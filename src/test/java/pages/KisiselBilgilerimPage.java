package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KisiselBilgilerimPage {

    public KisiselBilgilerimPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='hesabim-btn'])[2]")
    public WebElement hesabimButton;

    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[1]/header/div/div/div[8]/div/div[2]/div[2]/div/ul/li[1]/a")
    public WebElement kisiselBilgilerimButton;

    @FindBy(xpath = "//*[@id=\"txtAdSoyad\"]")
    public WebElement kisiselBilgilerimAdSoyad;

    @FindBy(id = " txtEmail")
    public WebElement kisiselBilgilerimEmail;

    @FindBy(xpath = "(//span[@class='checkmark'])[7]")
    public WebElement emailCheckbox;

    @FindBy(xpath = "(//span[@class='checkmark'])[8]")
    public WebElement smsCheckbox;

    @FindBy(xpath = "//button[@value='GERİ']")
    public WebElement kaydetButton;

    @FindBy(xpath = "//button[@value='ÖDEME'")
    public WebElement sifirlaButton;

    @FindBy(xpath = "//button[@value='HESABIMI SİL']")
    public WebElement hesabiSilButton;

    @FindBy(xpath = "(//div[@class='container'])[10]")
    public WebElement adresBilgisiAlani;

    @FindBy(xpath = "(//div[@class='container'])[10]")
    public WebElement kBguncellemePopUp;

    @FindBy(xpath = "(//button[@class='btn-close'])[26]")
    public WebElement kBguncellemePopUpClose;



}
