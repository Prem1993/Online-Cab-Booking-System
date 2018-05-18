/*Copyright 2016 Deepak Kumar
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
This code is written by Deepak Kumar */

package com.wipro.ata.service.administrator;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.ata.bean.DriverAddressBean;
import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.dao.administrator.DriverDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DriverService {
	@Autowired
	DriverDao dao;
	public String addDriver(DriverBean driverbean, DriverAddressBean dabean){

		if(driverbean==null||dabean==null)
			return "FAIL";
		 else if(driverbean.getFirstName()==null
				||driverbean.getLastName()==null
				||driverbean.getLicenseNumber()==null
				||driverbean.getContactNumber()==null
				||driverbean.getVehicleNumber()==null
				||dabean.getHouseNumber()==0
				||dabean.getFirstLineOfAddress()==null
				||dabean.getSecondLineOfAddress()==null
				||dabean.getCity()==null
			    ||dabean.getState()==null
			    ||dabean.getPinCode()==null){
			return "FAIL";
		}
			else
			{
				return dao.addDriver(driverbean,dabean);
			}
		}
	public Object[] viewDriver(String vehicleNumber){
		return dao.viewDriver(vehicleNumber);
	}


	public String modifyDriver(DriverBean driverbean, DriverAddressBean dabean){
		return dao.modifyDriver(driverbean, dabean);
	}

	public String deleteDriver(DriverBean driverbean, DriverAddressBean dabean){
		return dao.deleteDriver(driverbean, dabean);
	}
	public ArrayList<Object[]> displayall(){
		return dao.displayall();
	}
}
