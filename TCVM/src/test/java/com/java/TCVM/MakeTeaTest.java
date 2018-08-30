package com.java.TCVM;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.data.Container;
import com.java.TCVM.data.Product;
import com.java.TCVM.service.DrinkAvailability;
import com.java.TCVM.service.ProductRecord;
import com.java.TCVM.service.WasteProductRecord;
import com.java.TCVM.service.makeImpl.MakeTea;

@RunWith(MockitoJUnitRunner.class)
public class MakeTeaTest {

	@Mock
	private DrinkAvailability drinkAvailability;
	
	@Mock 
	private ProductRecord productRecord;
	
	@Mock
	private WasteProductRecord wasteproductRecord;
	
	@Mock 
	private ContainerInitializer containerInitializer;
	
	@InjectMocks
	MakeTea makeTea;
	
	@Test
	public void shouldSystemSupportToMakeTea() throws IOException{
		
		when(drinkAvailability.checkAvailabilityNeededForDrink(2)).thenReturn(true);
		/*Container container = new Container();
		int value = 1000;
		container.setTeaContainer(value);
		when(container).thenReturn(container);*/
		
		/*container.setCoffeeContainer(value);
		when(containerInitializer.getContainerInstance()).thenReturn(container);	
			
		container.setCoffeeContainer(value);
		when(containerInitializer.getContainerInstance().getMilkContainer()).thenReturn(1000);

		container.setCoffeeContainer(value);
		when(containerInitializer.getContainerInstance().getSugerContaier()).thenReturn(1000);
		
		container.setCoffeeContainer(value);
		when(containerInitializer.getContainerInstance().getTeaContainer()).thenReturn(1000);

		container.setCoffeeContainer(value);
		when(containerInitializer.getContainerInstance().getWaterContainer()).thenReturn(1000);*/
		
		/*Mockito.doNothing().when(productRecord).AddProductInList(new Product("tea",2,2*10));
		Mockito.doNothing().when(wasteproductRecord).AddWasteProductInList(new Container(1*2, 0, 2*2, 5*2, 4*2));*/
		when(containerInitializer.getContainerInstance().getMilkContainer()).thenReturn(1000);
		when(containerInitializer.getContainerInstance().getSugerContaier()).thenReturn(1000);
		when(containerInitializer.getContainerInstance().getTeaContainer()).thenReturn(1000);
		when(containerInitializer.getContainerInstance().getWaterContainer()).thenReturn(1000);
		when(containerInitializer.getContainerInstance().getCoffeeContainer()).thenReturn(1000);
 

		MakeTea makeTea = new MakeTea();
		makeTea.makingDrink(2);
		verify(drinkAvailability).checkAvailabilityNeededForDrink(2);
	}
}
