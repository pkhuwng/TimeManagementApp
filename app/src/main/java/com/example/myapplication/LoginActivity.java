package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper; // Khai báo DatabaseHelper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Đặt tên file XML của bạn

        // Khởi tạo DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Khai báo các View
        EditText userInput = findViewById(R.id.username_input); // ID trong layout
        EditText passInput = findViewById(R.id.password_input); // ID trong layout
        Button buttonLoginAction = findViewById(R.id.button_login_action); // Nút đăng nhập
        TextView buttonRegister = findViewById(R.id.button_register); // Nút đăng ký

        // Sự kiện nhấn nút Đăng Nhập
        buttonLoginAction.setOnClickListener(v -> {
            String username = userInput.getText().toString().trim();
            String password = passInput.getText().toString().trim();

            // Xử lý đăng nhập (kiểm tra thông tin)
            if (validateLogin(username, password)) {
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Đóng activity đăng nhập
            } else {
                Toast.makeText(this, "Tên đăng nhập hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
            }
        });

        // Sự kiện nhấn nút Đăng Ký
        buttonRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
            finish(); // Đóng Activity đăng nhập
        });
    }

    private boolean validateLogin(String username, String password) {
        // Kiểm tra thông tin đăng nhập từ cơ sở dữ liệu
        return dbHelper.checkUser(username, password);
    }
}