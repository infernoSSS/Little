package com.mygdx.game.SceneMaker.SceneMakerElements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;

public interface SceneMakerElement {
    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager);

    public void update();

    public void draw(SpriteBatch spriteBatch);

    public void dispose();
}
