package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TeslimatTuruGelAlPage {

    public TeslimatTuruGelAlPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"deliveryTypeChooseForm\"]/div/div/div[2]/div/div[2]/div[3]/div/div[2]/div")
    public WebElement teslimatTuruGelAl;


}
