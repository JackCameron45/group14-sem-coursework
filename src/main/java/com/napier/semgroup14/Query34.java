package com.napier.semgroup14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Query34 {

    public Query34() {
    }


    public void getAndDisplayList(Connection con) {

        // class returning list of objects (records extracted from SQL query)
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect = String.format(" SELECT co.Continent, SUM((SELECT sum(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code )) AS Cities_Population,  "
                    + " SUM(co.Population) - SUM((SELECT sum(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code )) AS Rural_Population, "
                    + " FORMAT(SUM((SELECT sum(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code ))  "
                    + " / (SUM ( co.Population ) ) *100,2) AS Percentage_Living_in_Cities, "
                    + " FORMAT(100-(SUM((SELECT SUM(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code ))  "
                    + " / (SUM(co.Population) ))*100,2) AS Percentage_Living_in_Rural_Areas "
                    + " FROM country co  GROUP BY co.Continent  ORDER BY co.Continent ASC);");

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new query result if valid.
            // Check one is returned

            if (rset.isBeforeFirst()) {
                // list of objects extracted from query result (rset) each record as object inserted into object list
                ArrayList<zCityCountryLanguage> CityCountryLanguageThrees = new ArrayList<zCityCountryLanguage>();

                // each row of sql results set as objects fields and added to arrayList of country, country, countryLanguage
                while (rset.next()) {
                    City city = new City();
                    Country country = new Country();
                    CountryLanguage countryLanguage = new CountryLanguage();

                    country.continent = rset.getString("country.Continent");
                    city.Population = rset.getInt("Cities_Population");
                    city.ID = rset.getInt("Rural_Population");
                    country.gNP = rset.getBigDecimal("Percentage_Living_in_Cities");
                    country.gNPOld = rset.getBigDecimal("Percentage_Living_in_Rural_Areas");

                    zCityCountryLanguage three = new zCityCountryLanguage(city, country, countryLanguage);
                    CityCountryLanguageThrees.add(three);
                }

                // display each country fields in  Countries objects list
                System.out.println("Continent,    Cities_Population, Rural_Population ,  Percentage_Living_in_Cities, Percentage_Living_in_Rural_Areas");
                for (zCityCountryLanguage eachThree : CityCountryLanguageThrees) {
                    System.out.println(eachThree.getCountry().continent + "  "
                            + eachThree.getCity().Population + "  "
                            + eachThree.getCity().ID + "  "
                            + eachThree.getCountry().gNP + "  "
                            + eachThree.getCountry().gNPOld);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }
}
