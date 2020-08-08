package com.mygdx.game.Util;

import java.util.HashMap;
import java.util.Set;

public class HashMapTranslator {

    public static String StringMasstranslateHashMapToOneString(HashMap<Integer,String[]> hashMap){
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Set<Integer> keys = hashMap.keySet();
        for(Integer k : keys){
            sb.append(k).append('=');
            String[] supStrings = hashMap.get(k);
            for(String s : supStrings){
                sb.append(s).append('&');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append(", ");
        }
        int legth = sb.length();
        sb.delete(legth-2,legth);
        sb.append('}');
        return sb.toString();
    }

    public static String intMassTranslateHashMapToOneString(HashMap<Integer,Integer[]> hashMap){
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Set<Integer> keys = hashMap.keySet();
        for(Integer k : keys){
            sb.append(k).append('=');
            for(Integer supInt : hashMap.get(k)){
                sb.append(supInt).append('&');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append(", ");
        }
        int legth = sb.length();
        sb.delete(legth-2,legth);
        sb.append('}');
        return sb.toString();
    }

    public static HashMap<Integer, Integer[]> HashMapIntIntMassFromString(String string){
        HashMap<Integer, Integer[]> hashMap = new HashMap<>();
        Integer[] integerMass;
        String supString = string.replace("{", "");
        supString = string.replace("}", "");
        supString = string.replace(" ", "");
        String[] supStrings = supString.split(",");
        String[] supStrings2;
        Integer key;
        for(String s : supStrings){
            supStrings2 = s.split("=");
            key = Integer.parseInt(supStrings2[0]);
            supStrings2 = supStrings2[1].split("&");
            int length = supStrings2.length;
            integerMass = new Integer[length];
            for(int i = 0; i < length; i++){
                integerMass[i] = Integer.parseInt(supStrings2[i]);
            }
            hashMap.put(key, integerMass);
        }
        return hashMap;
    }

}
