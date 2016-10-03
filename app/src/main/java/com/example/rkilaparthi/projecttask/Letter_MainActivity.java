package com.example.rkilaparthi.projecttask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkilaparthi on 10/3/2016.
 */
public class Letter_MainActivity extends Activity{

    String[] scheme_name;
    String[] dateofupload;
    String[] version;
    String[] description;
    String[] view;

    List<LettersData> list;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letter_activity_main);

        list = new ArrayList<LettersData>();
        scheme_name = getResources().getStringArray(R.array.scheme_name);
        dateofupload = getResources().getStringArray(R.array.dateofupload);
        version = getResources().getStringArray(R.array.version);
        description = getResources().getStringArray(R.array.description);
        view = getResources().getStringArray(R.array.view_letters);

        for (int i = 0; i < scheme_name.length; i++) {
            LettersData item = new LettersData(scheme_name[i],dateofupload[i],version[i],description[i],view[i]);
            list.add(item);
        }

        mylistview = (ListView) findViewById(R.id.list_view);
        LetterAdapterActivity adapter = new LetterAdapterActivity(this, (ArrayList) list);
        mylistview.setAdapter(adapter);
    }
}
