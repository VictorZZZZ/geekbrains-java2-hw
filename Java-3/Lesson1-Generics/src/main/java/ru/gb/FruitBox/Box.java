package ru.gb.FruitBox;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<T>();

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public float getWeight(){
        if(fruits.size()>0) {
            return fruits.size() * fruits.get(0).getWeight();
        } else{
            return 0f;
        }
    }

    public <S extends Fruit> boolean compare(Box<S> anotherBox){
        return this.getWeight()==anotherBox.getWeight();
    }

    public void moveFromOtherBox(Box<T> anotherBox){
        fruits.addAll(anotherBox.fruits);
        anotherBox.clear();
    }

    public void clear(){
        fruits.clear();
    }
}
