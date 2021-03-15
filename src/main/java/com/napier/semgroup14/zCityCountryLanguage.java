package com.napier.semgroup14;

public class zCityCountryLanguage {
    private City city;
    private Country country;
    private CountryLanguage countryLanguage;

    public zCityCountryLanguage(City city, Country country, CountryLanguage countryLanguage ) {
        this.country = country;
        this.city = city;
        this.countryLanguage = countryLanguage;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CountryLanguage getCountryLanguage() {
        return countryLanguage;
    }

    public void setCountryLanguage(CountryLanguage countryLanguage) {
        this.countryLanguage = countryLanguage;
    }
}
