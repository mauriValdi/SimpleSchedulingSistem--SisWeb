/*
 * SimpleSchedulingWS.java
 */
package com.scheduling.simple.ws;

import com.scheduling.simple.model.Student;
import com.scheduling.simple.model.Class;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SimpleSchedulingWS {
    
    private final SimpleSchedulingResource resource = new SimpleSchedulingResource();
    
    /**
     * Creates a new student.
     * @param studentId Integer
     * @param lastName String
     * @param firstName String
     * @return 
     */
        /**
     * Creates a new class.
     * @param code String
     * @param title String
     * @param description String
     * @return 
     */
    public Student createStudent(@WebParam(name = "studentId") int studentId, 
            @WebParam(name = "lastName") String lastName, 
            @WebParam(name = "firstName") String firstName) {
        return resource.createStudent(studentId, lastName, firstName);
    }
    
    public Class createClass(@WebParam(name = "code") String code, 
            @WebParam(name = "title") String title, 
            @WebParam(name = "description") String description) {
        return resource.createClass(code, title, description);
    }
    
    /**
     * Return a student based on its studentId.
     * @param studentId Integer
     * @return 
     */
        public Student retrieveStudent(@WebParam(name = "studentId") int studentId) {
        return resource.retrieveStudent(studentId);
    }
    
        /**
     * Return a class based on its code.
     * @param code String
     * @return 
     */
    
    
    public Class retrieveClass(@WebParam(name = "code") String code) {
        return resource.retrieveClass(code);
    }
    
    // add more methods to createClass, registerStudentToClass
}
