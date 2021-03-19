import com.napier.semgroup14.City;
import com.napier.semgroup14.CityAndCountry;
import com.napier.semgroup14.Country;
import com.napier.semgroup14.MainProgram;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static com.napier.semgroup14.MainProgram.CityReportDisplay;
import static com.napier.semgroup14.MainProgram.CountryReportDisplay;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrationTest {


    //Creating MainProgram instance
    static MainProgram mainprogram;

    //Connecting to database
    @BeforeAll
    static void init() {
        mainprogram = new MainProgram();
        mainprogram.connect("localhost:33060", "pass");
    }

    //Query1 test
    @Test
    public void query1GetListTest() {
        ArrayList<Country> countries = mainprogram.query1GetList();
        assertEquals("China", countries.get(0).Name);
        assertEquals(239, countries.size());
    }

    //Query2 test
    @Test
    public void query2GetListTest() {
        ArrayList<Country> countries = mainprogram.query2GetList();
        assertEquals("China", countries.get(0).Name);
        assertEquals(51, countries.size());
    }

    //Query3 test
    @Test
    public void query3GetListTest() {
        ArrayList<Country> countries = mainprogram.query3GetList();
        assertEquals("Haiti", countries.get(2).Name);
        assertEquals(24, countries.size());
    }

    //Query4 test
    @Test
    public void query4GetListTest() {
        ArrayList<Country> countries = mainprogram.query4GetList();
        assertEquals("India", countries.get(1).Name);
        assertEquals(5, countries.size());
    }

    //Query5 test
    @Test
    public void query5GetListTest() {
        ArrayList<Country> countries = mainprogram.query5GetList();
        assertEquals("Germany", countries.get(1).Name);
        assertEquals(5, countries.size());
    }

    //Query6 test
    @Test
    public void query6GetListTest() {
        ArrayList<Country> countries = mainprogram.query6GetList();
        assertEquals("Haiti", countries.get(2).Name);
        assertEquals(5, countries.size());
    }

    //Query7 test
    @Test
    public void query7GetListTest() {
        ArrayList<City> cities = mainprogram.query7GetList();
        assertEquals(4079, cities.size());
        assertEquals("Seoul", cities.get(1).Name);
    }

    //Query8 test
    @Test
    public void query8GetListTest() {
        ArrayList<City> cities = mainprogram.query8GetList();
        assertEquals(841, cities.size());
        assertEquals("Moscow", cities.get(0).Name);
    }

    //Query9 test
    @Test
    public void query9GetListTest() {
        ArrayList<City> cities = mainprogram.query9GetList();
        assertEquals(58, cities.size());
        assertEquals("Carrefour", cities.get(7).Name);
    }

    //Query10 test
    @Test
    public void query10GetListTest() {
        ArrayList<City> cities = mainprogram.query10GetList();
        assertEquals(40, cities.size());
        assertEquals("Marseille", cities.get(1).Name);
    }

    //Query11 test
    @Test
    public void query11GetListTest() {
        ArrayList<City> cities = mainprogram.query11GetList();
        assertEquals(5, cities.size());
        assertEquals("Las Heras", cities.get(2).Name);
    }

    //Query12 test
    @Test
    public void query12GetListTest() {
        ArrayList<City> cities = mainprogram.query12GetList();
        assertEquals(5, cities.size());
        assertEquals("Seoul", cities.get(1).Name);
    }

    //Query13 test
    @Test
    public void query13GetListTest() {
        ArrayList<City> cities = mainprogram.query13GetList();
        assertEquals(5, cities.size());
        assertEquals("Moscow", cities.get(0).Name);
    }

    //Query14 test
    @Test
    public void query14GetListTest() {
        ArrayList<City> cities = mainprogram.query14GetList();
        assertEquals(5, cities.size());
        assertEquals("La Habana", cities.get(0).Name);
    }

    //Query15 test
    @Test
    public void query15GetListTest() {
        ArrayList<City> cities = mainprogram.query15GetList();
        assertEquals(5, cities.size());
        assertEquals("Paris", cities.get(0).Name);
    }

    //Query16 test
    @Test
    public void query16GetListTest() {
        ArrayList<City> cities = mainprogram.query16GetList();
        assertEquals(5, cities.size());
        assertEquals("Godoy Cruz", cities.get(0).Name);
    }

    //Query17 test
    @Test
    public void query17GetListTest() {
        ArrayList<City> cities = mainprogram.query17GetList();
        assertEquals(232, cities.size());
        assertEquals("Jakarta", cities.get(1).Name);
    }

    //Query18 test
    @Test
    public void query18GetListTest() {
        ArrayList<City> cities = mainprogram.query18GetList();
        assertEquals(46, cities.size());
        assertEquals("London", cities.get(1).Name);
    }

    //Query19 test
    @Test
    public void query19GetListTest() {
        ArrayList<City> cities = mainprogram.query19GetList();
        assertEquals(10, cities.size());
        assertEquals("Papeete", cities.get(1).Name);
    }

    //Query20 test
    @Test
    public void query20GetListTest() {
        ArrayList<City> cities = mainprogram.query20GetList();
        assertEquals(5, cities.size());
        assertEquals("Seoul", cities.get(0).Name);
    }

    //Query21 test
    @Test
    public void query21GetListTest() {
        ArrayList<City> cities = mainprogram.query21GetList();
        assertEquals(5, cities.size());
        assertEquals("Berlin", cities.get(2).Name);
    }

    //Query22 test
    @Test
    public void query22GetListTest() {
        ArrayList<City> cities = mainprogram.query22GetList();
        assertEquals(5, cities.size());
        assertEquals("Avarua", cities.get(3).Name);
    }

    //Query23 test
    @Test
    public void query23GetListTest() {
        ArrayList<CityAndCountry> reports = mainprogram.query23GetList();
        assertEquals(7, reports.size());
        assertEquals("Asia", reports.get(0).Continent);
    }

    //Query24 test
    @Test
    public void query24GetListTest() {
        ArrayList<CityAndCountry> reports = mainprogram.query24GetList();
        assertEquals(25, reports.size());
        assertEquals("Antarctica", reports.get(0).Region);
    }

    //Query25 test
    @Test
    public void query25GetListTest() {
        ArrayList<CityAndCountry> reports = mainprogram.query25GetList();
        assertEquals(239, reports.size());
        assertEquals("Albania", reports.get(1).CountryName);
    }

    //Query26 test
    @Test
    public void query26GetListTest() {
        ArrayList<Country> country = mainprogram.query26GetList();
        assertEquals(1, country.size());
        assertEquals(6078749450L, country.get(0).Population);
    }

    //Query27 test
    @Test
    public void query27GetListTest() {
        ArrayList<Country> country = mainprogram.query27GetList();
        assertEquals(1, country.size());
        assertEquals(730074600, country.get(0).Population);
    }

    //Query28 test
    @Test
    public void query28GetListTest() {
        ArrayList<Country> country = mainprogram.query28GetList();
        assertEquals(1, country.size());
        assertEquals(38140000, country.get(0).Population);
    }

    //Query29 test
    @Test
    public void query29GetListTest() {
        ArrayList<Country> country = mainprogram.query29GetList();
        assertEquals(1, country.size());
        assertEquals(59225700, country.get(0).Population);
    }

    //Query30 test
    @Test
    public void query30GetListTest() {
        ArrayList<Country> country = mainprogram.query30GetList();
        assertEquals(1, country.size());
        assertEquals(2513988, country.get(0).Population);
    }

    //Query31 test
    @Test
    public void query31GetListTest() {
        ArrayList<Country> country = mainprogram.query31GetList();
        assertEquals(1, country.size());
        assertEquals(2125246, country.get(0).Population);
    }

    //Query32 test
    @Test
    public void query32GetListTest() {
        ArrayList<CityAndCountry> reports = mainprogram.query32GetList();
        assertEquals(232, reports.size());
        assertEquals("Aruba", reports.get(0).CountryName);
    }

    //Query33 test
    @Test
    public void query33GetListTest() {
        ArrayList<CityAndCountry> reports = mainprogram.query33GetList();
        assertEquals(5, reports.size());
        assertEquals("Chinese", reports.get(0).Language);
    }
}

