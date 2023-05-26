package org.ryanha.generator;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class ArrayGenerator {
    private final int[] array;
    private final Set<Integer> elements;

    public ArrayGenerator(int size) {
        if(size < 1) {
            throw new IllegalArgumentException("Invalid array size");
        }
        this.array = new int[size];
        this.elements = new LinkedHashSet<>();
    }

    public void generate() {
        Random random = new Random();
        while(this.elements.size() < this.array.length) {
            elements.add(random.nextInt(this.array.length)+1);
        }
        int index = 0;
        for(int element : elements) {
            this.array[index++] = element;
        }
    }

    public int[] getClonedArray() {
        int[] array = new int[this.array.length];
        System.arraycopy(this.array, 0, array, 0, this.array.length);
        return array;
    }

    public int[] getArray() {
        return array;
    }
}
