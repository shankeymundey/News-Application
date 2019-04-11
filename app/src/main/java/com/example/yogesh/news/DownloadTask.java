package com.example.yogesh.news;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;

/**
 * Created by Yogesh on 7/27/2018.
 */


public class DownloadTask extends AsyncTask<String, Void, Bitmap> {
    ImageView v;
    String url;

    public DownloadTask(ImageView v,String url) {
        this.v = v;
        this.url=url;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap b=null;
        try {
            URL newurl = new URL(url);
            b = BitmapFactory.decodeStream(newurl.openConnection()
                    .getInputStream());

        } catch (Exception e) {

        }
        return b;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        v.setImageBitmap(result);
    }


}

