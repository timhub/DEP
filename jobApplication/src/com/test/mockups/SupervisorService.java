package com.test.mockups;

import java.util.LinkedList;

import com.test.entity.SupervisorItem;

public class SupervisorService {
	LinkedList<SupervisorItem> list = new LinkedList<SupervisorItem>();
	

	private SupervisorItem total = new SupervisorItem();
	
	public LinkedList<SupervisorItem> getSupervisorService(){
		SupervisorItem a = new SupervisorItem();
		a.setNum("45600");
		a.setBranch_name("Beverly Hills");
		a.setTotal_branch("9");
		a.setRegistered_branch("6");
		a.setRegistered("67%");
		a.setRegistered_clients("534");
		a.setHeldaway_clients("141");
		a.setInternal("$2.8");
		a.setAggregated("$2.6");
		a.setHeldaway_manual("$3.2");
		a.setTotal_heldaway("$6.8");
		a.setTotal_internal_heldaway("$8.6");
		list.add(a);
		
		SupervisorItem b = new SupervisorItem();
		b.setNum("12345");
		b.setBranch_name("Brentwood");
		b.setTotal_branch("10");
		b.setRegistered_branch("6");
		b.setRegistered("50%");
		b.setRegistered_clients("527");
		b.setHeldaway_clients("141");
		b.setInternal("$2.8");
		b.setAggregated("$5.4");
		b.setHeldaway_manual("$0.3");
		b.setTotal_heldaway("$5.7");
		b.setTotal_internal_heldaway("$8.6");
		list.add(b);
		
		SupervisorItem c = new SupervisorItem();
		c.setNum("08904");
		c.setBranch_name("Century City");
		c.setTotal_branch("12");
		c.setRegistered_branch("4");
		c.setRegistered("33%");
		c.setRegistered_clients("420");
		c.setHeldaway_clients("104");
		c.setInternal("$3.5");
		c.setAggregated("$6.4");
		c.setHeldaway_manual("$3.0");
		c.setTotal_heldaway("$5.8");
		c.setTotal_internal_heldaway("$10.5");
		list.add(c);
		
		SupervisorItem d = new SupervisorItem();
		d.setNum("78965");
		d.setBranch_name("Santa Monica");
		d.setTotal_branch("5");
		d.setRegistered_branch("4");
		d.setRegistered("80%");
		d.setRegistered_clients("303");
		d.setHeldaway_clients("142");
		d.setInternal("$1.6");
		d.setAggregated("$0.3");
		d.setHeldaway_manual("$1.7");
		d.setTotal_heldaway("$2.0");
		d.setTotal_internal_heldaway("$3.6");
		list.add(d);
		
		SupervisorItem e = new SupervisorItem();
		e.setNum("84211");
		e.setBranch_name("Venice");
		e.setTotal_branch("11");
		e.setRegistered_branch("6");
		e.setRegistered("55%");
		e.setRegistered_clients("399");
		e.setHeldaway_clients("86");
		e.setInternal("$2.3");
		e.setAggregated("$6.0");
		e.setHeldaway_manual("0.3");
		e.setTotal_heldaway("$3.7");
		e.setTotal_internal_heldaway("$6.0");
		list.add(e);
		
		total.setNum("1356");
		total.setBranch_name("Westside Complex");
		total.setTotal_branch("45");
		total.setRegistered_branch("24");
		total.setRegistered("53%");
		total.setRegistered_clients("2,183");
		total.setHeldaway_clients("614");
		total.setInternal("$13.2");
		total.setAggregated("$15.5");
		total.setHeldaway_manual("$8.6");
		total.setTotal_heldaway("$24.1");
		total.setTotal_internal_heldaway("$37.3");
		
		return list;
	}
	
	public SupervisorItem getTotal() {
		return total;
	}

	public void setTotal(SupervisorItem total) {
		this.total = total;
	}
}
