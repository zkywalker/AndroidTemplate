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
import me.arulnadhan.textsurface.animations.Delay;
import me.arulnadhan.textsurface.animations.ScaleSurface;
import me.arulnadhan.textsurface.contants.*;

public class SurfaceScale extends AppCompatActivity {

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
        Text textA = TextBuilder.create("Android Ultimate").setPosition(me.arulnadhan.textsurface.contants.Align.SURFACE_CENTER).build();
        Text textB = TextBuilder.create("Would you buy iT?").setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textA).build();
        Text textC = TextBuilder.create("Yes!").setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textB).build();


        textSurface.play(TYPE.SEQUENTIAL,
                Alpha.show(textA, 500),
                new AnimationsSet(TYPE.PARALLEL,
                        new AnimationsSet(TYPE.PARALLEL, Alpha.show(textB, 500), Alpha.hide(textA, 500)),
                        new ScaleSurface(500, textB, Fit.WIDTH)
                ),
                Delay.duration(1000),
                new AnimationsSet(TYPE.PARALLEL,
                        new AnimationsSet(TYPE.PARALLEL, Alpha.show(textC, 500), Alpha.hide(textB, 500)),
                        new ScaleSurface(500, textC, Fit.WIDTH)
                )
        );
    }
}

