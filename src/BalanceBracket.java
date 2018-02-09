import java.util.Scanner;
import java.util.Stack;

public class BalanceBracket {
	static String isBalanced(String s) {
        char [] split = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<split.length; i++) {
        	char c = split[i];
        	if(c == '{' || c == '(' || c =='[') {
        		stack.push(c);
        	}
        	else if(c == '}' || c == ')' || c == ']') {
        		if(stack.isEmpty()) {
        			return "NO";
        		}
        		if(c == '}') {
        			if(stack.peek() != '{') {
        				return "NO";
        			}
        			else {
        				stack.pop();
        			}
        		}
        		else if(c == ')') {
        			if(stack.peek() != '(') {
        				return "NO";
        			}
        			else {
        				stack.pop();
        			}
        		}
        		else if(c == ']') {
        			if(stack.peek() != '[') {
        				return "NO";
        			}
        			else {
        				stack.pop();
        			}
        		}
        	}
        }
        if(stack.isEmpty()) {
        	return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
