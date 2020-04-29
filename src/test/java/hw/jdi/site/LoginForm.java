package hw.jdi.site;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class LoginForm extends Form<User> {

    @Css("#name")
    private TextField name;
    @Css("#password")
    private TextField password;
    @Css("#user-name")
    private Text userName;
    @Css("#login-button")
    private Button loginButton;
    @Css("#user-icon")
    private Button userIcon;

    public void login(User user) {

        userIcon.click();
        super.login(user);
    }

    public Text getUserName() {

        return userName;
    }

}
