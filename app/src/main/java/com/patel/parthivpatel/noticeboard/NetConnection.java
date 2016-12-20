package com.patel.parthivpatel.noticeboard;

/**
 * Created by SNET1 on 08-Nov-16.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetConnection extends Activity {


    private SharedPreferences prefs;
    private String prefName = "report";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            prefs = getSharedPreferences(prefName, MODE_PRIVATE);
            String net_ip=prefs.getString("ip", "http://192.168.0.23/cnb/");
            net_ip = prefs.getString("ip", "http://test.wooshopee.com/DB_CNB_Frame.php");

            URL url = new URL(net_ip);
            executeReq(url);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("connection", 1);
            editor.commit();

            finish();
            startActivity(new Intent(NetConnection.this,CNB_Login.class));
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), " "+e.toString(), Toast.LENGTH_LONG).show();

            Toast.makeText(getApplicationContext(), "Check Network Connection " +
                    "and IP Address ", Toast.LENGTH_LONG).show();

            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("connection", 0);
            editor.commit();

            finish();
            startActivity(new Intent(NetConnection.this,CNB_Login.class));
        }
    }

    public void executeReq(URL urlObject) throws IOException {

        HttpURLConnection conn = null;
        conn = (HttpURLConnection) urlObject.openConnection();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        conn.setReadTimeout(30000);//milliseconds
        conn.setConnectTimeout(3500);//milliseconds
        conn.setRequestMethod("GET");
        conn.setDoInput(true);

        // Start connect
        conn.connect();
        InputStream response =conn.getInputStream();
        Log.d("Response:", response.toString());
        System.out.println(""+response.toString());
    }
}

