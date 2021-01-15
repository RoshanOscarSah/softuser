package com.assignment.esoftwarica

import com.assignment.esoftwarica.model.User
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText;
    private lateinit var etPassword: EditText;
    private lateinit var btnLogin: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val user = User();
                val isLogin =
                    user.LoginOperation(etUsername.text.toString(), etPassword.text.toString());

                if (TextUtils.isEmpty(etUsername.text.toString())) {
                    etUsername.setError("Username Required");
                    etUsername.requestFocus();
                } else if (TextUtils.isEmpty(etPassword.text.toString())) {
                    etPassword.setError("Password Required");
                    etPassword.requestFocus();
                } else {
                    if (isLogin) {
                        startActivity(Intent(this@LoginActivity, DashboardActivity::class.java));
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Either Username or Password Does not Match",
                            Toast.LENGTH_SHORT
                        )
                            .show();
                    }
                }
            }
        })
    }
}