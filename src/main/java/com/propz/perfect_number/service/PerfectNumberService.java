package com.propz.perfect_number.service;

import com.propz.perfect_number.exception.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class PerfectNumberService {

    public long findPerfectNumber(Integer minNumber, Integer maxNumber){
        if(minNumber == null)
            throw new BadRequestException("Número inválido");

        for (int i = minNumber; ; i++) {
            if (maxNumber != null && i > maxNumber)
                return 0;

            if (isPerfect(i))
                return i;
        }
    };

    public boolean isPerfect(int number){
        if(number <= 1)
            return false;

        int divisorSum = 1;
        for(int i = 2; i < number; i++){
            if(number % i != 0)
                continue;

            divisorSum += i;
        }

        return divisorSum == number;
    }
}
