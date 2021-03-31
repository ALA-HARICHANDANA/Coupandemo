package com.cp.sports.service;

import java.util.List;

import com.cp.sports.entity.Coupan;
import com.cp.sports.exception.CoupanServiceException;

public interface CoupanService {

	public Coupan addCoupans(Coupan coupan);

	public  Coupan editCoupans(String coupanId, Coupan coupan); 

	public  Coupan removeCoupans(String coupanId) throws CoupanServiceException;
	
	public Coupan getCoupan(String coupanId) throws CoupanServiceException;

	public List<Coupan> getAllCoupans();

}
