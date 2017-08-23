package com.example;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/8/22 22 07:46
 * description:
 */
class Question38_NumberOfK {

    /**
     * 数字在排序数组中出现的次数
     * <p>
     * 统计一个数字在排序数组中出现的次数。
     * 例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，出现了4次。
     */
    static void test() {

        int[] arr = new int[]{1, 2, 2, 3, 3, 3, 3, 4, 5};
        int targetNumber = 3;

        countNumber(arr, targetNumber);
        countNumber2(arr, targetNumber);
        countNumber3(arr, targetNumber);
    }

    /*
        O(log n)
            使用二分查找确定第一个数字k和最后一个数字k的下标，即可得出
     */
    private static void countNumber3(int[] arr, int targetNumber) {
        if (CommonUtil.isEmpty(arr)) return;

        int firstK = getKIndex(arr, targetNumber, true);
        int endK = getKIndex(arr, targetNumber, false);

        if (firstK == -1 || endK == -1) {
            System.out.println(0);
            return;
        }

        System.out.println(endK - firstK + 1);
    }

    // 寻找第一个K和最后一个K的角标
    private static int getKIndex(int[] arr, int targetNumber, boolean first) {
        if (CommonUtil.isEmpty(arr)) return -1;

        int start = 0;
        int end = arr.length - 1;
        int k = 0;

        while (start <= end) {
            k = start + (end - start) / 2;

            if (arr[k] < targetNumber) {
                start = k + 1;
            } else if (arr[k] > targetNumber) {
                end = k - 1;
            } else {
                if (first) {
                    //相等
                    if (k - 1 > 0 && arr[k] == arr[k - 1]) {
                        end = k - 1;
                    } else {
                        break;
                    }
                } else {
                    if (k + 1 < arr.length - 1 && arr[k] == arr[k + 1]) {
                        start = k + 1;
                    } else {
                        break;
                    }
                }
            }
        }

        if (start > end) {
            return -1;
        }
        return k;
    }

    /*
            使用二分查找，确定一个后向前向后查找O(log n)
            如果数组全部都是一样的数字，那么最坏的情况也是O(n)
     */
    private static void countNumber2(int[] arr, int targetNumber) {
        if (CommonUtil.isEmpty(arr)) return;

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] < targetNumber) {
                start = mid + 1;
            } else if (arr[mid] > targetNumber) {
                end = mid - 1;
            } else {
                break;
            }
        }

        if (start > end) {
            System.out.println(0);
            return;
        }

        int count = 1;
        //从mid处开始向左、向右
        for (int i = mid - 1; i > 0; --i) {
            if (arr[i] == targetNumber) {
                ++count;
            } else {
                break;
            }
        }

        for (int i = mid + 1, length = arr.length; i < length; ++i) {
            if (arr[i] == targetNumber) {
                ++count;
            } else {
                break;
            }
        }

        System.out.println(count);

    }

    /*
        O(n),计算
     */
    private static void countNumber(int[] arr, int targetNumber) {
        if (CommonUtil.isEmpty(arr)) return;

        int count = 0;
        for (int i = 0, length = arr.length; i < length; ++i) {
            if (arr[i] == targetNumber) {
                ++count;
            }
        }

        System.out.println(count);
    }


}
