package com.atm.api.controller;

import com.atm.api.entity.AtmLocationResponse;
import com.atm.api.service.AtmSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class AtmSearchController {
    Logger logger = Logger.getLogger(AtmSearchController.class.getName());

    @Autowired
    private AtmSearchService atmSearchService;

    @GetMapping(value = "/fetchAtmsInfo/{city}")
    public ResponseEntity<List<AtmLocationResponse>> getINGBankAtmInfo(@PathVariable("city") String city) throws Exception
    {
        ResponseEntity<List<AtmLocationResponse>> listResponseEntity = null;
        logger.info("The city is :" + city);
        try {
            listResponseEntity = new ResponseEntity<List<AtmLocationResponse>>(atmSearchService.getINGBankAtmInfo(city), HttpStatus.OK);
        }catch (Exception ex){
         logger.info("Exception caught is: " + ex);
        }
        return listResponseEntity;
    }

}
