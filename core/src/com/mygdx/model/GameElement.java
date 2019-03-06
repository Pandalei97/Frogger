package com.mygdx.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameElement {
	protected Vector2 position;
	protected World world;
	//Le temps de réagir
	protected float frequency;
	
	
	public GameElement(Vector2 position, World world, float frequency) {
		this.position = position;
		this.world = world;
		this.frequency = frequency;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void setPosition(float x, float y) {
		position.set(x, y);
	}

	public float getFrequency() {
		return frequency;
	}
	
	public abstract float getWidth();
	public abstract float getHeight();
	
	public Rectangle getZoneCollision() {
		return new Rectangle(position.x, position.y, getWidth()*0.7f, getHeight()*0.7f);
	}
	
	public boolean collisionner(Rectangle player) {
		return player.overlaps(getZoneCollision());
	}
	
}
