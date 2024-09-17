package de.cloudypanda.stream;

import java.util.List;

public class IntegerStreamService extends AbstractStreamService<List<Integer>> {
    public IntegerStreamService(List<Integer> elements) {
        super(elements);
    }

    /**
     * Filters out all even numbers from the elements
     * @return a list of odd numbers
     */
    public List<Integer> filterEvenElements() {
        //TODO Implementieren
        return null;
    }

    /**
     * Filters out all odd numbers from the elements
     * @return a list of even numbers
     */
    public List<Integer> filterOddElements() {
        //TODO Implementieren
        return null;
    }
}
