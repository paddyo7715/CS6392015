package com.mfl.brenden.menuproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnClickListener {

    Context context;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button SMS = (Button)rootView.findViewById(R.id.SMS);
        SMS.setOnClickListener(this);

        Button Phone = (Button)rootView.findViewById(R.id.Phone);
        Phone.setOnClickListener(this);

        Button Map = (Button)rootView.findViewById(R.id.Map);
        Map.setOnClickListener(this);

        Button Web = (Button)rootView.findViewById(R.id.Web);
        Web.setOnClickListener(this);

        Button Share = (Button)rootView.findViewById(R.id.Share);
        Share.setOnClickListener(this);

        Button NewActivity = (Button)rootView.findViewById(R.id.NewActivity);
        NewActivity.setOnClickListener(this);



        return rootView;
    }
    @Override
    public void onClick(View v) {


       switch(v.getId()){
           case R.id.SMS:
               final Intent sendIntent = new Intent(Intent.ACTION_VIEW);
               sendIntent.setData(Uri.parse("smsto:" + Uri.encode("123456789")));
               sendIntent.putExtra("Hi this is Brenden OReilly", "hello");
               startActivity(sendIntent);
               break;
            case R.id.Phone:
                Toast.makeText(context, "this is my Toast message!!! =)",
                        Toast.LENGTH_LONG).show();
                final Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:2127651234"));
                startActivity(dialIntent);
                break;
           case R.id.Web:
               final Intent WEBIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.com"));
               startActivity(WEBIntent);
               break;
           case R.id.Map:
               float lat = 40.714728f;
               float lng = -73.998672f;

               String maplLabel = "ABC Label";
               final Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                       Uri.parse("geo:0,0?q="+lat+","+lng+"&z=16 (" + maplLabel + ")"));
               startActivity(intent);
               break;
           case R.id.Share:
               Intent sintent = new Intent();
               sintent.setAction(Intent.ACTION_SEND);
               sintent.setType("text/plain");
               Intent shareintent = new Intent();
               shareintent.setAction(Intent.ACTION_CHOOSER);
               shareintent.putExtra(Intent.EXTRA_TITLE, "Share The Love!");
               shareintent.putExtra(Intent.EXTRA_INTENT, sintent);
               startActivity(shareintent);
               break;
           case R.id.NewActivity:
               final Intent activityintent = new Intent(getActivity(),NewActivity.class);
               startActivity(activityintent);
               break;
       }
    }




}
