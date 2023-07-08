/* 
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode indexNode  = l1;
        long  multiple = 1;
        long  num1 = 0 , num2 = 0;
        // get num1
        while(indexNode != null){
            num1 +=  (indexNode.val * multiple);
            multiple *= 10;
            indexNode = indexNode.next;
        }
        // get num2
        indexNode = l2;
        multiple = 1;
        while(indexNode != null){
            num2 +=  (indexNode.val * multiple);
            multiple *= 10;
            indexNode = indexNode.next;
        }
        
        long sum = num1 + num2;
        char[] chars = ("" + sum).toCharArray();
        int charLastIndex = chars.length - 1;
        int charConvertedToInt = Character.getNumericValue(chars[charLastIndex]);
        ListNode headNode = new ListNode(charConvertedToInt);
        indexNode = headNode; //refer by address not a copy;

        for(int i = chars.length-2; i >= 0; i--){
            charConvertedToInt = Character.getNumericValue(chars[i]);
            ListNode newNode = new ListNode(charConvertedToInt);
            indexNode.next = newNode;
            indexNode = newNode;   
        }
        
        return headNode;
    }
}