package com.planetakinoauth.ts;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // Path to Node.js executable and the TypeScript (JavaScript) file
            String nodePath = "node";  // Ensure node is in your system's PATH
            String scriptPath = "path/to/sign.js";  // Path to the compiled JavaScript file

            // Build the process to run the Node.js script
            ProcessBuilder processBuilder = new ProcessBuilder(nodePath, scriptPath);
            processBuilder.redirectErrorStream(true);  // Redirect error output to standard output

            // Start the process and read the output
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print output from the Node.js script
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Node.js script finished with exit code " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
