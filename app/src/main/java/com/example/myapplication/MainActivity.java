package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sử dụng CountDownTimer để chuyển đến LoginRegisterActivity sau 2 giây
        new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Không làm gì trong mỗi tick
            }

            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                // Không gọi finish() ở đây để giữ MainActivity mở
            }
        }.start();
    }
}