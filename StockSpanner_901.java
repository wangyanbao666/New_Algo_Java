package org.example;

import java.util.ArrayList;

public class StockSpanner_901 {
    static class StockSpanner {
        private ArrayList<Integer> stocks;
        private ArrayList<Integer> stockSpans;
        public StockSpanner() {
            stocks = new ArrayList();
            stockSpans = new ArrayList();
        }

        public int next(int price) {
            int result = 1;
            while (stocks.size()>0 && stocks.get(stocks.size()-1) <= price){
                int size = stocks.size();
                stocks.remove(size-1);
                result+=stockSpans.remove(size-1);
            }
            stocks.add(price);
            stockSpans.add(result);
            System.out.println("result, "+result);
            return result;
        }
    }

    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        s.next(100);
        s.next(80);
        s.next(60);
        s.next(70);
        s.next(60);
        s.next(75);
        s.next(85);
    }
}
