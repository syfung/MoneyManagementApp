package transaction;

import java.time.ZonedDateTime;

public class CatchUpTransaction extends ConcreteTransaction {

	/**
	 * @param different
	 * @param now
	 */
	public CatchUpTransaction(double different, ZonedDateTime now) {
		super("catch up", different, TransactionType.CATCHUP, null, now, now);
	}

}
