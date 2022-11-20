package com.example.mathtrainer;

import java.util.Random;

public class Problem {
    private int result;
    private final Random random=new Random();

    public int getRandom(int min, int max){
        return  (int) (Math.random()*(max-min))+min;
    }

    public int getResult() {
        return result;
    }
    public int getNoiseResult() {
        return result + getRandom(-4,4);
    }

    public String getProblem() {
        int a = getRandom(-50, 50);
        int b = getRandom(-50, 50);
        String sign = getRandomSign();
        if (sign.equals("+")) result = a + b;
        else if (sign.equals("-")) result = a - b;
        else if (sign.equals("/")) {
            while (b == 0)
                b = getRandom(-50, 50);
            if (Math.abs(a)<Math.abs(b)) {
                int c = a;
                a = b;
                b = c;
            }
            result = a / b;
        } else if (sign.equals("*")) result = a * b;
        if (sign.equals("+") && b < 0) {
            sign = "-";
            b *= -1;
        } else if (sign.equals("-") && b < 0) {
            sign = "+";
            b *= -1;
        }
        if ((sign.equals("/") || sign.equals("*")) && b < 0) {
            sign += " (";
            return a + sign + b+")";
        } else return a + sign + b;
    }

    private String getRandomSign(){
        int c = getRandom(-100,100);
        String d;
        if (c%4==1) d ="+";
        else if (c%4==2) d ="-";
        else if (c%4==3) d ="/";
        else d="*";
        return d;
    }
}
