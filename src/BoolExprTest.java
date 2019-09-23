import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoolExprTest {

    private BoolExpr boolExpr = new BoolExpr();

    @Test
    void parseBoolExpr1() {
        String expression = "!(f)";
        assertTrue(boolExpr.parseBoolExpr(expression));
    }

    @Test
    void parseBoolExpr2() {
        String expression = "|(f,t)";
        assertTrue(boolExpr.parseBoolExpr(expression));
    }

    @Test
    void parseBoolExpr3() {
        String expression = "&(t,f)";
        assertFalse(boolExpr.parseBoolExpr(expression));
    }

    @Test
    void parseBoolExpr4() {
        String expression = "|(&(t,f,t),!(t))";
        assertFalse(boolExpr.parseBoolExpr(expression));
    }
}