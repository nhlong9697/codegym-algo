package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CommonDivisibleService {
    public int commonDivisble(int a, int b) {
        while (a != b) {
            if (a < b)
                b = b - a;
            if (a > b)
                a = a - b;
        }
        return a;
    }
}
