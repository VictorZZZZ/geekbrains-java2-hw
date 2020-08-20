package ru.gb.testing;

import ru.gb.examples.TestExample;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class TestingTool {
    private static final Integer OUT_OF_RANGE_VAL = 11;


    public static void main(String[] args) {
        try {
            start(TestExample.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        //start("E:\\Learn\\Java\\geekbrains\\Homeworks-java2\\Java-3\\Lesson7-Reflection\\target\\classes\\ru\\gb\\examples\\TestExample1");
    }

    public static void start(String clazzPath){
        try {
            File f = new File(clazzPath);
            ClassLoader loader = new URLClassLoader(new URL[]{new File(f.getParent()).toURL()});
            Class clazz = loader.loadClass(f.getName());
            start(clazz);
        } catch (MalformedURLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class clazz) throws IllegalAccessException, InstantiationException {
        boolean isAnnotationPresent = false;
        for(Method method:clazz.getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                isAnnotationPresent=true;
                break;
            }
        }
        if(!isAnnotationPresent){
            throw new RuntimeException("Annotation @Test is not present in this class");
        }

        Object instance = clazz.newInstance();
        Method doFirstMethod = null;
        Method doLastMethod = null;
        HashMap<Integer,ArrayList<Method> > priorityMap= new HashMap<>();
        for(Method method:clazz.getMethods()){
            if(method.isAnnotationPresent(BeforeSuite.class)){
                if(doFirstMethod==null){
                    doFirstMethod = method;
                } else {
                    throw new RuntimeException("BeforeSuite should be just one. Class has more");
                }
            }
            if(method.isAnnotationPresent(Test.class)){
                if(method.getAnnotation(Test.class).priority()==0){
                    ArrayList<Method> arrayList = priorityMap.get(OUT_OF_RANGE_VAL);
                    if(arrayList==null){
                        arrayList = new ArrayList<>();
                        arrayList.add(method);
                        priorityMap.put(OUT_OF_RANGE_VAL,arrayList);
                    } else{
                        arrayList.add(method);
                    }
                } else {
                    Integer priority = method.getAnnotation(Test.class).priority();
                    ArrayList<Method> arrayList = priorityMap.get(priority);
                    if(arrayList==null){
                        arrayList = new ArrayList<>();
                        arrayList.add(method);
                        priorityMap.put(priority,arrayList);
                    } else{
                        arrayList.add(method);
                    }
                }

            }
            if(method.isAnnotationPresent(AfterSuite.class)){
                if(doLastMethod==null){
                    doLastMethod = method;
                } else {
                    throw new RuntimeException("AfterSuite should be just one. Class has more");
                }
            }
        }
        if(doFirstMethod!=null){
            invokeMethod(instance, doFirstMethod);
        }

        for(Map.Entry<Integer,ArrayList<Method>> entry:priorityMap.entrySet()){
            for(Method method:entry.getValue()) {
                invokeMethod(instance,method);
            }
        }

        if(doLastMethod!=null){
            invokeMethod(instance, doLastMethod);
        }

    }

    private static void invokeMethod(Object instance, Method doFirstMethod) {
        try {
            doFirstMethod.invoke(instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
