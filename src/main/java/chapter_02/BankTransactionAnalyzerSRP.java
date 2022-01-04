package chapter_02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SRP 원칙을 적용한 거래내역 분석기
 */
public class BankTransactionAnalyzerSRP {
  private static final String RESOURCES = "src/main/resources/";

  public static void main(final String[] args) throws Exception {

    final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    final Path path = Paths.get(RESOURCES + args[0]);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
    final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

    collectSummary(bankStatementProcessor);

//    System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
//    System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
  }

  private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
    System.out.println("Total amount for all transactions : "
        + bankStatementProcessor.calculateTotalAmount());
    System.out.println("Total amount for transactions in January : "
        + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
    System.out.println("Total salary received is : "
        + bankStatementProcessor.calculateTotalForCategory("Salary"));
  }

//  private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
//    return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
//  }
//
//  private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
//    return bankTransactions.stream()
//        .filter(bankStatement -> month.equals(bankStatement.getDate().getMonth()))
//        .collect(Collectors.toList());
//  }
}
