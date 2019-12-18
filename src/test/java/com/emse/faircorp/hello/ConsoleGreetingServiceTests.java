package com.emse.faircorp.hello;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ExtendWith(OutputCaptureExtension.class)

public class ConsoleGreetingServiceTests {

    @Test
    public void testGreeting(CapturedOutput output) {
        ConsoleGreetingService greetingService = new ConsoleGreetingService(); // 1
        greetingService.greet("Spring");
        Assertions.assertThat(output.getAll()).contains("Hello, Spring!");
    }
}