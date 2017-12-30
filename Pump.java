
public class Pump {

	private int pumpNumber;
	private Vehicle currentVehicle;
	private boolean available;
	
	public Pump(int p) {
		
		pumpNumber = p;
		currentVehicle = null;
		available = true;
		
	}
	
	public int getPumpNumber() {
		return pumpNumber;
	}
	
	public Vehicle getCurrentVehicle() {
		return currentVehicle;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setCurrentVehicle(Vehicle v) {
		currentVehicle = v;
	}
	
	public void setAvailable(boolean a) {
		available = a;
	}
	
	public void setPumpNumber(int pN) {
		pumpNumber = pN;
	}
	
}
