package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public abstract class Vehicle extends GameElementLineaire{
	public Vehicle(Vector2 position, World world, float movingTime, float speed) {
		super(position, world, movingTime, speed);
	}
}
