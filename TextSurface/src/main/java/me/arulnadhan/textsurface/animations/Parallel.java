package me.arulnadhan.textsurface.animations;

import me.arulnadhan.textsurface.contants.TYPE;
import me.arulnadhan.textsurface.interfaces.ISurfaceAnimation;

public class Parallel extends AnimationsSet {
	public Parallel(ISurfaceAnimation... animations) {
		super(TYPE.PARALLEL, animations);
	}
}
