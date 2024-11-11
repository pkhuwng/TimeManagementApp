package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dbHelper = new DatabaseHelper(this);

        TextView buttonLogin = findViewById(R.id.button_login);
        Button buttonRegisterAction = findViewById(R.id.button_signup_action);
        EditText usernameInput = findViewById(R.id.username_input);
        EditText passwordInput = findViewById(R.id.password_input);
        EditText nameInput = findViewById(R.id.name_input);

        buttonLogin.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        buttonRegisterAction.setOnClickListener(v -> {
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            String name = nameInput.getText().toString().trim();

            if (isInputValid(username, password, name)) {
                handleUserRegistration(username, password, name);
            } else {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Phương thức kiểm tra tính hợp lệ của đầu vào
    private boolean isInputValid(String username, String password, String name) {
        return !username.isEmpty() && !password.isEmpty() && !name.isEmpty();
    }

    // Phương thức xử lý đăng ký người dùng
    private void handleUserRegistration(String username, String password, String name) {
        if (registerUser(username, password, name)) {
            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Tên đăng nhập đã tồn tại!", Toast.LENGTH_SHORT).show();
        }
    }

    // Phương thức đăng ký người dùng
    private boolean registerUser(String username, String password, String name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Kiểm tra xem tên đăng nhập đã tồn tại chưa
        String selection = DatabaseHelper.COL_USERNAME + " = ?";
        String[] selectionArgs = { username };

        try (Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, null, selection, selectionArgs, null, null, null)) {
            if (cursor != null && cursor.getCount() > 0) {
                return false; // Tên đăng nhập đã tồn tại
            }
        }

        // Tiến hành lưu thông tin người dùng
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_USERNAME, username);
        values.put(DatabaseHelper.COL_PASSWORD, password); // Nên mã hóa mật khẩu
        values.put(DatabaseHelper.COL_DISPLAY_NAME, name);
        values.put(DatabaseHelper.COL_TYPE, "user");

        long newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values);
        return newRowId != -1; // Trả về true nếu lưu thành công
    }
}