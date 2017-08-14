package me.arulnadhan.androidultimate.TextSurface.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import me.arulnadhan.androidultimate.R;
import me.arulnadhan.textsurface.Debug;
import me.arulnadhan.textsurface.Text;
import me.arulnadhan.textsurface.TextBuilder;
import me.arulnadhan.textsurface.TextSurface;
import me.arulnadhan.textsurface.animations.Alpha;
import me.arulnadhan.textsurface.animations.ChangeColor;
import me.arulnadhan.textsurface.contants.TYPE;

public class ColorText extends AppCompatActivity {

    private TextSurface textSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textsurface);
        textSurface = (TextSurface) findViewById(R.id.text_surface);

        textSurface.postDelayed(new Runnable() {
            @Override
            public void run() {
                show();
            }
        }, 1000);

        findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        CheckBox checkDebug = (CheckBox) findViewById(R.id.check_debug);
        checkDebug.setChecked(Debug.ENABLED);
        checkDebug.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Debug.ENABLED = isChecked;
                textSurface.invalidate();
            }
        });
    }

    private void show() {
        textSurface.reset();
        Text textA = TextBuilder
                .create("AndroiD:)")
                .setPosition(me.arulnadhan.textsurface.contants.Align.SURFACE_CENTER)
                .setSize(64)
                .setAlpha(0)
                .build();

        textSurface.play(TYPE.SEQUENTIAL,
                Alpha.show(textA, 1000),
                ChangeColor.to(textA, 1000, Color.RED),
                ChangeColor.fromTo(textA, 1000, Color.BLUE, Color.CYAN),
                Alpha.hide(textA, 1000)
        );
    }

}

