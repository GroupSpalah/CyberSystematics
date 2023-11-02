package ls_10_23.ls_02_11_23;

import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        String login = "[a-zA-Z]*";
        String password = "[a-zA-Z\\d]*";

        System.out.println("Login = " + Pattern.matches(login, "avalev"));
        System.out.println("Password = " + Pattern.matches(password, "12354das"));

    }
}
