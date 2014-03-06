package bibliophiles.bookstore.dao;

import bibliophiles.bookstore.domain.Creditcard;

public interface CreditcardDao {
	public void add(Creditcard creditcard);
	public Creditcard findByCardNumber(String cardnumber);
	public void updateCreditcard(Creditcard creditcard);
	public void del(String cardnumber);
}
