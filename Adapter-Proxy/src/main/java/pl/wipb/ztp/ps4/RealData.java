package pl.wipb.ztp.ps4;
// prosta implementacja danych - tablica
class RealData implements Data {
	private int[] Data;
	public RealData(int size) {
		Data = new int[size];
	}

	public int get(int idx) {
		return Data[idx];
	}

	public void set(int idx, int value) {
		Data[idx]=value;
	}

	public int size() {
		return Data.length;
	}
    /* ... */
}