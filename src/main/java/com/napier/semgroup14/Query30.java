package com.napier.semgroup14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Query30 {

    public Query30() {
    }


    public void getAndDisplayList(String  district, Connection con) {

        // class returning list of objects (records extracted from SQL query)
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect = String.format(" SELECT city.District, SUM(city.Population) AS Population  FROM city WHERE city.District = '%s';", district);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new query results if valid.
            // Check one is returned

            if (rset.isBeforeFirst()) {
                // list of objects extracted from query result (rset) each record as object inserted into object list
                ArrayList<Country> Countries = new ArrayList<Country>();
                while (rset.next()) {
                    Country country = new Country();
                    country.population = rset.getLong("population");
                    Countries.add(country);
                }

                // display each country fields in  Countries objects list
                for (Country nthCountry : Countries) {
                    System.out.println(nthCountry.population );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }
}
