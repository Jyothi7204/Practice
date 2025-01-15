package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BigDecimal bd=BigDecimal.valueOf(1234567890.32145);
        System.out.println(bd);
        BigDecimal bd1=bd.setScale(4, RoundingMode.HALF_DOWN);
        System.out.println(bd1);
        //methods
        BigDecimal a=new BigDecimal(123456);
        System.out.println("addition "+a.add(new BigDecimal(345678)));
        System.out.println("substraction "+a.subtract(new BigDecimal(345678)));
        System.out.println("multiplication "+a.multiply(new BigDecimal(345678)));
        System.out.println("division "+a.divide(new BigDecimal(345678),2,RoundingMode.HALF_UP));
        System.out.println("Comparing "+bd.compareTo(bd1));

        }
    }
