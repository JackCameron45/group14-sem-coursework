import com.napier.semgroup14.Country;
import com.napier.semgroup14.MainProgram;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UnitTest {

    static MainProgram mainprogram;

    @BeforeAll
    static void init()
    {
        mainprogram = new MainProgram();
    }

    @Test
    void printCountriesTestNull() {
        MainProgram.CountryReportDisplay(null);
    }

    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        MainProgram.CountryReportDisplay(countries);
    }

    @Test
    void printSalariesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        MainProgram.CountryReportDisplay(countries);
    }

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

}
