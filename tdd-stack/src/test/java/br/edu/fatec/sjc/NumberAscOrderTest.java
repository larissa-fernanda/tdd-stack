package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NumberAscOrderTest {

    @Test
    public void testSortWithNumbers() throws StackFullException, StackEmptyException {
        @SuppressWarnings("unchecked")
        CustomStack<Number> mockStack = (CustomStack<Number>) mock(CustomStack.class);

        when(mockStack.isEmpty())
            .thenReturn(false).thenReturn(true);
        when(mockStack.size())
            .thenReturn(6);
        when(mockStack.pop())
            .thenReturn(16)
            .thenReturn(4)
            .thenReturn(8)
            .thenReturn(23)
            .thenReturn(15)
            .thenReturn(42);

        NumberAscOrder<Number> numberAscOrder = new NumberAscOrder<>(mockStack);
        List<Number> sortedNumbers = numberAscOrder.sort();

        List<Number> expected = new ArrayList<>();
        Collections.addAll(expected, 4, 8, 15, 16, 23, 42);
        Collections.sort(expected, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
        assertEquals(expected, sortedNumbers);
    }

    @Test
    public void testSortWithEmptyStack() throws StackEmptyException {
        @SuppressWarnings("unchecked")
        CustomStack<Number> mockStack = mock(CustomStack.class);

        when(mockStack.isEmpty()).thenReturn(true);
        when(mockStack.size()).thenReturn(-1);

        NumberAscOrder<Number> numberAscOrder = new NumberAscOrder<>(mockStack);
        List<Number> sortedNumbers = numberAscOrder.sort();

        List<Number> expected = new ArrayList<>();
        Collections.sort(expected, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));

        assertEquals(expected, sortedNumbers);
    }
}
