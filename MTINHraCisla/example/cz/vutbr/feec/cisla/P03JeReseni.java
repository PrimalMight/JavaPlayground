package cz.vutbr.feec.cisla;

public class P03JeReseni {
	public static void main(String[] args) {
		HraciPole h = new HraciPole();
		System.out.println("" + h + h.jeReseni());
		
		System.out.println(); // odradkuj
		h.pohni(1);
		System.out.println("" + h + h.jeReseni());
	}
}
