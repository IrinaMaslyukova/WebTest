import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Example_3 {
    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver", "E:\\Instal\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "E:\\Instal\\chromedriver_win32_2\\chromedriver.exe");
//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.i.ua/");
        if (driver.findElement(By.xpath("//input[@name='login']")).isEnabled()) {
            System.out.println("Google search text box Is enabled.");
            driver.findElement(By.xpath("//input[@name='login']")).sendKeys("mogilat");
            driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("rfrnec");
            Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='domn']")));
            dropdown.selectByVisibleText("ua.fm");
            driver.findElement(By.xpath("//input[@value='Войти']")).click();
            System.out.println(driver.findElement(By.xpath("//div[@class='pager float_right']")).getText() + "test is passed");

        } else {
            System.out.println("test is failed");

        }
        driver.close();
    }
}
