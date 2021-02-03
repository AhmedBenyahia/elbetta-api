package com.tekup.gld.project.elbetta.model;

import javax.persistence.Table;

@Table(name = "auction_product")
public class AuctionProduct {

	private float starPrice;

	private String higherBidder;

	private Float currentPrice;
}
