package stepDefinations;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SiparislerimPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;

public class SiparislerimStepDef {
        SiparislerimPage siparislerimPage = new SiparislerimPage();
        @When("Acılan dropdown menuden siparislerime tiklar.")
        public void acılan_dropdown_menuden_siparislerime_tiklar() {
            bekle(5);
            siparislerimPage.siparislerimButton.click();
            bekle(5);
        }
         @Then("Gecmis siparislerin goruntulendigini dogrular.")
         public void gecmisSiparislerinGoruntulendiginiDogrular() {
             if(siparislerimPage.siparislerimListe.isDisplayed()) {
                 System.out.println("Sipariş listesi başarıyla görüntülendi!");
             } else {
                 System.out.println("Sipariş listesi görüntülenemedi!");
             }

        }
        @And("Herhangi bir siparisin detayina tiklar.")
        public void herhangiBirSiparisinDetayinaTiklar() {
            bekle(5);
             siparislerimPage.siparisDetayiButton.click();
         }
        @When("Siparis detayinin geldigini dogrular.")
        public void siparis_detayinin_geldigini_dogrular() {
            bekle(3);
            siparislerimPage.siparisDetayiButton.click();
        }
        @When("Tekrarla butonuna tiklar.")
        public void tekrarla_butonuna_tiklar() {
            bekle(3);
            click(siparislerimPage.tekrarlaButton);
        }
        @Then("Kullanıcı sepet sayfasına yönlendirildigini dogrular.")
        public void kullanıcı_sepet_sayfasına_yönlendirildigini_dogrular() {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"popupPagesOrderHistoryPage\"]/div/div/div[2]/div/div/div/div[2]/div[1]")));


            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            String popupText = (String) js.executeScript("return arguments[0].innerText;", popupElement);

            String expectedText = "Siparişiniz tekrar işlendi. Sepet sayfasına yönlendiriliyorsunuz";
            Assert.assertTrue(popupText.contains(expectedText));
        }
}

