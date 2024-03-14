package stepDefinations;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.KisiselBilgilerimPage;
import utilities.ReusableMethods;
import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;

public class KisiselBilgilerimStepDef {

    KisiselBilgilerimPage kisiselBilgilerimPage = new KisiselBilgilerimPage();
    Faker faker = new Faker();

    @When("Kullanıcı hesabım butonuna tıklar.")
    public void kullanıcı_hesabım_butonuna_tıklar() {
        bekle(3);
        click(kisiselBilgilerimPage.hesabimButton);
        bekle(2);
    }

    @And("Acılan dropdown menüden kişisel bilgilerime tıklar.")
    public void acılan_dropdown_menüden_kişisel_bilgilerime_tıklar() {
        click(kisiselBilgilerimPage.kisiselBilgilerimButton);
    }

    @Then("Kişisel Bilgilerim'in  geldiğini dogrular.")
    public void kişisel_bilgilerim_in_geldiğini_dogrular() {
        bekle(5);
        String adSoyadAlani = kisiselBilgilerimPage.kisiselBilgilerimAdSoyad.getText();
        bekle(10);
        System.out.println("adSoyadAlani = " + adSoyadAlani);
        Assert.assertTrue(adSoyadAlani.isEmpty());

    }

    @When("Kullanıcı {string} butonuna veri girer.")
    public void kullanıcıButonunaVeriGirer(String string) {
        bekle(2);
        kisiselBilgilerimPage.kisiselBilgilerimAdSoyad.click();
        kisiselBilgilerimPage.kisiselBilgilerimAdSoyad.clear();
        bekle(2);
        kisiselBilgilerimPage.kisiselBilgilerimAdSoyad.sendKeys(string);
        click(kisiselBilgilerimPage.kaydetButton);
        bekle(2);
    }

    @Then("Ad Soyad alani {string} görüntülenir")
    public void ad_soyad_alani_görüntülenir(String string) {
        bekle(10);
        ReusableMethods.windowHandle();
        Assert.assertTrue(kisiselBilgilerimPage.kBguncellemePopUp.getText().contains(string));
        bekle(5);
        click(kisiselBilgilerimPage.kBguncellemePopUpClose);

    }

    @When("Email de degisiklik yapar.")
    public void emailDeDegisiklikYapar() {
        click(kisiselBilgilerimPage.kisiselBilgilerimEmail);
        kisiselBilgilerimPage.kisiselBilgilerimEmail.clear();
        kisiselBilgilerimPage.kisiselBilgilerimEmail.sendKeys(faker.internet().emailAddress());
        click(kisiselBilgilerimPage.kaydetButton);

    }

    @Then("Degisiklik yaptigini dogrular.")
    public void degisiklikYaptiginiDogrular() {
        bekle(10);
        Assert.assertTrue(kisiselBilgilerimPage.kBguncellemePopUp.getText().contains("Profil bilgileriniz başarılı bir şekilde güncellendi."));
    }

    @When("İletişim tercıhlerımden E-Posta kutusunu işaretler")
    public void iletişimTercıhlerımdenEPostaKutusunuIşaretler() {
        kisiselBilgilerimPage.emailCheckbox.click();

    }

    @And("Kullanıcı kaydet butonuna tıklar.")
    public void kullanıcıKaydetButonunaTıklar() {
        bekle(5);
        click(kisiselBilgilerimPage.kaydetButton);
    }

    @Then("Iletisim tercihi dogrulamasini yapar.")
    public void ıletisimTercihiDogrulamasiniYapar() {
        bekle(10);
        Assert.assertTrue(kisiselBilgilerimPage.kBguncellemePopUp.getText().contains("Profil bilgileriniz başarılı bir şekilde güncellendi."));
    }


    @When("Kullanici Ad soyad butonunu bos birakir")
    public void kullaniciAdSoyadButonunuBosBirakir() {
        bekle(5);
        kisiselBilgilerimPage.kisiselBilgilerimAdSoyad.clear();
        bekle(5);
        kisiselBilgilerimPage.kisiselBilgilerimAdSoyad.sendKeys("");
        
    }

    @Then("Kullanici uyari mesaji almali")
    public void kullaniciUyariMesajiAlmali() {
        bekle(10);
       Assert.assertTrue(kisiselBilgilerimPage.uyariMesaji.getText().contains("Ad Soyad alanına özel karakter girmeyiniz."));

    }

    @When("Kullanici Ad soyad butonuna sinirsiz karakter girer")
    public void kullaniciAdSoyadButonunaSinirsizKarakterGirer() {
        kisiselBilgilerimPage.kisiselBilgilerimAdSoyad.clear();
        kisiselBilgilerimPage.kisiselBilgilerimAdSoyad.sendKeys("aaaaaaaaaadddddddddd");

    }


    @Then("Kullanici uyari mesajini almali")
    public void kullaniciUyariMesajiniAlmali() {
        bekle(10);
        Assert.assertTrue(kisiselBilgilerimPage.kBguncellemePopUp.getText().contains("Profil bilgileriniz başarılı bir şekilde güncellendi."));
    }

    @When("Kullanici email alanini bos birakir")
    public void kullaniciEmailAlaniniBosBirakir() {
        bekle(5);
        kisiselBilgilerimPage.kisiselBilgilerimEmail.clear();
        bekle(3);
        kisiselBilgilerimPage.kisiselBilgilerimEmail.sendKeys("");
    }

    @Then("Kullanici uyarı mesaji almalı")
    public void kullaniciUyarıMesajiAlmalı() {
        bekle(5);
        Assert.assertTrue(kisiselBilgilerimPage.uyariMesaji.getText().contains("Email alanına geçerli bir email adresi giriniz"));
    }

    @When("Kullanici format disi bir email girer")
    public void kullaniciFormatDisiBirEmailGirer() {
        kisiselBilgilerimPage.kisiselBilgilerimEmail.clear();
        kisiselBilgilerimPage.kisiselBilgilerimEmail.sendKeys("ayse.armagmail.com");
    }

    @Given("Kayitli adreslerin otomatik geldigini gorur.")
    public void kayitliAdreslerinOtomatikGeldiginiGorur() {
        boolean adreslerGeldiMi = kisiselBilgilerimPage.adreslerContainer.isDisplayed();
        Assert.assertTrue("Kayıtlı adreslerin otomatik olarak geldiği görülmeli", adreslerGeldiMi);
    }

    @Given("Kullanici adres ekle butonuna tiklar.")
    public void kullaniciAdresEkleButonunaTiklar() {
        bekle(5);
        click(kisiselBilgilerimPage.adresEkle);
    }

    @When("Kullanici adres sayfasinin geldigini dogrular.")
    public void kullaniciAdresSayfasininGeldiginiDogrular() {
        bekle(10);
        Assert.assertTrue("Adres sayfası görünmüyor.", kisiselBilgilerimPage.adresForm.isDisplayed());

    }
}

