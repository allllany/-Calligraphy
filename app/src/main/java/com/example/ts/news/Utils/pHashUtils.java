//package com.example.ts.news.Utils;
//import android.graphics.Bitmap;
//
//
//
//public class pHashUtils {
//    /**
//     * 感知哈希算法
//     * @param src
//     * @return
//     */
//    public char[] pHash(Bitmap src) {
//        int width = 8;
//        int height = 8;
//        BufferedImage image = this.resize(src,height,width);
//        int[] dctDate = new int[width * height];
//        int index = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                int pixel = image.getRGB(j, i);
//                int gray = this.gray(pixel);
//                dctDate[index++] = gray;
//            }
//        }
//        dctDate = DCT.DCT(dctDate,width);
//        int avg = DCT.averageGray(dctDate ,width,height);
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<height; i++) {
//            for(int j=0; j<width; j++) {
//                if(dctDate[i*height + j] >= avg) {
//                    sb.append("1");
//                } else {
//                    sb.append("0");
//                }
//            }
//        }
//        long result;
//        if(sb.charAt(0) == '0') {
//            result = Long.parseLong(sb.toString(), 2);
//        } else {
//            //如果第一个字符是1，则表示负数，不能直接转换成long，
//            result = 0x8000000000000000l ^ Long.parseLong(sb.substring(1), 2);
//        }
//
//        sb = new StringBuilder(Long.toHexString(result));
//        if(sb.length() < 16) {
//            int n = 16-sb.length();
//            for(int i=0; i<n; i++) {
//                sb.insert(0, "0");
//            }
//        }
//        return sb.toString().toCharArray();
//    }
//
//    /**
//     * 离散余弦变换
//     * @param pix 原图像的数据矩阵
//     * @param n 原图像(n*n)的高或宽
//     * @return 变换后的矩阵数组
//     */
//    public static int[] DCT(int[] pix, int n) {
//        double[][] iMatrix = new double[n][n];
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                iMatrix[i][j] = (double)(pix[i*n + j]);
//            }
//        }
//        double[][] quotient = coefficient(n);	//求系数矩阵
//        double[][] quotientT = transposingMatrix(quotient, n);	//转置系数矩阵
//
//        double[][] temp = matrixMultiply(quotient, iMatrix, n);
//        iMatrix =  matrixMultiply(temp, quotientT, n);
//
//        int newpix[] = new int[n*n];
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                newpix[i*n + j] = (int)iMatrix[i][j];
//            }
//        }
//        return newpix;
//    }
//
//    /**
//     * 矩阵转置
//     * @param matrix 原矩阵
//     * @param n 矩阵(n*n)的高或宽
//     * @return 转置后的矩阵
//     */
//    private static double[][]  transposingMatrix(double[][] matrix, int n) {
//        double nMatrix[][] = new double[n][n];
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                nMatrix[i][j] = matrix[j][i];
//            }
//        }
//        return nMatrix;
//    }
//
//    /**
//     * 求离散余弦变换的系数矩阵
//     * @param n n*n矩阵的大小
//     * @return 系数矩阵
//     */
//    private static double[][] coefficient(int n) {
//        double[][] coeff = new double[n][n];
//        double sqrt = 1.0/Math.sqrt(n);
//        for(int i=0; i<n; i++) {
//            coeff[0][i] = sqrt;
//        }
//        for(int i=1; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                coeff[i][j] = Math.sqrt(2.0/n) * Math.cos(i*Math.PI*(j+0.5)/(double)n);
//            }
//        }
//        return coeff;
//    }
//
//    /**
//     * 矩阵相乘
//     * @param A 矩阵A
//     * @param B 矩阵B
//     * @param n 矩阵的大小n*n
//     * @return 结果矩阵
//     */
//    private static double[][] matrixMultiply(double[][] A, double[][] B, int n) {
//        double nMatrix[][] = new double[n][n];
//        double t;
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                t = 0;
//                for(int k=0; k<n; k++) {
//                    t += A[i][k]*B[k][j];
//                }
//                nMatrix[i][j] = t;
//            }
//        }
//        return nMatrix;
//    }
//
//    /**
//     * 求灰度图像的均值
//     * @param pix 图像的像素矩阵
//     * @param w 图像的宽
//     * @param h 图像的高
//     * @return 灰度均值
//     */
//    public static int averageGray(int[] pix, int w, int h) {
//        int sum = 0;
//        for(int i=0; i<h; i++) {
//            for(int j=0; j<w; j++) {
//                sum = sum+pix[i*w + j];
//            }
//        }
//        return sum/(w*h);
//    }
//
//}
