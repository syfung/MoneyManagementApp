package transaction;

public class CatchUpTransaction extends ConcreteTransaction {

	/**
	 * 
	 */
	public CatchUpTransaction(double different) {
		super();
		// TODO Auto-generated constructor stub
		this.amount = different;
		this.transactionType = TransactionType.CATCHUP;
	}
	
}
