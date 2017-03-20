package cs240.iainlee.familymapclient;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginFragment extends android.support.v4.app.Fragment {

    private EditText mServerHost;
    private EditText mServerPort;
    private EditText mUsername;
    private EditText mPassword;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmail;

    private RadioButton mMale;
    private RadioButton mFemale;

    private Button mSignIn;
    private Button mRegister;

    private Login mLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLogin = new Login();
        mSignIn.setActivated(false);
		mRegister.setActivated(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        mUsername = (EditText) v.findViewById(R.id.username);
        mUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLogin.setUsername(s.toString());
                Log.d("username", "added the username: " + mLogin.getUsername());
				changeAccessibility();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mPassword = (EditText) v.findViewById(R.id.password);
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLogin.setPassword(s.toString());
                Log.d("password", "added the password: " + mLogin.getPassword());
				changeAccessibility();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mFirstName = (EditText) v.findViewById(R.id.firstName);
        mFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLogin.setFirstName(s.toString());
				changeAccessibility();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mLastName = (EditText) v.findViewById(R.id.lastName);
        mLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLogin.setLastName(s.toString());
				changeAccessibility();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mEmail = (EditText) v.findViewById(R.id.email);
        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLogin.setEmail(s.toString());
                Log.d("email", "added the email: " + mLogin.getEmail());
				changeAccessibility();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mServerHost = (EditText) v.findViewById(R.id.server_host);
        mServerHost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLogin.setServerHost(s.toString());
                Log.d("server_host", "added the server host number " + mLogin.getServerHost());
				changeAccessibility();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mServerPort = (EditText) v.findViewById(R.id.server_port);
        mServerPort.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLogin.setServerPort(s.toString());
                Log.d("server_port", "added the server port number " + mLogin.getServerPort());
				changeAccessibility();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mMale = (RadioButton) v.findViewById(R.id.male_radio);
        mMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mLogin.setMale(isChecked);
                Log.d("gender", "isMale: " + mLogin.isMale());
            }
        });

        mFemale = (RadioButton) v.findViewById(R.id.female_radio);
        mFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mLogin.setMale(!isChecked);
                Log.d("gender", "isMale: " + mLogin.isMale());
				changeAccessibility();
            }
        });

        mSignIn = (Button) v.findViewById(R.id.sign_in_button);
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Signed In", Toast.LENGTH_SHORT).show();
            }
        });

        mRegister = (Button) v.findViewById(R.id.register_button);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Registered", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

	private void changeAccessibility() {
		if(mLogin.isLoginReady()) {
			mSignIn.setActivated(true);
		}if(mLogin.isRegisterReady()) {
			mRegister.setActivated(true);
		}
	}

}