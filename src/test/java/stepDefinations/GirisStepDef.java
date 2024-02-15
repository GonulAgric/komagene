package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import pages.UyeOlPage;
import utilities.Driver;
import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;


public class GirisStepDef {
    UyeOlPage uyeOlPage = new UyeOlPage();

    @When("Üye Ol Giriş Yap butonuna tıklanır")
    public void üyeOlGirişYapButonunaTıklanır() {
        click(uyeOlPage.uyeolButton);
    }

    @And("Telefon numarası girilir")
    public void telefonNumarasıGirilir() {

        // Üye ol pop-up ekranına geçiş yap
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                break;
            }

            bekle(3);
            uyeOlPage.phoneNumber.click();

            uyeOlPage.phoneNumber.sendKeys("5461127610");
            uyeOlPage.girisYap.click();
            bekle(3);
        }
    }


    @And("Gelen dogrulama kodu girilir")
    public void gelenDogrulamaKoduGirilir() throws IOException {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n" +
                "    \"FirmaId\":32,\n" +
                "    \"Telefon\":\"5461127610\"\n" +
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
        uyeOlPage.dogrulama.sendKeys(responseBody);
       // loginPage.girisYapAllert.click();
    }


    @When("Giriş Yap butonuna tıklanır")
    public void girişYapButonunaTıklanır() {
        uyeOlPage.girisYapAllert.click();

    }



}
