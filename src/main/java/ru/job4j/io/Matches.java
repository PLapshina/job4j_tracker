package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3");
            int matches = Integer.parseInt(input.nextLine());
            if (matches >= 1 && matches <= 3 && matches <= count) {
                count -= matches;
                System.out.println("Остаток спичек:" + count);
                if (count != 0) {
                    turn = !turn;
                } else {
                    System.out.println(player + " победил!");
                }
            } else {
                System.out.println("Необходимо ввести число от 1 до 3 (включительно) и не более остатка. Введите число повторно");
            }
        }
    }
}
