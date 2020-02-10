package NewTestingTRY;
import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CeckTest {
    private static final String CITY = "New York";
    public static final String MAY_FIRST = "1 May 2020";
    public static final String MAY_LAST = "31 May 2020";


    private static WebDriver webDriver;
    private WelcomePage welcomePage;
    private NewYorkPage newYorkPage;


    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/oleksandrlitvincuk/Desktop/Java/untitled/src/main/resources/drivers/chromedriver2");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.booking.com/index.en-gb.html");
    }

    @Before
    public void navigateToBasePage() {
        welcomePage = new WelcomePage(webDriver);
        newYorkPage = new NewYorkPage(webDriver);
    }

    @AfterClass
    public static void cleanUp() {
        webDriver.close();
    }

    @Test
    @Description(value = "Test is tests")
    public void dataCityTest() throws ParseException {
        welcomePage.enterCity();
        welcomePage.clickOnDate();
        welcomePage.choiseDate();
        welcomePage.clickSerch();

        assertThat(newYorkPage.chekInDate().getText()).containsSequence(MAY_FIRST);

        assertThat(newYorkPage.checkOutDate().getText()).containsSequence(MAY_LAST);

        List<WebElement> searchResultList = newYorkPage.searchCityTagInSearchResultSetOnPage();
        for (WebElement searchResult : searchResultList) {

            assertTrue(searchResult.getText().contains(CITY));
        }

        //Check days
        SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(MAY_FIRST);
        Date secondDate = sdf.parse(MAY_LAST);
        long diffInMill = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMill, TimeUnit.MILLISECONDS);
        String stringDiff = String.valueOf(diff);
        System.out.println(stringDiff);
        String textOfString = newYorkPage.spant().getText();

        assertThat(textOfString).containsSequence(stringDiff);
    }
}
