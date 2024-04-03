package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.SmokePage;
import pages.TeslimatTuruGelAlPage;

import static utilities.ReusableMethods.bekle;

public class TeslimatTuruGelAlStepDef {

   TeslimatTuruGelAlPage teslimatGelAl=new TeslimatTuruGelAlPage();
    SmokePage smokePage = new SmokePage();
    @When("Acilan sayfada Gel Al servis secenegine tiklar.")
    public void acilan_sayfada_gel_al_servis_secenegine_tiklar() {
        bekle(5);
        teslimatGelAl.teslimatTuruGelAl.click();

    }

    @And("Secili adresle devam et butonuna tiklar.")
    public void seciliAdresleDevamEtButonunaTiklar() {
        bekle(5);
        smokePage.seciliAdresleDevam.click();
    }
}
