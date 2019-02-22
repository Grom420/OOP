package controller;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParsePolishNotationsTest {

    @Test
    public void parse() {

        List<String> postfix = new ArrayList<>();
        postfix.add("5");
        postfix.add("4");
        postfix.add("3");
        postfix.add("*");
        postfix.add("+");
        assertEquals(postfix, ParsePolishNotations.parse("5+4*3"));
    }
}