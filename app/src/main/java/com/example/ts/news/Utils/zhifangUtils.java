//package com.example.ts.news.Utils;
//
//public class zhifangUtils {
//    final Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.test_hist);
//        image0.setImageBitmap(bitmap);
//
//    CV4JImage cv4jImage = new CV4JImage(bitmap);
//    ImageProcessor imageProcessor = cv4jImage.convert2Gray().getProcessor();
//
//    int[][] source = null;
//    int[][] target = null;
//
//    CalcHistogram calcHistogram = new CalcHistogram();
//    int bins = 180;
//    source = new int[imageProcessor.getChannels()][bins];
//        calcHistogram.calcHSVHist(imageProcessor,bins,source,true);
//
//        if (imageProcessor instanceof ByteProcessor) {
//        EqualHist equalHist = new EqualHist();
//        equalHist.equalize((ByteProcessor) imageProcessor);
//        image1.setImageBitmap(cv4jImage.getProcessor().getImage().toBitmap());
//
//        target = new int[imageProcessor.getChannels()][bins];
//        calcHistogram.calcHSVHist(imageProcessor,bins,target,true);
//    }
//
//    CompareHist compareHist = new CompareHist();
//    StringBuilder sb = new StringBuilder();
//        sb.append("巴氏距离:").append(compareHist.bhattacharyya(source[0],target[0])).append("\r\n")
//                .append("协方差:").append(compareHist.covariance(source[0],target[0])).append("\r\n")
//                .append("相关性因子:").append(compareHist.ncc(source[0],target[0]));
//
//        result.setText(sb.toString());
//}
