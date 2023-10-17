package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;

public class YoutubePage {
    public void YoutubePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input#search'")
    public WebElement aramakutusu;

}
