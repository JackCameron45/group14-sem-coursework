package com.napier.semgroup14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Query32 {

    public Query32() {
    }


    public void getAndDisplayList(String cityParameter, Connection con) {

        // class returning list of objects (records extracted from SQL query)
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect = String.format(" SELECT city.Name, country.Name, city.Population FROM country, city "
                    + "WHERE city.ID = country.Capital AND city.Name =  '%s';", cityParameter);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new query result if valid.
            // Check one is returned

            if (rset.isBeforeFirst()) {
                // list of objects extracted from query result (rset) each record as object inserted into object list

                ArrayList<zCityAndCountryPair> ListofCityAndCountryPairs = new ArrayList<zCityAndCountryPair>();
                Country country = new Country();
                City city = new City();
                zCityAndCountryPair pair = new zCityAndCountryPair(city, country);
                while (rset.next()) {
                    city.Name = rset.getString("city.Name");
                    country.name = rset.getString("country.Name");
                    city.Population = rset.getInt("city.population");
                    ListofCityAndCountryPairs.add(pair);
                }

                // display each country fields in  Countries objects list
              for (zCityAndCountryPair pairs : ListofCityAndCountryPairs) {
                  System.out.println(pairs.getCity().Name + " the capital of " + pairs.getCountry().name + " population: " + pairs.getCity().Population );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }
}
