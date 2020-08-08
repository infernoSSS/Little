package com.mygdx.game.Objs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.scenes.Scene;
import com.mygdx.game.managers.GameManager;

public abstract class Button extends GameObj {
    protected Sound tapSound;
    protected boolean isTapped;
    protected float soundDeltaTime;

    @Override
    public GameObj createObj(int id, int type, float[] xy, Scene scene, GameManager gameManager, String names) {
        String[] supStrings = names.split("!", 2);
        tapSound = Gdx.audio.newSound(Gdx.files.internal(supStrings[0]));
        soundDeltaTime = 0;
        super.createObj(id, type, xy, scene, gameManager, supStrings[1]);
        return this;
    }

    @Override
    public boolean update(Scene scen, GameManager gameManager) {
        soundDeltaTime += gameManager.getDeltaTime();
        if(checkTap(gameManager)){
            doAction();
        }
        return true;
    }

    @Override
    protected void updateTexture(int textureNumb) {
        nowTexture = textureNumb;
    }

    @Override
    public void draw(Scene gameScene, SpriteBatch batch) {
        super.draw(gameScene, batch);
    }

    @Override
    protected void loadTextures(Scene gameScene, GameManager gameManager, String names) {
        super.loadTextures(gameScene, gameManager, names);
    }

    protected void playSound(){
        if(soundDeltaTime >= 0.26) {
            tapSound.play();
            soundDeltaTime = 0;
        }
    }

    public void doAction(){
        playSound();
    }

    protected boolean checkTap(GameManager gameManager){
        if(gameManager.getGameController().getCursor().isTapped()){
            if(hitBox.contains(gameManager.getGameController().getCursor().getVector3().x, gameManager.getGameController().getCursor().getVector3().y)){ // никогда не заходит
                isTapped = true;
                updateTexture(1);
                return true;
            }
            }else {
                isTapped = false;
                updateTexture(0);
        }
        return false;
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    protected String getNames(String... names) {
        return super.getNames(names);
    }

    @Override
    public void dispose() {
        super.dispose();
        tapSound.dispose();
    }
}
