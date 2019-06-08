package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void connectToServer(View view) {
        EditText ip = (EditText) findViewById(R.id.IPIN);
        EditText port = (EditText) findViewById(R.id.portIn);
        String ipStr = ip.getText().toString();
        String portStr = port.getText().toString();
        Intent intent = new Intent(this, joyStickActivity.class);
        intent.putExtra("ipStr", ipStr);
        intent.putExtra("portStr", portStr );
        startActivity(intent);
    }
}
