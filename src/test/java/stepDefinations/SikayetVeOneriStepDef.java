package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AnaSayfaPage;
import pages.SikayetVeOneriPage;
import utilities.Driver;
import utilities.ReusableMethods;
import java.time.Duration;
import java.util.List;

import static utilities.ReusableMethods.*;

public class SikayetVeOneriStepDef {
    AnaSayfaPage anaSayfa = new AnaSayfaPage();
    SikayetVeOneriPage sikayetVeOneri = new SikayetVeOneriPage();

    @And("Kullanici hesabim butonuna tiklar.")
    public void kullanici_hesabim_butonuna_tiklar() {
        click(sikayetVeOneri.hesabimButon);


    }

    @When("Acilan dropdown menuden sikayet ve oneriye tiklar.")
    public void acilan_dropdown_menuden_sikayet_ve_oneriye_tiklar() {
        bekle(3);
        click(sikayetVeOneri.sikayetVeOnerilerim);
    }

    @Then("Sikayet ve onerilerim'in otomatik geldigini gorur.")
    public void sikayet_ve_onerilerim_in_otomatik_geldigini_gorur() {
        List<WebElement> sikayetListesi = Driver.getDriver().findElements(By.id("ordersAccordion"));
        Assert.assertTrue("Hata: Şikayet listesi dolu olmalıdır", sikayetListesi.size() > 0);
    }

    @And("Kullanici yeni butonuna tiklar.")
    public void kullaniciYeniButonunaTiklar() {
        bekle(2);
        sikayetVeOneri.sikayetVeOnerilerYeniButtonu.click();
    }

    @And("Yeni sikayet ekler.")
    public void yeniSikayetEkler() {
        anaSayfa.iletisimAdButonu.sendKeys("Gonul");
        anaSayfa.iletisimSoyadButonu.sendKeys("Agrıc");
        bekle(3);
        click(anaSayfa.iletisimTelefonButonu);
        anaSayfa.iletisimTelefonButonu.sendKeys("5555555555");
        anaSayfa.iletisimEmailButonu.sendKeys("agrc.gnl@gmail.com");
        bekle(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        // Ülke dropdown'ı tıklanabilir olana kadar bekle
        WebElement ulkeDropdown = wait.until(ExpectedConditions.elementToBeClickable(anaSayfa.iletisimUlkeDrapDown));
        click(ulkeDropdown);

        WebElement ilDropdown = wait.until(ExpectedConditions.elementToBeClickable(anaSayfa.iletisimIlDrapDown));
        click(ilDropdown);
        ReusableMethods.ddmIndex(anaSayfa.iletisimIlDrapDown, 2);
        bekle(3);
        ddmIndex(anaSayfa.iletisimIlceDrapDown, 2);
        bekle(3);
        ReusableMethods.ddmIndex(sikayetVeOneri.konuAlani, 2);
        bekle(3);
        sikayetVeOneri.mesajAlani.sendKeys("Bu bir test mesajıdır dikkate almayınız lütfen ");
        bekle(5);
        click(anaSayfa.iletisimKvkkKutucugu);
        bekle(2);
        click(anaSayfa.iletisimAcıkRizaKutucugu);
        bekle(3);
        anaSayfa.iletisimFormuGonderButonu.click();
    }

    @Then("Yeni sikayetin goruntulendigini dogrular.")
    public void yeniSikayetinGoruntulendiginiDogrular() {

        bekle(10);
        Assert.assertTrue(sikayetVeOneri.yeniSikayetSuccessMesaj.getText().contains("Mesajınız gönderilmiştir."));

    }

}
