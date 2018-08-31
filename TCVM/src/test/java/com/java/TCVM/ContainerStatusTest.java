package com.java.TCVM;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.data.Container;
import com.java.TCVM.service.ContainerStatus;

@RunWith(MockitoJUnitRunner.class)
public class ContainerStatusTest {

	@InjectMocks
	ContainerStatus containerStatus;
	
	@Test
	public void shouldSystemSupportContainerStatus() throws IOException {
		
		Assert.assertTrue(containerStatus.showContainerStatus());
		
	}

}
