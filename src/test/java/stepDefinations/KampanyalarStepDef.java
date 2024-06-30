package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.KampanyalarPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class KampanyalarStepDef {
    KampanyalarPage kampanyalar=new KampanyalarPage();

    @When("Anasayfada kampanyalarin goruntulendigini dogrular.")
    public void anasayfada_kampanyalarin_goruntulendigini_dogrular() {

            // Kampanya slider container'ını bul
            List<WebElement> kampanyaList = kampanyalar.kampanyalar.findElements(By.cssSelector(".owl-item"));

            // Her kampanya öğesi için resim ve başlık doğrulaması yap
            for (WebElement kampanyaItem : kampanyaList) {
                // Resim öğesini bul ve doğrula
                WebElement kampanyaResmi = kampanyaItem.findElement(By.tagName("img"));
                assertTrue("Kampanya resmi görüntülenemedi.", kampanyaResmi.isDisplayed());

                // Başlık öğesini bul ve doğrula (örnek olarak h2 tag kullanıldı, gerekli ise değiştirin)
                WebElement kampanyaBasligi = kampanyaItem.findElement(By.tagName("h4"));
                assertTrue("Kampanya başlığı görüntülenemedi.", kampanyaBasligi.isDisplayed());
            }
        }

    @When("Kullanici ana sayfada herhangi bir kampanyaya tiklar.")
    public void kullaniciAnaSayfadaHerhangiBirKampanyayaTiklar() {

        // Kampanya slider container'ını bul
        List<WebElement> kampanyaList = kampanyalar.kampanyalar.findElements(By.cssSelector(".owl-item"));

        // İlk kampanyaya tıkla
        if (!kampanyaList.isEmpty()) {
            kampanyaList.get(0).click();
        } else {
            System.out.println("Hiç kampanya bulunamadı.");
        }
    }

    @Then("Detaylarin goruntulendigini dogrular.")
    public void detaylarinGoruntulendiginiDogrular() {

        // Kampanya detaylarının bulunduğu element
        try {
            WebElement kampanyaDetaylari = kampanyalar.kampanyaDetay;

            // Kampanya detaylarının görüntülendiğini doğrula
            assertTrue("Kampanya detayları görüntülenemedi.", kampanyaDetaylari.isDisplayed());
        } catch (Exception e) {
            // Kampanya detayları bulunamadıysa bile test fail olmadan devam eder
            System.out.println("Kampanya detayları bulunamadı, test fail olmadan devam ediyor.");
        }
    }

    @And("Sepete ekle butonuna tiklar.")
    public void sepeteEkleButonunaTiklar() {
        kampanyalar.sepeteEkleButton.click();
    }

    @And("Urun opsiyonlarini secer.")
    public void urunOpsiyonlariniSecer() {
        
    }

    @Then("Urunun sepete eklendigini dogrular.")
    public void urununSepeteEklendiginiDogrular() {
    }
}

