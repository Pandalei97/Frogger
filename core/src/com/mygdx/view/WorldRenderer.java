package com.mygdx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.model.GameElement;
import com.mygdx.model.World;
//Controller
public class WorldRenderer {
	private World world;
	private SpriteBatch batch;
	private float timeToMove = 0;
	private int moveTime = 3;
	
	
	/*
	private Frogger game;
	
	public WorldRenderer(Frogger game) {
		world = new World();
		this.game = game;
	}
	*/
	
	public WorldRenderer(World world) {
		this.world = world;
		this.batch = new SpriteBatch();
	}
	
	public void render (float delta) {
		batch.begin();
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			this.world.getFrog().MoveBy(-15, 0);
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			this.world.getFrog().MoveBy(15, 0);
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
			this.world.getFrog().MoveBy(0, 15);
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
			this.world.getFrog().MoveBy(0, -15);
		
		timeToMove += Gdx.graphics.getDeltaTime();
		if(timeToMove > moveTime) {
			this.world.getFly().MoveTo(this.world.getFly().getRandomPosition());
			timeToMove = 0;
		}
		
		batch.draw(TextureFactory.getInstance().getFond(),0,0);
		for (GameElement ge : world) {	// Render every element of world
			batch.draw(TextureFactory.getInstance().getTexture(ge.getClass()), ge.getPosition().x, ge.getPosition().y, ge.getWidth(), ge.getHeight());
		}
		
		batch.end();
	}
	

}
