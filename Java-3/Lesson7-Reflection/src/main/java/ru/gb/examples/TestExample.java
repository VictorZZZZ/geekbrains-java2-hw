package ru.gb.examples;

import ru.gb.testing.AfterSuite;
import ru.gb.testing.BeforeSuite;
import ru.gb.testing.Test;
import ru.gb.testing.TestingTool;

public class TestExample {
    public static void main(String[] args) {
        System.out.println("just to compile");
    }

    public TestExample() {
    }

    @BeforeSuite
    public void beforeMethod(){
        System.out.println("Before Suite");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test(priority = 5)
    public void test2(){
        System.out.println("Test 2");
    }

    @Test
    public void test8(){
        System.out.println("Test 8");
    }
    @Test(priority = 3)
    public void test3(){
        System.out.println("Test 3");
    }

    @Test(priority = 3)
    public void test4(){
        System.out.println("Test 4");
    }

    @AfterSuite
    public void afterMethod(){
        System.out.println("After Suite");
    }
}
