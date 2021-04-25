package com.napier.semgroup14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;


/**
 * Class to connect to the MySQL world database
 */
@SpringBootApplication
@RestController
public class MainProgram {
    /**
     * Connection to MySQL world database.
     */
    private static Connection con = null;

    /**
     * Connect to the MySQL world database.
     */
    public static void connect(String location) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "pass");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
                // Wait a bit for db to start
                try {
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
    public static void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    //Use methods to connect to the database
    public static void main(String[] args)
    {
        // Connect to database
        if (args.length < 1)
        {
            connect("localhost:33060");
        }
        else
        {
            connect(args[0]);
        }

        SpringApplication.run(MainProgram.class, args);
    }

    /**
     * Gets all the countries populations in the world.
     *
     * @return A list of all countries populations in the world, or null if there is an error.
     */
    @RequestMapping("query1")
    public ArrayList<Country> query1GetList() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            + "FROM country "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getLong("country.Population");
                country.capital = rset.getInt("country.Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets all the countries populations in the continent.
     *
     * @return A list of all countries populations in the continent, or null if there is an error.
     */
    @RequestMapping("query2")
    public ArrayList<Country> query2GetList(@RequestParam(value = "continent") String CONTINENT) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            + "FROM country "
                            + "WHERE country.Continent = '"
                            + CONTINENT
                            + "' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getLong("country.Population");
                country.capital = rset.getInt("country.Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets all the countries populations in the region.
     *
     * @return A list of all countries populations in the region, or null if there is an error.
     */
    @RequestMapping("query3")
    public ArrayList<Country> query3GetList(@RequestParam(value = "region") String REGION) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            + "FROM country "
                            + "WHERE country.Region = '"
                            + REGION
                            + "' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getLong("country.Population");
                country.capital = rset.getInt("country.Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets all the top N countries populations.
     *
     * @return A list of all top N countries populations, or null if there is an error.
     */
    @RequestMapping("query4")
    public ArrayList<Country> query4GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            + "FROM country "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getLong("country.Population");
                country.capital = rset.getInt("country.Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets all the top N countries populations.
     *
     * @return A list of all top N countries populations, or null if there is an error.
     */
    @RequestMapping("query5")
    public ArrayList<Country> query5GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            + "FROM country "
                            + "WHERE country.Continent = 'Europe' "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getLong("country.Population");
                country.capital = rset.getInt("country.Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets all the top N countries populations.
     *
     * @return A list of all top N countries populations, or null if there is an error.
     */
    @RequestMapping("query6")
    public ArrayList<Country> query6GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            + "FROM country "
                            + "WHERE country.Region = 'Caribbean' "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getLong("country.Population");
                country.capital = rset.getInt("country.Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets all the current cities populations in the world.
     *
     * @return A list of all cities and populations in the world, or null if there is an error.
     */
    @RequestMapping("query7")
    public ArrayList<City> query7GetList() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, CountryCode, District, Population "
                            + "FROM city "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets all the current cities populations in a continent.
     *
     * @return A list of all cities and populations in a continent, or null if there is an error.
     */
    @RequestMapping("query8")
    public ArrayList<City> query8GetList(@RequestParam(value = "continent") String CONTINENT) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE Continent = '"
                            + CONTINENT
                            + "' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets all the current cities populations in a region.
     *
     * @return A list of all cities and populations in a region, or null if there is an error.
     */
    @RequestMapping("query9")
    public ArrayList<City> query9GetList(@RequestParam(value = "region") String REGION) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE country.Region = '"
                            + REGION
                            + "' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets all the current cities populations in a country.
     *
     * @return A list of all cities and populations in a country, or null if there is an error.
     */
    @RequestMapping("query10")
    public ArrayList<City> query10GetList(@RequestParam(value = "country") String COUNTRY) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE country.Name = '"
                            + COUNTRY
                            + "' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets all the current cities populations in a district.
     *
     * @return A list of all cities and populations in a district, or null if there is an error.
     */
    @RequestMapping("query11")
    public ArrayList<City> query11GetList(@RequestParam(value = "district") String DISTRICT) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city "
                            + "WHERE city.District = '"
                            + DISTRICT
                            + "' "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets top N populated cities.
     *
     * @return A list of the top N populated cities, or null if there is an error.
     */
    @RequestMapping("query12")
    public ArrayList<City> query12GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets top N populated cities.
     *
     * @return A list of the top N populated cities, or null if there is an error.
     */
    @RequestMapping("query13")
    public ArrayList<City> query13GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE Continent = 'Europe' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets top N populated cities.
     *
     * @return A list of the top N populated cities, or null if there is an error.
     */
    @RequestMapping("query14")
    public ArrayList<City> query14GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE Region = 'Caribbean' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets top N populated cities.
     *
     * @return A list of the top N populated cities, or null if there is an error.
     */
    @RequestMapping("query15")
    public ArrayList<City> query15GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.CountryCode IN (SELECT country.Code FROM country WHERE country.Name = 'France' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets top N populated cities.
     *
     * @return A list of the top N populated cities, or null if there is an error.
     */
    @RequestMapping("query16")
    public ArrayList<City> query16GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city "
                            + "WHERE city.District = 'Mendoza' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.district = rset.getString("city.District");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets all the current capital cities populations in the world.
     *
     * @return A list of all capital cities and populations in the world, or null if there is an error.
     */
    @RequestMapping("query17")
    public ArrayList<City> query17GetList() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.CountryCode, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.Capital FROM country ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets all the current capital cities populations in a continent.
     *
     * @return A list of all capital cities and populations in a continent, or null if there is an error.
     */
    @RequestMapping("query18")
    public ArrayList<City> query18GetList(@RequestParam(value = "continent") String CONTINENT) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.CountryCode, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.capital FROM country WHERE country.Continent = '"
                            + CONTINENT
                            + "' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets all the current capital cities populations in a region.
     *
     * @return A list of all capital cities and populations in a region, or null if there is an error.
     */
    @RequestMapping("query19")
    public ArrayList<City> query19GetList(@RequestParam(value = "region") String REGION) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.CountryCode, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.capital FROM country WHERE country.Region = '"
                            + REGION
                            + "' ) "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets top N populated capital cities.
     *
     * @return A list of the top N populated capital cities, or null if there is an error.
     */
    @RequestMapping("query20")
    public ArrayList<City> query20GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.CountryCode, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.Capital FROM country ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets top N populated capital cities.
     *
     * @return A list of the top N populated capital cities, or null if there is an error.
     */
    @RequestMapping("query21")
    public ArrayList<City> query21GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.CountryCode, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.Capital FROM country WHERE country.Continent = 'Europe' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets top N populated capital cities.
     *
     * @return A list of the top N populated capital cities, or null if there is an error.
     */
    @RequestMapping("query22")
    public ArrayList<City> query22GetList(@RequestParam(value = "id") String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.CountryCode, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.code AND city.ID IN (SELECT country.Capital FROM country WHERE country.Region = 'Polynesia' ) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT "
                            + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.countryCode = rset.getString("city.CountryCode");
                city.population = rset.getInt("city.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Gets rural and cities report in a continent.
     *
     * @return A report of the rural and cities population in a continent, or null if there is an error.
     */
    @RequestMapping("query23")
    public ArrayList<CityAndCountry> query23GetList() {
        try {
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
            ArrayList<CityAndCountry> reports = new ArrayList<>();
            while (rset.next()) {
                CityAndCountry cityandcountry = new CityAndCountry();
                cityandcountry.continent = rset.getString("co.Continent");
                cityandcountry.cityPopulation = rset.getLong("Cities_Population");
                cityandcountry.cityPercentage = rset.getFloat("Percentage_Living_in_Cities");
                cityandcountry.ruralPopulation = rset.getLong("Rural_Population");
                cityandcountry.ruralPercentage = rset.getFloat("Percentage_Living_in_Rural_Areas");
                reports.add(cityandcountry);
            }
            return reports;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query23
    public static void query23Display(ArrayList<CityAndCountry> reports) {
        for (CityAndCountry report : reports) {
            if (report != null) {
                System.out.println(
                        "Continent: " + report.continent + "\n"
                                + "City Population: " + report.cityPopulation + "\n"
                                + "City Percentage: " + report.cityPercentage + "\n"
                                + "Rural Population: " + report.ruralPopulation + "\n"
                                + "Rural Percentage: " + report.ruralPercentage + "\n");
            }
        }
    }

    /**
     * Gets rural and cities report in a region.
     *
     * @return A report of the rural and cities population in a region, or null if there is an error.
     */
    @RequestMapping("query24")
    public ArrayList<CityAndCountry> query24GetList() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT co.Region, "
                            + "SUM((SELECT sum(ci.Population) FROM city ci "
                            + "WHERE ci.CountryCode = co.Code)) AS Cities_Population, "
                            + "SUM(co.Population) "
                            + "-SUM((SELECT sum(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code)) AS Rural_Population, "
                            + "FORMAT(SUM((SELECT sum(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code)) "
                            + "/(SUM(co.Population)) *100,2) AS Percentage_Living_in_Cities, "
                            + "FORMAT(100-(SUM((SELECT SUM(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code)) "
                            + "/(SUM(co.Population)))*100,2) AS Percentage_Living_in_Rural_Areas "
                            + "FROM country co  GROUP BY co.Region  ORDER BY co.Region ASC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CityAndCountry> reports = new ArrayList<>();
            while (rset.next()) {
                CityAndCountry cityandcountry = new CityAndCountry();
                cityandcountry.region = rset.getString("co.Region");
                cityandcountry.cityPopulation = rset.getLong("Cities_Population");
                cityandcountry.cityPercentage = rset.getFloat("Percentage_Living_in_Cities");
                cityandcountry.ruralPopulation = rset.getLong("Rural_Population");
                cityandcountry.ruralPercentage = rset.getFloat("Percentage_Living_in_Rural_Areas");
                reports.add(cityandcountry);
            }
            return reports;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets rural and cities report in a region.
     *
     * @return A report of the rural and cities population in a region, or null if there is an error.
     */
    @RequestMapping("query25")
    public ArrayList<CityAndCountry> query25GetList() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT co.Name, "
                            + "SUM((SELECT sum(ci.Population) FROM city ci "
                            + "WHERE ci.CountryCode = co.Code)) AS Cities_Population, "
                            + "SUM(co.Population) "
                            + "-SUM((SELECT sum(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code)) AS Rural_Population, "
                            + "FORMAT(SUM((SELECT sum(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code)) "
                            + "/(SUM(co.Population)) *100,2) AS Percentage_Living_in_Cities, "
                            + "FORMAT(100-(SUM((SELECT SUM(ci.Population) FROM city ci  WHERE ci.CountryCode = co.Code)) "
                            + "/(SUM(co.Population)))*100,2) AS Percentage_Living_in_Rural_Areas "
                            + "FROM country co  GROUP BY co.Name  ORDER BY co.Name ASC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CityAndCountry> reports = new ArrayList<>();
            while (rset.next()) {
                CityAndCountry cityandcountry = new CityAndCountry();
                cityandcountry.countryName = rset.getString("co.Name");
                cityandcountry.cityPopulation = rset.getLong("Cities_Population");
                cityandcountry.cityPercentage = rset.getFloat("Percentage_Living_in_Cities");
                cityandcountry.ruralPopulation = rset.getLong("Rural_Population");
                cityandcountry.ruralPercentage = rset.getFloat("Percentage_Living_in_Rural_Areas");
                reports.add(cityandcountry);
            }
            return reports;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query25
    public static void query25Display(ArrayList<CityAndCountry> reports) {
        for (CityAndCountry report : reports) {
            if (report != null) {
                System.out.println(
                        "Country: " + report.countryName + "\n"
                                + "City Population: " + report.cityPopulation + "\n"
                                + "City Percentage: " + report.cityPercentage + "\n"
                                + "Rural Population: " + report.ruralPopulation + "\n"
                                + "Rural Percentage: " + report.ruralPercentage + "\n");
            }
        }
    }

    //Method to display Query24
    public static void query24Display(ArrayList<CityAndCountry> reports) {
        for (CityAndCountry report : reports) {
            if (report != null) {
                System.out.println(
                        "Region: " + report.region + "\n"
                                + "City Population: " + report.cityPopulation + "\n"
                                + "City Percentage: " + report.cityPercentage + "\n"
                                + "Rural Population: " + report.ruralPopulation + "\n"
                                + "Rural Percentage: " + report.ruralPercentage + "\n");
            }
        }
    }

    /**
     * Gets world population.
     *
     * @return A list of the world population, or null if there is an error.
     */
    @RequestMapping("query26")
    public ArrayList<Country> query26GetList() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS population "
                            + "FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.population = rset.getLong("population");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query26
    public static void query26Display(ArrayList<Country> countries) {
        for (Country country : countries) {
            if (country != null) {
                System.out.println(
                        country.population + "\n");
            }
        }
    }

    /**
     * Gets continent population.
     *
     * @return A list of the continent population, or null if there is an error.
     */
    @RequestMapping("query27")
    public ArrayList<Country> query27GetList(@RequestParam(value = "continent") String CONTINENT) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS Continent_Population "
                            + "FROM country "
                            + "WHERE country.Continent = '"
                            + CONTINENT
                            + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.population = rset.getLong("Continent_Population");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query27
    public static void query27Display(ArrayList<Country> countries) {
        for (Country country : countries) {
            if (country != null) {
                System.out.println(
                        country.population + "\n");
            }
        }
    }

    /**
     * Gets region population.
     *
     * @return A list of the region population, or null if there is an error.
     */
    @RequestMapping("query28")
    public ArrayList<Country> query28GetList(@RequestParam(value = "region") String REGION) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS Region_Population "
                            + "FROM country "
                            + "WHERE country.Region = '"
                            + REGION
                            + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.population = rset.getLong("Region_Population");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query28
    public static void query28Display(ArrayList<Country> countries) {
        for (Country country : countries) {
            if (country != null) {
                System.out.println(
                        country.population + "\n");
            }
        }
    }

    /**
     * Gets country population.
     *
     * @return A list of the country population, or null if there is an error.
     */
    @RequestMapping("query29")
    public ArrayList<Country> query29GetList(@RequestParam(value = "country") String COUNTRY) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS Country_Population "
                            + "FROM country "
                            + "WHERE country.Name = '"
                            + COUNTRY
                            + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.population = rset.getLong("Country_Population");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query29
    public static void query29Display(ArrayList<Country> countries) {
        for (Country country : countries) {
            if (country != null) {
                System.out.println(
                        country.population + "\n");
            }
        }
    }

    /**
     * Gets district population.
     *
     * @return A list of the district population, or null if there is an error.
     */
    @RequestMapping("query30")
    public ArrayList<Country> query30GetList(@RequestParam(value = "district") String DISTRICT) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(city.Population) AS District_Population "
                            + "FROM city "
                            + "WHERE city.District = '"
                            + DISTRICT
                            + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.population = rset.getLong("District_Population");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query30
    public static void query30Display(ArrayList<Country> countries) {
        for (Country country : countries) {
            if (country != null) {
                System.out.println(
                        country.population + "\n");
            }
        }
    }

    /**
     * Gets city population.
     *
     * @return A list of the city population, or null if there is an error.
     */
    @RequestMapping("query31")
    public ArrayList<Country> query31GetList(@RequestParam(value = "city") String CITY) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Population "
                            + "FROM city "
                            + "WHERE city.Name = '"
                            + CITY
                            + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.population = rset.getLong("city.Population");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query31
    public static void query31Display(ArrayList<Country> countries) {
        for (Country country : countries) {
            if (country != null) {
                System.out.println(
                        country.population + "\n");
            }
        }
    }

    /**
     * Gets capital city report.
     *
     * @return A report of the capital city, or null if there is an error.
     */
    @RequestMapping("query32test")
    public ArrayList<CityAndCountry> query32GetList() {
        try {
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
            ArrayList<CityAndCountry> reports = new ArrayList<>();
            while (rset.next()) {
                CityAndCountry cityandcountry = new CityAndCountry();
                cityandcountry.cityName = rset.getString("city.Name");
                cityandcountry.countryName = rset.getString("country.Name");
                cityandcountry.cityPopulation = rset.getLong("city.Population");
                reports.add(cityandcountry);
            }
            return reports;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query32
    public static void query32Display(ArrayList<CityAndCountry> reports) {
        for (CityAndCountry report : reports) {
            if (report != null) {
                System.out.println(
                        "Country Name : " + report.countryName + "\n"
                                + "Capital City Name : " + report.cityName + "\n"
                                + "Capital City Population : " + report.cityPopulation + "\n");
            }
        }
    }

    /**
     * Gets language report.
     *
     * @return A report of the languages, or null if there is an error.
     */
    @RequestMapping("query32")
    public ArrayList<CityAndCountry> query33GetList() {
        try {
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
            ArrayList<CityAndCountry> reports = new ArrayList<>();
            while (rset.next()) {
                CityAndCountry cityandcountry = new CityAndCountry();
                cityandcountry.language = rset.getString("countrylanguage.Language");
                cityandcountry.languageSpeakers = rset.getInt("Population");
                cityandcountry.languagePercentage = rset.getFloat("Percentage_of_The_World_Population");
                reports.add(cityandcountry);
            }
            return reports;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Method to display Query33
    public static void query33Display(ArrayList<CityAndCountry> reports) {
        for (CityAndCountry report : reports) {
            if (report != null) {
                System.out.println(
                        "Language : " + report.language + "\n"
                                + "Amount of Speakers : " + report.languageSpeakers + "\n"
                                + "Percentage of Speakers : " + report.languagePercentage + "\n");
            }
        }
    }

    //Method to display a country report
    public static void CountryReportDisplay(ArrayList<Country> countries) {
        // Check countries is not null
        if (countries == null) {
            System.out.println("No countries");
            return;
        }
        for (Country country : countries) {
            if (country != null) {
                System.out.println(
                        "Country Code: " + country.code + "\n"
                                + "Country Name: " + country.name + "\n"
                                + "Continent: " + country.continent + "\n"
                                + "Region: " + country.region + "\n"
                                + "Population: " + country.population + "\n"
                                + "Capital: " + country.capital + "\n");
            }
        }
    }

    //Method to display a city report
    public static void CityReportDisplay(ArrayList<City> cities) {
        // Check cities is not null
        if (cities == null) {
            System.out.println("No cities");
            return;
        }
        for (City city : cities) {
            if (city != null) {
                System.out.println(
                        "City Name: " + city.name + "\n"
                                + "Country Name: " + city.countryCode + "\n"
                                + "District: " + city.district + "\n"
                                + "Population: " + city.population + "\n");
            }
        }
    }

    //Method to a capital city report
    public static void CapitalCityReportDisplay(ArrayList<City> cities) {
        // Check cities is not null
        if (cities == null) {
            System.out.println("No capital cities");
            return;
        }
        for (City city : cities) {
            if (city != null) {
                System.out.println(
                        "City Name: " + city.name + "\n"
                                + "Country Name: " + city.countryCode + "\n"
                                + "Population: " + city.population + "\n");
            }
        }
    }
}
