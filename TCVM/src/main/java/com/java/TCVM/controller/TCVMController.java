package com.java.TCVM.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.java.TCVM.service.ContainerStatus;
import com.java.TCVM.service.InputScanner;
import com.java.TCVM.service.ProductRecord;
import com.java.TCVM.service.RefillContainer;
import com.java.TCVM.service.ResetContainer;
import com.java.TCVM.service.TotalSale;
import com.java.TCVM.service.WasteProductRecord;
import com.java.TCVM.service.availabilityImpl.BlackCoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.BlackTeaAvailability;
import com.java.TCVM.service.availabilityImpl.CoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.TeaAvailability;
import com.java.TCVM.service.makeImpl.MakeBlackCoffee;
import com.java.TCVM.service.makeImpl.MakeBlackTea;
import com.java.TCVM.service.makeImpl.MakeCoffee;
import com.java.TCVM.service.makeImpl.MakeTea;
public class TCVMController {
	
	
	
	public static void main(String[] args) throws IOException {
		new ContainerInitializer().getContainerInstance();
		new TCVMMenu(new InputScanner(),new MakeTea(new ContainerInitializer(),new ProductRecord(),new WasteProductRecord()),new MakeCoffee(new ContainerInitializer(),new ProductRecord(),new WasteProductRecord()),new MakeBlackTea(new ContainerInitializer(),new ProductRecord(),new WasteProductRecord()),new MakeBlackCoffee(new ContainerInitializer(),new ProductRecord(),new WasteProductRecord()),new TeaAvailability(),new CoffeeAvailability(),new BlackTeaAvailability(),new BlackCoffeeAvailability(),new RefillContainer(),new ContainerStatus(),new ResetContainer(),new TotalSale(new ProductRecord(),Logger.getLogger(Logger.GLOBAL_LOGGER_NAME))).showMenu();

	}
}