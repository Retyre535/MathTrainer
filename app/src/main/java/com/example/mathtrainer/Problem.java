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

    public String getProblem(){
        int a = getRandom(-50,50);
        int b = getRandom(-50,50);
        String sign = getRandomSign();
        if (sign.equals("+")) result = a + b;
        else result = a - b;
        return a + sign + b;

    }

    private String getRandomSign(){
        return random.nextBoolean()? "-" : "+";
    }
}
