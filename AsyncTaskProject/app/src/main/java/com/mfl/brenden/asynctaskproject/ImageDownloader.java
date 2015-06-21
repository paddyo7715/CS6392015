package com.mfl.brenden.asynctaskproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloader extends AsyncTask< String, String, Bitmap >
{
    View rootView;

    public ImageDownloader(View rootView) {
        Log.w("bpo", "Imagedownloader constructor called");
        this.rootView = rootView;
    }

    @Override
    public void onPreExecute()
    { }

    @Override
    public Bitmap doInBackground(String... params) {
        URL url = null;
        HttpURLConnection httpCon = null;
        Bitmap b = null;
        try {

            Log.w("bpo", "params0 " + params[0]);

            url = new URL(params[0]);
            Log.w("bpo", "Url " + url.getPath());

            httpCon = (HttpURLConnection)     url.openConnection();

            Log.w("bpo", "Url connection return " + httpCon.getResponseCode());

            if( httpCon.getResponseCode() != 200)
                throw new Exception(" Failed to connect");

            InputStream is = httpCon.getInputStream();
            b = BitmapFactory.decodeStream( is);
        }
        catch (Exception e) {
            Log.w("bpo", "doInBackground error " + e.getMessage());
        }
        finally
        {
            return b;
        }
    }

        @Override
        public void onPostExecute( Bitmap img)
        {
            ImageView iv = (ImageView) rootView.findViewById(R.id.imageView);

            if( iv != null && img != null)
            iv.setImageBitmap( img);
        }

    }



