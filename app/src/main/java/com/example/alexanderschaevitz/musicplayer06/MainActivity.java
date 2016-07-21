package com.example.alexanderschaevitz.musicplayer06;

import android.media.MediaPlayer;
import android.media.audiofx.PresetReverb;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.audiofx.AudioEffect;
import android.widget.RadioButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = (Button) findViewById(R.id.button_play);
        Button pause = (Button) findViewById(R.id.button_pause);
        Button stop = (Button) findViewById(R.id.button_stop);

        Switch reverbSwitch = (Switch) findViewById(R.id.reverbSwitch);
        boolean reverbBool = true;

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.lightsdownlow);

        mp.start();

        PresetReverb mReverb = new PresetReverb(0,mp.getAudioSessionId());//<<<<<<<<<<<<<
        mReverb.setPreset(PresetReverb.PRESET_LARGEROOM);
        mReverb.setEnabled(true);
        mp.setAuxEffectSendLevel(1.0f);
        //mp.prepare();


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
            }
        });


    }

    public void reverbOn(View view){

    }
}
