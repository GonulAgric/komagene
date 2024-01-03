package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
    public class FavorilerimPage {
        public FavorilerimPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy(xpath = "(//div[@class='row'])[144] ")
        public WebElement kategoriKartlari;
    }

