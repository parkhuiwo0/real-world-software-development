package chapter_02.interfaces;

import chapter_02.BankTransaction;
import java.util.List;

public interface BankStatementParser {

  /**
   * 한 줄의 문자열 거래내역을 BankTransaction 도메인 클래스로 파싱합니다.
   *
   * @param line 입출금 거래 내역 라인
   * @return 입출금 거래 내역
   */
  BankTransaction parseFrom(String line);

  /**
   * 입출금 거래내역 문자열 리스트를 파싱하여 리스트에 담아 리턴합니다.
   *
   * @param lines 입출금 거래내역 문자열 리스트
   * @return 입출금 거래 내역 리스트
   */
  List<BankTransaction> parseLinesFrom(List<String> lines);
}
