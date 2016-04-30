package com.hongoctuan.admin.ungdungxemphim.View;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongoctuan.admin.ungdungxemphim.BUS.LoginAccountBUS;
import com.hongoctuan.admin.ungdungxemphim.R;

/**
 * Created by admin on 4/30/2016.
 */
public class loginLayout {

    Activity context;
    public loginLayout(Activity context) {
        this.context = context;
    }

    public void dangxuatAccoutnLayout(){
        ImageView ivIcon = new ImageView(context);
        LinearLayout ll = (LinearLayout)context.findViewById(R.id.line_loginlayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ivIcon.setImageResource(R.drawable.ic_home);
        ll.addView(ivIcon, lp);
        //them textview ten dang nhap
        TextView txtTendangnhap = new TextView(context);
        txtTendangnhap.setText("noi dung");
        ll.addView(txtTendangnhap, lp);
        //them button dang xuat
        Button btnLogout = new Button(context);
        btnLogout.setText("Nhap");
        ll.addView(btnLogout, lp);
    }

    public void updateloginAccout(){
        LinearLayout ll = (LinearLayout)context.findViewById(R.id.line_loginlayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ImageView ivLogin= new ImageView(context);
        //them imageview  icon login
        ivLogin.setImageResource(R.drawable.login);
        ivLogin.setId(R.id.iv_login);
        ll.addView(ivLogin, lp);
        //them textview thong bao
        TextView txtNotification= new TextView(context);
        txtNotification.setId(R.id.txtNotification);
        txtNotification.setText("");
        ll.addView(txtNotification, lp);
        //them textview ten dang nhap
        TextView txtTendangnhap= new TextView(context);
        txtTendangnhap.setText("Tên Đăng Nhập:");
        txtTendangnhap.setId(R.id.txt_tendangnhap);
        ll.addView(txtTendangnhap, lp);
        //them textview mat khau
        TextView txtMatkhau= new TextView(context);
        txtMatkhau.setText("Mật Khẩu:");
        txtMatkhau.setId(R.id.txt_matkhau);
        ll.addView(txtMatkhau, lp);
        //them edittext ten dang nhap
        final EditText editTendangnhap=new EditText(context);
        editTendangnhap.setHint("Nhập Tên Đăng Nhập");
        editTendangnhap.setId(R.id.eidt_tendangnhap);
        ll.addView(editTendangnhap, lp);
        //them edittext mat khau
        final EditText editMatkhau = new EditText(context);
        editMatkhau.setHint("Nhập Mật Khẩu");
        editMatkhau.setId(R.id.edit_matkhau);
        ll.addView(editMatkhau, lp);
        //them button login
        Button btnLogin =  new Button(context);
        btnLogin.setText("Đăng Nhập");
        btnLogin.setId(R.id.btn_login);
        ll.addView(btnLogin, lp);
        //them button login facebook
        Button btnLoginfacebook = new Button(context);
        btnLoginfacebook.setText("Đăng Nhập Facebook");
        btnLoginfacebook.setId(R.id.btn_loginfacebook);
        ll.addView(btnLoginfacebook, lp);
        //them textview quen mat khau
        TextView txtQuenmatkhau= new TextView(context);
        txtQuenmatkhau.setText("Quên Mật Khẩu");
        txtQuenmatkhau.setId(R.id.txt_quenmatkhau);
        ll.addView(txtQuenmatkhau, lp);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAccount(editTendangnhap.getText().toString(),editMatkhau.getText().toString());
            }
        });
    }

    public void removeloginAccount(){
        //xoa button login
        Button btnLogin = (Button) context.findViewById(R.id.btn_login);
        ViewGroup btnLoginlayout = (ViewGroup)btnLogin.getParent();
        if(null!=btnLoginlayout) //for safety only  as you are doing onClick
            btnLoginlayout.removeView(btnLogin);
        //xoa imageview login
        ImageView ivLogin= (ImageView) context.findViewById(R.id.iv_login);
        ViewGroup ivLoginlayout = (ViewGroup)ivLogin.getParent();
        if(null!=ivLoginlayout) //for safety only  as you are doing onClick
            ivLoginlayout.removeView(ivLogin);
        //xoa textview notification
        TextView txtNotification= (TextView) context.findViewById(R.id.txtNotification);
        ViewGroup txtNotificationlayout = (ViewGroup)txtNotification.getParent();
        if(null!= txtNotificationlayout) //for safety only  as you are doing onClick
            txtNotificationlayout.removeView(txtNotification);
        //xoa textview name
        TextView txtTendangnhap = (TextView) context.findViewById(R.id.txt_tendangnhap);
        ViewGroup txtTendangnhaplayout = (ViewGroup)txtTendangnhap.getParent();
        if(null!= txtTendangnhaplayout) //for safety only  as you are doing onClick
            txtTendangnhaplayout.removeView(txtTendangnhap);
        //xoa textview pass
        TextView txtMatkhau = (TextView) context.findViewById(R.id.txt_matkhau);
        ViewGroup txtMatkhaulayout = (ViewGroup)txtMatkhau.getParent();
        if(null!= txtTendangnhaplayout) //for safety only  as you are doing onClick
            txtMatkhaulayout.removeView(txtMatkhau);
        //xoa edittext name
        EditText editTendangnhap = (EditText) context.findViewById(R.id.eidt_tendangnhap);
        ViewGroup editTendangnhaplayout = (ViewGroup)editTendangnhap.getParent();
        if(null!= editTendangnhaplayout) //for safety only  as you are doing onClick
            editTendangnhaplayout.removeView(editTendangnhap);
        //xoa edittext pass
        EditText editMatkhau = (EditText) context.findViewById(R.id.edit_matkhau);
        ViewGroup editMatkhaulayout = (ViewGroup)editMatkhau.getParent();
        if(null!= editMatkhaulayout) //for safety only  as you are doing onClick
            editMatkhaulayout.removeView(editMatkhau);
        //xoa login facebook
        Button btnLoginfacebook = (Button) context.findViewById(R.id.btn_loginfacebook);
        ViewGroup btnLoginfacebooklayout = (ViewGroup)btnLoginfacebook.getParent();
        if(null!= btnLoginfacebooklayout) //for safety only  as you are doing onClick
            btnLoginfacebooklayout.removeView(btnLoginfacebook);
        //xoa textview quen mat khau
        TextView txtQuenmatkhau = (TextView) context.findViewById(R.id.txt_quenmatkhau);
        ViewGroup txtQuenmatkhaulayout = (ViewGroup)txtQuenmatkhau.getParent();
        if(null!= txtQuenmatkhaulayout) //for safety only  as you are doing onClick
            txtQuenmatkhaulayout.removeView(txtQuenmatkhau);
    }
    private void loginAccount(String name, String pass){
        LoginAccountBUS loginAccount_bus = new LoginAccountBUS(context);
        loginAccount_bus.execute(name, pass);
    }
}
