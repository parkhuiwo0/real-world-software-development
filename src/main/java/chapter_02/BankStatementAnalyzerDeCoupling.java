package chapter_02;

import chapter_02.BankStatementProcessor;
import chapter_02.BankTransaction;
import chapter_02.interfaces.BankStatementParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzerDeCoupling {
  private static final String RESOURCES = "src/main/resources/";

  public void analyze(final String fileName, final BankStatementParser bankStatementParser)
      throws IOException {
    final Path path = Paths.get(RESOURCES + fileName);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

    BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

    collectSummary(bankStatementProcessor);
  }

  private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
    System.out.println("Total amount for all transactions : "
        + bankStatementProcessor.calculateTotalAmount());
    System.out.println("Total amount for transactions in January : "
        + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
    System.out.println("Total salary received is : "
        + bankStatementProcessor.calculateTotalForCategory("Salary"));
  }
}
