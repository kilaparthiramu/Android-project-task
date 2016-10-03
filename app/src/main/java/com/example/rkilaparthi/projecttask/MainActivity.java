package com.example.rkilaparthi.projecttask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    String[] auction_id;
    String[] auction_detail;
    String[] zone;
    String[] area;
    String[] view;
    String[] google_map;

    List<ListData> list;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<ListData>();
        auction_id = getResources().getStringArray(R.array.auctionid);
        auction_detail = getResources().getStringArray(R.array.auctiondetail);
        zone = getResources().getStringArray(R.array.zone);
        area = getResources().getStringArray(R.array.area);
        view = getResources().getStringArray(R.array.view);
        google_map = getResources().getStringArray(R.array.map);

        for (int i = 0; i < auction_id.length; i++) {
            ListData item = new ListData(auction_id[i],auction_detail[i],zone[i],area[i],view[i],google_map[i]);
            list.add(item);
        }

        mylistview = (ListView) findViewById(R.id.list_view);
        BaseAdapterActivity adapter = new BaseAdapterActivity(this, (ArrayList) list);
        mylistview.setAdapter(adapter);
    }


}



















