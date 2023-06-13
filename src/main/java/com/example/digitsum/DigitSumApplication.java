package com.example.digitsum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DigitSumApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitSumApplication.class, args);
    }
}

@RestController
class DigitSumController {
    private int usageCount = 0;

    @GetMapping(value = "/digit-sum/{number}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public Object calculateDigitSum(@PathVariable int number) {
        usageCount++;

        int sum = 0;
        int temp = number;

        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            temp /= 10;
        }

        return new DigitSumResponse(number, sum, usageCount);
    }
}

class DigitSumResponse {
    public int number;
    public int digitSum;
    public int usageCount;

    public DigitSumResponse(int number, int digitSum, int usageCount) {
        this.number = number;
        this.digitSum = digitSum;
        this.usageCount = usageCount;
    }
}
