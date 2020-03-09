package com.example.sharedprefsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button saveBtn;
    private EditText nameField;
    private EditText emailField;
    private EditText phoneField;
    private Switch darkmodeSwitch;
    private Switch notifSwitch;
    private ConstraintLayout background;

    private TextView emailLabel;
    private TextView titleLabel;
    private TextView phoneLabel;
    private TextView nameLabel;
    private TextView infoLabel;


    SharedPreferences sharedpreferences;

    public static final String mypreference = "myPrefs";
    public static final String NAME_KEY = "nameKey";
    public static final String EMAIL_KEY = "emailKey";
    public static final String PHONE_KEY = "phoneKey";
    public static final String DARK_MODE_KEY = "darkModeKey";
    public static final String NOTIFS_KEY = "notifsKey";

    boolean isDarkMode = false;
    boolean showNotifs = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        saveBtn = findViewById(R.id.saveBtn);
        nameField = findViewById(R.id.nameTxt);
        emailField = findViewById(R.id.emailTxt);
        phoneField = findViewById(R.id.phoneTxt);
        darkmodeSwitch = findViewById(R.id.darkModeSwitch);
        notifSwitch = findViewById(R.id.notifsSwitch);
        background = findViewById(R.id.background);

        emailLabel = findViewById(R.id.emailLblTV);
        phoneLabel = findViewById(R.id.phoneLblTV);
        nameLabel = findViewById(R.id.nameLblTV);
        titleLabel = findViewById(R.id.titleTxtView);
        infoLabel = findViewById(R.id.infoTV);




        loadPrefs(); //see method below


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveSettings();

            }
        });

        darkmodeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Log.d("onChecked Change", "changed theme");
                toggleTheme(b);

            }
        });

    }

    private  void loadPrefs(){


        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(NAME_KEY)) {
            nameField.setText(sharedpreferences.getString(NAME_KEY, ""));
        }
        if (sharedpreferences.contains(EMAIL_KEY)) {
            emailField.setText(sharedpreferences.getString(EMAIL_KEY, ""));

        }
        if (sharedpreferences.contains(PHONE_KEY)) {
            phoneField.setText(sharedpreferences.getString(PHONE_KEY, ""));

        } if(sharedpreferences.contains(DARK_MODE_KEY)){

            isDarkMode = sharedpreferences.getBoolean(DARK_MODE_KEY, false);
            darkmodeSwitch.setChecked(isDarkMode);
            toggleTheme(isDarkMode);

        } if(sharedpreferences.contains(NOTIFS_KEY)){

            showNotifs = sharedpreferences.getBoolean(NOTIFS_KEY, true);
            notifSwitch.setChecked(showNotifs);
        }
    }

    private void saveSettings(){

        Log.d("saveSettings" , "settings Saved.");

        SharedPreferences.Editor editor = sharedpreferences.edit();

        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String phone = phoneField.getText().toString();


        editor.putString(NAME_KEY, name);
        editor.putString(EMAIL_KEY, email);
        editor.putString(PHONE_KEY, phone);

        isDarkMode= darkmodeSwitch.isChecked();
        editor.putBoolean(DARK_MODE_KEY, isDarkMode);

        showNotifs = notifSwitch.isChecked();
        editor.putBoolean(NOTIFS_KEY, showNotifs);


        editor.commit();


        if(showNotifs){

            Toast.makeText( getApplicationContext(), "You have successfully saved the preferences", Toast.LENGTH_LONG).show();
        }



    }

    private void toggleTheme(boolean darkIsOn){


        if(darkIsOn){

            //it's dark mode, so make light mode


            emailLabel.setTextColor(getResources().getColor(R.color.lightText));
            phoneLabel.setTextColor(getResources().getColor(R.color.lightText));
            nameLabel.setTextColor(getResources().getColor(R.color.lightText));
            infoLabel.setTextColor(getResources().getColor(R.color.lightText));
            titleLabel.setTextColor(getResources().getColor(R.color.lightText));

            emailField.setTextColor(getResources().getColor(R.color.lightText));
            phoneField.setTextColor(getResources().getColor(R.color.lightText));
            nameField.setTextColor(getResources().getColor(R.color.lightText));
            background.setBackgroundColor(getResources().getColor(R.color.darkBackground));

            isDarkMode = true;


        } else {

            //it's light mode, so make dark.

            emailLabel.setTextColor(getResources().getColor(R.color.darkText));
            phoneLabel.setTextColor(getResources().getColor(R.color.darkText));
            nameLabel.setTextColor(getResources().getColor(R.color.darkText));
            infoLabel.setTextColor(getResources().getColor(R.color.darkText));
            titleLabel.setTextColor(getResources().getColor(R.color.darkText));

            emailField.setTextColor(getResources().getColor(R.color.darkText));
            phoneField.setTextColor(getResources().getColor(R.color.darkText));
            nameField.setTextColor(getResources().getColor(R.color.darkText));
            background.setBackgroundColor(getResources().getColor(R.color.lightBackground));

            isDarkMode = false;

        }
    }
}
