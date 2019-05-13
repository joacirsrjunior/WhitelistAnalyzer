package br.com.joacirjunior.whitelist.enums;

public enum ECommandType {

    INSERTION(1),
    VALIDATION(2);

    private Integer value;

    ECommandType(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }

}
