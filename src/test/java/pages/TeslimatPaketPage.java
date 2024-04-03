package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TeslimatPaketPage {

    public TeslimatPaketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[1]/section/div[1]/div/div[1]/div[1]")
    public WebElement teslimatTuru;

    @FindBy(xpath = "//*[@id=\"deliveryTypeChooseForm\"]/div/div/div[2]/div/div[2]/div[1]/div/div[2]")
    public WebElement teslimatTuruPaket;

    @FindBy(xpath = "//*[@class=\"d-block w-100 popupButon\"]")
    public WebElement seciliTeslimatTürüIleDevamEt;


    @FindBy(xpath = "//*[@id=\"popupAddressChooseForm\"]/div/div/div[2]/div/div/div/div[2]/div[1]")
    public WebElement seciliSubeKapaliAlert;

   @FindBy(xpath = "//*[@id=\"popupAddressChooseForm\"]/div/div/div[2]/div/div/div/div[2]")
    public WebElement seciliSubePaketAlert;


}
