package com.java.TCVM;

import java.io.IOException;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import com.java.TCVM.controller.TCVMMenu;
import com.java.TCVM.data.Container;
import com.java.TCVM.service.RefillContainer;

@RunWith(MockitoJUnitRunner.class)
public class RefillContainerTest {
	
	@InjectMocks
	RefillContainer refillContainer;
	
	@Mock
	TCVMMenu tcvmMenu;
	
	@Mock
	Container container;
	
	@Test
	public void shouldSystemSupportRefillContainerForTea() throws IOException{
		Mockito.doNothing().when(container).setTeaContainer(2000);
		refillContainer.refillContainer(1);
		Mockito.verify(container).setTeaContainer(2000);
	}
	
	@Test
	public void shouldSystemSupportRefillContainerForCoffee() throws IOException{
		Mockito.doNothing().when(container).setCoffeeContainer(2000);
		refillContainer.refillContainer(2);
		Mockito.verify(container).setCoffeeContainer(2000);
	}
	
	@Test
	public void shouldSystemSupportRefillContainerForWater() throws IOException{
		Mockito.doNothing().when(container).setWaterContainer(15000);
		refillContainer.refillContainer(4);
		Mockito.verify(container).setWaterContainer(15000);
	}
	
	@Test
	public void shouldSystemSupportRefillContainerForSugar() throws IOException{
		Mockito.doNothing().when(container).setSugerContaier(8000);
		refillContainer.refillContainer(3);
		Mockito.verify(container).setSugerContaier(8000);
	}
	
	@Test
	public void shouldSystemSupportRefillContainerForMilk() throws IOException{
		Mockito.doNothing().when(container).setMilkContainer(10000);
		refillContainer.refillContainer(5);
		Mockito.verify(container).setMilkContainer(10000);
	}
	
	@Test
	public void shouldSystemSupportExitingWithoutRefilling() throws IOException{
		refillContainer.refillContainer(6);
	}
	
}
