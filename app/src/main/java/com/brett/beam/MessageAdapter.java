package com.brett.beam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Created by Ermano
 * on 4/14/2018.
 */

public class MessageAdapter extends ArrayAdapter<MessageNFC> {

    LayoutInflater inflater ;

    private class ViewHolder{
        TextView tv_from, tv_msg, tv_date;
        public ViewHolder(){}
    }

    public MessageAdapter(@NonNull Context context, int resource, @NonNull List<MessageNFC> objects) {
        super(context, resource, objects);

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;
        int layoutResource = 0;
        String status = "";
        MessageNFC message = getItem(position);

        if (message.getFrom().equals("Me")){
            layoutResource = R.layout.msg_right;

        }else{
            layoutResource = R.layout.msg_left;
        }

        holder = new ViewHolder();
        convertView = inflater.inflate(layoutResource, parent, false);

        holder.tv_from = (TextView) convertView.findViewById(R.id.msg_from);
        holder.tv_msg = (TextView) convertView.findViewById(R.id.msg_msg);
        holder.tv_date = (TextView) convertView.findViewById(R.id.msg_date);

        convertView.setTag(holder);

        holder.tv_from.setText(message.getFrom());

        holder.tv_msg.setText(message.getMessage());

        holder.tv_date.setText(String.format(Locale.US, "%s", message.getmDate()));


        return convertView;
    }



}
