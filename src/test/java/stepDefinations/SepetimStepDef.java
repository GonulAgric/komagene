package stepDefinations;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.SepetimPage;
import utilities.ReusableMethods;
import java.util.List;
    public class SepetimStepDef {
        SepetimPage sepetimPage = new SepetimPage();
        @When("Acılan dropdown menuden siparislerime tiklar.")
        public void acılan_dropdown_menuden_siparislerime_tiklar() {
            sepetimPage.siparislerimButton.click();
        }
        @When("Gecmis siparislerimi gorur.")
        public void gecmis_siparislerimi_gorur() {
            List<WebElement> tumSiparisler = (List<WebElement>) sepetimPage.siparislerTable;
            int satirSayisi = 1;
            for (WebElement herSatir : tumSiparisler){
                System.out.println("Satir" + satirSayisi + "=>" + herSatir.getText());
                satirSayisi++;
            }
        }
        /* @Then("Gecmis siparislerin goruntulendigini dogrular.")
      public void gecmis_siparislerin_goruntulendigini_dogrular() {
      }
  */
        @When("Siparisin detayina tiklar.")
        public void siparisin_detayina_tiklar() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
        @When("Siparis detayinin geldigini dogrular.")
        public void siparis_detayinin_geldigini_dogrular() {
            sepetimPage.siparisDetayiButton.click();
        }
        @When("Tekrarla butonuna tiklar.")
        public void tekrarla_butonuna_tiklar() {
            sepetimPage.tekrarlaButton.click();
        }
        @Then("Kullanıcı sepet sayfasına yönlendirildigini dogrular.")
        public void kullanıcı_sepet_sayfasına_yönlendirildigini_dogrular() {
            ReusableMethods.windowHandle();
            Assert.assertTrue(sepetimPage.sepetimYonlendirmePopUp.getText().contains("Siparişiniz tekrar işlendi. Sepet sayfasına yönlendiriliyorsunuz"));
        }
    }

