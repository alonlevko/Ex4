package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class joyStickActivity extends AppCompatActivity {
    TcpClient mTcpClient;
    String ip;
    String port;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joy_stick);
        Intent intent = getIntent();
        this.ip = intent.getStringExtra("ipStr");
        this.port = intent.getStringExtra("portStr");
        new ConnectTask().execute("");
    }

    public class ConnectTask extends AsyncTask<String, String, TcpClient> {
        @Override
        protected TcpClient doInBackground(String... message) {

            //we create a TCPClient object
            mTcpClient = new TcpClient(ip, port);
            mTcpClient.run();
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

    public class joyStickView extends View {
        private Paint back;
        private Paint middle;
        private Paint stick;
        public joyStickView(Context context) {
            super(context);
            back = new Paint(Paint.ANTI_ALIAS_FLAG);
            back.setColor(Color.BLUE);
            back.setStyle(Paint.Style.FILL);
            middle = new Paint(Paint.ANTI_ALIAS_FLAG);
            middle.setColor(Color.GRAY);
            middle.setStyle(Paint.Style.FILL);
            stick = new Paint(Paint.ANTI_ALIAS_FLAG);
            stick.setColor(Color.GREEN);
            stick.setStyle(Paint.Style.FILL);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        }

        @Override
        protected void onDraw(Canvas canvas) {

        }
    }
}
