package hw4.ex2;

import hw4.BaseTestClass;
import hw4.site.MetalsAndColorsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise2 extends BaseTestClass {

    @DataProvider
    public Object[][] metalsAndColorsDataProvider() {

        return new Object[][] {
                {MetalsAndColorsTestData.builder().setSummaryOdd(1).setSummaryEven(2)
                        .setElements(Arrays.asList("Earth")).setColor("Yellow").setMetal("Selen")
                        .setVegetables(Arrays.asList("Onion")).build()}
        };
    }

    @Test(dataProvider = "metalsAndColorsDataProvider")
    private void exerciseTest(MetalsAndColorsTestData testData) {

        // Tasks 1
        openSiteByURLAndCheckItsTitleTest();

        // Task 2
        loginAndCheckUsername(userName, password);

        // Task 3
        navigationHeaderObject.clickHeaderItem("Metals & Colors");
        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage(chromeDriver);

        // Task 4
        metalsAndColorsPage.getSummaryObject().clickElement(Integer.toString(testData.getSummaryEven()));
        metalsAndColorsPage.getSummaryObject().clickElement(Integer.toString(testData.getSummaryOdd()));
        metalsAndColorsPage.getColorsObject().selectByValue(testData.getColor());
        metalsAndColorsPage.getMetalsObject().selectByValue(testData.getMetal());

        MetalsAndColorsPage.ElementsObject elementsObject = metalsAndColorsPage.getElementsObject();
        List<String> elements = testData.getElements();
        for (String el : elements) {
            elementsObject.clickElement(el);
        }

        MetalsAndColorsPage.VegetablesObject vegetablesObject = metalsAndColorsPage.getVegetablesObject();
        List<String> vegetables = testData.getVegetables();
        for (String veg : vegetables) {
            vegetablesObject.selectByValue(veg);
        }

        // Task 5
        metalsAndColorsPage.getSubmitButton().clickButton();

        // Task 6
        List<String> results = metalsAndColorsPage.getResultSection().getTextFromSection();
        List<String> resultsPattern = Arrays.asList(
                "Summary: ",
                "Elements: ",
                "Color: ",
                "Metal: ",
                "Vegetables: "
        );
        assertEquals(results.size(), resultsPattern.size());
        for (int i = 0; i < resultsPattern.size(); ++i) {
            softAssert.assertTrue(results.get(i).contains(resultsPattern.get(i)));
        }

        softAssert.assertAll();
    }

    private static class MetalsAndColorsTestData {
        private int summaryOdd;
        private int summaryEven;
        private List<String> elements;
        private String color;
        private String metal;
        private List<String> vegetables;

        public MetalsAndColorsTestData(int summaryOdd, int summaryEven,
                                       List<String> elements, String color,
                                       String metal, List<String> vegetables) {

            this.summaryOdd = summaryOdd;
            this.summaryEven = summaryEven;
            this.elements = elements;
            this.color = color;
            this.metal = metal;
            this.vegetables = vegetables;
        }

        public static MetalsAndColorsBuilder builder() {

            return new MetalsAndColorsBuilder();
        }

        public int getSummaryOdd() {

            return summaryOdd;
        }
        public int getSummaryEven() {

            return summaryEven;
        }
        public List<String> getElements() {

            return elements;
        }
        public String getColor() {

            return color;
        }
        public String getMetal() {

            return metal;
        }
        public List<String> getVegetables() {

            return vegetables;
        }
    }

    private static class MetalsAndColorsBuilder {
        private int summaryOdd;
        private int summaryEven;
        private List<String> elements;
        private String color;
        private String metal;
        private List<String> vegetables;

        public MetalsAndColorsBuilder() {

        }

        public MetalsAndColorsBuilder setSummaryOdd(int summaryOdd) {

            this.summaryOdd = summaryOdd;
            return this;
        }
        public MetalsAndColorsBuilder setSummaryEven(int summaryEven) {

            this.summaryEven = summaryEven;
            return this;
        }
        public MetalsAndColorsBuilder setElements(List<String> elements) {

            this.elements = elements;
            return this;
        }
        public MetalsAndColorsBuilder setColor(String color) {

            this.color = color;
            return this;
        }
        public MetalsAndColorsBuilder setMetal(String metal) {

            this.metal = metal;
            return this;
        }
        public MetalsAndColorsBuilder setVegetables(List<String> vegetables) {

            this.vegetables = vegetables;
            return this;
        }
        public MetalsAndColorsTestData build() {
            return new MetalsAndColorsTestData(summaryOdd, summaryEven, elements, color, metal, vegetables);
        }
    }
}
