package com.mygdx.game.Objs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.Scene;

public class Button extends GameObj {
    private Sound tapSound;
    private boolean isTapped;

    @Override
    public GameObj createObj(int id, int type, float[] xy, Scene scene, GameManager gameManager, String names) {
        String[] supStrings = names.split("/", 2);
        tapSound = Gdx.audio.newSound(Gdx.files.internal(supStrings[0]));
        return super.createObj(id, type, xy, scene, gameManager, supStrings[1]);
    }

    @Override
    public boolean update(Scene scen, GameManager gameManager) {
        isTapped = checkTap(gameManager);
        updateTexture();
        return true;
    }

    @Override
    protected void updateTexture() {
        super.updateTexture();
    }

    @Override
    public void draw(Scene scene, SpriteBatch batch) {
        super.draw(scene, batch);
    }

    @Override
    protected void loadTextures(Scene scene, GameManager gameManager, String names) {
        super.loadTextures(scene, gameManager, names);
    }

    private void playSound(){
        tapSound.play();
    }

    public void doAction(){

    }

    private boolean checkTap(GameManager gameManager){
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

}
