package com.napier.semgroup14;
//import jdk.internal.math.FloatingDecimal;

import java.math.BigDecimal;

/**
 * Represents a country
 */
public class CountryLanguage {

    public String CountryCode;
    public String Language;
    public int IsOfficial;

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public int getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(int isOfficial) {
        IsOfficial = isOfficial;
    }

    public BigDecimal getPercentage() {
        return Percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        Percentage = percentage;
    }

    public BigDecimal Percentage;




}