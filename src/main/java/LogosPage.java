import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogosPage {
    private WebDriver driver;

    // Локаторы для логотипов
    private By visaLogoLocator = By.xpath("//section[@class='pay']//div[@class='pay__partners']//img[@alt='Visa']");
    private By visaVerifiedLogoLocator = By.xpath("//section[@class='pay']//div[@class='pay__partners']//img[@alt='Verified By Visa']");
    private By mastercardLogoLocator = By.xpath("//section[@class='pay']//div[@class='pay__partners']//img[@alt='MasterCard']");
    private By mastercardSecureCodeLogoLocator = By.xpath("//section[@class='pay']//div[@class='pay__partners']//img[@alt='MasterCard Secure Code']");
    private By belcardLogoLocator = By.xpath("//section[@class='pay']//div[@class='pay__partners']//img[@alt='Белкарт']");

    // Конструктор
    public LogosPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с логотипами

    public boolean isVisaLogoDisplayed() {
        WebElement visaLogo = driver.findElement(visaLogoLocator);
        return visaLogo.isDisplayed();
    }

    public boolean isVisaVerifiedLogoDisplayed() {
        WebElement visaVerifiedLogo = driver.findElement(visaVerifiedLogoLocator);
        return visaVerifiedLogo.isDisplayed();
    }

    public boolean isMastercardLogoDisplayed() {
        WebElement mastercardLogo = driver.findElement(mastercardLogoLocator);
        return mastercardLogo.isDisplayed();
    }

    public boolean isMastercardSecureCodeLogoDisplayed() {
        WebElement mastercardSecureCodeLogo = driver.findElement(mastercardSecureCodeLogoLocator);
        return mastercardSecureCodeLogo.isDisplayed();
    }

    public boolean isBelcardLogoDisplayed() {
        WebElement belcardLogo = driver.findElement(belcardLogoLocator);
        return belcardLogo.isDisplayed();
    }
}
