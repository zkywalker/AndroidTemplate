package me.arulnadhan.textsurface.animations;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import me.arulnadhan.textsurface.Text;
import me.arulnadhan.textsurface.TextSurface;
import me.arulnadhan.textsurface.utils.Utils;
import me.arulnadhan.textsurface.interfaces.IEndListener;
import me.arulnadhan.textsurface.interfaces.ITextSurfaceAnimation;

public class Scale implements ITextSurfaceAnimation, ValueAnimator.AnimatorUpdateListener {

	private int duration;
	private final float from;
	private final float to;
	private final int pivot;
	private Text text;
	private TextSurface textSurface;

	public Scale(Text text, int duration, float from, float to, int pivot) {
		this.text = text;
		this.duration = duration;
		this.from = from;
		this.to = to;
		this.pivot = pivot;
	}

	@Override public void setInitValues(@NonNull Text text) {

	}

	@NonNull @Override public Text getText() {
		return text;
	}

	@Override public void onStart() {

	}

	@Override public void start(@Nullable IEndListener listener) {
		text.setScalePivot(pivot, pivot);
		PropertyValuesHolder sX = PropertyValuesHolder.ofFloat("scaleX", from, to);
		PropertyValuesHolder sY = PropertyValuesHolder.ofFloat("scaleY", from, to);
		ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(text, sX, sY);
		Utils.addEndListener(this, animator, listener);
		animator.setDuration(duration);
		animator.addUpdateListener(this);
		animator.start();
	}

	@Override public void setTextSurface(@NonNull TextSurface textSurface) {
		this.textSurface = textSurface;
	}

	@Override public long getDuration() {
		return duration;
	}

	@Override public void onAnimationUpdate(ValueAnimator animation) {
		textSurface.invalidate();
	}

	@Override public String toString() {
		return "Scale{" +
				"text=" + text +
				'}';
	}
}
