
public class MartabakKlasik extends Martabak implements Discount{

	public MartabakKlasik(String type, String adonan, String size, String extraTopping, int qty, int choice) {
		super(type, adonan, "", size, extraTopping, 0, qty, choice);
		this.setPrice(calculatePrice());
	}

	@Override
	public double calculatePrice() {

		if (choice == 1) {
			name = "Martabak Coklat";
			if (size.equals("Regular")) {
				price = 25000;
			} else {
				price = 32000;
			}
		} else if (choice == 2) {
			name = "Martabak Keju";
			if (size.equals("Regular")) {
				price = 25000;
			} else {
				price = 32000;
			}
		} else if (choice == 3) {
			name = "Martabak Coklat Keju";
			if (size.equals("Regular")) {
				price = 35000;
			} else {
				price = 42000;
			}
		} else if (choice == 4) {
			name = "Martabak Kacang";
			if (size.equals("Regular")) {
				price = 25000;
			} else {
				price = 32000;
			}
		} else {
			name = "Martabak Coklat Keju Kacang";
			if (size.equals("Regular")) {
				price = 38000;
			} else {
				price = 45000;
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
			price = price - (price * d5);
		}
		else if(this.qty >= 20){
			price = price - (price * d10);
		}
	}

}
