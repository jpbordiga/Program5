import java.util.ArrayList;

public class MinHeap implements MinHeapInterface {

	private int heapsize = 0;
	
	public MinHeap() {
		//
	}
	
	@Override
	public void buildMinHeap(ArrayList<Vehicle> arr) {
		
		this.heapsize = arr.size();
		
		for(int i = ((arr.size()) / 2); i >= 0; i--) {
			minHeapify(arr, i);
		}
		
	}

	@Override
	public void minHeapify(ArrayList<Vehicle> arr, int i) {
		
		int l = left(i);
		int r = right(i);
		int smallest = 0;
		
		if((l <= heapsize) && (arr.get(l).getKey() > arr.get(i).getKey())) {
			smallest = l;
		} else {
			smallest = i;
		}
		
		if((r <= heapsize) && (arr.get(r).getKey() > arr.get(smallest).getKey())) {
			smallest = r;
		}
		
		if(smallest != i) {
			Vehicle placeHolder = arr.get(i);
			arr.set(i, arr.get(smallest));
			arr.set(smallest, placeHolder);
			minHeapify(arr, smallest);
		}
		
	}
	
	@Override
	public int parent(int i) {
		return i / 2;
	}

	@Override
	public int left(int i) {
		return 2 * i;
	}

	@Override
	public int right(int i) {
		return (2 * i) + 1;
	}

	public int getHeapsize() {
		return heapsize;
	}
	
	public void setHeapsize(int i) {
		heapsize = i;
	}
	
}
