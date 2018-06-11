import static org.testng.Assert.*;
import org.json.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;


@Test
public class FacebookLoginTest {
    @Test
    public void testSuccessfulLogin() throws JSONException, IOException {
        //reading entire json
        String entireFile =  new String(Files.readAllBytes(Paths.get("tests.json")));

        System.out.println(entireFile);

        JSONObject AllTests = new JSONObject(entireFile);
        JSONArray tests = AllTests.getJSONArray("Tests");

        //For loop will repeatedly test so long as we have tests defined in the json.
        for (int i = 0; i < tests.length(); i++)
        {
            //Grabbing the username and password we wish to test
            String userName = tests.getJSONObject(i).getString("username");
            String password = tests.getJSONObject(i).getString("password");

            //Actual actions to login to facebook.
            WebsiteUser TestUser = new WebsiteUser();
            TestUser.navigateUrl("https://www.facebook.com/");
            TestUser.enterText(By.id("email"), userName);
            TestUser.enterText(By.id("pass"), password);
            TestUser.clickButton(By.id("loginbutton"));

            //Checking we have successfully navigated to the next Facebook page whose title is Facebook.
            String ExpectedPageTitle = "Facebook";
            System.out.println(System.getProperty("os.name"));

            //Checking the page title contains 'Facebook'
            assertTrue(Pattern.matches(".*Facebook", TestUser.getUserDriver().getTitle()));

            //Checking we weren't asked to provide login credentials again.
            assertEquals(TestUser.getUserDriver().findElements( By.id("email") ).size() == 0, true);
            assertEquals(TestUser.getUserDriver().findElements( By.id("pass") ).size() == 0, true);

            //Checking for the Home link and account settings drop down to verify we are logged in.
            assertEquals(TestUser.getUserDriver().findElements(By.xpath("//*[.=\"Home\"]")).size() != 0, true);
            assertEquals(TestUser.getUserDriver().findElements(By.id("userNavigationLabel")).size() != 0, true);

            //shutting down this WebDriver
            TestUser.quit();
        }
    }
}