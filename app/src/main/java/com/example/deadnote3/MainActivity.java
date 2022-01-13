package com.example.deadnote3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FirstFragment.Controller {

    private static final String TAG = " HappY MainActivity >> ";
private Button fragmentStartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        fragmentStartButton = findViewById(R.id.start_first_fragment);
        fragmentStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick() called with: view = [" + view + "]");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.first_fragment_holder , new FirstFragment())
                        .addToBackStack("First transaction")
                        .commit();
            }
        });
}

    @Override
    public void startButtonPressed(String message) {
        getSupportFragmentManager()
                .beginTransaction()
              //  .add(R.id.second_fragment_holder , new SecondFragment(message))
             .add(R.id.second_fragment_holder, SecondFragment.getInstance(message))
                .addToBackStack(null)
                .commit();
    }
}