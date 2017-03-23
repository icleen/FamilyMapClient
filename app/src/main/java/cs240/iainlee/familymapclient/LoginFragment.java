package cs240.iainlee.familymapclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

import client.ServerProxy;
import models.Event;
import models.LoginResponse;
import models.Person;

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
	private RadioGroup mRadioGroup;

	private Button mSignIn;
	private Button mRegister;

	private Login mLogin;
	private LoginResponse mResponse;
	
	private Person[] mPersons;
	private Event[] mEvents;
	
	private static final String TAG = "LoginFragment";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mLogin = new Login();
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
//				Log.d("username", "added the username: " + mLogin.getUsername());
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
//				Log.d("password", "added the password: " + mLogin.getPassword());
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
//				Log.d("email", "added the email: " + mLogin.getEmail());
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
//				Log.d("server_host", "added the server host number " + mLogin.getServerHost());
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
//				Log.d("server_port", "added the server port number " + mLogin.getServerPort());
				changeAccessibility();
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		mRadioGroup = (RadioGroup) v.findViewById(R.id.radio_group);

		mMale = (RadioButton) v.findViewById(R.id.male_radio);

		mFemale = (RadioButton) v.findViewById(R.id.female_radio);

		mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch(checkedId) {
					case R.id.male_radio:
						mLogin.setGender("m");
						break;
					case R.id.female_radio:
						mLogin.setGender("f");
						break;
				}
				Log.d("gender", "gender: " + mLogin.getGender());
				changeAccessibility();
			}
		});

		mSignIn = (Button) v.findViewById(R.id.sign_in_button);
		mSignIn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new loginServer().execute();
				if(mResponse != null || mResponse.getErrorMessage() != null) {
					Toast.makeText(view.getContext(), "Failed", Toast.LENGTH_SHORT).show();
					Log.d("login", "onClick: " + mResponse.toString());
				}else {
					Toast.makeText(view.getContext(), "Login", Toast.LENGTH_SHORT).show();
					Log.d("login", "onClick: " + mResponse.toString());
				}
			}
		});

		mRegister = (Button) v.findViewById(R.id.register_button);
		mRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new registerInServer().execute();
				if(mResponse != null || mResponse.getErrorMessage() != null) {
					Toast.makeText(v.getContext(), "Failed", Toast.LENGTH_SHORT).show();
					Log.d("register", "onClick: " + mResponse.toString());
				}else {
					Toast.makeText(v.getContext(), "Registered", Toast.LENGTH_SHORT).show();
					Log.d("register", "onClick: " + mResponse.toString());
				}
				
			}
		});

		mSignIn.setEnabled(false);
		mRegister.setEnabled(false);

		return v;
	}

	private void changeAccessibility() {
		if(mLogin.isLoginReady()) {
			mSignIn.setEnabled(true);
		}if(mLogin.isRegisterReady()) {
			mRegister.setEnabled(true);
		}
	}
	
	private class registerInServer extends AsyncTask<Void, Void, LoginResponse> {
		
		@Override
		protected LoginResponse doInBackground(Void... params) {
			LoginResponse response = new ServerProxy().registerUser(mLogin);
			return response;
		}
		
		@Override
		protected void onPostExecute(LoginResponse r) {
			mResponse = r;
		}
	}
	
	private class loginServer extends AsyncTask<Void, Void, LoginResponse> {
		
		@Override
		protected LoginResponse doInBackground(Void... params) {
			LoginResponse response = new ServerProxy().userLogin(mLogin);
			return response;
		}
		
		@Override
		protected void onPostExecute(LoginResponse r) {
			mResponse = r;
		}
	}
	
	private class fetchUserInfo extends AsyncTask<Void, Void, Void> {
		
		@Override
		protected Void doInBackground(Void... params) {
			ServerProxy server = new ServerProxy();
			mPersons = server.getPeople();
			mEvents = server.getEvents();
			return null;
		}
		
	}
}
