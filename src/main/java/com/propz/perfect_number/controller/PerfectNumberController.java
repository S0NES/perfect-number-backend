package com.propz.perfect_number.controller;

import com.propz.perfect_number.service.PerfectNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PerfectNumberController {

    @Autowired
    private PerfectNumberService perfectNumberService;
    @GetMapping("/between")
    public Long getListPage(@RequestParam Integer minNumber, @RequestParam Integer maxNumber) throws ParseException {
        return perfectNumberService.findPerfectNumber(minNumber, maxNumber);
    }
    @GetMapping("/verify")
    public Boolean verifyPerfect(@RequestParam int number) throws ParseException {
        return perfectNumberService.isPerfect(number);
    }
}
