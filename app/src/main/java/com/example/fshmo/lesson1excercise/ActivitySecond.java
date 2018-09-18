package com.example.fshmo.lesson1excercise;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class ActivitySecond extends AppCompatActivity {

    private static final String LTAG = ActivitySecond.class.getName();
    public static final String KEY_TEXT = "KEY_TEXT";
    private TextView textView;
    private Activity activity = this;
    private Button sendEmailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.text_view);
        textView.setText(getIntent().getStringExtra(KEY_TEXT));
        sendEmailBtn = findViewById(R.id.sendEmailBtn);
        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] addresses = new String[]{"fshmorgilov@gmail.com"};
                composeEmail(addresses, "Bug report", getIntent().getStringExtra(KEY_TEXT));
            }
        });


    }

    public static void start(Activity activity, String text) {
        Intent intent = new Intent(activity, ActivitySecond.class);
        intent.putExtra(KEY_TEXT, text);
        activity.startActivity(intent);
    }

    public void composeEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else
            Toast.makeText(activity, "No Email App found", Toast.LENGTH_LONG).show();
    }
}

