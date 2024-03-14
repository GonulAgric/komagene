package stepDefinations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AdreslerimPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;

public class AdresStepDef {
    AdreslerimPage adresEkleme = new AdreslerimPage();

    @When("Acilan dropdown menuden adreslerime tiklar.")
    public void acilanDropdownMenudenAdreslerimeTiklar() {
        bekle(2);
        adresEkleme.adreslerimButonu.click();
    }


    @When("Kullanici Yeni Adres Ekle butonuna tiklar")
    public void kullaniciYeniAdresEkleButonunaTiklar() {
        ReusableMethods.visibleWait(adresEkleme.yeniAdresBilgisiEkleButonu, 5);
        click(adresEkleme.yeniAdresBilgisiEkleButonu);

    }

    @And("Kullanici baslik butonunu doldurur.")
    public void kullaniciBaslikButonunuDoldurur() {
        adresEkleme.adresBaslikButonu.sendKeys("test");

    }

    @And("Kullanici adres tipi butonunu doldurur.")
    public void kullaniciAdresTipiButonunuDoldurur() {
        ReusableMethods.ddmIndex(adresEkleme.adresTipiButonu, 1);

    }

    @When("Kullanici ad  butonunu doldurur.")
    public void kullaniciAdButonunuDoldurur() {
        adresEkleme.adAlaniButonu.sendKeys("Gönül");

    }

    @And("Kullanici soyad butonunu doldurur.")
    public void kullaniciSoyadButonunuDoldurur() {
        adresEkleme.SoyAdAlaniButonu.sendKeys("Ağrıç");
    }

    @And("Kullanici telefon alanini doldurur.")
    public void kullaniciTelefonAlaniniDoldurur() {
        adresEkleme.telefonAlaniButonu.sendKeys("5551126589");

    }

    @And("Kullanici il secer.")
    public void kullaniciIlSecer() {
        bekle(2);
        ReusableMethods.ddmIndex(adresEkleme.ilDropdawn, 1);

    }

    @And("Kullanici ilce secer.")
    public void kullaniciIlceSecer() {
        bekle(4);
        ReusableMethods.ddmIndex(adresEkleme.ilceDropdawn, 2);

    }

    @And("Kullanici mahalle secer.")
    public void kullaniciMahalleSecer() {
        bekle(4);
        ReusableMethods.ddmIndex(adresEkleme.mahalleDropdawn, 3);

    }

    @And("Kullanici sokak secer.")
    public void kullaniciSokakSecer() {
        bekle(5);
        ReusableMethods.ddmIndex(adresEkleme.sokakDropdawn, 3);
    }

    @And("Kullanici bina no alanini doldurur.")
    public void kullaniciBinaNoAlaniniDoldurur() {
        bekle(2);
        adresEkleme.binaNo.sendKeys("1");

    }

    @And("Kullanici kat alanini doldurur.")
    public void kullaniciKatAlaniniDoldurur() {
        adresEkleme.katNo.sendKeys("2");
    }

    @And("Kullanici daire no alanini doldurur.")
    public void kullaniciDaireNoAlaniniDoldurur() {
        adresEkleme.daireNo.sendKeys("5");

    }

    @And("Kullanici Adres bilgimi kaydet butonuna tıklar")
    public void kullaniciAdresBilgimiKaydetButonunaTıklar() {

        adresEkleme.adresBilgimiKaydetButonu.click();
    }

    @Then("Kullanici yeni adresin listelendigini dogrular.")
    public void kullaniciYeniAdresinListelendiginiDogrular() {
    }


    @And("Başlik alanini boş birakir.")
    public void başlikAlaniniBoşBirakir() {
        bekle(5);
        adresEkleme.adresBaslikButonu.sendKeys(" ");

    }

    @Then("Kullanici uyari mesaji almali.")
    public void kullaniciUyariMesajiAlmali() {
        bekle(3);
        adresEkleme.adresBaslikButonu.click();
        String actualMesaj = adresEkleme.baslikAlaniHataMesaji.getText();
        String expectedMesaj = "Başlık minimum 2, maksimum 100 karakter olması gerekiyor; girdiğiniz karekter sayısı 1.";

        Assert.assertEquals(expectedMesaj, actualMesaj);
    }

    @And("Adres tipi alanini boş birakir.")
    public void adresTipiAlaniniBoşBirakir() {

    }

    @Then("Kullanici uyari mesaji alir.")
    public void kullaniciUyariMesajiAlir() {
        bekle(3);
        String actualMesaj = adresEkleme.adresTipiAlaniHataMesaji.getText();
        String expectedMesaj = "Lütfen adres tipi seçiniz.";
        bekle(5);
        Assert.assertEquals(expectedMesaj,actualMesaj);
    }

    @Given("Ad butonuna {string} girilir")
    public void adButonunaGirilir(String string) {
        adresEkleme.adAlaniButonu.sendKeys(string);

    }

    @Then("Ve {string} görüntülenir")
    public void veGörüntülenir(String string) {
        adresEkleme.adAlaniHataMesaji.sendKeys(string);
    }

    @And("Soyad butonuna {string} girilir")
    public void soyadButonunaGirilir(String string) {
        adresEkleme.SoyAdAlaniButonu.sendKeys(string);
    }

    @Then("Ve soyad {string} görüntülenir")
    public void veSoyadGörüntülenir(String string) {
        adresEkleme.soyadAlaniHataMesaji.sendKeys(string);
    }

    @Given("Telefon butonuna {string} girilir")
    public void telefonButonunaGirilir(String string) {
        bekle(3);
        adresEkleme.telefonAlaniButonu.sendKeys(string);

    }

    @Then("Ve telefon alani {string} görüntülenir")
    public void veTelefonAlaniGörüntülenir(String string) {
        bekle(3);
        adresEkleme.telefonAlaniHataMesaji.sendKeys(string);
    }

    @Given("Bina No butonuna {string} girilir")
    public void binaNoButonunaGirilir(String string) {
        bekle(3);
        adresEkleme.binaNo.sendKeys(string);

    }


    @Then("bina no alani {string} görüntülenir")
    public void binaNoAlaniGörüntülenir(String string) {
        adresEkleme.binaNoAlaniHataMesaji.sendKeys(string);
    }

    @Given("Kullanici test baslikli adresin duzenle butonuna tiklar.")
    public void kullaniciTestBaslikliAdresinDuzenleButonunaTiklar() {
        bekle(3);
        click(adresEkleme.duzenleButonu);

    }

    @When("Bilgilerde degişiklik yapar.")
    public void bilgilerdeDegişiklikYapar() {
        bekle(3);
        adresEkleme.adAlaniButonu.clear();
        bekle(3);
        adresEkleme.adAlaniButonu.sendKeys("Suay");


    }

    @And("Adres bilgimi kaydet butonuna basar.")
    public void adresBilgimiKaydetButonunaBasar() {
        adresEkleme.adresBilgimiGüncelle.click();

    }

    @Given("Kullanici sil butonuna tiklar.")
    public void kullaniciSilButonunaTiklar() {
        bekle(5);
        click(adresEkleme.silenecekAdres);
        click(adresEkleme.silButton);
    }


    @Then("Soyad butonuna gecersiz veri girilir ve hata mesaji alinir.")
    public void soyadButonunaGecersizVeriGirilirVeHataMesajiAlinir() {
        String[][] invalidData = {
                {"", "Soyad alanına özel karakter girmeyiniz."},
                {"a", "Soyad minimum 2, maksimum 15 karakter olması gerekiyor; girdiğiniz karekter sayısı 1."},
                {"/", "Soyad alanına özel karakter girmeyiniz."}
        };

        for (String[] data : invalidData) {
            // Geçersiz adı gir
            WebElement nameInput = adresEkleme.SoyAdAlaniButonu;
            nameInput.clear();
            nameInput.sendKeys(data[0]);
            bekle(2);

            // Hata mesajını kontrol et
            WebElement errorMessage = adresEkleme.soyadAlaniHataMesaji;
            String actualErrorMessage = errorMessage.getText();

            // Beklenen hata mesajı ile gerçek hata mesajını karşılaştır
            Assert.assertEquals("Hata mesajı beklenenden farklı!", data[1], actualErrorMessage);
        }
    }


//        adresEkleme.SoyAdAlaniButonu.sendKeys(gecersizVeri);
//       adresEkleme.soyadAlaniHataMesaji.sendKeys(hataMesaji);


    @And("Ad butonuna {string} için {string} görüntülenir.")
    public void adButonunaIçinGörüntülenir(String invalidData, String expectedErrorMessage) {
        // Soyad butonuna belirli veriyi girme ve hata mesajını kontrol etme kodları
        WebElement surnameInput = adresEkleme.adAlaniButonu;
        surnameInput.clear();
        surnameInput.sendKeys(invalidData);

        // Hata mesajını kontrol et
        WebElement errorMessage = adresEkleme.adAlaniHataMesaji;
        String actualErrorMessage = errorMessage.getText();

        // Beklenen hata mesajı ile gerçek hata mesajını karşılaştır
        Assert.assertEquals("Hata mesajı beklenenden farklı!", expectedErrorMessage, actualErrorMessage);
    }
}