package com.napier.semgroup14;

public class zCityAndCountryPair {
    private Country country;
    private City city;

    public zCityAndCountryPair(City city, Country country ) {
        this.country = country;
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
