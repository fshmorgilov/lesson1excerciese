package com.example.fshmo.lesson1excercise;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LTAG = MainActivity.class.getName();

    private Button previewBtn;
    private EditText editText;
    private Activity currentActivity = this;
//    public static final String KEY_TEXT = "KEY_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        previewBtn = findViewById(R.id.previewBtn);

        if (editText.getText() != null)
            previewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(LTAG, "BTN PRESSED");
                    String entered = editText.getText().toString();
                    Log.i(LTAG, entered);
                    Toast.makeText(currentActivity, "Showing your text", Toast.LENGTH_LONG).show();
                    ActivitySecond.start(currentActivity, entered);

                }
            });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
