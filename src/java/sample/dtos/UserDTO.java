/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.io.Serializable;

/**
 *
 * @author phath
 */
public class UserDTO implements Serializable {
    private String userID;
    private String fullName;
    private String role;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, String role, String password) {
        this.userID = userID;
        this.fullName = fullName;
        this.role = role;
        this.password = password;
    }

    public UserDTO(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
