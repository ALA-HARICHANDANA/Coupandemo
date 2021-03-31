package com.cp.sports.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.sports.dao.CoupanRepository;
import com.cp.sports.entity.Coupan;
import com.cp.sports.exception.CoupanServiceException;

@Service

public class CoupanServiceImpl implements CoupanService{
	@Autowired
	private CoupanRepository coupanrepository;
	@Override
	public Coupan addCoupans(Coupan coupan) {
		// TODO Auto-generated method stub
		Optional<Coupan> coupan1 = coupanrepository.findById(coupan.getCoupanId());
		if (coupan1.isEmpty()) {
			return coupanrepository.saveAndFlush(coupan);
		} else {
			throw new CoupanServiceException("Coupan already exists");
		}
	}

	
	@Override
	public Coupan editCoupans(String coupanId, Coupan coupan) {
		// TODO Auto-generated method stub
		Optional<Coupan> coupan1 = coupanrepository.findById(coupanId);
		if (coupan1.isEmpty()) {
			throw new CoupanServiceException("Coupan not found");
		}
		else
		coupanrepository.save(coupan);
		return coupan;
		
	}

	@Override
	public Coupan getCoupan(String coupanId) throws CoupanServiceException{
		// TODO Auto-generated method stub
		Optional<Coupan> coupan = coupanrepository.findById(coupanId);
		if (coupan.isEmpty()) {
			throw new CoupanServiceException("Given coupanId does not exist");
		}
		return coupan.get();
	}

	@Override
	public List<Coupan> getAllCoupans() {
		// TODO Auto-generated method stub
		List<Coupan> coupan = coupanrepository.findAll();
		if (coupan.isEmpty()) {
			throw new CoupanServiceException("Coupans not found");
		}
		return coupan;
	}


	@Override
	public Coupan removeCoupans(String coupanId) throws CoupanServiceException {
		Optional<Coupan> coupan = coupanrepository.findById(coupanId);
		if (coupan.isEmpty())
			throw new CoupanServiceException("coupanId does not exist to delete");
		else
			coupanrepository.delete(coupan.get());
		
		return null;
	}


	
}
