package hw2.ex2;

import hw2.BaseClass;
import org.testng.annotations.Test;

public class Exercise2 extends BaseClass {

    @Test(enabled = false)
//    @Test
    private void selectCheckboxesAndAssertTheirStatuses() {

    }

    @Test(enabled = false)
//    @Test
    private void selectRadiobuttonsAndAssertTheirStatusses() {

    }

    @Test(enabled = false)
//    @Test
    private void selectInDropdownAndAssertItsStatus() {

    }

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
