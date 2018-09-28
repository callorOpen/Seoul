package com.biz.st;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BoardWriteActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent main = new Intent(BoardWriteActivity.this,MainActivity.class);
                    startActivity(main);
                    finish();

                    return true;
                case R.id.navigation_bookmark:
                    Intent bookmark = new Intent(BoardWriteActivity.this,BookmarkActivity.class);
                    startActivity(bookmark);
                    finish();

                    return true;
                case R.id.navigation_notifications:
                    Intent notification = new Intent(BoardWriteActivity.this, NotificationActivity.class);
                    startActivity(notification);
                    finish();

                    return true;
                case R.id.navigation_mypage:
                    Intent mypage = new Intent(BoardWriteActivity.this,MypageActivity.class);
                    startActivity(mypage);
                    finish();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
