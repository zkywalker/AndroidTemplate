package me.arulnadhan.sweetsheet.listener;

import android.os.SystemClock;

public  class SingleClickHelper {

    private static long L_CLICK_INTERVAL = 400;
    private long preClickTime;


    public boolean clickEnable(){
        long clickTime= SystemClock.elapsedRealtime();
        if ( clickTime - preClickTime > L_CLICK_INTERVAL){
            preClickTime=clickTime;
            return true;
        }
        return false;
    }
}
