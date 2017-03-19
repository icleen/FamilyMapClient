package cs240.iainlee.familymapclient;

/**
 * Created by iain on 3/18/17.
 */

public class Login {

    private String mUsername;
    private String mPassword;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private boolean mIsMale;

    private String mServerHost;
    private String mServerPort;

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public boolean isMale() {
        return mIsMale;
    }

    public void setMale(boolean isMale) {
        mIsMale = isMale;
    }

    public String getServerHost() {
        return mServerHost;
    }

    public void setServerHost(String serverHost) {
        mServerHost = serverHost;
    }

    public String getServerPort() {
        return mServerPort;
    }

    public void setServerPort(String serverPort) {
        mServerPort = serverPort;
    }
}
