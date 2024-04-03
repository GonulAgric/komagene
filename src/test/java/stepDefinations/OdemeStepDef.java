package stepDefinations;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.OdemePage;

import static utilities.ReusableMethods.bekle;

public class OdemeStepDef {

OdemePage odeme=new OdemePage();
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

}
