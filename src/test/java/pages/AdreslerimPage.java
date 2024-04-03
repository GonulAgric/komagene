package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdreslerimPage {

    public AdreslerimPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*[@id=\"dropdownMenuButton1\"]/div")
    public WebElement hesabimButonu;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[9]")
    public WebElement adreslerimButonu;

    @FindBy(xpath = "(//*[@class='d-block w-100 b2cButon'])[7]")
    public WebElement yeniAdresBilgisiEkleButonu;

    @FindBy(xpath = "(//*[@id='txtAddressAddFormBaslik'])[1]")
    public WebElement adresBaslikButonu;

    @FindBy(xpath = "(//*[@id='drpAdresTipi'])[1]")
    public WebElement adresTipiButonu;


    @FindBy(xpath = "(//*[@id='txtAddresEditFormAd'])[1]")
    public WebElement adAlaniButonu;


    @FindBy(xpath = "(//*[@id=\"txtAddressAddFormSoyad\"])[1]")
    public WebElement SoyAdAlaniButonu;


    @FindBy(xpath = "(//*[@id='txtAddressAddFormPhoneNumber'])[1]")
    public WebElement telefonAlaniButonu;


    @FindBy(xpath = "(//*[@id='drpIl'])[2]")
    public WebElement ilDropdawn;

    @FindBy(xpath = "(//*[@id='drpDistrict'])[2]")
    public WebElement ilceDropdawn;


    @FindBy(xpath = "(//*[@id='drpMahalle'])[2]")
    public WebElement mahalleDropdawn;


    @FindBy(xpath = "(//*[@id='drpNeighbourhood'])[2]")
    public WebElement sokakDropdawn;


    @FindBy(xpath = "(//*[@id='txtBinaNo'])[1]")
    public WebElement binaNo;


    @FindBy(xpath = "(//*[@id='txtKat'])[1]")
    public WebElement katNo;


    @FindBy(xpath = "(//*[@id='txtDaireNo'])[1]")
    public WebElement daireNo;


    @FindBy(xpath = "(//*[@class='d-block w-100 b2cButon'])[5]")
    public WebElement adresBilgimiKaydetButonu;


    @FindBy(xpath = "//*[@class='inputError active']")
    public WebElement baslikAlaniHataMesaji;


    @FindBy(xpath = "(//*[@class='col-md-12'])[56]")
    public WebElement adresTipiAlaniHataMesaji;


    @FindBy(xpath = "(//*[@class='inputError active'])[1]")
    public WebElement adAlaniHataMesaji;


    @FindBy(xpath = "(//*[@id=\"addressAddForm\"]/div/div/div[2]/div/div/div/div[2]/form/div[3]/div[2]/span)[1]")
    public WebElement soyadAlaniHataMesaji;


    @FindBy(xpath = "//*[text()='Telefon alanına numara giriniz.']")
    public WebElement telefonAlaniHataMesaji;


    @FindBy(xpath = "//*[text()='Bina No alanına sadece numara,harf veya \"-\" ve \"/\"  karakteri girebilirsiniz.']")
    public WebElement binaNoAlaniHataMesaji;


    @FindBy(xpath = "(//*[@id=\"btnAdresDuzenle\"])[1]")
    public WebElement duzenleButonu;


    @FindBy(xpath = "//*[text()=\"Adres Bilgimi Güncelle\"]")
    public WebElement adresBilgimiGüncelle;


    @FindBy(xpath = "//div[@class='row addressListItem'][1]")
    public WebElement silenecekAdres;

   @FindBy(xpath = "//*[@id=\"btnAdresSil\"]")
    public WebElement silButton;



}
