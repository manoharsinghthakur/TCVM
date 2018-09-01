package com.java.TCVM;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.service.ResetContainer;

@RunWith(MockitoJUnitRunner.class)
public class ResetContainerTest {

	@InjectMocks
	ResetContainer resetContainer;
	
	@Test
	public void shouldSystemSupportResetContainer() throws IOException {
		Assert.assertTrue(resetContainer.resetingContainer());
	}

}
