package csatt_projs_java_music_player;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LaunchPage implements ActionListener {
	
	public File currentFile;
	
	// new frame
	JFrame frame = new JFrame();
	
	//buttons
	JButton chooseFileButton = new JButton("Choose File");
	JButton playButton = new JButton("Play");
	
	//labels
	JLabel title = new JLabel();
	JLabel fileName = new JLabel();
	JLabel showName = new JLabel();
	
	LaunchPage() {
		
		//configure BUTTONS
		
		// ... chooseFileButton
		chooseFileButton.setBounds(150, 45, 100, 20); // x = 100, y = 160, width = 200, height = 40
		chooseFileButton.setFocusable(false);
		chooseFileButton.addActionListener(this);
		
		// ... playButton
		playButton.setBounds(150, 200, 100, 40);
		playButton.setFocusable(false);
		playButton.addActionListener(this);
		
		
		
		//configure LABELS
		
		// ... title
		title.setBounds(105, 2, 200, 40);
		title.setText("Java Music Player");
		title.setFont(new Font("Serif", Font.BOLD, 24));
		
		// ... fileName
		fileName.setBounds(95, 80, 200, 40);
		fileName.setFont(new Font("Sans-serif", Font.PLAIN, 14));
		
		// ... showName
		showName.setBounds(10, 80, 100, 40);
		showName.setText("File Name: ");
		showName.setFont(new Font("Sans-serif", Font.BOLD, 14));
		
		
		
		//add our elements to the frame we created
		
		// BUTTONS
		frame.add(chooseFileButton);
		frame.add(playButton);
		
		// LABELS
		frame.add(title);
		frame.add(fileName);
		frame.add(showName);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == chooseFileButton) {
			
			JFileChooser fileChooser = new JFileChooser();
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			
			if (response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				currentFile = file;
				String fileNameStr = fileChooser.getSelectedFile().getName();
				System.out.println(file);
				System.out.println(fileNameStr);
				
				fileName.setText(fileNameStr);
			}
			
		}
		
		if (e.getSource() == playButton) {
			
			String extension = "";

			int i = currentFile.getName().lastIndexOf('.');
			if (i > 0) {
			    extension = currentFile.getName().substring(i + 1);
			}
			
			if (extension.equals("wav")) {
				try {
					WavAudio wavAudio = new WavAudio(currentFile);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if (extension.equals("mp3")) {
				Mp3Audio mp3Audio = new Mp3Audio(currentFile);
			}
			
		}
		
	}

}
