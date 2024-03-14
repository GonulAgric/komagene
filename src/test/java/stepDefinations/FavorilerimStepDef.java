package stepDefinations;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.FavorilerimPage;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;
import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;

public class FavorilerimStepDef {
        FavorilerimPage favorilerimPage = new FavorilerimPage();
        @When("Urun kartlarindan birine tiklar.")
        public void urun_kartlarindan_birine_tiklar() {
            ReusableMethods.scroll(favorilerimPage.durumler);
            bekle(5);
            click(favorilerimPage.durumler);
            bekle(5);
            favorilerimPage.CigKoftedurumFavori.click();

        }


        @When("Acilan urun detayinda favori simgesine tiklar.")
        public void acilan_urun_detayinda_favori_simgesine_tiklar() {
            favorilerimPage.favoriSimge.click();
            bekle(5);
            favorilerimPage.poup.click();
        }
        @Then("Urunun favorilerine eklendigini dogrular.")
        public void urunun_favorilerine_eklendigini_dogrular() {
        // Bekleme işlemi
        bekle(10);
        // Favori ürünlerin container'ını bulma
        WebElement favoriUrunlerContainer = Driver.getDriver().findElement(By.cssSelector("#main-wrapper > article > section > div"));
        bekle(10);

        // Favori ürünlerin listesini içeren bir liste
        List<WebElement> favoriUrunler = favoriUrunlerContainer.findElements(By.xpath(".//div[contains(@class, 'favori-urun')]"));
        for (WebElement urun : favoriUrunler) {
            if (urun.getText().contains("Çiğ Köfte Dürüm")) {

            }
        }
        bekle(10);
        click(favorilerimPage.CigKoftedurumFavori1);
        bekle(10);
        click(favorilerimPage.favoriSimge);

    }

    @When("Acılan dropdown menuden favori urunlerime tiklar.")
        public void acılan_dropdown_menuden_favori_urunlerime_tiklar() {
        // Favorilerimiz sayfasına gitme
        bekle(10);
        click(favorilerimPage.favoriUrunlerimiz);
        bekle(3);
        }


    @Then("Favori urunlerimin otomatik geldigini dogrular.")
    public void favori_urunlerimin_otomatik_geldigini_dogrular() {
        Assert.assertTrue("Favori ürünler görüntülenemedi.", favorilerimPage.favoriUrunlerContainer.isDisplayed());
    }

}


