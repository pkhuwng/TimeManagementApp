package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button button_show_more_task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); // Đảm bảo layout này tồn tại
        button_show_more_task = findViewById(R.id.button_show_more_tasks);
        button_show_more_task.setOnClickListener(v->{
            Intent intent = new Intent(HomeActivity.this, ScheduleActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_menu, menu); // Đảm bảo tên tệp menu đúng
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_back:
//                finish();
//                return true;
//            case R.id.action_home:
//                // Xử lý khi người dùng chọn "Home"
//                return true;
//            case R.id.action_user:
//                // Xử lý khi người dùng chọn "User"
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}