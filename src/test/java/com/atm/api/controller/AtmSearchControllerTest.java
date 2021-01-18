package com.atm.api.controller;

import com.atm.api.entity.AtmLocationResponse;
import com.atm.api.service.AtmSearchService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AtmSearchControllerTest {

    @InjectMocks
    private AtmSearchController atmSearchController;

    @Mock
    private AtmSearchService atmSearchService;

    @Test
    public void getINGBankAtmInfoByCity() throws Exception
    {
        List<AtmLocationResponse> actualResponse = atmSearchService.getINGBankAtmInfo("Manhattan");
        assertEquals(new ArrayList<AtmLocationResponse>().size(), actualResponse.size());

    }

}
