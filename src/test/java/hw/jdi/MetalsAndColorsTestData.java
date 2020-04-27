package hw.jdi;

import java.util.List;

public class MetalsAndColorsTestData {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public MetalsAndColorsTestData(List<Integer> summary, List<String> elements, String color, String metal, List<String> vegetables) {

        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metal;
        this.vegetables = vegetables;
    }

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
