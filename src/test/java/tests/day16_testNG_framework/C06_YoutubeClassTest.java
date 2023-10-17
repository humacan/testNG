package tests.day16_testNG_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.Driver;

public class C06_YoutubeClassTest {
    @Test
    public void youtubeTest(){
        //System.setProperty("Webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        Driver.getDriver().get("https://www.youtube.com");

        //YoutubePage youtubePage=new YoutubePage();
        //aramakutusu.click();
        WebElement arama=driver.findElement(By.tagName("#search.ytd-searchbox"));
        //youtubePage.aramakutusu.sendKeys("total war attila");
        arama.click();
        arama.sendKeys("total war attila"+ Keys.ENTER);

    }
}
