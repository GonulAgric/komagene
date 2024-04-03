package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SikayetVeOneriPage {

    public SikayetVeOneriPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='hesabim-btn'])[2]")
    public WebElement hesabimButon;


    @FindBy(xpath = "//*[@id=\"collapse0\"]/div")
    public WebElement sikayetVeOnerilerContainer;



    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[1]/header/div/div/div[8]/div/div[2]/div[2]/div/ul/li[2]/a")
    public WebElement sikayetVeOnerilerim;


    @FindBy(xpath = "(//button[@style=\"padding: 5px;\"])[14]")
    public WebElement sikayetVeOnerilerYeniButtonu;


    @FindBy(xpath = "//*[@id=\"contactResultPopup\"]/div/div/div[2]/div/div/div/div[2]/div[1]/button")
    public WebElement kapatButtonu;


    @FindBy(xpath = "//*[@id=\"heading0\"]/button/div")
    public WebElement sonSikayet;

    @FindBy(xpath = "//*[@id=\"drpKonu\"]")
    public WebElement konuAlani;


    @FindBy(id = "txtContactPageAciklama")
    public WebElement mesajAlani;



    @FindBy(xpath = "//div[text()='Mesajınız gönderilmiştir.']")
    public WebElement yeniSikayetSuccessMesaj;





}
