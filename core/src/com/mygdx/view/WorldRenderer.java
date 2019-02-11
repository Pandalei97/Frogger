package com.mygdx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
		batch.draw(TextureFactory.getInstance().getTextureFrog(0),world.getFrog().getPosition().x, world.getFrog().getPosition().y);
		batch.draw(TextureFactory.getInstance().getTextureFly(),world.getFly().getPosition().x, world.getFly().getPosition().y);
		batch.draw(TextureFactory.getInstance().getTextureVehicle(0),world.getVehiculeRed().getPosition().x, world.getVehiculeRed().getPosition().y);
		batch.draw(TextureFactory.getInstance().getTextureVehicle(1),world.getVehicleBlue().getPosition().x, world.getVehicleBlue().getPosition().y);
		
		/*
		for(GameElement e : world) {
			//batch.draw(region, x, y, originX, originY, width, height, scaleX, scaleY, rotation);
		}
		*/
		batch.end();
	}
	

}
