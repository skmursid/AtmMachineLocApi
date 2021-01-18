package com.atm.api.service;

import com.atm.api.dao.AtmSearchDao;
import com.atm.api.entity.Address;
import com.atm.api.entity.AtmLocationResponse;
import com.atm.api.entity.OpeningHours;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AtmSearchServiceTest {

    private List<AtmLocationResponse> atmLocationResponses;

    @InjectMocks
    private AtmSearchService atmSearchService;

    @Mock
    private AtmSearchDao atmSearchDao;

    @Test
    public void getINGBankAtmInfoByCity() throws Exception
    {
        Mockito.when(atmSearchDao.getINGBankAtmInfo()).thenReturn(atmLocationResponses());
        List<AtmLocationResponse> actualResponse = atmSearchService.getINGBankAtmInfo("New York");
        assertEquals(2, actualResponse.size());
    }

    private List<AtmLocationResponse> atmLocationResponses() {
        List<AtmLocationResponse> atmLocationResponses = new ArrayList<>();
        AtmLocationResponse atmLocationResponse = new AtmLocationResponse();
        Address address = new Address();
        address.setCity("New York");
        address.setHousenumber("4-56");
        atmLocationResponse.setAddress(address);
        atmLocationResponse.setDistance(20);
        atmLocationResponse.setOpeningHours(new ArrayList<OpeningHours>());
        atmLocationResponse.setType("Test2");
        atmLocationResponse.setFunctionality("Test4567");
        AtmLocationResponse atmLocationResponse2 = new AtmLocationResponse();
        Address address2 = new Address();
        address2.setCity("New York");
        address2.setHousenumber("4-562");
        atmLocationResponse2.setAddress(address2);
        atmLocationResponse2.setDistance(20);
        atmLocationResponse2.setOpeningHours(new ArrayList<OpeningHours>());
        atmLocationResponse2.setType("Test");
        atmLocationResponse2.setFunctionality("Test456");
        atmLocationResponses.add(atmLocationResponse);
        atmLocationResponses.add(atmLocationResponse2);
        return atmLocationResponses;
    }

}
