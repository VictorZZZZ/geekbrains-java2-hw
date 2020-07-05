package ru.gb.collections.phoneBook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Person("Иванов","789456321","email1@gb.ru"));
        phoneBook.add(new Person("Иванов","789426321","email2@gb.ru"));
        phoneBook.add(new Person("Петров","189456321","email3@gb.ru"));
        phoneBook.add(new Person("Сидоров","289456321","email4@gb.ru"));
        phoneBook.add(new Person("Петров","389456321","email5@gb.ru"));
        phoneBook.add(new Person("Степанов","489456321","email6@gb.ru"));
        phoneBook.add(new Person("Иванов","589456321","email7@gb.ru"));
        System.out.println("Enter the surname:");
        Scanner scanner = new Scanner(System.in);
        phoneBook.showPhonesBySurname(scanner.nextLine());
        phoneBook.showEmailsBySurname(scanner.nextLine());
    }
}
