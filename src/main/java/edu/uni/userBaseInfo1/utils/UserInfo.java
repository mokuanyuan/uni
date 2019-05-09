package edu.uni.userBaseInfo1.utils;

import edu.uni.userBaseInfo1.bean.*;

import java.util.List;

/**
 * Author: mokuanyuan 15:53 2019/5/7
 * @apiNote: 用于把所有跟user_id有关的数据记录关联到一起
 */
public class UserInfo {

    List<User> users;
    List<Ecomm> ecomms;
    List<Address> addresses;
    List<Picture> pictures;
    List<StudentRelation> studentRelations;
    List<LearningDegree> learningDegrees;
    List<EmployeeHistory> employeeHistories;
    List<Student> students;
    List<Employee> employees;
    List<UserinfoApply> userinfoApplies;
    List<PoliticalAffiliation> politicalAffiliations;
    List<AddrCountry>addrCountries;
    List<AddrState> addrStates;
    List<AddrCity>addrCities;
    List<AddrArea>addrAreas;
    List<AddrStreet>addrStreets;

    public List<AddrCountry> getAddrCountries() {
        return addrCountries;
    }

    public void setAddrCountries(List<AddrCountry> addrCountries) {
        this.addrCountries = addrCountries;
    }

    public List<AddrState> getAddrStates() {
        return addrStates;
    }

    public void setAddrStates(List<AddrState> addrStates) {
        this.addrStates = addrStates;
    }

    public List<AddrCity> getAddrCities() {
        return addrCities;
    }

    public void setAddrCities(List<AddrCity> addrCities) {
        this.addrCities = addrCities;
    }

    public List<AddrArea> getAddrAreas() {
        return addrAreas;
    }

    public void setAddrAreas(List<AddrArea> addrAreas) {
        this.addrAreas = addrAreas;
    }

    public List<AddrStreet> getAddrStreets() {
        return addrStreets;
    }

    public void setAddrStreets(List<AddrStreet> addrStreets) {
        this.addrStreets = addrStreets;
    }

    public List<PoliticalAffiliation> getPoliticalAffiliations() {
        return politicalAffiliations;
    }

    public void setPoliticalAffiliations(List<PoliticalAffiliation> politicalAffiliations) {
        this.politicalAffiliations = politicalAffiliations;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Ecomm> getEcomms() {
        return ecomms;
    }

    public void setEcomms(List<Ecomm> ecomms) {
        this.ecomms = ecomms;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public List<StudentRelation> getStudentRelations() {
        return studentRelations;
    }

    public void setStudentRelations(List<StudentRelation> studentRelations) {
        this.studentRelations = studentRelations;
    }

    public List<LearningDegree> getLearningDegrees() {
        return learningDegrees;
    }

    public void setLearningDegrees(List<LearningDegree> learningDegrees) {
        this.learningDegrees = learningDegrees;
    }

    public List<EmployeeHistory> getEmployeeHistories() {
        return employeeHistories;
    }

    public void setEmployeeHistories(List<EmployeeHistory> employeeHistories) {
        this.employeeHistories = employeeHistories;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<UserinfoApply> getUserinfoApplies() {
        return userinfoApplies;
    }

    public void setUserinfoApplies(List<UserinfoApply> userinfoApplies) {
        this.userinfoApplies = userinfoApplies;
    }


    public UserInfo() {
    }

    public UserInfo(List<User> users, List<Ecomm> ecomms, List<Address> addresses, List<Picture> pictures, List<StudentRelation> studentRelations, List<LearningDegree> learningDegrees, List<EmployeeHistory> employeeHistories, List<Student> students, List<Employee> employees, List<UserinfoApply> userinfoApplies, List<PoliticalAffiliation> politicalAffiliations, List<AddrCountry> countries, List<AddrState> states, List<AddrCity> cities, List<AddrStreet> addrStreets) {
        this.users = users;
        this.ecomms = ecomms;
        this.addresses = addresses;
        this.pictures = pictures;
        this.studentRelations = studentRelations;
        this.learningDegrees = learningDegrees;
        this.employeeHistories = employeeHistories;
        this.students = students;
        this.employees = employees;
        this.userinfoApplies = userinfoApplies;
        this.politicalAffiliations = politicalAffiliations;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "users=" + users +
                ", ecomms=" + ecomms +
                ", addresses=" + addresses +
                ", pictures=" + pictures +
                ", studentRelations=" + studentRelations +
                ", learningDegrees=" + learningDegrees +
                ", employeeHistories=" + employeeHistories +
                ", students=" + students +
                ", employees=" + employees +
                ", userinfoApplies=" + userinfoApplies +
                ", politicalAffiliations=" + politicalAffiliations +
                '}';
    }
}
