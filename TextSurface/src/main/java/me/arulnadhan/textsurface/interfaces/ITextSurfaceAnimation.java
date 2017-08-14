package me.arulnadhan.textsurface.interfaces;

import android.support.annotation.NonNull;

import me.arulnadhan.textsurface.Text;

public interface ITextSurfaceAnimation extends ISurfaceAnimation {

	void setInitValues(@NonNull Text text);

	Text getText();

}