package me.arulnadhan.androidultimate.TextSurface.activities;


import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
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
import me.arulnadhan.textsurface.animations.Circle;
import me.arulnadhan.textsurface.animations.Delay;
import me.arulnadhan.textsurface.animations.Parallel;
import me.arulnadhan.textsurface.animations.Rotate3D;
import me.arulnadhan.textsurface.animations.Sequential;
import me.arulnadhan.textsurface.animations.SideCut;
import me.arulnadhan.textsurface.animations.Slide;
import me.arulnadhan.textsurface.animations.TransSurface;
import me.arulnadhan.textsurface.contants.Direction;
import me.arulnadhan.textsurface.contants.Pivot;
import me.arulnadhan.textsurface.contants.Side;

public class CookieThumper extends AppCompatActivity {

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
        final Typeface robotoBlack = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Black.ttf");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTypeface(robotoBlack);

        Text textDaai = TextBuilder
                .create("Hello!")
                .setPaint(paint)
                .setSize(64)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(me.arulnadhan.textsurface.contants.Align.SURFACE_CENTER).build();

        Text textBraAnies = TextBuilder
                .create("Welcome")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF, textDaai).build();

        Text textFokkenGamBra = TextBuilder
                .create(" to")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(me.arulnadhan.textsurface.contants.Align.RIGHT_OF, textBraAnies).build();

        Text textHaai = TextBuilder
                .create("the")
                .setPaint(paint)
                .setSize(74)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF, textFokkenGamBra).build();

        Text textDaaiAnies = TextBuilder
                .create("Awesome")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textHaai).build();

        Text texThyLamInnie = TextBuilder
                .create(" Template")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(me.arulnadhan.textsurface.contants.Align.RIGHT_OF, textDaaiAnies).build();

        Text textThrowDamn = TextBuilder
                .create("Android ")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, texThyLamInnie).build();

        Text textDevilishGang = TextBuilder
                .create("Ultimate...!")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textThrowDamn).build();

        Text textSignsInTheAir = TextBuilder
                .create(":)")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textDevilishGang).build();

        textSurface.play(
                new Sequential(
                        me.arulnadhan.textsurface.animations.ShapeReveal.create(textDaai, 750, SideCut.show(Side.LEFT), false),
                        new Parallel(me.arulnadhan.textsurface.animations.ShapeReveal.create(textDaai, 600, SideCut.hide(Side.LEFT), false), new Sequential(Delay.duration(300), me.arulnadhan.textsurface.animations.ShapeReveal.create(textDaai, 600, SideCut.show(Side.LEFT), false))),
                        new Parallel(new TransSurface(500, textBraAnies, Pivot.CENTER), me.arulnadhan.textsurface.animations.ShapeReveal.create(textBraAnies, 1300, SideCut.show(Side.LEFT), false)),
                        Delay.duration(500),
                        new Parallel(new TransSurface(750, textFokkenGamBra, Pivot.CENTER), Slide.showFrom(Side.LEFT, textFokkenGamBra, 750), ChangeColor.to(textFokkenGamBra, 750, Color.WHITE)),
                        Delay.duration(500),
                        new Parallel(TransSurface.toCenter(textHaai, 500), Rotate3D.showFromSide(textHaai, 750, Pivot.TOP)),
                        new Parallel(TransSurface.toCenter(textDaaiAnies, 500), Slide.showFrom(Side.TOP, textDaaiAnies, 500)),
                        new Parallel(TransSurface.toCenter(texThyLamInnie, 750), Slide.showFrom(Side.LEFT, texThyLamInnie, 500)),
                        Delay.duration(500),
                        new Parallel(
                                new TransSurface(1500, textSignsInTheAir, Pivot.CENTER),
                                new Sequential(
                                        new Sequential(me.arulnadhan.textsurface.animations.ShapeReveal.create(textThrowDamn, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
                                        new Sequential(me.arulnadhan.textsurface.animations.ShapeReveal.create(textDevilishGang, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
                                        new Sequential(me.arulnadhan.textsurface.animations.ShapeReveal.create(textSignsInTheAir, 500, Circle.show(Side.CENTER, Direction.OUT), false))
                                )
                        ),
                        Delay.duration(200),
                        new Parallel(
                                me.arulnadhan.textsurface.animations.ShapeReveal.create(textThrowDamn, 1500, SideCut.hide(Side.LEFT), true),
                                new Sequential(Delay.duration(250), me.arulnadhan.textsurface.animations.ShapeReveal.create(textDevilishGang, 1500, SideCut.hide(Side.LEFT), true)),
                                new Sequential(Delay.duration(500), me.arulnadhan.textsurface.animations.ShapeReveal.create(textSignsInTheAir, 1500, SideCut.hide(Side.LEFT), true)),
                                Alpha.hide(texThyLamInnie, 1500),
                                Alpha.hide(textDaaiAnies, 1500)
                        )
                )
        );

    }

}
