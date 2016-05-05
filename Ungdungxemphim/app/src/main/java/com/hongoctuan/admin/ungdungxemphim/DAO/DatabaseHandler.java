package com.hongoctuan.admin.ungdungxemphim.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.hongoctuan.admin.ungdungxemphim.DTO.BinhluanDTO;
import com.hongoctuan.admin.ungdungxemphim.DTO.PhimDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 5/3/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "ungdungxemphim";
    private static int DATABASE_VERSION = 1;
    public static String TABLE_PHIM = "phim";
    public static String TABLE_BINHLUAN = "binhluan";
    Context context;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        //insertData();
    }

    public PhimDTO getPhim(String maphim){
        PhimDTO phim = new PhimDTO();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_PHIM +" where id = '"+maphim+"'";

        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        phim.setMaphim(cursor.getString(0));
        phim.setTenphim(cursor.getString(1));
        phim.setDaodien(cursor.getString(2));
        phim.setDienvien(cursor.getString(3));
        phim.setDanhgia(cursor.getString(4));
        phim.setTomtat(cursor.getString(5));
        phim.setTheloai(cursor.getString(6));
        phim.setUrl(cursor.getString(7));
        db.close();
        return phim;
    }
    public ArrayList<PhimDTO> getListPhimGoiY(String theloai, String maphim){
        ArrayList<PhimDTO> list = new ArrayList<PhimDTO>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_PHIM +" where id != '"+maphim+"' and theloai = '" + theloai +"'";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            PhimDTO phim = new PhimDTO();
            phim.setMaphim(cursor.getString(0));
            phim.setTenphim(cursor.getString(1));
            phim.setDaodien(cursor.getString(2));
            phim.setDienvien(cursor.getString(3));
            phim.setDanhgia(cursor.getString(4));
            phim.setTomtat(cursor.getString(5));
            phim.setTheloai(cursor.getString(6));
            phim.setUrl(cursor.getString(7));
            list.add(phim);
            cursor.moveToNext();
        }
        db.close();
        return list;
    }
    public ArrayList<BinhluanDTO> getBinhluan(String maphim){
        ArrayList<BinhluanDTO> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_BINHLUAN +" where maphim = '"+maphim+"'";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            BinhluanDTO binhluan = new BinhluanDTO();
            binhluan.setMabinhluan(cursor.getString(0));
            binhluan.setNguoibinhluan(cursor.getString(2));
            binhluan.setContent(cursor.getString(3));
            list.add(binhluan);
            cursor.moveToNext();
        }
        db.close();
        return list;
    }

    public void insertData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", "hd01");
        values.put("tenphim", "Biệt đội đánh thuê");
        values.put("daodien", "Sylvester Stallone");
        values.put("dienvien", "Lý Liên Kiệt, Sylvester Stallone, Jason Statham, Jet Li, Dolph Lundgren");
        values.put("danhgia", "4");
        values.put("tomtat", "Bộ phim là cuộc chiến của một nhóm lính đánh thuê, nhằm vào Nam Mỹ để hoàn thành nhiệm vụ " +
                "là lật đổ một nhà độc tài tại đây. Nhà độc tài là tướng quân Garza. Dù là tướng quân nhưng ông lại bị một " +
                "cưu điệp viên CIA  thao túng và ép phải ủng hộ cho việc sản xuất thuốc phiện.Khi nhóm đánh thuê do Barney Ross " +
                "chỉ huy được chính CIA nhờ tiêu diệt cựu điệp viên xấu Paine thì Ross đã biết nhiệm vụ lần này vô cùng nguy hiểm. " +
                "Anh đã có thể dừng lại nhưng sự ám ảnh về cô gái có bức vẽ tuyệt vời Sandra đã đẩy anh và nhóm đến một cuộc chiến " +
                "đầy cam go.");
        values.put("theloai", "hd");
        values.put("url", "https://www.youtube.com/watch?v=0qjxbz7cBmU");


        if(db.insert(TABLE_PHIM, null, values)!= -1){
            Toast.makeText(context, "Thêm thành công!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Thêm thất bại!", Toast.LENGTH_SHORT).show();
        }
        db.close();
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues values2 = new ContentValues();
        values2.put("maphim", "hd01");
        values2.put("nguoibinhluan", "User A");
        values2.put("noidung", "phim rất hay!!!");
        if(db2.insert(TABLE_BINHLUAN, null, values2)!= -1){
            Toast.makeText(context, "Thêm thành công!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Thêm thất bại!", Toast.LENGTH_SHORT).show();
        }
        db2.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE binhluan ("+
                "id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,"+
                "maphim TEXT, nguoibinhluan TEXT, noidung TEXT)";
        db.execSQL(sql);
        sql="CREATE TABLE phim (";
        sql+="id TEXT primary key,";
        sql+="tenphim TEXT,";
        sql+="daodien TEXT,";
        sql+="dienvien TEXT,";
        sql+="danhgia TEXT,";
        sql+="tomtat TEXT,";
        sql+="theloai TEXT,";
        sql+="url TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists" + TABLE_PHIM);
        db.execSQL("drop table if exists" + TABLE_BINHLUAN);
        onCreate(db);
    }
}
