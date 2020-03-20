package edu.northeastern.ashish;

public class RefStore<T> {
    public T value;
    private RefStore(){}

    public RefStore(T value) {
        this.value = value;
    }
}
