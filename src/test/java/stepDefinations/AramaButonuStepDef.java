package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AramaButonuPages;

import java.util.NoSuchElementException;

import static utilities.ReusableMethods.bekle;

public class AramaButonuStepDef {

    AramaButonuPages aramaButonu=new AramaButonuPages();
    @When("Kullanici arama cubuguna tiklar")
    public void kullanici_arama_cubuguna_tiklar() {
        bekle(3);
        aramaButonu.aramaButonu.click();

    }
    @And("Aranacak veriyi girer.")
    public void aranacak_veriyi_girer() {
       aramaButonu.aramaButonu.sendKeys("ayran");
    }
    @And("Enter tusuna basar")
    public void enter_tusuna_basar() {
      aramaButonu.aramaButonu.sendKeys(Keys.ENTER);
    }
    @Then("Urunlerin listelendigini dogrular.")
    public void urunlerin_listelendigini_dogrular() {

            WebElement urunlerList=aramaButonu.urunlerList;
            Assert.assertTrue("Ürünler listelenemedi.",urunlerList.isDisplayed());
            System.out.println("Ürünler listelendi.");

        }

    @And("Buyuk harflerle aranacak veriyi girer.")
    public void buyukHarflerleAranacakVeriyiGirer() {
        aramaButonu.aramaButonu.sendKeys("AYRAN");
    }

    @And("Yazim yanlisi yaparak aranacak veriyi girer.")
    public void yazimYanlisiYaparakAranacakVeriyiGirer() {

        aramaButonu.aramaButonu.sendKeys("aryan");
    }

    @And("Gecersiz bir veri girer.")
    public void gecersizBirVeriGirer() {
        bekle(3);
        aramaButonu.aramaButonu.sendKeys("sampuan");
    }

    @Then("Uyari mesajini gorur.")
    public void uyariMesajiniGorur() {
        bekle(3);
        String text=aramaButonu.uyariMesaji.getText();
        System.out.println("text = " + text);
        Assert.assertTrue(text.contains("Aradığınız ürün bulunmamaktadır."));
    }

    @And("Arama cubuguna veri girmez.")
    public void aramaCubugunaVeriGirmez() {

        bekle(3);
        aramaButonu.aramaButonu.sendKeys("");
    }

    @Then("Uyari mesajinin geldigini dogrular.")
    public void uyariMesajininGeldiginiDogrular() {
        bekle(5);
        String text=aramaButonu.uyariMesajiPoup.getText();
        System.out.println("text = " + text);
        Assert.assertTrue(text.contains("Lütfen özel karakterler girmeyiniz."));
    }


}


