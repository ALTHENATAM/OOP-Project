import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class OptionsComponent extends JComponent implements MouseListener{

    private static BufferedImage playButton;
    private static BufferedImage helpButton;
    private static BufferedImage quitButton;
    private static BufferedImage aboutUs;

    private static BufferedImage backgroundImage;
    private static BufferedImage logo;
    SE se = new SE();


    public OptionsComponent() {
        addMouseListener(this);
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;


        try {
            backgroundImage = ImageIO.read(new File("images/background_2.png"));
            logo = ImageIO.read(new File("images/logo.png"));

            playButton = ImageIO.read(new File("images/play_button.png"));
            helpButton = ImageIO.read(new File("images/helpButton.png"));
            quitButton = ImageIO.read(new File("images/quitButton.png"));
            aboutUs = ImageIO.read(new File("images/aboutUs.png"));
        }
        catch(IOException e) {}
                   
        
        g2.drawImage(backgroundImage, 0, 0, 1140, 640, null);
        g2.drawImage(logo, 250, 0, 650, 250, null);

        g2.drawImage(helpButton, 600, 520, 160, 70, null);
        g2.drawImage(quitButton, 380, 520, 160, 70, null);
        g2.drawImage(playButton, 600, 400, 160, 70, null);
        g2.drawImage(aboutUs, 350, 385, 200, 110, null);


        
    }


    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        //quit button
        if(mouseX>= 380 && mouseX<=540 && mouseY>=520 && mouseY<=590) {
            System.exit(0);
        }


        //play button
        else if(mouseX>= 600 && mouseX<=760 && mouseY>=400 && mouseY<=470) {
            playSE("sounds/Wallpaper(chosic.com).wav");
            
            Tester.currentState = Tester.STATE.GAME;
            Tester.menuFrame.dispose();
            Tester.gameRefreshThread.start();
            Tester.gameCheckThread.start();
        }


        //help button
        else if(mouseX>= 600 && mouseX<=760 && mouseY>=520 && mouseY<=590) {
            JOptionPane.showMessageDialog(this, "1. GOAL: have a hand value closer to 21 than the dealer's hand without exceeding 21." +
                            "\n2. CARD VALUES:" +
                            "\n   - Face cards (King, Queen, Jack) are each worth 10 points." + 
                            "\n   - Aces can be worth either 1 or 11 points, depending on which value benefits the hand more." +
                            "\n3. THE DEAL: You are dealt two cards each, and the dealer receives 2 cards down (hole card)." +
                            "\n4. TURN:" +
                            "\n   - You can choose to \"hit\" if you do not have enough 14 points (take another card) or \"stand\" (keep your current hand)." +
                            "\n   - You can continue to hit until you decide to stand, or until your hand exceeds 21, resulting in a bust." +
                            "\n5. WINNING & LOSING:" +
                            "\n   - You win if your hand is under 21 points and greater than dealer's hand" +
                            "\n   - If you bust (exceeds 21), the dealer is under 21 points. Dealer will win game." +
                            "\n   - If the dealer busts, you win (if you do not over 21 points)." +
                            "\n   - If both the player (you) and dealer have the same hand value, it's a push (a tie), and your bet is returned." +
                            "\n6. BLACKJACK: If the player (you) or dealer is dealt 21 from the start (Ace & a 10-value card), player/dealer got a blackjack" , "BLACKJACK'S BASIC GAMEPLAY",
                    JOptionPane.INFORMATION_MESSAGE);                    
        }


        //about us button
        else if(mouseX>= 350 && mouseX<=550 && mouseY>=395 && mouseY<=465) {
            JOptionPane.showMessageDialog(this, "BlackJack (Xi Dach) - OOP Project-International University-VNU-HCM" +
                    "\nLê Xuân Tâm - ITDSIU21118  \n" +
                    "Nguyễn Nguyên Hiệu - ITDSIU21087   \n" +
                    "Nguyễn Ngọc Sang - ITDSIU21114", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }


    }

        //Play the sound effect  
    @SuppressWarnings("static-access")
    private void playSE(String Sound) {
        
        se.setFile(Sound);
        se.play();	
    }
    //Stop the music
    @SuppressWarnings("static-access")
    public void stopSE() {
        
        se.stop();}


    public void mouseExited(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

    }
}

