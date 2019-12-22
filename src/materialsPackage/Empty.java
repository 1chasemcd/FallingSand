package materialsPackage;

import mainPackage.Grid;
import processing.core.PApplet;

public class Empty extends Material
{
    public Empty(PApplet sketch)
    {
        mColor = sketch.color(200, 200, 200);
    }

    public void move() {}
}
