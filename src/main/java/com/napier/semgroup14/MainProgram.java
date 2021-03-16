package com.napier.semgroup14;

import java.sql.*;
import java.util.ArrayList;

// Class to connect to the MSQL world database
public class MainProgram
{
    /**
     * Connection to MySQL world database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL world database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Connect to database
                System.out.println("Connecting to db:3306/world");
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "pass");
//                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world?useSSL=false", "root", "pass");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
                try {
                    // Wait a bit for db to start
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted? Should not happen.");
                }
            }
        }
    }

    /**
     * Disconnect from the MySQL world database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    //Use methods to connect to the database
    public static void main(String[] args)
    {
        // Create new Application
        MainProgram a = new MainProgram();

        // Connect to database
        a.connect();

        // Extract info for query #1
        System.out.println("Query 1, population of countries in world"+ "\n");
        ArrayList<Country> citiesq1 = a.query1GetList();
        // Run query #1
        query1Display(citiesq1);

        // Extract info for query #2
        System.out.println("Query 2, population of countries in Asia"+ "\n");
        ArrayList<Country> citiesq2 = a.query2GetList();
        // Run query #2
        query2Display(citiesq2);

        // Extract info for query #3
        System.out.println("Query 3, population of countries in Caribbean"+ "\n");
        ArrayList<Country> citiesq3 = a.query3GetList();
        // Run query #3
        query3Display(citiesq3);

        // Extract info for query #4
        System.out.println("Query 4, top N populated Countries"+ "\n");
        ArrayList<Country> citiesq4 = a.query4GetList();
        // Run query #4
        query4Display(citiesq4);

        // Extract info for query #5
        System.out.println("Query 5, top N populated Countries in Europe"+ "\n");
        ArrayList<Country> citiesq5 = a.query5GetList();
        // Run query #5
        query5Display(citiesq5);

        // Extract info for query #6
        System.out.println("Query 6, top N populated Countries in the Caribbean"+ "\n");
        ArrayList<Country> citiesq6 = a.query6GetList();
        // Run query #6
        query6Display(citiesq6);

        // Extract info for query #7
        System.out.println("Query 7, population of cities in world"+ "\n");
        ArrayList<City> citiesq7 = a.query7GetList();
        // Run query #7
        query7Display(citiesq7);

        // Extract info for query #8
        System.out.println("Query 8, population of cities in continent Europe"+ "\n");
        ArrayList<City> citiesq8 = a.query8GetList();
        // Run query #8
        query8Display(citiesq8);

        // Extract info for query #9
        System.out.println("Query 9, population of cities in region Caribbean"+ "\n");
        ArrayList<City> citiesq9 = a.query9GetList();
        // Run query #9
        query9Display(citiesq9);

        // Extract info for query #10
        System.out.println("Query 10, population of cities in country France"+ "\n");
        ArrayList<City> citiesq10 = a.query10GetList();
        // Run query #10
        query10Display(citiesq10);

        // Extract info for query #11
        System.out.println("Query 11, population of cities in district Mendoza"+ "\n");
        ArrayList<City> citiesq11 = a.query11GetList();
        // Run query #11
        query11Display(citiesq11);

        // Extract info for query #12
        System.out.println("Query 12, top N populated cities in the world"+ "\n");
        ArrayList<City> citiesq12 = a.query12GetList();
        // Run query #12
        query12Display(citiesq12);

        // Extract info for query #13
        System.out.println("Query 13, top N populated cities in Europe"+ "\n");
        ArrayList<City> citiesq13 = a.query13GetList();
        // Run query #13
        query13Display(citiesq13);

        // Extract info for query #14
        System.out.println("Query 14, top N populated cities in the Caribbean"+ "\n");
        ArrayList<City> citiesq14 = a.query14GetList();
        // Run query #14
        query14Display(citiesq14);

        // Extract info for query #15
        System.out.println("Query 15, top N populated cities in France"+ "\n");
        ArrayList<City> citiesq15 = a.query15GetList();
        // Run query #15
        query15Display(citiesq15);

        // Extract info for query #16
        System.out.println("Query 16, top N populated cities in Mendoza"+ "\n");
        ArrayList<City> citiesq16 = a.query16GetList();
        // Run query #16
        query16Display(citiesq16);

        // Extract info for query #17
        System.out.println("Query 17, population of capital cities"+ "\n");
        ArrayList<City> citiesq17 = a.query17GetList();
        // Run query #17
        query17Display(citiesq17);

        // Extract info for query #18
        System.out.println("Query 18, population of capital cities in Europe"+ "\n");
        ArrayList<City> citiesq18 = a.query18GetList();
        // Run query #18
        query18Display(citiesq18);

        // Extract info for query #19
        System.out.println("Query 19, population of capital cities in Polynesia"+ "\n");
        ArrayList<City> citiesq19 = a.query19GetList();
        // Run query #19
        query19Display(citiesq19);

        // Extract info for query #20
        System.out.println("Query 20, top N populated capital cities in the world"+ "\n");
        ArrayList<City> citiesq20 = a.query20GetList();
        // Run query #20
        query20Display(citiesq20);

        // Extract info for query #21
        System.out.println("Query 21, top N populated capital cities in Europe"+ "\n");
        ArrayList<City> citiesq21 = a.query21GetList();
        // Run query #21
        query21Display(citiesq21);

        // Extract info for query #22
        System.out.println("Query 22, top N populated capital cities in Polynesia"+ "\n");
        ArrayList<City> citiesq22 = a.query22GetList();
        // Run query #22
        query22Display(citiesq22);

        // Extract info for query #26
        System.out.println("Query 26, population of the world"+ "\n");
        ArrayList<Country> citiesq26 = a.query26GetList();
        // Run query #26
        query26Display(citiesq26);

        // Extract info for query #27
        System.out.println("Query 27, population of Europe"+ "\n");
        ArrayList<Country> citiesq27 = a.query27GetList();
        // Run query #27
        query27Display(citiesq27);

        // Extract info for query #28
        System.out.println("Query 28, population of the Caribbean"+ "\n");
        ArrayList<Country> citiesq28 = a.query28GetList();
        // Run query #28
        query28Display(citiesq28);

        // Extract info for query #29
        System.out.println("Query 29, population of France"+ "\n");
        ArrayList<Country> citiesq29 = a.query29GetList();
        // Run query #29
        query29Display(citiesq29);

        // Extract info for query #30
        System.out.println("Query 30, population of Baijeri"+ "\n");
        ArrayList<Country> citiesq30 = a.query30GetList();
        // Run query #30
        query30Display(citiesq30);

        // Extract info for query #31
        System.out.println("Query 31, population of Paris"+ "\n");
        ArrayList<Country> citiesq31 = a.query31GetList();
        // Run query #31
        query31Display(citiesq31);

        // Extract info for query #32
        System.out.println("Query 32, Capital City Report"+ "\n");
        ArrayList<CityAndCountry> citiesq32 = a.query32GetList();
        // Run query #32
        query32Display(citiesq32);

        // Extract info for query #33
        System.out.println("Query 33, Amount of language speakers in the world"+ "\n");
        ArrayList<CityAndCountry> citiesq33 = a.query33GetList();
        // Run query #33
        query33Display(citiesq33);

        // Extract info for query #34
        System.out.println("Query 34, Population living in cities and rural areas"+ "\n");
        ArrayList<CityAndCountry> citiesq34 = a.query34GetList();
        // Run query #34
        query34Display(citiesq34);

        // Disconnect from database
        a.disconnect();
    }

    //Method to get a city from the database
    public City getCity(int CityID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name "
                            + "FROM city "
                            + "WHERE ID = " + CityID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                return city;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display a city from the database
    public void displayCity(City city)
    {
        if (city != null)
        {
            System.out.println(
                    city.ID + " "
                            + city.Name + "\n"
                            + city.CountryCode + "\n"
                            + city.District + "\n"
                            + city.Population + "\n");
        }
    }

    /**
     * Gets all the countries populations in the world.
     * @return A list of all countries populations in the world, or null if there is an error.
     */
    public ArrayList<Country> query1GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.name, country.Population "
                            + "FROM country "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Name = rset.getString("country.Name");
                country.Population = rset.getInt("country.Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query1
    public static void query1Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Name + "\n"
                                + countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the countries populations in the continent.
     * @return A list of all countries populations in the continent, or null if there is an error.
     */
    public ArrayList<Country> query2GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.name, country.Population "
                            + "FROM country "
                            + "WHERE country.Continent = 'Asia' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Name = rset.getString("country.Name");
                country.Population = rset.getInt("country.Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query2
    public static void query2Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Name + "\n"
                                + countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the countries populations in the region.
     * @return A list of all countries populations in the region, or null if there is an error.
     */
    public ArrayList<Country> query3GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.name, country.Population "
                            + "FROM country "
                            + "WHERE country.Region = 'Caribbean' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Name = rset.getString("country.Name");
                country.Population = rset.getInt("country.Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query3
    public static void query3Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Name + "\n"
                                + countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the top N countries populations.
     * @return A list of all top N countries populations, or null if there is an error.
     */
    public ArrayList<Country> query4GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.name, country.Population "
                            + "FROM country "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Name = rset.getString("country.Name");
                country.Population = rset.getInt("country.Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query4
    public static void query4Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Name + "\n"
                                + countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the top N countries populations.
     * @return A list of all top N countries populations, or null if there is an error.
     */
    public ArrayList<Country> query5GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.name, country.Population "
                            + "FROM country "
                            + "WHERE country.Continent = 'Europe' "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Name = rset.getString("country.Name");
                country.Population = rset.getInt("country.Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query5
    public static void query5Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Name + "\n"
                                + countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the top N countries populations.
     * @return A list of all top N countries populations, or null if there is an error.
     */
    public ArrayList<Country> query6GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.name, country.Population "
                            + "FROM country "
                            + "WHERE country.Region = 'Caribbean' "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Name = rset.getString("country.Name");
                country.Population = rset.getInt("country.Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query6
    public static void query6Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Name + "\n"
                                + countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the current cities populations in the world.
     * @return A list of all cities and populations in the world, or null if there is an error.
     */
    public ArrayList<City> query7GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population "
                            + "FROM city "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query7
    public static void query7Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the current cities populations in a continent.
     * @return A list of all cities and populations in a continent, or null if there is an error.
     */
    public ArrayList<City> query8GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE Continent = 'Europe' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query8
    public static void query8Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the current cities populations in a region.
     * @return A list of all cities and populations in a region, or null if there is an error.
     */
    public ArrayList<City> query9GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE country.Region = 'Caribbean' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query9
    public static void query9Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the current cities populations in a country.
     * @return A list of all cities and populations in a country, or null if there is an error.
     */
    public ArrayList<City> query10GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE country.Name = 'France' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query10
    public static void query10Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the current cities populations in a district.
     * @return A list of all cities and populations in a district, or null if there is an error.
     */
    public ArrayList<City> query11GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population "
                            + "FROM city "
                            + "WHERE city.District = 'Mendoza' "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query11
    public static void query11Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets top N populated cities.
     * @return A list of the top N populated cities, or null if there is an error.
     */
    public ArrayList<City> query12GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population "
                            + "FROM city "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query12
    public static void query12Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets top N populated cities.
     * @return A list of the top N populated cities, or null if there is an error.
     */
    public ArrayList<City> query13GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE Continent = 'Europe' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query13
    public static void query13Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets top N populated cities.
     * @return A list of the top N populated cities, or null if there is an error.
     */
    public ArrayList<City> query14GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE Region = 'Caribbean' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query14
    public static void query14Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets top N populated cities.
     * @return A list of the top N populated cities, or null if there is an error.
     */
    public ArrayList<City> query15GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE country.Name = 'France' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query15
    public static void query15Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets top N populated cities.
     * @return A list of the top N populated cities, or null if there is an error.
     */
    public ArrayList<City> query16GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city "
                            + "WHERE city.District = 'Mendoza' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query16
    public static void query16Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the current capital cities populations in the world.
     * @return A list of all apital cities and populations in the world, or null if there is an error.
     */
    public ArrayList<City> query17GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.Capital FROM country ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query17
    public static void query17Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the current capital cities populations in a continent.
     * @return A list of all apital cities and populations in a continent, or null if there is an error.
     */
    public ArrayList<City> query18GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.capital FROM country WHERE country.Continent = 'Europe' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query18
    public static void query18Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets all the current capital cities populations in a region.
     * @return A list of all apital cities and populations in a region, or null if there is an error.
     */
    public ArrayList<City> query19GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.capital FROM country WHERE country.Region = 'Polynesia' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query19
    public static void query19Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets top N populated capital cities.
     * @return A list of the top N populated capital cities, or null if there is an error.
     */
    public ArrayList<City> query20GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.Capital FROM country ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query20
    public static void query20Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets top N populated capital cities.
     * @return A list of the top N populated capital cities, or null if there is an error.
     */
    public ArrayList<City> query21GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.Capital FROM country WHERE country.Continent = 'Europe' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query21
    public static void query21Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets top N populated capital cities.
     * @return A list of the top N populated capital cities, or null if there is an error.
     */
    public ArrayList<City> query22GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.Capital FROM country WHERE country.Region = 'Polynesia' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.Name = rset.getString("city.Name");
                city.Population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Method to display Query22
    public static void query22Display(ArrayList<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null)
            {
                System.out.println(
                        cities.get(i).Name + "\n"
                                + cities.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets world population.
     * @return A list of the world population, or null if there is an error.
     */
    public ArrayList<Country> query26GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS population "
                            + "FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Population = rset.getLong("population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query26
    public static void query26Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets continent population.
     * @return A list of the continent population, or null if there is an error.
     */
    public ArrayList<Country> query27GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS Continent_Population "
                            + "FROM country "
                            + "WHERE country.Continent = 'Europe'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Population = rset.getLong("Continent_Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query27
    public static void query27Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets region population.
     * @return A list of the region population, or null if there is an error.
     */
    public ArrayList<Country> query28GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS Region_Population "
                            + "FROM country "
                            + "WHERE country.Region = 'Caribbean'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Population = rset.getLong("Region_Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query28
    public static void query28Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets country population.
     * @return A list of the country population, or null if there is an error.
     */
    public ArrayList<Country> query29GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS Country_Population "
                            + "FROM country "
                            + "WHERE country.Name = 'France'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Population = rset.getLong("Country_Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query29
    public static void query29Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets district population.
     * @return A list of the district population, or null if there is an error.
     */
    public ArrayList<Country> query30GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(city.Population) AS District_Population "
                            + "FROM city "
                            + "WHERE city.District = 'Baijeri'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Population = rset.getLong("District_Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query30
    public static void query30Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets city population.
     * @return A list of the city population, or null if there is an error.
     */
    public ArrayList<Country> query31GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Population "
                            + "FROM city "
                            + "WHERE city.Name = 'Paris'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Population = rset.getLong("city.Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query31
    public static void query31Display(ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i) != null)
            {
                System.out.println(
                        countries.get(i).Population + "\n");
            }
        }
    }

    /**
     * Gets capital city report.
     * @return A report of the capital city, or null if there is an error.
     */
    public ArrayList<CityAndCountry> query32GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM country, city "
                            + "WHERE city.ID = country.Capital";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CityAndCountry> reports = new ArrayList<CityAndCountry>();
            while (rset.next())
            {
                CityAndCountry cityandcountry = new CityAndCountry();
                cityandcountry.CityName = rset.getString("city.Name");
                cityandcountry.CountryName = rset.getString("country.Name");
                cityandcountry.CityPopulation = rset.getLong("city.Population");
                reports.add(cityandcountry);
            }
            return reports;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query32
    public static void query32Display(ArrayList<CityAndCountry> reports){
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i) != null)
            {
                System.out.println(
                        reports.get(i).CountryName + "\n"
                                + reports.get(i).CityName + "\n"
                                + reports.get(i).CityPopulation + "\n");
            }
        }
    }

    /**
     * Gets language report.
     * @return A report of the languages, or null if there is an error.
     */
    public ArrayList<CityAndCountry> query33GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT countrylanguage.Language, SUM(country.Population) AS Population, "
                            + "FORMAT((SUM(country.Population)/(SELECT SUM(country.Population) AS World_Population "
                            + "FROM  country))*100,2)  AS Percentage_of_The_World_Population "
                            + "FROM country, countrylanguage "
                            + "WHERE  country.Code = countrylanguage.CountryCode "
                            + "AND countrylanguage.Language "
                            + "IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')"
                            + "GROUP BY countrylanguage.Language "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CityAndCountry> reports = new ArrayList<CityAndCountry>();
            while (rset.next())
            {
                CityAndCountry cityandcountry = new CityAndCountry();
                cityandcountry.Language = rset.getString("countrylanguage.Language");
                cityandcountry.LanguageSpeakers = rset.getInt("Population");
                cityandcountry.LanguagePercentage = rset.getFloat("Percentage_of_The_World_Population");
                reports.add(cityandcountry);
            }
            return reports;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query33
    public static void query33Display(ArrayList<CityAndCountry> reports){
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i) != null)
            {
                System.out.println(
                        reports.get(i).Language + "\n"
                                + reports.get(i).LanguageSpeakers + "\n"
                                + reports.get(i).LanguagePercentage + "\n");
            }
        }
    }

    /**
     * Gets language report.
     * @return A report of the languages, or null if there is an error.
     */
    public ArrayList<CityAndCountry> query34GetList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT co.Continent, "
                            + "SUM((SELECT sum(ci.Population) FROM city ci "
                            + "WHERE ci.CountryCode = co.Code)) AS Cities_Population, "
                            + "SUM(co.Population) "
                            + "-SUM((SELECT sum(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code)) AS Rural_Population, "
                            + "FORMAT(SUM((SELECT sum(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code)) "
                            + "/(SUM(co.Population)) *100,2) AS Percentage_Living_in_Cities, "
                            + "FORMAT(100-(SUM((SELECT SUM(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code)) "
                            + "/(SUM(co.Population)))*100,2) AS Percentage_Living_in_Rural_Areas "
                            + "FROM country co  GROUP BY co.Continent  ORDER BY co.Continent ASC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CityAndCountry> reports = new ArrayList<CityAndCountry>();
            while (rset.next())
            {
                CityAndCountry cityandcountry = new CityAndCountry();
                cityandcountry.Continent = rset.getString("co.Continent");
                cityandcountry.CityPopulation = rset.getLong("Cities_Population");
                cityandcountry.CityPercentage = rset.getFloat("Percentage_Living_in_Cities");
                cityandcountry.RuralPopulation = rset.getLong("Rural_Population");
                cityandcountry.RuralPercentage = rset.getFloat("Percentage_Living_in_Rural_Areas");
                reports.add(cityandcountry);
            }
            return reports;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query34
    public static void query34Display(ArrayList<CityAndCountry> reports){
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i) != null)
            {
                System.out.println(
                        "Continent: " + reports.get(i).Continent + "\n"
                                + "City Population: " + reports.get(i).CityPopulation + "\n"
                                + "City Percentage: " + reports.get(i).CityPercentage + "\n"
                                + "Rural Population: " + reports.get(i).RuralPopulation + "\n"
                                + "Rural Percentage: " + reports.get(i).RuralPercentage + "\n");
            }
        }
    }
}