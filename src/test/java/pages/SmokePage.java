package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SmokePage {

    public SmokePage() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "(//div[@class='hesabim-btn'])[2]")
    public WebElement hesabim;

    @FindBy(xpath = "//*[@id=\"yazi\"]")
    public WebElement adresSecimAlani;

    @FindBy(id = "addressListItem74075")
    public WebElement kayitliAdreslerimTest ;


   @FindBy(id = "branchX1717")
    public WebElement tugayYoluSube ;

   @FindBy(id = "branchX3037")
    public WebElement maltepaBaglarbasiSube ;

   @FindBy(id = "branchX1665")
    public WebElement maltepaMeydanSube ;

   @FindBy(xpath = "//*[@id=\"addressChooseForm\"]/div/div/div[2]/div/div/div[4]/div[2]/button")
    public WebElement seciliAdresleDevam ;

   @FindBy(xpath = "//*[@id=\"campingSlider\"]/div[1]/div/div[6]/a/img")
    public WebElement biCiftTatliMenu ;

  @FindBy(xpath = "(//*[@class='w-100 img-fluid'])[1]")
    public WebElement ikiliDurumMenu ;

  @FindBy(xpath = "(//*[@class='d-block w-100'])[1]")
    public WebElement AciSecimi ;

  @FindBy(xpath= "(//div[@type='button'])[6]")
    public WebElement doritosSecimi ;

  @FindBy(xpath = "(//*[@type='radio'])[5]")
    public WebElement extraMalzemeIstemiyorum ;

  @FindBy(xpath = "(//div[@type='button'])[7]")
    public WebElement lavasSecimi ;

  @FindBy(xpath = "(//*[@type='radio'])[8]")
    public WebElement extraLavasIstemiyorum ;

  @FindBy(xpath = "(//*[@class='labelCheckBox'])[1]")
    public WebElement garniturSecimi ;

  @FindBy(xpath = "(//*[@class='labelCheckBox'])[24]")
    public WebElement sosSecimi ;

  @FindBy(xpath = "(//*[@class='d-block w-100'])[4]")
    public WebElement ikinciAciSecimi ;

  @FindBy(xpath = "(//div[@type='button'])[9]")
    public WebElement ikincidoritosSecimi ;

  @FindBy(xpath = "(//*[@type='radio'])[14]")
    public WebElement ikinciextraMalzemeIstemiyorum ;

  @FindBy(xpath = "(//div[@type='button'])[10]")
    public WebElement ikinciLavasSecimi ;

  @FindBy(xpath = "(//*[@type='radio'])[17]")
    public WebElement ikinciLavasIstemiyorum ;

  @FindBy(xpath = "(//*[@class='labelCheckBox'])[31]")
    public WebElement ikinciGarniturSecimi ;

  @FindBy(xpath = "(//*[@class='labelCheckBox'])[54]")
    public WebElement ikinciSosSecimi ;

  @FindBy(xpath = "(//div[@type='button'])[11]")
    public WebElement icecekSecimi ;

  @FindBy(xpath = "(//*[@type='radio'])[19]")
    public WebElement komageneAyran ;

  @FindBy(xpath = "(//div[@type='button'])[12]")
    public WebElement ikinciicecekSecimi ;

  @FindBy(xpath = "(//*[@type='radio'])[27]")
    public WebElement ikinciAyran ;

  @FindBy(xpath = "(//div[@type='button'])[13]")
    public WebElement pepsiPromosyonSecimi ;

  @FindBy(xpath = "(//*[@type='radio'])[35]")
    public WebElement pepsiPromosyonIstemiyorum ;

  @FindBy(xpath = "(//div[@type='button'])[14]")
    public WebElement redbullPromosyonSecimi ;

  @FindBy(xpath = "(//*[@type='radio'])[38]")
    public WebElement redbullPromosyonIstemiyorum ;

  @FindBy(id = "btnSepeteEkle")
    public WebElement sepeteEkleButtonu ;

  @FindBy(xpath = "(//*[@class='card-img-center d-block w-100'])[3]")
    public WebElement durumler ;

  @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[1]/section/div[2]/div/div[1]/div[1]/div/img")
    public WebElement CigKoftedurum ;

  @FindBy(xpath = "(//*[@class='d-block w-100'])[1]")
    public WebElement CigKoftedurumAcıSecimi ;

 @FindBy(xpath = "(//div[@type='button'])[5]")
    public WebElement CigKoftedurumDoritosSecimi ;

 @FindBy(xpath = "(//*[@type='radio'])[4]")
    public WebElement CigKoftedurumextraMalzemeIstemiyorum ;

  @FindBy(xpath = "//*[@id=\"main-wrapper\"]/section[4]/div/div/div[16]/div/div[1]/img")
    public WebElement tatli ;

  @FindBy(xpath = "//*[@id=\"divAcilirRadyoKutuListesif9254b59-dbd9-4ade-784c-fce19628f11e\"]")
    public WebElement tatliPepsi ;

  @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/section/div/div[3]/div[1]/div[3]/div[1]/div/div[1]/div/div[3]")
    public WebElement adetArttır ;

  @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[1]/section/div[2]/div/div[1]/div[1]/div/img")
    public WebElement irmikTatlisi ;

   @FindBy(xpath = "//*[@id=\"drprd**9fe9e108-00cd-44c8-600d-78a90d62d551**1\"]")
    public WebElement PepsiPromosyonIstemiyorum ;

   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/section[4]/div/div/div[14]/div/div[1]/img")
    public WebElement dondurmalar ;


   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[1]/section/div[2]/div/div[15]/div[1]/div/img")
    public WebElement magnum ;

   @FindBy(xpath = "(//*[@id=\"dropdownMenuButton1\"])[3]")
    public WebElement sepetim ;

   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/section/div/div[2]/div[1]/div[3]/div[1]/div/div[1]/div/div[3]")
    public WebElement magnumAdetArt ;

   @FindBy(xpath = "(//*[@class='checkmark'])[8]")
    public WebElement odemeTeslimatTuru;

   @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/div/div/div[2]/div[1]/div[8]/div[2]/button")
    public WebElement siparisVer ;

   @FindBy(xpath = "//*[@id=\"nav-online-kredi-karti\"]/div[1]/div/label/span")
    public WebElement saklıKArtBilgilerimiKul ;

   @FindBy(xpath = "//*[@id=\"drpMyCard\"]")
    public WebElement odemeKArtıDropdown ;


   @FindBy(xpath = "//*[@id=\"nav-online-kredi-karti\"]/div[3]/div/div[3]/div/label/span")
    public WebElement mesafeliSatış ;


   @FindBy(xpath = "//*[@id=\"nav-online-kredi-karti\"]/div[5]/div[2]/button")
    public WebElement siparisiTamamla ;

   @FindBy(xpath = "//*[@id='passwordfield']")
    public WebElement odemeDogrulama ;

   @FindBy(xpath = "//*[@id=\"submitbutton\"]")
    public WebElement odemeOnaylama ;


}
