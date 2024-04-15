package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.OdemePage;
import pages.SmokePage;

import static utilities.ReusableMethods.bekle;

public class OdemeStepDef {

    OdemePage odeme=new OdemePage();
    SmokePage smokePage = new SmokePage();
    @And("Odeme seceneklerini goruntuler ve secer.")
    public void odeme_seceneklerini_goruntuler_ve_secer() {
        bekle(3);
       String odemeSecenekleri= odeme.odemeSecenekleri.getText();
       System.out.println(odemeSecenekleri);
        Assert.assertTrue(odemeSecenekleri.contains("ONLİNE/KREDİ KARTI\n" +
                "ŞUBEDE ÖDEME"));
        bekle(3);

        if (odeme.onlineKrediKartiButton.isEnabled() && odeme.subedeOdemeButton.isEnabled()) {
            System.out.println("Her iki ödeme seçeneği de seçilebilir durumda.");
        } else {
            System.out.println("En az bir ödeme seçeneği seçilemez durumda.");
        }


    }

    @And("Kart bilgilerini girer")
    public void kartBilgileriniGirer() {

        odeme.kartSahibiButton.sendKeys("Test Test");
        bekle(3);
        odeme.kartNumarasiButton.sendKeys("4871460000000004");
        bekle(3);
        odeme.kartAyButton.sendKeys("10");
        bekle(3);
        odeme.kartYılButton.sendKeys("33");
        bekle(3);
        odeme.kartCvvButton.sendKeys("156");

    }

    @And("Bu kart bilgilerimi saklamak istiyorum checkbox tiklar.")
    public void buKartBilgilerimiSaklamakIstiyorumCheckboxTiklar() {
        bekle(3);
        odeme.kartBilgilerimiSaklamakIstiyorumButton.click();
        
    }

    @Then("Kart bilgilerinin saklandigini dogrular.")
    public void kartBilgilerininSaklandiginiDogrular() {
        // Kart bilgileri geldiği zaman yazılacak
    }

    @And("Gecersiz kart bilgileri girer")
    public void gecersizKartBilgileriGirer() {
        odeme.kartSahibiButton.sendKeys("a");
        bekle(3);
        odeme.kartNumarasiButton.sendKeys("5555556666663333");
        bekle(3);
        odeme.kartAyButton.sendKeys("1");
        bekle(3);
        odeme.kartYılButton.sendKeys("22");
        bekle(3);
        odeme.kartCvvButton.sendKeys("150");
        bekle(3);
        odeme.mesafeliSatisButton.click();


    }

    @Then("Uyari mesaji alir.")
    public void uyariMesajiAlir() {
        bekle(10);
        String text= odeme.paymentEkrani.getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("HATA!\n" +
                "Beklenmeyen bir hata oluştu! Lütfen daha sonra tekrar deneyiniz."));
    }


    @And("Siparis notu bolumune yuz karakterden az bir not yazar.")
    public void siparisNotuBolumuneYuzKarakterdenAzBirNotYazar() {
        bekle(3);
        odeme.siparisNotu.sendKeys("Lütfen zile basmayınız");

    }

    @And("Siparis notu bolumune yuz karakterden fazla bir not yazar.")
    public void siparisNotuBolumuneYuzKarakterdenFazlaBirNotYazar() {
        bekle(3);
        odeme.siparisNotu.sendKeys("aaaaaaaaaabbbbbbbbbbbccccccccccnnnnnnnnnnmmmmmmmmmmööööööööööşşşşşşşşşşkkkkkkkkkkjjjjjjjjjjıııııııııı");
    }


    @Then("Uyari mesajini alir")
    public void uyariMesajiniAlir() {
        bekle(3);
        String text=odeme.siparisNotuUyariMesaji.getText();
        bekle(3);
        Assert.assertTrue(text.contains("Sipariş notu en fazla 100 karekter girilmelidir."));
    }

    @And("Sakli kart bilgilerimi kullanmak istiyorum kutusunu isaretler.")
    public void sakliKartBilgilerimiKullanmakIstiyorumKutusunuIsaretler() {

        smokePage.saklıKArtBilgilerimiKul.click();

    }

    @And("Kayitli kartlarindan birini secer.")
    public void kayitliKartlarindanBiriniSecer() {
        Select dropdown = new Select(smokePage.odemeKArtıDropdown);
        dropdown.selectByIndex(1);
        bekle(2);
    }

    @And("Siparis tamamla butonuna tiklar.")
    public void siparisTamamlaButonunaTiklar() {
        bekle(3);
        smokePage.siparisiTamamla.click();
    }

    @And("Kart bilgimi sil kutusunu isaretler.")
    public void kartBilgimiSilKutusunuIsaretler() {
        bekle(3);
       // odeme.kartBilgimiSil.click();  // Kart bilgileri gelince açılaçak.
    }

    @And("Yeni kart ekle butonuna tiklar.")
    public void yeniKartEkleButonunaTiklar() {
        bekle(3);
        odeme.yeniKartEkle.click();
    }

    @And("Yeni kart bilgilerini girer.")
    public void yeniKartBilgileriniGirer() {

        bekle(5);
        odeme.yeniKartEklekartSahibi.sendKeys("Test Test");
        bekle(3);

        bekle(3);
        odeme.kartAyButton.sendKeys("10");
        bekle(3);
        odeme.kartYılButton.sendKeys("2033");
        bekle(3);
        odeme.kartCvvButton.sendKeys("156");
    }

    @And("Kart bilgilerimi kaydet butonuna tıklar.")
    public void kartBilgilerimiKaydetButonunaTıklar() {
        bekle(3);
        odeme.kartBilgimiKaydet.click();
    }

    @When("Kapıda odeme secenegine tiklar.")
    public void kapıdaOdemeSecenegineTiklar() {
    }
}
