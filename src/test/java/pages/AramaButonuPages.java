package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AramaButonuPages {

    public AramaButonuPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='txtSearch']")
    public WebElement aramaButonu;

    @FindBy(xpath = "//ul[@class='products columns-3']")
    public WebElement urunlerList;

    @FindBy(xpath = "//span[@id='loading']")
    public WebElement uyariMesaji;

   @FindBy(xpath = "//div[text()='Lütfen özel karakterler girmeyiniz.']")
    public WebElement uyariMesajiPoup;



}
