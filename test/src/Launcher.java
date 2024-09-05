import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher {
    Launcher() {
        // Create the main application frame for the launcher
        JFrame frame = new JFrame("Launcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Create and add the H1 label
        JLabel welcomeLabel = new JLabel("Welcome to PG Accommodation Platform", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(50, 10, 50, 10)); // Add top padding
        frame.add(welcomeLabel, BorderLayout.CENTER);

        // Create and add the launch button
        JButton launchButton = new JButton("Click here to find PG near Your college");
        launchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Launch the LoginPage
                SwingUtilities.invokeLater(() -> {
                    LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
                    loginPage.setVisible(true); // Make sure the LoginPage is visible
                });
                frame.dispose(); // Dispose of the launcher frame after opening the login screen
            }
        });


        // Button to open RegisterPage
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Launch the RegisterPage
                frame.dispose();
                SwingUtilities.invokeLater(() -> new RegisterPage().setVisible(true));
            }
        });

        // Create a panel for buttons and add it to the bottom of the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(launchButton);
        buttonPanel.add(registerButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the launcher frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Launcher();
    }
}
