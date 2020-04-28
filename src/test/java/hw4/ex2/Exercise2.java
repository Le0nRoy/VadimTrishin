package hw4.ex2;

import hw4.BaseTestClass;
import hw4.site.MetalsAndColorsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise2 extends BaseTestClass {

    @DataProvider
    public Object[][] metalsAndColorsDataProvider() {

        return new Object[][]{
                {MetalsAndColorsTestData.builder().setElements(Arrays.asList("Earth")).setColor("Yellow")
                        .setMetal("Gold").build()},
                {MetalsAndColorsTestData.builder().setSummaryOdd(3).setSummaryEven(8)
                        .setVegetables(Arrays.asList("Cucumber", "Tomato")).build()},
                {MetalsAndColorsTestData.builder().setSummaryOdd(3).setSummaryEven(2)
                        .setElements(Arrays.asList("Wind", "Fire", "Water")).setMetal("Bronze")
                        .setVegetables(Arrays.asList("Onion")).build()},
                {MetalsAndColorsTestData.builder().setSummaryOdd(5).setSummaryEven(6)
                        .setElements(Arrays.asList("Water")).setColor("Green").setMetal("Selen")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")).build()},
                {MetalsAndColorsTestData.builder().setElements(Arrays.asList("Fire")).setColor("Blue")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).build()}
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
        if (testData.getSummaryOdd() != 0) {
            metalsAndColorsPage.getSummaryObject().clickElement(Integer.toString(testData.getSummaryEven()));
            metalsAndColorsPage.getSummaryObject().clickElement(Integer.toString(testData.getSummaryOdd()));
        }
        if (testData.getColor() != null) {
            metalsAndColorsPage.getColorsObject().selectByValue(testData.getColor());
        }
        if (testData.getMetal() != null) {
            metalsAndColorsPage.getMetalsObject().selectByValue(testData.getMetal());
        }

        List<String> elements;
        if (testData.getElements() != null) {
            MetalsAndColorsPage.ElementsObject elementsObject = metalsAndColorsPage.getElementsObject();
            elements = testData.getElements();
            for (String el : elements) {
                elementsObject.clickElement(el);
            }
        }

        List<String> vegetables;
        if (testData.getVegetables() != null) {
            MetalsAndColorsPage.VegetablesObject vegetablesObject = metalsAndColorsPage.getVegetablesObject();
            // Deselect default value
            vegetablesObject.selectByValue("Vegetables");
            vegetables = testData.getVegetables();
            for (String veg : vegetables) {
                vegetablesObject.selectByValue(veg);
            }
        }

        // Task 5
        metalsAndColorsPage.getSubmitButton().clickButton();

        // Task 6
        // Check results by pattern and parse them
        List<String> results = metalsAndColorsPage.getResultSection().getTextFromSection();
        List<String> resultsPattern = new ArrayList<String>();
        resultsPattern.add("Summary: ");
        if (testData.getElements() != null) {
            resultsPattern.add("Elements: ");
        }
        resultsPattern.add("Color: ");
        resultsPattern.add("Metal: ");
        resultsPattern.add("Vegetables: ");

        assertEquals(results.size(), resultsPattern.size());
        for (
                int i = 0; i < resultsPattern.size(); ++i) {
            softAssert.assertTrue(results.get(i).contains(resultsPattern.get(i)));
            results.set(i, results.get(i).split(resultsPattern.get(i))[1]);
        }

        int posSummary = 0;
        int posElements = 1;
        int posColor = 2;
        int posMetal = 3;
        int posVegetables = 4;

        // Check results
        if (testData.getSummaryOdd() != 0) {
            softAssert.assertEquals(results.get(posSummary),
                    Integer.toString(testData.getSummaryEven() + testData.getSummaryOdd()));
        }

        if (testData.getElements() != null) {
            elements = testData.getElements();
            String elementsResult = results.get(posElements);
            softAssert.assertEquals(elementsResult.split(", ").length, elements.size());
            for (String str : elements) {
                softAssert.assertTrue(elementsResult.contains(str));
            }
        } else {
            posColor = 1;
            posMetal = 2;
            posVegetables = 3;
        }

        if (testData.getColor() != null) {
            softAssert.assertEquals(results.get(posColor), testData.getColor());
        }
        if (testData.getMetal() != null) {
            softAssert.assertEquals(results.get(posMetal), testData.getMetal());
        }

        if (testData.getVegetables() != null) {
            vegetables = testData.getVegetables();
            String vegetablesResult = results.get(posVegetables);
            softAssert.assertEquals(vegetablesResult.split(", ").length, vegetables.size());
            for (String str : vegetables) {
                softAssert.assertTrue(vegetablesResult.contains(str));
            }
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
