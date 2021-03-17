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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@Disabled
public class TestWithoutRunApp {

    static MainProgram mp;

    @Disabled
    @BeforeAll
    static public void initDatabase() throws ClassNotFoundException, SQLException {
//        mp = new MainProgram();
//        mp.connect();
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM './db/world_db/worldTest.sql';MODE=MYSQL", "sa", "");
        mp = new MainProgram();
        mp.setConnectForTest(conn);
    }

    @Disabled
    @AfterAll
    public static void deInit() {
        mp.disconnect();
    }

    @Disabled
    @Test
    public void query6GetListTest() {
        ArrayList<Country> countries = mp.query6GetList();
        System.out.println("Test try " + countries.size());
        assertEquals(5, countries.size());
    }

    //  @Disabled
    @Disabled
    @Test
    public void query7GetListTest() {
        ArrayList<City> cities = mp.query7GetList();
        System.out.println("Test proba " + cities.size());
        assertEquals(4079, cities.size());
        assertEquals("Seoul", cities.get(1).Name, "1st element of the list should match");
    }

 //   @Test
 //   public void query33GetListTest() {
 //       ArrayList<CityAndCountry> cityAndCountries = mp.query33GetList();
 //       assertEquals("32.38", roundBg(cityAndCountries.get(0).LanguagePercentage));
 //   }

    public static BigDecimal roundBg(float arg) {
        return new BigDecimal(arg).setScale(2, RoundingMode.HALF_UP);
    }

}
