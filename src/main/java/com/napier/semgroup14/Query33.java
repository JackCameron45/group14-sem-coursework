package com.napier.semgroup14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Query33 {

    public Query33() {
    }


    public void getAndDisplayList(Connection con) {

        // class returning list of objects (records extracted from SQL query)
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect = String.format(" SELECT countrylanguage.Language, SUM(country.Population) AS Population, "
                    + " FORMAT((SUM(country.Population)/(SELECT SUM(country.Population) AS World_Population "
                    + " FROM  country))*100,2)  AS Percentage_of_The_World_Population "
                    + " FROM country, countrylanguage"
                    + " WHERE  country.Code = countrylanguage.CountryCode "
                    + " AND countrylanguage.Language "
                    + " IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') "
                    + " GROUP BY countrylanguage.Language "
                    + " ORDER BY Population DESC;");

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new query result if valid.
            // Check one is returned

            if (rset.isBeforeFirst()) {
                // list of objects extracted from query result (rset) each record as object inserted into object list
                ArrayList<zCityCountryLanguage> ListofCityAndCountryThrees = new ArrayList<zCityCountryLanguage>();

                // each row of sql results set as objects fields and added to arrayList of country, country, countryLanguage
                while (rset.next()) {
                    City city = new City();
                    Country country = new Country();
                    CountryLanguage countryLanguage = new CountryLanguage();
                    countryLanguage.Language = rset.getString("countrylanguage.Language");
                    country.population = rset.getLong("Population");
                    country.lifeExpectancy = rset.getBigDecimal("Percentage_of_The_World_Population");
                    zCityCountryLanguage three = new zCityCountryLanguage(city, country, countryLanguage);
                    ListofCityAndCountryThrees.add(three);
                }

                // display each country fields in  Countries objects list
                for (zCityCountryLanguage eachThree : ListofCityAndCountryThrees) {
                    System.out.println(eachThree.getCountryLanguage().Language + "  "
                            + eachThree.getCountry().population + "  "
                            + eachThree.getCountry().lifeExpectancy );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }
}
