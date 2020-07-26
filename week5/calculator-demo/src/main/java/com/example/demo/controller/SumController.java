package com.example.demo.controller;

import com.example.demo.CommonDivisible;
import com.example.demo.Sum;
import com.example.demo.service.CommonDivisibleService;
import com.example.demo.service.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SumController {
    @Autowired
    private SumService sumService;
    @Autowired
    private CommonDivisibleService commonDivisibleService;

    @GetMapping("/sum")
    public ResponseEntity<Integer> sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        int sum = sumService.sum(a,b);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    @GetMapping("/divisible")
    public ResponseEntity<Integer> commonDivisble(@RequestParam("a") int a,
                                                  @RequestParam("b") int b) {
        int commonDivisible = commonDivisibleService.commonDivisble(a,b);
        return new ResponseEntity<>(commonDivisible, HttpStatus.OK);
    }

    @PostMapping("/sum/{a}/{b}")
    public ResponseEntity<Integer> sumPost(@PathVariable int a, @PathVariable int b) {
        int sum = sumService.sum(a,b);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }
    @GetMapping("/divisible/{a}/{b}")
    public ResponseEntity<Integer> commonDivisible(@PathVariable int a, @PathVariable int b) {
        int commonDivisible = commonDivisibleService.commonDivisble(a,b);
        return new ResponseEntity<>(commonDivisible,HttpStatus.OK);
    }

    @PostMapping("/sum")
    public ResponseEntity<Integer> sumPut(@RequestBody Sum sumObj) {
        int sum = sumService.sum(sumObj.getA(), sumObj.getB());
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }
    @PostMapping("/divisible")
    public ResponseEntity<Integer> divisible(@RequestBody CommonDivisible commonDivisibleObj) {
        int commonDivisible = commonDivisibleService.commonDivisble(commonDivisibleObj.getA(),
                commonDivisibleObj.getB());
        return new ResponseEntity<>(commonDivisible, HttpStatus.OK);
    }

    @PostMapping("/file")
    public ResponseEntity<String> getNameFile(@ModelAttribute MultipartFile file) {
        return new ResponseEntity<>(file.getName(), HttpStatus.OK);
    }
}
