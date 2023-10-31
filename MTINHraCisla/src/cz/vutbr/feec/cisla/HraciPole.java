package cz.vutbr.feec.cisla;

import java.util.ArrayList;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class HraciPole implements Comparable<HraciPole>{
	private int[][] data = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, -1 } };
	private int x = 2;
	private int y = 2;
	private ArrayList<Integer> pohyby = new ArrayList<Integer>();

	public ArrayList<Integer> getPohyby() {
        return pohyby;
    }

    public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	public HraciPole klonujAPohni(int smer) {
		HraciPole nove = new HraciPole();
		nove.x = this.x;
		nove.y = this.y;
		nove.pohyby.addAll(this.pohyby);
		nove.pohyby.add(smer);
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				nove.data[x][y] = this.data[x][y];
			}
		}

		boolean jeMozny = nove.pohni(smer);
		if (jeMozny) {
			return nove;
		} else {
			return null;
		}
	}

	public boolean jeReseni() {
		int[][] groundTruth = {{1,4,7},{2,5,8},{3,6,-1}};
		for (int iy = 0; iy < 3; iy++) {
			for	(int ix = 0; ix < 3; ix++) {
				if (data[ix][iy] != groundTruth[ix][iy]) {
					return false;
				}
			}
		}
		return true; 
	}

	public boolean pohni(int smer) {
		switch (smer) {
		case UP:
			// nahoru
			if (y < 1) {
				return false;
			}
			data[x][y] = data[x][y - 1];
			data[x][y - 1] = -1;
			y = y - 1; // y--;
			return true;
		case DOWN:
			// nahoru
			if (y > 1) {
				return false;
			}
			data[x][y] = data[x][y + 1];
			data[x][y + 1] = -1;
			y++; // y = y + 1;
			return true;
		case LEFT:
			// nahoru
			if (x < 1) {
				return false;
			}
			data[x][y] = data[x - 1][y];
			data[x - 1][y] = -1;
			x = x - 1; // y--;
			return true;
		case RIGHT:
			if (x > 1) {
				return false;
			}
			data[x][y] = data[x + 1][y];
			data[x + 1][y] = -1;
			x++; // y = y + 1;
			return true;
		}
		return false;
	}

    @Override
    public boolean equals(Object comp){
        if(comp == null){
            return false;
        }
        if(comp == this){
            return true;
        }
        if(comp.getClass() != this.getClass()){
            return false;
        }
        HraciPole other = (HraciPole) comp;
        if(other.x != this.x || other.y != this.y){
            return false;
        }
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(other.data[x][y] != this.data[x][y]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder(17, 31).append(x).append(y).append(data).toHashCode(); //TODO: slide 17
    }

    @Override
    public int compareTo(HraciPole other){
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(other.data[x][y] < this.data[x][y]){
                    return -1;
                }
                else if(other.data[x][y] > this.data[x][y]){
                    return 1;
                }
            }
        }
        return 0;
    }

	@Override
	public String toString() {
		String res = "pohyby:" + pohyby + "\n";
		for (int iy = 0; iy < 3; iy++) {
			for (int ix = 0; ix < 3; ix++) {
				res += data[ix][iy] + ",";
			}
			res += "\n";
		}
		return res;
	}
}
