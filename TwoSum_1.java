/* 
1. Two Sum
Given an arrray of integers, return indices of the two numbers such that they add up to specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
import java.util.*;
class TwoSum_1 {
    public static void main(String[] args) {
        int target = 8;
        int[] integers = {1,2,3,4,5};
        normalWay(integers,target);
        smartWay(integers,target);
    }
    static void normalWay(int[] integers,int target) {
        for(int i = 0;i<integers.length; i++) {
            for(int j = i+1;j<integers.length;j++) {
                if (target == integers[i] + integers[j]) {
                    System.out.println(i + " " + j); 
                    return;
                }
            }
        }
        System.out.println("No match!");
    }
    static void smartWay(int[] intergers, int target) {
        Map<Integer, Integer> theHashMap = new HashMap<>();
        int different;
        for(int i = 0; i<intergers.length; i++) {
            different = target - intergers[i];
            if(theHashMap.containsKey(different)) {
                System.out.println(theHashMap.get(different) + " " + i);
                return;
            }
            theHashMap.put(intergers[i],i);
        }
        System.out.println("No match!");
    }
}