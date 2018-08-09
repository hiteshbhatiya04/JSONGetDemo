package com.example.hitesh.studentjsonactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentAdapter extends BaseAdapter {

    Context context;
    ArrayList<HashMap<String, String>> hashMapArrayList;

    public StudentAdapter(MainActivity mainActivity, ArrayList<HashMap<String, String>> hashMapArrayList) {

    this.context =mainActivity;
    this.hashMapArrayList =hashMapArrayList;
    }

    @Override
    public int getCount() {
        return hashMapArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.student_layout,null);
        TextView id = (TextView)view1.findViewById(R.id.txt_id);
        TextView name = (TextView)view1.findViewById(R.id.txt_name);
        TextView email = (TextView)view1.findViewById(R.id.txt_email);
        TextView address = (TextView)view1.findViewById(R.id.txt_address);
        TextView gender = (TextView)view1.findViewById(R.id.txt_gender);
        TextView mob = (TextView)view1.findViewById(R.id.txt_mobile);
        TextView home = (TextView)view1.findViewById(R.id.txt_home);
        TextView office = (TextView)view1.findViewById(R.id.txt_office);

        id.setText("Id :"+hashMapArrayList.get(i).get("id"));
        name.setText("Name :"+hashMapArrayList.get(i).get("name"));
        email.setText("Email :"+hashMapArrayList.get(i).get("email"));
        address.setText("Address :"+hashMapArrayList.get(i).get("address"));
        gender.setText("Gender :"+hashMapArrayList.get(i).get("gender"));
        mob.setText("Mobile :"+hashMapArrayList.get(i).get("mob"));
        home.setText("Home :"+hashMapArrayList.get(i).get("home"));
        office.setText("Office :"+hashMapArrayList.get(i).get("office"));

        return view1;
    }
}
