import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public static boolean validParenthesis(String s){
        //Understand:
        //Match: HashMap, Stack
        //Plan: create Hashmap create Key/Value pairs matching the open and closed parenthesis, using a stack to store
        //Implement:
        //Review:
        //Evaluate:

        HashMap<Character, Character> myMap = new HashMap<>();
        myMap.put(')', '(');
        myMap.put(']', '[');
        myMap.put('}', '{');

        Stack<Character> myStack = new Stack<Character>();

        //s = "()", s = "()[]{}"
        for(int j=0; j<s.length(); j++){
            Character i = s.charAt(j);
            if(i == '('){
                myStack.push(i);
            }
            else if(i == '['){
                myStack.push(i);
            }
            else if(i == '{'){
                myStack.push(i);
            }
            else if(i == ')'){
                if(myStack.empty() || myStack.peek() != '('){
                    return false;
                }
                else{
                    myStack.pop();
                }
            }
            else if(i == ']'){
                if(myStack.empty() || myStack.peek() != '['){
                    return false;
                }
                else{
                    myStack.pop();
                }
            }
            else if(i == '}'){
                if(myStack.empty() || myStack.peek() != '{'){
                    return false;
                }
                else{
                    myStack.pop();
                }
            }
        }

        return true;
    }
}
