package com.atm.api.dao;

import com.atm.api.entity.AtmLocationResponse;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.List;

@ComponentScan
public interface AtmSearchDao {

    List<AtmLocationResponse> getINGBankAtmInfo() throws IOException;
}
