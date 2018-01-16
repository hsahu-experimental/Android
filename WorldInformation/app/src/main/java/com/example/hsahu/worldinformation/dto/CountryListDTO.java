package com.example.hsahu.worldinformation.dto;

import java.util.List;

public class CountryListDTO {

    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public CountryListDTO(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "CountryListDTO{" +
                "countries=" + countries +
                '}';
    }
}
