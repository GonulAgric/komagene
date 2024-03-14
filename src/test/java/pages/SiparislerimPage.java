package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
    public class SiparislerimPage {
        public SiparislerimPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy(xpath = "(//*[@class='dropdown-item'])[10]")
        public WebElement siparislerimButton;

        @FindBy(id = "ordersAccordion ")
        public WebElement siparislerTable;

        @FindBy(css = "#heading2 > button > div > div.col-md-2.text-end")
        public WebElement siparisDetayiButton;

        @FindBy(css = "#collapse0 > div > div > div.col-md-2.btn-group-vertical > div > button")
        public WebElement tekrarlaButton;

        @FindBy(xpath = "//*[@id=\"popupPagesOrderHistoryPage\"]/div/div/div[2]/div/div/div/div[2]/div[1]")
        public WebElement sepetimYonlendirmePopUp;

        @FindBy(css = "#main-wrapper > article > div:nth-child(2) > div:nth-child(2)")
        public WebElement siparislerimListe;
    }

