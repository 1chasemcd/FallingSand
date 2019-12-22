package mainPackage;

public class IVector {

    public int x;
    public int y;

    public IVector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public IVector(IVector iv)
    {
        this.x = iv.x;
        this.y = iv.y;
    }
}
