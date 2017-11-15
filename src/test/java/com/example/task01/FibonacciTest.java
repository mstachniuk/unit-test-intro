package com.example.task01;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
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

    @Test
    @Parameters({"0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "10, 55"})
    public void shouldTestFibonacci(int n, int expected) {
        Fibonacci fibonacci = new Fibonacci();
        double result = fibonacci.fibonacci(n);
        assertEquals(expected, result, 0.0000001);
    }

}