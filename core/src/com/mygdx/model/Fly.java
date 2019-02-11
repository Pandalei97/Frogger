package com.mygdx.model;


import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Fly extends GameElement{
	private ArrayList<Vector2> positionsRefuges= new ArrayList<Vector2>();
	private int movingTime;
	
	public Fly(Vector2 position, World world) {
		super(position, world);
		this.movingTime = 6;
		positionsRefuges.add(new Vector2(20,630));
		positionsRefuges.add(new Vector2(150,630));
		positionsRefuges.add(new Vector2(280,630));
		positionsRefuges.add(new Vector2(410,630));
		positionsRefuges.add(new Vector2(540,630));
	}
	
	public void MoveBy(float x, float y) {
		setPosition(position.x + x, position.y + y);
	}
	
	public void MoveTo(Vector2 v) {
		position.set(v);
	}
	
	public int getMovingTime() {
		return this.movingTime;
	}
	
	public Vector2 getRandomPosition() {
		Random rand = new Random();
		int randomIndex = 0 + rand.nextInt(4 - 0 + 1);
		return positionsRefuges.get(randomIndex);
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
