package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SepetimPage {

    public SepetimPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//div[@class='modal-content']")
    public WebElement sepeteYonlendirmePopUp;

    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[1]/div[1]/div/div[4]/div[2]")
    public WebElement siparisDetay;

    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/button")
    public WebElement sepetteUrunIptal;

    @FindBy(xpath = "//*[@id=\"popupBasketDetailLeft\"]/div/div/div[2]/div/div/div/div[2]")
    public WebElement sepetteUrunIptalPopUp;

    @FindBy(xpath = "//*[@id=\"0bodyMain\"]/div[1]/div[4]/div[2]/label/img")
    public WebElement sepetteOpsiyonDegisim;

    @FindBy(xpath = "//*[@id=\"opsiyonEditForm\"]/div/div/div[2]/div/div/div[2]/div/button")
    public WebElement degisiklikleriKaydet;



    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[2]/div[1]/div[5]/div[2]")
    public WebElement baslangicSepetTutari;


    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[2]/div[1]/div[7]/div[2]")
    public WebElement yeniSepetTutari;


    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[2]/div[1]/div[2]")
    public WebElement teslimatTuru;


    @FindBy(xpath = "//label[contains(text(), 'Gel Al')]/input")
    public WebElement teslimatTuruGelAl;


    @FindBy(xpath = "//label[contains(text(), 'Paket Servis')]/input")
    public WebElement teslimatTuruPaket;


    @FindBy(xpath = "//*[@id=\"popupConfirmSepetTuruDegisimi\"]/div/div/div[2]/div/div/div/div[2]")
    public WebElement teslimatTuruDegisiklikAlert;


    @FindBy(xpath = "//*[@id=\"popupConfirmSepetTuruDegisimi\"]/div/div/div[2]/div/div/div/div[2]/div[3]/div[1]/button")
    public WebElement teslimatTuruDegisiklikAlertEvet;


    @FindBy(xpath = "//*[@id=\"tabOdemeEkrani\"]")
    public WebElement odemeSayfasi;


    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[2]/div/div[3]")
    public WebElement sepetteAdetArttirma;


    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[2]/div/div[1]")
    public WebElement sepetteAdetAzaltma;


    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[2]/div/div[2]")
    public WebElement sepetteBaslangicAdetSayisi;



    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[2]/div/div[2]")
    public WebElement sepetteYeniAdetSayisi;


    @FindBy(xpath = "(//div[contains(text(), 'Miktar 1 den küçük olamaz')])[1]")
    public WebElement urunSayisiAzaltmaPopUp;


    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[1]")
    public WebElement sepetUrun;




}
