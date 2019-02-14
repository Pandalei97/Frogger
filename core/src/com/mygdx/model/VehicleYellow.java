package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class VehicleYellow extends GameElement{

	public VehicleYellow(Vector2 position, World world) {
		super(position, world);
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
