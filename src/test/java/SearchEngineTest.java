import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchEngineTest {
   private WebDriver driver;
   private SearchEngine searchEngine;

   @Before
   public void setUp() {
      driver = new ChromeDriver();
      searchEngine = new SearchEngine();
   }

   @Test
   public void testSearch() {
      // Navigate to the website and perform the search
      driver.get("https://www.google.com/");
      List<String> results = searchEngine.search("Selenium Java");

      // Verify the results
      assertTrue(results.size() > 0);
      for (String result : results) {
         assertTrue(result.contains("Selenium"));
         assertTrue(result.contains("Java"));
      }
   }

   @After
   public void tearDown() {
      driver.quit();
   }
}
