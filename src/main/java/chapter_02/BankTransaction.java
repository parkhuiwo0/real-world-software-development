package chapter_02;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 거래 내역 도메인 클래스.
 */
public class BankTransaction {
  private final LocalDate date;
  private final double amount;
  private final String description;

  BankTransaction(LocalDate date, double amount, String description) {
    this.date = date;
    this.amount = amount;
    this.description = description;
  }

  LocalDate getDate() {
    return date;
  }

  double getAmount() {
    return amount;
  }

  String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return String.format("[BankTransaction] date=%s, amount=%f, description=%s",
        date.toString(), amount, description);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BankTransaction that = (BankTransaction) o;
    return Double.compare(that.amount, amount) == 0 &&
        Objects.equals(date, that.date) &&
        Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, amount, description);
  }
}
