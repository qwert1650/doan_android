package com.hongoctuan.admin.ungdungxemphim;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
<<<<<<< HEAD
=======
import android.content.Intent;
>>>>>>> origin/master
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

<<<<<<< HEAD
import com.hongoctuan.admin.ungdungxemphim.BUS.GoiYSearchFragment;
import com.hongoctuan.admin.ungdungxemphim.BUS.MainFragment;
import com.hongoctuan.admin.ungdungxemphim.BUS.SearchFragment;
import com.hongoctuan.admin.ungdungxemphim.DAO.DatabaseHelper;
=======
import com.hongoctuan.admin.ungdungxemphim.DAO.DatabaseHelper;
import com.viewpagerindicator.CirclePageIndicator;
>>>>>>> origin/master

import java.util.ArrayList;

<<<<<<< HEAD
public class MainActivity extends ActionBarActivity{
=======
public class MainActivity extends ActionBarActivity implements View.OnClickListener {
>>>>>>> origin/master
    DatabaseHelper db;

    ArrayList<String> dataArray_right=new ArrayList<String>();
    ArrayList<Object> objectArray_right=new ArrayList<Object>();
    ArrayList<String> dataArray_left=new ArrayList<String>();
    ArrayList<Object> objectArray_left=new ArrayList<Object>();

    Integer[] menu = {R.drawable.ic_home, R.drawable.ic_history};
    DrawerLayout mDrawerlayout;
    ListView mDrawerList_Left,mDrawerList_Right;
    ActionBarDrawerToggle mDrawerToggle;
    ImageButton imgLeftMenu,imgRightMenu;


    ListItemsAdapterLeft Left_Adapter;
    ListItemsAdapterRight Right_Adapter;

    //Search
    ImageView iv_back;
    ImageView iv_timkiem;
    AutoCompleteTextView auto_Search;
    ArrayList<String> list_autoSearch = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_timkiem = (ImageView) findViewById(R.id.iv_timkiem);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        db= new DatabaseHelper(this);
        list_autoSearch = db.getDanhSachPhim();
        auto_Search = (AutoCompleteTextView) findViewById(R.id.autoCompleteSearch);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list_autoSearch);

        auto_Search.setAdapter(adapter);
        auto_Search.setThreshold(1);

        loadTrangChu();
        //initControl();
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
<<<<<<< HEAD
        //init();
        db = new DatabaseHelper(this);

        iv_timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_back.setVisibility(View.VISIBLE);
                auto_Search.setPadding(50, 0, 50, 0);
                db.insertLichSu(auto_Search.getText().toString());
                loadTimKiem();
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_back.setVisibility(View.GONE);
                auto_Search.setPadding(10,0,50,0);
                loadTrangChu();
            }
        });

        auto_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadGoiYSeach(auto_Search.getText().toString());
            }
        });
=======
        init();
        db = new DatabaseHelper(this);
>>>>>>> origin/master
    }

    // Filling the ArrayLists


    public void RefreshListView() {
        objectArray_left.clear();
        for (int i = 0; i < dataArray_left.size(); i++) {
            Object obj = new Object();
            objectArray_left.add(obj);
        }
        Log.d("object array", "" + objectArray_left.size());
        Left_Adapter = new ListItemsAdapterLeft(this,objectArray_left, 1,dataArray_left,menu);
        mDrawerList_Left.setAdapter(Left_Adapter);

        objectArray_right.clear();
        for (int i = 0; i < dataArray_right.size(); i++) {
            Object obj = new Object();
            objectArray_right.add(obj);
        }
        Log.d("object array", "" + objectArray_right.size());
        Right_Adapter = new ListItemsAdapterRight(this,objectArray_right, 1,dataArray_right);
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

<<<<<<< HEAD
    public void loadTrangChu(){
        Fragment fragment = new MainFragment(this);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFragment, fragment).commit();
=======

    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImageAdapter(MainActivity.this,ImagesArray));
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
>>>>>>> origin/master
    }

    public void loadTimKiem() {
        Fragment fragment = new SearchFragment(this,auto_Search.getText().toString());
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFragment, fragment).commit();
    }

    public void loadGoiYSeach(String keyword){
        Fragment fragment = new GoiYSearchFragment(this,auto_Search.getText().toString());
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFragment, fragment).commit();
    }
}
