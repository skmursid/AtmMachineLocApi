package com.atm.api.dao;

import com.atm.api.entity.AtmLocationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class AtmSearchDaoImpl implements AtmSearchDao{

    Logger logger = Logger.getLogger(AtmSearchDaoImpl.class.getName());
    private static final String ING_URL = "https://www.ing.nl/api/locator/atms/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<AtmLocationResponse> getINGBankAtmInfo() throws IOException {
        AtmLocationResponse[] ingAtmLocations = null;
        String response = restTemplate.getForObject(ING_URL, String.class);
        Optional<String> jsonResponse = Optional.ofNullable(response);
        if (jsonResponse.isPresent()) {
            ingAtmLocations = new ObjectMapper().readValue(response.substring(6, response.toString().length()), AtmLocationResponse[].class);
            logger.info("Atm location successfully retrieved");
        }
        return Arrays.asList(ingAtmLocations);
    }
}
