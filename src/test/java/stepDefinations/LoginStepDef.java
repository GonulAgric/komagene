package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.Set;

import static utilities.ReusableMethods.bekle;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("Ana sayfaya gidilir")
    public void ana_sayfaya_gidilir() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @When("{string} butonuna tıklanır")
    public void butonuna_tıklanır(String string) {
        bekle(2);
        ReusableMethods.click(loginPage.uyeolButton);


    }
    @When("Bir telefon numarası girilir")
    public void bir_telefon_numarası_girilir() {
        String anaPencereHandle = Driver.getDriver().getWindowHandle();
        // Üye ol pop-up ekranına geçiş yap
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                break;
            }

            bekle(3);
            loginPage.phoneNumber.click();

            loginPage.phoneNumber.sendKeys("05461127610");
            loginPage.girişYap.click();
        }
    }
    @When("Ad, soyad, e-posta bilgileri girilir")
    public void ad_soyad_e_posta_bilgileri_girilir() {
        loginPage.ad.click();
        loginPage.ad.sendKeys("ad");
        loginPage.soyad.sendKeys("soyad");
        loginPage.mail.sendKeys("ad.soyad@gmail.com");
        bekle(2);

    }
    @When("{string} ve {string} ve {string} checkbox'ları seçilir")
    public void ve_ve_checkbox_ları_seçilir(String string, String string2, String string3) {
        loginPage.kvkkcheckbox.click();
        bekle(2);
        loginPage.üyelikKosullariCheckBox.click();
        bekle(2);
        loginPage.gizlilikSözleşmesiCheckBox.click();
        bekle(2);
        loginPage.üyeligiTamamlaButton.click();
        bekle(5);
     

    }
    @When("Telefonuna yanlış doğrulama kodu girilir")
    public void telefonuna_yanlış_doğrulama_kodu_girilir() {
        bekle(5);
        loginPage.allertKodGiris.sendKeys("5555");
        bekle(2);
        loginPage.girisYapAllert.click();
        bekle(3);

    }
    @When("{string} butonuna tekrar tıklanır")
    public void butonuna_tekrar_tıklanır(String string) {

    }
    @Then("{string} uyarısı görüntülenir")
    public void uyarısı_görüntülenir(String string) {
        String alertText = loginPage.alert.getText();

        Assert.assertFalse(alertText.contains("hosgeldiniz"));

    }
    @And("sayfa kapatılır")
    public void sayfaKapatılır() {
        Driver.closeDriver();
    }

    @Then("{string} mesajı görüntülenir")
    public void mesajıGörüntülenir(String arg0) {
        
    }

    @And("Telefonuna gelen doğrulama kodu girilir")
    public void telefonunaGelenDoğrulamaKoduGirilir() {
    }
}