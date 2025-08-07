/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.factory;
/*
Djfactory.java
DJ Factory Class
Author: Maphelo Shaun Tshapile (213152231)
Date: 17 March 2025
 */

import za.ac.cput.domain.DJ;
import za.ac.cput.utilities.Helper;

public class DJfactory {

//Apply Validation and Create DJ Instances.     
    public static String validateandCreateDJ(String djId, String djName, String contactNumber, String emailAddress, String availabilityStatus) {

        String id = Helper.validatedjId(djId);

        String name = Helper.validatedjName(djName);

        String contact =Helper.validatecontactNumber(contactNumber);

        String email = Helper.validateEmailAddress(emailAddress);

        String status = Helper.validateavailabilityStatus(availabilityStatus);

        String output = id + name + contact + email + status;

        return output;

    }

}//End of Class DJfactory
