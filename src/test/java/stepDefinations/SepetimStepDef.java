package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SepetimPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.ReusableMethods.*;

public class SepetimStepDef {

    SepetimPage sepetim = new SepetimPage();

    @Then("Ürünün sepete eklendiğini doğrular")
    public void ürünün_sepete_eklendiğini_doğrular() {

        bekle(30);
        click(sepetim.sepeteYonlendirmePopUp);
        String popupText = sepetim.sepeteYonlendirmePopUp.getText();
        System.out.println("alert: " + popupText);
        bekle(5);
        Assert.assertTrue(popupText.contains("Ürün sepetinize eklendi, ürün listesine yönlendiriliyorsunuz"));


    }

    @Then("Adres bilgileri ve sipariş detay bilgilerini görüntüler.")
    public void adresBilgileriVeSiparişDetayBilgileriniGörüntüler() {

        String siparisDetayText = sepetim.siparisDetay.getText();
        String expectedDetails = "Acı Seçimi : Az Acı\n" +
                "Doritos Seçimi : Ekstra Malzeme İstemiyorum\n" +
                "Lavaş Seçimi : Ekstra Lavaş İstemiyorum\n" +
                "Garnitür Seçimi : Garnitür İstemiyorum\n" +
                "Sos Seçimi : Nar Ekşisi\n" +
                "Yanında İyi Gider : İçecek İstemiyorum\n" +
                "1 Lt. Pepsi Promosyonu : Promosyon İstemiyorum";

        Assert.assertTrue(siparisDetayText.contains(expectedDetails));

    }

    @When("Sepetteki urunun iptal Et butonuna tiklar.")
    public void sepettekiUrununIptalEtButonunaTiklar() {
        bekle(5);
        sepetim.sepetteUrunIptal.click();
    }

    @Then("Urunun sepetten çikarildiğini dogrular.")
    public void urununSepettenÇikarildiğiniDogrular() {
        bekle(5);
        sepetim.sepetteUrunIptalPopUp.click();
        String sepetteUrunIptalText = sepetim.sepetteUrunIptalPopUp.getText();
        bekle(5);
        System.out.println(sepetteUrunIptalText);

        Assert.assertTrue(sepetteUrunIptalText.contains("Seçtiğiniz ürün sepetinizden çıkarıldı."));
    }

    @When("Degisiklik yapmak istedigi opsiyonu secer.")
    public void degisiklikYapmakIstedigiOpsiyonuSecer() {
        bekle(3);
        sepetim.siparisDetay.click();
    }

    @And("Sectigi opsiyonu degiştirir.")
    public void sectigiOpsiyonuDegiştirir() {
        bekle(3);
        sepetim.sepetteOpsiyonDegisim.click();
    }

    @And("Degisiklikleri kaydet butonuna tiklar.")
    public void degisiklikleriKaydetButonunaTiklar() {
        bekle(3);
        sepetim.degisiklikleriKaydet.click();
    }

    @When("Sol ust kosedeki teslimat turunu degistirir ve degisiklikgin sepet tutarini yansidigini dogrular.")
    public void solUstKosedekiTeslimatTurunuDegistirirVeDegisiklikginSepetTutariniYansidiginiDogrular() {
        bekle(5); // Genel bir bekleme ekleyebiliriz, çünkü sayfa yüklendikten sonra işlemleri gerçekleştireceğiz.

        // Başlangıç sepet tutarını al
        String baslangicSepetTutari = sepetim.baslangicSepetTutari.getText();
        System.out.println("baslangicSepetTutari ="+baslangicSepetTutari);

        // Teslimat türlerini al
        WebElement gelAl = sepetim.teslimatTuruGelAl;
        WebElement paketServis = sepetim.teslimatTuruPaket;

        // Teslimat türlerinin seçili olup olmadığını kontrol et
        boolean gelAlSecili = gelAl.isSelected();
        System.out.println(gelAlSecili);
        boolean paketServisSecili = paketServis.isSelected();
        System.out.println(paketServisSecili);

        // Teslimat türüne göre işlem yap

          if (gelAlSecili) {
            // "Gel Al" seçiliyse, "Paket Servis"e tıklanacak
            paketServis.click();
            bekle(3);
            sepetim.teslimatTuruDegisiklikAlertEvet.click();
        } else if (paketServisSecili) {
            // "Paket Servis" seçiliyse, "Gel Al" seçilecek
            gelAl.click();
            sepetim.teslimatTuruDegisiklikAlertEvet.click();
        }

        // Değişikliğin sepet tutarına yansıdığını doğrula
        bekle(10); // İşlem tamamlandıktan sonra bir bekleme ekleyebiliriz, çünkü sayfanın yenilenmesi veya içeriğin güncellenmesi gerekebilir.
        String yeniSepetTutari = sepetim.yeniSepetTutari.getText();
        System.out.println("yeniSepetTutari ="+yeniSepetTutari);
        Assert.assertNotEquals(baslangicSepetTutari, yeniSepetTutari, "Sepet tutarı değişmedi.");
    }

    @Then("Odeme sayfasinda oldugunu dogrular.")
    public void odemeSayfasindaOldugunuDogrular() {
        bekle(5);
        Assert.assertTrue(sepetim.odemeSayfasi.isDisplayed());
    }

    @When("Ekledigi urunun adet sayisini arttirir.")
    public void ekledigiUrununAdetSayisiniArttirir() {
        bekle(3);
        sepetim.sepetteAdetArttirma.click();
        bekle(3);
        sepetim.sepetteAdetArttirma.click();
    }

    @Then("Adet sayisinin arttirildigini dogrular.")
    public void adetSayisininArttirildiginiDogrular() {
        String baslangicSayisi= sepetim.sepetteBaslangicAdetSayisi.getText();
        System.out.println(baslangicSayisi);
        bekle(3);
        sepetim.sepetteAdetArttirma.click();

        String yeniUrunSAyisi= sepetim.sepetteYeniAdetSayisi.getText();
        System.out.println(yeniUrunSAyisi);

        Assert.assertNotEquals(baslangicSayisi,yeniUrunSAyisi);
    }

    @When("Ekledigi urunun adet sayisini azaltir.")
    public void ekledigiUrununAdetSayisiniAzaltir() {

        bekle(3);
        sepetim.sepetteAdetAzaltma.click();
    }

    @Then("Adet sayisinin azaldigini dogrular.")
    public void adetSayisininAzaldiginiDogrular() {
       bekle(5);
       String poupText= sepetim.urunSayisiAzaltmaPopUp.getText();
        System.out.println("poupText:"+poupText);
        bekle(5);
       Assert.assertTrue(poupText.contains("Miktar 1 den küçük olamaz"));

    }
}
