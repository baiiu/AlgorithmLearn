package com.baiiu.sort;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/4/9 09 21:01
 * description:
 * 堆排序：
 */
class HeapSort {

    static void heapSort(int[] array) {
        if (array == null || array.length == 1) return;

        int i, size = array.length;

        /*
            1. 从末端子节点开始作调整，使得子节点永远小于父节点。
            2. 构造大顶堆
        */

        // i = (lastLeftIndex - 1) / 2 = (size -2) /2即堆的末端子节点，
        // 从末子节点往上开始调整堆，使得子节点永远小于父节点。
        for (i = (size - 2) >> 2; i >= 0; --i) {
            //maxHeapify(array, i, size);
            //maxHeapify2(array, i, size);
            maxHeapify3(array, i, size);
        }

        /*
            3. 交换堆顶元素和末尾元素，重新调整剩下元素为大顶堆
         */
        for (i = size; i > 0; --i) {
            CommonUtil.swap(array, 0, i);//将堆顶元素和末尾元素交换

            //maxHeapify(array, 0, i);//将剩下的元素调整为大顶堆
            //maxHeapify2(array, 0, i);//将剩下的元素调整为大顶堆
            maxHeapify3(array, 0, i);//将剩下的元素调整为大顶堆
        }

    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     * 使array[index...len]成为大顶堆
     *
     * 使用递归
     *
     * @param index 需要堆化处理的数据的索引
     * @param len 未排序的堆（数组）的长度,注意处理下标
     */
    private static void maxHeapify(int[] array, int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。

        if (li > len - 1) { // 左子节点索引超出计算范围(数组长度)，直接返回。
            // 这种情况是指已经进入到叶子节点了，非叶子节点必定是有左孩子的。
            return;
        }

        //选择最大的节点的下标
        if (ri < len && array[ri] > array[li]) { // 右子节点在数组内 && 并先判断左右子节点，哪个较大。
            cMax = ri; //两个子节点哪个大
        }

        if (array[cMax] > array[index]) { //子节点大于跟节点，不大顶堆的定义，调换
            CommonUtil.swap(array, cMax, index);      // 如果父节点被子节点调换，

            maxHeapify(array, cMax, len);  // cMax已被换为最大子节点的下标，需要继续判断换下后的父节点是否符合堆的特性。这样就可以不断调整
        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     * 使array[index...len]成为大顶堆
     *
     * 使用循环
     *
     * @param index 需要堆化处理的数据的索引。
     * 构造大顶堆时，挨个传入进来的就是末尾非叶子节点的index，开始调整此index到length间的数组，使其成为大顶堆
     * 进行堆排序时，传入进来的始终是0，len传入的却是length- 1 - i，调整从0到length- 1 - i间的数组，使成为大顶堆
     * <br />
     * @param len 未排序的堆（数组）的长度，始终传的是要排序数组的length。
     */
    private static void maxHeapify2(int[] array, int index, int len) {
        //遍历所有的非叶子节点
        //以末尾的非叶子节点开始调整，逐个往上、从右往左挨个进行调整，找到合适的位置，将记录进行互换

        int li, ri, iMax;

        while (true) {
            li = (index << 1) + 1;//左子节点下标
            ri = li + 1; //右子节点下标

            iMax = li;//最大值角标，默认为li

            if (li > len - 1) {
                // 已经是叶子节点，其左孩子不存在
                break;
            }

            if (ri < len && array[ri] > array[li]) {
                //右孩子大于左孩子
                iMax = ri;
            }

            if (array[iMax] > array[index]) {
                //孩子节点大于父节点，交换，对该子节点再进行重排
                CommonUtil.swap(array, iMax, index);
                index = iMax;
            } else {
                break; // 不用交换
            }

        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     * 使array[index...len]成为大顶堆
     *
     * 使用循环，好理解的写法
     *
     * @param index 需要堆化处理的数据的索引。
     * 构造大顶堆时，挨个传入进来的就是末尾非叶子节点的index，开始调整此index到length间的数组，使其成为大顶堆
     * 进行堆排序时，传入进来的始终是0，len传入的却是length- 1 - i，调整从0到length- 1 - i间的数组，使成为大顶堆
     * <br />
     * @param len 未排序的堆（数组）的长度，始终传的是要排序数组的length。
     */
    private static void maxHeapify3(int[] array, int index, int len) {
        int li, ri, iMax;

        while (true) {
            li = (index << 1) + 1;
            ri = li + 1;
            iMax = index;

            if (li < len && array[li] > array[iMax]) {
                iMax = li;
            }

            if (ri < len && array[ri] > array[iMax]) {
                iMax = ri;
            }

            if (iMax == index) {
                // 说明当前小树就是堆，不用重排
                break;
            } else {
                CommonUtil.swap(array, iMax, index);
                index = iMax;
            }

        }
    }

}
