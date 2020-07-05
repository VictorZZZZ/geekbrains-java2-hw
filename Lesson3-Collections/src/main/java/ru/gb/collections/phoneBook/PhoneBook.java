package ru.gb.collections.phoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class PhoneBook {
    HashMap<String, HashSet<Person>> book = new HashMap<>();
    public void add(Person person){
        if (!book.containsKey(person.getSurname())) {
            HashSet<Person> hashSet = new HashSet<>();
            hashSet.add(person);
            book.put(person.getSurname(),hashSet);
        } else {
            HashSet<Person> hashSet = book.get(person.getSurname());
            hashSet.add(person);
        }
    }

    public void showPhonesBySurname(String surname){
        ArrayList<String> phonesList = getPhones(surname);
        System.out.println(surname + " ");
        for (String phone:phonesList) {
            System.out.println("   " + phone);
        }
    }

    public void showEmailsBySurname(String surname){
        ArrayList<String> emailsList = getPhones(surname);
        System.out.println(surname + " ");
        for (String email:emailsList) {
            System.out.println("   " + email);
        }
    }

    private ArrayList<String> getPhones(String surname){
        HashSet<Person> surnameHashSet = book.get(surname);
        Iterator<Person> iterator = surnameHashSet.iterator();
        ArrayList<String> result = new ArrayList<>();
        while(iterator.hasNext()){
            result.add(iterator.next().getPhone());
        }
        return result;
    }

    private ArrayList<String> getEmails(String surname){
        HashSet<Person> surnameHashSet = book.get(surname);
        Iterator<Person> iterator = surnameHashSet.iterator();
        ArrayList<String> result = new ArrayList<>();
        while(iterator.hasNext()){
            result.add(iterator.next().getEmail());
        }
        return result;
    }

    @Override
    public String toString() {
        ArrayList<String> result = new ArrayList<>();
        for (String surname : book.keySet()) {
            HashSet<Person> hashSet = book.get(surname);
            Iterator<Person> iteratorPerson = hashSet.iterator();
            result.add(surname+":\n");
            while(iteratorPerson.hasNext()) {
                Person p = iteratorPerson.next();
                result.add("    " + p.getPhone()+" " + p.getEmail() + "\n");
            }

        }
        return result.toString();
    }
}
