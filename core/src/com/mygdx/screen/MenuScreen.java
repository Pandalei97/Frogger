package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mygdx.frogger.FroggerGame;

public class MenuScreen implements Screen, InputProcessor{
	private FroggerGame game;
	private BitmapFont font;
	private SpriteBatch batch;
	
	public MenuScreen(FroggerGame game) {
		this.game = game;
		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void show() {
		font = new BitmapFont(false);
        font.setColor(Color.GOLD);
        batch = new SpriteBatch();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        renderWelcomeInstructions(batch);
        batch.end();
		
	}

	private void renderWelcomeInstructions(SpriteBatch batch2) {
		String text = "Frogger";
        text = text + "\nAppuyez sur n'importe quelle touche pour commencer.";
        font.draw(batch, text, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0,
                Align.center, false);
		
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
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean keyDown(int keycode) {
        GameScreen screen = new GameScreen(game);
        game.setCurrentScreen(screen);
        
        //screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
