package me.arulnadhan.flyrefresh;


public interface IPullHeader {
    void onPullProgress(PullHeaderLayout parent, int state, float progress);
}
