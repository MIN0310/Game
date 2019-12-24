package com.min.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        findViewById(R.id.button_up).setOnClickListener(this);
        findViewById(R.id.button_down).setOnClickListener(this);
        findViewById(R.id.button_left).setOnClickListener(this);
        findViewById(R.id.button_right).setOnClickListener(this);
        gameView = findViewById(R.id.game);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_up:
                Log.d("MainActivity", "onClick: UP");
//                gameView.posY = gameView.posY-50; 或
//                gameView.posY -= 50;
                gameView.setPosY(gameView.getPosY() - 50);
                gameView.invalidate();
                break;
            case R.id.button_down:
                Log.d("MainActivity", "onClick: DOWN");
                gameView.setPosY(gameView.getPosY() + 50);
                gameView.invalidate();
                break;
            case R.id.button_left:
                Log.d("MainActivity", "onClick: LEFT");
                gameView.setPosX(gameView.getPosX() - 50);
                gameView.invalidate();
                break;
            case R.id.button_right:
                Log.d("MainActivity", "onClick: RIGHT");
                gameView.setPosX(gameView.getPosX() + 50);
                gameView.invalidate();
                break;
        }

    }
}
