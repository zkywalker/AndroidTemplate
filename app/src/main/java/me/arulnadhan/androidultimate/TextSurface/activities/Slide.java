package me.arulnadhan.androidultimate.TextSurface.activities;


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
import me.arulnadhan.textsurface.animations.AnimationsSet;
import me.arulnadhan.textsurface.animations.TransSurface;
import me.arulnadhan.textsurface.contants.*;

public class Slide extends AppCompatActivity {

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
        Text textA = TextBuilder.create(" How are you?").build();
        Text textB = TextBuilder.create("I'm fine! ").setPosition(me.arulnadhan.textsurface.contants.Align.LEFT_OF, textA).setSize(24).build();
        Text textC = TextBuilder.create("Are you sure?").setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textB).setSize(24).build();
        Text textD = TextBuilder.create("Totally!").setPadding(10, 10, 10, 10).setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textC).setSize(24).build();
        int duration = 1350;

        textSurface.play(
                TYPE.SEQUENTIAL,
                new AnimationsSet(TYPE.PARALLEL,
                        new AnimationsSet(TYPE.SEQUENTIAL,
                                new AnimationsSet(TYPE.PARALLEL, me.arulnadhan.textsurface.animations.Slide.showFrom(Side.LEFT, textA, duration), me.arulnadhan.textsurface.animations.Slide.showFrom(Side.RIGHT, textB, duration)),
                                me.arulnadhan.textsurface.animations.Slide.showFrom(Side.TOP, textC, duration),
                                me.arulnadhan.textsurface.animations.Slide.showFrom(Side.BOTTOM, textD, duration)
                        ),
                        new TransSurface(duration * 3, textD, Pivot.CENTER)
                ),
                new AnimationsSet(TYPE.PARALLEL,
                        new AnimationsSet(TYPE.SEQUENTIAL,
                                new AnimationsSet(TYPE.PARALLEL, me.arulnadhan.textsurface.animations.Slide.hideFrom(Side.LEFT, textD, duration), me.arulnadhan.textsurface.animations.Slide.hideFrom(Side.RIGHT, textC, duration)),
                                me.arulnadhan.textsurface.animations.Slide.hideFrom(Side.TOP, textB, duration),
                                me.arulnadhan.textsurface.animations.Slide.hideFrom(Side.BOTTOM, textA, duration)
                        ),
                        new TransSurface(duration * 3, textA, Pivot.CENTER)
                )

        );
    }
}

