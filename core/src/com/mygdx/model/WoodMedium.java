package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class WoodMedium extends Wood{

	public WoodMedium(Vector2 position, World world, float frequency, float speed) {
		super(position, world, frequency, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 273;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 57;
	}

}
