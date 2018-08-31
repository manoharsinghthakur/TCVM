package com.java.TCVM;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.data.Container;
import com.java.TCVM.service.ProductRecord;
import com.java.TCVM.service.WasteProductRecord;
import com.java.TCVM.service.makeImpl.MakeCoffee;
import com.java.TCVM.service.makeImpl.MakeTea;

@RunWith(MockitoJUnitRunner.class)
public class MakeCoffeeTest {
	
	@InjectMocks
	private MakeCoffee makeCoffee;
	
	@Mock
	private ContainerInitializer containerInitializer;
	
	@Mock
	private ProductRecord productRecord;
	
	@Mock
	WasteProductRecord wasteproductRecord;
	
	
	@Test
	public void shouldSystemSupportToMakeCoffee() throws IOException{
		
		Container container = new Container(1, 0 , 0 ,0, 0);
		
		when(containerInitializer.getContainerInstance()).thenReturn(container);
		
		makeCoffee.makingDrink(2);
	 	
	 	verify(containerInitializer, Mockito.atLeast(1)).getContainerInstance();
	
	}
}