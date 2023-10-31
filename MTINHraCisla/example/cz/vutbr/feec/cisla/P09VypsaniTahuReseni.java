package cz.vutbr.feec.cisla;

public class P09VypsaniTahuReseni {
	public static void main(String[] args) {
		HraciPole h = new HraciPole();
		System.out.println("" + h + h.jeReseni());
		
		System.out.println(); // odradkuj
		h = h.klonujAPohni(1);
		h = h.klonujAPohni(2);
		h = h.klonujAPohni(3);
		System.out.println("" + h + h.jeReseni());
	}
}
