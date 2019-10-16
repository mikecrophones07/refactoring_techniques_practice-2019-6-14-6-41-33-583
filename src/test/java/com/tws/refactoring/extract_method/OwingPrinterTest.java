package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_return_owing_receipt() {
        OwingPrinter owing =  new OwingPrinter();
        List<Order> orderList = new ArrayList<>();

        String name = "Mike Echon";
        StringBuilder expectedResult = new StringBuilder();
        expectedResult
                .append("*****************************\n")
                .append("****** Customer totals ******\n")
                .append("*****************************\n")
                .append("name: Mike Echon \n")
                .append("amount: 60.0 \n");

        IntStream.rangeClosed(0, 5).forEach(value ->{
            Order order = new Order(10);
            orderList.add(order);
        });


        owing.printOwing(name, orderList);
        String actualResult = outContent.toString();
        assertEquals(expectedResult.toString(), actualResult);
    }
}