package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHeaderBurger {
    private WebDriver driver;

    public PageHeaderBurger(WebDriver driver) {
        this.driver = driver;
    }

    //ссылка на "Конструктор"
    private By constructorLink = By.xpath("//p[text()='Конструктор']");

    //ссылка на "Личный кабинет"
    private By profileLink = By.xpath("//p[text()='Личный Кабинет']");

    //логотип
    private By logoBurger = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    public void clickProfileLink() {
        driver.findElement(profileLink).click();
    }

    public void clickLogoBurger() {
        driver.findElement(logoBurger).click();
    }
}
