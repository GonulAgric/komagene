package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
    public class SepetimPage {
        public SepetimPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy(linkText = "Siparişlerim ")
        public WebElement siparislerimButton;

        @FindBy(id = "ordersAccordion ")
        public WebElement siparislerTable;

        @FindBy(linkText = "SİPARİŞ DETAYI ")
        public WebElement siparisDetayiButton;

        @FindBy(linkText = "Tekrarla")
        public WebElement tekrarlaButton;

        @FindBy(xpath = "(//div[@class='col-md-12'])[108]")
        public WebElement sepetimYonlendirmePopUp;
    }

