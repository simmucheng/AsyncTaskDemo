package com.example.simmucheng.asynctaskdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by simmucheng on 16/7/30.
 */
public class AsyncTaskActivity extends Activity{
    private ImageView im_picture;
    private ProgressBar pb_progress;
    public static String url="http://pic3.zhongsou.com/image/38063b6d7defc892894.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_asynctask);
        im_picture= (ImageView) findViewById(R.id.iv_picture);
        pb_progress= (ProgressBar) findViewById(R.id.progressbar);
        new MyAsyncTask().execute(url);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    class MyAsyncTask extends AsyncTask<String,Void,Bitmap>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb_progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            pb_progress.setVisibility(View.GONE);
            im_picture.setImageBitmap(bitmap);

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String url=params[0];
            Bitmap bitmap=null;
            URLConnection connection;
            InputStream is;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                connection= new URL(url).openConnection();
                is=connection.getInputStream();
                bitmap= BitmapFactory.decodeStream(new BufferedInputStream(is));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
    }
}
