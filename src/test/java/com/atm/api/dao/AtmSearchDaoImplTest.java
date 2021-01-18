package com.atm.api.dao;

import com.atm.api.entity.Address;
import com.atm.api.entity.AtmLocationResponse;
import com.atm.api.entity.OpeningHours;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AtmSearchDaoImplTest {

    @InjectMocks
    private AtmSearchDaoImpl empService;

    @Mock
    private AtmSearchDao atmSearchDao;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void getINGBankAtmInfo() throws IOException{
        when(restTemplate.getForObject("http://localhost:8080/testVal/city", AtmLocationResponse[].class))
                .thenReturn(new AtmLocationResponse[2]);
    }

}
