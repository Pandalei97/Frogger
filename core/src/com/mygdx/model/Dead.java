package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class Dead extends GameElement{

	public Dead(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	public float getWidth() {
		return 66;
	}

	@Override
	public float getHeight() {
		return 51;
	}

}
