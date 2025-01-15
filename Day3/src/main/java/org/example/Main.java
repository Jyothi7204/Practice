package org.example;

import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Optional<String> op = Optional.of("Hello");
        System.out.println(op);
        Optional<String> op1 = Optional.ofNullable(null);
        System.out.println(op1);
        Optional<String> op3 = Optional.ofNullable("hello from op3");
        System.out.println(op3);
        Optional<String> op2 = Optional.empty();
        System.out.println(op2);
        op3.ifPresent(s -> System.out.println(s.toUpperCase()));
        Optional<String> op4=op3.map(String::toUpperCase);
        System.out.println(op4.get());//do not use
        System.out.println(op1.orElse("Not found"));//eager
        System.out.println(op1.orElseGet(()->op3.get()));//lazy
        Optional<String> name = Optional.of("John Doe");
        String upname=name.map(String::toUpperCase).filter(s->s.startsWith("JOHN")).orElse("Nope");
        System.out.println(upname);
        // System.out.println(op1.orElseThrow(()->new RuntimeException("Exception")));
        op3.map(String::toUpperCase).get();
        // op3.flatMap(s->s.startsWith("h"));

        }
    }
