package com.mygdx.frogger;

import com.badlogic.gdx.math.Vector2;

public class Vehicle extends GameElement{

	public Vehicle(Vector2 position, World world) {
		super(position, world);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 200;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 60;
	}

}
