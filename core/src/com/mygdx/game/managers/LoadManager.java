package com.mygdx.game.managers;

import java.util.HashMap;

public class LoadManager {
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
}
