package com.mygdx.game.Objs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.scenes.Scene;

public class SceneChangeButton extends Button implements SceneChangeZone {
    private int changeTo;
    private Scene scene;

    @Override
    public GameObj createObj(int id, int type, float[] xy, Scene scene, GameManager gameManager, String names) {
        super.createObj(id, type, xy, scene, gameManager, names);
        this.scene = scene;
        changeTo = scene.getTransfer(scene.getNumbOfSceneChangeButtons());
        return this;
    }

    @Override
    public boolean update(Scene scen, GameManager gameManager) {
        return super.update(scen, gameManager);
    }

    @Override
    protected void updateTexture(int textureNumb) {
        super.updateTexture(textureNumb);
    }

    @Override
    public void draw(Scene gameScene, SpriteBatch batch) {
        super.draw(gameScene, batch);
    }

    @Override
    protected void loadTextures(Scene gameScene, GameManager gameManager, String names) {
        super.loadTextures(gameScene, gameManager, names);
    }

    @Override
    protected void playSound() {
        super.playSound();
    }

    @Override
    public void doAction() {
        super.doAction();
        changeScene();
    }

    @Override
    protected boolean checkTap(GameManager gameManager) {
        return super.checkTap(gameManager);
    }

    @Override
    public void changeScene() {
        scene.getSceneManager().updateScene(changeTo);
    }

    public void dispose(){
        super.dispose();
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
