package com.biz.st;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BoardActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Button btn_mo;
    Button btn_hu;
    Button btn_mytext ;
    Button btn_write;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent main = new Intent(BoardActivity.this,MainActivity.class);
                    startActivity(main);
                    return true;
                case R.id.navigation_bookmark:
                    Intent bookmark = new Intent(BoardActivity.this,BookmarkActivity.class);
                    startActivity(bookmark);
                    return true;
                case R.id.navigation_notifications:
                    Intent notification = new Intent(BoardActivity.this, NotificationActivity.class);
                    startActivity(notification);
                    return true;
                case R.id.navigation_mypage:
                    Intent mypage = new Intent(BoardActivity.this,MypageActivity.class);
                    startActivity(mypage);
                    return true;
            }
            return false;
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        btn_mo = findViewById(R.id.btn_mo);
        btn_write = findViewById(R.id.btn_write);


        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent write = new Intent(BoardActivity.this, BoardWriteActivity.class);
                startActivity(write);
            }
        });



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }




}

