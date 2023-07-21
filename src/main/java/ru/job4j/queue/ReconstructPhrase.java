package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElement;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElement) {
        this.descendingElements = descendingElements;
        this.evenElement = evenElement;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        int size = evenElement.size() / 2;
        for (int i = 0; i < size; i++) {
            str.append(evenElement.pollFirst());
            evenElement.pollFirst();
        }
        return str.toString();
    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            str.append(descendingElements.pollLast());
        }
        return str.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
