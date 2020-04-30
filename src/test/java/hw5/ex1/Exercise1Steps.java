package hw5.ex1;

import hw5.AbstractSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Exercise1Steps extends AbstractSteps {

    private List<WebElement> elements;
    private WebElement element;

    @Step("Get header items")
    public List<WebElement> getHeaderItems() {

        elements = indexPage.getNavigationHeaderObject().getnavigationHeaderItems();
        return elements;
    }

    @Step("Get benefit icons")
    public List<WebElement> getBenefitIcons() {

        elements = indexPage.getBenefitIconsObject().getbenefitIcons();
        return elements;
    }

    @Step("Get benefit texts")
    public List<WebElement> getBenefitTexts() {

        elements = indexPage.getBenefitTextsObject().getBenefitTexts();
        return elements;
    }

    @Step("Get left menu items")
    public List<WebElement> getLeftMenuItems() {

        elements = indexPage.getLeftMenuObject().getLeftMenuItems();
        return elements;
    }

    @Step("Get frame button")
    public WebElement getFrameButton() {

        element = indexPage.getFrameButtonObject().getFrameButton();
        return element;
    }

    @Step("Get frame button from inside frame")
    public WebElement getFrameButtonFromFrame() {

        chromeDriver.get(chromeDriver.findElement(
                By.xpath("//*[@id='frame']")).getAttribute("src"));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@value='Frame Button']")));
        return element;
    }

    @Step("Number of elements in previous step should be '{0}")
    public void numberOfElementsGotInPreviousStepShouldBe(int expectedNumberOfElements) {

        softAssert.assertEquals(elements.size(), expectedNumberOfElements);
    }

    @Step("Elements got in previous step should be '{0}")
    public void elementsGotInPreviousStepShouldBe(List<String> expectedElements) {

        softAssert.assertNotSame(elements, expectedElements);
    }

    @Step("Attribute '{1}' of element got in previous step should be '{0}")
    public void elementGotInPreviousStepAttributeValueShouldBe(String expectedAttributeValue, String attributeName) {

        String result = element.getAttribute(attributeName);
        softAssert.assertEquals(result, expectedAttributeValue);
    }

}
