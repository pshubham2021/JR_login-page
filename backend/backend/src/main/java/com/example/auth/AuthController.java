
package com.example.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private static final String USER_FILE = "users.json";

    @PostMapping("/signup")
    public Map<String, Object> signup(@RequestBody Map<String, String> user) throws IOException {
        List<Map<String, String>> users = readUsers();
        for (Map<String, String> u : users) {
            if (u.get("username").equals(user.get("username"))) {
                return Map.of("success", false, "message", "Username already exists");
            }
        }
        users.add(user);
        writeUsers(users);
        return Map.of("success", true);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> user) throws IOException {
        List<Map<String, String>> users = readUsers();
        for (Map<String, String> u : users) {
            if (u.get("username").equals(user.get("username")) && u.get("password").equals(user.get("password"))) {
                return Map.of("success", true);
            }
        }
        return Map.of("success", false, "message", "Invalid credentials");
    }

    private List<Map<String, String>> readUsers() throws IOException {
        File file = new File(USER_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            String json = sb.toString();
            if (json.isEmpty()) return new ArrayList<>();
            return new ObjectMapper().readValue(json, List.class);
        }
    }

    private void writeUsers(List<Map<String, String>> users) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            writer.write(new ObjectMapper().writeValueAsString(users));
        }
    }
}
