package com.hongwu.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序 Description
 * 
 * 每次冒出一个最大值
 * 
 * @author 01383184
 * @date 2018年12月27日上午9:56:42
 */
@SuppressWarnings("unused")
public class BubbleSort {

	public static void main(String[] args) {

		int[] array = new int[] { 9, 3, 4, 2, 1, 6, 7, 8, 5 };
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}

		System.out.println(Arrays.toString(array));
	}

	public static void swap(int[] array, int j, int i) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	/**
	 * 交换强化1
	 * 
	 * @param array
	 * @param j
	 * @param i
	 */
	public static void swapStrengthen1(int[] array, int j, int i) {
		array[i] = array[i] - array[j];
		array[j] = array[i] + array[j];
		array[i] = array[j] - array[i];
	}

	/**
	 * 交换强化2
	 * 
	 * @param array
	 * @param j
	 * @param i
	 */
	public static void swapStrengthen2(int[] array, int j, int i) {
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}

	/**
	 * 交换强化3
	 * 
	 * @param array
	 * @param j
	 * @param i
	 */

	public static void swapStrengthen3(int[] array, int j, int i) {
		array[i] = array[i] ^ array[j];
		array[j] = array[i] ^ array[j];
		array[i] = array[i] ^ array[j];
	}

}
