package pl.wipb.ztp.ps4;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

// baza danych - kolekcja Data
class Baza extends AbstractListModel<Data>{
    private List<Data> ar = new ArrayList<Data>();

    public void add(Data tab){
    	// TODO Auto-generated method stub
        ar.add(tab);
        fireIntervalAdded(tab, getSize(), getSize());
    }

    public void remove(int idx){
    	// TODO Auto-generated method stub
        ar.remove(idx);
        fireIntervalRemoved(listenerList, idx, idx);
    }

    public int getSize() {
    	// TODO Auto-generated method stub
		return ar.size();
    }

    public Data getElementAt(int index) {
    	// TODO Auto-generated method stub
		return ar.get(index);
    }
}