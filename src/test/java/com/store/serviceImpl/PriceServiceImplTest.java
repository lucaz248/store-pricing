package com.store.serviceImpl;

import com.store.dto.PriceDto;
import com.store.exception.InvalidInputDataException;
import com.store.exception.PriceNotFoundException;
import com.store.service.PriceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PriceServiceImplTest {

    @Autowired
    private PriceService priceService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findPricePvp() throws InvalidInputDataException, PriceNotFoundException {
        String priceDate = "2020-06-14-10.00";
        Long productId = 35455L;
        Long brandId = 1L;
        PriceDto pricePvp = priceService.findPricePvp(priceDate, productId, brandId);
        assertEquals(pricePvp.getPrice(), new BigDecimal("35.50"));
    }
}
