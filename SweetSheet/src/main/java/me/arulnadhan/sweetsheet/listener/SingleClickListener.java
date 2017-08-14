package me.arulnadhan.sweetsheet.listener;

import android.view.View;


public class SingleClickListener implements View.OnClickListener {

    private View.OnClickListener mListener;

    private SingleClickHelper singleClickhelper =new SingleClickHelper();

    public SingleClickListener(View.OnClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onClick(View v) {

        if (singleClickhelper.clickEnable()) {
            if(mListener != null) {
                mListener.onClick(v);
            }
        }

    }


}
