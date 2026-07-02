import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class task2 extends JFrame implements ActionListener {

    JLabel titleLabel, guessLabel, resultLabel, attemptsLabel;
    JTextField guessField;
    JButton guessButton, playAgainButton, exitButton;

    Random random = new Random();
    int randomNumber;
    int attempts;

    public task2() {

        randomNumber = random.nextInt(100) + 1;
        attempts = 0;

        setTitle("Guess The Number");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(new Color(30,30,30));

        titleLabel = new JLabel("🎯 Guess The Number");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(150,30,300,40);
        add(titleLabel);

        guessLabel = new JLabel("Enter a number (1 - 100)");
        guessLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        guessLabel.setForeground(Color.WHITE);
        guessLabel.setBounds(180,90,250,30);
        add(guessLabel);

        guessField = new JTextField();
        guessField.setBounds(175,130,220,40);
        guessField.setFont(new Font("Arial", Font.BOLD,18));
        add(guessField);

        guessButton = new JButton("Guess");
        guessButton.setBounds(220,190,120,40);
        guessButton.addActionListener(this);
        add(guessButton);

        resultLabel = new JLabel("New Game Started!",SwingConstants.CENTER);
        resultLabel.setForeground(Color.YELLOW);
        resultLabel.setFont(new Font("Arial",Font.BOLD,18));
        resultLabel.setBounds(100,250,400,30);
        add(resultLabel);

        attemptsLabel = new JLabel("Attempts : 0",SwingConstants.CENTER);
        attemptsLabel.setForeground(Color.WHITE);
        attemptsLabel.setFont(new Font("Arial",Font.PLAIN,18));
        attemptsLabel.setBounds(170,290,250,30);
        add(attemptsLabel);

        playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(140,360,130,40);
        playAgainButton.addActionListener(this);
        add(playAgainButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(330,360,130,40);
        exitButton.addActionListener(this);
        add(exitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==guessButton){

            try{

                int guess = Integer.parseInt(guessField.getText());

                if(guess<1 || guess>100){
                    JOptionPane.showMessageDialog(this,"Enter number between 1 and 100");
                    return;
                }

                attempts++;
                attemptsLabel.setText("Attempts : "+attempts);

                if(guess==randomNumber){

                    resultLabel.setForeground(Color.GREEN);
                    resultLabel.setText("Congratulations! Correct Guess!");

                    JOptionPane.showMessageDialog(this,
                            "You guessed correctly in "+attempts+" attempts.");

                }

                else if(guess<randomNumber){

                    resultLabel.setForeground(Color.ORANGE);
                    resultLabel.setText("Too Low!");

                }

                else{

                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Too High!");

                }

            }

            catch(Exception ex){

                JOptionPane.showMessageDialog(this,"Please enter a valid number.");

            }

        }

        if(e.getSource()==playAgainButton){

            randomNumber = random.nextInt(100)+1;
            attempts=0;

            attemptsLabel.setText("Attempts : 0");
            resultLabel.setForeground(Color.YELLOW);
            resultLabel.setText("New Game Started!");
            guessField.setText("");

        }

        if(e.getSource()==exitButton){

            System.exit(0);

        }

    }

    public static void main(String args[]){

        new task2();

    }

}
