package com.example.tykoon;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tykoon.rank.RankActivity;

public class HomeActivity extends AppCompatActivity {

    ImageButton btnGameStart, btnRanking;
    TextView userNameTextView;
    String name;
    static MediaPlayer mP = null;

    @Override
    protected void onResume() {
        super.onResume();

        // 배경음악 넣음
        if(mP == null) {
            mP = MediaPlayer.create(getApplicationContext(), R.raw.toastfactory_bgm);
            mP.start();
            mP.setLooping(true);
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_view);
        setTitle("사용자 정보 입력");

        btnGameStart = (ImageButton) findViewById(R.id.btnGameStart);
        btnRanking = (ImageButton) findViewById(R.id.btnRanking);

        userNameTextView = findViewById(R.id.userNameTextView);
        // Intent intent = getIntent();
        // name = intent.getStringExtra("name");
        name = GameInstance.getInstance().getPlayerID();

        userNameTextView.setText("안녕하세요 "+name+"님");

        btnGameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다음 activity로 넘김
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //랭킹 쪽으로 뷰를 돌려주기
                Intent intent = new Intent(HomeActivity.this, RankActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }
}

