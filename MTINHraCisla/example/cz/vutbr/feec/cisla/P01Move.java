package cz.vutbr.feec.cisla;

import cz.vutbr.feec.cisla.HraciPole;

/**
 *	Priklad jak vytvorit jednu pametovou polozku a provest pohyb.
 */
public class P01Move {
	public static void main(String[] args) {
		HraciPole p = new HraciPole();
		System.out.println(p);
		
		int NAHORU = 1;
		p.pohni(NAHORU);
		System.out.println(p);
	}
}
