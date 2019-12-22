package materialsPackage;

import mainPackage.Grid;
import mainPackage.IVector;
import processing.core.PApplet;

public class SandBlock extends Material{

    public SandBlock(PApplet sketch)
    {
        this.sketch = sketch;
        mColor = sketch.color(100, 100, 50);
    }

    public void move()
    {
        pos = new IVector(getPos());

        if (Grid.materials[pos.x][pos.y + 1] instanceof Empty ||
                Grid.materials[pos.x][pos.y + 1] instanceof Water)
        {
            Grid.materials[pos.x][pos.y + 1] = new Sand(sketch);

        }


    }
}
