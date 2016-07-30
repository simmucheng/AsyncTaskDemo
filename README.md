# AsyncTaskDemo

关于AsyncTask的简单用法，其中AsyncTask需要使用到的四个方法，包括


doInBackgroud()，->运行在线程池

onPostExecute(),->运行在UI线程

onPreExecute(),->运行在UI线程

onProgressUpdate()->运行在UI线程。

该项目完成了
1.从网上通过URL通过异步任务类加载一张图片并显示出来。


2.模拟进度条的运行，并详细处理了在android系统中按下back后，进度条还在后台运行，通过在activity的onPause方法中标记cancel并在onPostExecute()方法中截断程序的运行。
