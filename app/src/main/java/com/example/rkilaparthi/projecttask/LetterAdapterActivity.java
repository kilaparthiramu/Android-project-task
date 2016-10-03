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
 * Created by rkilaparthi on 10/3/2016.
 */
public class LetterAdapterActivity extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList myList=new ArrayList();

    public LetterAdapterActivity(Context context, ArrayList myList){

        this.context = context;
        this.myList = myList;
        inflater=LayoutInflater.from(this.context);
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public LettersData getItem(int position) {
        return (LettersData) myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if(convertView == null){
            convertView=inflater.inflate(R.layout.letter_row,parent,false);
            holder=new MyViewHolder();
            convertView.setTag(holder);
            holder.scheme_name=(TextView)convertView.findViewById(R.id.txt_view_scheme_name);
            holder.dateofupload=(TextView)convertView.findViewById(R.id.txt_view_date_upload);
            holder.version=(TextView)convertView.findViewById(R.id.txt_view_version);
            holder.description=(TextView)convertView.findViewById(R.id.txt_view_description);
            holder.view=(Button) convertView.findViewById(R.id.button_view);
        }
        else {
            holder = (MyViewHolder) convertView.getTag();
        }
        final LettersData list_pos = (LettersData) myList.get(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toaster(view, list_pos.getScheme_name());
            }
        });

        holder.scheme_name.setText(list_pos.getScheme_name());
        holder.dateofupload.setText(list_pos.getDateof_upload());
        holder.version.setText(list_pos.getVersion());
        holder.description.setText(list_pos.getDescription());
        holder.view.setText(list_pos.getView());
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
        View dialogview = inflater.inflate(R.layout.letter_dailogue, null);
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
        TextView scheme_name;
        TextView dateofupload;
        TextView version;
        TextView description;
        Button view;
    }
}
