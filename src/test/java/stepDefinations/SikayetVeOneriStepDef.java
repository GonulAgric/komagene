package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;
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


    @Then("Yeni sikayetin goruntulendigini dogrular.")
    public void yeniSikayetinGoruntulendiginiDogrular() {

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

        // Yeni şikayet oluştur
        String yeniSikayetMetni = "Bu bir test mesajıdır dikkate almayınız lütfen ";
        WebElement sikayetMetniInput = Driver.getDriver().findElement(By.id("txtContactPageAciklama"));
        sikayetMetniInput.sendKeys(yeniSikayetMetni);
        bekle(5);
        click(anaSayfa.iletisimKvkkKutucugu);
        bekle(2);
        click(anaSayfa.iletisimAcıkRizaKutucugu);
        bekle(3);
        anaSayfa.iletisimFormuGonderButonu.click();
        bekle(2);
        sikayetVeOneri.kapatButtonu.click();
        bekle(3);
        Driver.getDriver().navigate().back();
        bekle(3);
        sikayetVeOneri.sonSikayet.click();
        bekle(10);
        // Şikayet metinlerini içeren tüm dropdown'ları al
        List<WebElement> sikayetDropdownList = Driver.getDriver().findElements(By.cssSelector(".accordion-item .accordion-button"));


// Her bir dropdown için kontrol yap
        boolean yeniSikayetEklendi = false;
        for (WebElement sikayetDropdown : sikayetDropdownList) {
            // Dropdown'ı aç
            click(sikayetDropdown);

            // Dropdown içindeki şikayet metni elementini al
            WebElement sikayetMetniElement = sikayetDropdown.findElement(By.xpath("(//*[@class='col-md-12 text-start'])[2]"));

            // Debug: Şikayet metnini yazdır
            System.out.println("Şikayet Metni: " + sikayetMetniElement.getText());

            // Yeni şikayet metni ile karşılaştır
            if (sikayetMetniElement.getText().equals(yeniSikayetMetni)) {
                yeniSikayetEklendi = true;
                break;
            }
        }
       bekle(10);
// Yeni şikayetin herhangi bir dropdown içine eklenip eklenmediğini doğrula
        Assert.assertTrue("Hata: Yeni şikayet dropdown içine eklenmemiştir.", yeniSikayetEklendi);
    }

}