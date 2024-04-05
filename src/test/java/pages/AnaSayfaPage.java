package pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.awt.*;

public class AnaSayfaPage {

    public AnaSayfaPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//div[@class='owl-item active']")
    public WebElement kampanyalar;

    @FindBy(xpath= "//*[@id=\"campingSlider\"]/div[1]/div/div[4]/a/img")
    public WebElement ultraMegaDurumKampanyasiBanner;

    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article/section/div/div/ul/div/div[1]/div")
    public WebElement ultraMegaDurumKampanyasi;

    @FindBy(xpath = "//div[@class='container']")
    public WebElement kategoriConteiner;

   @FindBy(xpath = "//*[text()='AYIN ÜRÜNÜ']")
    public WebElement ayinUrunu;

   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/footer/div/div[2]/div[1]")
    public WebElement mobilUygulamaIkonları;

   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/footer/div/div[2]/div[1]/div[2]/div[1]/a/img")
    public WebElement appStoreIkon;


   @FindBy(xpath = "//*[@id=\"cookie-notice\"]/button[1]")
    public WebElement cerezPopup;


   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/footer/div/div[2]/div[1]/div[2]/div[3]/a/img")
    public WebElement googlePlay;


   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/footer/div/div[2]/div[1]/div[2]/div[5]/a/img")
    public WebElement appGallery;


    @FindBy(xpath = "(//*[@class='socialMediaIcons'])[1]")
    public WebElement ınstagram;

    @FindBy(xpath = "(//*[@class='socialMediaIcons'])[2]")
    public WebElement twitter;


    @FindBy(xpath = "(//*[@class='socialMediaIcons'])[3]")
    public WebElement facebook;


    @FindBy(xpath = "(//*[@class='socialMediaIcons'])[4]")
    public WebElement youtube;


    @FindBy(xpath = "//*[@class='col-md-2 yaziRengiBeyaz kurumsalLinkler  d-none d-sm-block']")
    public WebElement kurumsalSayfalar;



    @FindBy(xpath = "(//*[@rel='noreferrer'])[16]")
    public WebElement gizlilikSozlesmesi;

    @FindBy(xpath = "(//*[@rel='noreferrer'])[15]")
    public WebElement hakkimizda;


    @FindBy(xpath = "(//*[@rel='noreferrer'])[21]")
    public WebElement sertifiklar;


    @FindBy(xpath = "(//*[@rel='noreferrer'])[17]")
    public WebElement KvkkBilgilendirmeMetni;

   @FindBy(xpath = "(//*[@rel='noreferrer'])[22]")
    public WebElement iletisim;


   @FindBy(xpath = "(//*[@rel='noreferrer'])[18]")
    public WebElement MesafeliSatisSozlesmesi;


   @FindBy(xpath = "(//*[@rel='noreferrer'])[23]")
    public WebElement franchiseBasvuru;


   @FindBy(xpath = "(//*[@rel='noreferrer'])[20]")
    public WebElement insanKaynaklari;


   @FindBy(xpath = "(//*[@rel='noreferrer'])[19]")
    public WebElement UyelikKosullari;



   @FindBy(xpath = "//input[@id='txtContactPageAd']")
    public WebElement iletisimAdButonu;



   @FindBy(xpath = "//input[@id='txtContactPageSoyad']")
    public WebElement iletisimSoyadButonu;


   @FindBy(xpath = "//input[@id='txtContactPagePhoneNumber']")
    public WebElement iletisimTelefonButonu;



   @FindBy(xpath = "//input[@id='txtContactEmail']")
    public WebElement iletisimEmailButonu;



   @FindBy(xpath = "//select[@id='drpUlke']")
    public WebElement iletisimUlkeDrapDown;



   @FindBy(xpath = "(//*[@id=\"drpIl\"])[3]")
    public WebElement iletisimIlDrapDown;


   @FindBy(xpath = "//*[@id=\"drpIlce\"]")
    public WebElement iletisimIlceDrapDown;
//   @FindBy(xpath = "//*[@id=\"drpIlce\"]")
//    public WebElement ;


   @FindBy(xpath = "//*[@id=\"txtContactPageAciklama\"]")
    public WebElement iletisimAcıklamaAlani;



   @FindBy(xpath = "(//*[@class='checkmark'])[7]")
    public WebElement iletisimKvkkKutucugu;



   @FindBy(xpath = "(//*[@class=\"checkmark\"])[8]")
    public WebElement iletisimAcıkRizaKutucugu;



   @FindBy(xpath = "//*[text()=\"FORMU GÖNDER\"]")
    public WebElement iletisimFormuGonderButonu;


   @FindBy(xpath = "(//*[@class=\"col-md-12 text-center\"])[6]")
    public WebElement iletisimBilgilendirMesaji;


   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[1]/div/div[4]/div/div/div[1]/div[1]/span")
    public WebElement iletisimAdAlaniBosBirakilincaMesaji;



   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[1]/div/div[4]/div/div/div[1]/div[2]/span")
    public WebElement iletisimSoyAdAlaniBosBirakilincaMesaji;



   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[1]/div/div[4]/div/div/div[2]/div[1]/span")
    public WebElement iletisimTelefonAlaniBosBirakilincaMesaji;



   @FindBy(xpath = "//*[text()=\"Email alanına geçerli bir email adresi giriniz\"]")
    public WebElement iletisimEmailAlaniBosBirakilincaMesaji;




   @FindBy(xpath = "(//*[@class='w-25'])[1]")
    public WebElement kariyerNetLOgo;


   @FindBy(xpath = "(//a[@rel='noreferrer'])[2]")
    public WebElement linkedInLOgo;


   @FindBy(xpath = "//div[@class='w-100 slideicin']")
    public WebElement banner;



   @FindBy(xpath = "//*[@title='BiÇift Tatlı Menü Mobil']")
    public WebElement bannerBiCiftTatliMenu;


   @FindBy(xpath = "//*[@title='100.Yıl Kampanyası ']")
    public WebElement banneryuzuncuYıl;


   @FindBy(xpath = "//*[@id=\"drpKonu\"]")
    public WebElement konuAlani;




}
