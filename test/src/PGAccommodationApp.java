import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PGAccommodationApp extends JFrame {

    private JPanel optionsPanel;
    private boolean isOptionsPanelVisible = false;

    public PGAccommodationApp() {
        setTitle("PG Accommodation Platform");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500); // Mobile-like screen ratio
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#FDE68A")); // Sushi color background

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
        headerPanel.setBackground(Color.decode("#FDE68A")); // Sushi color background
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Header label
        JLabel headerLabel = new JLabel("PG_ROOMS", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.decode("#0347A1")); // Dark blue for header text
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBackground(Color.decode("#FDE68A")); // Sushi color background

        JButton optionsButton = new JButton("Options");
        optionsButton.setPreferredSize(new Dimension(100, 40));
        optionsButton.setBackground(Color.decode("#0347A1")); // Dark blue
        optionsButton.setForeground(Color.BLACK); // Black text
        optionsButton.addActionListener(e -> toggleOptionsPanel(mainPanel));

        JButton searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 40));
        searchButton.setBackground(Color.decode("#0347A1")); // Dark blue
        searchButton.setForeground(Color.BLACK); // Black text

        // Add buttons with spacing between them
        buttonPanel.add(optionsButton);
        buttonPanel.add(Box.createHorizontalStrut(20)); // Gap between buttons
        buttonPanel.add(searchButton);

        // Add components to headerPanel
        headerPanel.add(Box.createHorizontalStrut(10)); // Add space before buttons
        headerPanel.add(optionsButton);
        headerPanel.add(Box.createHorizontalGlue()); // Center alignment for the label
        headerPanel.add(headerLabel);
        headerPanel.add(Box.createHorizontalGlue()); // Center alignment for the label
        headerPanel.add(searchButton);
        headerPanel.add(Box.createHorizontalStrut(10)); // Add space after buttons

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(createContent(), BorderLayout.CENTER);

        // Initialize options panel (but do not add it to the main layout yet)
        initOptionsPanel();

        add(mainPanel);
        setVisible(true);
    }

    private void initOptionsPanel() {
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setPreferredSize(new Dimension(250, 100)); // Panel width
        optionsPanel.setBackground(Color.decode("#FDE68A")); // Sushi color background
        optionsPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.decode("#0347A1"))); // Dark blue border

        // Define button size
        Dimension buttonSize = new Dimension(150, 40);

        // Create buttons with controlled size
        JButton messagesButton = new JButton("Messages");
        messagesButton.setBackground(Color.decode("#0347A1")); // Dark blue
        messagesButton.setForeground(Color.BLACK); // Black text
        messagesButton.setPreferredSize(buttonSize);
        messagesButton.setMinimumSize(buttonSize);
        messagesButton.setMaximumSize(buttonSize);
        messagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        messagesButton.addActionListener(e -> showMessagesPage(this));

        JButton addRequestButton = new JButton("Add Request");
        addRequestButton.setBackground(Color.decode("#0347A1")); // Dark blue
        addRequestButton.setForeground(Color.BLACK); // Black text
        addRequestButton.setPreferredSize(buttonSize);
        addRequestButton.setMinimumSize(buttonSize);
        addRequestButton.setMaximumSize(buttonSize);
        addRequestButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addRequestButton.addActionListener(e -> showAddRequestPage(this));

        JButton favouritesButton = new JButton("Favourites");
        favouritesButton.setBackground(Color.decode("#0347A1")); // Dark blue
        favouritesButton.setForeground(Color.BLACK); // Black text
        favouritesButton.setPreferredSize(buttonSize);
        favouritesButton.setMinimumSize(buttonSize);
        favouritesButton.setMaximumSize(buttonSize);
        favouritesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton profileButton = new JButton("Profile");
        profileButton.setBackground(Color.decode("#0347A1")); // Dark blue
        profileButton.setForeground(Color.BLACK); // Black text
        profileButton.setPreferredSize(buttonSize);
        profileButton.setMinimumSize(buttonSize);
        profileButton.setMaximumSize(buttonSize);
        profileButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.decode("#0347A1")); // Dark blue
        logoutButton.setForeground(Color.BLACK); // Black text
        logoutButton.setPreferredSize(buttonSize);
        logoutButton.setMinimumSize(buttonSize);
        logoutButton.setMaximumSize(buttonSize);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.addActionListener(e -> System.exit(0));

        // Add buttons to the panel with spacing
        optionsPanel.add(Box.createVerticalStrut(10)); // Add space at the top
        optionsPanel.add(messagesButton);
        optionsPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        optionsPanel.add(addRequestButton);
        optionsPanel.add(Box.createVerticalStrut(10));
        optionsPanel.add(favouritesButton);
        optionsPanel.add(Box.createVerticalStrut(10));
        optionsPanel.add(profileButton);
        optionsPanel.add(Box.createVerticalStrut(10));
        optionsPanel.add(logoutButton);
        optionsPanel.add(Box.createVerticalStrut(10)); // Add space at the bottom

        // Initially, position the panel off the screen to the left
        optionsPanel.setLocation(-optionsPanel.getWidth(), 0);
    }

    private static JScrollPane createContent() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.decode("#FFFFFF")); // White background
        contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15)); // Padding around the content

        String[] recommendedItems = {
                "PG near University, 8000 INR",
                "PG at Riverside, 12000 INR",
                "PG at Downtown, 7000 INR",
                "PG at Midtown, 9000 INR",
                "PG at City Center, 11000 INR",
                "PG at Lakeside, 10000 INR",
                "PG near Park Avenue, 9500 INR",
                "PG at Old Town, 6000 INR",
                "PG near Tech Hub, 10500 INR",
                "PG at West End, 8500 INR",
                "PG near Metro Station, 7200 INR"
        };

        for (String item : recommendedItems) {
            JTextPane textPane = new JTextPane();
            textPane.setContentType("text/html");
            textPane.setText("<html>" + item + "</html>");
            textPane.setEditable(false);
            textPane.setPreferredSize(new Dimension(400, 60)); // Increase box size
            textPane.setBackground(new Color(245, 245, 245));
            textPane.setMargin(new Insets(10, 10, 10, 10));

            // Set curved edges using a rounded border with no visible line
            textPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            contentPanel.add(textPane);
            contentPanel.add(Box.createVerticalStrut(20)); // Increase space between items
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        return scrollPane;
    }

    private void toggleOptionsPanel(JPanel mainPanel) {
        if (!isOptionsPanelVisible) {
            mainPanel.add(optionsPanel, BorderLayout.WEST);
            new Thread(() -> {
                for (int i = -optionsPanel.getWidth(); i <= 0; i += 10) {
                    optionsPanel.setLocation(i, 0);
                    optionsPanel.revalidate();
                    optionsPanel.repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
            isOptionsPanelVisible = true;
        } else {
            new Thread(() -> {
                for (int i = 0; i >= -optionsPanel.getWidth(); i -= 10) {
                    optionsPanel.setLocation(i, 0);
                    optionsPanel.revalidate();
                    optionsPanel.repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                mainPanel.remove(optionsPanel);
                mainPanel.revalidate();
                mainPanel.repaint();
            }).start();
            isOptionsPanelVisible = false;
        }
    }
    private JPanel createAddRequestForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Institution Name
        JLabel institutionLabel = new JLabel("Institution Name:");
        JTextField institutionField = new JTextField();
        institutionField.setPreferredSize(new Dimension(200, 30));

        // Distance
        JLabel distanceLabel = new JLabel("Distance from Institute (in km):");
        JTextField distanceField = new JTextField();
        distanceField.setPreferredSize(new Dimension(200, 30));

        // Room Type
        JLabel roomTypeLabel = new JLabel("Room Type:");
        String[] roomTypes = {"1RK", "2BHK", "3BHK", "4BHK", "More"};
        JComboBox<String> roomTypeCombo = new JComboBox<>(roomTypes);

        // Number of Members
        JLabel membersLabel = new JLabel("Number of Members:");
        JTextField membersField = new JTextField();
        membersField.setPreferredSize(new Dimension(200, 30));

        // Image Upload
        JLabel imageLabel = new JLabel("Upload Images:");
        JButton uploadButton = new JButton("Choose File");
        uploadButton.setPreferredSize(new Dimension(200, 30));

        // Add components to formPanel
        formPanel.add(institutionLabel);
        formPanel.add(institutionField);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(distanceLabel);
        formPanel.add(distanceField);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(roomTypeLabel);
        formPanel.add(roomTypeCombo);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(membersLabel);
        formPanel.add(membersField);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(imageLabel);
        formPanel.add(uploadButton);
        formPanel.add(Box.createVerticalStrut(20));

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(submitButton);

        return formPanel;
    }



    private void showMessagesPage(JFrame parentFrame) {
        JOptionPane.showMessageDialog(parentFrame, "Messages Page");
    }

    private void showAddRequestPage(JFrame parentFrame) {
        JPanel formPanel = createAddRequestForm();
        JOptionPane.showOptionDialog(
                parentFrame,
                formPanel,
                "Add Request",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[] { "OK" },
                "OK"
        );
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(PGAccommodationApp::new);
    }
}
