package com.mygdx.view;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.frogger.FroggerGame;
import com.mygdx.model.GameElement;
import com.mygdx.model.GameElementLineaire;
import com.mygdx.model.Turtle;
import com.mygdx.model.Fly;
import com.mygdx.model.Frog;
import com.mygdx.model.World;
import com.mygdx.outils.Pair;
//Controller
public class WorldRenderer {
	private World world;
	//private FroggerGame game;
	private SpriteBatch batch = new SpriteBatch();
	private float timerFly = 0;
	private float timerFrog = 0;
	private float timerRefreshFrog = 0;
	private float timerRefreshTurtle = 0;
	private int mouseX, mouseY;
	private int moveH = 0, moveV = 0;
	private ShapeRenderer grille = new ShapeRenderer();
	private int score;
	private int nbVie;
	private BitmapFont scoreBitmap = new BitmapFont(false);
	private BitmapFont vieBitmap = new BitmapFont(false);
	private boolean[] refugeOccupe =  {false, true, false, true, false, true, false,true, false};
	private Rectangle[] refugeRect = new Rectangle[9];
	private boolean termine = false;
	private boolean flyAlive = true;
	//Boolean qui détermine si le frog est sur un tronc ou sur des tortues
	private boolean sheltered;
	private Frog frogActuel;
	private TextureFrog textureFrogActuel = new TextureFrog();
	private TextureTurtle textureTurtle = new TextureTurtle();
	public WorldRenderer(World world) {
		this.world = world;
		//this.game = game;
		//this.batch = new SpriteBatch();
		score = 0;
		nbVie = this.world.getNbVie();
		frogActuel = this.world.getFrog();
		initRefugeRect();
	}
	

	private void initRefugeRect() {
		int width = 67;
		int height = 53;
		for(int i = 0; i < 9; i++)
			refugeRect[i] = new Rectangle(i*width, 53*12, width, height);
	}


	public int getNbVie() {
		return nbVie;
	}
	
	public void render (float delta) {
		//À chaque tour, on suppose que le forg n'est pas sur un tronc ou un tortue
		sheltered = false;
		
		
		if(nbVie <= 0 || refugeRempli())
			termine = true;
		
		
	//DEBUT DE BATCH
		batch.begin();
		//Dessine le fond
		batch.draw(TextureFactory.getInstance().getFond(),0,0);
		
		//Dessin de FrogActuel
		for (GameElement ge : world) {	// Render every element of world
			//On dessine tout sauf la mouche et le frog
			if(!(ge instanceof com.mygdx.model.Fly) && !(ge instanceof com.mygdx.model.Frog)&& !(ge instanceof com.mygdx.model.Turtle)) {
				batch.draw(TextureFactory.getInstance().getTexture(ge.getClass()), ge.getPosition().x, ge.getPosition().y, ge.getWidth()*0.7f, ge.getHeight()*0.7f);

			}
			if(ge instanceof com.mygdx.model.Turtle) {
				timerRefreshTurtle += Gdx.graphics.getDeltaTime();
				batch.draw(textureTurtle.getTexture(), ge.getPosition().x, ge.getPosition().y, ge.getWidth()*0.7f, ge.getHeight()*0.7f);
				if(timerRefreshTurtle > 0.5) {
					textureTurtle.refreshIndex();
					timerRefreshTurtle = 0;
				}
			}
			if(ge instanceof GameElementLineaire) {
				((GameElementLineaire)ge).refreshPosition();
				if(ge.collisionner(frogActuel.getZoneCollision())) {
					verifieCollisionLineaire(((GameElementLineaire)ge));
				}
			}
				
		}
		
		verifieEau();
		
		//Dessine le frogger
		batch.draw(textureFrogActuel.getTexture(), frogActuel.getPosition().x, frogActuel.getPosition().y, frogActuel.getWidth()*0.7f, frogActuel.getHeight()*0.7f);
		
		batch.end();
		
		//TextureFrog textureFrog = (TextureFrog)TextureFactory.getInstance().getTexturable(frogActuel.getClass());
		//textureFrog.render(delta);
		
		
		grille.begin(ShapeType.Line);
		grille.setColor(1,0,0,1);
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				grille.rect(i*67, j*53, 67, 53);
			}
		}
		grille.end();
		
		renderInfo();
		renderRefuge();
		renderFly();
	//FIN DE BATCH
		//Animation
		timerRefreshFrog += Gdx.graphics.getDeltaTime();
		if(timerRefreshFrog > 0.08) {
			textureFrogActuel.refreshIndex();
			timerRefreshFrog = 0;
		}
			
		//Gestions des movements
		timerFrog += Gdx.graphics.getDeltaTime();
		
		//Mouvement par clique de souris
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
				return false;
			}
	
			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}
	
			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				return false;
			}
	
			@Override
			public boolean scrolled(int amount) {
				return false;
			}
			
		});
		
		if(timerFrog > frogActuel.getFrequency()) {
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				//this.world.getFrog().MoveBy(-1, 0);
				moveH = -1;
				timerFrog = 0;
				textureFrogActuel.jump();
			}
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				//this.world.getFrog().MoveBy(1, 0);
				moveH = 1;
				timerFrog = 0;
				textureFrogActuel.jump();
			}
			if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
				//this.world.getFrog().MoveBy(0, 1);
				moveV = 1;
				timerFrog = 0;
				textureFrogActuel.jump();
			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				//this.world.getFrog().MoveBy(0, -1);
				moveV = -1;
				timerFrog = 0;
				textureFrogActuel.jump();
			}
			frogActuel.MoveBy(moveH, moveV);
			moveH = 0;
			moveV = 0;
			//On vérifie uniquement qprès le mouvement du frogger pour écomomiser
			if(frogActuel.collisionner(this.world.getFly().getZoneCollision())) {
				nbVie++;
				flyAlive = false;
			}
			verifieDest();	
		}
		
		
		
		
		
	}
	
	
	private boolean refugeRempli() {
		for(int i = 0; i < 9; i++)
			if(!refugeOccupe[i])
				return false;
		return true;
	}


	private void verifieDest() {
		for(int i = 0; i < 9; i++) {
			if(frogActuel.collisionner(refugeRect[i])) {
				if(refugeOccupe[i])
					nbVie--;
				else {
					score += 100;
					refugeOccupe[i] = true;
				}
					
				frogActuel.setPosition(frogActuel.getPositionInitial().x, frogActuel.getPositionInitial().y);
			}
				
		}
		
	}

	private void verifieCollisionLineaire(GameElementLineaire ge) {
		
		if(ge instanceof com.mygdx.model.Vehicle) {
			frogActuel.setPosition(frogActuel.getPositionInitial().x, frogActuel.getPositionInitial().y);
			nbVie --;
		}
		else {
			
			frogActuel.refreshPosition(ge.getFrequency(), ge.getSpeed());
			sheltered = true;
			System.out.println("Monter:");
			System.out.println(sheltered);
		}
		
	}


	private void verifieEau() {
		int width = 67;
		int height = 53;
		Rectangle zone = new Rectangle(0, 53*7, width*9, height*4);
//TODO à enlever les commentaires
		
		if(frogActuel.collisionner(zone)&& !sheltered) {
			nbVie--;
			frogActuel.setPosition(frogActuel.getPositionInitial().x, frogActuel.getPositionInitial().y);
		}
		
	}


	


	private void renderInfo() {
		
		batch.begin();
		String textScore = "Score: ";
		textScore += score;
        scoreBitmap.setColor(Color.WHITE);
        scoreBitmap.draw(batch, textScore, 70, 720);
        
        String textVie = "Vie: ";
		textVie += nbVie;
        vieBitmap.setColor(Color.WHITE);
        vieBitmap.draw(batch, textVie, 350, 720);
        batch.end();
       
    }

	private void renderRefuge() {
		batch.begin();
		for(int i = 0; i < 9; i+=2) {
			if(refugeOccupe[i])
				batch.draw(TextureFactory.getInstance().getTexture(frogActuel.getClass()),refugeRect[i].x,refugeRect[i].y);
		}
        batch.end();
		
	}
	
	private void renderFly() {
		if(flyAlive) {
			Fly fly = this.world.getFly();
			batch.begin();
			batch.draw(TextureFactory.getInstance().getTexture(fly.getClass()), fly.getPosition().x, fly.getPosition().y, fly.getWidth()*0.7f, fly.getHeight()*0.7f);
			batch.end();
			timerFly += Gdx.graphics.getDeltaTime();
			if(timerFly > this.world.getFly().getFrequency()) {
				this.world.getFly().MoveTo(this.world.getFly().getRandomPosition());
				timerFly = 0;
				
			}
		}
		
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean estTermine() {
		return termine;
	}
	

	

}
