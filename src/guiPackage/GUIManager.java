package guiPackage;

import processing.core.*;

public class GUIManager
{
    private PApplet sketch;
    private SelectButton[] buttons;
    private SelectButton hideButton;
    private String lastSelected = "Empty";
    private PVector pos;

    public GUIManager(PApplet sketch, float startX, float startY, String... text)
    {
        this.sketch = sketch;
        this.pos = new PVector(startX, startY);
        this.hideButton = new SelectButton(this.sketch, startX,this.sketch.height - 50,"Hide");

        this.buttons = new SelectButton[text.length];

        for (int i = 0; i < text.length; i++)
        {
            buttons[i] = new SelectButton(this.sketch, pos.x, pos.y + i * 50, text[i]);
        }
    }

    public void show()
    {
        onlyOneSelect();
        checkForHide();

        for (SelectButton b : buttons)
        {
            b.show();
        }

        hideButton.show();
    }

    public String getSelected()
    {
        for (SelectButton b: buttons)
        {
            if (b.on)
            {
                return b.text;
            }
        }

        return "Empty";
    }

    private void onlyOneSelect()
    {
        for (SelectButton b1 : buttons)
        {
            if (b1.on && !b1.text.equals(lastSelected))
            {

                for (SelectButton b2 : buttons)
                {
                    if (b2.text.equals(lastSelected))
                    {
                        b2.on = false;
                    }
                }

                lastSelected = b1.text;
            }
        }
    }

    private void checkForHide()
    {
        if (hideButton.on)
        {
            hideButton.on = false;

            if (hideButton.text.equals("Hide"))
            {
                hideButton.text = "Show";

                for (SelectButton b : buttons)
                {
                    b.pos.x = -200;
                }
            }
            else
            {
                hideButton.text = "Hide";

                for (SelectButton b : buttons)
                {
                    b.pos.x = this.pos.x;
                }
            }
        }
    }

    public boolean clicked()
    {
        return (sketch.mouseX > pos.x && sketch.mouseX < pos.x + 150 &&
                sketch.mouseY > pos.y && sketch.mouseY < pos.y + buttons.length * 50) &&
                hideButton.text.equals("Hide") ||
               (sketch.mouseX > hideButton.pos.x - 20 && sketch.mouseX < hideButton.pos.x + 170 &&
                sketch.mouseY > hideButton.pos.y - 20);
    }
}
