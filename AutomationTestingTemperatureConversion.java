import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WindowType;

public class AutomationTestingTemperatureConversion {
    public static void main(String[] args) throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "/Users/goksualcinkaya/Downloads/chromedriver-mac-arm64/chromedriver");

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();

        String fahrenheitTemp[] = {"100", "-100", "1 0 0", "", "50.5"};
        String convertTo[] = {"Celsius", "Kelvin", "Celsius", "Kelvin", "Celsius"};

        for (int index = 0; index < fahrenheitTemp.length; index++) {
            driver.get("https://cmpsprojectgroup1.com/wpdemo/");

            WebElement element = driver.findElement(By.xpath("//a[@href='https://cmpsprojectgroup1.com/wpdemo/18-2/']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(3000);
            element.click();

            WebElement fahrenheit = driver.findElement(By.name("Fahrenheit"));
            fahrenheit.sendKeys(fahrenheitTemp[index]);
            WebElement conversionUnit = driver.findElement(By.id(convertTo[index]));
            conversionUnit.click();
            WebElement convertButton = driver.findElement(By.name("Convert"));
            convertButton.click();

            try {
                Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                Thread.sleep(5000);
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                driver.switchTo().newWindow(WindowType.TAB);
            } catch (Exception e) {
                driver.switchTo().newWindow(WindowType.TAB);
            }
        }
    }
}