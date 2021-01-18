package com.atm.api.service;

import com.atm.api.dao.AtmSearchDao;
import com.atm.api.entity.AtmLocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtmSearchService {

    @Autowired
    private AtmSearchDao atmSearchDao;

    public List<AtmLocationResponse> getINGBankAtmInfo(String city) throws Exception
    {
        return atmSearchDao.getINGBankAtmInfo().stream().
                filter(e -> e.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }

}
