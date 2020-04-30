package hw5.ex1;

import hw5.AbstractSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Exercise1Steps extends AbstractSteps {

    private List<WebElement> elements;
    private WebElement element;

    public List<WebElement> getHeaderItems() {

        elements = indexPage.getNavigationHeaderObject().getnavigationHeaderItems();
        return elements;
    }

    public List<WebElement> getBenefitIcons() {

        elements = indexPage.getBenefitIconsObject().getbenefitIcons();
        return elements;
    }

    public List<WebElement> getBenefitTexts() {

        elements = indexPage.getBenefitTextsObject().getBenefitTexts();
        return elements;
    }

    public List<WebElement> getLeftMenuItems() {

        elements = indexPage.getLeftMenuObject().getLeftMenuItems();
        return elements;
    }

    public WebElement getFrameButton() {

        element = indexPage.getFrameButtonObject().getFrameButton();
        return element;
    }

    public WebElement getFrameButtonFromFrame() {

        chromeDriver.get(chromeDriver.findElement(
                By.xpath("//*[@id='frame']")).getAttribute("src"));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@value='Frame Button']")));
        return element;
    }

    public void numberOfElementsGotInPreviousStepShouldBe(int expectedNumberOfElements) {

        softAssert.assertEquals(elements.size(), expectedNumberOfElements);
    }

    public void elementsGotInPreviousStepShouldBe(List<String> expectedElements) {

        softAssert.assertNotSame(elements, expectedElements);
    }

    public void elementGotInPreviousStepAttributeValueShouldBe(String expectedAttributeValue, String attributeName) {

        String result = element.getAttribute(attributeName);
        softAssert.assertEquals(result, expectedAttributeValue);
    }

}
