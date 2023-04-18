package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("335");
        student.setDateOfAdmission(new Date());
        System.out.println("Студент: " + student.getFullName() + System.lineSeparator()
                + "Группа: " + student.getGroup() + System.lineSeparator()
                + "Дата поступления: " + student.getDateOfAdmission());
    }
}
