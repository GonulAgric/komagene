package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.KampanyalarPage;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.click;

public class KampanyalarStepDef {
    KampanyalarPage kampanyalar = new KampanyalarPage();

    @When("Anasayfada kampanyalarin goruntulendigini dogrular.")
    public void anasayfada_kampanyalarin_goruntulendigini_dogrular() {
        bekle(10);
        try {
            // "id" attribute'u "campingSlider" olan div elementini bulun
            WebElement campingSlider = Driver.getDriver().findElement(By.id("campingSlider"));

            // "owl-item" sınıfına sahip tüm kampanya elemanlarını bulun
            List<WebElement> kampanyaElemanlari = campingSlider.findElements(By.className("owl-item"));

            // Kampanya elemanlarının görüntülendiğini doğrulayın
            for (WebElement kampanya : kampanyaElemanlari) {
                WebElement imgElement = kampanya.findElement(By.tagName("img"));
                if (imgElement.isDisplayed()) {
                    System.out.println("Kampanya görüntülendi: " + imgElement.getAttribute("title"));
                } else {
                    System.out.println("Kampanya görüntülenemedi: " + imgElement.getAttribute("title"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // WebDriver'ı kapatın
            Driver.getDriver().quit();
        }
    }

    @When("Kullanici ana sayfada herhangi bir kampanyaya tiklar.")
    public void kullaniciAnaSayfadaHerhangiBirKampanyayaTiklar() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));

        // "id" attribute'u "campingSlider" olan div elementini bulun
        WebElement campingSlider = Driver.getDriver().findElement(By.id("kampanyaSlider"));

        // "owl-item" sınıfına sahip tüm kampanya elemanlarını bulun
        List<WebElement> kampanyaElemanlari = campingSlider.findElements(By.className("owl-item"));


        // İlk kampanya elemanını tıklayın
        for (WebElement kampanyaElemani : kampanyaElemanlari) {
            if (kampanyaElemani.getAttribute("class").contains("active")) {
                WebElement linkElement = kampanyaElemani.findElement(By.tagName("a"));

                // Öğenin görünür olmasını bekleyin
                wait.until(ExpectedConditions.visibilityOf(linkElement));
                wait.until(ExpectedConditions.elementToBeClickable(linkElement));

                try {
                    // Normal tıklama yapmayı deneyin
                    linkElement.click();

                    // Uyarı mesajını kontrol edin
                    try {
                        WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("col-md-12")));
                        if (warningMessage != null && warningMessage.getText().contains("Bu kampanya sadece mobil uygulamaya özeldir.")) {
                            // Uyarı mesajını kapatın
                            bekle(5);
                            WebElement closeButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"mobilKampanyaUyari\"]/div/div/div[1]/button"));
                            closeButton.click();
                            continue; // Bir sonraki kampanyaya geç
                        }
                    } catch (Exception e) {
                        // Uyarı mesajı bulunamadıysa devam edin
                    }
                } catch (Exception e) {
                    // Eğer tıklama başarısız olursa JavaScript ile tıklamayı deneyin
                    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
                    js.executeScript("arguments[0].click();", linkElement);
                }
                break;
            }
        }


    }




    @Then("Detaylarin goruntulendigini dogrular.")
    public void detaylarinGoruntulendiginiDogrular() {


                // Detayların görüntülendiğini doğrulayın
                // Örneğin, detay sayfasındaki bir başlık veya belirgin bir öğenin varlığını kontrol edin
                WebElement detayBaslik = Driver.getDriver().findElement(By.tagName("h1"));
                if (detayBaslik.isDisplayed()) {
                    System.out.println("Kampanya detayları görüntülendi: " + detayBaslik.getText());
                } else {
                    System.out.println("Kampanya detayları görüntülenemedi.");
                }
            }




    @And("Sepete ekle butonuna tiklar.")
    public void sepeteEkleButonunaTiklar() {
        kampanyalar.sepeteEkleButton2.click();
    }

    @And("Urun opsiyonlarini secer.")
    public void urunOpsiyonlariniSecer() {
        // Ürün opsiyonlarını dinamik olarak seçin
        List<WebElement> opsiyonlar = Driver.getDriver().findElements(By.cssSelector("#main-wrapper > article:nth-child(3) > section > div > div.row.g-5 > div.col-md-7"));

        for (WebElement opsiyon : opsiyonlar) {
            List<WebElement> secenekler = opsiyon.findElements(By.tagName("div"));

            if (!secenekler.isEmpty()) {
                // İlk seçeneği seçin (opsiyonel: belirli bir mantıkla seçim yapılabilir)
                secenekler.get(0).click();
            }


        }
    }

    @Then("Urunun sepete eklendigini dogrular.")
    public void urununSepeteEklendiginiDogrular() {
    }

    @When("Kullanıcı ana sayfada herhangi bir kampanyaya tıklar.")
    public void kullanıcıAnaSayfadaHerhangiBirKampanyayaTıklar() {
        bekle(10);


            // Kampanyaların olduğu slider'dan dördüncü kampanyayı seçin
            WebElement campaignSlider = Driver.getDriver().findElement(By.cssSelector("#campingSlider"));
            List<WebElement> campaignItems = campaignSlider.findElements(By.cssSelector(".owl-item:not(.cloned) a"));

            if (campaignItems.size() > 3) {
                // JavaScript Executor ile elementi tıklayın
                JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
                executor.executeScript("arguments[0].click();", campaignItems.get(3));

                // Bekleme fonksiyonu
                bekle(5);
            } else {
                System.out.println("Kampanya bulunamadı veya indeks dışında.");
            }
       bekle(3);
       kampanyalar.sepeteEkleButton1.click();


    }

@And("Kullanıcı opsiyonları seçer.")
    public void kullanıcıOpsiyonlarıSeçer() {
// Ana opsiyon container'ını bulun
                WebElement opsiyonContainer = Driver.getDriver().findElement(By.cssSelector("#0bodyMain"));

// Opsiyon gruplarını bulun
                List<WebElement> opsiyonGruplari = opsiyonContainer.findElements(By.cssSelector(".form-check"));

// Her opsiyon grubundaki ilk seçeneği seçin
                for (WebElement opsiyonGrubu : opsiyonGruplari) {
                    List<WebElement> labelElementler = opsiyonGrubu.findElements(By.tagName("label"));
                    if (!labelElementler.isEmpty()) {
                        labelElementler.get(0).click();
                    }
                }
            }

    @And("Sepette teslimat türünü değiştirir.")
    public void sepetteTeslimatTürünüDeğiştirir() {
        
    }

    @Then("Değişen teslimat türü ile birlikte fiyatın değiştiğini doğrular")
    public void değişenTeslimatTürüIleBirlikteFiyatınDeğiştiğiniDoğrular() {
    }
}

