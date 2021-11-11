package com.LC;

import java.util.Arrays;
import java.util.Comparator;

public class ReOrderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>(){
            @Override
            public int compare(String log1, String log2){
                String[] a = log1.split(" ", 2);
                String[] b = log2.split(" ", 2);
                
                boolean aDig = Character.isDigit(a[1].charAt(0));
                boolean bDig = Character.isDigit(b[1].charAt(0));
                if(!aDig && !bDig){
                    int cmp = a[1].compareTo(b[1]);
                    if(cmp != 0){
                        return cmp;
                    }else{
                        return a[0].compareTo(b[0]);
                    }
                }else if(aDig && !bDig){
                    return 1;
                }else if (!aDig && bDig){
                    return -1;
                }else 
                    return 0;
                }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }
}
