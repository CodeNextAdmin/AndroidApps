package com.example.sickbeetz;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button dBtn;
    private Button cBtn;
    private Button hBtn;
    private MediaPlayer mpD;
    private MediaPlayer mpC;
    private MediaPlayer mpH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dBtn = (Button)this.findViewById(R.id.drumsBtn);
        cBtn = (Button)this.findViewById(R.id.cymbalBtn);
        hBtn = (Button)this.findViewById(R.id.hatBtn);
        final MediaPlayer mpD = MediaPlayer.create(this, R.raw.drums);


        dBtn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                mpD.start();
            }
        });


    }
}
