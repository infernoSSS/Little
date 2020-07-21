package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	SceneManager sceneManager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		sceneManager = new SceneManager();
		sceneManager.create();
	}

	@Override
	public void render () {
		updateData();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sceneManager.drawScene(batch);
		//batch.draw(img, 0, 0);
		batch.end();
	}

	public void updateData(){

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
