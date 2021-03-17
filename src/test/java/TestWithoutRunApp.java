import com.napier.semgroup14.City;
import com.napier.semgroup14.CityAndCountry;
import com.napier.semgroup14.Country;
import com.napier.semgroup14.MainProgram;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
public class TestWithoutRunApp {

    static  MainProgram mp;

    @BeforeAll
    static public void   initT() {
        mp = new MainProgram();
        mp.connect();
    }
    @AfterAll
    public static      void  deInit() {
        mp.disconnect();
    }

    @Disabled
    @Test
    public void query6GetListTest(){
        ArrayList<Country> countries = mp.query6GetList();
        System.out.println("Test proba " + countries.size());
        assertEquals(5, countries.size());
    }
    @Disabled
    @Test
    public void query7GetListTest(){
        ArrayList<City> cities = mp.query7GetList();
        System.out.println("Test proba " + cities.size());
        assertEquals(4079, cities.size());
        assertEquals("Seoul", cities.get(1).Name, "Pierwszy element na liście ma się zgadzać");
    }
    @Disabled
    @Test
    public void query33GetListTest() {
        ArrayList<CityAndCountry> cityAndCountries = mp.query33GetList();
//        new BigDecimal( ).setScale(2, RoundingMode.HALF_UP)

        assertEquals(new BigDecimal("32.38"),  roundBg(cityAndCountries.get(0).LanguagePercentage));
        // skrot
    }

    public static BigDecimal roundBg(float arg) {
        return new  BigDecimal(arg).setScale(2, RoundingMode.HALF_UP);
    }

}
