package com.hospital.dbms.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.hospital.dbms.models.User;
import com.hospital.dbms.services.UserService;

public class MainUI {

    public static void launch(ApplicationContext context) {

        EventQueue.invokeLater(() -> {

            UserService service = context.getBean(UserService.class);

            Frame frame = new Frame("Hospital Management System");

            // Input components
            Label label = new Label("Enter Name:");
            TextField textField = new TextField(20);
            Button saveBtn = new Button("Save");
            Button getBtn = new Button("Get All");

            // Output area (better than labels)
            TextArea area = new TextArea(10, 40);

            // Layout
            frame.setLayout(new FlowLayout());

            // Add components
            frame.add(label);
            frame.add(textField);
            frame.add(saveBtn);
            frame.add(getBtn);
            frame.add(area);

            // SAVE USER
            saveBtn.addActionListener(e -> {
                String name = textField.getText();

                if (!name.isEmpty()) {
                    service.addUser(new User(0, name));
                    textField.setText("");
                    area.append("User Saved: " + name + "\n");
                } else {
                    area.append("Please enter a name\n");
                }
            });

            // GET ALL USERS
            getBtn.addActionListener(e -> {
                List<User> users = service.getUsers();

                area.setText(""); // clear previous data

                if (users.isEmpty()) {
                    area.append("No users found\n");
                } else {
                    for (User user : users) {
                        area.append("Name: " + user.getName() + "\n");
                    }
                }
            });

            // Frame settings
            frame.setSize(450, 400);
            frame.setVisible(true);

            // Close event
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        });
    }
}