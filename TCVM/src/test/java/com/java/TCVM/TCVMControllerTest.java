package com.java.TCVM;

import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.controller.InputScanner;
import com.java.TCVM.controller.TCVMController;
import com.java.TCVM.controller.TCVMMenu;
import com.java.TCVM.data.Container;

@RunWith(MockitoJUnitRunner.class)
public class TCVMControllerTest {
	
	@InjectMocks
	TCVMController tcvmController;
	
	@Mock
	InputScanner inputScanner;
	
	@Mock
	ContainerInitializer containerInitializer;
	
	@Mock
	private static Container container;
	
	@Mock
	private static TCVMMenu tcvmMenu;
	@Test
	public void mainTest() throws IOException{
		when(inputScanner.nextInt()).thenReturn(9);
		Mockito.doNothing().when(tcvmMenu).showMenu();
		TCVMController.main(null);
	}
}
