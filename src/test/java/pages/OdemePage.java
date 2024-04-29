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

    @FindBy(xpath = "//*[@id=\"nav-kapida-odeme-tab\"]")
    public WebElement kapidaOdeme;

    @FindBy(xpath = "//*[@id=\"nav-kapida-odeme\"]/div[1]/div/div/select")
    public WebElement odemeYontemiDropDown;

    @FindBy(xpath = "//*[@id=\"addressChooseForm\"]/div/div/div[1]/button")
    public WebElement adresDegistirSAyfasiKapatmaButonu;

    @FindBy(xpath = "//*[@id=\"nav-kapida-odeme\"]/div[3]/div/label/span")
    public WebElement mesafeliSatisSözlesmesi;

    @FindBy(xpath = "//*[text()=\"Siparişiniz alındı.\"]")
    public WebElement siparisAlindiPopUp;

    @FindBy(xpath = "//*[@id=\"nav-kapida-odeme\"]/div[5]/div[2]/button")
    public WebElement siparisiTamamlaButton;


    @FindBy(xpath = "//*[text()=\"Lütfen ödeme yöntemi seçiniz.\"]")
    public WebElement odemeYontemiUyariMesaji;


    @FindBy(xpath = "//*[text()=\"Lütfen mesafeli satış sözleşmesini okduğunuzu belirtiniz.\"]")
    public WebElement mesafeliSatisSozlesmesiUyariMesaji;


    @FindBy(xpath = "//a[contains(text(),'Farklı bir alıcı girmek istiyorum.')]")
    public WebElement farkliBirAliciGirmekIstiyorum;


    @FindBy(xpath = "//*[@id=\"txtAliciAdiSoyadi\"]")
    public WebElement farkliBirAliciGirmekIstiyorumAdAlani;


    @FindBy(xpath = "//*[@id=\"txtAliciTelefon\"]")
    public WebElement farkliBirAliciGirmekIstiyorumTelefonAlani;


    @FindBy(xpath = "(//*[@class=\"d-block w-100 odemeGeriButonu\"])[4]")
    public WebElement farkliBirAliciGirmekIstiyorumTamamButton;


    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[2]/div[1]/div[7]")
    public WebElement sepetTutari;



    @FindBy(xpath = "(//*[text()=\"Toplam tutar, minimum sipariş tutarından küçük.\"])[1]")
    public WebElement sepetTutariUyariPoup;


    @FindBy(xpath = "//button[@value='ÖDEME']")
    public WebElement siparisVer;




}
