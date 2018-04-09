package com.gradledevextreme.light.indooratlaspro.View.Activities.DialogActivities;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gradledevextreme.light.indooratlaspro.R;
import com.gradledevextreme.light.indooratlaspro.Util.Constants;
import com.gradledevextreme.light.indooratlaspro.View.Activities.LoginActivities.LoginActivity;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Activity showing dialog to add map and current location to database
 */

public class DialogActivity extends Activity {
    private Button mOk, mCancel;
    public static String name;
    public EditText mName;
    private ImageView btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // final databasehandler db = new databasehandler(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog);

        mOk = findViewById(R.id.okBtnId);
        mCancel = findViewById(R.id.cancelBtnId);
        mName = findViewById(R.id.mName);
        btnSpeak = findViewById(R.id.btnSpeak);


        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mName.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    mName.setError(getString(R.string.error_message));
                } else {
                    Intent i = new Intent(DialogActivity.this, FavoriteActivity.class);
                    startActivity(i);
                    DialogActivity.this.finish();
                }

            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogActivity.this.finish();
            }
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptSpeechInput();
            }
        });

    }

    public void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.Say_something));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {
            Log.e("DialogActivity: ", " " + e.getMessage());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mName.setText(result.get(0));
                }
                break;
            }
        }
    }


    void showToastMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
                .show();
    }
}
