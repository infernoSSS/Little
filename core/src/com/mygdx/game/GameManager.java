package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import java.util.HashMap;

public final class GameManager {
    private int numbOfStartScene;
    private String lastSave;
    private HashMap<Integer, String> objsList;
    private String objsListFileName;
    private TextureAtlas textureAtlas;

    private GameOgjCreator gameOgjCreator;

    public void create(){
        gameOgjCreator = new GameOgjCreator();
        objsListFileName = "resurs/objFile.txt"; //здесь лежит HashMap с key - id, val - String описание объекта
        objsList = new HashMap<>();
        loadObjsFromFile(takeStringFromFile(objsListFileName),objsList);
        numbOfStartScene = 1;             //должно подгружаться из save
        createTextureAtlas();
    }

    private void createTextureAtlas(){      //создаём атлас текстур
        if(Gdx.files.local("resurs/packedImages/packed.png").exists()){ //если есть, то обновляем старое
            Gdx.files.local("resurs/packedImages/packed.png").delete();
        }
        if(Gdx.files.local("resurs/packedImages/packed.atlas").exists()){
            Gdx.files.local("resurs/packedImages/packed.atlas").delete();
        }
        TexturePacker.process("resurs/images", "resurs/packedImages", "packed");
        textureAtlas = new TextureAtlas(Gdx.files.local("resurs/packedImages/packed.atlas"));
    }

    public HashMap<Integer, String> getObjsList(){
        return objsList;
    }

    public int getNumbOfStartScene(){
        return numbOfStartScene;
    }//номер и метод нужно заменить так чтобы подгружалась последняя сохранённая сцена

    public void loadObjsFromFile(String stringFromFile, HashMap<Integer, String> objMap){ //получает строку считанную из файла и ссылку на Hashmap
        stringFromFile = stringFromFile.replace("{","");// удаление кавычек
        stringFromFile =  stringFromFile.replace("}","");
        stringFromFile =  stringFromFile.replace(" ","");
        String[] supStrings = stringFromFile.split(","); // разбиваем на пары ключ-значение
        String[] supStrings2;
        for(String s : supStrings){
            supStrings2 = s.split("=");
            objMap.put(Integer.parseInt(supStrings2[0]), supStrings2[1]);
        }
    }

    public String takeStringFromFile(String fileName){ //чтение из файла
        FileHandle file = Gdx.files.local(fileName);
        return file.readString();
    }

    public GameOgjCreator getGameOgjCreator() {
        return gameOgjCreator;
    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public void delete(){

    }

}
