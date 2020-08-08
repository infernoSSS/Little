package com.mygdx.game.SceneMaker.SceneMakerObj.buttons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SceneMaker.utils.HidingWindow;
import com.mygdx.game.SceneMaker.utils.Tip;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.scenes.SceneMakerScene;

public class WindowCloseButton extends SceneMakerButton {
    private HidingWindow hidingWindow;

    public WindowCloseButton(HidingWindow hidingWindow, GameManager gameManager, float x, float y) {
        super(gameManager, x, y, "okButton");
        this.hidingWindow = hidingWindow;
    }

    @Override
    public void create(SceneMakerScene sceneMakerScene, GameManager gameManager, SceneManager sceneManager) {
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
        hidingWindow.hide();
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
