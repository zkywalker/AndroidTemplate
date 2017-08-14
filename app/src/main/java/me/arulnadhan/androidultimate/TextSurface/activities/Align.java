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
import me.arulnadhan.textsurface.contants.TYPE;

public class Align extends AppCompatActivity {

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
        Text textCenter = TextBuilder.create("Center")
                .setPosition(me.arulnadhan.textsurface.contants.Align.SURFACE_CENTER)
                .setPadding(25, 25, 25, 25)
                .build();

        Text textLeft = TextBuilder.create("L")
                .setPadding(20, 20, 20, 20)
                .setPosition(me.arulnadhan.textsurface.contants.Align.LEFT_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textCenter)
                .build();

        Text textRight = TextBuilder.create("R")
                .setPadding(20, 20, 20, 20)
                .setPosition(me.arulnadhan.textsurface.contants.Align.RIGHT_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textCenter)
                .build();

        Text textTop = TextBuilder.create("T")
                .setPosition(me.arulnadhan.textsurface.contants.Align.TOP_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textCenter)
                .build();

        Text textBottom = TextBuilder.create("B")
                .setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textCenter)
                .build();

        //

        Text textBottomBottom = TextBuilder.create("BB")
                .setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.CENTER_OF, textBottom)
                .build();

        //

        Text textLeftTop = TextBuilder.create("LT")
                .setPosition(me.arulnadhan.textsurface.contants.Align.LEFT_OF | me.arulnadhan.textsurface.contants.Align.TOP_OF, textCenter)
                .build();

        Text textRightTop = TextBuilder.create("RT")
                .setPosition(me.arulnadhan.textsurface.contants.Align.RIGHT_OF | me.arulnadhan.textsurface.contants.Align.TOP_OF, textCenter)
                .build();

        Text textLeftBottom = TextBuilder.create("LB")
                .setPosition(me.arulnadhan.textsurface.contants.Align.LEFT_OF | me.arulnadhan.textsurface.contants.Align.BOTTOM_OF, textCenter)
                .build();

        Text textRightBottom = TextBuilder.create("RB")
                .setPosition(me.arulnadhan.textsurface.contants.Align.BOTTOM_OF | me.arulnadhan.textsurface.contants.Align.RIGHT_OF, textCenter)
                .build();

        final int duration = 125;

        textSurface.play(TYPE.SEQUENTIAL,
                Alpha.show(textCenter, duration),
                Alpha.show(textRight, duration),
                Alpha.show(textTop, duration),
                Alpha.show(textLeft, duration),
                Alpha.show(textBottom, duration),

                Alpha.show(textLeftTop, duration),
                Alpha.show(textLeftBottom, duration),
                Alpha.show(textRightBottom, duration),
                Alpha.show(textRightTop, duration),

                Alpha.show(textBottomBottom, duration)
        );
    }

}

