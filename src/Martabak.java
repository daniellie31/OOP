
public abstract class Martabak {
	protected String type;
	protected String adonan;
	protected String name;
	protected String size;
	protected String extraTopping;
	protected double price;
	protected int qty;
	protected int choice;

	public abstract double calculatePrice();

	public Martabak(String type, String adonan, String name, String size, String extraTopping, double price, int qty, int choice) {
		super();
		this.type = type;
		this.adonan = adonan;
		this.name = name;
		this.size = size;
		this.extraTopping = extraTopping;
		this.price = price;
		this.qty = qty;
		this.choice = choice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdonan() {
		return adonan;
	}

	public void setAdonan(String adonan) {
		this.adonan = adonan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getExtraTopping() {
		return extraTopping;
	}

	public void setExtraTopping(String extraTopping) {
		this.extraTopping = extraTopping;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

}
