package es.aesan.rgseaa.test.selenium;

import com.google.common.net.HttpHeaders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPageTest {

    WebDriver driver;
    MainPage mainPage;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get(Constant.SERVER+Constant.URL_LOGIN);
        TimeUnit.SECONDS.sleep(1);
        mainPage.login();
        TimeUnit.SECONDS.sleep(1);

    }

}
