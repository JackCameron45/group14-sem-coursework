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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {


    //Creating MainProgram instance
    static MainProgram mainprogram;

    @BeforeAll
    static void init() {
        mainprogram = new MainProgram();
        mainprogram.connect("localhost:33060");
    }


    @Test
    public void query1GetListTest() {
        ArrayList<Country> countries = mainprogram.query1GetList();
        assertEquals(239, countries.size() );
        assertEquals("China", countries.get(0).Name );
        // assertTrue(countries.size() > 0);

    }

    @Test
    public void query2GetListTest() {
        ArrayList<Country> countries = mainprogram.query1GetList();
        assertEquals("China", countries.get(0).Name );
        assertEquals(239, countries.size() );
        // assertTrue(countries.size() > 0);
    }


    @Test
    public void query6GetListTest() {
        ArrayList<Country> countries = mainprogram.query6GetList();
        assertEquals(5, countries.size());
    }


    @Test
    public void query7GetListTest() {
        ArrayList<City> cities = mainprogram.query7GetList();
        assertEquals(4079, cities.size());
        assertEquals("Seoul", cities.get(1).Name, "1st element of the list should match");
    }

    @Test
    public void query33GetListTest() {
        ArrayList<CityAndCountry> cityAndCountries = mainprogram.query33GetList();
        assertEquals("32.38", roundBg(cityAndCountries.get(0).LanguagePercentage));
    }

    public static BigDecimal roundBg(float arg) {
        return new BigDecimal(arg).setScale(2, RoundingMode.HALF_UP);
    }

}