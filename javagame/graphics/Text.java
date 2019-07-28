package javagame.graphics;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

public class Text
{
    public static void drawString(Graphics graphics, String text, int x, int y, boolean center, Color c, Font font)
    {
        graphics.setColor(c);
        graphics.setFont(font);

        if (center)
        {
            FontMetrics fm = graphics.getFontMetrics(font);
            int center_x = x - fm.stringWidth(text) / 2;
            int center_y = (y - fm.getHeight() / 2) + fm.getAscent();

            graphics.drawString(text, center_x, center_y);
            return;
        }

        graphics.drawString(text, x, y);
    }
}