package materialsPackage;

import mainPackage.Grid;
import mainPackage.IVector;
import processing.core.PApplet;

public class MagicBlock extends Material{

    public MagicBlock(PApplet sketch)
    {
        this.sketch = sketch;
        mColor = sketch.color(160, 0, 0);
    }

    public void move()
    {
        pos = new IVector(getPos());

        int addX = 0, addY = 0;

        if (Grid.materials[pos.x][pos.y + 1] instanceof Empty)
        {
            addY = 1;
        }
        else if (Grid.materials[pos.x + 1][pos.y + 1] instanceof Empty &&
                Grid.materials[pos.x - 1][pos.y + 1] instanceof Empty)
        {
            addY = 1;
            if (Math.random() >= 0.5)
            {
                addX = -1;
            }
            else
            {
                addX = 1;
            }
        }
        else if (Grid.materials[pos.x + 1][pos.y + 1] instanceof Empty)
        {
            addY = 1;
            addX = 1;
        }
        else if (Grid.materials[pos.x - 1][pos.y + 1] instanceof Empty)
        {
            addY = 1;
            addX = -1;
        }
        else if (Grid.materials[pos.x + 1][pos.y] instanceof Empty &&
                Grid.materials[pos.x - 1][pos.y] instanceof Empty)
        {
            if (Math.random() >= 0.5)
            {
                addX = -1;
            }
            else
            {
                addX = 1;
            }
        }
        else if (Grid.materials[pos.x + 1][pos.y] instanceof Empty)
        {
            addX = 1;
        }
        else if (Grid.materials[pos.x - 1][pos.y] instanceof Empty)
        {
            addX = -1;
        }
        else if (Grid.materials[pos.x + 1][pos.y - 1] instanceof Empty &&
                Grid.materials[pos.x - 1][pos.y - 1] instanceof Empty)
        {
            addY = -1;

            if (Math.random() >= 0.5)
            {
                addX = -1;
            }
            else
            {
                addX = 1;
            }
        }
        else if (Grid.materials[pos.x + 1][pos.y - 1] instanceof Empty)
        {
            addX = 1;
            addY = -1;
        }
        else if (Grid.materials[pos.x - 1][pos.y - 1] instanceof Empty)
        {
            addX = -1;
            addY = -1;
        }
        else if (Grid.materials[pos.x][pos.y - 1] instanceof Empty)
        {
            addY = -1;
        }

        if (addX != 0 || addY != 0) {
            Grid.materials[pos.x + addX][pos.y + addY] = new Magic(sketch);
        }
    }
}
