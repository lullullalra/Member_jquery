package gntp.model2.vo;

import java.sql.Timestamp;

public class BookVO {

    // 책들의 정보 분류번호, 도서명, 저자, 가격, 구입일

    private int BookNo;
    private String BookName;
    private String author;
    private int price;
    private Timestamp BuyDate;

    // 책을 빌린 학생 번호
    private int StdNo = 0;

    public int getStdNo() {
        return StdNo;
    }

    public void setStdNo(int stdNo) {
        StdNo = stdNo;
    }

    // 대출 가능 여부
    private boolean isPossible = false;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    // 대출 횟수
    private int Count = 0;
    
    public BookVO(int BookNo,String BookName, String author, int price, Timestamp BuyDate){
        this.BookNo = BookNo;
        this.BookName = BookName;
        this.author = author;
        this.price = price;
        this.BuyDate = BuyDate;
    }

    public boolean isPossible() {
        return this.isPossible;
    }

    public void setisPossible(boolean isPossible) {
        this.isPossible = isPossible;
    }

    public int getBookNo() {
        return BookNo;
    }

    public void setBookNo(int bookNo) {
        BookNo = bookNo;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getBuyDate() {
        return BuyDate;
    }

    public void setBuyDate(Timestamp buyDate) {
        BuyDate = buyDate;
    }
}