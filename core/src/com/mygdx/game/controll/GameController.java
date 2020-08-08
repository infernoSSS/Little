package com.mygdx.game.controll;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameController {
    private Cursor cursor;
    private InputMultiplexer inputMultiplexer;

    public GameController(OrthographicCamera camera){
        cursor = new Cursor(camera);
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(0, new MyGameInputAdapter(cursor));
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public Cursor getCursor() {
        return cursor;
    }

    public InputMultiplexer getInputMultiplexer() {
        return inputMultiplexer;
    }
}
