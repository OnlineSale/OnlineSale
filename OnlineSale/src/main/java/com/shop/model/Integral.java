package com.shop.model;

import java.io.Serializable;

public class Integral implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6465824212364939766L;

	private int id;
	private int userId;
	private int balanceIntegral;
	private int accumulatedIntegral;
	private int rankingIntegral;
	private int shareIntegral;
	private int withdrawIntegral;
	
	public Integral() {}


	public Integral(int id, int userId, int balanceIntegral, int accumulatedIntegral, int rankingIntegral,
			int shareIntegral, int withdrawIntegral) {
		super();
		this.id = id;
		this.userId = userId;
		this.balanceIntegral = balanceIntegral;
		this.accumulatedIntegral = accumulatedIntegral;
		this.rankingIntegral = rankingIntegral;
		this.shareIntegral = shareIntegral;
		this.withdrawIntegral = withdrawIntegral;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getBalanceIntegral() {
		return balanceIntegral;
	}
	
	public void setBalanceIntegral(int balanceIntegral) {
		this.balanceIntegral = balanceIntegral;
	}

	public int getAccumulatedIntegral() {
		return accumulatedIntegral;
	}

	public void setAccumulatedIntegral(int accumulatedIntegral) {
		this.accumulatedIntegral = accumulatedIntegral;
	}

	public int getRankingIntegral() {
		return rankingIntegral;
	}

	public void setRankingIntegral(int rankingIntegral) {
		this.rankingIntegral = rankingIntegral;
	}

	public int getShareIntegral() {
		return shareIntegral;
	}

	public void setShareIntegral(int shareIntegral) {
		this.shareIntegral = shareIntegral;
	}

	public int getWithdrawIntegral() {
		return withdrawIntegral;
	}

	public void setWithdrawIntegral(int withdrawIntegral) {
		this.withdrawIntegral = withdrawIntegral;
	}
	
	
}
