package mainPackage;

import materialsPackage.*;
import processing.core.PApplet;
import processing.core.PVector;

public class Grid
{
    private IVector size;
    private PVector pSize;
    public static Material[][] materials;
    public static Material[][] startMaterials;
    private PApplet sketch;
    boolean running = false;

    String selected = "Empty";

    Grid(PApplet sketch, int xSize, int ySize)
    {
        this.sketch = sketch;
        size = new IVector(xSize, ySize);
        pSize = new PVector((float) sketch.width / xSize, (float) sketch.height / ySize);

        materials = new Material[size.x][size.y];
        startMaterials = new Material[size.x][size.y];

        reset();

        setStartMaterials();
    }

    void update()
    {
        if (running)
        {
            setStartMaterials();

            for (int x = 1; x < size.x - 1; x++)
            {
                for (int y = 1; y < size.y - 1; y++)
                {
                    startMaterials[x][y].move();
                }
            }

            for (int x = 0; x < size.x; x++)
            {
                materials[x][0] = new Empty(sketch);
                materials[x][size.y - 1] = new Empty(sketch);
            }

            for (int y = 0; y < size.y; y++)
            {
                materials[0][y] = new Empty(sketch);
                materials[size.x - 1][y] = new Empty(sketch);
            }
        }

        if (selected == "Clear")
        {
            reset();
        }
    }

    void show()
    {
        for (int x = 0; x < size.x; x++)
        {
            for (int y = 0; y < size.y; y++)
            {
                sketch.fill(materials[x][y].mColor);
                sketch.stroke(materials[x][y].mColor);
                sketch.rect(x * pSize.x, y * pSize.y, pSize.x, pSize.y);
            }
        }
    }

    void place(int x, int y) {
        IVector pos = new IVector((int) Math.max(Math.min(x / pSize.x, size.x - 1), 0),
                (int) Math.max(Math.min(y / pSize.y, size.y - 1), 0));

        switch (selected) {
            case "Stone":
                materials[pos.x][pos.y] = new Stone(sketch);
                break;

            case "Water":
                materials[pos.x][pos.y] = new Water(sketch);
                break;

            case "Sand":
                materials[pos.x][pos.y] = new Sand(sketch);
                break;

            case "Gas":
                materials[pos.x][pos.y] = new Gas(sketch);
                break;

            case "Water Block":
                materials[pos.x][pos.y] = new WaterBlock(sketch);
                break;

            case "Gas Block":
                materials[pos.x][pos.y] = new GasBlock(sketch);
                break;

            case "Magic":
                materials[pos.x][pos.y] = new Magic(sketch);
                break;

            case "Magic Block":
                materials[pos.x][pos.y] = new MagicBlock(sketch);
                break;

            case "Sand Block":
                materials[pos.x][pos.y] = new SandBlock(sketch);
                break;

            default:
                materials[pos.x][pos.y] = new Empty(sketch);
                break;
        }
    }

    private void setStartMaterials()
    {
        for (int x = 0; x < materials.length; x++) {
            for (int y = 0; y < materials[0].length; y++) {
                startMaterials[x][y] = materials[x][y];
            }
        }
    }

    public void reset()
    {
        for (int x = 0; x < size.x; x++)
        {
            for (int y = 0; y < size.y; y++)
            {
                materials[x][y] = new Empty(sketch);
            }
        }
    }
}