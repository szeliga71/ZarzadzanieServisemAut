package Exceptions;


import users.Person;

import java.util.List;

public class ProblematicTenantException extends Exception {

    public ProblematicTenantException(Person person , List<String> o){



        System.out.println("Osoba  "+ person  +"  posiada na wynajmowanych pomieszczeniach " + o);
    }



}
