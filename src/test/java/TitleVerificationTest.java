import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitleVerificationTest extends BaseTest {

    @Test
    public void testTitleText() {
        MainPage mainPage = new MainPage(driver);
        String titleText = mainPage.getTitleText();
        System.out.println(titleText);
        assertEquals("Онлайн пополнение\nбез комиссии", titleText, "Название блока не соответствует ожидаемому!");
    }
}
