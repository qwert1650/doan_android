package com.hongoctuan.admin.ungdungxemphim.DTO;

/**
 * Created by admin on 5/3/2016.
 */
public class CommentDTO {
    String icon;
    String content;
    String nguoibinhluan;
    String mabinhluan;

    public String getCommentId() {
        return mabinhluan;
    }

    public void setCommentId(String mabinhluan) {
        this.mabinhluan = mabinhluan;
    }

    public String getCommenter() {
        return nguoibinhluan;
    }

    public void setCommenter(String nguoibinhluan) {
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
