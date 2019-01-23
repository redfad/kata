package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Account model
 * @author elmekkaoui Redouane
 *
 */
public class Account {
	// creation Date
	private LocalDate creationDate;
	private BigDecimal balance;
	private LocalDate endDate;
	private AccountStatus status;
	private Integer accountId;

	/**
	 * create an account zero balance
	 */
	public Account() {
		this.creationDate = LocalDate.now();
		this.balance = new BigDecimal(0.0);
		this.accountId = Integer.valueOf((int) (Math.random() * 1000));
		this.setStatus(AccountStatus.ACTIF);
	}

	/**
	 * create an account with initial balance
	 * @param balance
	 */
	public Account(BigDecimal balance) {
		this.creationDate = LocalDate.now();
		this.balance = balance;
		this.accountId = Integer.valueOf((int) (Math.random() * 1000));
		this.setStatus(AccountStatus.ACTIF);
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	/**
	 * @return the accountId
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return accountId.intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [creationDate=" + creationDate + ", balance=" + balance + ", endDate=" + endDate + ", status="
				+ status + ", accountId=" + accountId + "]";
	}

}
