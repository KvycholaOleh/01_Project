package ua.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "smartphones")
public class Item extends AbstractEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producer")
	private Producer producer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "model")
	private Model model;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "os")
	private Os os;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "color")
	private Color color;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_display")
	private TypeDisplay typeDisplay;
	private BigDecimal displaySize;
	private BigDecimal camera;
	private int batteryCapacity;
	private BigDecimal price;

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

	public BigDecimal getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(BigDecimal displaySize) {
		this.displaySize = displaySize;
	}

	public BigDecimal getCamera() {
		return camera;
	}

	public void setCamera(BigDecimal camera) {
		this.camera = camera;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

		
}
