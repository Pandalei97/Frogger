package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class WoodLong extends Wood{

	public WoodLong(Vector2 position, World world, float frequency, float speed) {
		super(position, world, frequency, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 354;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 60;
	}

}
