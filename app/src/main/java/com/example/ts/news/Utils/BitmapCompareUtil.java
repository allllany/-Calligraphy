package com.example.ts.news.Utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

/**
 * Created by wuyr on 17-12-12 下午4:20.
 */

@SuppressWarnings({"WeakerAccess", "SameParameterValue"})
public class BitmapCompareUtil {

    /**
     * 需要被检测到的颜色
     */
    private static int[][] mPaintColors;

    /**
     * 获取两张图片的数据比较
     *
     * @param src         原图
     * @param target      要比较的图片
     * @param paintColors 需要被检测到的颜色
     * @return 两图的像素信息
     */
    public static DiffInfo getBitmapDiffInfo(Bitmap src, Bitmap target, int... paintColors) {
        //先将原图缩放4倍 (提高执行效率，因为是涂鸦线条，基本不会影响到最终的结果的)
        float scale = .25F;
        Bitmap srcTemp = scaleBitmap(src, (int) (src.getWidth() * scale), (int) (src.getHeight() * scale));
        Bitmap targetTemp = scaleBitmap(target, (int) (target.getWidth() * scale), (int) (target.getHeight() * scale));
        //初始化需要被检测到的颜色
        initPaintColors(paintColors);

        int srcBitmapDarkPixelCount, //原图对应颜色像素点数
                targetBitmapDarkPixelCount, //目标图对应颜色像素点数
                hitCount, //完全重合的像素点数
                nearCount, //相近的像素点数
                awayCount; //不匹配的像素点数
        float similarityDegree; //自己计算的相似度
        hitCount = nearCount = awayCount = 0;

        List<Point> targetBitmapPixelPoints = new ArrayList<>(); //目标bitmap像素点
        //初始化目标bitmap
        targetBitmapDarkPixelCount = getLookLikePaintColorPixel(targetTemp, 0, 0, targetBitmapPixelPoints, null);

        int[][] srcBitmapPixelPointsTable = new int[srcTemp.getHeight()][srcTemp.getWidth()]; //原图像素点映射表
        //初始化原图
        srcBitmapDarkPixelCount = getLookLikePaintColorPixel(srcTemp, 0, 0, null, srcBitmapPixelPointsTable);

        //遍历目标bitmap获取的像素点，并查找匹配
        for (Point point : targetBitmapPixelPoints) {
            //检查数组越界 （因为目标bitmap可能比原图大）
            if (!isOutside(point.x, point.y, srcBitmapPixelPointsTable.length, srcBitmapPixelPointsTable[0].length)) {
                if (srcBitmapPixelPointsTable[point.y][point.x] == 1) {
                    //等于1，则完全匹配
                    hitCount++;
                } else {
                    //检查周边5个像素点是否有匹配到
                    if (checkNearItemIsHit(5, srcBitmapPixelPointsTable, point)) {
                        nearCount++;
                    } else {
                        awayCount++;
                    }
                }
            }
        }
        //(自己计算的)相似度的基本分，根据两图获取的像素的相差百分比
        similarityDegree = (float) targetBitmapDarkPixelCount / (float) srcBitmapDarkPixelCount;
        if (similarityDegree > 1) {
            //目标bitmap的像素点比原图的多，则用1减去多出来的
            float more = Math.abs(1 - similarityDegree);
            similarityDegree = 1 - more;
        }
        //计算两图完全匹配的像素点与总像素点的百分比
        float hitPercent = (float) hitCount / (float) srcBitmapDarkPixelCount;
        //计算相邻的像素点与总像素点的百分比
        float nearPercent = (float) nearCount / (float) srcBitmapDarkPixelCount;
        //这个我们把2个相邻的点，当作一个完全匹配的点
        hitPercent += nearPercent / 2;
        //再用基本分 - 1 - 优化后的完全命中百分比
        similarityDegree -= 1 - hitPercent;

        if (similarityDegree < 0) {
            similarityDegree = 0;
        }

        //因为刚刚缩放了图片，所以这些数据也要恢复 （除以缩放比例）
        return new DiffInfo((int) (srcBitmapDarkPixelCount / scale), (int) (targetBitmapDarkPixelCount / scale),
                (int) (hitCount / scale), (int) (nearCount / scale), (int) (awayCount / scale), similarityDegree);
    }

    /**
     * 获取目标bitmap近似画笔颜色的像素点
     *
     * @param target 目标bitmap
     * @param startX bitmap在canvas中的x轴
     * @param startY bitmap在canvas中的y轴
     * @param data   获取到的像素点 以List的形式
     * @param table  获取到的像素点 以二位数组的形式
     * @return 获取到的像素点数
     */
    private static int getLookLikePaintColorPixel(Bitmap target, final int startX, final int startY, final List<Point> data, final int[][] table) {
        final int[] darkColorCount = {0};
        getBitmapPixelColor(target, new PixelColorHandler() {
            @Override
            public void onHandle(Bitmap target, int index, int x, int y, int r, int g, int b) {
                if (table != null) {
                    table[y][x] = 1;
                }
                if (data != null) {
                    data.add(new Point(startX + x, startY + y));
                }
                ++darkColorCount[0];
            }
        });
        return darkColorCount[0];
    }

    /**
     * 获取目标bitmap近似画笔颜色的像素点
     *
     * @param target  目标bitmap
     * @param handler 回调接口
     */
    private static void getBitmapPixelColor(Bitmap target, PixelColorHandler handler) {
        if (checkBitmapCanUse(target) && handler != null) {
            int width = target.getWidth(), height = target.getHeight();
            int[] targetPixels = new int[width * height];
            //获取bitmap所有像素点
            target.getPixels(targetPixels, 0, width, 0, 0, width, height);
            int index = 0;
            int pixelColor;
            int r, g, b;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    //获取rgb色值并与目标颜色相比较
                    pixelColor = targetPixels[index];
                    r = Color.red(pixelColor);
                    g = Color.green(pixelColor);
                    b = Color.blue(pixelColor);
                    if (isLookLikePaintColor(r, g, b)) {
                        handler.onHandle(target, index, x, y, r, g, b);
                    }
                    ++index;
                }
            }
        }
    }

    /**
     * 将目标bitmap进行缩放
     *
     * @param target 目标bitmap
     * @param w      新的宽度
     * @param h      新的高度
     * @return 缩放后的bitmap
     */
    public static Bitmap scaleBitmap(Bitmap target, int w, int h) {
        if (target == null || target.isRecycled()) {
            return target;
        }
        int width = target.getWidth(), height = target.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) w / width), ((float) h / height));
        return Bitmap.createBitmap(target, 0, 0, width, height, matrix, true);
    }

    /**
     * 检查目标bitmap是否可用
     */
    private static boolean checkBitmapCanUse(Bitmap target) {
        return target != null && !target.isRecycled();
    }

    /**
     * 根据色值判断和目标颜色是否近似
     */
    private static boolean isLookLikePaintColor(int r, int g, int b) {
        for (int[] color : mPaintColors) {
            int dither = 10; //允许色值的抖动范围是10 (max = 255)
            int redDither = Math.abs(color[0] - r);
            int greenDither = Math.abs(color[1] - g);
            int blueDither = Math.abs(color[2] - b);
            if (redDither < dither && greenDither < dither && blueDither < dither) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     */
    private static void initPaintColors(int[] paintColors) {
        mPaintColors = new int[paintColors.length][3];
        for (int index = 0; index < paintColors.length; index++) {
            int r, g, b;
            int color = paintColors[index];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            mPaintColors[index][0] = r;
            mPaintColors[index][1] = g;
            mPaintColors[index][2] = b;
        }
    }

    /**
     *
     *
     * @param nearCount    需要查找周边像素的个数
     * @param targetPixels 色值表
     * @param currentPos   当前坐标
     * @return 是否查找到
     */
    private static boolean checkNearItemIsHit(int nearCount, int[][] targetPixels, Point currentPos) {
        //先初始化数据
        int length = nearCount * 2 + 1;
        int[][] state = new int[length][length];
        int verticalCount = targetPixels.length;
        int horizontalCount = targetPixels[0].length;

        Queue<Point> queue = new ArrayDeque<>(); //这个是应该查找的点的队列
        queue.offer(new Point(nearCount, nearCount)); //当前pos先入队
        state[nearCount][nearCount] = 1; //标记该点无效（已经被用过）
        while (!queue.isEmpty()) { //有任务未完成
            Point header = queue.poll(); //队头出队
            List<Point> directions = getCanArrivePos(state, header); //获取队头周边8个可到达的点 (注意是可到达，不包括已经走过的点)
            //遍历获取到的周边点
            for (int i = 0; i < directions.size(); i++) {
                Point direction = directions.get(i);
                //调整坐标
                int x = direction.x < length ? currentPos.x - direction.x : currentPos.x + direction.x;
                int y = direction.y < length ? currentPos.y - direction.y : currentPos.y + direction.y;
                //检查越界
                if (!isOutside(direction.x, direction.y, verticalCount, horizontalCount)
                        && !isOutside(x, y, verticalCount, horizontalCount)) {
                    //等于1表示查找到了匹配的点
                    if (targetPixels[y][x] == 1) {
                        return true;
                    }
                        //否则将这个点入队，需要查找这个点的周围
                    else {
                        queue.offer(direction);
                    }
                }
            }
        }
        //任务队列为空，且还没返回，自然是找不到了
        return false;
    }

    /**
     * 根据当前点获取周围8个相邻的点，如下：
     * 1 2 3
     * 4 * 5
     * 6 7 8
     *
     * @param state      状态映射表
     * @param currentPos 当前坐标点
     * @return 可以到达的像素点 (未被标记获取过的)
     */
    private static List<Point> getCanArrivePos(int[][] state, Point currentPos) {
        List<Point> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Point tmp = getNextPosition(currentPos, i);
            //检查下一个点是否越界
            if ((tmp.x > -1 && tmp.x < state.length) && (tmp.y > -1 && tmp.y < state.length))
                //检查这个点是否已经被标记过无效
            {
                if (state[tmp.y][tmp.x] != 1) {
                    result.add(tmp);
                    //标记该点无效
                    state[tmp.y][tmp.x] = 1;
                }
            }
        }
        return result;
    }

    /**
     * 根据当前点和方向获取下一个方向的点
     *
     * @param currentPos 当前坐标点
     * @param direction  要获取的方向
     * @return 对应的点
     */
    private static Point getNextPosition(Point currentPos, int direction) {
        Point result = new Point(currentPos.x, currentPos.y);
        switch (direction) {
            //左
            case 0:
                result.x -= 1;
                break;
            //上
            case 1:
                result.y -= 1;
                break;
            //下
            case 2:
                result.y += 1;
                break;
            //右
            case 3:
                result.x += 1;
                break;
            //左上
            case 4:
                result.x -= 1;
                result.y -= 1;
                break;
            //左下
            case 5:
                result.x -= 1;
                result.y += 1;
                break;
            //右上
            case 6:
                result.x += 1;
                result.y -= 1;
                break;
            //右下
            case 7:
                result.x += 1;
                result.y += 1;
                break;
        }
        return result;
    }

    /**
     * 检查目标pos是否越界
     */
    private static boolean isOutside(int x, int y, int verticalCount, int horizontalCount) {
        return x < 0 || y < 0 || x > horizontalCount - 1 || y > verticalCount - 1;
    }

    /**
     * 处理像素点的回调接口
     */
    private interface PixelColorHandler {
        void onHandle(Bitmap target, int index, int x, int y, int r, int g, int b);
    }

    public static class DiffInfo {
        public int srcPixelCount, //原图对应颜色像素点数
                targetPixelCount,//目标图对应颜色像素点数
                hitCount, //完全重合的像素点数
                nearCount, //相近的像素点数
                awayCount; //不匹配的像素点数
        public float similarityDegree; //自己计算的相似度

        public DiffInfo(int srcPixelCount, int targetPixelCount, int hitCount, int nearCount, int awayCount, float similarityDegree) {
            this.srcPixelCount = srcPixelCount;
            this.targetPixelCount = targetPixelCount;
            this.hitCount = hitCount;
            this.nearCount = nearCount;
            this.awayCount = awayCount;
            this.similarityDegree = similarityDegree;
        }

        @Override
        public String toString() {
            return String.format(Locale.getDefault(),
                    "similarityDegree: %s\tsrcPixelCount: %s\ttargetPixelCount: %s\thitCount: %s\tnearCount: %s\tawayCount: %s",
                    similarityDegree, srcPixelCount, targetPixelCount, hitCount, nearCount, awayCount);
        }
    }
}
