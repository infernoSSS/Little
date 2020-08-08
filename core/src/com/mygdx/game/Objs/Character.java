package com.mygdx.game.Objs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.scenes.Scene;

public class Character extends GameObj{
    @Override
    public GameObj createObj(int id, int type, float[] xy, Scene gameScene, GameManager gameManager, String names) {
        return super.createObj(id, type, xy, gameScene, gameManager, names);
    }

    @Override
    public boolean update(Scene Scene, GameManager gameManager) {
        return super.update(Scene, gameManager);
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
    }
}
