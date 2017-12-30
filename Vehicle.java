
public class Vehicle {

	private String vehicleID;
	private int refuelPriority;
	private int arrivalTime;
	private int key;
	private boolean atPump;
	private Pump pumpUsing;
	private int fueledAt;
	private boolean inQueue;
	private boolean hasFueled;
	
	
	public Vehicle(String iD, int a, int p, int k) {
		
		vehicleID = iD;
		arrivalTime = a;
		refuelPriority = p;
		key = k;
		inQueue = false;
		hasFueled = false;
		
	}
	
	public String getID() {
		return vehicleID;
	}
	
	public int getRefuelPriority() {
		return refuelPriority;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getKey() {
		return key;
	}
	
	public boolean getAtPump() {
		return atPump;
	}
	
	public Pump getPump() {
		return pumpUsing;
	}
	
	public int getFueledAt() {
		return fueledAt;
	}
	
	public boolean getInQueue() {
		return inQueue;
	}
	
	public boolean getHasFueled() {
		return hasFueled;
	}
	
	public void setKey(int k) {
		key = k;
	}
	
	public void setPump(Pump p) {
		pumpUsing = p;
	}
	
	public void setFueledAt(int f) {
		fueledAt = f;
	}
	
	public void setInQueue(boolean q) {
		inQueue = q;
	}
	
	public void setHasFueled(boolean hF) {
		hasFueled = hF;
	}
	
}
