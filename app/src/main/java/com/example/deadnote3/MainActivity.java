package com.example.deadnote3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "[LifeCycleActivity]";

    private int counter1 = 0;       // первый счетчик
    private int counter2 = 0;       // второй счетчик

    private TextView textCounter1;  // пользовательский элемент 1-го счетчика
    private TextView textCounter2;  // пользовательский элемент 2-го счетчика


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

        // Получить пользовательский элемент по идентификатору
        textCounter1 = findViewById(R.id.textView1);
        textCounter2 = findViewById(R.id.textView2);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;

                //установить текст на TextView
                textCounter2.setText(String.format(Locale.getDefault(), "%d", counter2));
            }
        });

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

    // Обработка кнопки через атрибут onClick в макете
    public void button1_onClick(View view) {
        counter1++;
        textCounter1.setText(String.format(Locale.getDefault(), "%d", counter1));
    }


}