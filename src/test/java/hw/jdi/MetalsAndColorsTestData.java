package hw.jdi;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MetalsAndColorsTestData {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<Integer> getSummary() {

        return summary;
    }

    public List<String> getElements() {

        return elements;
    }

    public String getColor() {

        return color;
    }

    public String getMetals() {

        return metals;
    }

    public List<String> getVegetables() {

        return vegetables;
    }

    public List<String> getResultsPattern() {

        List<String> resultsPattern = new ArrayList<String>();
        resultsPattern.add("Summary");
        if (elements != null) {
            resultsPattern.add("Elements");
        }
        resultsPattern.add("Color");
        resultsPattern.add("Metal");
        resultsPattern.add("Vegetables");

        return resultsPattern;
    }

    @Override
    public String toString() {

        return "MetalsAndColorsTestData{" +
                "summary=" + summary +
                ", elements=" + elements +
                ", color='" + color + '\'' +
                ", metals='" + metals + '\'' +
                ", vegetables=" + vegetables +
                '}';
    }

}
