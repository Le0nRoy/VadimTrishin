package hw2.ex1;

import hw2.BaseClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise1 extends BaseClass {

    @Test
    public void openSiteByURLAndCheckItsTitleTest() {
        chromeDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
        String ret = chromeDriver.getTitle();
        String expected = "Home Page";
        assertEquals(ret, expected);

        // TODO replace with WebDriver wait methods (is it needed at all?)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
