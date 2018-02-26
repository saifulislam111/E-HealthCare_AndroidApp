package com.example.mdsaifulislam.newproject3;

import java.util.ArrayList;

/**
 * Created by Md Saiful Islam on 11/19/2017.
 */

public class Breath {
    private static int averageIndex = 0;
    private static final int averageArraySize = 4;
    private static final int[] averageArray = new int[averageArraySize];
    public static enum TYPE {
        GREEN, RED
    };

    private static TYPE currentType = TYPE.GREEN;
    private static double beats = 0;



    public static double  solve() {
        int averageArrayAvg = 0;
        int averageArrayCnt = 0;
        ArrayList<Double> rawAudio = MainResActivity.raw_audio;

        for(int j = 0; j<rawAudio.size();j++) {
            double imgAvg = rawAudio.get(j);
            //////////////////////////////loop start
            for (int i = 0; i < averageArray.length; i++) {
                if (averageArray[i] > 0) {
                    averageArrayAvg += averageArray[i];
                    averageArrayCnt++;
                }
            }

            int rollingAverage = (averageArrayCnt > 0) ? (averageArrayAvg / averageArrayCnt) : 0;
            TYPE newType = currentType;
            if (imgAvg < rollingAverage) {
                newType = TYPE.RED;
                if (newType != currentType) {
                    beats++;
                    // Log.d(TAG, "BEAT!! beats="+beats);
                }
            } else if (imgAvg > rollingAverage) {
                newType = TYPE.GREEN;
            }

            if (averageIndex == averageArraySize) averageIndex = 0;
            averageArray[averageIndex] = (int)imgAvg;
            averageIndex++;

            // Transitioned from one state to another to the same
            if (newType != currentType) {
                currentType = newType;
            }
            /////////////////////////stop loop
        }

//            double bps = (beats / 40);
//            int dpm = (int) (bps * 60d);
        return (Math.ceil((beats/2)-1)*3);
    }
}
