package com.hongwu.algorithm.sort;

/**
 * 
 * Description
 * 
 * 先取一中间值,将一数组拆分成两个数组,左数组比中间值小，右数组比中间值大。 再针对两数组直到拆成最小
 * 
 * 
 * @author 01383184
 * @date 2018年12月27日上午10:35:33
 */

public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[] { 9, 3, 4, 2, 1, 6, 7, 8, 5 };

		int left = 0;
		int right = array.length;
		int middle = array[left];

		while (left < right) {

			while (right-- > left && array[right] < middle) {
				break;
			}

			while (left++ < right && array[left] > middle) {
				break;
			}
			
			if(left<right){
				BubbleSort.swap(array, left, right);
			}
			
		}
		
		

	}

}
