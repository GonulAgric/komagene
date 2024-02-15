package utilities;





import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class ReusableMethods {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;


    //HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {

        Driver.getDriver().switchTo().alert().accept();

    }

    //Alert DISMISS
    public static void alertDismiss() {

        Driver.getDriver().switchTo().alert().dismiss();

    }

    //Alert getText()
    public static void alertText() {

        Driver.getDriver().switchTo().alert().getText();

    }

    //Alert promptBox
    public static void alertprompt(String text) {

        Driver.getDriver().switchTo().alert().sendKeys(text);

    }

    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchToWindow1
    public static void switchToWindow(int sayi) {

        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));

    }

    //SwitchToWindow2
    public static void window(int sayi) {

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());

    }
    //EXPLICIT WAIT METHODS

    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }



    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }






    //Alert Wait
    public static void alertWait(int sayi) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));

        wait.until(ExpectedConditions.alertIsPresent());

    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

    //Tüm Sayfa ScreenShot
    public static void tumSayfaResmi(String name) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        String dosyaYolu = "TestOutput/screenshot/screenshot" + tarih + name + ".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();

        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElement ScreenShot
    public static void webElementResmi(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/webElementScreenshot" + tarih + ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //ExtentReport
    public static void extentReport() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Erol");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
    }

    //WebTable
    public static void printData(int satir, int sutun) {

        WebElement satirSutun = Driver.getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));

        System.out.println(satirSutun.getText());
    }

    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

            js.executeScript("arguments[0].click();", element);
        }
    }

    //JS Scroll
    public static void scroll(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void scrollHome() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SendAttributeValue
    public static void sendAttributeJS(WebElement element, String text) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }


    public static void clickWithJS(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        }
    }

    public static void downloadPDF(String pdfURL, String savePath) {
        try {
            URL url = new URL(pdfURL);
            InputStream in = new BufferedInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }

            in.close();
            fileOutputStream.close();
            System.out.println("PDF dosyası başarıyla indirildi.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateTokenAdmin() {

        Map<String, Object> body = new HashMap<>();
        body.put("password", ConfigReader.getProperty("admin_password"));
        body.put("username", ConfigReader.getProperty("admin_username"));


        Response response = given().contentType(ContentType.JSON).body(body).post("https://managementonschools.com/app/auth/login");
        return response.jsonPath().getString("token");

    }

    public static String smsKod() {

        Map<String, Object> body = new HashMap<>();
        body.put("FirmaId", 32);
        body.put("Telefon", "5461127610");


        Response response = given().contentType(ContentType.JSON).body(body).post("https://gateway.supergrup.com/auth/auth/testicinguvenlikoduver");
        return response.jsonPath().getString("");

    }

    public static void  windowHandle() {
        String anaPencereHandle = Driver.getDriver().getWindowHandle();
        // Üye ol pop-up ekranına geçiş yap
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                break;
            }
        }


    }



        public static void urlDogrulama(String text) {
            String mainWindowHandle = Driver.getDriver().getWindowHandle();

            Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
            for (String handle : allWindowHandles) {
                if (!handle.equals(mainWindowHandle)) {
                    Driver.getDriver().switchTo().window(handle);

                    // Sayfanın yüklenmesini bekleyin
                    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.urlContains(text));

                    assertTrue("Kullanici ilgili sayfaya yonlendirilemedi", Driver.getDriver().getCurrentUrl().contains(text));
                    bekle(10);
                    // Pencere kapatma
                    Driver.getDriver().close();

                    // Ana pencereye geri dön
                    Driver.getDriver().switchTo().window(mainWindowHandle);
                }
            }
        }

    public static WebElement getBannerElement(String bannerId) {
        By bannerLocator = By.id(bannerId);
        return Driver.getDriver().findElement(bannerLocator);
    }


}







