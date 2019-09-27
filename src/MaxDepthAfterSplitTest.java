import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxDepthAfterSplitTest {
    private final MaxDepthAfterSplit maxDepthAfterSplit= new MaxDepthAfterSplit();

    @Test
    void maxDepthAfterSplit1() {
//        String seq = "(()())";
//        String seq = "(())";
        String seq = "(((()))((())))";
        System.out.println(Arrays.toString(maxDepthAfterSplit.maxDepthAfterSplit(seq)));
    }

    @Test
    void maxDepthAfterSplit2() {
        String seq = "()(())()";
        System.out.println(Arrays.toString(maxDepthAfterSplit.maxDepthAfterSplit(seq)));
    }
}