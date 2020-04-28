package com.example.multipleactivitiessample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;

public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        Button btnMain = findViewById(R.id.btnMain);
        Button btnSecond = findViewById(R.id.btnSecond);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            btnMain.setText(bundle.getString("edValueFromMainActivity"));
        }

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        btnSecond.setText(sp.getString("edValueFromMainActivityUsingSp","Missing"));
    }
}
