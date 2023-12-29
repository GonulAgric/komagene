package stepDefinations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AdreslerimPage;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.bekle;

public class AdresStepDef {
    AdreslerimPage adresEkleme = new AdreslerimPage();

    @When("Acilan dropdown menuden adreslerime tiklar.")
    public void acilanDropdownMenudenAdreslerimeTiklar() {
        bekle(2);
        adresEkleme.adreslerimButonu.click();
    }


    @And("Kullanici Yeni Adres Ekle butonuna tiklar")
    public void kullaniciYeniAdresEkleButonunaTiklar() {
        adresEkleme.yeniAdresBilgisiEkleButonu.click();
        
    }
    @And("Kullanici baslik butonunu doldurur.")
    public void kullaniciBaslikButonunuDoldurur() {
        adresEkleme.adresBaslikButonu.sendKeys("test");
        
    }

    @And("Kullanici adres tipi butonunu doldurur.")
    public void kullaniciAdresTipiButonunuDoldurur() {
        ReusableMethods.ddmIndex(adresEkleme.adresTipiButonu,1);
        
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
        ReusableMethods.ddmIndex(adresEkleme.ilDropdawn,1);

    }

    @And("Kullanici ilce secer.")
    public void kullaniciIlceSecer() {
        bekle(2);
        ReusableMethods.ddmIndex(adresEkleme.ilceDropdawn,1);

    }

    @And("Kullanici mahalle secer.")
    public void kullaniciMahalleSecer() {
        bekle(2);
        ReusableMethods.ddmIndex(adresEkleme.mahalleDropdawn,1);

    }
    @And("Kullanici sokak secer.")
    public void kullaniciSokakSecer() {
        bekle(5);
        ReusableMethods.ddmIndex(adresEkleme.sokakDropdawn,3);
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
        String actualMesaj=adresEkleme.baslikAlaniHataMesaji.getText();
        String expectedMesaj="Başlık minimum 2, maksimum 100 karakter olması gerekiyor; girdiğiniz karekter sayısı 1.";

        Assert.assertEquals(expectedMesaj,actualMesaj);
    }

    @And("Adres tipi alanini boş birakir.")
    public void adresTipiAlaniniBoşBirakir() {
        ReusableMethods.ddmIndex(adresEkleme.adresTipiButonu,0);
        
    }

    @Then("Kullanici uyari mesaji alir.")
    public void kullaniciUyariMesajiAlir() {
        String actualMesaj= adresEkleme.adresTipiAlaniHataMesaji.getText();
        String expectedMesaj= "Lütfen adres tipi seçiniz.";
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

    @Given("Soyad butonuna {string} girilir")
    public void soyadButonunaGirilir(String string) {
        adresEkleme.SoyAdAlaniButonu.sendKeys(string);
    }

    @Then("Ve soyad {string} görüntülenir")
    public void veSoyadGörüntülenir(String string) {
        adresEkleme.soyadAlaniHataMesaji.sendKeys(string);
    }

    @Given("Telefon butonuna {string} girilir")
    public void telefonButonunaGirilir(String string) {
        adresEkleme.telefonAlaniButonu.sendKeys(string);

    }

    @Then("Ve telefon alani {string} görüntülenir")
    public void veTelefonAlaniGörüntülenir(String string) {
        adresEkleme.telefonAlaniHataMesaji.sendKeys(string);
    }

    @Given("Bina No butonuna {string} girilir")
    public void binaNoButonunaGirilir(String string) {
        adresEkleme.binaNo.sendKeys(string);
    }


    @Then("bina no alani {string} görüntülenir")
    public void binaNoAlaniGörüntülenir(String string) {
        adresEkleme.binaNoAlaniHataMesaji.sendKeys(string);
    }

    @Given("Kullanici test baslikli adresin duzenle butonuna tiklar.")
    public void kullaniciTestBaslikliAdresinDuzenleButonunaTiklar() {
        adresEkleme.duzenleButonu.click();

    }

    @When("Bilgilerde degişiklik yapar.")
    public void bilgilerdeDegişiklikYapar() {
        adresEkleme.adAlaniButonu.clear();
        adresEkleme.adAlaniButonu.sendKeys("Suay");

    }

    @And("Adres bilgimi kaydet butonuna basar.")
    public void adresBilgimiKaydetButonunaBasar() {
        adresEkleme.adresBilgimiGüncelle.click();

    }

    @Given("Kullanici sil butonuna tiklar.")
    public void kullaniciSilButonunaTiklar() {
        adresEkleme.sil.click();
    }

}