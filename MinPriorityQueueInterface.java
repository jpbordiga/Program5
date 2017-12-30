import java.util.ArrayList;

public interface MinPriorityQueueInterface {

	public void insert(ArrayList<Vehicle> cars, Vehicle v);
	public void mHInsert(ArrayList<Vehicle> cars, int k); // types?
	public Vehicle minimum(ArrayList<Vehicle> cars);
	public void extractMin(ArrayList<Vehicle> cars);
	public Vehicle mHExtractMin(ArrayList<Vehicle> cars);
	public void decreaseKey(ArrayList<Vehicle> cars, int i, int k);
	
}
