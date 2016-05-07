package com.hongoctuan.admin.demoautocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView text;
    MultiAutoCompleteTextView text1;
    String[] languages={"Android ","java","IOS","anan","SQL","JDBC","Web services"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, languages);

        text.setAdapter(adapter);
        text.setThreshold(1);
    }
}
