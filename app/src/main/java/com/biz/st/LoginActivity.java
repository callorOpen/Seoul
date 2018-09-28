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

import com.biz.st.database.MemberVO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Iterator;

public class LoginActivity extends AppCompatActivity {

    TextView txt_loginuserid;
    TextView txt_loginpassword;
    Button btn_login_join;
    Button btn_login;

    DatabaseReference databaseReference;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent home = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(home);
                    finish();
                    return true;
                case R.id.navigation_bookmark:
                    Intent bookmark = new Intent(LoginActivity.this,BookmarkActivity.class);
                    startActivity(bookmark);
                    finish();
                    return true;
                case R.id.navigation_notifications:
                    Intent notification = new Intent(LoginActivity.this, NotificationActivity.class);
                    startActivity(notification);
                    finish();
                    return true;
                case R.id.navigation_mypage:
                    Intent mypage = new Intent(LoginActivity.this,MypageActivity.class);
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
        setContentView(R.layout.activity_login);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        txt_loginuserid = findViewById(R.id.txt_loginuserid);
        txt_loginpassword = findViewById(R.id.txt_loginpassword);



        btn_login_join = findViewById(R.id.btn_login_join);
        btn_login_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lo_join = new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(lo_join);
                finish();

            }
        });

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
                        while(child.hasNext()){

                            MemberVO vo = child.next().getValue(MemberVO.class);
                            if(vo.getUserId().equals(txt_loginuserid.getText().toString())){
                                if(!vo.getPassword().equals(txt_loginpassword.getText().toString())){
                                    Toast.makeText(getApplicationContext(),"비밀번호가 틀립니다", Toast.LENGTH_LONG).show();
                                    return;
                                }
//                                Toast.makeText(getApplicationContext(),"로그인 성공", Toast.LENGTH_LONG).show();

                                // 새로운 intent를 생성하고
                                // 로그인 정보가 담긴 VO 넘겨주기
                                Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
//                                intent.putExtra("MEMBER",vo);
                                startActivity(intent);
                                finish();
                                return;
                            }

                        }
                        Toast.makeText(getApplicationContext(),"아이디가 존재하지 않습니다.",Toast.LENGTH_LONG).show();
                        return;
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_mypage);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
