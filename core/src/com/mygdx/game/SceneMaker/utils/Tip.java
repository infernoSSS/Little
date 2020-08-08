package com.mygdx.game.SceneMaker.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.SceneMaker.SceneMakerElements.SceneMakerElement;
import com.mygdx.game.SceneMaker.SceneMakerObj.buttons.WindowCloseButton;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;

public class Tip implements SceneMakerElement, HidingWindow {
    private GameManager gameManager;
    private String tip;
    private BitmapFont font;
    private String backgraund;
    private WindowCloseButton windowCloseButton;
    private Vector3 position;
    private Color color;
    private boolean hide;

    public Tip(String tip, SceneMakerScene sceneMakerScene, GameManager gameManager){
        this.gameManager = gameManager;
        this.tip = tip;
        font = new BitmapFont();
        font.getData().setScale(1.5f);
        position = new Vector3((1280-200)/2, (800 - 300)/2, 0);
        windowCloseButton = new WindowCloseButton(this, gameManager, position.x+80, position.y+20);
        windowCloseButton.create(sceneMakerScene, gameManager, sceneMakerScene.getSceneManager());
        backgraund = "tipSheet";
        color = Color.BLACK;
        hide = true;
    }

    public Tip(String tip, Color color, SceneMakerScene sceneMakerScene, GameManager gameManager){
        this.gameManager = gameManager;
        this.tip = tip;
        font = new BitmapFont();
        font.getData().setScale(1.5f);
        position = new Vector3((1280-200)/2, (800 - 300)/2, 0);
        windowCloseButton = new WindowCloseButton(this, gameManager, position.x+80, position.y+20);
        windowCloseButton.create(sceneMakerScene, gameManager, sceneMakerScene.getSceneManager());
        backgraund = "tipSheet";
        this.color = color;
        hide = true;
    }

    @Override
    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager) {

    }

    @Override
    public void update() {
        if(!hide){
            windowCloseButton.update();
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        if(!hide){
            spriteBatch.draw(gameManager.getTextureAtlas().findRegion(backgraund), position.x, position.y);
            font.setColor(color);
            font.draw(spriteBatch, tip, position.x+40, position.y+200, 100, 1, true);
            windowCloseButton.draw(spriteBatch);
        }
    }

    public void show(){
        hide = false;
    }

    public void hide(){
        hide = true;
    }

    @Override
    public void dispose() {
        windowCloseButton.dispose();
        font.dispose();
    }
}
