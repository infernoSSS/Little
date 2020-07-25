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

}
