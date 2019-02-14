package com.mygdx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.model.GameElement;
import com.mygdx.model.GameElementLineaire;
import com.mygdx.model.World;
//Controller
public class WorldRenderer {
	private World world;
	private SpriteBatch batch;
	private float timerFly = 0;
	private float timerFrog = 0;
	private int mouseX, mouseY;
	private int moveH = 0, moveV = 0;
	private ShapeRenderer grille = new ShapeRenderer();
	
	public WorldRenderer(World world) {
		this.world = world;
		this.batch = new SpriteBatch();
	}
	
	public void render (float delta) {
		batch.begin();
		timerFrog += Gdx.graphics.getDeltaTime();
		
	Gdx.input.setInputProcessor(new InputProcessor(){

		@Override
		public boolean keyDown(int keycode) {
			// TODO Auto-generated method stub
			return false;
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
			if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
				mouseX = Gdx.input.getX();
				mouseY = Gdx.input.getY();
				// y1 = 690/600 *x;
				// y2 = -(690/600) * x + 690
				if(mouseY > (690.0/600 * mouseX) && mouseY < (-690.0/600 * mouseX + 690)) {
					moveH = -1;
				}
				if(mouseY < (690.0/600 * mouseX) && mouseY > (-690.0/600 * mouseX + 690)) {
					moveH = 1;
				}
				if(mouseY < (690.0/600 * mouseX) && mouseY < (-690.0/600 * mouseX + 690)) {
					moveV = 1;
				}
				if(mouseY > (690.0/600 * mouseX) && mouseY > (-690.0/600 * mouseX + 690)) {
					moveV = -1;
				}
				
				System.out.println("x : " + mouseX + " y : " + mouseY);
			}
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
		
	});
		
		
		this.world.getFrog().MoveBy(moveH, moveV);
		moveH = 0;
		moveV = 0;
		if(timerFrog > this.world.getFrog().getFrequency()) {
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				this.world.getFrog().MoveBy(-1, 0);
				timerFrog = 0;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				this.world.getFrog().MoveBy(1, 0);
				timerFrog = 0;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
				this.world.getFrog().MoveBy(0, 1);
				timerFrog = 0;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				this.world.getFrog().MoveBy(0, -1);
				timerFrog = 0;
			}
				
		}
		
		
		timerFly += Gdx.graphics.getDeltaTime();
		if(timerFly > this.world.getFly().getFrequency()) {
			this.world.getFly().MoveTo(this.world.getFly().getRandomPosition());
			timerFly = 0;
		}
		
		batch.draw(TextureFactory.getInstance().getFond(),0,0);
		GameElementLineaire temp;
		for (GameElement ge : world) {	// Render every element of world
			batch.draw(TextureFactory.getInstance().getTexture(ge.getClass()), ge.getPosition().x, ge.getPosition().y, ge.getWidth()*0.7f, ge.getHeight()*0.7f);
			if(ge instanceof GameElementLineaire) {
				temp = (GameElementLineaire)ge;
				temp.refreshPosition();
				ge.setPosition(temp.getPosition().x, temp.getPosition().y);
			}
				
		}
		
		grille.begin(ShapeType.Line);
		grille.setColor(1,0,0,1);
		for(int i = 0; i < 67; i++) {
			for(int j = 0; j < 53; j++) {
				grille.rect(i*67, j*53, 67, 53);
			}
		}
		grille.end();
		
		
		batch.end();
	}
	

}
