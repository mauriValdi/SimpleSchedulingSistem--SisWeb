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
    
    private final Map<Integer, Student> studentsMap;
    private final Map<String,Class > classesMap;

    public SimpleSchedulingResource() {
        studentsMap = new HashMap<Integer, Student>();
        classesMap = new HashMap<String, Class>();
    }
    
    public Student createStudent(int studentId, String lastName, String firstName) {
        // TODO validate input data
        Student student = new Student(studentId, lastName, firstName);
        synchronized(studentsMap){
        
        studentsMap.put(studentId, student);
        }
        return student;
    }
    
    public Class createClass(String code, String title, String description) {
        // TODO validate input data
        Class clas = new Class(code, title, description);
        synchronized(classesMap){
            classesMap.put(code , clas);
        }
        return clas;
    }
    
/*    public void addStudentToClass(int studentID, String classCode){
        
    }*/
    

    public Student retrieveStudent(int studentId) {
        synchronized(studentsMap){
            return studentsMap.get(studentId);
        }
    }
    
    public Class retrieveClass(String code) {
        synchronized(classesMap){
               return classesMap.get(code);
        }
    }
    
    public void editClassTitle(String code, String title){
        synchronized(classesMap){
            classesMap.get(code).setTitle(title);
        }
    }
    
    public void editClassDescription(String code, String description){
        synchronized(classesMap){
            classesMap.get(code).setDescription(description);
        }
    }
    
    public void editStundentFirstName(int studentId, String firstName){
        synchronized(studentsMap){
            studentsMap.get(studentId).setFirstName(firstName);
        }
    }
    
    public void editStudentLastName(int studentId, String lastName){
        synchronized(studentsMap){
            studentsMap.get(studentId).setLastName(lastName);
        }
    }
    
    public void deleteStudent(int studentId)
    {
        studentsMap.remove(studentId);
    }
    
    public void deleteClass(String code)
    {
        classesMap.remove(code);
    }
    
    public void addStudentToClass(int studentId, String code)
    {
        synchronized(classesMap){
            classesMap.get(code).addId(studentId);
        }
        synchronized(studentsMap){
            studentsMap.get(studentId).addCode(code);
        }
    }
    
    public List<Student> getStudents()
    {
        synchronized(studentsMap){
            List<Student> students = new ArrayList<>(studentsMap.values());
             return students;
        }
    }
    
    public List<Class> getClasses()
    {
        synchronized(classesMap){
            List<Class> classes = new ArrayList<>(classesMap.values());
            return classes;
        }
    }
    
    public List<Class> getClassesFromStudent(int studentId)
    {
        
        List<String> studentClasses = new ArrayList<>();
        synchronized(studentsMap){
        studentClasses = studentsMap.get(studentId).getCodes();}
        List<Class> allClasses = new ArrayList<>();
        int size=studentClasses.size();
        Class thisClass = new Class(" "," "," ");
        synchronized(classesMap){
    
        for(int x=0;x<size;x++) {
            thisClass = classesMap.get(studentClasses.get(x));
            if(thisClass !=null )
                allClasses.add(thisClass);
        }
        }
        return  allClasses;
    }
    
    
    
    public List<Student> getStudentsForClass(String code)
    {
        List<Integer> classIds;
        classIds = new ArrayList<>();
        synchronized(classesMap){
            classIds = classesMap.get(code).getIds();
        }
        List<Student> allStudents = new ArrayList<>();
        int size=classIds.size();
        Student thisStudent = new Student(0," "," ");
        synchronized(studentsMap){
        for(int x=0;x<size;x++) {
            thisStudent = studentsMap.get(classIds.get(x));
            if(thisStudent !=null )
                allStudents.add(thisStudent);
        }
        }
        return  allStudents;
    }
    
    public Student editStudent(int id, String firstName, String LastName){
        synchronized(studentsMap){
            studentsMap.get(id).setFirstName(firstName);
            studentsMap.get(id).setLastName(LastName);
        }
        
        return studentsMap.get(id); 
    }
    
    public Class editClass(String code, String title, String description){
        synchronized(classesMap){
            classesMap.get(code).setTitle(title);
            classesMap.get(code).setTitle(description);
        }
        return classesMap.get(code);
    }
    
    public Student searchStudentByFirstName(String firstName){
        List<Student> allStudents = getStudents();
        int cuantity = allStudents.size();
        Student result = new Student(0," "," ");
        int cont =1;
        Boolean encontro = false;
        while(cont<cuantity && !encontro){
            if(allStudents.get(cont).getFirstName().equals(firstName)){
                result = allStudents.get(cont);
                encontro = true;
            }
        }
        return result;
    }
    
    public Student searchStudentByLastName(String lastName){
        List<Student> allStudents = getStudents();
        int cuantity = allStudents.size();
        Student result = new Student(0," "," ");
        int cont =1;
        Boolean encontro = false;
        while(cont<cuantity && !encontro){
            if(allStudents.get(cont).getLastName().equals(lastName)){
                result = allStudents.get(cont);
                encontro = true;
            }
        }
        return result;
    }
    
    public Class searchClassByTitle(String title){
        List<Class> allClasses = getClasses();
        int cuantity = allClasses.size();
        Class result = new Class(""," "," ");
        int cont =1;
        Boolean encontro = false;
        while(cont<cuantity && !encontro){
            if(allClasses.get(cont).getTitle().equals(title)){
                result = allClasses.get(cont);
                encontro = true;
            }
        }
        return result;
    }
    
    public Class searchClassByDescription(String description){
        List<Class> allClasses = getClasses();
        int cuantity = allClasses.size();
        Class result = new Class(""," "," ");
        int cont =1;
        Boolean encontro = false;
        while(cont<cuantity && !encontro){
            if(allClasses.get(cont).getDescription().equals(description)){
                result = allClasses.get(cont);
                encontro = true;
            }
        }
        return result;
    }
        
    
        
        
        
        
    
    
    
    
}
    
    
    
    

