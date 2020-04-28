package com.example.multipleactivitiessample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.open_receiver_activity:
                EditText edMain = findViewById(R.id.edMain);
                Intent receiverActivityIntent = new Intent(getApplicationContext(), ReceiverActivity.class);
                String edValue = edMain.getText().toString();
                receiverActivityIntent.putExtra("edValueFromMainActivity", edValue);

                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor spEd = sp.edit();
                spEd.putString("edValueFromMainActivityUsingSp", edValue);
                spEd.apply();

                startActivity(receiverActivityIntent);
                return true;
            case R.id.show_message:
                Toast.makeText(this, "Some important message", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
