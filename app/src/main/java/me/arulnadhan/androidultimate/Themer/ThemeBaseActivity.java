package me.arulnadhan.androidultimate.Themer;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.WindowManager;

import me.arulnadhan.androidultimate.R;

public class ThemeBaseActivity extends AppCompatActivity {

    private final static int THEME_BLUE = 0;
    private final static int THEME_RED = 1;
    private final static int THEME_GREEN = 2;
    private final static int THEME_CYAN = 3;
    private final static int THEME_PURPLE = 4;
    private final static int THEME_ORANGE = 5;
    private final static int THEME_PINK = 6;
    private final static int THEME_TEAL = 7;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateTheme();
    }

    public void updateTheme() {
        if (Utility.getTheme(getApplicationContext()) <= THEME_BLUE) {
            setTheme(R.style.AppTheme_Blue);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getPrimDark(this));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_RED) {
            setTheme(R.style.AppTheme_Red);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getPrimDark(this));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_GREEN) {
            setTheme(R.style.AppTheme_Green);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getPrimDark(this));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_CYAN) {
            setTheme(R.style.AppTheme_Cyan);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getPrimDark(this));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_PURPLE) {
            setTheme(R.style.AppTheme_Purple);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getPrimDark(this));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_ORANGE) {
            setTheme(R.style.AppTheme_Orange);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getPrimDark(this));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_PINK) {
            setTheme(R.style.AppTheme_Pink);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getPrimDark(this));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_TEAL) {
            setTheme(R.style.AppTheme_Teal);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getPrimDark(this));
            }
        }
    }

    public static int getAccentColor(final Context context) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorAccent, value, true);
        return value.data;
    }

    public static int getPrimDark(final Context context) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimaryDark, value, true);
        return value.data;
    }
}
