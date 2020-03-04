package com.allbangladesh.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String SHARED_PREF_NAME = "mysharedpref";
    private static final String KEY_NAME = "keyname";

    EditText editText;
    TextView textView;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
/**
 * Get the SharedPreferences
 * Initialize the Editor
 * Put the values
 * Apply the changes
 *
 * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextName);
        textView = findViewById(R.id.textView);
        //getting shared preferences
         sp= getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        //initializing editor
        editor = sp.edit();
        String name = sp.getString(KEY_NAME, null);
        if (name != null) {
            textView.setText("Welcome " + name);
        }
        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveName();

            }
        });
        Button show=findViewById(R.id.buttonShow);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayName();
//                editor.clear();
//                editor.apply();
            }
        });
    }

    private void saveName() {
        String name = editText.getText().toString();

        if (name.isEmpty()) {
            editText.setError("Name required");
            editText.requestFocus();
            return;
        }

        //put the values
        editor.putString(KEY_NAME, name);

        //apply
        editor.apply();

        editText.setText("");
    }

    private void displayName() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sp.getString(KEY_NAME, null);

        if (name != null) {
            textView.setText("Welcome " + name);
        }
    }

}