package com.patel.parthivpatel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.content.ContextCompat;

import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Element adsElement = new Element();
        adsElement.setTitle("Advertise with Parthiv Patel");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Its Parthiv Patel Page")
                .setImage(R.drawable.patel)
                .addItem(new Element().setTitle("Version 6.2"))
                .addItem(adsElement)
                .addGroup("Connect with Parthiv Patel")
                .addEmail("parthiv89patel@gmail.com")
                .addWebsite("https://github.com/parthivpatel89")
                .addFacebook("parthivpatel89")
                .addTwitter("parthivpatel89")
                .addYoutube(" ")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addInstagram("parthivpatel89")
                .addGitHub("parthivpatel89")
                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
        //setContentView(R.layout.activity_about_page);
    }
    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        //copyRightsElement.setIcon(R.drawable.copy);
        copyRightsElement.setColor(ContextCompat.getColor(this, mehdi.sakout.aboutpage.R.color.about_item_icon_color));
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutUs.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }
}
