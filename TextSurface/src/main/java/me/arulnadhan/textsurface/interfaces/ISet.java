package me.arulnadhan.textsurface.interfaces;

import java.util.LinkedList;

import me.arulnadhan.textsurface.contants.TYPE;

public interface ISet extends ISurfaceAnimation {
	TYPE getType();

	LinkedList<ISurfaceAnimation> getAnimations();
}
