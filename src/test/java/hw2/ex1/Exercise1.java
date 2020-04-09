package hw2.ex1;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseClass {

    // FIXME delete after debugging
    @Deprecated
    private void sleep() {

        try {
            Thread.sleep(WAIT_TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
