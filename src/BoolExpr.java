import java.util.Stack;

/**
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * <p>
 * 有效的表达式需遵循以下约定：
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/parsing-a-boolean-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class BoolExpr {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> worker = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            Stack<Character> operTemp = new Stack<>();
            if (currentChar == ',') {
                continue;
            }
            if (currentChar != ')') {
                worker.push(currentChar);
            } else {
                while (worker.peek() != '(') {
                    operTemp.push(worker.pop());
                }
                worker.pop();
                char oper = worker.pop();
                Character blockResult = blockExpr(operTemp, oper);
                if (blockResult == null) {
                    System.out.println("运算符输入有误,结果不可信");
                    return false;
                }
                worker.push(blockResult);
            }
        }
        return worker.pop() == 't';
    }

    private Character blockExpr(Stack<Character> operStack, char oper) {
        if (oper == '!') {
            return operStack.pop() == 't' ? 'f' : 't';
        }
        if (oper == '&') {
            while (!operStack.isEmpty()) {
                if (operStack.pop() == 'f') {
                    return 'f';
                }
            }
            return 't';
        }
        if (oper == '|') {
            while (!operStack.isEmpty()) {
                if (operStack.pop() == 't') {
                    return 't';
                }
            }
            return 'f';
        }
        return null;
    }
}
