package com.patel.parthivpatel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {



    Button buttonSend;
    EditText textTo;
    EditText textSubject;
    EditText textMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("E-mail");

        buttonSend = (Button) findViewById(R.id.submit);
        textTo = (EditText) findViewById(R.id.edtto);
        textSubject = (EditText) findViewById(R.id.edtsubject);
        textMessage = (EditText) findViewById(R.id.edtmessage);
        textTo.setText("ppa89patel@gmail.com");

        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String to = textTo.getText().toString();
                String subject = textSubject.getText().toString();
                String message = textMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }
}