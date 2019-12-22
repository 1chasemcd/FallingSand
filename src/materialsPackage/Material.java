package materialsPackage;

import mainPackage.Grid;
import mainPackage.IVector;
import processing.core.PApplet;

public abstract class Material {
    public int mColor;
    PApplet sketch;
    IVector pos;

    public abstract void move();

    protected IVector getPos() {
        for (int x = 0; x < Grid.materials.length; x++)
        {
            for (int y = 0; y < Grid.materials[0].length; y++)
            {
                if (Grid.startMaterials[x][y] == this || Grid.materials[x][y] == this) {
                    return new IVector(x, y);
                }
            }
        }

        return new IVector(-1, -1);
    }
}
