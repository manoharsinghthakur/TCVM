package com.java.TCVM;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.service.ContainerStatus;
import com.java.TCVM.service.InputScanner;
import com.java.TCVM.service.ReturningMainMenu;

@RunWith(MockitoJUnitRunner.class)
public class ContainerStatusTest {

	@InjectMocks
	ContainerStatus containerStatus;

	@Mock 
	InputScanner inputScanner;
	
	
	
	/*@InjectMocks
	ReturningMainMenu returningMainMenu;*/
	@Test
	public void test() throws IOException {
		Mockito.when(inputScanner.nextInt()).thenReturn(0);
		containerStatus.showContainerStatus();
	}

}
