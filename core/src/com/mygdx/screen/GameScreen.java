package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.model.World;
import com.mygdx.view.WorldRenderer;

public class GameScreen implements Screen{
	private World world;
	private WorldRenderer worldRenderer;
	
	public GameScreen() {
		world = new World();
		worldRenderer = new WorldRenderer(world);
	}
	
	public World getWorld() {
		return world;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		// called when this screen is set as the screen with game.setScreen();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    this.worldRenderer.render(delta);

		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		// called when current screen changes from this to a different screen
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		// never called automatically
		
	}

}
