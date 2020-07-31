package ru.gb.collections.wordsCounter;

import java.util.HashMap;

public class WordsCounter {
    public static void main(String[] args) {
        String str = "Lorem ipsum dolor dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum In culpa qui officia deserunt mollit anim id est laborum";
        String[] strArr = str.split(" ");
        //System.out.println(Arrays.toString(strArr));
        HashMap<String,Integer> result = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            if(!result.containsKey(strArr[i])){
                result.put(strArr[i],1);
            } else {
                result.put(strArr[i],result.get(strArr[i])+1);
            }
        }
        System.out.println(result.toString());
    }
}
