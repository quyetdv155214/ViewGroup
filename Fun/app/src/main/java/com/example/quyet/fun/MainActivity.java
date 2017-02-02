package com.example.quyet.fun;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    private SeekBar sb_door;
    private View v_invisible;
    private EditText et_text;
    private Button bt_say;
    private TextView tv_roboTalk;
    int width;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gerReference();
        addListener();
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;


    }

    private void addListener() {
        sb_door.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                android.view.ViewGroup.LayoutParams layoutParams = v_invisible.getLayoutParams();
                layoutParams.width =width/sb_door.getMax() * i ;
                layoutParams.height = v_invisible.getHeight();
                v_invisible.setLayoutParams(layoutParams);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bt_say.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_roboTalk.setText(et_text.getText());
            }
        });
    }

    private void gerReference() {
        sb_door = (SeekBar) findViewById(R.id.sb_door);
        v_invisible = findViewById(R.id.v_invisible);
        bt_say= (Button) findViewById(R.id.bt_say);
        tv_roboTalk = (TextView) findViewById(R.id.tv_roboTalk);
        et_text = (EditText) findViewById(R.id.et_text);
    }
}
