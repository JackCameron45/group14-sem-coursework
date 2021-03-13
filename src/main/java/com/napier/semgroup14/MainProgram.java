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
                // Wait a bit for db to start
                Thread.sleep(3000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "pass");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
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

        // Run Test Query
        System.out.println("Test Query"+ "\n");
        City city = a.getCity(247);
        // Display results
        a.displayCity(city);

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

}