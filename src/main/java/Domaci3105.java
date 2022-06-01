import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Domaći:
Napisati dva smoke testa za https://www.telerik.com/support/demos:
Proveriti da klikom na Desktop odlazimo na tu sekciju
Proveriti da klikom na Mobile odlazimo na tu sekciju
Koristiti TestNG, asserte.
Domaći na git.
*/
public class Domaci3105 {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to("https://www.telerik.com/support/demos");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void testDesktopClick() {
        WebElement desktopClick = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktopClick.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualClass = desktopClick.getAttribute("class");
        String expectedClass = "NavAlt-anchor u-b0 is-active";

        Assert.assertEquals(actualClass, expectedClass);
    }

    @Test
    public void testMobileClick() {
        WebElement mobileClick = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobileClick.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualClass = mobileClick.getAttribute("class");
        String expectedClass = "NavAlt-anchor u-b0 is-active";

        Assert.assertEquals(actualClass, expectedClass);
    }
}
