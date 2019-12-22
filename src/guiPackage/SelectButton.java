package guiPackage;

import processing.core.*;

class SelectButton
{
    private PApplet sketch;
    PVector pos;
    String text;
    boolean on = false;
    private boolean toggle = true;

    SelectButton(PApplet sketch, float x, float y, String text)
    {
        this.sketch = sketch;
        this.pos = new PVector(x, y);
        this.text = text;
    }

    void show()
    {
        sketch.stroke(0);
        if (on)
        {
            sketch.fill(150);
        }
        else
        {
            sketch.fill(255);
        }

        sketch.rect(pos.x, pos.y, 150, 25);
        sketch.noStroke();

        sketch.fill(0);
        sketch.text(text, pos.x, pos.y + 20);
        sketch.fill(0);

        if (sketch.mousePressed && (sketch.mouseX > pos.x && sketch.mouseX < pos.x + 150
                && sketch.mouseY > pos.y && sketch.mouseY < pos.y + 25) && toggle)
        {
            toggle = false;
            on = !on;
        }

        if (!sketch.mousePressed)
        {
            toggle = true;
        }
    }
}
