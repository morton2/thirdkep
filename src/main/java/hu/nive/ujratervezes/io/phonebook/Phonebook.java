package hu.nive.ujratervezes.io.phonebook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) throws IOException {
        if (contacts == null) {
            Files.deleteIfExists(Path.of(output));
            throw new IllegalArgumentException("param cannot be null.");
        }
        if (output == null) {
            throw new IllegalArgumentException("param cannot be null.");
        }
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8))) {
                for (Map.Entry<String, String> entry : contacts.entrySet()) {
                    //if (entry.getKey() == null || entry.getValue() == null) {
                    //    throw new IllegalArgumentException("param cannot be null.");
                    //}
                    writer.write(entry.getKey() + ": " + entry.getValue());
                    ((BufferedWriter) writer).newLine();
                }
            } catch (IOException ex) {
            }
        }
    }