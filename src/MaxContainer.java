import java.util.Stack;

/**
 * Created by prajesh on 6/3/16.
 */
public class MaxContainer {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{6,2,5,4,4,1,6}));
    }

    public static int maxArea(int[] height) {

        Stack<Integer> stack = new Stack<>();

        int area=0, maxarea=0,top=0;

        int i=0;

        while (i < height.length) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxarea = Math.max(h * w, maxarea);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxarea = Math.max(h * w, maxarea);
        }



        return maxarea;
    }
}
