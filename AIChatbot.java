import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AIChatbot extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JLabel statusLabel;

    public AIChatbot() {

        setTitle("AI Chatbot - CodeAlpha Task 3");
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("🤖 AI CHATBOT");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        statusLabel = new JLabel("● Online");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(statusLabel, BorderLayout.EAST);

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton sendButton = new JButton("Send");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        // Bottom panel
        JPanel inputPanel = new JPanel(new BorderLayout(8, 8));
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add components
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Welcome message
        addBotMessage("Hello! 👋 I'm your AI Chatbot.");
        addBotMessage("I can answer questions about Java, AI, programming and more.");
        addBotMessage("Type 'help' to see what I can do.");

        // Send button
        sendButton.addActionListener(e -> sendMessage());

        // Enter key
        inputField.addActionListener(e -> sendMessage());

        // Clear button
        clearButton.addActionListener(e -> {
            chatArea.setText("");
            addBotMessage("Chat cleared. How can I help you?");
        });

        // Exit button
        exitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to exit?",
                    "Exit Chatbot",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    // Send user message
    private void sendMessage() {

        String message = inputField.getText().trim();

        if (message.isEmpty()) {
            return;
        }

        addUserMessage(message);

        String response = getResponse(message.toLowerCase());

        addBotMessage(response);

        inputField.setText("");
    }

    // Add user message
    private void addUserMessage(String message) {

        String time = getCurrentTime();

        chatArea.append("\nYou [" + time + "]:\n");
        chatArea.append(message + "\n");
    }

    // Add bot message
    private void addBotMessage(String message) {

        String time = getCurrentTime();

        chatArea.append("\nBot [" + time + "]:\n");
        chatArea.append(message + "\n");
    }

    // Current time
    private String getCurrentTime() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm");

        return LocalTime.now().format(formatter);
    }

    // NLP-style response system
    private String getResponse(String message) {

        // Greetings
        if (containsAny(message,
                "hello", "hi", "hey", "good morning",
                "good afternoon", "good evening")) {

            return "Hello! 😊 Nice to talk with you. How can I help you?";
        }

        // How are you
        if (containsAny(message,
                "how are you", "how are u", "are you fine")) {

            return "I'm doing great! I'm ready to answer your questions. 🤖";
        }

        // Bot name
        if (containsAny(message,
                "your name", "who are you", "what are you")) {

            return "I'm an AI Chatbot created using Java and Swing.";
        }

        // Java
        if (containsAny(message,
                "java", "java language")) {

            return "Java is a high-level, object-oriented programming language "
                    + "known for portability, security and reliability.";
        }

        // OOP
        if (containsAny(message,
                "oop", "object oriented", "object-oriented")) {

            return "OOP stands for Object-Oriented Programming. "
                    + "Its main concepts include Encapsulation, Inheritance, "
                    + "Polymorphism and Abstraction.";
        }

        // AI
        if (containsAny(message,
                "what is ai",
                "artificial intelligence",
                "define ai")) {

            return "Artificial Intelligence (AI) is a field of computer science "
                    + "that enables machines to perform tasks that normally "
                    + "require human intelligence.";
        }

        // NLP
        if (containsAny(message,
                "nlp",
                "natural language processing")) {

            return "NLP stands for Natural Language Processing. "
                    + "It helps computers understand and process human language.";
        }

        // Machine Learning
        if (containsAny(message,
                "machine learning",
                "ml",
                "what is machine learning")) {

            return "Machine Learning is a branch of AI where computers learn "
                    + "patterns from data and use them to make predictions or decisions.";
        }

        // Programming
        if (containsAny(message,
                "programming",
                "coding",
                "code")) {

            return "Programming is the process of creating instructions "
                    + "that a computer can execute to solve problems.";
        }

        // GUI
        if (containsAny(message,
                "gui",
                "graphical user interface")) {

            return "GUI stands for Graphical User Interface. "
                    + "It allows users to interact with software through "
                    + "buttons, windows, menus and other visual elements.";
        }

        // Java Swing
        if (containsAny(message,
                "swing",
                "java swing")) {

            return "Java Swing is a GUI toolkit in Java used to create "
                    + "desktop applications with components such as buttons, "
                    + "text fields and windows.";
        }

        // C++
        if (containsAny(message,
                "c++",
                "cpp")) {

            return "C++ is a powerful general-purpose programming language "
                    + "that supports object-oriented and procedural programming.";
        }

        // Python
        if (containsAny(message,
                "python",
                "python language")) {

            return "Python is a high-level programming language known for "
                    + "its simple syntax and wide use in AI, data science and web development.";
        }

        // Data structures
        if (containsAny(message,
                "data structure",
                "array",
                "linked list",
                "stack",
                "queue")) {

            return "Data structures are ways of organizing and storing data. "
                    + "Examples include arrays, stacks, queues, linked lists and trees.";
        }

        // Help
        if (containsAny(message,
                "help",
                "what can you do",
                "commands")) {

            return "You can ask me about:\n"
                    + "• Java\n"
                    + "• OOP\n"
                    + "• Artificial Intelligence\n"
                    + "• NLP\n"
                    + "• Machine Learning\n"
                    + "• Programming\n"
                    + "• Java Swing\n"
                    + "• Python\n"
                    + "• C++\n"
                    + "• Data Structures";
        }

        // Thanks
        if (containsAny(message,
                "thank you",
                "thanks",
                "thank")) {

            return "You're welcome! 😊";
        }

        // Goodbye
        if (containsAny(message,
                "bye",
                "goodbye",
                "see you")) {

            return "Goodbye! 👋 Have a great day!";
        }

        // Default response
        return "I'm not sure about that yet. 🤔\n"
                + "Try asking me about Java, AI, NLP, programming or type 'help'.";
    }

    // Keyword matching method
    private boolean containsAny(String message, String... keywords) {

        for (String keyword : keywords) {

            if (message.contains(keyword)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AIChatbot chatbot = new AIChatbot();

            chatbot.setVisible(true);
        });
    }
}