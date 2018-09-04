package com.java.TCVM;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.data.Product;
import com.java.TCVM.data.ProductRecord;

@RunWith(MockitoJUnitRunner.class)
public class ProductRecordTest {

	@InjectMocks
	private ProductRecord productRecord;
	
	@Test
	public void shouldSystemMaintainProductRecord() {
		productRecord.addProductInList(new Product("tea",1,10));
		Assert.assertNotNull(productRecord.getProductList());
	}

}
