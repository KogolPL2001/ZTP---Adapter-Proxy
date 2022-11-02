package pl.wipb.ztp.ps4;

// dane przechowywane w bazie
interface Data {
    public int get(int idx);
    public void set(int idx, int value);
    public int size();
}