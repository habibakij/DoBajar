package com.dobajar.myapplication.Loged;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.dobajar.myapplication.R;
import com.dobajar.myapplication.activity.ProductDetails;

public class Register extends AppCompatActivity {

    private EditText edRegName, edRegEmail, edRegPassword, edRegRePassword;
    private Button btRegister;
    String name, email, password, repassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edRegName= findViewById(R.id.edName);
        edRegEmail= findViewById(R.id.edEmail);
        edRegPassword= findViewById(R.id.edPassword);
        edRegRePassword= findViewById(R.id.edRePassword);
        btRegister= findViewById(R.id.btnRegister);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name= edRegName.getText().toString().trim();
                email= edRegEmail.getText().toString().trim();
                password= edRegPassword.getText().toString().trim();
                repassword= edRegRePassword.getText().toString().trim();

                SharedPreferences sharedPref = getSharedPreferences("RegisterData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("RegEmail",email);
                editor.putString("RegPassword",password);
                editor.commit();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (TextUtils.isEmpty(name)){
                    edRegName.setError("Enter your Name");
                    edRegName.requestFocus();
                } else if (!email.matches(emailPattern)){
                    edRegEmail.setError("Enter Valid Email Address");
                    edRegEmail.requestFocus();
                } else if(password.length()< 6){
                    edRegPassword.setError("Password at least 6 char long");
                    edRegPassword.requestFocus();
                } else if (!password.equals(repassword)){
                    edRegPassword.setError("Password not match");
                    edRegPassword.requestFocus();
                }else {
                    startActivity(new Intent(Register.this, ProductDetails.class));
                }
            }
        });
    }
}
