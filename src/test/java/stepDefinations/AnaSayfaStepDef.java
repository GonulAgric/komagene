package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AnaSayfaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.junit.Assert.*;
import static utilities.ReusableMethods.*;

public class AnaSayfaStepDef {

    AnaSayfaPage anaSayfa = new AnaSayfaPage();

    @And("Kullanici ana sayfada kampanya kartlarinin görüntülendigini dogrular.")
    public void kullanici_ana_sayfada_kampanya_kartlarinin_görüntülendigini_dogrular() {
        ReusableMethods.visibleWait(anaSayfa.kampanyalar, 10);
        assertTrue("Kampanya kartları görüntülenmiyor", anaSayfa.kampanyalar.isDisplayed());

    }

    @When("Kullanici herhangi bir kampanyaya tiklar.")
    public void kullaniciHerhangiBirKampanyayaTiklar() {
        ReusableMethods.scroll(anaSayfa.ultraMegaDurumKampanyasiBanner);
        bekle(10);
        click(anaSayfa.ultraMegaDurumKampanyasiBanner);

    }

    @Then("Kullanici ilgili kampanya sayfasina yonlendirilip yonlendirilmedigini dorular.")
    public void kullaniciIlgiliKampanyaSayfasinaYonlendirilipYonlendirilmediginiDorular() {

        String currentUrl = Driver.getDriver().getCurrentUrl();
        assertTrue("Kullanıcı ilgili kampanya sayfasina yönlendirilmedi.", currentUrl.contains("gene-gelsine-ozel-ultra-mega-durum-menu-"));
    }

    @Given("Kullanici ana sayfada kategori kartlarinin  goruntulendigini dogrular.")
    public void kullaniciAnaSayfadaKategoriKartlarininGoruntulendiginiDogrular() {
        Driver.getDriver().navigate().to(ConfigReader.getProperty("url"));
        assertTrue("Kategori Kartları Görüntülenmiyor", anaSayfa.kategoriConteiner.isDisplayed());
    }

    @And("Kullanici herhangi bir kategori kartina tiklar.")
    public void kullaniciHerhangiBirKategoriKartinaTiklar() {
        ReusableMethods.scroll(anaSayfa.ayinUrunu);
        bekle(10);
        click(anaSayfa.ayinUrunu);
    }

    @Then("Kullanici ilgili kategorilere yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciIlgiliKategorilereYonlendirilipYonlendirilmediginiDogrular() {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        assertTrue("Kullanıcı ilgili kategorilere yönlendirilmedi.", currentUrl.contains("/ayin-urunu"));
    }
    @When("Kullanici ana sayfada  mobil uygulama ikonlarının goruntulendigini dogrular.")
    public void kullaniciAnaSayfadaMobilUygulamaIkonlarınınGoruntulendiginiDogrular() {
        // Ikonları beklet ve görünürlük durumunu kontrol et
        Driver.getDriver().navigate().to(ConfigReader.getProperty("url"));
        ReusableMethods.scroll(anaSayfa.mobilUygulamaIkonları);
        bekle(10);
        assertTrue("Mobil uygulama ikonları görüntülenmedi.", anaSayfa.mobilUygulamaIkonları.isDisplayed());

    }

    @When("Kullanici AppStore ikonuna tiklar.")
    public void kullaniciAppStoreIkonunaTiklar() {

            bekle(10);
            click(anaSayfa.appStoreIkon);

        }


    @Then("Kullanici ilgili sayfaya yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciIlgiliSayfayaYonlendirilipYonlendirilmediginiDogrular() {

        ReusableMethods.urlDogrulama("/us/app/komagene-gene-gelsin");
//        // Mevcut pencerenin handle'ını al
//        String mainWindowHandle = Driver.getDriver().getWindowHandle();
//
//// Yeni bir pencere açılması durumunda tüm pencere handle'larını al
//        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
//
//// Ana pencere dışındaki diğer pencereye geçiş yap
//        for (String handle : allWindowHandles) {
//            if (!handle.equals(mainWindowHandle)) {
//                Driver.getDriver().switchTo().window(handle);
//
//                assertTrue("Kullanici ilgili sayfaya yonlendirilemedi", Driver.getDriver().getCurrentUrl().contains("/us/app/komagene-gene-gelsin"));
//
//                // Pencere kapatma
//                Driver.getDriver().close();
//
//                // Ana pencereye geri dön
//                Driver.getDriver().switchTo().window(mainWindowHandle);
//            }
//        }

    }

    @When("Kullanici GooglePlay ikonuna tiklar.")
    public void kullaniciGooglePlayIkonunaTiklar() {
        click(anaSayfa.googlePlay);

    }

    @Then("Kullanici GooglePlay sayfasina yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciGooglePlaySayfasinaYonlendirilipYonlendirilmediginiDogrular() {

        // Mevcut pencerenin handle'ını al
        String mainWindowHandle = Driver.getDriver().getWindowHandle();

// Yeni bir pencere açılması durumunda tüm pencere handle'larını al
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

// Ana pencere dışındaki diğer pencereye geçiş yap
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);

                assertTrue("Kullanici ilgili sayfaya yonlendirilemedi", Driver.getDriver().getCurrentUrl().contains("store/apps/details?id=com.grows.komagene&hl=en_US"));

                // Pencere kapatma
                Driver.getDriver().close();

                // Ana pencereye geri dön
                Driver.getDriver().switchTo().window(mainWindowHandle);
            }
        }


    }

    @And("Kullanici AppGallery ikonuna tiklar.")
    public void kullaniciAppGalleryIkonunaTiklar() {
        click(anaSayfa.appGallery);

    }

    @Then("Kullanici AppGallery sayfasina yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciAppGallerySayfasinaYonlendirilipYonlendirilmediginiDogrular() {
        // Mevcut pencerenin handle'ını al
        String mainWindowHandle = Driver.getDriver().getWindowHandle();

       // Yeni bir pencere açılması durumunda tüm pencere handle'larını al
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

      // Ana pencere dışındaki diğer pencereye geçiş yap
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);

                assertTrue("Kullanici ilgili sayfaya yonlendirilemedi", Driver.getDriver().getCurrentUrl().contains("/app/C107609847"));

                // Pencere kapatma
                Driver.getDriver().close();

                // Ana pencereye geri dön
                Driver.getDriver().switchTo().window(mainWindowHandle);
            }
        }
    }

    @When("Kullanici Instagram ikonuna tiklar.")
    public void kullaniciInstagramIkonunaTiklar() {
        bekle(5);
        click(anaSayfa.ınstagram);
    }

    @Then("Kullanici Instagram sayfasina yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciInstagramSayfasinaYonlendirilipYonlendirilmediginiDogrular() {

        // Mevcut pencerenin handle'ını al
        String mainWindowHandle = Driver.getDriver().getWindowHandle();

        // Yeni bir pencere açılması durumunda tüm pencere handle'larını al
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();


        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);

                assertTrue("Kullanici ilgili sayfaya yonlendirilemedi", Driver.getDriver().getCurrentUrl().contains("instagram"));

                // Pencere kapatma
                Driver.getDriver().close();

                // Ana pencereye geri dön
                Driver.getDriver().switchTo().window(mainWindowHandle);
            }
        }
    }

    @And("Kullanici Twitter ikonuna tiklar.")
    public void kullaniciTwitterIkonunaTiklar() {
        click(anaSayfa.twitter);
    }

    @Then("Kullanici Twitter sayfasina yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciTwitterSayfasinaYonlendirilipYonlendirilmediginiDogrular() {
        // Mevcut pencerenin handle'ını al
        String mainWindowHandle = Driver.getDriver().getWindowHandle();

        // Yeni bir pencere açılması durumunda tüm pencere handle'larını al
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);

                assertTrue("Kullanici ilgili sayfaya yonlendirilemedi", Driver.getDriver().getCurrentUrl().contains("twitter"));

                // Pencere kapatma
                Driver.getDriver().close();

                // Ana pencereye geri dön
                Driver.getDriver().switchTo().window(mainWindowHandle);
            }
        }

    }

    @And("Kullanici Youtube ikonuna tiklar.")
    public void kullaniciYoutubeIkonunaTiklar() {
        click(anaSayfa.youtube);
        
    }

    @Then("Kullanici YouTube sayfasina yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciYouTubeSayfasinaYonlendirilipYonlendirilmediginiDogrular() {
        // Mevcut pencerenin handle'ını al
        String mainWindowHandle = Driver.getDriver().getWindowHandle();

        // Yeni bir pencere açılması durumunda tüm pencere handle'larını al
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);

                assertTrue("Kullanici ilgili sayfaya yonlendirilemedi", Driver.getDriver().getCurrentUrl().contains("https://www.youtube.com/"));

                // Pencere kapatma
                Driver.getDriver().close();

                // Ana pencereye geri dön
                Driver.getDriver().switchTo().window(mainWindowHandle);
            }
        }
        
    }

    @And("Kullanici Facebook ikonuna tiklar.")
    public void kullaniciFacebookIkonunaTiklar() {
        click(anaSayfa.facebook);
        
    }

    @Then("Kullanici Facebook sayfasina yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciFacebookSayfasinaYonlendirilipYonlendirilmediginiDogrular() {
    ReusableMethods.urlDogrulama("facebook");
    }

    @When("Kullanici ana sayfada kurumsal sayfalarin goruntulendigini dogrular.")
    public void kullaniciAnaSayfadaKurumsalSayfalarinGoruntulendiginiDogrular() {

        Assert.assertTrue(anaSayfa.kurumsalSayfalar.isDisplayed());
        
    }

    @And("Kullanici Gizlilik Sözleşmesi sekmesine tiklar.")
    public void kullaniciGizlilikSözleşmesiSekmesineTiklar() {
        click(anaSayfa.gizlilikSozlesmesi);
    }

    @Then("Kullanici Gizlilik Sözleşmesine yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciGizlilikSözleşmesineYonlendirilipYonlendirilmediginiDogrular() {
     ReusableMethods.urlDogrulama("\"/gizliliksozlesmesi/gizliliksozlesmesi\"");
    }

    @When("Kullanici Hakkimizda sekmesine tiklar.")
    public void kullaniciHakkimizdaSekmesineTiklar() {
        click(anaSayfa.hakkimizda);
    }

    @Then("Kullanici Hakkimizda sekmesine yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciHakkimizdaSekmesineYonlendirilipYonlendirilmediginiDogrular() {
        ReusableMethods.urlDogrulama("aboutpage");
    }

    @And("Kullanici Sertifikalar sekmesine tiklar.")
    public void kullaniciSertifikalarSekmesineTiklar() {
        click(anaSayfa.sertifiklar);

    }

    @Then("Kullanici Sertifikalar sekmasine yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciSertifikalarSekmasineYonlendirilipYonlendirilmediginiDogrular() {
        ReusableMethods.urlDogrulama("certificatepage");
    }

    @When("Kullanici Kvkk Bilgilendirme Metni sekmesine tiklar.")
    public void kullaniciKvkkBilgilendirmeMetniSekmesineTiklar() {
        click(anaSayfa.KvkkBilgilendirmeMetni);

    }

    @Then("Kullanici Kvkk Bilgilendirme Metni sekmesine yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciKvkkBilgilendirmeMetniSekmesineYonlendirilipYonlendirilmediginiDogrular() {
        ReusableMethods.urlDogrulama("/kvkk");
    }

    @And("Kullanici Mesafeli Satis Sozlesmesi sekmesine tiklar.")
    public void kullaniciMesafeliSatisSozlesmesiSekmesineTiklar() {
        click(anaSayfa.MesafeliSatisSozlesmesi);

    }
    @Then("Kullanici Mesafeli Satis Sozlesmesi sekmesine yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciMesafeliSatisSozlesmesiSekmesineYonlendirilipYonlendirilmediginiDogrular() {
        ReusableMethods.urlDogrulama("/mesafelisatissozlesmesi/mesafelisatissozlesmesi");
    }

    @And("Kullanici Uyelik kosullari sekmesine tiklar.")
    public void kullaniciUyelikKosullariSekmesineTiklar() {
        click(anaSayfa.UyelikKosullari);

    }

    @Then("Kullanici Uyelik kosullari sekmesine yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciUyelikKosullariSekmesineYonlendirilipYonlendirilmediginiDogrular() {
        ReusableMethods.urlDogrulama("/uyelikkosullari/uyelikkosullari");

    }

    @And("Kullanici Insan Kaynaklari sekmesine tiklar.")
    public void kullaniciInsanKaynaklariSekmesineTiklar() {
        click(anaSayfa.insanKaynaklari);

    }

    @Then("Kullanici Insan Kaynaklari sekmesine yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciInsanKaynaklariSekmesineYonlendirilipYonlendirilmediginiDogrular() {
        ReusableMethods.urlDogrulama("/humanresourcepage");
    }

    @And("Kullanici Franchise sekmesine tiklar.")
    public void kullaniciFranchiseSekmesineTiklar() {
        click(anaSayfa.franchiseBasvuru);
    }

    @Then("Kullanici Franchise sekmesine sekmesine yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciFranchiseSekmesineSekmesineYonlendirilipYonlendirilmediginiDogrular() {
        ReusableMethods.urlDogrulama("/franchisebasvurusu");

    }

    @And("Kullanici Iletisim sekmesine tiklar.")
    public void kullaniciIletisimSekmesineTiklar() {
        click(anaSayfa.iletisim);

    }

    @Then("Kullanici Iletisim sekmesine sekmesine yonlendirilip yonlendirilmedigini dogrular.")
    public void kullaniciIletisimSekmesineSekmesineYonlendirilipYonlendirilmediginiDogrular() {
        ReusableMethods.urlDogrulama("contactpage");
    }

    @Given("Kullanici anasayfada  iletisim sekmesine tiklar.")
    public void kullaniciAnasayfadaIletisimSekmesineTiklar() {
        click(anaSayfa.iletisim);

    }

    @When("Acılan sayfada istek ve oneri formunun zorunlu alanlarina valid degerler girer.")
    public void acılanSayfadaIstekVeOneriFormununZorunluAlanlarinaValidDegerlerGirer() {
        anaSayfa.iletisimAdButonu.sendKeys("Gonul");
        anaSayfa.iletisimSoyadButonu.sendKeys("Agrıc");
        bekle(3);
        click(anaSayfa.iletisimTelefonButonu);
        anaSayfa.iletisimTelefonButonu.sendKeys("5461127610");
        anaSayfa.iletisimEmailButonu.sendKeys("agrc.gnl@gmail.com");
        bekle(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
      // Ülke dropdown'ı tıklanabilir olana kadar bekle
        WebElement ulkeDropdown = wait.until(ExpectedConditions.elementToBeClickable(anaSayfa.iletisimUlkeDrapDown));
        click(ulkeDropdown);

        WebElement ilDropdown = wait.until(ExpectedConditions.elementToBeClickable(anaSayfa.iletisimIlDrapDown));
        click(ilDropdown);
        ReusableMethods.ddmIndex(anaSayfa.iletisimIlDrapDown,2);
        bekle(3);
        ddmIndex(anaSayfa.iletisimIlceDrapDown,2);

        anaSayfa.iletisimAcıklamaAlani.sendKeys("Test");

    }

    @And("Kvkk bilgi formunu okudum onayliyorum kutucugunu isaretler.")
    public void kvkkBilgiFormunuOkudumOnayliyorumKutucugunuIsaretler() {
        bekle(2);
    click(anaSayfa.iletisimKvkkKutucugu);
    }

    @And("Acik riza metnini okudum onayliyorum kutucugunu isaretler.")
    public void acikRizaMetniniOkudumOnayliyorumKutucugunuIsaretler() {
        bekle(2);
        click(anaSayfa.iletisimAcıkRizaKutucugu);

    }

    @And("Kullanici formu gonder butonuna tiklar.")
    public void kullaniciFormuGonderButonunaTiklar() {
        bekle(3);
        anaSayfa.iletisimFormuGonderButonu.click();

    }

    @Then("Formu gonderdigine dair bilgilendirme mesajı alir.")
    public void formuGonderdigineDairBilgilendirmeMesajıAlir() {
        bekle(3);
        String beklenenMesaj= "Mesajınız gönderilmiştir.\n" +
                "En kısa zamanda size yanıt verilecektir.\n" +
                "\n" +
                "Komagene' ye ilginiz için teşekkür ederiz.\n" +
                "\n" +
                "Komagene Müşteri Hizmetleri";
        String actualMesaj = anaSayfa.iletisimBilgilendirMesaji.getText();
        assertEquals(beklenenMesaj,actualMesaj);

    }


    @When("Ad alanina {string} girilir.")
    public void adAlaninaGirilir(String string) {
        anaSayfa.iletisimAdButonu.sendKeys(string);

    }

    @Then("{string} goruntulenir")
    public void goruntulenir(String string) {
        assertTrue(anaSayfa.iletisimAdAlaniBosBirakilincaMesaji.getText().contains(string));
    }

    @When("Soyad alanina {string} girilir.")
    public void soyadAlaninaGirilir(String string) {
        anaSayfa.iletisimSoyadButonu.sendKeys(string);
        
    }

    @Then("Soyad alaninda {string} goruntulenir")
    public void soyadAlanindaGoruntulenir(String string) {
        assertTrue(anaSayfa.iletisimSoyAdAlaniBosBirakilincaMesaji.getText().contains(string));
    }

    @When("Telefon alanina {string} girilir.")
    public void telefonAlaninaGirilir(String string) {
        bekle(3);
        click(anaSayfa.iletisimTelefonButonu);
        anaSayfa.iletisimTelefonButonu.sendKeys(string);

    }

    @Then("Telefon alaninda {string} goruntulenir")
    public void telefonAlanindaGoruntulenir(String string) {
        assertTrue(anaSayfa.iletisimTelefonAlaniBosBirakilincaMesaji.getText().contains(string));
    }

    @When("Email alanina {string} girilir.")
    public void emailAlaninaGirilir(String string) {
        anaSayfa.iletisimEmailButonu.sendKeys(string);
    }

    @Then("Email alaninda {string} goruntulenir")
    public void emailAlanindaGoruntulenir(String string) {
        assertTrue(anaSayfa.iletisimEmailAlaniBosBirakilincaMesaji.getText().contains(string));
    }

    @When("Adiniz Soyadiniz alanina gecerli veri girer.")
    public void adinizSoyadinizAlaninaGecerliVeriGirer() {
        anaSayfa.iletisimAdButonu.sendKeys("Gonul");
        anaSayfa.iletisimSoyadButonu.sendKeys("Agrıc");
    }

    @And("Email alanina gecerli veri girer.")
    public void emailAlaninaGecerliVeriGirer() {
        anaSayfa.iletisimEmailButonu.sendKeys("agrc.gnl@gmail.com");

    }

    @And("Cep Telefonu alanina gecerli veri girer.")
    public void cepTelefonuAlaninaGecerliVeriGirer() {
        click(anaSayfa.iletisimTelefonButonu);
        anaSayfa.iletisimTelefonButonu.sendKeys("5461127610");
        bekle(2);

    }

    @And("Ulke alanini degistirir.")
    public void ulkeAlaniniDegistirir() {
      ReusableMethods.ddmIndex(anaSayfa.iletisimUlkeDrapDown,3);
      bekle(3);

    }

    @And("Il alanina veri girer.")
    public void ılAlaninaVeriGirer() {
        ReusableMethods.ddmIndex(anaSayfa.iletisimIlDrapDown,1);
        bekle(3);
    }

    @And("Ilce alanina veri girer.")
    public void ılceAlaninaVeriGirer() {
        ddmIndex(anaSayfa.iletisimIlceDrapDown,1);

    }

    @And("Aciklama alanina veri girer")
    public void aciklamaAlaninaVeriGirer() {
        bekle(2);
        anaSayfa.iletisimAcıklamaAlani.sendKeys("Test");
    }

    @When("Kariyer.net logosuna tiklar.")
    public void kariyerNetLogosunaTiklar() {
        click(anaSayfa.kariyerNetLOgo);
        
    }

    @And("Kariyer.net sayfasina yonlendirilir.")
    public void kariyerNetSayfasinaYonlendirilir() {

        assertTrue("Kullanici ilgili sayfaya yonlendirilemedi", Driver.getDriver().getCurrentUrl().contains("kariyer.net"));
        bekle(5);
           Driver.getDriver().navigate().back();

        }

    @When("Linked In logosuna tiklar.")
    public void linkedInLogosunaTiklar() {
        bekle(5);
        click(anaSayfa.linkedInLOgo);
        
    }

    @And("Linked In sayfasina yonlendirilir.")
    public void linkedInSayfasinaYonlendirilir() {
    ReusableMethods.urlDogrulama("linkedin");
    }

    @Given("Anasayfada banner {string} goruntulenir")
    public void anasayfadaBannerGoruntulenir(String bannerElement ) {
        ReusableMethods.getBannerElement(bannerElement);
    }

    @When("Banner kaydirilabilir")
    public void bannerKaydirilabilir() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(300, 0);
        actions.perform();
        anaSayfa.banner.click();
        
    }

    @Then("Banner tiklanabilir ve ilgili sayfaya yonlendirilir")
    public void bannerTiklanabilirVeIlgiliSayfayaYonlendirilir() {
    }
}

