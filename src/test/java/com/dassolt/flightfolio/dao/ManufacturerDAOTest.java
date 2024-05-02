package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Manufacturer;

public class ManufacturerDAOTest {
    public static void main(String[] args) {
        Manufacturer lockheedMartin = new Manufacturer("Lockheed Martin");
        Manufacturer dassault = new Manufacturer("Dassault");

        try {
            ManufacturerDAO dao = new ManufacturerDAO();

            dao.add(lockheedMartin);
            dao.add(dassault);

             assert lockheedMartin.getId().equals(dao.findById(lockheedMartin.getId()).getId());
             assert dao.findAll().size() == 2;

             lockheedMartin.setName("Lockhead Martin");
             dao.update(lockheedMartin);

             assert lockheedMartin.getName().equals(dao.findById(lockheedMartin.getId()).getName());

             dao.delete(lockheedMartin);

             assert dao.findById(lockheedMartin.getId()) == null;

             dao.delete(dassault);

             assert dao.findAll().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
