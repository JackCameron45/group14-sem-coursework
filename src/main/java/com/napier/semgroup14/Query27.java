package com.napier.semgroup14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Query27 {

    public Query27() {
    }


    public void Query27GetAndDisplayList(String  continent, Connection con) {

        // class returning list of objects (records extracted from SQL query)
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect = String.format("SELECT SUM(country.Population) AS population FROM country WHERE country.Continent = '%s';", continent);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
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
            System.out.println("Failed to get employee details");
        }
    }
}
