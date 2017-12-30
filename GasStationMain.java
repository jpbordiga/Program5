// JEFF BORDIGA
// 10/23/17
// PROGRAM05

// I know it doesn't work, these projects are harder than they used to be!

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class GasStationMain {

	private static final String OUTPUT = "output.txt.csv"; // output file
	
	public static void main(String[] args) {
		

		int inputSize = 0;
	
		
		Scanner inFile = null;
		
		String[] files = new String[3]; // list of input files is used for whole output file
		
		files[0] = "vehicle_3_25.txt";
		files[1] = "vehicle_5_25.txt";
		files[2] = "vehicle_5_100.txt";
		
		PrintWriter outputStream = null;
		
		try{
		
			outputStream = new PrintWriter(new FileOutputStream(OUTPUT));
			
			for(int i = 0; i < files.length; i++) { // iterating through each input file for each trial
				
				int numPumps = 0;
				
				try{
						
					inFile = new Scanner(new FileInputStream(files[i]));
					numPumps = inFile.nextInt();
					inputSize = inFile.nextInt(); // stuck in input size into file for convenience
					
					
				} catch(FileNotFoundException e){
					System.out.println("ERROR: unable to open file " + files[i]);
					System.exit(0);
				}
				
				MinPriorityQueue mPQ = new MinPriorityQueue();
				ArrayList<Vehicle> vehicles = createVehicles(inFile, inputSize);
				ArrayList<Vehicle> vehicleQueue = new ArrayList<>();
				
				Pump[] pumps = new Pump[numPumps];
				
				for(int a = 0; a < numPumps; a++) {
					
					Pump p = new Pump(i);
					pumps[a] = p;
					pumps[a].setPumpNumber(a + 1);
					
				}
				
				int cycles = 0;
				
				while(vehicleQueue.size() >= 0) { // main simulation
					
					if(cycles > 0) {
						
						for(int b = 0; b < numPumps; b++) {
							
							pumps[b].setCurrentVehicle(null);
							pumps[b].setAvailable(true);
							
						}
						
					}
					
					for(int c = 0; c < inputSize; c++) {
						
						if((vehicles.get(c).getArrivalTime() == cycles) && (vehicles.get(c).getInQueue() == false)) {
							mPQ.insert(vehicleQueue, vehicles.get(c));
							vehicles.get(c).setInQueue(true);
						}
						
					}
					
					for(int d = 0; d < numPumps; d++) {
						
						if((pumps[d].isAvailable() == true) && (d < vehicleQueue.size())) {
							
							if(vehicleQueue.get(d).getID() != "ID1997NULL") {
								pumps[d].setCurrentVehicle(vehicleQueue.get(d));
								pumps[d].setAvailable(false);
								vehicleQueue.get(d).setFueledAt(cycles);
								outputStream.println(vehicleQueue.get(d).getID() + ", " + vehicleQueue.get(d).getArrivalTime() + ", " + vehicleQueue.get(d).getFueledAt());
								mPQ.extractMin(vehicleQueue);
							}
							
						}
						
					}
					
					cycles++;
					
					if(vehicleQueue.size() == 1) {
						break;
					}
					
				}
				
				outputStream.println();
				
			}
			
			outputStream.close();
			
		} catch(FileNotFoundException e){
			System.out.println("ERROR: unable to open file " + OUTPUT);
			System.exit(0);
		}
		
	}
	
	public static ArrayList<Vehicle> createVehicles(Scanner iF, int iS) { // creates initial list of vehicles to be fed into the queue
		
		ArrayList<Vehicle> vehicles = new ArrayList<>(iS);
		
		for(int i = 0; i < iS; i++) {
			Vehicle v = new Vehicle(iF.next(), iF.nextInt(), iF.nextInt(), i);
			vehicles.add(v);
		}
		
		return vehicles;
		
	}
	

}
