import java.util.ArrayDeque;
import java.util.Deque;

class BasicCalculator {
    public static int calculate(String s) {
      int ans = 0;
      int num = 0;
      int sign = 1;
      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(sign);

  
      for (final char c : s.toCharArray())
        if (Character.isDigit(c))
          num = num * 10 + (c - '0');
        else if (c == '(')
          stack.push(sign);
        else if (c == ')')
          stack.pop();
        else if (c == '+' || c == '-') {
          ans += sign * num;//0+1*1//1
          sign = (c == '+' ? 1 : -1) * stack.peek();//1
          num = 0;//0
        }
  
      return ans + sign * num;
    }
    public static void main(String[] args) {
        String s="1+1";
        int result=calculate(s);
        System.out.println(result);
        
    }
  }