/*
 * SimpleSchedulingResource.java
 */
package com.scheduling.simple.ws;

import com.scheduling.simple.model.Student;
import com.scheduling.simple.model.Class;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleSchedulingResource {
    
    private Map<Integer, Student> studentsMap;
    private Map<String,Class > classessMap;

    public SimpleSchedulingResource() {
        studentsMap = new HashMap<Integer, Student>();
        classessMap = new HashMap<String, Class>();
    }
    
    public Student createStudent(int studentId, String lastName, String firstName) {
        // TODO validate input data
        Student student = new Student(studentId, lastName, firstName);
        studentsMap.put(studentId, student);
        
        return student;
    }
    
    public Class createClass(String code, String title, String description) {
        // TODO validate input data
        Class clas = new Class(code, title, description);
        classessMap.put(code , clas);
        
        return clas;
    }
    
/*    public void addStudentToClass(int studentID, String classCode){
        
    }*/
    

    public Student retrieveStudent(int studentId) {
        return studentsMap.get(studentId);
    }
    
       public Class retrieveClass(String code) {
        return classessMap.get(code);
    }
    
    
}
