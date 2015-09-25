import javax.swing.*;
	
import app.*;
	
public class KOTRApplication extends MultimediaApplication
{
    /**
     * The entry-point of the application
     *
     * @param args    The command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
       SwingUtilities.invokeAndWait(
          new KOTRApplication(args, 700, 800));
    }
	
    /**
     * Explicit Value Constructor
     *
     * @param args    The command-line arguments
     * @param width   The width of the content (in pixels)
     * @param height  The height of the content (in pixels)
     */
    public KOTRApplication(String[] args,
                                   int width, int height)
    {
       super(args, new KOTRApp(), width, height);
    }
}

