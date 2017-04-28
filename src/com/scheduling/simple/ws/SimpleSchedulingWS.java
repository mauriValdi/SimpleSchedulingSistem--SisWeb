/*
 * SimpleSchedulingWS.java
 */
package com.scheduling.simple.ws;

import com.scheduling.simple.model.Student;
import com.scheduling.simple.model.Class;
import java.util.ArrayList;
import java.util.List;
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
    
    public void addStudentToClass(@WebParam(name = "studentId") int studentId,
            @WebParam(name = "code") String code){
        resource.addStudentToClass(studentId, code);
    }
    
    public void deleteStudent(@WebParam(name= "studentId") int studentId)
    {
        resource.deleteStudent(studentId);
    }
    
    public void deleteClass(@WebParam(name = "code") String code)
    {
        resource.deleteClass(code);
    }
    
    public Student editStudent(@WebParam(name = "studentId") int studentId, 
            @WebParam(name = "lastName") String lastName, 
            @WebParam(name = "firstName") String firstName)
    {
        return resource.editStudent(studentId, firstName, lastName);
    }
    
    public Class editClass(@WebParam(name = "code") String code, 
            @WebParam(name = "title") String title, 
            @WebParam(name = "description") String description){
        return resource.editClass(code, title, description);
    }
    
    
    public List<Class> getAllClasses()
    {
        return resource.getClasses();
    }
    
    public List<Student> getAllStudents()
    {
        return resource.getStudents();
    }
    
    public List<Class> getClassesForStudent(@WebParam(name= "studentId") int studentId)
    {
        return resource.getClassesFromStudent(studentId);
    }
    
    public List<Student> getStudentsForClass(@WebParam(name= "classCode") String code)
    {
        return resource.getStudentsForClass(code);
    }
    
    public Student searchStudentByFirstName(@WebParam(name = "firstName") String firstName){
        return resource.searchStudentByFirstName(firstName);
    }
    
    public Student searchStudentByLastName(@WebParam(name = "lastName") String lastName){
        return resource.searchStudentByLastName(lastName);
    }
    
    public Class searchClassByTitle(@WebParam(name = "title") String title){
        return resource.searchClassByTitle(title);
    }
    
        public Class searchClassByDescription(@WebParam(name = "description") String description){
        return resource.searchClassByDescription(description);
    }
    
    
}
