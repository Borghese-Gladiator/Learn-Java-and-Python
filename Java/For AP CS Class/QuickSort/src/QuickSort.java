
public class QuickSort 
{
	public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        quickSort(arr, 0, n-1);
        printArray(arr);
    }
	public static void printArray(int arr[])
    {
		System.out.println("Sorted Array");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	public static void quickSort(int[] arr, int begin, int end)
	{
		if (begin < end)
		{
			int pivot = findPivot(arr, begin, end);
			quickSort(arr, begin, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}	
	 }
	public static int findPivot(int[] array, int begin, int end)
	{
	int pivot = array[begin];
	int pivotIndex = begin;
	boolean switchGreater = true, switchLower = true;
	while(true) {
		switchGreater = true;
		switchLower = true;
		for(int i = end; i > pivotIndex; i--) {
			if(pivot > array[i]) {
				int temp = array[i];
				array[i] = pivot;
			array[pivotIndex] = temp;
				pivotIndex = i;
				switchGreater = false;
				break;
			}
		}
		for(int i = begin + 1; i < pivotIndex; i++) {
			if(pivot < array[i]) {
				int temp = array[i];
				array[i] = pivot;
				array[pivotIndex] = temp;
				pivotIndex = i;
				switchLower = false;
				break;
			}
		}
		if(switchGreater && switchLower)
			return pivotIndex;
		}
	}
}
