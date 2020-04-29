package hw.jdi.site;

public class User {

    private String name;
    private String password;
    private String fullName;

    public User(String name, String password, String fullName) {

        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public String getFullName() {

        return fullName;
    }

}