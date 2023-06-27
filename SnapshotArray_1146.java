package org.example;

import java.util.*;

public class SnapshotArray_1146 {
    class SnapshotArray {
        private List<int[]>[] map;
        private int snapNum;

        public SnapshotArray(int length) {
            map = new List[length];
            snapNum = -1;
            for (int i=0;i<length;i++){
                map[i] = new ArrayList<>();
                map[i].add(new int[]{-1,0});
            }
        }

        public void set(int index, int val) {
            List<int[]> temp = map[index];
            if (snapNum!=temp.get(temp.size()-1)[0]){
                temp.add(new int[]{snapNum,val});
            }
            else {
                temp.get(temp.size()-1)[1]=val;
            }
        }

        public int snap() {
            snapNum+=1;
            return snapNum;
        }

        public int searchClosest(int index, int snap_id){
            List<int[]> list = map[index];
            int l=0;
            int r = list.size();
            while (l<r){
                int n = l+(r-l)/2;
                if ((n==list.size()-1 || list.get(n+1)[0]>snap_id) && list.get(n)[0]<=snap_id){
                    return n;
                }
                else if (list.get(n)[0]<=snap_id){
                    l = n+1;
                }
                else {
                    r = n;
                }
            }
            return l;
        }

        public int get(int index, int snap_id) {
            // if (snap_id==snapNum){
            // }
            int i = searchClosest(index, snap_id-1);
            // System.out.println(i);
            return map[index].get(i)[1];
        }
    }
}
