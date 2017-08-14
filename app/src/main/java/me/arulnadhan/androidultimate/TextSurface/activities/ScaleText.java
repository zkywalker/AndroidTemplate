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
import me.arulnadhan.textsurface.animations.Delay;
import me.arulnadhan.textsurface.animations.Parallel;
import me.arulnadhan.textsurface.animations.Scale;
import me.arulnadhan.textsurface.animations.Sequential;
import me.arulnadhan.textsurface.contants.Pivot;
import me.arulnadhan.textsurface.contants.TYPE;

public class ScaleText extends AppCompatActivity {

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

        Text textA = TextBuilder.create("textA")
                .build();

        Text textB = TextBuilder.create("textB")
                .setPosition(me.arulnadhan.textsurface.contants.Align.LEFT_OF, textA)
                .build();

        Text textC = TextBuilder.create("textC")
                .setPosition(me.arulnadhan.textsurface.contants.Align.RIGHT_OF, textA)
                .build();

        Text textD = TextBuilder.create("textD")
                .setPosition(me.arulnadhan.textsurface.contants.Align.LEFT_OF, textB)
                .build();

        textSurface.play(TYPE.PARALLEL,
                new Sequential(new Scale(textA, 1000, 1, 2, Pivot.CENTER), new Scale(textA, 1000, 2, 1, Pivot.CENTER)),
                new Sequential(Delay.duration(250), new Parallel(new Scale(textB, 500, 1.5f, 1f, Pivot.LEFT), new Scale(textB, 500, 1, 1.5f, Pivot.LEFT))),
                new Sequential(Delay.duration(500), new Parallel(new Scale(textC, 500, 1.5f, 1f, Pivot.LEFT), new Scale(textC, 500, 1, 1.5f, Pivot.LEFT))),
                new Sequential(Delay.duration(750), new Parallel(new Scale(textD, 500, 1.5f, 1f, Pivot.LEFT), new Scale(textD, 500, 1, 1.5f, Pivot.LEFT)))
        );
    }

}

