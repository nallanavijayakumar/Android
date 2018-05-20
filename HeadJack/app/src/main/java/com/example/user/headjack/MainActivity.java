package com.example.user.headjack;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnCheck;
    AudioManager am, audioManager;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        textView = (TextView)findViewById(R.id.textview1);
        btnCheck = (Button)findViewById(R.id.button1);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                useEarpiece();
                handleHeadphonesState(v.getContext());
            }
        });


    }
    public void handleHeadphonesState(Context context){
        AudioManager am = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);

        if(am.isSpeakerphoneOn()) {
            textView.setText("SpeacketPhone is ON");
        } else{
            textView.setText("SpeacketPhone is OFF");
        }
    }


    private void useEarpiece() {
        //audioManager.setMode(AudioManager.MODE_NORMAL);
        audioManager.setSpeakerphoneOn(true);

    }

}
