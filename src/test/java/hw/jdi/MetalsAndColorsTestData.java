package hw.jdi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MetalsAndColorsTestData {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

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
