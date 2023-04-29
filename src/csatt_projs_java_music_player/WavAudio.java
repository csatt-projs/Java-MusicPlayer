package csatt_projs_java_music_player;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class WavAudio {

	public WavAudio(File currentFile) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Scanner scanner = new Scanner(System.in);
		
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(currentFile);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
		
		String response = scanner.next();
		
	}

}
