package cz.vutbr.feec.cisla;

import java.util.Random;

import cz.vutbr.feec.cisla.HraciPole;

/**
 * Tento priklad demonstruje jak nahodne zamichat pocatecni reseni s pomoci
 * 10000 nahodnych tahu.
 */
public class P02Randomize {
	public static void main(String[] args) {
		HraciPole g = new HraciPole();
		Random rnd = new Random();
        int i;
		for (i = 0; i < 100000; i++) {
			// nahodne cislo 0 - 3
			int nahodne = rnd.nextInt(4);
			g.pohni(1 + nahodne);
		}
        System.out.println("provedlo se " + i + " tahů");
		System.out.println(g);
	}
}
