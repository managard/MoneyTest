
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
		}		
		return coinsUsed;
	}
}
class Coins{
	private int[]coins;
	private int size = 0;
	public Coins(int size) {
		coins = new int[size];
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
}
