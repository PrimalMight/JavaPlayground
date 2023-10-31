package cz.vutbr.feec.cisla;

public class P04KlonovaniPameti2 {
	public static void main(String[] args) {
		HraciPole g = new HraciPole();
		System.out.println("Original: \n" + g);

		for (int i = 1; i <= 4; i++) {
			HraciPole g3 = g.klonujAPohni(i);
            if(g3 != null){ // TODO: vypis pouze možných tahů (slide 13)
                System.out.println("Kopie s pohybem " + i + " je: \n" + g3);
            }
		}
	}
}
