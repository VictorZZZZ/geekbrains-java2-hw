package ru.gb.FruitBox;

public class FruitBoxFactory {
    public static void main(String[] args) {
        Box<Apple> boxA = new Box<>();
        boxA.addFruit(new Apple());
        boxA.addFruit(new Apple());
        boxA.addFruit(new Apple());
        boxA.addFruit(new Apple());
        boxA.addFruit(new Apple());
        boxA.addFruit(new Apple());

        System.out.println("Weight of Box Apple="+boxA.getWeight());

        Box<Orange> boxO = new Box<>();
        boxO.addFruit(new Orange());
        boxO.addFruit(new Orange());
        boxO.addFruit(new Orange());
        boxO.addFruit(new Orange());
        System.out.println("Weight of Box Orange="+boxO.getWeight());

        System.out.println("Compare Box weights: "+boxA.compare(boxO));


        Box<Apple> boxA1 = new Box<>();
        boxA1.addFruit(new Apple());
        boxA1.addFruit(new Apple());


        System.out.println("Weight of BoxA1 Apple="+boxA1.getWeight());
        System.out.println("Moving Apples from A1 to A...");
        boxA.moveFromOtherBox(boxA1);
        System.out.println("Weight of BoxA Apple="+boxA.getWeight());
        System.out.println("Weight of BoxA1 Apple="+boxA1.getWeight());

    }
}
