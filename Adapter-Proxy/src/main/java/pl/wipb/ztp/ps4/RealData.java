package pl.wipb.ztp.ps4;

import java.util.LinkedList;

// prosta implementacja danych - tablica
class RealData implements Data {
	private int[] Data;
	private LinkedList<Data> copies=null;
	public RealData(int size) {
		Data = new int[size];
		copies=new LinkedList<>();
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
    
	public Data copy()
	{
		Data copy = new ProxyCopy(this);
		copies.addLast(copy);
		return copy;
	}

	public void cutCopies()
	{
		for(Data d:copies)
			if(d instanceof ProxyCopy)
				((ProxyCopy)d).copying();
		copies.clear();
	}
}