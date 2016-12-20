package com.patel.parthivpatel.noticeboard;

/**
 * Created by SNET1 on 08-Nov-16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.patel.parthivpatel.R;

public class SampleCodez extends AppCompatActivity
{

    protected boolean active = true;
    protected int splashTime = 5000;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samplecodez);

        Thread splashTread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    int waited = 0;

                    while(active && (waited < splashTime))
                    {
                        sleep(40);
                        if(active)
                        {
                            waited += 100;
                        }
                    }
                }
                catch(InterruptedException e)
                {
                    // do nothing
                } finally
                {
                    finish();
                    startActivity(new Intent(SampleCodez.this,NetConnection.class));
                }
            }
        };
        splashTread.start();
    }
}