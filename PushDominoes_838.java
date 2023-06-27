package org.example;

import java.util.ArrayList;

public class PushDominoes_838 {
    class Solution {
        public String pushDominoes(String dominoes) {
            StringBuilder sb = new StringBuilder();
            ArrayList<Character> stack = new ArrayList<>();
            for (int i=0;i<dominoes.length();i++){
                char c = dominoes.charAt(i);
                if (c == '.'){
                    stack.add(c);
                }
                else {
                    int count = 0;
                    while (stack.size()>0 && stack.get(stack.size()-1) == '.'){
                        stack.remove(stack.size()-1);
                        count++;
                    }
                    if (stack.size()==0){
                        if (c == 'L'){
                            sb.append("L".repeat(Math.max(0, count + 1)));
                        }
                        else {
                            sb.append(".".repeat(Math.max(0, count)));
                            stack.add('R');
                        }
                    }
                    else {
                        if (c == 'L'){
                            stack.remove(stack.size()-1);
                            int RNum = count/2;
                            int LNum = count/2;
                            sb.append("R".repeat(Math.max(0, RNum+1)));
                            if (count%2!=0){
                                sb.append(".");
                            }
                            sb.append("L".repeat(Math.max(0, LNum+1)));
                        }
                        else {
                            sb.append("R".repeat(Math.max(0, count+1)));
                            stack.add('R');
                        }

                    }
                }
            }
            System.out.println(stack);
            if (stack.size()>0 && stack.get(0)=='R'){
                sb.append("R".repeat(stack.size()));
            }
            else {
                sb.append(".".repeat(stack.size()));
            }
            return sb.toString();
        }
    }
}
