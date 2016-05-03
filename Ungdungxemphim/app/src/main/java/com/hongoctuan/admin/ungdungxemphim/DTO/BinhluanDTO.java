package com.hongoctuan.admin.ungdungxemphim.DTO;

/**
 * Created by admin on 5/3/2016.
 */
public class BinhluanDTO {
    String icon;
    String content;
    String nguoibinhluan;
    String mabinhluan;

    public String getMabinhluan() {
        return mabinhluan;
    }

    public void setMabinhluan(String mabinhluan) {
        this.mabinhluan = mabinhluan;
    }

    public String getNguoibinhluan() {
        return nguoibinhluan;
    }

    public void setNguoibinhluan(String nguoibinhluan) {
        this.nguoibinhluan = nguoibinhluan;
    }



    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
