package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.Assert;
import pages.UyeOlPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static utilities.ReusableMethods.bekle;

public class ÜyeOlStepDef {
    UyeOlPage loginPage = new UyeOlPage();

    @Given("Ana sayfaya gidilir")
    public void ana_sayfaya_gidilir() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @When("{string} butonuna tıklanır")
    public void butonuna_tıklanır(String string) {
        ReusableMethods.visibleWait(loginPage.uyeolButton,2);
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

            loginPage.phoneNumber.sendKeys("5424494392");
            loginPage.girisYap.click();
            bekle(3);
        }
    }
    @When("Ad, soyad, e-posta bilgileri girilir")
    public void ad_soyad_e_posta_bilgileri_girilir() {
        loginPage.ad.click();
        loginPage.ad.sendKeys("ad");
        loginPage.soyad.sendKeys("soyad");
        loginPage.mail.sendKeys("ab.komgn@gmail.com");
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

//        String anaPencereHandle = Driver.getDriver().getWindowHandle();
//        // Üye ol pop-up ekranına geçiş yap
//        String mainWindowHandle = Driver.getDriver().getWindowHandle();
//        for (String handle : Driver.getDriver().getWindowHandles()) {
//            if (!handle.equals(mainWindowHandle)) {
//                Driver.getDriver().switchTo().window(handle);
//                break;
//            }
//            String text = loginPage.hoşgeldinizPopUp.getText();
//            Assert.assertTrue(text.contains("hoş geldininiz"));
//        }
    }

    @And("Telefonuna gelen doğrulama kodu girilir")
    public void telefonunaGelenDoğrulamaKoduGirilir() throws IOException {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,"{\n" +
                "    \"FirmaId\":32,\n" +
                "    \"Telefon\":\"5461127610\"\n" +
                "}");
        Request request = new Request.Builder()
                .url("https://gateway.komagene.com.tr/auth/auth/testicinguvenlikoduver")
                .method("POST",body)
                .build();

        okhttp3.Response response = client.newCall(request).execute();

        int statusCode = response.code();
        String responseBody = response.body().string();

        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " +responseBody);

        bekle(5);
        loginPage.dogrulama.sendKeys(responseBody);
        loginPage.girisYapAllert.click();
    }

    @And("Eksik Bir telefon numarası girilir")
    public void eksikBirTelefonNumarasıGirilir() {

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

            loginPage.phoneNumber.sendKeys("54611276");
            loginPage.girisYap.click();
            bekle(3);
        }
    }

    @And("Kullanıcı anasayfaya dön butonuna tıklar.")
    public void kullanıcıAnasayfayaDönButonunaTıklar() {
        bekle(3);
        loginPage.anasayfayaDön.click();
    }

    @When("Ad alanina {string} girilir")
    public void ad_alanina_girilir(String string) {
        loginPage.ad.click();
        loginPage.ad.sendKeys(string);
    }
    @Then("{string} görüntülenir")
    public void görüntülenir(String string) {
        Assert.assertTrue(loginPage.adBosBirakilincaUyariMesaji.getText().contains(string));
    }

    @When("Soyad alanina {string} girilir")
    public void soyad_alanina_girilir(String string) {
        loginPage.soyad.click();
        loginPage.soyad.sendKeys(string);
    }
    @Then("Soyad {string} görüntülenir")
    public void soyad_görüntülenir(String string) {
        Assert.assertTrue(loginPage.soyadBosBirakilincaUyariMesaji.getText().contains(string));
    }
    @When("Email alanina {string} girilir")
    public void email_alanina_girilir(String string) {
        loginPage.mail.click();
        loginPage.mail.sendKeys(string);
    }
    @Then("Email {string} görüntülenir")
    public void email_görüntülenir(String string) {
        Assert.assertTrue(loginPage.emailBosBirakilincaUyariMesaji.getText().contains(string));
    }

    @When("{string} numarasi girilir")
    public void numarasi_girilir(String string) {
            loginPage.phoneNumber.click();
            loginPage.phoneNumber.sendKeys(string);
            loginPage.girisYap.click();
            bekle(2);
        }

    @Then("Telefon {string} görüntülenir")
    public void telefon_görüntülenir(String string) {
            ReusableMethods.windowHandle();
            Assert.assertTrue(loginPage.telNoUyariMesaji.getText().contains(string));

        }
    @When("KVKK Metni checkbox i isaretlenmez")
    public void kvkk_metni_checkbox_i_isaretlenmez() {

    }
    @When("Gizlilik Sözleşmesi  checkbox'i isaretlenir")
    public void gizlilik_sözleşmesi_checkbox_i_isaretlenir() {
        loginPage.gizlilikSözleşmesiCheckBox.click();
    }
    @When("Üyelik Sözleşmesi checkbox'i isaretlenir")
    public void üyelik_sözleşmesi_checkbox_i_isaretlenir() {
        loginPage.üyelikKosullariCheckBox.click();
    }


    @And("Üyeliği Tamamla butonuna tıklanır")
    public void üyeliğiTamamlaButonunaTıklanır() {
        loginPage.üyeligiTamamlaButton.click();
    }

    @Then("KVKK hata mesaji dogrulanir")
    public void kvkkHataMesajiDogrulanir() {
        ReusableMethods.windowHandle();
       loginPage.KVKKhataMesaji.click();
       Assert.assertTrue(loginPage.KVKKhataMesaji.getText().contains("Lütfen Kvkk bilgilendirme metinini,Üyelik koşullarını ve gizlilik sözleşmesini okuduğunuzu belirtiniz."));
    }
    @When("KVKK Metni checkbox i isaretlenir")
    public void kvkk_metni_checkbox_i_isaretlenir() {
        loginPage.kvkkcheckbox.click();
    }
    @When("Gizlilik Sözleşmesi  checkbox'i isaretlenmez")
    public void gizlilik_sözleşmesi_checkbox_i_isaretlenmez() {

    }
    @When("Üyelik Sözleşmesi checkbox'i isaretlenmez")
    public void üyelik_sözleşmesi_checkbox_i_isaretlenmez() {

    }
}

