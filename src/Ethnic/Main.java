import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public Main() {
        // Initialize the main frame
        frame = new JFrame("Shopping App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);  // Increased size for better space

        // Initialize CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add all panels
        mainPanel.add(createWelcomePanel(), "Welcome");
        mainPanel.add(createRegistrationPanel(), "Register");
        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createAdminLoginPanel(), "AdminLogin");
        mainPanel.add(createGenderSelectionPanel(), "GenderSelection");
        mainPanel.add(createForgetPasswordPanel(), "ForgetPassword");

        // Add the main panel to the frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Helper methods for font sizes
    private Font getHeadingFont() {
        return new Font("Artifakt Element", Font.BOLD, 26); // For main headings
    }

    private Font getLabelFont() {
        return new Font("Artifakt Element", Font.PLAIN, 18); // For labels
    }

    private Font getButtonFont() {
        return new Font("Artifakt Element", Font.PLAIN, 20); // For buttons
    }

    private Font getLinkFont() {
        return new Font("SansSerif", Font.PLAIN, 14); // For small link-style buttons
    }

    // Helper method to set common aesthetics for panels
    private JPanel stylePanel(JPanel panel) {
        panel.setBackground(Color.decode("#F7B9C4")); // Set background color
        return panel;
    }

    // Welcome Panel
    private JPanel createWelcomePanel() {
        JPanel panel = stylePanel(new JPanel());
        panel.setLayout(new GridLayout(5, 1));
        JLabel label = new JLabel("Welcome to the Shopping App", JLabel.CENTER);
        label.setFont(getHeadingFont());

        JButton registerButton = new JButton("Register");
        registerButton.setFont(getButtonFont());

        JButton loginButton = new JButton("Login");
        loginButton.setFont(getButtonFont());

        JButton forgotPasswordButton = new JButton("<html><u>Forget Password</u></html>");
        forgotPasswordButton.setForeground(Color.BLUE);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setFont(getLinkFont());

        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "Register"));
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        forgotPasswordButton.addActionListener(e -> cardLayout.show(mainPanel, "ForgetPassword"));

        panel.add(label);
        panel.add(registerButton);
        panel.add(loginButton);
        panel.add(forgotPasswordButton);

        return panel;
    }

    private JPanel createRegistrationPanel() {
        JPanel panel = stylePanel(new JPanel(new GridLayout(9, 2, 10, 10)));  // Increased gap for aesthetics

        // Adding Customer Name
        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setFont(getLabelFont());
        JTextField nameField = new JTextField();

        // Adding Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(getLabelFont());
        JTextField usernameField = new JTextField();

        // Adding Phone Number
        JLabel phoneLabel = new JLabel("Phone No:");
        phoneLabel.setFont(getLabelFont());
        JTextField phoneField = new JTextField();

        // Adding Location
        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(getLabelFont());
        JTextField locationField = new JTextField();

        // Adding Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(getLabelFont());
        JTextField emailField = new JTextField();

        // Adding Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(getLabelFont());
        JPasswordField passwordField = new JPasswordField();

        // Adding Confirm Password
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(getLabelFont());
        JPasswordField confirmPasswordField = new JPasswordField();

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(getButtonFont());
        submitButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Registration Successful!"));

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(getButtonFont());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        // Add components to panel with more spacing for better layout
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(locationLabel);
        panel.add(locationField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(submitButton);
        panel.add(backButton);

        return panel;
    }

    // Login Panel
    private JPanel createLoginPanel() {
        JPanel panel = stylePanel(new JPanel(new GridLayout(4, 2)));
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(getLabelFont());
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(getLabelFont());
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.setFont(getButtonFont());
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "GenderSelection"));

        JButton backButton = new JButton("Back");
        backButton.setFont(getButtonFont());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(backButton);

        return panel;
    }

    // Admin Login Panel
    private JPanel createAdminLoginPanel() {
        JPanel panel = stylePanel(new JPanel(new GridLayout(4, 2)));
        JLabel adminUsernameLabel = new JLabel("Admin Username:");
        adminUsernameLabel.setFont(getLabelFont());
        JTextField adminUsernameField = new JTextField();

        JLabel adminPasswordLabel = new JLabel("Admin Password:");
        adminPasswordLabel.setFont(getLabelFont());
        JPasswordField adminPasswordField = new JPasswordField();

        JButton adminLoginButton = new JButton("Login");
        adminLoginButton.setFont(getButtonFont());
        adminLoginButton.addActionListener(e -> {
            if ("admin".equals(adminUsernameField.getText()) && "admin@2024".equals(new String(adminPasswordField.getPassword()))) {
                JOptionPane.showMessageDialog(frame, "Admin Login Successful!");
                cardLayout.show(mainPanel, "GenderSelection");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Admin Credentials!");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setFont(getButtonFont());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        panel.add(adminUsernameLabel);
        panel.add(adminUsernameField);
        panel.add(adminPasswordLabel);
        panel.add(adminPasswordField);
        panel.add(adminLoginButton);
        panel.add(backButton);

        return panel;
    }

    // Gender Selection Panel
    private JPanel createGenderSelectionPanel() {
        JPanel panel = stylePanel(new JPanel(new GridLayout(4, 1)));
        JLabel label = new JLabel("Choose your category", JLabel.CENTER);
        label.setFont(getHeadingFont());

        JButton maleButton = new JButton("Male");
        maleButton.setFont(getButtonFont());

        JButton femaleButton = new JButton("Female");
        femaleButton.setFont(getButtonFont());

        maleButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Male category selected!"));
        femaleButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Female category selected!"));

        JButton backButton = new JButton("Back");
        backButton.setFont(getButtonFont());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        panel.add(label);
        panel.add(maleButton);
        panel.add(femaleButton);
        panel.add(backButton);

        return panel;
    }

    // Forget Password Panel
    private JPanel createForgetPasswordPanel() {
        JPanel panel = stylePanel(new JPanel(new GridLayout(5, 2)));

        JLabel emailLabel = new JLabel("Enter Registered Email:");
        emailLabel.setFont(getLabelFont());
        JTextField emailField = new JTextField();

        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setFont(getLabelFont());
        JPasswordField newPasswordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm New Password:");
        confirmPasswordLabel.setFont(getLabelFont());
        JPasswordField confirmPasswordField = new JPasswordField();

        JButton resetButton = new JButton("Reset Password");
        resetButton.setFont(getButtonFont());
        resetButton.addActionListener(e -> {
            String email = emailField.getText();
            String newPassword = new String(newPasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (email.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Password reset successful for: " + email, "Success", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(mainPanel, "Login");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setFont(getButtonFont());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(resetButton);
        panel.add(backButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}


