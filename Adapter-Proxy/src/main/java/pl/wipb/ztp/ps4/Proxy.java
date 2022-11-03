package pl.wipb.ztp.ps4;

public class Proxy implements Data{
    private RealData data;
    private int size;
    public Proxy(int size)
    {
        this.size=size;
    }
    @Override
    public int get(int idx) {
        return data==null ? 0 : data.get(idx);
    }
    @Override
    public void set(int idx, int value) {
        if(data==null)
            data=new RealData(size);
        data.set(idx, value);
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public Data copy() {
        if(data==null){
            data=new RealData(size);
        }
        return data.copy();
    }
    @Override
    public void cutCopies() {
        if(data==null)
            return;
        else
            data.cutCopies();
    }

    
}
