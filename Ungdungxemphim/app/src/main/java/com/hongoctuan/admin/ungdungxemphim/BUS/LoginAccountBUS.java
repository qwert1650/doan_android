package com.hongoctuan.admin.ungdungxemphim.BUS;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.hongoctuan.admin.ungdungxemphim.R;
import com.hongoctuan.admin.ungdungxemphim.View.loginLayout;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by admin on 4/29/2016.
 */
public class LoginAccountBUS extends AsyncTask<String, Void, String> {
    Activity context;

    public LoginAccountBUS(Activity context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://restfullapiservice.somee.com/api/logginAccount");
        httpPost.setHeader("content-type", "application/json");
        JSONObject data = new JSONObject();
        try {
            data.put("name",params[0]);
            data.put("pass",params[1]);
            StringEntity entity = null;
            entity = new StringEntity(data.toString(), HTTP.UTF_8);
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String result = "";
            return result = bufferedReader.readLine();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s.equals("null")) {
            TextView txtNotification = (TextView) context.findViewById(R.id.txtNotification);
            txtNotification.setText("Tên đăng nhập, mật khẩu không chính xác!");
        }
        else{
            String name = "";
            try {
                JSONObject jsonUser = new JSONObject(s);
                name = jsonUser.getString("name");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            loginLayout loginlayout = new loginLayout(context);
            loginlayout.removeloginAccount();
            loginlayout.updateLayout(name);
        }
    }
}
