package com.mfl.brenden.imageviewer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View.OnClickListener;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnClickListener {

    View rootView = null;
    TextView tv = null;
    ImageView iv = null;
    int Current_Car = 0;

    final static int NUMBER_OF_CARS = 5;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container, false);


        tv = (TextView)rootView.findViewById(R.id.text_view);
        tv.setText(R.string.car1_name);

        iv = (ImageView)rootView.findViewById(R.id.image_view);
        iv.setImageResource(R.drawable.car1);

        Button prev = (Button)rootView.findViewById(R.id.prev);
        prev.setOnClickListener(this);

        Button next = (Button)rootView.findViewById(R.id.next);
        next.setOnClickListener(this);


        Current_Car = 1;

        return rootView;

    }
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.prev:
                Current_Car--;
                if (Current_Car == 0) Current_Car = NUMBER_OF_CARS;
                break;
            case R.id.next:
                Current_Car++;
                if (Current_Car == NUMBER_OF_CARS + 1) Current_Car = 1;
                break;
        }

        int imgID = getResources().getIdentifier("car" + Current_Car, "drawable", this.getActivity().getPackageName());
        int stgID = getResources().getIdentifier("car" + Current_Car + "_name", "string", this.getActivity().getPackageName());

        iv.setImageResource(imgID);
        tv.setText(stgID);

    }

}
