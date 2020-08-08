package com.mygdx.game.SceneMaker.SceneMakerObj.texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.SceneMaker.SceneMakerElements.SceneMakerElement;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;

import java.util.ArrayList;

public class UnUseTexture implements SceneMakerElement {
    private GameManager gameManager;
    private ArrayList<TextureAtlas.AtlasRegion> texteures;
    private Vector3 position;
    private int curTexture;

    public UnUseTexture(GameManager gameManager, float x, float y, String... names){
        this.gameManager = gameManager;
        position = new Vector3(x, y ,0);
        texteures = new ArrayList<>();
        for (String name : names){
            texteures.add(gameManager.getTextureAtlas().findRegion(name));
        }
    }

    @Override
    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager) {
        curTexture = 0;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texteures.get(curTexture), position.x, position.y);
    }

    @Override
    public void dispose() {

    }
}
