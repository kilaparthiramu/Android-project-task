package com.example.rkilaparthi.projecttask;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rkilaparthi on 9/26/2016.
 */
public class BaseAdapterActivity extends BaseAdapter {
     LayoutInflater inflater;
     Context context;
     ArrayList myList=new ArrayList();

    public BaseAdapterActivity(Context context, ArrayList myList){

        this.context = context;
        this.myList = myList;
        inflater=LayoutInflater.from(this.context);
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public ListData getItem(int position) {
        return (ListData) myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if(convertView == null){
            convertView=inflater.inflate(R.layout.row,parent,false);
            holder=new MyViewHolder();
            convertView.setTag(holder);
            holder.auction_id=(TextView)convertView.findViewById(R.id.txt_view_auction_id);
            holder.auction_detail=(TextView)convertView.findViewById(R.id.txt_view_auction_detail);
            holder.zone=(TextView)convertView.findViewById(R.id.txt_view_Zone);
            holder.area=(TextView)convertView.findViewById(R.id.txt_view_area);
            holder.view=(Button) convertView.findViewById(R.id.button_view);
            holder.google_map=(Button) convertView.findViewById(R.id.button_map);
        }
        else {
            holder = (MyViewHolder) convertView.getTag();
        }
        final ListData list_pos = (ListData) myList.get(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toaster(view, list_pos.getAuction_id());
            }
        });

        holder.auction_id.setText(list_pos.getAuction_id());
        holder.auction_detail.setText(list_pos.getAuction_detail());
        holder.zone.setText(list_pos.getZone());
        holder.area.setText(list_pos.getArea());
        holder.view.setText(list_pos.getView());
        holder.google_map.setText(list_pos.getGoogle_map());
        
        return convertView;
    }

    public void toaster(View view, String auction_id) {
        SpannableString ss = new SpannableString("If you are unable to view files,you can download from here or download Adobe Pdf Reader to view the file");

        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View alertDialogBuilder) {
                context.startActivity(new Intent(context,FromActivity.class));
            }
        };

        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                context.startActivity(new Intent(context,FromActivity.class));

            }
        };
        ss.setSpan(span1, 54, 58, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 71, 87, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogview = inflater.inflate(R.layout.dialog, null);
        TextView t1=(TextView)dialogview.findViewById(R.id.dialogue_title);
        TextView t2=(TextView)dialogview.findViewById(R.id.dialogue_message);
        TextView t3=(TextView)dialogview.findViewById(R.id.dialogue_ok);
        t1.setText(auction_id);
        t2.setText(ss);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(dialogview);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"You clicked yes button",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });


    }
    
    private class MyViewHolder{
        TextView auction_id;
        TextView auction_detail;
        TextView zone;
        TextView area;
        Button view;
        Button google_map;

    }
}
