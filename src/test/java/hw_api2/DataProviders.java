package hw_api2;

import hw_api2.entities.testData.SpellerTextTestDataEntity;
import hw_api2.entities.testData.SpellerTextsTestDataEntity;
import org.testng.annotations.DataProvider;

import static hw_api2.utils.Parser.jsonFileParser;

public class DataProviders {

    private static String spellerTextJsonDataPath;
    private static String spellerTextsJsonDataPath;
    private static String spellerTextJsonDataNamePattern;
    private static String spellerTextsJsonDataNamePattern;

    public static void setSpellerTextJsonDataPath(String spellerTextJsonDataPath) {

        DataProviders.spellerTextJsonDataPath = spellerTextJsonDataPath;
    }

    public static void setSpellerTextsJsonDataPath(String spellerTextsJsonDataPath) {

        DataProviders.spellerTextsJsonDataPath = spellerTextsJsonDataPath;
    }

    public static void setSpellerTextJsonDataNamePattern(String spellerTextJsonDataNamePattern) {

        DataProviders.spellerTextJsonDataNamePattern = spellerTextJsonDataNamePattern;
    }

    public static void setSpellerTextsJsonDataNamePattern(String spellerTextsJsonDataNamePattern) {

        DataProviders.spellerTextsJsonDataNamePattern = spellerTextsJsonDataNamePattern;
    }

    @DataProvider
    public Object[][] spellerTextsDataProvider() {

        return jsonFileParser(SpellerTextsTestDataEntity.class, spellerTextsJsonDataPath, spellerTextsJsonDataNamePattern);
    }
    @DataProvider
    public Object[][] spellerTextDataProvider() {

        return jsonFileParser(SpellerTextTestDataEntity.class, spellerTextJsonDataPath, spellerTextJsonDataNamePattern);
    }

}
