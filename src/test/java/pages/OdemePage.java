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

    @FindBy(xpath = "//*[@id=\"nav-online-kredi-karti-tab\"]")
    public WebElement onlineKrediKartiButton;

    @FindBy(xpath = "//input[@id='txtKartSahibiReadOnly']")
     public WebElement kartSahibiButton;

    @FindBy(xpath = "//*[@id=\"txtCardNumber1ReadOnly\"]")
    public WebElement kartNumarasiButton;

    @FindBy(xpath = "//*[@id=\"txtSonKullanmaTarihiAyReadOnly\"]")
    public WebElement kartAyButton;

    @FindBy(xpath = "//*[@id=\"txtSonKullanmaTarihiYilReadOnly\"]")
    public WebElement kartYılButton;

    @FindBy(xpath = "//*[@id=\"txtCvvReadOnly\"]")
    public WebElement kartCvvButton;

    @FindBy(xpath = "//*[@id=\"nav-online-kredi-karti\"]/div[2]/div/div[6]/div/label/span")
    public WebElement kartBilgilerimiSaklamakIstiyorumButton;

    @FindBy(xpath = "//*[@id=\"nav-online-kredi-karti\"]/div[2]/div/div[8]/div/label/span")
    public WebElement mesafeliSatisButton;

    @FindBy(xpath = "/html/body/div/div[2]")
    public WebElement paymentEkrani;

    @FindBy(xpath = "//*[@id=\"txtSiparisNotu\"]")
    public WebElement siparisNotu;

    @FindBy(xpath = "//*[@id=\"popupPagesOrderPage\"]/div/div/div[2]/div/div/div/div[2]")
    public WebElement siparisNotuUyariMesaji;

    @FindBy(xpath = "//*[@id=\"nav-online-kredi-karti\"]/div[3]/div/div[5]/div[1]/button")
    public WebElement kartBilgimiSil;

    @FindBy(xpath = "//*[@value=\"YENİ KART EKLE\"]")
    public WebElement yeniKartEkle;

    @FindBy(xpath = "//*[@class='btn btn-red d-block']")
    public WebElement kartBilgimiKaydet;

    @FindBy(xpath = "//*[@id=\"txtKartSahibi\"]")
    public WebElement yeniKartEklekartSahibi;

    @FindBy(xpath = "//*[@id=\"txtCardNumber1\"]")
    public WebElement yeniKartEklekartNumarasi;

    @FindBy(xpath = "//*[@id=\"txtSonKullanmaTarihiAy\"]")
    public WebElement yeniKartEkleAy;

    @FindBy(xpath = "//*[@id=\"txtSonKullanmaTarihiYil\"]")
    public WebElement yeniKartEkleYil;

    @FindBy(xpath = "//*[@id=\"txtCvv\"]")
    public WebElement yeniKartEkleCvv;

}
