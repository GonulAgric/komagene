package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KampanyalarPage {

    public KampanyalarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "campingSlider")
    public WebElement kampanyalar ;

    @FindBy(id = "")
    public WebElement kampanyaDetay ;

    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article/section/div[2]/div/ul/div/div[3]/div[2]/button")
    public WebElement sepeteEkleButton ;

}
