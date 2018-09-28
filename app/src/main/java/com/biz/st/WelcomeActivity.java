package com.biz.st;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.biz.st.database.MemberVO;

public class WelcomeActivity extends AppCompatActivity {

    ImageButton imgbtn_board;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent main = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(main);
                    finish();

                    return true;
                case R.id.navigation_bookmark:
                    Intent bookmark = new Intent(WelcomeActivity.this,BookmarkActivity.class);
                    startActivity(bookmark);
                    finish();

                    return true;
                case R.id.navigation_notifications:
                    return true;
                case R.id.navigation_mypage:
                    Intent mypage = new Intent(WelcomeActivity.this,MypageActivity.class);
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
        setContentView(R.layout.activity_welcome);

        Intent wel = getIntent();
        MemberVO vo = (MemberVO)wel.getSerializableExtra("MEMBER");

        imgbtn_board = findViewById(R.id.imgbtn_board);
        imgbtn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent board = new Intent(WelcomeActivity.this,BoardActivity.class);
                startActivity(board);
                finish();

            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
