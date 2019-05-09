/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.Showroom;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Anonymous
 */
@WebService(serviceName = "showRoom")
public class showRoom {

    @PersistenceContext(unitName = "carShowRoomPU")
    private EntityManager em;
    @Resource
    private UserTransaction utx;
    Showroom showroom = new Showroom();
    private List<Showroom> showroomList = new ArrayList<>();
    List<String> colors = new ArrayList<String>();
//a web servcie method to insert the values to the car show room table

    @WebMethod(operationName = "insert")
    public String insert(@WebParam(name = "carMake") String carMake,
            @WebParam(name = "color") String color,
            @WebParam(name = "registrationNumber") String registrationNumber,
            @WebParam(name = "yearOfManufacturing") int yearOfManufacturing,
            @WebParam(name = "type") String type,
            @WebParam(name = "availability") String availability
    ) {
//java persistence API persist

        if (colors.contains(color)) {

            try {
                showroom.setAvailability(availability);
                showroom.setCarMake(carMake);
                showroom.setColor(color);
                showroom.setDateCreated(new java.util.Date());
                showroom.setDateUpdated(new java.util.Date());
                showroom.setRegistrationNumber(registrationNumber);
                showroom.setType(type);
                showroom.setYearOfManufacturing(yearOfManufacturing);
                showroom.setDeleted(0);

                utx.begin();
                em.persist(showroom);
                utx.commit();

            } catch (Exception ex) {
            }
        } else {
            return "color not accepted";
        }
        return "successfuly Inserted";
    }
//service to do update of the car based on color and availability

    @WebMethod(operationName = "update")
    public String update(
            @WebParam(name = "registrationNumber") String registrationNumber,
            @WebParam(name = "color") String color,
            @WebParam(name = "availability") String availability
    ) {

        Showroom car = (Showroom) em.createQuery("Select s from Showroom s where s.registrationNumber = '" + registrationNumber + "' and s.deleted = 0").getSingleResult();
        try {
            car.setColor(color);
            car.setAvailability(availability);
            utx.begin();
            em.merge(car);
            utx.commit();
            return "successfuly updated color and availability";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
//web service method to do a soft delete only sets status to 1

    @WebMethod(operationName = "delete")
    public String delete(
            @WebParam(name = "registrationNumber") String registrationNumber
    ) {
        try {
            Showroom car = (Showroom) em.createQuery("Select s from Showroom s where s.registrationNumber = '" + registrationNumber + "' and s.deleted = 0").getSingleResult();
            car.setDeleted(1);
            utx.begin();
            em.merge(car);
            utx.commit();
            return "successfuly deleted";
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }
//Retrieves a value based on make and color giv en

    @WebMethod(operationName = "getBasedOnMakeAndColor")
    public String getBasedOnMakeAndColor(@WebParam(name = "carMake") String carMake,
            @WebParam(name = "color") String color
    ) {
        showroomList = em.createQuery("SELECT s FROM Showroom s WHERE s.carMake = '" + carMake + "' and s.color = '" + color + "' and s.deleted = 0").getResultList();
        StringBuilder br = new StringBuilder();
        for (Showroom sh : showroomList) {
            br.append(" Availability :" + sh.getAvailability() + " Car Make :" + sh.getCarMake() + " Color :" + sh.getColor() + " Year :" + sh.getYearOfManufacturing() + " Number :" + sh.getRegistrationNumber() + "  Type :" + sh.getType());
        }
        return br.toString();
    }
//Web method to get a car that is blue and available

    @WebMethod(operationName = "getBlueAndAvailable")
    public String getBlueAndAvailable() {
        showroomList = em.createQuery("SELECT s FROM Showroom s WHERE s.availability = '1' and s.color = 'blue' and s.deleted = 0").getResultList();
        StringBuilder br = new StringBuilder();
        for (Showroom sh : showroomList) {
            br.append(" Availability " + sh.getAvailability() + " Car Make " + sh.getCarMake() + " Color " + sh.getColor() + " Year " + sh.getYearOfManufacturing() + " Number " + sh.getRegistrationNumber() + "  Type " + sh.getType());
        }
        return br.toString();
    }
//A method to get only accepted colors. based on this method a client can obtain accepted colors

    @WebMethod(operationName = "carColors")
    public List carColors() {
        colors = new ArrayList<>();
        colors.add("white");
        colors.add("blue");
        colors.add("yellow");
        colors.add("green");
        colors.add("red");
        return colors;
    }
}
