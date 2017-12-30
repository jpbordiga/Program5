import java.util.ArrayList;

public class MinPriorityQueue implements MinPriorityQueueInterface {
	
	MinHeap mH;
	
	public MinPriorityQueue() {
		mH = new MinHeap();
	}

	@Override
	public void insert(ArrayList<Vehicle> cars, Vehicle v) {

		cars.add(0, v);
		
//		if(cars.size() == 0) { // couldn't get placing in terms of refuelPriority => arrivalTime to work
//			cars.add(0, v);
//		} else {
//		
//			for(int i = 0; i < cars.size(); i++) {
//				
//				if((cars.get(i).getRefuelPriority() < v.getRefuelPriority()) && (cars.get(i).getRefuelPriority() < v.getRefuelPriority())) {
//					
//				}
//				
//			}
//			
//		}
		
		mHInsert(cars, v.getKey());
		
	}
	
	@Override
	public void mHInsert(ArrayList<Vehicle> cars, int k) { //
		
		mH.setHeapsize(cars.size());
		
		if(cars.get(mH.getHeapsize() - 1).getID() != "ID1997NULL") {
			Vehicle maximumPlaceholder = new Vehicle("ID1997NULL", Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE); //
			cars.add(cars.size() - 1, maximumPlaceholder);
		}
		
		decreaseKey(cars, cars.size() - 1, k);
		
	}

	@Override
	public Vehicle minimum(ArrayList<Vehicle> cars) {
		return cars.get(0);
	}

	@Override
	public void extractMin(ArrayList<Vehicle> cars) {
		
		mHExtractMin(cars);
		cars.remove(minimum(cars));
		
	}
	
	@Override
	public Vehicle mHExtractMin(ArrayList<Vehicle> cars) { //
		
		if(cars.size() < 1) {
			System.out.println("ERROR: heap underflow");
			return null;
		}
		
		Vehicle min = cars.get(0);
		
		cars.set(0, cars.get(cars.size() - 1));
		mH.setHeapsize(cars.size());
		mH.minHeapify(cars, 0); //
		
		return min;
		
	}

	@Override
	public void decreaseKey(ArrayList<Vehicle> cars, int i, int k) { //
		
		if(k > cars.get(i).getKey()) {
			System.out.println("ERROR: new key > current key");
		}
	
		cars.get(i).setKey(k);
		
		while((i > 0) && (cars.get(mH.parent(i)).getKey() > cars.get(i).getKey())) {
			
			Vehicle placeHolder = cars.get(i);
			cars.set(i, cars.get(mH.parent(i)));
			cars.set(mH.parent(i), placeHolder);
			i = mH.parent(i);
			
		}
		
	}

}
