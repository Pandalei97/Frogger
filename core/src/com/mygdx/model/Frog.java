package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class Frog extends GameElement{

	private float speedVertical;
	private float speedHorizontal;
	private int nbVie;
	private Vector2 posInit;
	public Frog(Vector2 position, World world, float frequency, int nbVie) {
		super(position, world, frequency);
		this.posInit = new Vector2(position);
		this.speedVertical = 53;
		this.speedHorizontal = 67;
		this.setNbVie(nbVie); 
	}
	
	public Frog(Frog f) {
		super(f.position,f.world,f.frequency);
		this.speedVertical = f.speedVertical;
		this.speedHorizontal = f.speedHorizontal;
		this.nbVie = f.nbVie;
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

	public int getNbVie() {
		return nbVie;
	}

	public void setNbVie(int nbVie) {
		this.nbVie = nbVie;
	}
	
	public Vector2 getPositionInitial() {
		return posInit;
	}
	
	public void refreshPosition(float frequency, float speed) {
		position.x += frequency * speed;
		if(position.x < 0)
			position.x = 0;
		if(position.x > 67*8)
			position.x = 67*8; 
	}
	

}
