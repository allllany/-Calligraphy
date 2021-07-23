package com.example.ts.news.Utils;

import android.graphics.Bitmap;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.text.DecimalFormat;

import static org.opencv.imgproc.Imgproc.INTER_CUBIC;
import static org.opencv.imgproc.Imgproc.cvtColor;
import static org.opencv.imgproc.Imgproc.resize;

public class FCompareUtil {
    //作者：零医一零
    //时间：2019/10/27
    //输入：两个位图
    //输出：toast给你响应一下（响应在结尾自己改就是）
    //个人习惯：情谊全在注释里

    public static double HashCompare( Bitmap Bp1, Bitmap Bp2) {
        //数据定义导入部分
        Mat src1 = new Mat();
        Mat dst1 = new Mat();
        Mat src2 = new Mat();
        Mat dst2 = new Mat();
        //读取位图到MAT
        Utils.bitmapToMat(Bp1, src1);
        Utils.bitmapToMat(Bp2, src2);
        //变ARGB变灰度图，四通道变一通道
        cvtColor(src1, dst1, Imgproc.COLOR_BGR2GRAY);
        cvtColor(src2, dst2, Imgproc.COLOR_BGR2GRAY);
        //把灰度图图缩成8*8
        resize(dst1, dst1,new Size(8,8) , 0, 0,  INTER_CUBIC);
        resize(dst2, dst2,new Size(8,8) , 0, 0,  INTER_CUBIC);

        //核心算法部分
        //这里变成二维数组才可以用Mat.get(row,cul)去获取，二维是因为每个像素点里面可能有很多属性（ARGB）
        // 变成灰度之后就只有一个G了，这个G是Gray，前面那个G是Green。
        double[][] data1 = new double[64][1];
        double[][] data2 = new double[64][1];
        //iAvg 记录平均像素灰度值，arr记录像素灰度值，data是个跳板。
        int iAvg1 = 0, iAvg2 = 0;
        double[] arr1 = new double[64];
        double[] arr2 = new double[64];
        //get灰度给data，用data给arr充值，算平均灰度值iAvg。
        for (int i = 0; i < 8; i++)
        {
            int tmp = i * 8;
            for (int j = 0; j < 8; j++)
            {
                int tmp1 = tmp + j;
                data1[tmp1] = dst1.get(i,j);
                data2[tmp1] = dst2.get(i,j);
                arr1[tmp1] = data1[tmp1][0];
                arr2[tmp1] = data2[tmp1][0];
                iAvg1 += arr1[tmp1];
                iAvg2 += arr2[tmp1];
            }
        }
        iAvg1 /= 64;
        iAvg2 /= 64;
        //比对每个像素灰度值和平均灰度值大小
        for (int i = 0; i < 64; i++)
        {
            arr1[i] = (arr1[i] >= iAvg1) ? 1 : 0;
            arr2[i] = (arr2[i] >= iAvg2) ? 1 : 0;
        }
        //计算差异值
        int iDiffNum = 0;
        for (int i = 0; i < 64; i++) {
            if (arr1[i] != arr2[i]) {
                ++iDiffNum;
            }
        }
        //输出什么看个人喜好
        double res = (64 - iDiffNum) *1.0 / 64;
        return res;
//        if (iDiffNum <= 5) {
//            //Toast.makeText(getBaseContext(), "真像", Toast.LENGTH_SHORT).show();
//        } else {
//           // Toast.makeText(getBaseContext(), "我觉得不像", Toast.LENGTH_SHORT).show();
//        }
    }

}
