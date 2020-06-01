
public class MartabakBuah extends Martabak implements Discount{

	public MartabakBuah(String type, String adonan, String size, String extraTopping, int qty, int choice) {
		super(type, adonan, "", size, extraTopping, 0, qty, choice);
		this.setPrice(calculatePrice());
	}

	@Override
	public double calculatePrice() {
		if (choice == 1) {
			name = "Martabak Kismis";
			if (size.equals("Regular")) {
				price = 32000;
			} else {
				price = 39000;
			}
		} else if (choice == 2) {
			name = "Martabak Pisang";
			if (size.equals("Regular")) {
				price = 32000;
			} else {
				price = 39000;
			}
		} else if (choice == 3) {
			name = "Martabak Durian";
			if (size.equals("Regular")) {
				price = 35000;
			} else {
				price = 42000;
			}
		} else if (choice == 4) {
			name = "Martabak Srikaya";
			if (size.equals("Regular")) {
				price = 36000;
			} else {
				price = 43000;
			}
		} else {
			name = "Martabak Jagung Keju";
			if (size.equals("Regular")) {
				price = 37000;
			} else {
				price = 44000;
			}
		}

		if (extraTopping.equals("Yes")) {
			price += 5000;
		}

		discount();

		return price;
	}

	@Override
	public void discount() {
		if(this.qty >= 10){
			price = price - (price * d3);
		}
		else if(this.qty >= 20){
			price = price - (price * d7);
		}
	}

}
