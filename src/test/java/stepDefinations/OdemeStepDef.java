package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.OdemePage;
import pages.SmokePage;

import static utilities.ReusableMethods.*;

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
        bekle(5);
        odeme.siparisiTamamlaButton.click();
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
        bekle(3);
        odeme.kapidaOdeme.click();
    }

    @And("Odeme yontemi seciniz dropdown menuden nakit odemeye tiklar.")
    public void odemeYontemiSecinizDropdownMenudenNakitOdemeyeTiklar() {
        bekle(3);
        ddmIndex(odeme.odemeYontemiDropDown,1);
    }

    @And("Acilan adres degistir sayfasini kapatir.")
    public void acilanAdresDegistirSayfasiniKapatir() {
        bekle(3);
        odeme.adresDegistirSAyfasiKapatmaButonu.click();
    }

    @And("Mesafeli satış sozlesmesi butonunu isaretler.")
    public void mesafeliSatışSozlesmesiButonunuIsaretler() {
        bekle(3);
        odeme.mesafeliSatisSözlesmesi.click();
    }

    @Then("Siparisin tamamlandigini dogrular.")
    public void siparisinTamamlandiginiDogrular() {
        bekle(3);
        String text=odeme.siparisAlindiPopUp.getText();
        System.out.println(text);
        bekle(3);
        Assert.assertTrue(text.contains("Siparişiniz alındı."));
    }

    @And("Odeme yontemi secmez.")
    public void odemeYontemiSecmez() {
        
    }

    @Then("Uyari mesaji almali.")
    public void uyariMesajiAlmali() {
        bekle(3);
        String text= odeme.odemeYontemiUyariMesaji.getText();
        System.out.println(text);
        bekle(3);
        Assert.assertTrue(text.contains("Lütfen ödeme yöntemi seçiniz."));
    }

    @And("Mesafeli satis sozlesmesini bos birakir.")
    public void mesafeliSatisSozlesmesiniBosBirakir() {
        
    }


    @Then("Kullanici uyari mesajini alir.")
    public void kullaniciUyariMesajiniAlir() {
        bekle(3);
        String text= odeme.mesafeliSatisSozlesmesiUyariMesaji.getText();
        System.out.println(text);
        bekle(3);
        Assert.assertTrue(text.contains("Lütfen mesafeli satış sözleşmesini okduğunuzu belirtiniz."));
    }

    @And("Odeme yontemi seciniz dropdown menuden kredi karti ile odemeye tiklar.")
    public void odemeYontemiSecinizDropdownMenudenKrediKartiIleOdemeyeTiklar() {
        bekle(5);
        ddmIndex(odeme.odemeYontemiDropDown,2);

    }

    @And("Kayitli kartlarindan birini ekler.")
    public void kayitliKartlarindanBiriniEkler() {
        //Kart bilgileri gelince yazılacak
    }

    @Then("Kayitli karti tekrar kaydedince uyari mesaji alir.")
    public void kayitliKartiTekrarKaydedinceUyariMesajiAlir() {
        //Sistem fake kart bilgilerini kabul etmiyor.Hata çözülünce yazılacak.
    }

    @And("Siparis notu bolumune alici ve telefon bilgisi girer.")
    public void siparisNotuBolumuneAliciVeTelefonBilgisiGirer() {
        bekle(3);
        click(odeme.farkliBirAliciGirmekIstiyorum);
        bekle(3);
        odeme.farkliBirAliciGirmekIstiyorumAdAlani.sendKeys("Ayşe");
        bekle(3);
        odeme.farkliBirAliciGirmekIstiyorumTelefonAlani.sendKeys("5461127610");
        bekle(2);
        odeme.farkliBirAliciGirmekIstiyorumTamamButton.click();
    }

    @Then("Siparis notu bolumune alici ve telefon bilgisinin geldigini dogrular.")
    public void siparisNotuBolumuneAliciVeTelefonBilgisininGeldiginiDogrular() {
        String text= odeme.siparisNotu.getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("Alıcı Adı Soyadı:Ayşe, Alıcı Telefon:5461127610"));
    }

    @And("Sepetin minimum sepet tutarının altında kaldığını görür.")
    public void sepetinMinimumSepetTutarınınAltındaKaldığınıGörür() {
        bekle(3);
        String sepetTutariMetni = odeme.sepetTutari.getText();
        System.out.println("sepetTutariMetni = " + sepetTutariMetni);
        // Metni uygun şekilde parçalayarak sadece sayısal değeri al
        String[] parts = sepetTutariMetni.split("\n"); // Metni "SEPET TUTARI" ibaresinden bölelim
        String sepetTutariSayisi = parts[1].replace("TL", "").trim(); // "TL" ibaresini kaldırıp boşlukları temizleyelim

        // Sepet tutarını double türüne çevir
        double sepetTutari = Double.parseDouble(sepetTutariSayisi);

        // Minimum sepet tutarı
        double hedefTutar = 65.0; // Hedef minimum sepet tutarı, istediğiniz değere göre değiştir
        bekle(5);
        odeme.siparisVer.click();
        // Minimum sepet tutarını kontrol et
        if (sepetTutari < hedefTutar) {
            System.out.println("Uyarı: Sepet tutarı 65 TL'nin altında!");
            // Eğer sepet tutarı hedef tutardan küçükse, uyarı mesajını kontrol et
            bekle(10);
            click(odeme.siparisVer);
            bekle(5);
            String uyariMesajiIçeriyorMu = odeme.sepetTutariUyariPoup.getText();
            Assert.assertTrue("Uyarı mesajı beklenen metni içermiyor: " + uyariMesajiIçeriyorMu, uyariMesajiIçeriyorMu.contains("Toplam tutar, minimum sipariş tutarından küçük."));
        } else {
            System.out.println("Sepet tutarı 65 TL veya daha fazla.");
        }

    }

    @And("Sipariş ver butonuna tiklar")
    public void siparişVerButonunaTiklar() {
        bekle(3);
      click( odeme.siparisVer);
    }
}
