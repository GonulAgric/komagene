package stepDefinations;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
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
        click(kisiselBilgilerimPage.hesabimButton);
        bekle(2);
    }

    @When("Acılan dropdown menüden kişisel bilgilerime tıklar.")
    public void acılan_dropdown_menüden_kişisel_bilgilerime_tıklar() {
        click(kisiselBilgilerimPage.kisiselBilgilerimButton);
    }

    @Then("Kişisel Bilgilerim'in  geldiğini dogrular.")
    public void kişisel_bilgilerim_in_geldiğini_dogrular() {
        String adSoyadAlani = kisiselBilgilerimPage.kisiselBilgilerimAdSoyad.getText();
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
        kisiselBilgilerimPage.kisiselBilgilerimEmail.click();
        kisiselBilgilerimPage.kisiselBilgilerimEmail.clear();
        kisiselBilgilerimPage.kisiselBilgilerimEmail.sendKeys(faker.internet().emailAddress());
        click(kisiselBilgilerimPage.kaydetButton);

    }

    @Then("Degisiklik yaptigini dogrular.")
    public void degisiklikYaptiginiDogrular() {
        ReusableMethods.windowHandle();
        Assert.assertTrue(kisiselBilgilerimPage.kBguncellemePopUp.getText().contains("Lütfen geçerli bir email adresi giriniz."));
    }

    @When("İletişim tercıhlerımden E-Posta kutusunu işaretler")
    public void iletişimTercıhlerımdenEPostaKutusunuIşaretler() {
        kisiselBilgilerimPage.emailCheckbox.click();

    }

    @And("Kullanıcı kaydet butonuna tıklar.")
    public void kullanıcıKaydetButonunaTıklar() {
        kisiselBilgilerimPage.kaydetButton.click();
    }

    @Then("Iletisim tercihi dogrulamasini yapar.")
    public void ıletisimTercihiDogrulamasiniYapar() {
        bekle(10);
        ReusableMethods.windowHandle();
    }
}

