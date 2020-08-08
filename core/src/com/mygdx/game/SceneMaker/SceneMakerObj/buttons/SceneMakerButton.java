package com.mygdx.game.SceneMaker.SceneMakerObj.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.SceneMaker.SceneMakerElements.SceneMakerElement;
import com.mygdx.game.SceneMaker.SceneMakerElements.SceneSettingsSheet;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;

import java.util.ArrayList;

public abstract class SceneMakerButton implements SceneMakerElement {
    private GameManager gameManager;
    private SceneSettingsSheet sceneSettingsSheet;
    private SceneManager sceneManager;
    private ArrayList<TextureAtlas.AtlasRegion> texteures;
    private  int curTexture;
    private Vector3 position;
    private Sound tapSound;
    protected float soundDeltaTime;
    private boolean isTapped;
    private Rectangle box;

    public SceneMakerButton(GameManager gameManager, float x, float y, String... names){
        //this.sceneSettingsSheet = sceneSettingsSheet;
        position = new Vector3(x, y, 0);
        this.gameManager = gameManager;
        texteures = new ArrayList<>();
        for(String name : names){
            texteures.add(gameManager.getTextureAtlas().findRegion(name));
        }
    }

    @Override
    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        isTapped = false;
        curTexture = 0;
        box = new Rectangle(position.x, position.y, texteures.get(curTexture).getRotatedPackedWidth(), texteures.get(curTexture).getRotatedPackedHeight());
        tapSound = Gdx.audio.newSound(Gdx.files.internal("audio/tapSound.wav"));
        soundDeltaTime = 0;
    }

    @Override
    public void update() {
        soundDeltaTime += gameManager.getDeltaTime();
        if(checkTap(gameManager)){
            doAction();
        }else {
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texteures.get(curTexture), position.x, position.y);
    }

    protected boolean checkTap(GameManager gameManager){
        if(gameManager.getGameController().getCursor().isTapped()){
            if(box.contains(gameManager.getGameController().getCursor().getVector3().x, gameManager.getGameController().getCursor().getVector3().y)){
                //box.contains(gameManager.getGameController().getCursor().getVector3().x, gameManager.getGameController().getCursor().getVector3().y)
                isTapped = true;
                return true;
            }
        }else {
            isTapped = false;
        }
        return false;
    }

    protected void doAction(){
        playSound();
    }

    protected void playSound(){
        if(soundDeltaTime >= 0.26) {
            tapSound.play();
            soundDeltaTime = 0;
        }
    }

    @Override
    public void dispose() {
        tapSound.dispose();
    }
}
