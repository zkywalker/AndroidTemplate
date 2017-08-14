package me.arulnadhan.androidultimate.Login;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import me.arulnadhan.androidultimate.R;

public class Login_anim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_anim);

        final LinearLayout LoginBox = (LinearLayout) findViewById(R.id.LoginBox);
        final Button submit = (Button) findViewById(R.id.submit);
        LoginBox.setVisibility(View.GONE);
        submit.setVisibility(View.GONE);

        final ImageView imgLogo = (ImageView) findViewById(R.id.logo);


        Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.translate);
        animTranslate.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                LoginBox.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                Animation animFade = AnimationUtils.loadAnimation(Login_anim.this, R.anim.fade);
                LoginBox.startAnimation(animFade);
                submit.startAnimation(animFade);

            }
        });
        imgLogo.startAnimation(animTranslate);
    }


    public void submit(View v) {
        Snackbar.make(v, "Submiting...", Snackbar.LENGTH_LONG).show();
    }
}


