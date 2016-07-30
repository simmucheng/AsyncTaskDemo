package com.example.simmucheng.asynctaskdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mAsyncTaskButton;
    private Button mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAsyncTaskButton= (Button) findViewById(R.id.btn_asynctask);
        mProgressBar= (Button) findViewById(R.id.btn_progressbar);

        mAsyncTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,AsyncTaskActivity.class);
                startActivity(intent);
            }
        });
        mProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,ProgressBarActivity.class);
                startActivity(intent);

            }
        });
    }
}
