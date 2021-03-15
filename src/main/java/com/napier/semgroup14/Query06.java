package com.napier.semgroup14;

import java.sql.*;
import java.util.ArrayList;

public class Query06 {

    public Query06() {
    }


    public void getAndDisplayList(String regionCode, Connection con) {

        // class returning list of objects (records extracted from SQL query)
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect = String.format("SELECT country.name AS name, country.Population AS population FROM country"
                    + " WHERE country.Region = '%s'  ORDER BY country.Population DESC LIMIT 5", regionCode);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new list of countries if valid.
            // Check one is returned

            if (rset.isBeforeFirst()) {
                // list of objects extracted from query result (rset) each record as object inserted into object list
                ArrayList<Country> Countries = new ArrayList<Country>();
                while (rset.next()) {
                    Country country = new Country();
                    country.name = rset.getString("name");
                    country.population = rset.getInt("population");
                    Countries.add(country);
                }

                // display each country fields in  Countries objects list
                for (Country nthCountry : Countries) {
                    System.out.println(
                            nthCountry.name + "  population:  "
                                    + nthCountry.population );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }
}
