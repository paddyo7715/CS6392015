package com.mfl.brenden.statesproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import android.util.Log;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AdapterView.OnItemClickListener {

    View rootView = null;
    Context context = null;
    ListView lv = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        context = getActivity();

        final ListView listview = (ListView) rootView.findViewById(R.id.listviewlayout);
        String[] states = new String[] { "Alabama", "Alaska", "Arizona",
                "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
                "Florida", "Georgia", "Hawaii", "Idaho", "Louisiana", "Indiana",
                "Iowa", "Kansas", "Kentucky", "Maine", "Maryland", "Massachusetts",
                "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
                "Nevada ", "New Hampshire", "New Jersey", "New Mexico", "New York ", "North Carolina",
                "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island",
                "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont ",
                "Virginia", "Washington", "West Virginia", "Wisconsin ", "Wyoming" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, states);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < states.length; ++i) {
            list.add(states[i]);
        }

        lv = (ListView)rootView.findViewById(R.id.listviewlayout);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);



        return rootView;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {

        Log.w("bpo", "onclick");

        // ListView Clicked item index
        int itemPosition     = position;

        // ListView Clicked item value
        String  itemValue    = (String) lv.getItemAtPosition(position);

        // Show Alert
//        Toast.makeText(context,
//                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
//                .show();

        if (itemValue.equals("Ohio")) {

// Create a Uri from an intent string. Use the result to create an Intent.
//            Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
            Uri gmmIntentUri = Uri.parse("geo:39.9611111,-82.9988889?q=39.9611111,-82.9988889&z=6(Ohio, State Capital)");
//            String Uri = String.format(Locale.ENGLISH, "geo:%f,%f", 39.9611111, -82.9988889);


// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps");
// Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);
        }


 //       final Intent activityintent = new Intent(getActivity(),NewActivity.class);
//        final Intent activityintent = new Intent(getActivity(),MapsActivity.class);
//        startActivity(activityintent);

    }
}
