package com.example.myapplication;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); // Đảm bảo layout này tồn tại

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