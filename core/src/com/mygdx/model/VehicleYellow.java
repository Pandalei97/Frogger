package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class VehicleYellow extends GameElementLineaire{

	public VehicleYellow(Vector2 position, World world, float frequency, float speed) {
		super(position, world, frequency, speed);
	}

	@Override
	public float getWidth() {
		return 136;
	}

	@Override
	public float getHeight() {
		return 71;
	}

}
