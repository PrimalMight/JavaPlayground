package cz.vutbr.feec.cisla;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class BFS {
	public void vypisTahy(HraciPole zadani) {
		
		// TIP: Vyzkousejte s ruznyma strukturama
		HashSet<HraciPole> closed = new HashSet<HraciPole>();
		// TreeSet<HraciPole> closed = new TreeSet<HraciPole>();
		// LinkedList<HraciPole> closed = new LinkedList<HraciPole>();

    
    
        boolean cont = true;
        LinkedList<HraciPole> fronta = new LinkedList<HraciPole>();
        fronta.addLast(zadani);

        while(cont){
            if(fronta.isEmpty()){
            System.out.println("Konec, reseni neexistuje");
            cont = false;
        } 
        else {
            HraciPole tmp = fronta.removeFirst();
            if(tmp.jeReseni()){
                System.out.println("Reseni nalezeno");
                System.out.println(tmp);
                System.out.println("Pocet tahu: " + tmp.getPohyby().size());
                cont = false;
            }
            else {
                closed.add(tmp);
                for(int i = 1; i <= 4; i++){
                    HraciPole nove = tmp.klonujAPohni(i);
                    if(nove != null && !closed.contains(nove)){
                        fronta.addLast(nove);
                    }
                }
            }
        }
        }
        
    }
}
