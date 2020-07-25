package com.mygdx.game;

public class GameOgjCreator {
    public GameObj createObj(int id, float[] xy,Scene scene, GameManager gameManager, String... names){
        String[] supStringsToGetType = names;
        String[] supStr2 = supStringsToGetType[0].split("/");
        supStringsToGetType[0] = supStr2[1];
        int type = Integer.parseInt(supStr2[0]);
        switch (type){
            case (0) :
                return null;
            case (1) :
                return new GameNoUseObj().createObj(id, type, xy, scene, gameManager,  supStringsToGetType);
            default: return null;
        }
    }
}
