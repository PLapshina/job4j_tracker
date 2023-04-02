package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultSum = sum(10);
        System.out.println("x + y = " + resultSum);
        int resultMinus = minus(7);
        System.out.println("y - x = " + resultMinus);
        int resultMultiply = calculator.multiply(5);
        System.out.println("x * y = " + resultMultiply);
        int resultDivide = calculator.divide(15);
        System.out.println("y / x = " + resultDivide);
        int resultSumAllOperation = calculator.sumAllOperation(10);
        System.out.println("Сумма всех операций = " + resultSumAllOperation);
    }
}
