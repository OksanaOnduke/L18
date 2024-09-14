import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoPresenceTest extends BaseTest {

    @Test
    public void testVisaLogoPresence() {
        LogosPage logosPage = new LogosPage(driver);
        assertTrue(logosPage.isVisaLogoDisplayed(), "Visa logo is not displayed on the page");
        System.out.println("Visa logo is displayed on the page.");
    }
    @Test
    public void testVisaVerifiedLogoPresence() {
        LogosPage logosPage = new LogosPage(driver);
        assertTrue(logosPage.isVisaVerifiedLogoDisplayed(), "VisaVerifiedLogo is not displayed on the page");
        System.out.println("VisaVerifiedLogo is displayed on the page");
    }

    @Test
    public void testMastercardLogoPresence() {
        LogosPage logosPage = new LogosPage(driver);
        assertTrue(logosPage.isMastercardLogoDisplayed(), "Mastercard logo is not displayed on the page");
        System.out.println("Mastercard logo is displayed on the page.");
    }

    @Test
    public void testMastercardSecureCodeLogoPresence() {
        LogosPage logosPage = new LogosPage(driver);
        assertTrue(logosPage.isMastercardSecureCodeLogoDisplayed(), "Mastercard Secure Code logo is not displayed on the page");
        System.out.println("Mastercard Secure Code logo is displayed on the page.");
    }

    @Test
    public void testBelcardLogoPresence() {
        LogosPage logosPage = new LogosPage(driver);
        assertTrue(logosPage.isBelcardLogoDisplayed(), "Belcard logo is not displayed on the page");
        System.out.println("Belcard logo is displayed on the page.");
    }
}
