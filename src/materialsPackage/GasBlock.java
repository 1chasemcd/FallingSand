package materialsPackage;

import mainPackage.Grid;
import mainPackage.IVector;
import processing.core.PApplet;

public class GasBlock extends Material {

    public GasBlock(PApplet sketch)
    {
        this.sketch = sketch;
        mColor = sketch.color(120, 170, 170);
    }

    public void move()
    {
        pos = new IVector(getPos());

        if (Grid.materials[pos.x][pos.y - 1] instanceof Empty)
        {
            Grid.materials[pos.x ][pos.y - 1] = new Gas(sketch);
        }


    }
}
