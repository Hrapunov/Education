package homework;

public class TestBot {
    private final String password;
    private final String login;

    public TestBot(String login, String password){
        this.password = password;
        this.login = login;
    }
    public  String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
}
