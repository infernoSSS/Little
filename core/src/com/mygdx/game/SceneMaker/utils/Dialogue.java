package com.mygdx.game.SceneMaker.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.SceneMaker.SceneMakerElements.SceneMakerElement;
import com.mygdx.game.SceneMaker.SceneMakerObj.buttons.WindowCloseButton;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;



public class Dialogue implements SceneMakerElement,HidingWindow {
    private GameManager gameManager;
    private SceneMakerScene sceneMakerScene;
    private String backgraund;
    private WindowCloseButton windowCloseButton;
    private String text;
    private TextField textField;
    private Vector3 position;
    private boolean hide;

    public Dialogue(String text, float x, float y, GameManager gameManager){
        this.gameManager = gameManager;
        this.text = text;
        position = new Vector3(x, y, 0);
        backgraund = "16080Button";
        hide = true;
        windowCloseButton = new WindowCloseButton(this, gameManager, position.x+60, position.y);
    }
    @Override
    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager) {
        this.gameManager = gameManager;
        this.sceneMakerScene = sceneMakerScene;
        windowCloseButton.create(sceneMakerScene, gameManager, sceneManager);
        textField = new TextField(text, gameManager.getSkin());
        textField.setPosition(position.x+5, position.y+40);
        sceneMakerScene.getStage().addActor(textField);
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
            textField.draw(spriteBatch, 1f);
            windowCloseButton.draw(spriteBatch);
        }
    }

    public void show(){
        hide = false;
    }

    public void hide(){
        hide = true;
    }

    public String getText(){
        return textField.getText();
    }

    @Override
    public void dispose() {
        windowCloseButton.dispose();
    }
}
