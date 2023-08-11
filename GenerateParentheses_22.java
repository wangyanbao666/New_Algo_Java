package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses_22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generate("", n, result, 0);
            return result;
        }

        public void generate(String cur, int left, List<String> result, int require){
            if (left==0){
                cur = cur + ")".repeat(Math.max(0, require));
                result.add(cur);
                return;
            }
            String newCur;
            if (require>0){
                for (int j=1;j<=require;j++){
                    newCur = cur + ")".repeat(Math.max(0,j));
                    for (int i=1;i<=left;i++){
                        generate(newCur + "(".repeat(Math.max(0, i)), left-i, result, require+i-j);
                    }
                }
            }
            else {
                for (int i=1;i<=left;i++){
                    newCur = cur + "(".repeat(Math.max(0, i));
                    generate(newCur, left-i, result, require+i);
                }
            }


        }
    }
}
