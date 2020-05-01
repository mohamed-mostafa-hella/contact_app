package com.example.mmh.myfragmenttrain.adabter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mmh.myfragmenttrain.R;
import com.example.mmh.myfragmenttrain.data_folder.contact_elem_data;

import java.util.ArrayList;

public class recyclerviewadabter extends RecyclerView.Adapter<recyclerviewadabter.myholder> {

    private ArrayList<contact_elem_data> data = new ArrayList<>();
    private Context context;
    int stata=1;

    public recyclerviewadabter(ArrayList<contact_elem_data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        myholder holder = new myholder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final myholder holder, int position) {
        final contact_elem_data contact_elem_data=data.get(position);
        holder.pname.setText(contact_elem_data.getName());
        holder.pid.setText(contact_elem_data.getId());
        String nnumber="#5#";
        if(data.get(position).getPhonenum().size() > 0)
           nnumber = contact_elem_data.getPhonenum().get(0);
        final String number=nnumber;
        holder.callimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,number, Toast.LENGTH_LONG).show();
                callnun(number);

            }
        });
        holder.smsimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,number, Toast.LENGTH_LONG).show();
                String message = "Welcome to sms";
                sendSMS(number,message);
            }
        });
        holder.loveimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contact_elem_data.isLove()){
                    contact_elem_data.setLove(false);
                    holder.loveimg.setImageResource(R.drawable.ic_love);
                }else{
                    contact_elem_data.setLove(true);
                    holder.loveimg.setImageResource(R.drawable.ic_love_red);
                }
            }
        });
        /*
        if(data.get(position).getPhoto()!=null)
            holder.pimg.setImageBitmap( BitmapFactory.decodeStream(data.get(position).getPhoto()));;
            */
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myholder extends RecyclerView.ViewHolder{

        ImageView pimg,callimg,smsimg,loveimg;
        TextView pid,pname;

        public myholder(View itemView) {
            super(itemView);
            pimg=itemView.findViewById(R.id.person_img);
            pid=itemView.findViewById(R.id.id);
            pname=itemView.findViewById(R.id.person_name);
            callimg=itemView.findViewById(R.id.call_img);
            smsimg=itemView.findViewById(R.id.sms_img);
            loveimg=itemView.findViewById(R.id.love_img);
        }
    }

    private void callnun(String nnumber){
        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+nnumber));
        try {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                context.startActivity(in);
            }
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Could not find an activity to place the call.", Toast.LENGTH_SHORT).show();
        }
    }
    private void sendSMS(String phoneNumber, String message) {
        Uri uri = Uri.parse("smsto:"+phoneNumber);
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", message);
        context.startActivity(it);
    }
}
