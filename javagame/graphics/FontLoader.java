package javagame.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontLoader
{
    public static Font fontLoader(String path, float size)
    {
        try
        {
            return Font.createFont(Font.TRUETYPE_FONT, new File(FontLoader.class.getResource(path).getPath())).deriveFont(Font.PLAIN, size); 
        }
        catch (FontFormatException | IOException e)
        {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }
}