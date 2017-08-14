package me.arulnadhan.androidultimate.Login;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.arulnadhan.androidultimate.R;

public class Login_material extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_material);
    }

    public void submit(View v) {
        Snackbar.make(v, "Submiting...", Snackbar.LENGTH_LONG).show();
    }

}
