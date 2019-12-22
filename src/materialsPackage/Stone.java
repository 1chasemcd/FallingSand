package materialsPackage;

import mainPackage.Grid;
import processing.core.PApplet;

public class Stone extends Material
{
    public Stone(PApplet sketch)
    {
        mColor = sketch.color(60, 30, 30);
    }

    public void move() {}
}
