package labs.labi1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Skobki {

    public boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (!isPair(open, c)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        Skobki task = new Skobki();
        String[] tests = {"[]", "[](){}", "[({})]", "[({}()){}]", "{]", "({)}"};
        for (String s : tests) {
            System.out.println("Input: str = \"" + s + "\"");
            System.out.println("Output: " + task.isBalanced(s) + "\n");
        }
    }
}
