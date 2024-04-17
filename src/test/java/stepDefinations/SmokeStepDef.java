package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.UyeOlPage;
import pages.SmokePage;
import utilities.Driver;
import utilities.ReusableMethods;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static io.restassured.RestAssured.given;
import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;

public class SmokeStepDef {

    UyeOlPage loginPage = new UyeOlPage();
    SmokePage smokePage = new SmokePage();
    Response response;

    @Then("Hesabında oldugunu dogrular")
    public void hesabındaOldugunuDogrular() {

        bekle(10);
        Assert.assertEquals("HESABIM", smokePage.hesabim.getText());



    }

  @Given("Adres secimini yapar.")
    public void adresSeciminiYapar() {

      WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(smokePage.adresSecimAlani));
        ReusableMethods.click(smokePage.adresSecimAlani);
        bekle(5);
        click(smokePage.kayitliAdreslerimTest);
        bekle(20);

      List<WebElement> subeler = Driver.getDriver().findElements(By.cssSelector(".subeListItem"));

      boolean acikSubeVar = false;

      // Her bir şube için kontrol yap
      for (WebElement sube : subeler) {
          // Şube durumu elementini bul
          WebElement durumElementi = sube.findElement(By.cssSelector(".text-center p"));

          // Durumu kontrol et
          String durum = durumElementi.getText().trim();
          if (durum.equals("AÇIK")) {
              // AÇIK durumdaysa tıkla
              sube.click();
              System.out.println("Açık olan şube tıklandı: " + sube.findElement(By.cssSelector("h6")).getText());
              acikSubeVar = true;
              break;
          } else if (durum.equals("SADECE GEL AL")) {
              // SADECE GEL AL durumdaysa tıkla
              sube.click();
              System.out.println("Gel Al şube tıklandı: " + sube.findElement(By.cssSelector("h6")).getText());
              acikSubeVar = true;
              break;
          }
      }

      // Açık veya SADECE GEL AL şube yoksa uyarı ver
      if (!acikSubeVar) {
          System.out.println("Uyarı: Açık veya Gel Al şube bulunamadı. Subeler kapalı.");
      }


      smokePage.seciliAdresleDevam.click();
 }




    @When("Kullanici Dürümler kategorisine tiklar.")
    public void kullaniciDürümlerKategorisineTiklar() {

        ReusableMethods.scroll(smokePage.durumler);
        bekle(3);
        click(smokePage.durumler);
    }

    @And("Cigkofte durume menuye tiklar.")
    public void cigkofteDurumeMenuyeTiklar() {

        bekle(10);
       click( smokePage.CigKoftedurum);

    }

    @And("Opsiyon seçimlerini yapar.")
    public void opsiyonSeçimleriniYapar() {

        bekle(10);
        click(smokePage.AciSecimi);
        bekle(5);
        click(smokePage.doritosSecimi);
        bekle(10);
        click(smokePage.extraMalzemeIstemiyorum);
        bekle(3);
        ReusableMethods.scroll(smokePage.lavasSecimi);
        bekle(3);
        click(smokePage.lavasSecimi);
        bekle(3);
        click(smokePage.extraLavasIstemiyorum);
        bekle(3);
        ReusableMethods.scroll(smokePage.garniturSecimi);
        bekle(3);
        click(smokePage.garniturSecimi);
        ReusableMethods.scroll(smokePage.sosSecimi);
        bekle(3);
        click(smokePage.sosSecimi);
        click(smokePage.yanindaIyiGider);
        bekle(5);
        click(smokePage.icecekIstemiyorum);
        bekle(2);
        click(  smokePage.pepsiPromosyonSecimi);
        bekle(2);
        click(smokePage.pepsiPromosyonIstemiyorum);
        bekle(2);


    }


    @And("Sepete ekle butonuna tıklar.")
    public void sepeteEkleButonunaTıklar() {
        bekle(5);
        click(smokePage.sepeteEkleButtonu);
        bekle(10);
    }

    @Given("Kullanici sepetime tiklar.")
    public void kullaniciSepetimeTiklar() {

        bekle(5);
        smokePage.sepetim.click();
    }


    @When("Teslimat turunu Gel Al secer.")
    public void teslimatTurunuGelAlSecer() {
        bekle(5);
        click(smokePage.odemeTeslimatTuru);
    }

    @And("Sipariş ver butonuna tiklar.")
    public void siparişVerButonunaTiklar() {
        bekle(10);
        click(smokePage.siparisVer);
        bekle(2);
    }

    @And("Kart bilgilerini girer.")
    public void kartBilgileriniGirer() {
        smokePage.saklıKArtBilgilerimiKul.click();
        Select dropdown = new Select(smokePage.odemeKArtıDropdown);
        dropdown.selectByIndex(1);
        bekle(2);

    }

    @And("Mesafeli satış sozlesmesini isaretler.")
    public void mesafeliSatışSozlesmesiniIsaretler() {
        bekle(3);
        smokePage.mesafeliSatış.click();
    }

    @And("Siparisi tamamla butonuna tiklar.")
    public void siparisiTamamlaButonunaTiklar() {
        smokePage.siparisiTamamla.click();
        bekle(10);
        WebElement odemeiframeElement = Driver.getDriver().findElement(By.id("ucDHtml"));
        Driver.getDriver().switchTo().frame(odemeiframeElement);
    }

    @And("Odeme için telefona gelen dogrulama kodunu girer.")
    public void odemeIçinTelefonaGelenDogrulamaKodunuGirer() throws IOException {
        bekle(10);
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"Telefon\": \"5368411169\",\r\n    \"FirmaId\": \"32\"\r\n}");
        Request request = new Request.Builder()
                .url("https://gateway.komagene.com.tr/auth/auth/smskodugonder")
                .method("POST", body)
                .addHeader("firmaid", "32")
                .addHeader("anonymousclientid", "91a21a36-e694-4291-b919-9c36b06d189d")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "NSC_ESNS=16c8bca6-9e61-1578-9678-00505698d0f6_2911666953_1195167698_00000000004676674122")
                .build();

        try {
            okhttp3.Response response = client.newCall(request).execute();
            int statusCode = response.code();
            String responseBody = response.body().string();

            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);

            // Doğrulama kodunu temizle
            String cleanCode = responseBody.replaceAll("[^0-9]", "");

            // Elementin etkileşimli olduğundan emin ol
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(smokePage.odemeDogrulama));

            // Doğrulama kodunu elemente yaz
            smokePage.odemeDogrulama.click();
            smokePage.odemeDogrulama.sendKeys(cleanCode);

            bekle(10);

            // Elemente tıklama işlemleri

            smokePage.odemeOnaylama.click();
            Driver.getDriver().switchTo().defaultContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

