package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String lyrics = "Песня не найдена";
        if (position == 1) {
            lyrics = "Пусть бегут неуклюже";
        } else if (position == 2) {
            lyrics = "Спокойной ночи";
        }
        System.out.println(lyrics);
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(2);
        jukebox.music(5);
    }
}
