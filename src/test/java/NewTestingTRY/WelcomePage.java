package NewTestingTRY;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WelcomePage {
    public static final String SERCH_BUTTON_XPATH = "//text()[contains(.,'Search')]/ancestor::button[1]";
    public static final String CHECK_OUT_DATE_XPATH = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[5]/td[7]";
    public static final String CHECK_IN_DATE_XPATH = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[1]/td[5]";
    public static final String DATE_PICKER_NEXT_MONTH_ARROW_XPATH = "//body[@id='b2indexPage']/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/*[1]";
    public static final String CHOSE_FROM_DATE_INPUT_XPATH = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]\t";
    public static final String TARGET_DATE_XPATH = "//div[text()='May 2020']";
    private static final String CITY = "New York";
   // private WebDriver webDriver;
    WebDriver driver;


    WelcomePage(WebDriver driver) {
        this.driver=driver;
    }

    void enterCity(){
        driver.findElement(By.id("ss")).sendKeys(CITY);
    }

    void clickOnDate() {
        driver.findElement(By.xpath(CHOSE_FROM_DATE_INPUT_XPATH)).click();
        while (true){
            List<WebElement> elements = driver.findElements(By.xpath(TARGET_DATE_XPATH));
            if(elements.isEmpty()){
                driver.findElement(By.xpath(DATE_PICKER_NEXT_MONTH_ARROW_XPATH)).click();
                continue;
            }
            break;
        }
    }

    void  choiseDate(){
        findAndClick(CHECK_IN_DATE_XPATH);
        findAndClick(CHECK_OUT_DATE_XPATH);
    }

    void clickSerch(){
        //webDriver.findElement(By.xpath("//text()[contains(.,'Search')]/ancestor::button[1]")).click();
        findAndClick(SERCH_BUTTON_XPATH);
    }

    private void findAndClick(String targetEl){
        driver.findElement(By.xpath(targetEl)).click();
    }
}
