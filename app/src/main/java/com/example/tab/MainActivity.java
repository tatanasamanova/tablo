package com.example.tab;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer winx = 0;
    private Integer trix = 0;
    private TextView winxTextView;
    private TextView trixTextView;

    private static final String TAG = "MainActivity";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winxTextView = findViewById(R.id.winx_score);
        trixTextView = findViewById(R.id.trix_score);
    }

    @SuppressLint("SetTextI18n")
    public void onClickAddWinx(View view) {
        winx++;
        winxTextView.setText(winx.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickAddTrix(View view) {
        trix++;
        trixTextView.setText(trix.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickButtonClear(View view) {
        winx = 0;
        trix = 0;

        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("winx", winx);
        outState.putInt("trix", trix);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("winx")) {
            winx= savedInstanceState.getInt("winx");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("trix"))) {
            trix= savedInstanceState.getInt("trix");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    @SuppressLint("SetTextI18n")
    private void resetUI() {
        winxTextView.setText(winx.toString());
        trixTextView.setText(trix.toString());
        Log.d(TAG, "resetUI");
    }
}