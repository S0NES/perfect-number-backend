package com.propz.perfect_number.service;

import com.propz.perfect_number.exception.BadRequestException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PerfectNumberServiceTest {

    private final PerfectNumberService perfectNumber = new PerfectNumberService();

    @Test
    public void shouldThrowBadRequest(){
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            perfectNumber.findPerfectNumber(null, null);
        });
        assertEquals("Número inválido", exception.getMessage());
    }

    @Test
    public void shouldReturnPrimeNumber(){
        long i1 = perfectNumber.findPerfectNumber(2, 7);
        long i2 = perfectNumber.findPerfectNumber(8, 36);
        long i3 = perfectNumber.findPerfectNumber(30, 600);
        long i4 = perfectNumber.findPerfectNumber(500, 10000);

        assertEquals(6, i1);
        assertEquals(28, i2);
        assertEquals(496, i3);
        assertEquals(8128, i4);
    }

    @Test
    public void shouldThrowNotFound(){
        long i = perfectNumber.findPerfectNumber(500, 1000);

        assertEquals(0, i);
    }
}
