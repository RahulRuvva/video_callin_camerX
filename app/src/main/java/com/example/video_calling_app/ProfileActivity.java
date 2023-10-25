package com.example.video_calling_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class ProfileActivity extends AppCompatActivity {

    EditText targetuser;
    Button logout;
    TextView caller;

    ZegoSendCallInvitationButton callbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        targetuser = findViewById(R.id.usertext);
        logout = findViewById(R.id.logout);
        caller = findViewById(R.id.username);
        callbtn = findViewById(R.id.callbtn);

        caller.setText(getIntent().getStringExtra("caller"));

        caller.setText("You are: " + getIntent().getStringExtra("caller"));

        targetuser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                startvideoCall(targetuser.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void startvideoCall( String targetuserid)
    {
        callbtn.setIsVideoCall(true);
        callbtn.setResourceID("zego_uikit_call");
        callbtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetuserid,targetuserid)));
    }
}