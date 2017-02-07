package dto.form;


import ua.entity.Color;
import ua.entity.Model;
import ua.entity.Os;
import ua.entity.Producer;
import ua.entity.TypeDisplay;

public class ItemForm {
	private int id;
	private Producer producer;
	private Model model;
	private Os os;
	private Color color;
	private TypeDisplay typeDisplay;
	private String displaySize;
	private String camera;
	private String batteryCapacity;
	private String price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public Os getOs() {
		return os;
	}
	public void setOs(Os os) {
		this.os = os;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public TypeDisplay getTypeDisplay() {
		return typeDisplay;
	}
	public void setTypeDisplay(TypeDisplay typeDisplay) {
		this.typeDisplay = typeDisplay;
	}
	public String getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
