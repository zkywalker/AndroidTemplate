package me.arulnadhan.textsurface.animations;

import android.support.annotation.Nullable;

import me.arulnadhan.textsurface.interfaces.IEndListener;

public class Delay extends AbstractSurfaceAnimation {

	public static Delay duration(int duration) {
		return new Delay(duration);
	}

	public Delay(int duration) {
		super(null, duration);
	}

	@Override public void start(@Nullable final IEndListener listener) {
		textSurface.postDelayed(new Runnable() {
			@Override public void run() {
				if (listener != null) listener.onAnimationEnd(Delay.this);
			}
		}, duration);
	}

	@Override public String toString() {
		return "Delay{" +
				"duration=" + duration +
				'}';
	}
}
