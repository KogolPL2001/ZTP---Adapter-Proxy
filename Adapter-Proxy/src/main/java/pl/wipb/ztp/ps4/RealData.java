package pl.wipb.ztp.ps4;
// prosta implementacja danych - tablica
class RealData implements Data {
	private int[] Data;
	public RealData(int size) {
		// TODO Auto-generated constructor stub
		Data = new int[size];
	}

	public int get(int idx) {
		// TODO Auto-generated method stub
		return Data[idx];
	}

	public void set(int idx, int value) {
		// TODO Auto-generated method stub
		Data[idx]=value;
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return Data.length;
	}
    /* ... */
}