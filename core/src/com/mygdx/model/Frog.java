package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class Frog extends GameElement{

	private float speedVertical;
	private float speedHorizontal;
	public Frog(Vector2 position, World world, float frequency) {
		super(position, world, frequency);
		this.speedVertical = 53;
		this.speedHorizontal = 67;
	}

	public void MoveBy(int horiz, int verti) {
		
		if(horiz == 1 && position.x < 520 ||
			horiz == -1 && position.x > 30 ||
			verti == 1 && position.y < 590 ||
			verti == -1 && position.y > 15)
		setPosition(position.x + horiz * speedHorizontal, position.y + verti * speedVertical);
	}
	
	public float getSpeedVertical() {
		return speedVertical;
	}
	
	public float getSpeedHonrizontal() {
		return speedHorizontal;
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
