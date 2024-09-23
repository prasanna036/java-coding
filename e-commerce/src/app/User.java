package app;

public abstract class User {
    protected int userId;
    protected String username;
    protected String password;

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public boolean checkpassword(String password) {
    	return this.password.equals(password);
    }
}
