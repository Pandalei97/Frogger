package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class VehicleGreen extends Vehicle{
	

	public VehicleGreen(Vector2 position, World world, float movingTime, float speed) {
		super(position, world, movingTime, speed);
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 136;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 70;
	}

}
