package com.pts.business;

import com.pts.exception.BillerNotFoundException;
import com.pts.hibernate.BillerDAO;
import com.pts.pojo.Biller;

public class BillerBusiness {

	public Biller getBiller(int id) throws BillerNotFoundException {
		Biller biller = null;
		try {
			biller = new BillerDAO().getBiller(id);
		} catch (BillerNotFoundException e) {
			throw e;	
		}
		return biller;
	}

	public Biller createBiller(String billerName) {
		Biller biller = new BillerDAO().createBiller(billerName);
		return biller;
	}

	public Biller updateBiller(int billerId, String billerName) {
		Biller biller = null;
		try {
			biller = new BillerDAO().updateBiller(billerId, billerName);
		} catch (BillerNotFoundException e) {
			e.printStackTrace();
		}
		return biller;
	}

	public boolean deleteBiller(int billerId) {
		return new BillerDAO().deleteBiller(billerId);
	}

}
