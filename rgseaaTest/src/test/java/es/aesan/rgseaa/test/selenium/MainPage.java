package es.aesan.rgseaa.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='autentication']")
    public WebElement buttonAutentication;

    @FindBy(xpath = "//*[@id='login_nif']")
    public WebElement inputLoginNif;

    @FindBy(xpath = "//*[@id='login_pass']")
    public WebElement inputLoginPass;

    @FindBy(xpath = "//*[@id='login_acceder']")
    public WebElement buttonLoginAcceder;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() throws InterruptedException {
        buttonAutentication.click();
        TimeUnit.SECONDS.sleep(1);
        inputLoginNif.sendKeys("99999018D");
        TimeUnit.SECONDS.sleep(1);
        inputLoginPass.sendKeys("1234");
        TimeUnit.SECONDS.sleep(1);
        buttonLoginAcceder.click();
    }

}
