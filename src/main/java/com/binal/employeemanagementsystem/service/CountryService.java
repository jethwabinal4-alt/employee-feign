package com.binal.employeemanagementsystem.service;

import com.binal.employeemanagementsystem.dto.CountryDto;
import com.binal.employeemanagementsystem.entity.Country;
import com.binal.employeemanagementsystem.feignClient.EmpFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryService {

    private final EmpFeignClient empFeignClient;

    public List<CountryDto> addingCountry(List<CountryDto> countryDtoList){
        return empFeignClient.addingCountry(countryDtoList);
    }

    public CountryDto addCountry(CountryDto countryDto){
        return empFeignClient.addCountry(countryDto);
    }

    public List<CountryDto> getCountry(){
        return empFeignClient.getCountry();
    }

    public Country getCountryById(int id){
        return empFeignClient.getCountryById(id);
    }

    public CountryDto updateCountryById(int id,CountryDto countryDto){
        return empFeignClient.updateCountryById(id, countryDto);
    }

    public void deleteById(int id){
        empFeignClient.deleteById(id);
    }

    public void deleteCountry(){
        empFeignClient.deleteCountry();
    }
}
