package com.mygdx.game.controll;

import com.badlogic.gdx.Gdx;

public class GameController {
    Cursor cursor;
    MyGameInputAdapter myGameInputAdapter;

    public GameController(){
        cursor = new Cursor();
        myGameInputAdapter = new MyGameInputAdapter(cursor);
        Gdx.input.setInputProcessor(myGameInputAdapter);
    }

    public Cursor getCursor() {
        return cursor;
    }
}
