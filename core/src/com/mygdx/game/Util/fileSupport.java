package com.mygdx.game.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class fileSupport {
    public static String takeStringFromFile(String fileName){ //чтение из файла
        FileHandle file = Gdx.files.local(fileName);
        return file.readString();
    }

    public static String getSceneStringFromFile(String fileName){
        FileHandle sceneFile = Gdx.files.local(fileName);
        return sceneFile.readString();
    }
}
