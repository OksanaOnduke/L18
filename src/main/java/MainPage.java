import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By titleLocator = By.xpath("//section[@class='pay']/div[@class='pay__wrapper']/h2");

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для получения текста заголовка
    public String getTitleText() {
        WebElement titleElement = driver.findElement(titleLocator);
        return titleElement.getText();
    }

    // Локатор для кнопки "Отклонить" в cookies
    private By cookiesRejectButton = By.xpath("//button[contains(text(), 'Отклонить')]");
    // Локатор для текущего выбранного значения в dropdown-меню
    private By currentDropdownValue = By.xpath("//span[@class='select__now']");

    // Локатор для всех опций в dropdown
    private By dropdownOptions = By.xpath("//p[@class='select__option']");

    // Локаторы для input-полей
    private By connectionPhoneInput = By.xpath("//*[@id='connection-phone']");
    private By connectionSumInput = By.xpath("//*[@id='connection-sum']");

    private By homeInternetPhoneInput = By.xpath("//*[@id='internet-phone']");
    private By homeInternetSumInput = By.xpath("//*[@id='connection-sum']");

    private By instalmentAccountInput = By.xpath("//*[@id='score-instalment']");
    private By instalmentSumInput = By.xpath("//*[@id='instalment-sum']");
    private By instalmentEmailInput = By.xpath("//*[@id='instalment-email']");

    private By arrearsAccountInput = By.xpath("//*[@id='score-arrears']");
    private By arrearsSumInput = By.xpath("//*[@id='arrears-sum']");
    private By arrearsEmailInput = By.xpath("//*[@id='arrears-email']");

    // Метод для обработки всплывающего окна cookies
    public void rejectCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement rejectButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesRejectButton));
            rejectButton.click();
            System.out.println("Всплывающее окно cookies отклонено");
        } catch (Exception e) {
            System.out.println("Всплывающее окно cookies не найдено или уже закрыто.");
        }
    }

    // Метод для выбора опции в dropdown-меню
    public void selectOption(String optionText) {
        // Сначала кликаем по текущему выбранному значению, чтобы открыть меню
        WebElement currentDropdown = driver.findElement(currentDropdownValue);
        currentDropdown.click();

        // Явное ожидание появления выпадающих опций
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptions));

        // Находим нужную опцию по тексту и кликаем на неё
        WebElement option = driver.findElement(By.xpath("//p[contains(text(), '" + optionText + "')]"));
        option.click();
    }

    // Получение placeholder или текста из input field
    public String getInputPlaceholder(By inputLocator) {
        WebElement inputField = driver.findElement(inputLocator);
        return inputField.getAttribute("placeholder");
    }

    // Методы для проверки placeholder-ов в зависимости от опции
    public String getConnectionPhonePlaceholder() {
        return getInputPlaceholder(connectionPhoneInput);
    }

    public String getConnectionSumPlaceholder() {
        return getInputPlaceholder(connectionSumInput);
    }

    public String getHomeInternetPhonePlaceholder() {
        return getInputPlaceholder(homeInternetPhoneInput);
    }

    public String getHomeInternetSumPlaceholder() {
        return getInputPlaceholder(homeInternetSumInput);
    }

    public String getInstalmentAccountPlaceholder() {
        return getInputPlaceholder(instalmentAccountInput);
    }

    public String getInstalmentSumPlaceholder() {
        return getInputPlaceholder(instalmentSumInput);
    }

    public String getInstalmentEmailPlaceholder() {
        return getInputPlaceholder(instalmentEmailInput);
    }

    public String getArrearsAccountPlaceholder() {
        return getInputPlaceholder(arrearsAccountInput);
    }

    public String getArrearsSumPlaceholder() {
        return getInputPlaceholder(arrearsSumInput);
    }

    public String getArrearsEmailPlaceholder() {
        return getInputPlaceholder(arrearsEmailInput);
    }
}
