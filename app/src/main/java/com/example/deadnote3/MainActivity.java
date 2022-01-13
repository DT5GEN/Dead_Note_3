package com.example.deadnote3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "[LifeCycleActivity]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        //Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        makeToast(instanceState + " - onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        makeToast("onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        //Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        makeToast("Повторный запуск!! - onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        makeToast("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        makeToast("onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        //Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        makeToast("onSaveInstanceState()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        makeToast("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        makeToast("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        makeToast("onDestroy()");
    }

    private void makeToast(String messageOfState) {
        Toast.makeText(getApplicationContext(), messageOfState, Toast.LENGTH_SHORT).show();
        Log.d(TAG, messageOfState);
    }

}