package com.mygdx.game.SceneMaker.SceneMakerElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.SceneMaker.SceneMakerElements.SceneMakerElement;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;

import java.util.ArrayList;

public class ToStart implements SceneMakerElement {
    private GameManager gameManager;
    private SceneManager sceneManager;
    private ArrayList<TextureAtlas.AtlasRegion> texteures;
    private  int curTexture;
    private Vector3 position;
    private Sound tapSound;
    protected float soundDeltaTime;
    private boolean isTapped;
    private Rectangle box;

    @Override
    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager) {
        this.gameManager = gameManager;
        this.sceneManager = sceneManager;
        isTapped = false;
        texteures = new ArrayList<>();
        texteures.add(gameManager.getTextureAtlas().findRegion("toStart"));
        texteures.add(gameManager.getTextureAtlas().findRegion("toStartPressed"));
        curTexture = 0;
        position = new Vector3(10, 680, 0);
        box = new Rectangle(position.x, position.y, texteures.get(curTexture).getRotatedPackedWidth(), texteures.get(curTexture).getRotatedPackedHeight());
        tapSound = Gdx.audio.newSound(Gdx.files.internal("audio/tapSound.wav"));
        soundDeltaTime = 0;
    }

    @Override
    public void update() {
        soundDeltaTime += gameManager.getDeltaTime();
        if(checkTap(gameManager)){
            curTexture = 1;
            doAction();
        }else {
            curTexture = 0;
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texteures.get(curTexture), position.x, position.y);
    }

    protected boolean checkTap(GameManager gameManager){
        if(gameManager.getGameController().getCursor().isTapped()){
            if(box.contains(gameManager.getGameController().getCursor().getVector3().x, gameManager.getGameController().getCursor().getVector3().y)){
                isTapped = true;
                return true;
            }
        }else {
            isTapped = false;
        }
        return false;
    }

    private void doAction(){
        playSound();
        sceneManager.updateScene(1);
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
