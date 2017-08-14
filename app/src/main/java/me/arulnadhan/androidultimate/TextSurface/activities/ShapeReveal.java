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
import me.arulnadhan.textsurface.animations.Circle;
import me.arulnadhan.textsurface.animations.Delay;
import me.arulnadhan.textsurface.animations.Rotate3D;
import me.arulnadhan.textsurface.animations.SideCut;
import me.arulnadhan.textsurface.animations.Slide;
import me.arulnadhan.textsurface.animations.TransSurface;
import me.arulnadhan.textsurface.contants.Axis;
import me.arulnadhan.textsurface.contants.Direction;
import me.arulnadhan.textsurface.contants.Pivot;
import me.arulnadhan.textsurface.contants.Side;
import me.arulnadhan.textsurface.contants.TYPE;

public class ShapeReveal extends AppCompatActivity {

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
        Text textA = TextBuilder.create("Hey Guys,").setPosition(me.arulnadhan.textsurface.contants.Align.SURFACE_CENTER).setSize(28).build();
        Text textB = TextBuilder.create("How are you?").setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textA).setSize(28).build();
        Text textC = TextBuilder.create("Thanks for taking a look at ").setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textB).setSize(24).build();
        Text textD = TextBuilder.create("Android Ultimate").setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textC).setSize(28).build();

        final int flash = 1500;

        textSurface.play(TYPE.SEQUENTIAL,
                Rotate3D.showFromCenter(textA, 500, Direction.CLOCK, Axis.X),
                new AnimationsSet(TYPE.PARALLEL,
                        me.arulnadhan.textsurface.animations.ShapeReveal.create(textA, flash, SideCut.hide(Side.LEFT), false),
                        new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(flash / 4), me.arulnadhan.textsurface.animations.ShapeReveal.create(textA, flash, SideCut.show(Side.LEFT), false))
                ),
                new AnimationsSet(TYPE.PARALLEL,
                        Rotate3D.showFromSide(textB, 500, Pivot.TOP),
                        new TransSurface(500, textB, Pivot.CENTER)
                ),
                Delay.duration(500),
                new AnimationsSet(TYPE.PARALLEL,
                        Slide.showFrom(Side.TOP, textC, 500),
                        new TransSurface(1000, textC, Pivot.CENTER)
                ),
                Delay.duration(500),
                new AnimationsSet(TYPE.PARALLEL,
                        me.arulnadhan.textsurface.animations.ShapeReveal.create(textD, 500, Circle.show(Side.CENTER, Direction.OUT), false),
                        new TransSurface(1500, textD, Pivot.CENTER)
                ),
                Delay.duration(500),
                new AnimationsSet(TYPE.PARALLEL,
                        new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textD, 700), me.arulnadhan.textsurface.animations.ShapeReveal.create(textD, 1000, SideCut.hide(Side.LEFT), true)),
                        new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textC, 700), me.arulnadhan.textsurface.animations.ShapeReveal.create(textC, 1000, SideCut.hide(Side.LEFT), true))),
                        new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(1000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textB, 700), me.arulnadhan.textsurface.animations.ShapeReveal.create(textB, 1000, SideCut.hide(Side.LEFT), true))),
                        new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(1500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textA, 700), me.arulnadhan.textsurface.animations.ShapeReveal.create(textA, 1000, SideCut.hide(Side.LEFT), true))),
                        new TransSurface(4000, textA, Pivot.CENTER)
                )

        );
    }

}

