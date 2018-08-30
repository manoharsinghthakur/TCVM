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
	public void shouldSystemSupportRefillContainer() throws IOException{
		Mockito.doNothing().when(container).setTeaContainer(2000);
		refillContainer.refillContainer(1);
		Mockito.verify(container).setTeaContainer(2000);
	}
}
