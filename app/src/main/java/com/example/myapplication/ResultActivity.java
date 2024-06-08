package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    private ImageView modoruImg;
    private TextView daikyouImg;
    private ImageView curseImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.modoru_img), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        daikyouImg = findViewById(R.id.daikyou_img);
        curseImg   = findViewById(R.id.curse_img);

        Intent intent = getIntent();
        int num = intent.getIntExtra("result_id", -1);

        switch(num) {
            case 0:
                daikyouImg.setText("大吉");
                curseImg.setImageResource(R.drawable.great_blessing);
                break;
            case 1:
                daikyouImg.setText("中吉");
                curseImg.setImageResource(R.drawable.middle_blessing);
                break;
            case 2:
                daikyouImg.setText("小吉");
                curseImg.setImageResource(R.drawable.small_blessing);
                break;
            case 3:
                daikyouImg.setText("吉");
                curseImg.setImageResource(R.drawable.blessing);
                break;
            case 4:
                daikyouImg.setText("凶");
                curseImg.setImageResource(R.drawable.curse);
                break;
            case 5:
                daikyouImg.setText("大凶");
                curseImg.setImageResource(R.drawable.uncertain_luck);
                break;
        }

        //ボタンのViewを読み込む
        modoruImg = findViewById(R.id.modoru_img);
        //クリック処理を設定する
        modoruImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
                //  メイン画面に遷移させる
            }
        });
    }
}