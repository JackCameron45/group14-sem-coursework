import com.napier.semgroup14.City;
import com.napier.semgroup14.Country;
import com.napier.semgroup14.MainProgram;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

//Test Class to test the outputs of each display
public class UnitTest {

    //Creating MainProgram instance
    static MainProgram mainprogram;

    @BeforeAll
    static void init()
    {
        mainprogram = new MainProgram();
    }

    //Test when countries is null
    @Test
    void printCountriesTestNull() {
        MainProgram.CountryReportDisplay(null);
    }

    //Test when countries is empty
    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        MainProgram.CountryReportDisplay(countries);
    }

    //Test when countries has a null value
    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        MainProgram.CountryReportDisplay(countries);
    }

    //Test when all data is supplied
    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.Code = "FRA";
        country.Name = "France";
        country.Continent = "Europe";
        country.Region = "Western Europe";
        country.Population = 59225700;
        country.Capital = 2974;
        countries.add(country);
        MainProgram.CountryReportDisplay(countries);
    }

    //Test when cities is null
    @Test
    void printCitiesTestNull() {
        MainProgram.CityReportDisplay(null);
    }

    //Test when cities is empty
    @Test
    void printCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<>();
        MainProgram.CityReportDisplay(cities);
    }

    //Test when cities has a null value
    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        MainProgram.CityReportDisplay(cities);
    }

    //Test when all data is supplied
    @Test
    void printCities()
    {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.Name = "Edinburgh";
        city.CountryCode = "GBR";
        city.District = "Scotland";
        city.Population = 450180;
        cities.add(city);
        MainProgram.CityReportDisplay(cities);
    }

    //Test when cities is null
    @Test
    void printCapitalCitiesTestNull() {
        MainProgram.CapitalCityReportDisplay(null);
    }

    //Test when cities is empty
    @Test
    void printCapitalCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<>();
        MainProgram.CapitalCityReportDisplay(cities);
    }

    //Test when cities has a null value
    @Test
    void printCapitalCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        MainProgram.CapitalCityReportDisplay(cities);
    }

    //Test when all data is supplied
    @Test
    void printCapitalCities()
    {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.Name = "London";
        city.CountryCode = "GBR";
        city.Population = 7285000;
        cities.add(city);
        MainProgram.CapitalCityReportDisplay(cities);
    }

}
