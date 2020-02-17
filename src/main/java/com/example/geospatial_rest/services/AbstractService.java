package com.example.geospatial_rest.services;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.example.geospatial_rest.ejb.DataBean;

public abstract class AbstractService {
	@EJB
	private volatile DataBean db;
	
	protected DataBean getDataBean() {
		if (db == null) {
			synchronized (NationalParkService.class) {
				if (db == null) {
					try {
						InitialContext ctx = new InitialContext();
						db = (DataBean) ctx.lookup("java:module/DataBean");
					} catch (NamingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return db;
	}
	
}
