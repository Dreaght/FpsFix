package com.github.dreaght;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SettingsManager {
    private static final String DIRECTORY_NAME = "FpsFixer";
    private static final String FILE_NAME = "settings.txt";
    private static final String FILE_PATH = DIRECTORY_NAME + "/" + FILE_NAME;

    public static void saveSettings(boolean isEnabled) {
        try {
            Path directoryPath = Paths.get(DIRECTORY_NAME);

            if (Files.notExists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            String content = String.valueOf(isEnabled);
            Files.write(Paths.get(FILE_PATH), Collections.singletonList(content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEnabled() {
        Path path = Paths.get(FILE_PATH);

        try {
            if (Files.notExists(path)) {
                saveSettings(true);
            }

            List<String> lines = Files.readAllLines(path);
            if (!lines.isEmpty()) {
                return Boolean.parseBoolean(lines.get(0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
