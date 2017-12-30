import java.util.ArrayList;

public interface MinHeapInterface {

	public void buildMinHeap(ArrayList<Vehicle> arr);
	public void minHeapify(ArrayList<Vehicle> arr, int i);
	public int parent(int i);
	public int left(int i);
	public int right(int i);

}
