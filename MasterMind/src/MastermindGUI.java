import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; // Import MouseEvent
import java.awt.Color; // Import Color

public class MastermindGUI extends JFrame {
    private static final int NUM_PEGS = 4;
    private JPanel boardPanel, guessPanel;
    private JButton[][] pegButtons;
    private JButton submitButton;
    
    public MastermindGUI() {
        setTitle("Mastermind Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        setupGameBoard();
        setupGuessPanel();
        
        add(boardPanel, BorderLayout.CENTER);
        add(guessPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null); // Center the window on the screen
    }
    
    private void setupGameBoard() {
        boardPanel = new JPanel(new GridLayout(10, NUM_PEGS));
        pegButtons = new JButton[10][NUM_PEGS];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < NUM_PEGS; j++) {
                pegButtons[i][j] = new JButton();
                pegButtons[i][j].setEnabled(true);
                pegButtons[i][j].setBackground(Color.LIGHT_GRAY);
                pegButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                // Add a MouseListener for color selection
                pegButtons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Color selectedColor = JColorChooser.showDialog(
                                MastermindGUI.this, "Select Color", Color.LIGHT_GRAY);
                        if (selectedColor != null) {
                            ((JButton) e.getSource()).setBackground(selectedColor);
                        }
                    }
                });
                
                boardPanel.add(pegButtons[i][j]);
            }
        }
    }
    
    private void setupGuessPanel() {
        guessPanel = new JPanel();
        submitButton = new JButton("Submit Guess");
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the guess submission here
                // You can update the pegButtons and check for correct guesses
            }
        });
        
        guessPanel.add(submitButton);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MastermindGUI().setVisible(true);
            }
        });
    }
    
    public static void tests() {
    	
    }
}