package pl.wipb.ztp.ps4;

public class ProxyCopy implements Data{
    private Data original, copy;
    public ProxyCopy(Data original){
        this.original=original;
    }
    @Override
    public int get(int idx) {
        return copy!=null ? copy.get(idx) : original.get(idx);
    }
    @Override
    public void set(int idx, int value) {
        if(copy==null)
            original.cutCopies();
        copy.set(idx, value);
        
    }
    @Override
    public int size() {
        return copy!=null ? copy.size() : original.size();
    }
    @Override
    public Data copy() {
        return copy!= null ? copy.copy() : original.copy();
    }

    @Override
    public void cutCopies(){
        if(copy!=null)
            copy.cutCopies();
        original.cutCopies();
    }

    public void copying(){
        if(copy!=null) return;
        copy=new RealData(original.size());
        for(int i=0;i<original.size();i++)
        {
            copy.set(i, original.get(i));
        }
        original=null;
    }
    
}
