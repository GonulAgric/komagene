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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.SmokePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;

public class SmokeStepDef {

    LoginPage loginPage = new LoginPage();
    SmokePage smokePage = new SmokePage();
    Response response;


//    @When("Üye Ol Giriş Yap butonuna tıklanır")
//    public void üyeOlGirişYapButonunaTıklanır() {
//        click(loginPage.uyeolButton);
//    }
//
//    @And("Telefon numarası girilir")
//    public void telefonNumarasıGirilir() {
//
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
//        }
//    }
//
//
//    @And("Gelen dogrulama kodu girilir")
//    public void gelenDogrulamaKoduGirilir() throws IOException {
//
//        OkHttpClient client = new OkHttpClient();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\n" +
//                "    \"FirmaId\":32,\n" +
//                "    \"Telefon\":\"5461127610\"\n" +
//                "}");
//        Request request = new Request.Builder()
//                .url("https://gw.komagene.com.tr/auth/auth/testicinguvenlikoduver")
//                .method("POST", body)
//                .build();
//
//        okhttp3.Response response = client.newCall(request).execute();
//
//        int statusCode = response.code();
//        String responseBody = response.body().string();
//
//        System.out.println("Status Code: " + statusCode);
//        System.out.println("Response Body: " + responseBody);
//
//        bekle(5);
//        loginPage.dogrulama.sendKeys(responseBody);
//    }
//
//
//    @When("Giriş Yap butonuna tıklanır")
//    public void girişYapButonunaTıklanır() {
//        loginPage.girisYapAllert.click();
//
//    }

    @Then("Hesabında oldugunu dogrular")
    public void hesabındaOldugunuDogrular() {
        bekle(3);
        Assert.assertEquals("HESABIM", smokePage.hesabim.getText());
    }

    @Given("Adres secimini yapar.")
    public void adresSeciminiYapar() {
        bekle(2);
        smokePage.adresSecimAlani.click();
        smokePage.kayitliAdreslerimTest.click();
        bekle(3);

        if (smokePage.tugayYoluSube.getText().contains("AÇIK")) {
            ReusableMethods.scroll(smokePage.tugayYoluSube);
            click(smokePage.tugayYoluSube);
            smokePage.seciliAdresleDevam.click();
        }
        else {smokePage.maltepaMeydanSube.click();}


    }

    @When("Kullanici Bi cift tatli menuye tiklar.")
    public void kullaniciBiCiftTatliMenuyeTiklar() {
        ReusableMethods.scroll(smokePage.biCiftTatliMenu);
        bekle(2);
        click(smokePage.biCiftTatliMenu);
    }

    @And("İkili durum menuye tiklar.")
    public void ikiliDurumMenuyeTiklar() {
        bekle(2);
        smokePage.ikiliDurumMenu.click();

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
      ReusableMethods.scroll(smokePage.ikinciAciSecimi);
      bekle(5);
      click(smokePage.ikinciAciSecimi);
      bekle(3);
      click(smokePage.ikincidoritosSecimi);
      bekle(3);
      click(smokePage.ikinciextraMalzemeIstemiyorum);
      bekle(3);
      click(smokePage.ikinciLavasSecimi);
      bekle(3);
      smokePage.ikinciLavasIstemiyorum.click();
      bekle(2);
      smokePage.ikinciGarniturSecimi.click();
      bekle(2);
      smokePage.ikinciSosSecimi.click();
      bekle(2);
      smokePage.icecekSecimi.click();
      bekle(2);
      smokePage.komageneAyran.click();
      bekle(2);
      smokePage.ikinciicecekSecimi.click();
      bekle(2);
      smokePage.ikinciAyran.click();
      bekle(2);
      smokePage.pepsiPromosyonSecimi.click();
      bekle(2);
      click(smokePage.pepsiPromosyonIstemiyorum);
      bekle(2);
      smokePage.redbullPromosyonSecimi.click();
      bekle(2);
      smokePage.redbullPromosyonIstemiyorum.click();
   }


    @And("Sepete ekle butonuna tıklar.")
    public void sepeteEkleButonunaTıklar() {
        bekle(5);
     click(   smokePage.sepeteEkleButtonu);
    }
    @Given("Kullanici sepetime tiklar.")
    public void kullaniciSepetimeTiklar() {

        bekle(10);
        click(smokePage.sepetim);
    }


    @When("Teslimat turunu Gel Al secer.")
    public void teslimatTurunuGelAlSecer() {
        bekle(3);
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
        smokePage.mesafeliSatış.click();
    }

    @And("Siparisi tamamla butonuna tiklar.")
    public void siparisiTamamlaButonunaTiklar() {
        smokePage.siparisiTamamla.click();
        bekle(3);
        WebElement odemeiframeElement = Driver.getDriver().findElement(By.id("ucDHtml"));
        Driver.getDriver().switchTo().frame(odemeiframeElement);
        }

    @And("Odeme için telefona gelen dogrulama kodunu girer.")
    public void odemeIçinTelefonaGelenDogrulamaKodunuGirer() throws IOException {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n" +
                "    \"FirmaId\":32,\n" +
                "    \"Telefon\":\"5368411169\"\n" +
                "}");
        Request request = new Request.Builder()
                .url("https://gw.komagene.com.tr/auth/auth/testicinguvenlikoduver")
                .method("POST", body)
                .build();

        okhttp3.Response response = client.newCall(request).execute();

        int statusCode = response.code();
        String responseBody = response.body().string();

        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        bekle(5);
        smokePage.odemeDogrulama.sendKeys(responseBody);
        bekle(10);
        smokePage.odemeDogrulama.click();
        smokePage.odemeOnaylama.click();
        Driver.getDriver().switchTo().defaultContent();
    }

}
