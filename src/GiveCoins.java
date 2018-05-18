
public class GiveCoins {
	public static Coins go(int[] values, String[] names, int amount) {
		int point =0;
		Coins coinsUsed = new Coins(values.length);
		if(point<values.length && amount>=values[point]) {
			Coins a = go(values, names, amount, point+1);
			amount-=values[point];
			coinsUsed.add(point);
		}		
		return coinsUsed;
	}
	private static Coins go(int[] values, String[] names, int amount, int point) {
		Coins coinsUsed = new Coins(values.length);
		if(point<values.length && amount>=values[point]) {
			Coins a = go(values, names, amount, point+1);
			amount-=values[point];
			coinsUsed.add(point);
			coinsUsed.add(go(values, names, amount, point));
			coinsUsed=coinsUsed.compare(a);
		}
		else if(amount!=0) {
			coinsUsed.fail();
		}
		return coinsUsed;
	}
}
class Coins{
	private int[]coins;
	private int size = 0;
	private boolean valid = true;
	public Coins(int size) {
		coins = new int[size];
	}
	public void add(Coins add) {
		int[] temp = add.getCoins();
		for(int i=0;i<temp.length;i++) {
			while(temp[i]>0) {
				add(i);
			}
		}
	}
	public void fail() {
		valid=false;		
	}
	public void add(int location) {
		if(location<coins.length) {
			coins[location]++;
			size++;
		}
		else
			System.out.println("Error: Out of bounds.");
	}
	public int getSize() {
		return size;
	}
	public Coins compare(Coins a) {
		if(valid) {
			if(a.isValid()) {
				if(a.getSize()<size) {
					return this;
				}
				else
					return a;
			}
			else
				return this;
		}
		return a;
	}
	private boolean isValid() {
		return valid;
	}
	public int[] getCoins(){
		return coins;
	}
}
