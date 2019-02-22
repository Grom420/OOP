package controller;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculateTest {

    @Test
    public void operations() {

        List<String> postfix = new ArrayList<>();
        postfix.add("5");
        postfix.add("4");
        postfix.add("3");
        postfix.add("*");
        postfix.add("+");

        assertEquals(BigDecimal.valueOf(17.0), Calculate.operations(postfix));
    }
}