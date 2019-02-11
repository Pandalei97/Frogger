package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class Frog extends GameElement{

	public Frog(Vector2 position, World world) {
		super(position, world);
	}
	
	public void MoveBy(float x, float y) {
		setPosition(position.x + x, position.y + y);
	}

	@Override
	public float getWidth() {
		return 60;
	}

	@Override
	public float getHeight() {
		return 60;
	}
	

}
