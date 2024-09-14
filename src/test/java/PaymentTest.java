import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentTest extends BaseTest {
    private MainPage mainPage;

    @Test
    public void testPaymentProcessForConnectionService() {
        mainPage = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        mainPage.rejectCookies();

        mainPage.selectOption("Услуги связи");

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-phone']")));
        phoneInput.sendKeys("297777777");

        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-sum']")));
        sumInput.sendKeys("10");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")));

        WebElement amountSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='10.00 BYN']")));
        assertTrue(amountSpan.isDisplayed(), "Сумма 10.00 BYN не отображена корректно");

        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Оплатить  10.00 BYN')]")));
        assertTrue(payButton.isDisplayed(), "Кнопка 'Оплатить 10.00 BYN' не отображена корректно");

        WebElement phoneSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Номер:375297777777')]")));
        assertTrue(phoneSpan.isDisplayed(), "Введенный номер телефона отображен некорректно");

        WebElement cardNumberLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Номер карты']")));
        assertTrue(cardNumberLabel.isDisplayed(), "Надпись 'Номер карты' отсутствует");

        WebElement expiryDateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Срок действия']")));
        assertTrue(expiryDateLabel.isDisplayed(), "Надпись 'Срок действия' отсутствует");

        WebElement cvcLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='CVC']")));
        assertTrue(cvcLabel.isDisplayed(), "Надпись 'CVC' отсутствует");

        WebElement cardHolderLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Имя держателя (как на карте)']")));
        assertTrue(cardHolderLabel.isDisplayed(), "Надпись 'Имя держателя (как на карте)' отсутствует");

        WebElement visaIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']")));
        assertTrue(visaIcon.isDisplayed(), "Иконка Visa не отображена");

        WebElement mastercardIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']")));
        assertTrue(mastercardIcon.isDisplayed(), "Иконка MasterCard не отображена");

        WebElement belcardIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']")));
        assertTrue(belcardIcon.isDisplayed(), "Иконка Белкарт не отображена");

        WebElement cardsBrands = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cards-brands")));
        assertTrue(cardsBrands.isDisplayed(), "Мир или маэстро не отображена");

        driver.switchTo().defaultContent();
    }
}
