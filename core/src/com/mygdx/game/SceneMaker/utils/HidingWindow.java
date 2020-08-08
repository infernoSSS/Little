package com.mygdx.game.SceneMaker.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;

public interface HidingWindow {
    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager);
    public void show();
    public void hide();
    public void update();
    public void draw(SpriteBatch spriteBatch);
}
