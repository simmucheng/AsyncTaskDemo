package com.example.simmucheng.asynctaskdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * Created by simmucheng on 16/7/30.
 */
public class ProgressBarActivity extends Activity{
    private ProgressBar pb_progressbar;
    private MyAsyncTask mTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_progressbar);
        pb_progressbar= (ProgressBar) findViewById(R.id.pb_h_progressbar);
        mTask=new MyAsyncTask();
        mTask.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mTask!=null&&mTask.getStatus()== AsyncTask.Status.RUNNING){
            //cancel方法只是将对应的AsyncTask标记为cancel状态，并不是真正取消线程的执行。
            mTask.cancel(true);
        }

    }

    class MyAsyncTask extends AsyncTask<Void,Integer,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //更新progressbar的时候
            if(isCancelled()){
                return ;
            }
            pb_progressbar.setProgress(values[0]);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(int i=0;i<100;i++){
                if(isCancelled()){
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }
    }
}

