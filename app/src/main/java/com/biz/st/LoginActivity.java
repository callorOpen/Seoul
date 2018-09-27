package com.biz.st;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {


    Button lo_join;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent home = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(home);
                return true;
                case R.id.navigation_bookmark:
                    Intent bookmark = new Intent(LoginActivity.this,BookmarkActivity.class);
                    startActivity(bookmark);
                    return true;
                case R.id.navigation_notifications:
                    Intent notification = new Intent(LoginActivity.this, NotificationActivity.class);
                    startActivity(notification);
                    return true;
                case R.id.navigation_mypage:
                    Intent mypage = new Intent(LoginActivity.this,MypageActivity.class);
                    startActivity(mypage);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lo_join = findViewById(R.id.lo_join);
        lo_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lo_join = new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(lo_join);
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_mypage);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
