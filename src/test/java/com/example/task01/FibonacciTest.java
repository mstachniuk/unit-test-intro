package com.example.task01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    public void shouldReturnZeroForZero() {
        // given
        Fibonacci fibonacci = new Fibonacci();

        // when
        int result = fibonacci.fibonacci(0);

        // then
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnOneForOne() {
        // given
        Fibonacci fibonacci = new Fibonacci();

        // when
        int result = fibonacci.fibonacci(1);

        // then
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnOneForTwo() {
        // given
        Fibonacci fibonacci = new Fibonacci();

        // when
        int result = fibonacci.fibonacci(2);

        // then
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnTwoForThree() {
        // given
        Fibonacci fibonacci = new Fibonacci();

        // when
        int result = fibonacci.fibonacci(3);

        // then
        assertEquals(2, result);
    }

    @Test
    public void shouldReturnEightForSix() {
        // given
        Fibonacci fibonacci = new Fibonacci();
        Class<? extends Fibonacci> aClass = fibonacci.getClass();
        Class<Fibonacci> fibonacciClass = Fibonacci.class;

        // when
        int result = fibonacci.fibonacci(6);

        // then
        assertEquals(8, result);
    }
}
