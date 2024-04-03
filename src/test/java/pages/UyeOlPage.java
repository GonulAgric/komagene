package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UyeOlPage {

   public UyeOlPage() {
       PageFactory.initElements(Driver.getDriver(), this);
   }

   @FindBy(xpath = "(//div[@class='hesabim-btn'])[2]")
       public WebElement uyeolButton;

   @FindBy(xpath = "//*[@id=\"phnNumber\"]")
       public WebElement phoneNumber;

   @FindBy(xpath = "//*[@id=\"registerForm\"]/div/div/div[2]/div[1]/div/div[2]/div[1]/input")
       public WebElement ad;

   @FindBy(xpath = "//*[@id=\"registerForm\"]/div/div/div[2]/div[1]/div/div[2]/div[2]/input")
       public WebElement soyad;

   @FindBy(xpath="//*[@id=\"registerForm\"]/div/div/div[2]/div[1]/div/div[4]/div/input")
       public WebElement mail;

   @FindBy(xpath="//*[@id=\"phoneEntryForm\"]/div/div/div[2]/div[3]/div[2]/button")
       public WebElement girisYap;

   @FindBy(xpath="//*[@id=\"registerForm\"]/div/div/div[2]/div[3]/div/div/label/span")
       public WebElement kvkkcheckbox;

   @FindBy(xpath = "//*[@id=\"registerForm\"]/div/div/div[2]/div[3]/div/div/a")
       public WebElement kvkkMetni;

   @FindBy(xpath="//*[@id=\"registerForm\"]/div/div/div[2]/div[4]/div/div/label/span")
       public WebElement üyelikKosullariCheckBox;

   @FindBy(xpath="//*[@id=\"btnSmsLogin\"]")
       public WebElement girisYapAllert;

@FindBy(xpath="//*[@id=\"phoneCode1\"]")
       public WebElement allertKodGiris;

   @FindBy(xpath="//*[@id=\"registerForm\"]/div/div/div[2]/div[5]/div/div/label/span")
       public WebElement gizlilikSözleşmesiCheckBox;

  @FindBy(xpath="//*[@id=\"registerForm\"]/div/div/div[2]/div[7]/div[2]/button")
       public WebElement üyeligiTamamlaButton;

  @FindBy(xpath="//*[@id=\"kvkkMetni\"]/div/div/div[2]/div/div/div/button")
       public WebElement kapatButton;

  @FindBy(xpath="//*[@id=\"phoneCodeEntryForm\"]")
       public WebElement alert;

    @FindBy(xpath = "//*[@id=\"phoneCode1\"]")
    public WebElement dogrulama;

    @FindBy(xpath = "//*[@id=\"yeniuyewarning\"]/div/div/div[2]/div/div/div/div[2]/div/h3")
    public WebElement hoşgeldinizPopUp;

 @FindBy(xpath = "//*[@id=\"yeniuyewarning\"]/div/div/div[2]/div/div/div/div[4]/div/button")
    public WebElement anasayfayaDön;

    @FindBy(xpath = "(//span[@aria-live='polite'])[4]")
    public WebElement adBosBirakilincaUyariMesaji;

    @FindBy(xpath = "(//span[@aria-live='polite'])[5]")
    public WebElement soyadBosBirakilincaUyariMesaji;

    @FindBy(xpath = "(//span[@aria-live='polite'])[6]")
    public WebElement emailBosBirakilincaUyariMesaji;

    @FindBy(xpath = "(//div[@class='row'])[36]")
    public WebElement telNoUyariMesaji;

    @FindBy(xpath = "(//div[@class='col-md-12'])[19]")
    public WebElement KVKKhataMesaji;

    @FindBy(xpath = "//*[@id=\"cookie-notice\"]")
    public WebElement cerezPolitikasıPopUp;

    @FindBy(xpath = "//*[@id=\"cookie-notice\"]/button[1]")
    public WebElement cerezPolitikasıPopUpTamam;
}
