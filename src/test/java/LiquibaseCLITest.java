import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LiquibaseCLITest extends TestBase {

  @BeforeClass
  public static void seedDatabase() {
    // Initialize liquibase
    LiquibaseCLIExecutor liquibase = new LiquibaseCLIExecutor();

    // Clean up database before seeding by executing liquibase dropALL
    liquibase.executeLiquibaseCommand(prop.getProperty("liquibase.dir"), // Path to your Liquibase folder
        prop.getProperty("liquibase.executable"), // Liquibase executable
        "--defaults-file", basePath + "/" + prop.getProperty("liquibase.properties"), // Liquibase --argument and value
        "dropAll" // Liquibase command
    );

    // Seed database by executing liquibase update
    liquibase.executeLiquibaseCommand(prop.getProperty("liquibase.dir"), // Path to your Liquibase folder
        prop.getProperty("liquibase.executable"), // Liquibase executable
        "--defaults-file", basePath + "/" + prop.getProperty("liquibase.properties"), // Liquibase --argument and value
        "update" // Liquibase command
    );
  }

  @Test
  public void webCLITest() {

    // Refresh the webpage
    driver.navigate().refresh();

    // Find the element by its ID
    WebElement infoFrame = driver.findElement(By.id("infoFrame"));

    // Get the text content of the element
    String infoFrameText = infoFrame.getText();

    // Assert that the text content contains "Rus"
    Assert.assertTrue("The element text does not contain 'Ber'", infoFrameText.contains("Ber"));
  }
}
