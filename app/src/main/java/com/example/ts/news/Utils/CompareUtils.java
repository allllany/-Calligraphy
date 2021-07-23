package com.example.ts.news.Utils;

import android.graphics.Bitmap;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class CompareUtils {
    private static final String TAG = "相似度" ;


    public static double CompareTwoPic(Bitmap pic1, Bitmap pic2){

        Mat mat1 = new Mat();
        Mat mat2 = new Mat();
        Mat mat11 = new Mat();
        Mat mat22 = new Mat();

        Utils.bitmapToMat(pic1, mat1);
        Utils.bitmapToMat(pic2, mat2);
        Imgproc.cvtColor(mat1, mat11, Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(mat2, mat22, Imgproc.COLOR_BGR2GRAY);
        double target = comPareHist(mat11, mat22);
        return target;
    }


    public static double comPareHist(Mat srcMat, Mat desMat){

        srcMat.convertTo(srcMat, CvType.CV_32F);
        desMat.convertTo(desMat, CvType.CV_32F);
        double target = Imgproc.compareHist(srcMat, desMat, Imgproc.CV_COMP_CORREL);
        Log.e(TAG, "相似度 ：   ==" + target);
        return target;

    }
}
