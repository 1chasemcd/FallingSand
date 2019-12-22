package mainPackage;

// Use the processing library for graphics
import processing.core.PApplet;
import guiPackage.GUIManager;

public class FallingSandMain extends PApplet
{
    private Grid grid;
    private boolean toggle = true;
    private GUIManager buttons;

    public void settings() { size(1280, 778); }

    public void setup()
    {
        grid = new Grid(this, 128, 80);
        buttons = new GUIManager(this, width - 200, 20,
                "Empty", "Stone", "Water", "Sand", "Gas", "Magic",
                "Water Block", "Sand Block", "Gas Block", "Magic Block", "Clear");
        frameRate(20);
        noStroke();
        textSize(20);
    }

    public void draw()
    {
        grid.update();
        grid.show();
        buttons.show();
        grid.selected = buttons.getSelected();
        if (mousePressed && !buttons.clicked())
        {
            grid.place(mouseX, mouseY);
        }
    }

    public void mouseDragged()
    {
        if (!buttons.clicked())
        {
            grid.place(mouseX, mouseY);
        }
    }

    public void keyPressed()
    {
        if (key == ' ' && toggle) {
            grid.running = !grid.running;
            toggle = false;
        }

        if (keyCode == RIGHT)
        {
            grid.running = true;
            grid.update();
            grid.running = false;
        }
    }

    public void keyReleased()
    {
        if (key == ' ')
        {
            toggle = true;
        }
    }

    public static void main(String[] args) { PApplet.main("mainPackage.FallingSandMain"); }
}
