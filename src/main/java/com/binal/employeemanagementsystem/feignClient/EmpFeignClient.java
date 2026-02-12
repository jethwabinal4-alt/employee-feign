package com.binal.employeemanagementsystem.feignClient;

import com.binal.employeemanagementsystem.dto.CountryDto;
import com.binal.employeemanagementsystem.entity.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "country-service", url = "http://localhost:8083/country-api")
public interface EmpFeignClient {

    @PostMapping("/adding-country")
    List<CountryDto> addingCountry(List<CountryDto> countryDtoList);

    @PostMapping("/add-country")
    CountryDto addCountry(CountryDto countryDto);

    @GetMapping("/get-country")
    List<CountryDto> getCountry();

    @GetMapping("/get-byId/{id}")
    Country getCountryById(@PathVariable int id);

    @PutMapping("/update-byId/{id}")
    CountryDto updateCountryById(@PathVariable int id, @RequestBody CountryDto countryDto);

    @DeleteMapping("/delete-byId/{id}")
    Void deleteById(@PathVariable int id);

    @DeleteMapping("/delete-country")
    Void deleteCountry();
}
