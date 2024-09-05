import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class MessagesPage extends JFrame {

    public MessagesPage() {
        setTitle("Messages");
        setSize(500, 600); // Increased height to accommodate more messages
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextPane messagesPane = new JTextPane();
        messagesPane.setEditable(false);
        messagesPane.setContentType("text/html"); // Ensure this line is correctly placed
        messagesPane.setFont(new Font("Arial", Font.PLAIN, 14));

        // HTML content with styled message boxes and phone numbers
        String messages = "<html><body style='font-family: Arial, sans-serif;'>"
                + "<div style='border: 1px solid #ccc; border-radius: 5px; padding: 10px; margin: 10px 0; background-color: #f9f9f9;'>"
                + "<p><b>User1:</b> Hello, how are you? <br><i>Phone: (123) 456-7890</i></p>"
                + "</div>"
                + "<div style='border: 1px solid #ccc; border-radius: 5px; padding: 10px; margin: 10px 0; background-color: #f9f9f9;'>"
                + "<p><b>User2:</b> I'm good, thanks! How about you? <br><i>Phone: (987) 654-3210</i></p>"
                + "</div>"
                + "<div style='border: 1px solid #ccc; border-radius: 5px; padding: 10px; margin: 10px 0; background-color: #f9f9f9;'>"
                + "<p><b>User1:</b> I'm doing well. Just wanted to check in. <br><i>Phone: (123) 456-7890</i></p>"
                + "</div>"
                + "<div style='border: 1px solid #ccc; border-radius: 5px; padding: 10px; margin: 10px 0; background-color: #f9f9f9;'>"
                + "<p><b>User3:</b> Hey everyone, any updates? <br><i>Phone: (555) 123-4567</i></p>"
                + "</div>"
                + "<div style='border: 1px solid #ccc; border-radius: 5px; padding: 10px; margin: 10px 0; background-color: #f9f9f9;'>"
                + "<p><b>User2:</b> Nothing much, just waiting for the next meeting. <br><i>Phone: (987) 654-3210</i></p>"
                + "</div>"
                + "</body></html>";

        messagesPane.setText(messages); // Set the updated HTML content
        messagesPane.revalidate();
        messagesPane.repaint();

        JScrollPane scrollPane = new JScrollPane(messagesPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.GRAY;
            }
        });

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MessagesPage().setVisible(true));
    }
}
