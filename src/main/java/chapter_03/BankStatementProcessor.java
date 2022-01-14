package chapter_03;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * 거래 내역의 연산을 책임집니다.
 */
public class BankStatementProcessor {

  private final List<BankTransaction> bankTransactions;

  /**
   * 생성자.`
   */
  public BankStatementProcessor(List<BankTransaction> bankTransactions) {
    this.bankTransactions = bankTransactions;
  }

  /**
   * 거래 내역의 총 금액을 합산합니다.
   *
   * @return 합산된 총 거래 금액
   */
  public double calculateTotalAmount() {
    double total = 0;
    for (final BankTransaction bankTransaction : bankTransactions) {
      total += bankTransaction.getAmount();
    }

    return total;
  }

  /**
   * 특정 월에 대한 거래내역의 금액을 합산합니다.
   *
   * @return 합산된 총 거래 금액
   */
  public double calculateTotalInMonth(final Month month) {
    double total = 0;
    for (final BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDate().getMonth() == month) {
        total += bankTransaction.getAmount();
      }
    }

    return total;
  }

  /**
   * 특정 카테고리에 해당하는 거래 내역의 금액을 합산합니다.
   *
   * @param category 카테고리
   * @return 합산된 총 거래 금액
   */
  public double calculateTotalForCategory(final String category) {
    double total = 0;
    for (final BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDescription().equals(category)) {
        total += bankTransaction.getAmount();
      }
    }

    return total;
  }

  /**
   * 특정 금액 이상의 거래 내역을 찾습니다.
   *
   * @param amount 조회하려는 금액
   * @return 거래 내역 리스트
   */
  public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
    final List<BankTransaction> result = new ArrayList<>();

    for (BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getAmount() >= amount) {
        result.add(bankTransaction);
      }
    }
    return result;
  }

  /**
   * 특정 월에 해당하는 거래 내역을 찾습니다.
   *
   * @param month 월
   * @return 거래 내역 리스트
   */
  public List<BankTransaction> findTransactionsInMonth(final Month month) {
    final List<BankTransaction> result = new ArrayList<>();

    for (BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDate().getMonth() == month) {
        result.add(bankTransaction);
      }
    }
    return result;
  }

  /**
   * 특정 월과 금액에 해당하는 거래 내역을 찾습니다.
   *
   * @param month 월
   * @return 거래 내역 리스트
   */
  public List<BankTransaction> findTransactionsInMonth(final int amount, final Month month) {
    final List<BankTransaction> result = new ArrayList<>();

    for (BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() == amount) {
        result.add(bankTransaction);
      }
    }
    return result;
  }

}
