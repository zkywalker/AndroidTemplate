package me.arulnadhan.textsurface.interfaces;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface ITextEffect extends ITextSurfaceAnimation {
	void apply(Canvas canvas, String textValue, float x, float y, Paint paint);
}
