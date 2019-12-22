package materialsPackage;

import mainPackage.Grid;
import mainPackage.IVector;
import processing.core.PApplet;

public class WaterBlock extends Material {
    public WaterBlock(PApplet sketch)
    {
        this.sketch = sketch;
        mColor = sketch.color(0, 170, 200);
    }

    public void move()
    {
        pos = new IVector(getPos());

        if (Grid.materials[pos.x][pos.y + 1] instanceof Empty)
        {
            Grid.materials[pos.x][pos.y + 1] = new Water(sketch);
        }
    }
}
