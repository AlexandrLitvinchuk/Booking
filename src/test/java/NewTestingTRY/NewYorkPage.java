package NewTestingTRY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.lang.model.element.Element;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NewYorkPage {

    public static final String LIST_CITY_CLASS = "bui-link";
    public static final String CHECK_OUT_DATA_XPATH = "//div[text()='Sunday 31 May 2020']";
    public static final String CHECK_IN_DATA_XPATH = "//div[text()='Friday 1 May 2020']";
    //private WebDriver webDriver;
    WebDriver driver;

    NewYorkPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement chekInDate() {
        return driver.findElement(By.xpath(CHECK_IN_DATA_XPATH));
    }

    public WebElement checkOutDate() {
        return driver.findElement(By.xpath(CHECK_OUT_DATA_XPATH));
    }

    public WebElement spant(){return driver.findElement(By.className("sb-dates__los"));}

    public List<WebElement> searchCityTagInSearchResultSetOnPage() {
        return driver.findElements(By.className(LIST_CITY_CLASS));
    }

}















