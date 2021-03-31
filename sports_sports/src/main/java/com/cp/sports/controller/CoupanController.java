package com.cp.sports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.sports.entity.Coupan;
import com.cp.sports.exception.CoupanServiceException;
import com.cp.sports.service.CoupanService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/")
@Api
public class CoupanController {
	
	@Autowired
	
	private CoupanService coupanService;

	@PostMapping("/addcoupan")
	public ResponseEntity<Coupan> insertCoupan(@RequestBody Coupan coupan){
		Coupan resultcoupan = coupanService.addCoupans(coupan);
		return new ResponseEntity<Coupan>(resultcoupan,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecoupan/{id}")
	public void deleteCoupan(@PathVariable String id) throws CoupanServiceException{
	coupanService.removeCoupans(id);
	}
	
	@PutMapping("/editcoupan")
	public ResponseEntity<Coupan> editCoupans(@RequestBody Coupan coupan) {
		Coupan resultCoupan = coupanService.editCoupans(coupan.getCoupanId(),coupan);
		return new ResponseEntity<Coupan>(resultCoupan, HttpStatus.OK);
	}
	
	@GetMapping("/findcoupan/{id}")
	public ResponseEntity<Coupan> findCoupan(@PathVariable String id) throws CoupanServiceException{
		Coupan resultCoupan = coupanService.getCoupan(id);
		return new ResponseEntity<Coupan>(resultCoupan, HttpStatus.OK);
	}
	
	@GetMapping("/allcoupans")
	public ResponseEntity<List<Coupan>> getAllCoupan(){
		List<Coupan> resultCoupan = coupanService.getAllCoupans();
		return new ResponseEntity<List<Coupan>>(resultCoupan, HttpStatus.OK);
	}
	
}
