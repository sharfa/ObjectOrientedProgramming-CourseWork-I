
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterCarParkManager implements CarParkManager {
	private static Scanner sc = new Scanner(System.in);
	private ArrayList<Vehicle> vehicleList;
	private int noOfLots = 0;

	public static void main(String[] args) {

		WestminsterCarParkManager westminsterCarParkManager = new WestminsterCarParkManager();
		westminsterCarParkManager.vehicleList = new ArrayList<>(20);

		westminsterCarParkManager.Menu();
	}

	private void Menu() {
		System.out.println("");
		System.out.println("________________________________________________________");
		System.out.println();
		System.out.println("     WELCOME TO WESTMINSTER CAR PARK MANAGER SYSTEM    ");
		System.out.println();
		System.out.println("________________________________________________________");
		System.out.println();
		System.out.println("Car Parking Menus \n");
		System.out.println("Enter A : Add New Vehicle");
		System.out.println("Enter D : Delect Vehicle from Car Park");
		System.out.println("Enter L : List All Vehicles Currently Parked ");
		System.out.println("Enter P : Percentage of the Vehicles parked");
		System.out.println("Enter S : Search by Particular day");
		System.out.println("Enter C : Parking Charges");
		System.out.println("Enter X : Exit the menu");

		System.out.println();

		boolean continueAgain = true;
		// getting the selection
		while (continueAgain == true) {

			System.out.println("----------------------------------------------------------");
			System.out.println("");

			System.out.print("Enter your Menu: ");
			String selection = sc.next().toLowerCase();
			// checking the selection with user input
			if (selection.equals("a")) {
				addVehicle();
			} else if (selection.equals("d")) {
				deleteVehicle();
			} else if (selection.equals("s")) {
				searchByParticularDay();
			} else if (selection.equals("l")) {
				currentParkVehicle();
			} else if (selection.equals("c")) {
				displayParkingCharges();
			} else if (selection.equals("p")) {
				vehiclePercentage();
			} else if (selection.equals("x")) {
				System.out.println("\nThank you!\n");
				System.exit(0);
			} else {
				System.out.println("Check the Menu Again !!!");
			}
			System.out.println("");

			// prompting the user to enter yes or no
			System.out.print("Do you want to continue (yes/no): ");

			// initializing and declaring variable startAgain
			String startAgin = sc.next().toLowerCase();

			if (startAgin.equals("no")) {
				continueAgain = false;
			} else if (startAgin.equals("yes")) {
				continueAgain = true;
			} else {
				System.out.println("Invalid Input.!");
			}
		}
	}

	public void addVehicle() {

		System.out.println();
		System.out.println("Select the Type of the Vehicle ");
		System.out.println(" C = Car");
		System.out.println(" V = Van");
		System.out.println(" M = Matorbike");
		System.out.println();

		System.out.print("Enter Vehicle Type : ");
		String type = sc.next().toLowerCase();
		System.out.println();

		if ((type.equals("car") || (type.equals("van") || (type.equals("motorbike"))))) {

			System.out.print("Enter the ID plate No of the Vehicle : ");
			String idPlate = sc.next();
			System.out.println();

			if ((noOfLots < 20) || (noOfLots < 0)) {
				int year = 0, month = 0, minute = 0, day = 0, hour = 0;
				do {
					System.out.println("Enter Entrance Time =>  ");

					System.out.print("Enter hours :");
					hour = sc.nextInt();

					System.out.print("Enter minute: ");
					minute = sc.nextInt();
					System.out.println();

					System.out.println("Enter Entrance Date =>");
					System.out.print("Enter day: ");
					day = sc.nextInt();

					System.out.print("Enter month: ");
					month = sc.nextInt();

					System.out.print("Enter year: ");
					year = sc.nextInt();
					System.out.println();

					System.out.println("Entrance time: " + hour + ":" + minute);
					System.out.println("Entrance date: " + day + "-" + month + "-" + year);
					System.out.println();

				} while (hour < 00 || hour > 24 || minute < 00 || minute > 60 || month > 12 || month < 00 || day < 00
						|| day > 31 || year < 2011 || year > 2016);

				sc.nextLine();

				DateTime dateTime = new DateTime(day, month, year, hour, minute);

				System.out.print("Enter the Brand of the Vehicle : ");
				String brand = sc.next();

				if (type.equals("car")) {

					Car car = new Car();
					System.out.print("Enter the Color of the Car : ");
					// String color = sc.next();
					car.setColor(sc.next());

					System.out.print("Enter the  No of Doors of the Car : ");
					// int noOfDoors = sc.nextInt();
					car.setNoOfDoors(sc.nextInt());

					car.setDateTime(dateTime);
					car.setVehicleType(type);
					car.setIdPlate(idPlate);
					car.setBrand(brand);

					if (noOfLots < 20) {
						vehicleList.add(car);
						noOfLots++;
						System.out.println("Car was successfully added.");
					}

				} else if (type.equals("van")) {
					if (noOfLots < 19) {

						Van van = new Van();
						System.out.print("Enter the Cargo Volume of the Van : ");
						van.setCargoVolume(sc.nextDouble());

						van.setDateTime(dateTime);
						van.setVehicleType(type);
						van.setIdPlate(idPlate);
						van.setBrand(brand);

						if (noOfLots < 20) {
							vehicleList.add(van);
							noOfLots += 2;
							System.out.println("Van was successfully added.");
						}
					} else {
						System.out.println("Sorry there is only one available slot...");
					}

				} else if (type.equals("motorbike")) {

					Motorbike motorBike = new Motorbike();
					System.out.print("Enter the Engine Size of the Motorbike : ");

					motorBike.setEngineSize(sc.nextInt());

					motorBike.setDateTime(dateTime);
					motorBike.setVehicleType(type);
					motorBike.setIdPlate(idPlate);
					motorBike.setBrand(brand);

					if (noOfLots < 20) {
						vehicleList.add(motorBike);
						noOfLots++;
						System.out.println("MotorBike was successfully added.");
						System.out.println();
					}
				}

			} else {
				System.out.println("Sorry Parking is Only for Car, Van, Motobike.....");
			}
		} else {
			System.out.println("Sorry parking full...");
		}
		System.out.println();
		System.out.println("Available Parking Slots -> " + (20 - noOfLots));

	}

	public void deleteVehicle() {

		System.out.print("Enter ID Plate : ");
		String idPlate = sc.next();

		for (int i = 0; i < vehicleList.size(); i++) {
			if (idPlate.equals(vehicleList.get(i).getIdPlate())) {
				if (vehicleList.get(i).getVehicleType().equals("van")) {
					noOfLots = noOfLots - 2;
				} else {
					noOfLots--;
				}
				System.out.println(vehicleList.get(i).getVehicleType() + " is left from the car park");
				vehicleList.remove(i);
				System.out.println("Vehicle details are successfully delete!!");

			} else {
				System.err.println("Id Plate number entered is unavaliable");
			}

		}
	}

	public void searchByParticularDay() {
		System.out.println();
		int year = 0, month = 0, minute = 0, day = 0, hour = 0;
		do {
			System.out.println("Enter the entrance Time := ");
			System.out.print("Enter hours :");
			hour = sc.nextInt();

			System.out.print("Enter minute: ");
			minute = sc.nextInt();
			System.out.println();

			System.out.println("Enter the entrance Date := ");
			System.out.print("Enter day: ");
			day = sc.nextInt();

			System.out.print("Enter month: ");
			month = sc.nextInt();

			System.out.print("Enter year: ");
			year = sc.nextInt();
			System.out.println();
		} while (hour < 00 || hour > 24 || minute < 00 || minute > 60 || month > 12 || month < 00 || day < 00
				|| day > 31 || year != 2016);

		for (int i = 0; i < vehicleList.size(); i++) {
			if ((day == vehicleList.get(i).getDateTime().getDay())
					&& (month == vehicleList.get(i).getDateTime().getMonth())
					&& (year == vehicleList.get(i).getDateTime().getYear())
					&& (minute == vehicleList.get(i).getDateTime().getMinute())
					&& (hour == vehicleList.get(i).getDateTime().getHours())) {

				System.out.println("Vehicle parked Details ");
				System.out.println();
				System.out.println("Vehicle ID Plate : " + vehicleList.get(i).getIdPlate());
				System.out.println("Vehicle Brand : " + vehicleList.get(i).getBrand());
				System.out.println("Vehicle Type : " + vehicleList.get(i).getVehicleType());
			} else {
				System.out.println("Sorry vehicles are not parked...");
			}
		}
	}

	public void currentParkVehicle() {

		System.out.println("Currently Parked Vehicles ->");
		System.out.println();
		for (int i = vehicleList.size() - 1; i >= 0; i--) {

			System.out.println("Vehicle Type : " + vehicleList.get(i).getVehicleType());
			System.out.println("Vehicle ID Plate : " + vehicleList.get(i).getIdPlate());
			// System.out.println("Vehicle Brand : " +
			// vehicleList.get(i).getBrand());
			System.out.println("Vehicle entry time :- " + vehicleList.get(i).getDateTime().getHours() + ":"
					+ vehicleList.get(i).getDateTime().getMinute());
			System.out.println();
		}
		System.out.println("Available Parking Slots : " + (20 - noOfLots));
	}

	

	public void displayParkingCharges() {
		int minute = 0, hour = 0;
		do {
			System.out.print("Enter Current Time ( HH:MM ) : ");
			hour = sc.nextInt();
			minute = sc.nextInt();
		} while (hour < 00 || hour > 24 || minute < 00 || minute > 60);

		for (int i = 0; i < vehicleList.size(); i++) {
			int getHour = vehicleList.get(i).getDateTime().getHours();
			int getMinute = vehicleList.get(i).getDateTime().getMinute();

			int diffrentMinute;
			if (minute < getMinute) {
				diffrentMinute = 60 + minute - getMinute;
				if (hour == 00) {
					hour = 23;
				} else {
					hour--;
				}
			} else {
				diffrentMinute = minute - getMinute;
			}

			int diffrentHour;
			if (hour < getHour) {
				diffrentHour = hour + 24 - hour;
			} else {
				diffrentHour = hour - getHour;
			}

			int totalCost = 0;
			int x = 1;

			double hoursParked = Math.ceil(diffrentHour + (diffrentMinute * 1.0 / 60));

			if (hoursParked > 6) {
				totalCost = 30;
			} else {
				if (hoursParked > 3) {
					totalCost = 9;
					x = 4;
				}
			}
			for (; x <= hoursParked; x++) {
				if (hoursParked > 3) {
					totalCost += 3;
				} else {
					totalCost += 3;
				}
			}
			System.out.println("ID Plate No : " + vehicleList.get(i).getIdPlate());
			System.out.println("Charge : " + totalCost + "£");
		}
	}

}
