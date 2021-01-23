package HashTables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CheckSymmetric {

    public static void findSymmetric(){
       int[][]arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        String result = "";
        Map<Integer, Integer> pairs  = new HashMap<>();
       for(int i=0; i< arr.length; i++){
               System.out.print("X-Value: "+ arr[i][0]);
               System.out.println("Y-Value: "+ arr[i][1]);
               int x_val = arr[i][0];
               int y_val = arr[i][1];
               if (pairs.containsKey(y_val)){
                   if(pairs.get(y_val) == x_val) {
                       result += String.valueOf(y_val) + String.valueOf(pairs.get(y_val));
                   }
               }
               else
               {
                   pairs.put(x_val, y_val);
               }

       }

       System.out.println(result);
    }

    public static void main(String[] args){
        findSymmetric();
    }
}


