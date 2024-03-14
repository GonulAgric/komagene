package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OturumKapatmaPage {

    public OturumKapatmaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
