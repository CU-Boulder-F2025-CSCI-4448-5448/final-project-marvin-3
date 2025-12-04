import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StatsManager {
    private static final String FILE_NAME = "player_stats.txt";

    public static Map<String, Integer> loadStats() {
        Map<String, Integer> stats = new HashMap<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return stats;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String initials = parts[0].trim();
                    int wins = Integer.parseInt(parts[1].trim());
                    stats.put(initials, wins);
                }
            }
        } catch (IOException exception) {
            throw new RuntimeException("Error reading stats file", exception);
        }

        return stats;
    }

    public static void saveStats(Map<String, Integer> stats) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String initials : stats.keySet()) {
                printWriter.println(initials + "=" + stats.get(initials));
            }
        } catch (IOException exception) {
            throw new RuntimeException("Error writing stats file", exception);
        }
    }

    public static void recordWin(String initials) {
        Map<String, Integer> stats = loadStats();

        stats.put(initials, stats.getOrDefault(initials, 0) + 1);

        saveStats(stats);
    }

    public static void printStats() {
        Map<String, Integer> stats = loadStats();

        System.out.println("\n===============================");
        System.out.println("        STRATEGO STATS");
        System.out.println("===============================");

        if (stats.isEmpty()) {
            System.out.println("No stats available yet.");
            System.out.println("===============================\n");
            return;
        }

        stats.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry -> {
                    String initials = entry.getKey();
                    int wins = entry.getValue();
                    System.out.println(initials + " :  " + wins + " wins");
                });

        System.out.println("===============================\n");
    }
}
