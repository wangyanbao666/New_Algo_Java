package org.example;

public class CheckIfItIsAStraightLine_1232 {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            int x = coordinates[0][0];
            int y = coordinates[0][1];
            for (int i=1; i<coordinates.length; i++){
                if (coordinates[i][0] != x){
                    break;
                }
                if (i==coordinates.length-1){
                    return true;
                }
            }
            for (int i=1; i<coordinates.length; i++){
                if (coordinates[i][1] != y){
                    break;
                }
                if (i==coordinates.length-1){
                    return true;
                }
            }
            double k = (double) (coordinates[1][1]-coordinates[0][1])/(coordinates[1][0]-coordinates[0][0]);
            for (int i=1; i<coordinates.length-1; i++){
                double temp = (double) (coordinates[i+1][1]-coordinates[i][1])/(coordinates[i+1][0]-coordinates[i][0]);
                if (temp!=k){
                    return false;
                }
            }
            return true;
        }
    }
}
