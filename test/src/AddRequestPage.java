import javax.swing.*;
import java.awt.*;

public class AddRequestPage {

    public static void showAddRequestPage(JFrame parentFrame) {
        JFrame addRequestFrame = new JFrame("Add Request");
        addRequestFrame.setSize(400, 300);
        addRequestFrame.setLocationRelativeTo(parentFrame);
        addRequestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addRequestFrame.setLayout(new BorderLayout());

        // Create a panel for the form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 columns
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add form fields
        formPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Rent:"));
        JTextField rentField = new JTextField();
        formPanel.add(rentField);

        formPanel.add(new JLabel("Location:"));
        JTextField locationField = new JTextField();
        formPanel.add(locationField);

        formPanel.add(new JLabel("Amenities:"));
        JTextField amenitiesField = new JTextField();
        formPanel.add(amenitiesField);

        // Add the form panel to the frame
        addRequestFrame.add(formPanel, BorderLayout.CENTER);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        submitButton.addActionListener(e -> {
            // Handle form submission (e.g., validate and save the data)
            String name = nameField.getText();
            String rent = rentField.getText();
            String location = locationField.getText();
            String amenities = amenitiesField.getText();

            // Example: Print the data to the console
            System.out.println("Request Submitted:");
            System.out.println("Name: " + name);
            System.out.println("Rent: " + rent);
            System.out.println("Location: " + location);
            System.out.println("Amenities: " + amenities);

            addRequestFrame.dispose(); // Close the form after submission
        });

        cancelButton.addActionListener(e -> addRequestFrame.dispose()); // Close the form without submission

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        addRequestFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        addRequestFrame.setVisible(true);
    }
}
