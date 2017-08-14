package me.arulnadhan.textsurface.interfaces;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import me.arulnadhan.textsurface.TextSurface;

public interface ISurfaceAnimation {

	void onStart();

	void start(@Nullable IEndListener listener);

	void setTextSurface(@NonNull TextSurface textSurface);

	long getDuration();
}
