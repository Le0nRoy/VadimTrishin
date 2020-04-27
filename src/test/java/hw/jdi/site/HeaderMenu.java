package hw.jdi.site;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class HeaderMenu {

    @Css(".navbar-nav")
    public Menu navigationMenu;

    public class LoginForm extends Form<User> {

        private TextField login;
        private TextField password;
        private Button loginButton;
    }

}
