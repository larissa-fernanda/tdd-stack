package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number> {

    private CustomStack<T> stack;

    public NumberAscOrder(CustomStack<T> stack) {
        this.stack = stack;
    }

    public List<T> sort() throws StackEmptyException {
        List<T> sortedList = new ArrayList<>();

        int stackSize = stack.size();

        for (int i = 0; i < stackSize; i++) {
            T number = stack.pop();
            sortedList.add(number);
        }

        if (sortedList.isEmpty()) {
            return sortedList;
        }

        Collections.sort(sortedList, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));

        return sortedList;
    }
}

