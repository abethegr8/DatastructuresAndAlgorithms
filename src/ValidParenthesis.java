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

        return myStack.empty();
    }

    //s = "()", s = "()[]{}"
    public static boolean areParenthesisBalanced(String s){
        HashMap<Character, Character> closingToOpenParenthesisMap = new HashMap<>();
        Stack<Character> stackOfOpenParenthesis = new Stack<>();

        closingToOpenParenthesisMap.put(')', '(');
        closingToOpenParenthesisMap.put('}', '{');
        closingToOpenParenthesisMap.put(']', '[');

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            //if at anytime we see that its a closed parethesis, we need to pop the stack to see if the last element was an open parenth
            if(closingToOpenParenthesisMap.containsKey(c)){
                if(!stackOfOpenParenthesis.isEmpty() && closingToOpenParenthesisMap.get(c) == stackOfOpenParenthesis.peek()){
                    stackOfOpenParenthesis.pop();
                }
                else{
                    return false;
                }
            }
            else{
                //we get here if its a OPEN Parenthesis, so lets continue to push it into the stack
                stackOfOpenParenthesis.push(c);
            }
        }
        return stackOfOpenParenthesis.isEmpty();
    }
}
