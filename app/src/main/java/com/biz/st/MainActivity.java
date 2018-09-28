package com.biz.st;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.biz.st.database.BscVO;
import com.biz.st.helper.StringPagerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    ViewPager vp ;
    TabLayout tab;
    Button btn_bcs;
    Button btn_gen;
    Button btn_fav;
    ImageButton imgbtn_board;
    Button btn_title;
    ImageButton imgbtn_search;
    TextView bmt;
    List<String> bscList;
    List<String> genList;
    List<String> favList;
    StringPagerAdapter stringPagerAdapter;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_bookmark:

                    Intent bookmark = new Intent(MainActivity.this,BookmarkActivity.class);
                    startActivity(bookmark);
                    finish();

                    return true;
                case R.id.navigation_notifications:
                    Intent notification = new Intent(MainActivity.this, NotificationActivity.class);
                    startActivity(notification);
                    finish();

                    return true;
                case R.id.navigation_mypage:
                    Intent mypage = new Intent(MainActivity.this,MypageActivity.class);
                    startActivity(mypage);
                    finish();

                    return true;
            }
            return false;
        }
    };


    List<BscVO> dataList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bscList = new ArrayList<>();
        genList = new ArrayList<>();
        favList = new ArrayList<>();

        dataList = new ArrayList<BscVO>() ;
        vp = findViewById(R.id.view_pager);
        tab = findViewById(R.id.tab_layout);

        FirebaseDatabase.getInstance()  // db 정도 획득
                .getReference()     // db 연결 객체 획득
                .child("doc")       // doc 데이터를 감시하라
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // dataSnapshot
                        // firebase의 doc데이터가 변화되면, 자동으로 데이터를 수신해서 보관할 객체

                        // dataSnapshot으로 부터 필요한 데이터를 추출하는 코드

                        bscList.clear();
                        genList.clear();
                        favList.clear();

                        Log.d("data",":" + dataSnapshot.getChildrenCount());
                        for(DataSnapshot sd : dataSnapshot.getChildren()){

                            BscVO vo = sd.getValue(BscVO.class);
                            Log.d("VO",vo.bsc);

                            bscList.add(vo.bsc);
                            genList.add(vo.genre);
                            favList.add(vo.fav);

                            dataList.add(vo);


                        }
                        // 현재 추출된 data는 중복된 data
                        // >> 중복없는 data로 변환
                        Set<String> set = new TreeSet<>(bscList);       // 중복되지 않고, 오름차순
                        bscList = new ArrayList<>(set);
                        genList = new ArrayList<>(new TreeSet(genList));
                        favList = new ArrayList<>(new TreeSet(favList));



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.d("Data 오류", databaseError.toString());
                    }
                });    // 데이터가 변화되면 알려달라

        stringPagerAdapter = new StringPagerAdapter(getSupportFragmentManager(),favList);
        vp.setAdapter(stringPagerAdapter);
        tab.setupWithViewPager(vp);

        btn_fav = findViewById(R.id.btn_fav);
        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("Button","FAV");
                stringPagerAdapter = new StringPagerAdapter(getSupportFragmentManager(),favList);
                vp.setAdapter(stringPagerAdapter);
                tab.setupWithViewPager(vp);


            }
        });



        btn_bcs = findViewById(R.id.btn_bcs);
        btn_bcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("Button","BSC");
                stringPagerAdapter = new StringPagerAdapter(getSupportFragmentManager(),bscList);
                vp.setAdapter(stringPagerAdapter);
                tab.setupWithViewPager(vp);

            }
        });


        btn_gen = findViewById(R.id.btn_gen);
        btn_gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("Button","GEN");
                stringPagerAdapter = new StringPagerAdapter(getSupportFragmentManager(),genList);
                vp.setAdapter(stringPagerAdapter);
                tab.setupWithViewPager(vp);

            }
        });

        imgbtn_board = findViewById(R.id.imgbtn_board);
        imgbtn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent board = new Intent(MainActivity.this,BoardActivity.class);
                startActivity(board);
                finish();

            }
        });






//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
