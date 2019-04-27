package com.example.janken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    final int JANKEN_GU = 0;
    final int JANKEN_CHOKI = 1;
    final int JANKEN_PA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int myHand = 0;
        Intent intent = getIntent();
        int id = intent.getIntExtra("MY_HAND",0);

        ImageView myHandImagView = (ImageView)findViewById(R.id.my_hand_image);
        switch (id) {
            case R.id.gu:
                myHandImagView.setImageResource(R.drawable.gu);
                myHand = JANKEN_GU;
                break;
            case R.id.choki:
                myHandImagView.setImageResource(R.drawable.choki);
                myHand = JANKEN_CHOKI;
                break;
            case R.id.pa:
                myHandImagView.setImageResource(R.drawable.pa);
                myHand = JANKEN_PA;
                break;
            default:
                myHand = JANKEN_GU;
                break;
        }

        // コンピュータの手を決める
        int comHand = (int)(Math.random() * 3);
        ImageView comHandImageView = (ImageView)findViewById(R.id.com_hand_image);
        switch (comHand) {
            case JANKEN_GU:
                comHandImageView.setImageResource(R.drawable.com_gu);
                break;
            case JANKEN_CHOKI:
                comHandImageView.setImageResource(R.drawable.com_choki);
                break;
            case JANKEN_PA:
                comHandImageView.setImageResource(R.drawable.com_pa);
                break;
        }

        // 勝敗判定
        TextView resultLabel = (TextView)findViewById(R.id.result_label);
        int gameLesult = (comHand - myHand + 3) % 3;
        switch (gameLesult) {
            case 0:
                // あいこの場合
                resultLabel.setText(R.string.result_draw);
                break;
            case 1:
                // 勝ったの場合
                resultLabel.setText(R.string.result_win);
                break;
            case 2:
                // 負けたの場合
                resultLabel.setText(R.string.result_lose);
                break;
        }
    }

    public void onBackButtonTapped(View view) {
        finish();
    }
}
