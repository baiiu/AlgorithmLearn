package com.baiiu;

/**
 * auther: baiiu
 * time: 17/4/9 09 21:01
 * description:
 * 堆排序：
 */
public class HeapSort {

    static void heapSort(int[] array) {
        if (array == null || array.length == 1) return;

        int i, size = array.length;

        /*
            1. 从末端子节点开始作调整，使得子节点永远小于父节点。
            2. 构造大顶堆
        */
        for (i = (size - 2) >> 2; i >= 0; --i) { // i = size/2即堆的末端子节点，从此开始调整堆，使得子节点永远小于父节点。
            heapAdjust(array, i, size - 1);
        }

        /*
            3. 交换堆顶元素和末尾元素，重新调整剩下元素为大顶堆
         */
        //for (i = size - 1; i > 0; --i) {
        //    CommonUtil.swap(array, 0, i);//将堆顶元素和末尾元素交换
        //
        //    heapAdjust(array, 0, i - 1);//将剩下的元素调整为大顶堆
        //}

    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len 未排序的堆（数组）的长度
     */
    private static void heapAdjust(int[] array, int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。

        if (li > len) { // 左子节点索引超出计算范围，直接返回。
            return;
        }

        if (ri <= len && array[ri] > array[li]) { // 先判断左右子节点，哪个较大。
            cMax = ri;
        }
        if (array[cMax] > array[index]) {
            CommonUtil.swap(array, cMax, index);      // 如果父节点被子节点调换，

            heapAdjust(array, cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

}
