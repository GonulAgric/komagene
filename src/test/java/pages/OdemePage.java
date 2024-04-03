package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OdemePage {
    public OdemePage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*[@id=\"nav-tab\"]")
    public WebElement odemeSecenekleri;

    @FindBy(xpath = "//*[@id=\"nav-kapida-odeme-tab\"]")
    public WebElement subedeOdemeButton;

    @FindBy(xpath = "//*[@id=\"nav-online-kredi-karti-tab\"]]")
    public WebElement onlineKrediKartiButton;

}
