package com.hongoctuan.admin.democustomtestview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mLayout = (LinearLayout) findViewById(R.id.li_main);
//        mEditText = (EditText) findViewById(R.id.editText);
//        mButton = (Button) findViewById(R.id.button);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mLayout.addView(createNewTextView(mEditText.getText().toString()));
//            }
//        });
//        TextView textView = new TextView(this);
//        textView.setText("New text");
    }


//    private TextView createNewTextView(String text) {
//        final LinearLayoutCompat.LayoutParams lparams = new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
//        final TextView textView = new TextView(this);
//        textView.setLayoutParams(lparams);
//        textView.setText("New text: " + text);
//        return textView;
//    }
}
