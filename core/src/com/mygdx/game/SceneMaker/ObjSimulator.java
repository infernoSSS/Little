package com.mygdx.game.SceneMaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;


public class ObjSimulator {
    private TextureAtlas.AtlasRegion thisTexture;
    private Vector3 position;
    private int type;
    private int id;

    public void create(GameManager gameManager, int id, int type,  float x, float y, String names) {
        this.id = id;
        this.type = type;
        position = new Vector3(x, y, 0);
        thisTexture = gameManager.getTextureAtlas().findRegion(names.split("&")[0]);
    }


    public void update() {

    }


    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(thisTexture, position.x, position.y);
    }


    public void dispose() {

    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}
