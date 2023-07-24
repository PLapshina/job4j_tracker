package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double scoreSum = 0;
        double count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreSum += subject.score();
                count++;
            }
        }
        return scoreSum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            rsl.add(new Label(pupil.name(), averageScore(List.of(pupil))));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int scoreSum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreSum = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), scoreSum + subject.score());
            }
        }
        for (String name : map.keySet()) {
            rsl.add(new Label(name, (double) map.get(name) / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double scoreSum = 0;
            for (Subject subject : pupil.subjects()) {
                scoreSum += subject.score();
                rsl.add(new Label(pupil.name(), scoreSum));
            }
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int scoreSum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreSum = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), scoreSum + subject.score());
            }
        }
        for (String name : map.keySet()) {
            rsl.add(new Label(name, (double) map.get(name)));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}
