package com.biz.st;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class BookmarkActivity extends AppCompatActivity {

    ImageButton imgbtn_board ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent main = new Intent(BookmarkActivity.this,MainActivity.class);
                    startActivity(main);
                    finish();
                    return true;
                case R.id.navigation_bookmark:

                    return true;
                case R.id.navigation_notifications:
                    Intent notification = new Intent(BookmarkActivity.this, NotificationActivity.class);
                    startActivity(notification);
                    finish();

                    return true;
                case R.id.navigation_mypage:
                    Intent mypage = new Intent(BookmarkActivity.this,MypageActivity.class);
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
        setContentView(R.layout.activity_bookmark);

        imgbtn_board = findViewById(R.id.imgbtn_board);
        imgbtn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent board = new Intent(BookmarkActivity.this,BoardActivity.class);
                startActivity(board);
                finish();

            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_bookmark);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
