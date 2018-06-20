/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

/**
 *
 * @author Yunying
 */
public enum TypeEnum {   
    FUN("Having fun"),
    LIFE("Life story"),
    TEACH("Teaching topic"),
    POLITICS("Politics discuss");
    
    private final String label;

    
    private TypeEnum(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }
    
}