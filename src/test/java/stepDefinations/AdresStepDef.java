package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdresEkleme;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;

public class AdresStepDef {
    AdresEkleme adresEkleme= new AdresEkleme();
    LoginPage loginPage=new LoginPage();

    @Given("Verilen kullanıcı üyelik girişi yapar")
    public void verilen_kullanıcı_üyelik_girişi_yapar() {
//        Driver.getDriver().get(ConfigReader.getProperty("url"));
//        bekle(2);
//        ReusableMethods.click(loginPage.uyeolButton);
//        String anaPencereHandle = Driver.getDriver().getWindowHandle();
//        // Üye ol pop-up ekranına geçiş yap
//        String mainWindowHandle = Driver.getDriver().getWindowHandle();
//        for (String handle : Driver.getDriver().getWindowHandles()) {
//            if (!handle.equals(mainWindowHandle)) {
//                Driver.getDriver().switchTo().window(handle);
//                break;
//            }
//
//            bekle(3);
//            loginPage.phoneNumber.click();
//
//            loginPage.phoneNumber.sendKeys("5461127610");
//            loginPage.girişYap.click();
//            bekle(3);
//            loginPage.dogrulama.sendKeys(" ");
//            bekle(20);
//            loginPage.girisYapAllert.click();
//
//        }
    }
    @When("Ve kullanıcı {string} dropdown'ından {string} seçeneğini seçer")
    public void ve_kullanıcı_dropdown_ından_seçeneğini_seçer(String string, String string2) {

        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                break;
            }
        }
        bekle(3);
       click(adresEkleme.hesabim);
    }
    @When("kullanıcı {string} butonuna tıklar")
    public void kullanıcı_butonuna_tıklar(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("O zaman bir pop-up penceresi açılır")
    public void o_zaman_bir_pop_up_penceresi_açılır() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Örnek Adres butonunu doldurur.")
    public void kullanici_örnek_adres_butonunu_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Ev butonunu doldurur.")
    public void kullanici_ev_butonunu_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici John butonunu doldurur.")
    public void kullanici_john_butonunu_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Doe butonunu doldurur.")
    public void kullanici_doe_butonunu_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici {int}-{int} butonunu doldurur.")
    public void kullanici_butonunu_doldurur(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici İstanbul butonunu doldurur.")
    public void kullanici_istanbul_butonunu_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Beşiktaş butonunu doldurur.")
    public void kullanici_beşiktaş_butonunu_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Levent butonunu doldurur.")
    public void kullanici_levent_butonunu_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Örnek Sokak butonunu doldurur.")
    public void kullanici_örnek_sokak_butonunu_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Adres bilgimi kaydet butonuna tıklar")
    public void adres_bilgimi_kaydet_butonuna_tıklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Eğer sube yoksa {string} alerti görünmelidir")
    public void eğer_sube_yoksa_alerti_görünmelidir(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
