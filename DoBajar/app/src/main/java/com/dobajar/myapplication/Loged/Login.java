package com.dobajar.myapplication.Loged;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.dobajar.myapplication.R;
import com.dobajar.myapplication.activity.MainActivity;
import com.dobajar.myapplication.activity.ProductDetails;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private String TAG="LoginClass";
    private EditText edLogEmail, edLogPassword;
    private Button mlogin;
    String email, password, shareEmail, sharePassword;
    TextView goToRegister;
    private ProgressDialog progressDialog;
    private SharedPreferences sharedPref;
    private String getEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edLogEmail= findViewById(R.id.edlogEmail);
        edLogPassword= findViewById(R.id.edlogPassword);
        mlogin= findViewById(R.id.btnLogin);
        goToRegister= findViewById(R.id.gotoregister);

        progressDialog= new ProgressDialog(this);

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

         sharedPref= getSharedPreferences("RegisterData", Context.MODE_PRIVATE);
         getEmail= sharedPref.getString("RegEmail","default");

        CheckConnection();
    }

    private void CheckConnection() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ConnectionInfo= cm.getActiveNetworkInfo();

        if (ConnectionInfo!= null){
            try {
                mlogin.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onClick(View v) {
                        String email= edLogEmail.getText().toString();
                        String password= edLogPassword.getText().toString();
                        if (TextUtils.isEmpty(email)){
                            edLogEmail.setError("Enter email");
                        } else if(TextUtils.isEmpty(password)){
                            edLogPassword.setError("Enter password");
                        } else {
                            startActivity(new Intent(Login.this, MainActivity.class));
                        }

                        try {
                            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), 0);
                        } catch (Exception e) {
                            Log.d(TAG,"Keyboard Error: "+e.getMessage());
                        }
                    }
                });

            }catch (Exception e){
                Toast.makeText(this, "Log in Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (sharedPref.contains("RegEmail")){
            if (!getEmail.isEmpty()){
                startActivity(new Intent(this, ProductDetails.class));
            }
        } else {
            //Toast.makeText(this, "SharePreferance is empty", Toast.LENGTH_SHORT).show();
        }
    }
}
