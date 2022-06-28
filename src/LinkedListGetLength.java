/*Week3 Hackerrank Question
Complete the 'getLength' function below.
*
* The function is expected to return an INTEGER.
* The function accepts INTEGER_SINGLY_LINKED_LIST node as parameter.
 */

public class LinkedListGetLength {
    public static int getLength(ListNode.Node head){
        int count = 0;                              //integer to keep count of how many nodes
        ListNode.Node currentNode = head;           //tmp pointer that we we keep moving forward in the while loop

        while(currentNode != null){                 //while loop to loop through LL, 1->2->3->null, length should be 3.
            count++;                                //increment counter everytime we go in the method
            currentNode = currentNode.next;         //make curr node equal next
        }

        return count;       //simply return count
    }
}
