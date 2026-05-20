package sorting.divideAndConquer;

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
		if(array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex ){
			return;
		}

	
		if(array.length <= 1){
			return;
		}


		int midle = (leftIndex+rightIndex)/2;
		sort(array, leftIndex, midle);
		sort(array, midle+1, rightIndex);

		Merge(array, leftIndex, midle, rightIndex);

	}

	private void Merge(T[] array, int leftIndex, int midle, int rightIndex){

		int rightHelper = rightIndex - leftIndex;
		T[] arrayHelper = (T[]) new Comparable[rightHelper + 1];

		for(int i = 0; i <= rightHelper; i++){
			arrayHelper[i] = array[leftIndex + i];

		}

		int midleHelper = rightHelper / 2 ;

		int i = 0;
		int j = midleHelper +1;
		int k = leftIndex;

		while (i <= midleHelper && j<= rightHelper ) {

			if(arrayHelper[i].compareTo(arrayHelper[j]) < 0){
				array[k] = arrayHelper[i];
				i++;
			} else {
				array[k] = arrayHelper[j];
				j++;

			}

			k++;

			
		}


		while(i <= midleHelper){
			array[k] = arrayHelper[i];
			i++;
			k++;

		}



	}
} 
