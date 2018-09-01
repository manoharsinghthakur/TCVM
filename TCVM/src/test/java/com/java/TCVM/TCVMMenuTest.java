package com.java.TCVM;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.controller.TCVMMenu;
import com.java.TCVM.service.ContainerStatus;
import com.java.TCVM.service.InputScanner;
import com.java.TCVM.service.RefillContainer;
import com.java.TCVM.service.ResetContainer;
import com.java.TCVM.service.TotalSale;
import com.java.TCVM.service.availabilityImpl.BlackCoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.BlackTeaAvailability;
import com.java.TCVM.service.availabilityImpl.CoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.TeaAvailability;
import com.java.TCVM.service.makeImpl.MakeBlackCoffee;
import com.java.TCVM.service.makeImpl.MakeBlackTea;
import com.java.TCVM.service.makeImpl.MakeCoffee;
import com.java.TCVM.service.makeImpl.MakeTea;

@RunWith(MockitoJUnitRunner.class)
public class TCVMMenuTest {

	@InjectMocks
	TCVMMenu tcvmMenu;

	@Mock
	InputScanner inputScanner;

	@Mock
	TeaAvailability teaAvailability;

	@Mock
	CoffeeAvailability coffeeAvailability;

	@Mock
	BlackCoffeeAvailability blackCoffeeAvailability;

	@Mock
	BlackTeaAvailability blackTeaAvailability;

	@Mock
	RefillContainer refillContainer;

	@Mock
	TotalSale checkTotalSale;

	@Mock
	ContainerStatus containerStatus;

	@Mock
	ResetContainer resetContainer;

	@Mock
	MakeTea makeTea;

	@Mock
	MakeCoffee makeCoffee;

	@Mock
	MakeBlackTea makeBlackTea;

	@Mock
	MakeBlackCoffee makeBlackCoffee;

	@Test
	public void shouldCheckSwitchCaseOneMakeTeaNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(1);
		when(teaAvailability.checkAvailabilityNeededForDrink(anyInt())).thenReturn(false);

		tcvmMenu.showMenu();

		verify(teaAvailability).checkAvailabilityNeededForDrink(1);
	}

	@Test
	public void shouldCheckSwitchCaseOneMakeTea() throws IOException {
		when(inputScanner.nextInt()).thenReturn(1).thenReturn(2);
		when(teaAvailability.checkAvailabilityNeededForDrink(anyInt())).thenReturn(true);
		doNothing().when(makeTea).makingDrink(anyInt());
		tcvmMenu.showMenu();

		verify(teaAvailability).checkAvailabilityNeededForDrink(anyInt());
	}

	@Test
	public void shouldCheckSwitchCaseTwoMakeCoffeeNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(2);
		when(coffeeAvailability.checkAvailabilityNeededForDrink(anyInt())).thenReturn(false);

		tcvmMenu.showMenu();

		verify(coffeeAvailability).checkAvailabilityNeededForDrink(2);
	}

	@Test
	public void shouldCheckSwitchCaseTwoMakeCoffe() throws IOException {

		when(inputScanner.nextInt()).thenReturn(2);
		when(coffeeAvailability.checkAvailabilityNeededForDrink(Mockito.anyInt())).thenReturn(true);
		doNothing().when(makeCoffee).makingDrink(anyInt());
		tcvmMenu.showMenu();

		verify(inputScanner, Mockito.atLeast(1)).nextInt();
	}

	@Test
	public void shouldCheckSwitchCaseThreeMakeBlackTeaNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(3);
		when(blackTeaAvailability.checkAvailabilityNeededForDrink(Mockito.anyInt())).thenReturn(false);

		tcvmMenu.showMenu();

		verify(blackTeaAvailability).checkAvailabilityNeededForDrink(3);
	}

	@Test
	public void shouldCheckSwitchCaseThreeMakeBlackTea() throws IOException {
		when(inputScanner.nextInt()).thenReturn(3);
		when(blackTeaAvailability.checkAvailabilityNeededForDrink(anyInt())).thenReturn(true);
		doNothing().when(makeBlackTea).makingDrink(anyInt());

		tcvmMenu.showMenu();

		verify(inputScanner, Mockito.atLeast(1)).nextInt();
	}

	@Test
	public void shouldCheckSwitchCaseFourMakeBlackCoffeeNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(4);
		when(blackCoffeeAvailability.checkAvailabilityNeededForDrink(Mockito.anyInt())).thenReturn(false);

		tcvmMenu.showMenu();

		verify(blackCoffeeAvailability).checkAvailabilityNeededForDrink(4);
	}

	@Test
	public void shouldCheckSwitchCaseFourMakeBlackCoffee() throws IOException {
		when(inputScanner.nextInt()).thenReturn(4);
		when(blackCoffeeAvailability.checkAvailabilityNeededForDrink(anyInt())).thenReturn(true);
		doNothing().when(makeBlackCoffee).makingDrink(anyInt());

		tcvmMenu.showMenu();

		verify(inputScanner, Mockito.atLeast(1)).nextInt();

	}

	@Test
	public void shouldCheckSwitchCaseFiveRefillContainer() throws IOException {
		when(inputScanner.nextInt()).thenReturn(5).thenReturn(1);
		Mockito.doNothing().when(refillContainer).refillContainer(Mockito.anyInt());

		tcvmMenu.showMenu();

		Mockito.verify(refillContainer).refillContainer(Mockito.anyInt());
	}

	@Test
	public void shouldCheckSwitchCaseSixCheckTotalSale() throws IOException {
		when(inputScanner.nextInt()).thenReturn(6).thenReturn(1);
		Mockito.doNothing().when(checkTotalSale).productTotalSale();

		tcvmMenu.showMenu();

		Mockito.verify(checkTotalSale).productTotalSale();
	}

	@Test
	public void shouldCheckSwitchCaseSevenContainerStatus() throws IOException {
		when(inputScanner.nextInt()).thenReturn(7).thenReturn(1);
		Mockito.when(containerStatus.showContainerStatus()).thenReturn(true);
		tcvmMenu.showMenu();
		Mockito.verify(containerStatus).showContainerStatus();

	}

	@Test
	public void shouldCheckSwitchCaseEightResetContainer() throws IOException {
		when(inputScanner.nextInt()).thenReturn(8).thenReturn(1);
		Mockito.when(resetContainer.resetingContainer()).thenReturn(true);
		tcvmMenu.showMenu();
		Mockito.verify(resetContainer).resetingContainer();
	}
}
