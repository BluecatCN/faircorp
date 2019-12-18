package com.emse.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DummyUserService implements UserService {

    private final GreetingService greetingService;

    @Autowired
    public DummyUserService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void greetAll() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Elodie");
        names.add("Charles");
        for (String name : names) {
            greetingService.greet(name);
        }
    }
}
