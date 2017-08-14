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
import me.arulnadhan.textsurface.animations.Rotate3D;
import me.arulnadhan.textsurface.contants.Axis;
import me.arulnadhan.textsurface.contants.Direction;
import me.arulnadhan.textsurface.contants.Pivot;
import me.arulnadhan.textsurface.contants.TYPE;

public class Rotation3D extends AppCompatActivity {

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
        Text textA = TextBuilder.create("How are you?").setPosition(me.arulnadhan.textsurface.contants.Align.SURFACE_CENTER).setSize(48).build();
        Text textB = TextBuilder.create("I'm fine! And you?").setPosition(me.arulnadhan.textsurface.contants.Align.SURFACE_CENTER, textA).setSize(42).build();
        Text textC = TextBuilder.create("Thank You!").setPosition(me.arulnadhan.textsurface.contants.Align.SURFACE_CENTER, textB).setSize(48).build();
        int duration = 1250;

        textSurface.play(TYPE.SEQUENTIAL,
                new AnimationsSet(TYPE.SEQUENTIAL,
                        Rotate3D.showFromCenter(textA, duration, Direction.CLOCK, Axis.X),
                        Rotate3D.hideFromCenter(textA, duration, Direction.CLOCK, Axis.Y)
                ),
                new AnimationsSet(TYPE.SEQUENTIAL,
                        Rotate3D.showFromSide(textB, duration, Pivot.LEFT),
                        Rotate3D.hideFromSide(textB, duration, Pivot.RIGHT)
                ),
                new AnimationsSet(TYPE.SEQUENTIAL,
                        Rotate3D.showFromSide(textC, duration, Pivot.TOP),
                        Rotate3D.hideFromSide(textC, duration, Pivot.BOTTOM)
                )
        );
    }

}

