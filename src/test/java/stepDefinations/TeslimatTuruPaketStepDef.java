package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SmokePage;
import pages.TeslimatPaketPage;
import utilities.Driver;

import java.util.List;

import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;

public class TeslimatTuruPaketStepDef {

    TeslimatPaketPage teslimatPaket = new TeslimatPaketPage();
    SmokePage smokePage = new SmokePage();

    @Given("Kullanici sayfanin sol üst kösesindeki  teslimat turune tiklar.")
    public void kullanici_sayfanin_sol_üst_kösesindeki_teslimat_turune_tiklar() {
        bekle(5);
        click(teslimatPaket.teslimatTuru);

    }

    @When("Acilan sayfada paket servis secenegine tiklar.")
    public void acilan_sayfada_paket_servis_secenegine_tiklar() {
        bekle(3);
        click(teslimatPaket.teslimatTuruPaket);
    }

    @And("Secili teslimat turu ile devam et butonuna tiklar.")
    public void secili_teslimat_turu_ile_devam_et_butonuna_tiklar() {
        teslimatPaket.seciliTeslimatTürüIleDevamEt.click();
    }

    @And("Adres seçer.")
    public void adresSeçer() {
        bekle(5);
        smokePage.kayitliAdreslerimTest.click();
    }

    @Then("Seçilen adrese yakın şubelerin listelendiğini doğrular.")
    public void seçilenAdreseYakınŞubelerinListelendiğiniDoğrular() {
        bekle(10);
        String containerSelector = "#addressChooseForm > div > div > div.modal-body > div > div > div:nth-child(2) > div.col-md-10";

        WebElement container = Driver.getDriver().findElement(By.cssSelector(containerSelector));

        // Eğer container elementi görüntülendi ise, yakındaki şubelerin listelendiğini doğrula
        if (container.isDisplayed()) {
            System.out.println("Yakındaki şubelerin listesi görüntülendi.");
            // Buraya ek doğrulama adımlarını ekleyebilirsiniz
        } else {
            System.out.println("Yakındaki şubelerin listesi görüntülenemedi.");
            Assert.fail("Yakındaki şubelerin listesi görüntülenemedi."); // Şubelerin listesi görüntülenemediğinde senaryoyu başarısız olarak işaretle
        }
    }

    @Then("Subelerin acik kapali durumunun goruntulendigini dogrular.")
    public void subelerinAcikKapaliDurumununGoruntulendiginiDogrular() {

        bekle(5);

        // Açık/kapalı durumu kontrol edilecek container ve durum elementlerinin CSS selektörleri
        String containerSelector = "#branchX509 > div > div > div.col-md-4.text-end.justify-content-center > div > div:nth-child(2) > div > p";

        // Container elementi
        WebElement container = Driver.getDriver().findElement(By.cssSelector(containerSelector));

        // Container elementi var mı kontrol et
        if (container.isDisplayed()) {
            // Container elementi görüntülendiğinde burada ek kontrol adımlarını ekleyebilirsiniz
            System.out.println("Şubelerin açık/kapalı durumu görüntülendi.");
        } else {
            // Container elementi görüntülenmediğinde
            System.out.println("Şubelerin açık/kapalı durumu görüntülenemedi.");
            Assert.fail("Şubelerin açık/kapalı durumu görüntülenemedi."); // Senaryoyu başarısız olarak işaretle
        }
    }

    @And("Kapali bir sube secer.")
    public void kapaliBirSubeSecer() {
        bekle(10);

        List<WebElement> subeler = Driver.getDriver().findElements(By.cssSelector(".subeListItem"));


        // Her bir şube için kontrol yap
        for (WebElement sube : subeler) {
            // Şube durumu elementini bul
            WebElement durumElementi = sube.findElement(By.cssSelector(".text-center p"));

            // Durumu kontrol et
            String durum = durumElementi.getText().trim();
            if (durum.equals("KAPALI")) {
                // KAPALI durumdaysa tıkla
                sube.click();
            }
        }

    }


    @Then("Secilen sube kapali ise alert verdigini dogrular")
    public void secilenSubeKapaliIseAlertVerdiginiDogrular() {
        bekle(10);

        // Alert elementine tıklama
        teslimatPaket.seciliSubeKapaliAlert.click();

        // Alert metnini al
        String alertText = teslimatPaket.seciliSubeKapaliAlert.getText();

        // Assert kullanarak alert metninin içinde beklenen metnin yer alıp almadığını kontrol et
        Assert.assertTrue("Seçtiğiniz şube kapalı",alertText.contains("Seçtiğiniz şube kapalı"));
    }

    @And("Sadece Gel Al bir sube secer.")
    public void sadeceGelAlBirSubeSecer() {

        bekle(10);

        List<WebElement> subeler = Driver.getDriver().findElements(By.cssSelector(".subeListItem"));


        // Her bir şube için kontrol yap
        for (WebElement sube : subeler) {
            // Şube durumu elementini bul
            WebElement durumElementi = sube.findElement(By.cssSelector(".text-center p"));

            // Durumu kontrol et
            String durum = durumElementi.getText().trim();
            if (durum.equals(" SADECE GEL AL")) {
                // KAPALI durumdaysa tıkla
                sube.click();
            }
        }
    }

    @Then("Uyari mesaji aldigini dogrular.")
    public void uyariMesajiAldiginiDogrular() {

        bekle(10);
        teslimatPaket.seciliSubeKapaliAlert.click();
        String alertText = teslimatPaket.seciliSubePaketAlert.getText();
        Assert.assertEquals("Seçtiğiniz şube şu an paket servis hizmeti vermemektedir. Lütfen başka şube seçiniz", alertText);

    }
}