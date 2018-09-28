package com.biz.st;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.biz.st.database.MemberVO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class JoinActivity extends AppCompatActivity {

    TextView txt_userid;
    TextView txt_password;
    TextView txt_password_check;
    TextView txt_nick;
    TextView txt_email;
    RadioGroup radioGroup;
    RadioButton txt_gender;
    Spinner txt_age;
    String str_age;

    Button btn_id_check;
    Button btn_join;
    DatabaseReference databaseReference;
    MemberVO memberVO;

    // 아이디 중복체크하기 위해서 데이터 검색 이벤트 선언
    ValueEventListener checkId = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
            while(child.hasNext()){
                if(child.next().getKey().equalsIgnoreCase(txt_userid.getText().toString())){
                    Toast.makeText(getApplicationContext(),"존재하는 아이디 입니다.",Toast.LENGTH_LONG).show();

                    // 이벤트가 자꾸 반복 실행되는 것을 방지하기 위해 이벤트를 제거
                    databaseReference.removeEventListener(this);
                    return;
                }
            }
            // 중복 ID가 없으면 새로운 member로 등록처리
            databaseReference.child(memberVO.getUserId()).setValue(memberVO);
            Toast.makeText(getApplicationContext(),"사용가능한 아이디 입니다.",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent home = new Intent(JoinActivity.this,MainActivity.class);
                    startActivity(home);
                    finish();


                    return true;
                case R.id.navigation_bookmark:

                    Intent bookmark = new Intent(JoinActivity.this,BookmarkActivity.class);
                    startActivity(bookmark);
                    finish();

                    return true;
                case R.id.navigation_notifications:
                    Intent notification = new Intent(JoinActivity.this, NotificationActivity.class);
                    startActivity(notification);
                    finish();

                    return true;
                case R.id.navigation_mypage:
                    Intent mypage = new Intent(JoinActivity.this,MypageActivity.class);
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
        setContentView(R.layout.activity_join);


        memberVO = new MemberVO();

        txt_userid = findViewById(R.id.txt_userid);
        txt_password = findViewById(R.id.txt_password);
        txt_nick = findViewById(R.id.txt_nick);
        txt_email = findViewById(R.id.txt_email);

        radioGroup = findViewById(R.id.layout_gender);
        txt_age = findViewById(R.id.txt_age);
        txt_nick = findViewById(R.id.txt_nick);

        txt_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_age = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("members");

        btn_id_check = findViewById(R.id.btn_login_join);
        btn_id_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(checkId);
            }
        });

        btn_join = findViewById(R.id.btn_join);
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txt_userid.getText().toString().isEmpty()){
                    Toast.makeText(JoinActivity.this,"사용자 ID를 입력해야 합니다.", Toast.LENGTH_LONG).show();
                    return;
                }
                memberVO.setUserId(txt_userid.getText().toString());

                if(txt_password.getText().toString().isEmpty()){
                    Toast.makeText(JoinActivity.this,"비밀번호를 입력해야 합니다.", Toast.LENGTH_LONG).show();
                    return;
                }
//                if(!txt_password.getText().toString().equals(txt_password_check.getText().toString())){
//                    Toast.makeText(JoinActivity.this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_LONG).show();
//                    return;
//                }
                memberVO.setPassword(txt_password.getText().toString());


                // RadioGroup에서 현재 선택된 RadioButton Id를 추출하고
                // 그 Id를 이용해서 RadioButton 초기화
                int rid = radioGroup.getCheckedRadioButtonId();
                txt_gender = findViewById(rid);
                memberVO.setGender(txt_gender.getText().toString());

                if(str_age.equalsIgnoreCase("연령선택")){
                    Toast.makeText(JoinActivity.this, "연령을 선택해주세요.",Toast.LENGTH_LONG).show();
                    return;
                }
                memberVO.setAge(str_age);

                // txt_gender(RadioButton) 초기화 된 후에는 TextView와 같은 방법으로 문자열을 추출 할 수 있다.
                Toast.makeText(JoinActivity.this, txt_gender.getText().toString(), Toast.LENGTH_LONG).show();

                memberVO.setEmail(txt_email.getText().toString());
                memberVO.setNick(txt_nick.getText().toString());



            }
        });




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_mypage);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
