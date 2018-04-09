package com.gradledevextreme.light.indooratlaspro.View.Activities.LoginActivities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gradledevextreme.light.indooratlaspro.View.Activities.Main.MainActivity;
import com.gradledevextreme.light.indooratlaspro.R;

/*
Activity taking login credentials and moving to main activity
 */
public class LoginActivity extends AppCompatActivity {

    private Button mBtnLogin;
    private Button mBtnCamera;

    private EditText mEmployeId, mEmployeepassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //to remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Declaration
        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnCamera = findViewById(R.id.btnCamera);

        mEmployeId =findViewById(R.id.mEmployeeid);
        mEmployeepassword =findViewById(R.id.mEmployeepassword);


        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);

        if (hasLoggedIn) {
            gotomain();
        }

        //on Click Listener
        mBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, CameraActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }


        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEmployeId.getText().toString().equals("admin") && mEmployeepassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    //Intent to mainactivity
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);


                }else{
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
                    alertDialog.setMessage(getString(R.string.invalid_credentials));
                    alertDialog.setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertDialog.show();
                }

            }


        });


    }

    private void gotomain() {

        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }
}
