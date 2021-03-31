package com.cp.sports.servicetTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.sports.entity.Coupan;
import com.cp.sports.service.CoupanService;
@SpringBootTest
public class ICoupanServiceTest {
	@Autowired
	private CoupanService coupanService;
	
	@Test
	void addCoupanTest() {
		Coupan coupan = new Coupan("23","Diwali Coupan","Festival coupan","best offer coupan");
	assertEquals("Diwali Coupan",coupanService.addCoupans(coupan).getCoupanName().toString());
	coupanService.removeCoupans("23");
	
	}
	@Test
	void getCoupanIdtest() {
		Coupan coupan = new Coupan("22","Diwali Coupan","Festival coupan","best offer coupan");
		coupanService.addCoupans(coupan);
		assertEquals("Coupan [coupanId=22, coupanName=Diwali Coupan, coupanType=Festival coupan, coupanDescription=best offer coupan]",coupanService.getCoupan("22").toString());
coupanService.removeCoupans("22");
	}
	@Test
	void removeCoupan() {
		Coupan coupan1=new Coupan("20", "chss", "hgkjdsh", "hjhaa");
		coupanService.addCoupans(coupan1);
		assertNull(coupanService.removeCoupans("20"));
	}
	@Test
	void updateCoupan() {
		Coupan coupan = new Coupan("21","Diwali Coupan","Festival coupan","best offer coupan");
		Coupan coupan2 = new Coupan("21","Diwali Coupan","Festival special coupan","best offer coupan");
		coupanService.addCoupans(coupan);
		assertEquals("Festival special coupan",coupanService.editCoupans("21", coupan2).getCoupanType().toString());
	coupanService.removeCoupans("21");
	}
	
	
}
