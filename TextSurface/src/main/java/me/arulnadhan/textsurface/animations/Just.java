package me.arulnadhan.textsurface.animations;

import android.support.annotation.Nullable;

import me.arulnadhan.textsurface.contants.TYPE;
import me.arulnadhan.textsurface.Text;
import me.arulnadhan.textsurface.interfaces.IEndListener;

public class Just extends AbstractSurfaceAnimation {

	public static AnimationsSet show(Text... texts) {
		Just[] justs = new Just[texts.length];
		for (int i = 0; i < texts.length; i++) justs[i] = Just.show(texts[i]);
		return new AnimationsSet(TYPE.PARALLEL, justs);
	}

	public static Just show(Text text) {
		return new Just(text);
	}

	private Just(Text text) {
		super(text, 0);
	}

	@Override public void start(@Nullable IEndListener listener) {
		textSurface.invalidate();
		if (listener != null) listener.onAnimationEnd(this);
	}
}
