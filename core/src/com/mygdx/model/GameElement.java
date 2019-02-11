package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public abstract class GameElement {
	protected Vector2 position;
	protected World world;
	
	public GameElement(Vector2 position, World world) {
		this.position = position;
		this.world = world;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void setPosition(float x, float y) {
		position.set(x, y);
	}
	
	public abstract float getWidth();
	public abstract float getHeight();
	
}
