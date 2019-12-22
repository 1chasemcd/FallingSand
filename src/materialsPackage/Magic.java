package materialsPackage;

import processing.core.PApplet;
import mainPackage.IVector;
import mainPackage.Grid;

public class Magic extends Material
{
    public Magic(PApplet sketch)
    {
        this.sketch = sketch;
        mColor = sketch.color(200, 20, 20);
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

        if (addX == 0 && addY == 0 && !(Grid.startMaterials[pos.x][pos.y - 1] instanceof MagicBlock)) {
            addY = -1;

        }

        Grid.materials[pos.x + addX][pos.y + addY] = new Magic(sketch);

        if (!currentPosDifferent())
        {
            Grid.materials[pos.x][pos.y] = new Empty(sketch);
        }
    }

    private boolean currentPosDifferent()
    {
        return Grid.materials[pos.x][pos.y] != Grid.startMaterials[pos.x][pos.y];
    }
}

