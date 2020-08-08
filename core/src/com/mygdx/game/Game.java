package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 vector3;
	GameScreen gameScreen;

	static final int WIDTH  = 1280;
	static final int HIGHT  = 800;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(WIDTH, HIGHT);
		vector3 = new Vector3(WIDTH/2,HIGHT/2,0);
		camera.position.set(vector3);
		camera.update();
		gameScreen = new GameScreen();
		gameScreen.createScreen(camera);
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		gameScreen.draw(batch);
		batch.end();
	}

	public void update(){
		gameScreen.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameScreen.dispose();
	}
}
