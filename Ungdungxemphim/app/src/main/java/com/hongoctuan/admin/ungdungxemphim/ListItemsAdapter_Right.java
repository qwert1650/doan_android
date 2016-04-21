package com.hongoctuan.admin.ungdungxemphim;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 4/16/2016.
 */
public class ListItemsAdapter_Right extends ArrayAdapter<Object>
{
    Activity contextCha;
    ArrayList<String> dataArray_right;


    public ListItemsAdapter_Right(Activity contextCha,List<Object> items, int x,ArrayList<String> dataArray_right) {
        // TODO Auto-generated constructor stub
        super(contextCha, android.R.layout.simple_list_item_single_choice, items);
        this.contextCha = contextCha;
        this.dataArray_right = dataArray_right;
    }

    @Override
    public String getItem(int position) {
        // TODO Auto-generated method stub
        return dataArray_right.get(position);
    }

    public int getItemInteger(int pos)
    {
        return pos;

    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dataArray_right.size();
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflator=contextCha.getLayoutInflater();
        convertView=inflator.inflate(R.layout.login_layout, null);
        EditText txt =(EditText) convertView.findViewById(R.id.eidt_tendangnhap);
        Button btn = (Button) convertView.findViewById(R.id.btn_login);
        String text=dataArray_right.get(position);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contextCha,"noi dung 123 ",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}