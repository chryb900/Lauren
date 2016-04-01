import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



/**
 * @author Cmaeorn Hryb & Matthew Creedmore
 *
 */
public class Sound 
{
	Clip clip;

	/**
	 * Constructor
	 */
	public Sound()
	{
		try 
		{
			// Creates sound
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("eatmyass.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}	

	/**
	 * Play music
	 */
	public void playMusic()
	{
		clip.start();
	}

	/**
	 * Stop music
	 */
	public void stopMusic()
	{
		clip.stop();
	}
}