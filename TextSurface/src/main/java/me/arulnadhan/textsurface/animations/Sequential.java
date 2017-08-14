package me.arulnadhan.textsurface.animations;

import me.arulnadhan.textsurface.contants.TYPE;
import me.arulnadhan.textsurface.interfaces.ISurfaceAnimation;

public class Sequential extends AnimationsSet {
	public Sequential(ISurfaceAnimation... animations) {
		super(TYPE.SEQUENTIAL, animations);
	}
}
