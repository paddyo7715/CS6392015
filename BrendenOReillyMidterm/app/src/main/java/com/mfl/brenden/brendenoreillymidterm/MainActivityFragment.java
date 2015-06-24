package com.mfl.brenden.brendenoreillymidterm;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    View rootView = null;
    final double CONVERT_RATE = 1.609;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button Convert = (Button)rootView.findViewById(R.id.Convert);
        Convert.setOnClickListener(this);

        return rootView;
    }
    public void onClick(View v) {

        String ResultString = "";
        try {
            EditText miles = (EditText) rootView.findViewById(R.id.editmiles_et);
            ResultString = String.valueOf(Double.parseDouble(miles.getText().toString()) * CONVERT_RATE) + " kilometers";

        } catch (Exception e) {
            ResultString = "Error during conversion.  Please try again";
        } finally {
            TextView result = (TextView) rootView.findViewById(R.id.Result);
            result.setText(ResultString);
        }
    }
}
