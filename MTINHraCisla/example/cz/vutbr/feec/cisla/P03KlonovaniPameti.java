package cz.vutbr.feec.cisla;

public class P03KlonovaniPameti {
	public static void main(String[] args) {
		HraciPole g = new HraciPole();
		System.out.println("Original: \n" + g);

		int nahoru = 1;

		HraciPole g3 = g.klonujAPohni(nahoru);
		/*
		 * // Vyzkousejte nahradit timto kodem predchozi radek a pozorujte efekt
		 * HraciPole g3 = g;
		 * g3.pohni(nahoru);
		 */
		System.out.println("Kopie s pohybem " + nahoru + " je: \n" + g3);
	}
}
