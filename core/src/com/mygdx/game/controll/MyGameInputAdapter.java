package com.mygdx.game.controll;

import com.badlogic.gdx.InputAdapter;

public class MyGameInputAdapter extends InputAdapter {
    Cursor cursor;

    public MyGameInputAdapter(Cursor cursor) {
        super();
        this.cursor = cursor;
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character) {
        return super.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        switch (button){
            case (0):
                cursor.tap(screenX, screenY);
                return false;
            default: return false;
        }
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        switch (button){
            case (0):
                cursor.unTouch(screenX, screenY);
                return false;
            default: return false;
        }
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return super.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(int amount) {
        return super.scrolled(amount);
    }
}
