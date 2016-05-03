package com.hongoctuan.admin.ungdungxemphim;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hongoctuan.admin.ungdungxemphim.DAO.DatabaseHandler;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    DatabaseHandler db;

    ArrayList<String> dataArray_right=new ArrayList<String>();
    ArrayList<Object> objectArray_right=new ArrayList<Object>();
    ArrayList<String> dataArray_left=new ArrayList<String>();
    ArrayList<Object> objectArray_left=new ArrayList<Object>();

    Integer[] menu = {R.drawable.ic_home, R.drawable.ic_history};
    DrawerLayout mDrawerlayout;
    ListView mDrawerList_Left,mDrawerList_Right;
    ActionBarDrawerToggle mDrawerToggle;
    ImageButton imgLeftMenu,imgRightMenu;


    ListItemsAdapter_Left Left_Adapter;
    ListItemsAdapter_Right Right_Adapter;

    //slide show
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.five};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    ImageView iv_hd01,iv_hd02,iv_hd03,iv_hd04,iv_hd05,iv_hh01,iv_hh02,iv_hh03,iv_hh04,iv_hh05,iv_gt01,iv_gt02,iv_gt03,iv_gt04,iv_gt05;
    TextView txt_hd01,txt_hd02,txt_hd03,txt_hd04,txt_hd05,txt_hh01,txt_hh02,txt_hh03,txt_hh04,txt_hh05,txt_gt01,txt_gt02,txt_gt03,txt_gt04,txt_gt05;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        //===============Initialization of Variables=========================//

        mDrawerlayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList_Left=(ListView)findViewById(R.id.drawer_list_left);
        mDrawerList_Right=(ListView)findViewById(R.id.drawer_list_right);
        imgLeftMenu=(ImageButton)findViewById(R.id.imgLeftMenu);
        imgRightMenu=(ImageButton)findViewById(R.id.imgRightMenu);
        mDrawerlayout.setDrawerListener(mDrawerToggle);


        //============== Define a Custom Header for Navigation drawer=================//


        LayoutInflater inflator=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflator.inflate(R.layout.header, null);

        imgLeftMenu=(ImageButton)v.findViewById(R.id.imgLeftMenu);
        imgRightMenu=(ImageButton)v.findViewById(R.id.imgRightMenu);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1281A9")));
        getSupportActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getSupportActionBar().setCustomView(v);

        imgLeftMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (mDrawerlayout.isDrawerOpen(mDrawerList_Right)) {
                    mDrawerlayout.closeDrawer(mDrawerList_Right);
                }
                mDrawerlayout.openDrawer(mDrawerList_Left);
            }
        });


        imgRightMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (mDrawerlayout.isDrawerOpen(mDrawerList_Left)) {
                    mDrawerlayout.closeDrawer(mDrawerList_Left);
                }
                mDrawerlayout.openDrawer(mDrawerList_Right);
            }
        });

        mDrawerList_Left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_SHORT).show();
            }
        });
        Fill_LeftList();
        Fill_RightList();
        RefreshListView();
        init();
        db = new DatabaseHandler(this);
    }

    // Filling the ArrayLists


    public void RefreshListView() {
        objectArray_left.clear();
        for (int i = 0; i < dataArray_left.size(); i++) {
            Object obj = new Object();
            objectArray_left.add(obj);
        }
        Log.d("object array", "" + objectArray_left.size());
        Left_Adapter = new ListItemsAdapter_Left(this,objectArray_left, 1,dataArray_left,menu);
        mDrawerList_Left.setAdapter(Left_Adapter);

        objectArray_right.clear();
        for (int i = 0; i < dataArray_right.size(); i++) {
            Object obj = new Object();
            objectArray_right.add(obj);
        }
        Log.d("object array", "" + objectArray_right.size());
        Right_Adapter = new ListItemsAdapter_Right(this,objectArray_right, 1,dataArray_right);
        mDrawerList_Right.setAdapter(Right_Adapter);
    }
    public void Fill_LeftList()
    {
        dataArray_left.clear();
        dataArray_left.add("Trang Chủ");
        dataArray_left.add("Lich Chiếu Theo Rạp");
    }


    public void Fill_RightList()
    {
        dataArray_right.clear();
        dataArray_right.add("Option 1");
    }


    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this,ImagesArray));
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);
        NUM_PAGES =IMAGES.length;
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }
            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {
            }
            @Override
            public void onPageScrollStateChanged(int pos) {
            }
        });
    }

    public void initControl(){
        iv_hd01 = (ImageView) findViewById(R.id.iv_hd01);
        iv_hd02 = (ImageView) findViewById(R.id.iv_hd02);
        iv_hd03 = (ImageView) findViewById(R.id.iv_hd03);
        iv_hd04 = (ImageView) findViewById(R.id.iv_hd04);
        iv_hd05 = (ImageView) findViewById(R.id.iv_hd05);

        iv_hh01 = (ImageView) findViewById(R.id.iv_hh01);
        iv_hh02 = (ImageView) findViewById(R.id.iv_hh02);
        iv_hh03 = (ImageView) findViewById(R.id.iv_hh03);
        iv_hh04 = (ImageView) findViewById(R.id.iv_hh04);
        iv_hh05 = (ImageView) findViewById(R.id.iv_hh05);

        iv_gt01 = (ImageView) findViewById(R.id.iv_gt01);
        iv_gt02 = (ImageView) findViewById(R.id.iv_gt02);
        iv_gt03 = (ImageView) findViewById(R.id.iv_gt03);
        iv_gt04 = (ImageView) findViewById(R.id.iv_gt04);
        iv_gt05 = (ImageView) findViewById(R.id.iv_gt05);

        txt_hd01 = (TextView) findViewById(R.id.txt_hd01);
        txt_hd02 = (TextView) findViewById(R.id.txt_hd02);
        txt_hd03 = (TextView) findViewById(R.id.txt_hd03);
        txt_hd04 = (TextView) findViewById(R.id.txt_hd04);
        txt_hd05 = (TextView) findViewById(R.id.txt_hd05);

        txt_hh01 = (TextView) findViewById(R.id.txt_hh01);
        txt_hh02 = (TextView) findViewById(R.id.txt_hh02);
        txt_hh03 = (TextView) findViewById(R.id.txt_hh03);
        txt_hh04 = (TextView) findViewById(R.id.txt_hh04);
        txt_hh05 = (TextView) findViewById(R.id.txt_hh05);

        txt_gt01 = (TextView) findViewById(R.id.txt_gt01);
        txt_gt02 = (TextView) findViewById(R.id.txt_gt02);
        txt_gt03 = (TextView) findViewById(R.id.txt_gt03);
        txt_gt04 = (TextView) findViewById(R.id.txt_gt04);
        txt_gt05 = (TextView) findViewById(R.id.txt_gt05);

        iv_hd01.setOnClickListener(this);
        iv_hd02.setOnClickListener(this);
        iv_hd03.setOnClickListener(this);
        iv_hd04.setOnClickListener(this);
        iv_hd05.setOnClickListener(this);

        iv_hh01.setOnClickListener(this);
        iv_hh02.setOnClickListener(this);
        iv_hh03.setOnClickListener(this);
        iv_hh04.setOnClickListener(this);
        iv_hh05.setOnClickListener(this);

        iv_gt01.setOnClickListener(this);
        iv_gt02.setOnClickListener(this);
        iv_gt03.setOnClickListener(this);
        iv_gt04.setOnClickListener(this);
        iv_gt05.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id="";
        if(v.getId() == iv_hd01.getId())
            id = "hd01";
        if(v.getId() == iv_hd02.getId())
            id = "hd02";
        Intent intent = new Intent(MainActivity.this, MovieDetail.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        intent.putExtra("myData",bundle);
        startActivity(intent);
    }
}
