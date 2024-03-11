import java.sql.SQLException;
import liquibase.exception.LiquibaseException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LiquibaseAPITest extends TestBase {

  @BeforeClass
  public static void seedDatabase() throws ClassNotFoundException, SQLException, LiquibaseException {
    // Initialize liquibase
    LiquibaseAPIExecutor liquibaseAPIExecutor = new LiquibaseAPIExecutor();

    // Clean up database before seeding by executing liquibase dropALL
    liquibaseAPIExecutor.dropAll("liquibase_files/changelog_api.sql");

    // Seed database by executing liquibase update
    liquibaseAPIExecutor.update("liquibase_files/changelog_api.sql");
  }

  @Test
  public void webAPITest() {
    // Refresh the webpage
    driver.navigate().refresh();

    // Find the element by its ID
    WebElement infoFrame = driver.findElement(By.id("infoFrame"));

    // Get the text content of the element
    String infoFrameText = infoFrame.getText();

    // Assert that the text content contains "API"
    Assert.assertTrue("The element text does not contain 'API'", infoFrameText.contains("API"));
  }
}
