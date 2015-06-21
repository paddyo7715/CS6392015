package com.mfl.brenden.asynctaskproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnClickListener {

    Context context;
    View rootView = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button Download = (Button)rootView.findViewById(R.id.Download);
        Download.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {

        Log.w("bpo", "onclick");
        ImageDownloader id = new ImageDownloader(rootView);
        Log.w("bpo", "after imageview constructor");
        id.execute("https://raw.githubusercontent.com/paddyo7715/CS6392015/master/th.jpg");
        Log.w("bpo", "after id execute");

    }

}
