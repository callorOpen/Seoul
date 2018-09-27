package com.biz.st;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MypageActivity extends AppCompatActivity {

    ImageButton imgbtn_board;
    Button login ;
    Button join;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent main = new Intent(MypageActivity.this,MainActivity.class);
                    startActivity(main);
                    return true;
                case R.id.navigation_bookmark:
                    Intent bookmark = new Intent(MypageActivity.this,BookmarkActivity.class);
                    startActivity(bookmark);
                    return true;
                case R.id.navigation_notifications:
                    Intent notification = new Intent(MypageActivity.this, NotificationActivity.class);
                    startActivity(notification);
                    return true;
                case R.id.navigation_mypage:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        login = findViewById(R.id.login);
        join = findViewById(R.id.join);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MypageActivity.this,LoginActivity.class);
                startActivity(login);
            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent join = new Intent(MypageActivity.this,JoinActivity.class);
                startActivity(join);
            }
        });


        imgbtn_board = findViewById(R.id.imgbtn_board);
        imgbtn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent board = new Intent(MypageActivity.this,BoardActivity.class);
                startActivity(board);
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_mypage);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
