package com.hongoctuan.admin.ungdungxemphim;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hongoctuan.admin.ungdungxemphim.DAO.DatabaseHandler;
import com.hongoctuan.admin.ungdungxemphim.DTO.BinhluanDTO;
import com.hongoctuan.admin.ungdungxemphim.DTO.PhimDTO;

import java.util.ArrayList;

public class MovieDetail extends Activity {
    DatabaseHandler db;
    PhimDTO phim;
    TextView txt_tenphim, txt_daodien, txt_dienvien, txt_noidungphim;
    ImageView iv_phim;
    ArrayList<BinhluanDTO> list_binhluan;
    ListView lv_binhluan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent callerIntent=getIntent();
        Bundle packageFromCaller= callerIntent.getBundleExtra("myData");
        String id = packageFromCaller.getString("id");
        db = new DatabaseHandler(this);
        phim = new PhimDTO();
        phim = db.getPhim(id);
        list_binhluan = new ArrayList<BinhluanDTO>();
        list_binhluan = db.getBinhluan(id);

        txt_tenphim = (TextView) findViewById(R.id.txt_tenphim);
        txt_daodien = (TextView) findViewById(R.id.txt_daodien);
        txt_dienvien = (TextView) findViewById(R.id.txt_dienvien);
        iv_phim = (ImageView) findViewById(R.id.iv_phim);
        txt_noidungphim = (TextView) findViewById(R.id.txt_noidungphim);
        lv_binhluan = (ListView) findViewById(R.id.lv_binhluan);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        Drawable progress = ratingBar.getProgressDrawable();
        DrawableCompat.setTint(progress, Color.WHITE);

        txt_tenphim.setText(phim.getTenphim());
        String htmlDaodien="<b><u>Đạo diễn:</u></b>" +" "+ phim.getDaodien();
        txt_daodien.setText(Html.fromHtml(htmlDaodien));
        String htmlDienvien="<b><u>Diễn viên:</u></b>"+" "+ phim.getDienvien();
        txt_dienvien.setText(Html.fromHtml(htmlDienvien));
        int maphim = getResources().getIdentifier("com.hongoctuan.admin.ungdungxemphim:drawable/" + id, null, null);
        iv_phim.setImageResource(maphim);
        txt_noidungphim.setText(phim.getTomtat());
        BinhLuan_CustomList binhluanAdapter = new BinhLuan_CustomList(this,R.layout.activity_binh_luan__custom_list,list_binhluan);
        lv_binhluan.setAdapter(binhluanAdapter);
    }
}
