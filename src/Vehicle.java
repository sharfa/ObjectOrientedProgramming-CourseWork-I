public abstract class Vehicle {
	public String vehicleType;
	private String idPlate;
	private String brand;
	private DateTime dateTime;

	
	public String getIdPlate() {
		return idPlate;
	}

	public void setIdPlate(String idPlate) {
		this.idPlate = idPlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public abstract String getVehicleType();

	public abstract void setVehicleType(String vehicleType);
}
