package com.example.digitsum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DigitSumApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitSumApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/digitsum")
class DigitSumController {
    private int usageCount = 0;

    @GetMapping("/usage")
    public int getUsageCount() {
        return usageCount;
    }

    @GetMapping
    public int calculateDigitSum(@RequestParam("number") int number) {
        usageCount++;
        int sum = 0;
        int temp = number;

        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            temp /= 10;
        }

        return sum;
    }
}

