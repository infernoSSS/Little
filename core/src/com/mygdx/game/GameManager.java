package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.HashMap;

public final class GameManager {
    private int numbOfStartScene;
    private String lastSave;
    private HashMap<Integer, String[]> objsList;
    private String objsListFileName;

    public void create(){
        objsListFileName = "resurs/NoUseObjFile.txt"; //здесь лежит HashMap с key - id, val - String[] текстуры объектов
        objsList = new HashMap<>();
        loadObjsFromFile(takeStringFromFile(objsListFileName),objsList);
        numbOfStartScene = 1;             //должно подгружаться из save
    }

    public HashMap<Integer, String[]> getObjsList(){
        return objsList;
    }

    public int getNumbOfStartScene(){
        return numbOfStartScene;
    }

    public void loadObjsFromFile(String stringFromFile, HashMap<Integer, String[]> objMap){ //получает строку считанную из файла и ссылку на Hashmap
        stringFromFile = stringFromFile.replace("{","");// удаление кавычек
        stringFromFile =  stringFromFile.replace("}","");
        stringFromFile =  stringFromFile.replace(" ","");
        String[] supStrings = stringFromFile.split(","); // разбиваем на пары ключ-значение
        String[] supStrings2;
        for(String s : supStrings){
            supStrings2 = s.split("=");
            objMap.put(Integer.parseInt(supStrings2[0]), supStrings2[1].split(";"));
        }
    }

    public String takeStringFromFile(String fileName){ //чтение из файла
        FileHandle file = Gdx.files.local(fileName);
        return file.readString();
    }

    public void delete(){

    }

}
