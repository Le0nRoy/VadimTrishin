package hw.jdi.site;

import com.epam.jdi.light.elements.composite.WebPage;

public class HomePage extends WebPage {

    private LoginForm loginForm;

    public void login(User user) {
        loginForm.login(user);
    }

    public LoginForm getLoginForm() {

        return loginForm;
    }

}
