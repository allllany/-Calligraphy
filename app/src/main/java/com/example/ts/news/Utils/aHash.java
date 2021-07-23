//package com.example.ts.news.Utils;
//import android.graphics.Bitmap;
//import android.graphics.Color;
//
//public class aHash {
//    /**
//     * 均值哈希算法
//     * @param src
//     * @return
//     */
//    public char[] aHash(Bitmap src) {//已经是等大小的图片
//        int width = 8;
//        int height = 8;
//        //Bitmap image = this.resize(src,height,width);
//        width = src.getWidth();
//        height = src.getHeight();
//        int total = 0;
//        int[] ints = new int[width * height];
//        int index = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                int pixel = src.getPixel(j, i);
//                int gray = this.gary(pixel);
//                ints[index++] = gray;
//                total = total + gray;
//            }
//        }
//        StringBuffer res = new StringBuffer();
//        int grayAvg = total / (width * height);
//        for (int anInt : ints) {
//            if (anInt >= grayAvg) {
//                res.append("1");
//            } else {
//                res.append("0");
//            }
//        }
//        return res.toString().toCharArray();
//    }
//
//}
