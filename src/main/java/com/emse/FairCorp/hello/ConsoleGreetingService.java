package com.emse.FairCorp.hello;

public class ConsoleGreetingService implements GreetingService{
    @Override
    public void greet(String name) {
        System.out.println(name);;
    }
}
