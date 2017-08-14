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
import me.arulnadhan.textsurface.animations.Alpha;
import me.arulnadhan.textsurface.animations.AnimationsSet;
import me.arulnadhan.textsurface.animations.TransSurface;
import me.arulnadhan.textsurface.contants.*;

public class SurfaceTrans extends AppCompatActivity {

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
        Text textA = TextBuilder.create("Zig").setPosition(me.arulnadhan.textsurface.contants.Align.SURFACE_CENTER).setSize(32).build();
        Text textB = TextBuilder.create("Zag").setPosition(me.arulnadhan.textsurface.contants.Align.RIGHT_OF | me.arulnadhan.textsurface.contants.Align.BOTTOM_OF, textA).setSize(32).build();
        Text textC = TextBuilder.create("Ziig").setPosition(me.arulnadhan.textsurface.contants.Align.LEFT_OF | me.arulnadhan.textsurface.contants.Align.BOTTOM_OF, textB).setSize(32).build();
        Text textD = TextBuilder.create("Zaag").setPosition(me.arulnadhan.textsurface.contants.Align.RIGHT_OF | me.arulnadhan.textsurface.contants.Align.BOTTOM_OF, textC).setSize(32).build();

        int duration = 500;

        textSurface.play(TYPE.SEQUENTIAL,
                Alpha.show(textA, duration),
                new AnimationsSet(TYPE.PARALLEL, Alpha.show(textB, duration), new TransSurface(duration, textB, Pivot.CENTER)),
                new AnimationsSet(TYPE.PARALLEL, Alpha.show(textC, duration), new TransSurface(duration, textC, Pivot.CENTER)),
                new AnimationsSet(TYPE.PARALLEL, Alpha.show(textD, duration), new TransSurface(duration, textD, Pivot.CENTER)),
                new TransSurface(duration, textC, Pivot.CENTER),
                new TransSurface(duration, textB, Pivot.CENTER),
                new TransSurface(duration, textA, Pivot.CENTER)
        );
    }
}

