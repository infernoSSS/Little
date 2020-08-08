package com.mygdx.game.SceneMaker.SceneMakerObj.buttons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SceneMaker.SceneMakerElements.SceneSettingsSheet;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;

public class ApplySceneButton extends SceneMakerButton {
    private SceneMakerScene sceneMakerScene;
    private SceneSettingsSheet sceneSettingsSheet;

    public ApplySceneButton(SceneSettingsSheet sceneSettingsSheet, GameManager gameManager, float x, float y, String... names) {
        super(gameManager, x, y, names);
        this.sceneSettingsSheet = sceneSettingsSheet;
    }

    @Override
    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager) {
        this.sceneMakerScene = sceneMakerScene;
        super.create(sceneMakerScene, gameManager, sceneManager);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
    }

    @Override
    protected boolean checkTap(GameManager gameManager) {
        return super.checkTap(gameManager);
    }

    @Override
    protected void doAction() {
        super.doAction();
        sceneMakerScene.getSceneFileManager().loadScene(sceneSettingsSheet.getTextFields().get("sceneChoose").getText());
    }

    @Override
    protected void playSound() {
        super.playSound();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
