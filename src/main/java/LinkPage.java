import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkPage {
    private WebDriver driver;

    // Локатор для ссылки "Подробнее о сервисе"
    private By moreInfoLinkLocator = By.xpath("//section[@class='pay']//a[text()='Подробнее о сервисе']");

    // Конструктор
    public LinkPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для получения URL из ссылки
    public String getMoreInfoLinkUrl() {
        WebElement link = driver.findElement(moreInfoLinkLocator);
        return link.getAttribute("href");
    }

    // Метод для перехода по ссылке
    public void clickMoreInfoLink() {
        WebElement link = driver.findElement(moreInfoLinkLocator);
        link.click();
    }
}
