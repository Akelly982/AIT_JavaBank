/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aitbank.Accounts;


public class Login extends AITBank {
    
    
    
    // needed to get it out of the abstract class
    @Override  // check password is correct 
    public boolean login(String inputUserPin){    
                // compares the content instead of using == which will be trying to match the memory location (0xhf2)
        if (inputUserPin.equals(super.password)){
            return true;
        }
        else{
          return false; 
        }                     
    }
    
    public String getPin(){
        return super.password;
    }
    
}

