package me.arulnadhan.androidultimate.Fab.FabProgress.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import me.arulnadhan.androidultimate.R;

public class RobotoTextView extends TextView {

    private String basePath = "typeface/";

    public RobotoTextView(Context context) {
        super(context);
        init(null);
    }

    public RobotoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RobotoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        int typeFaceNumber = 0;
        if (attrs != null) {
            TypedArray a =
                    getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.RobotoTextView, 0, 0);

            try {
                typeFaceNumber = a.getInteger(R.styleable.RobotoTextView_typeface, 0);
            } finally {
                a.recycle();
            }
        }

        setTypeface(typeFaceNumber);
    }

    public void setType(int typefaceNumber) {
        setTypeface(typefaceNumber);
    }

    private void setTypeface(int typeFaceNumber) {
        Typeface typeface =
                Typeface.createFromAsset(getResources().getAssets(), getPathForTypeface(typeFaceNumber));
        setTypeface(typeface);
    }

    private String getPathForTypeface(int typeFaceNumber) {
        switch (typeFaceNumber) {
            case 0:
                return basePath + "Roboto-Regular.ttf";
            default:
                return basePath + "Roboto-Medium.ttf";
        }
    }
}
