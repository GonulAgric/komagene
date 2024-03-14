package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
    public class FavorilerimPage {
        public FavorilerimPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "(//*[@class='card-img-center d-block w-100'])[3]")
        public WebElement durumler ;

        @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[1]/section/div[2]/div/div[1]/div[1]/div/img")
        public WebElement CigKoftedurum ;
        @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[1]/section/div[2]/div/div[1]/div[1]/div/img")
        public WebElement CigKoftedurumFavori ;

        @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article/section/div/div[2]/div[2]/div[1]/div/img")
        public WebElement CigKoftedurumFavori1 ;

        @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article[2]/section/div/div[3]/div[1]/div[1]/div/button/img")
        public WebElement favoriSimge ;

       @FindBy(xpath = "(//a[@class='dropdown-item'])[11]")
        public WebElement favoriUrunlerimiz ;

        @FindBy(xpath = "(//div[@class='hesabim-btn'])[2]")
        public WebElement hesabimButton;

        @FindBy(xpath = "//*[@id=\"popupProductDetailProductDetailLeft\"]/div/div/div[1]/button")
        public WebElement poup;

        @FindBy(xpath = "//*[@id=\"main-wrapper\"]/article/section")
        public WebElement favoriUrunlerContainer;

    }

