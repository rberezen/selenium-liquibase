import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

  protected WebDriver driver;
  protected static Properties prop = new Properties();
  static String basePath = System.getProperty("user.dir");

  static {
    // Load the configuration file in a static block
    try {
      InputStream input = TestBase.class.getClassLoader().getResourceAsStream("config.properties");
      prop.load(input);
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to load config.properties", e);
    }
  }

  @Before
  public void setUp() throws Exception {
    // Set the path to your ChromeDriver
    System.setProperty("webdriver.chrome.driver", basePath + "/" + prop.getProperty("webdriver.chrome.driver"));

    // Create a new instance of the Chrome driver
    driver = new ChromeDriver();

    // Navigate to the base URL
    driver.get(prop.getProperty("base.url"));
  }

  @After
  public void tearDown() {
    // Close the browser
    if (driver != null) {
      driver.quit();
    }
  }
}

