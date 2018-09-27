package com.biz.st;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class JoinActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent home = new Intent(JoinActivity.this,MainActivity.class);
                    startActivity(home);

                    return true;
                case R.id.navigation_bookmark:

                    Intent bookmark = new Intent(JoinActivity.this,BookmarkActivity.class);
                    startActivity(bookmark);
                    return true;
                case R.id.navigation_notifications:
                    Intent notification = new Intent(JoinActivity.this, NotificationActivity.class);
                    startActivity(notification);
                    return true;
                case R.id.navigation_mypage:
                    Intent mypage = new Intent(JoinActivity.this,MypageActivity.class);
                    startActivity(mypage);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_mypage);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
