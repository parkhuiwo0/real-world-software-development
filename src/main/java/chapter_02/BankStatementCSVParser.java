package chapter_02;

import chapter_02.interfaces.BankStatementParser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV 파싱을 담당합니다.
 */
public class BankStatementCSVParser implements BankStatementParser {

  private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  /**
   * CSV형태의 라인들을 파싱하여 도메인 클래스로 변환합니다.
   *
   * @param lines CSV형태로 작성된 라인 리스트
   * @return 거래 내역 도메인 클래스 리스트
   */
  @Override
  public List<BankTransaction> parseLinesFrom(final List<String> lines) {
    final List<BankTransaction> bankTransactions = new ArrayList<>();
    for (final String line : lines) {
      bankTransactions.add(parseFrom(line));
    }

    return bankTransactions;
  }

  /**
   * 한 줄의 CSV 포맷을 파싱하여 도메인 클래스로 변환합니다.
   *
   * @param line CSV line
   * @return 변환된 도메인 클래스
   */
  @Override
  public BankTransaction parseFrom(final String line) {
    final String[] columns = line.split(",");

    final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
    final double amount = Double.parseDouble(columns[1]);
    final String description = columns[2];

    return new BankTransaction(date, amount, description);
  }
}
