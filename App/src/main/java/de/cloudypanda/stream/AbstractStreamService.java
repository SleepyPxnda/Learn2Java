package de.cloudypanda.stream;

public abstract class AbstractStreamService<T> {
    protected final T elements;

    public AbstractStreamService(T elements) {
        this.elements = elements;
    }
}
