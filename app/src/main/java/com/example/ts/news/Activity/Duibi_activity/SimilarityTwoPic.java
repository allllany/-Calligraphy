//package com.example.ts.news.Activity.Duibi_activity;
//
//import android.graphics.Bitmap;
//
//public class SimilarityTwoPic {
//    public static String similarity (Bitmap b, Bitmap viewBt) {
//        //把图片转换为Bitmap
//
//        Bitmap bm_one = b;
//        Bitmap bm_two = viewBt;
//        //保存图片所有像素个数的数组，图片宽×高
//        int[] pixels_one = new int[bm_one.getWidth()*bm_one.getHeight()];
//        int[] pixels_two = new int[bm_two.getWidth()*bm_two.getHeight()];
//        //获取每个像素的RGB值
//        bm_one.getPixels(pixels_one,0,bm_one.getWidth(),0,0,bm_one.getWidth(),bm_one.getHeight());
//        bm_two.getPixels(pixels_two,0,bm_two.getWidth(),0,0,bm_two.getWidth(),bm_two.getHeight());
//        //如果图片一个像素大于图片2的像素，就用像素少的作为循环条件。避免报错
//        if (pixels_one. length >= pixels_two. length) {
//            //对每一个像素的RGB值进行比较
//            for( int i = 0; i < pixels_two. length; i++){
//                int clr_one = pixels_one[i];
//                int clr_two = pixels_two[i];
//                //RGB值一样就加一（以便算百分比）
//                if (clr_one == clr_two) {
//                    t++;
//                } else {
//                    f++;
//                }
//            }
//        } else {
//            for( int i = 0; i < pixels_one. length; i++){
//                int clr_one = pixels_one[i];
//                int clr_two = pixels_two[i];
//                if (clr_one == clr_two) {
//                    t++;
//                } else {
//                    f++;
//                }
//            }
//
//        }
//
//        return "相似度为：" +myPercent ( t, t+ f );
//
//    }
//    /**
//     * 百分比的计算
//     * @author xupp
//     * @param y(母子)
//     * @param z（分子）
//     * @return 百分比（保留小数点后两位）
//     */
//    public static String myPercent (int y, int z)
//    {
//        String baifenbi= ""; //接受百分比的值
//        double baiy=y*1.0;
//        double baiz=z*1.0;
//        double fen=baiy/baiz;
//        DecimalFormat df1 = new DecimalFormat( "00.00%"); //##.00%   百分比格式，后面不足2位的用0补齐
//        baifenbi= df1.format(fen);
//        return baifenbi;
//    }
//}
