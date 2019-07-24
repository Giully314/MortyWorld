package javagame.utility;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Utility
{
    public static String loadFileAsString(String path)
    {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(new FileReader(Utility.class.getResource(path).getPath())))
        {
            String line;
            
            while ((line = buffer.readLine()) != null)
            {
                builder.append(line + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return builder.toString();
    }


    public static int parseInt(String number)
    {
        try
        {
            return Integer.parseInt(number);
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}