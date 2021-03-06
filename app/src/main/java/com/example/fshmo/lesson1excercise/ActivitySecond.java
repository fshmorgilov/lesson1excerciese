package com.example.fshmo.lesson1excercise;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class ActivitySecond extends AppCompatActivity {

    private static final String LTAG = ActivitySecond.class.getName();
    public static final String KEY_TEXT = "KEY_TEXT";
    private TextView textView;
    private Activity activity = this;
    private Button sendEmailBtn;

    public static void start(Activity activity, String text) {
        Intent intent = new Intent(activity, ActivitySecond.class);
        intent.putExtra(KEY_TEXT, text);
        activity.startActivity(intent);
    }


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
                Log.i(LTAG, "composing email");
                String[] addresses = new String[]{"fshmorgilov@gmail.com"};
                composeEmail(addresses, "Bug report", getIntent().getStringExtra(KEY_TEXT));
            }
        });


    }


    private void composeEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else {
            Log.i(LTAG, "No email app");
            Toast.makeText(activity, "No Email App found", Toast.LENGTH_LONG).show();
        }
    }


}

