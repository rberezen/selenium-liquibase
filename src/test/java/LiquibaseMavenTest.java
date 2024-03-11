import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LiquibaseMavenTest extends TestBase {

  @Test
  public void webMavenTest() {
    // Find the element by its ID
    WebElement infoFrame = driver.findElement(By.id("infoFrame"));

    // Get the text content of the element
    String infoFrameText = infoFrame.getText();

    // Assert that the text content contains "Rus"
    Assert.assertTrue("The element text does not contain 'Rus'", infoFrameText.contains("Rus"));
  }
}
