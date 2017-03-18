package cs240.iainlee.familymapclient;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.RadioButton;

public class LoginActivity extends Activity {

    private EditText mServerHost;
    private EditText mServerPort;
    private EditText mUsername;
    private EditText mPassword;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmail;
    private RadioButton mMale;
    private RadioButton mFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

}
