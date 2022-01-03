package chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Kiss Principle을 적용한 God Class
 */
public class BankTransactionAnalyzerSimple {

  private static final String RESOURCES = "src/main/resources/";

  public static void main(String[] args) throws IOException {

    final Path path = Paths.get(RESOURCES + args[0]);
    final List<String> lines = Files.readAllLines(path);
    double total = 0d;
    for (final String line : lines) {
      final String[] columns = line.split(",");
      final double amount = Double.parseDouble(columns[1]);
      total += amount;
    }

    System.out.println("총 거래 금액은 " + total + "원 입니다.");
  }
}
