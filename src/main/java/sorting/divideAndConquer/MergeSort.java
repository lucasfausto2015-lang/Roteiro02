package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array!= null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length ){
			int meio = leftIndex + (rightIndex - leftIndex) / 2;
			sort(array, leftIndex , meio);
			sort(array, meio+1, rightIndex);

			merge(array,leftIndex,rightIndex);

		}
	}

	private void merge(T[] array,int leftIndex, int rightIndex){

		int tamanhoDoArray = rightIndex - leftIndex;
		T[] helper = (T[]) new Comparable[tamanhoDoArray+1];

		for(int i = 0; i <= tamanhoDoArray;i++){
			helper[i] = array[leftIndex + i];
		}

		int meioArray = tamanhoDoArray / 2;

		int i = 0;
		int j = meioArray + 1;
		int k = leftIndex;

		while(i<= meioArray && j <= tamanhoDoArray){
			if(helper[i].compareTo(helper[j]) < 0){
				array[k] = helper[i];
				i++;
				k++;
			} else {
				array[k] = helper[j];
				j++;
				k++;
			}
		}

		while(i<=meioArray){
			array[k] = helper[i];
			k++;
			i++;
		}
	}

} 

class Main {
	public static void main(String[] args) {
		Integer[] array = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
		MergeSort<Integer> m = new MergeSort<Integer>();

		m.sort(array, 0,array.length);

		System.out.println(Arrays.toString(array));
	}
}
