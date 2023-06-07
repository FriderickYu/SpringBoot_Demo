package org.ytq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Encapulation<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Encapulation<T> success(){
        return new Encapulation<>(20000,"success",null);
    }

    public static <T> Encapulation<T> success(T data){
        return new Encapulation<>(20000,"success",data);
    }

    public static <T> Encapulation<T> success(T data,String message){
        return new Encapulation<>(20000,message,data);
    }

    public static <T> Encapulation<T> success(String message){
        return new Encapulation<>(20000,message,null);
    }

    public static<T>  Encapulation<T> fail(){
        return new Encapulation<>(20001,"fail",null);
    }

    public static<T>  Encapulation<T> fail(Integer code){
        return new Encapulation<>(code,"fail",null);
    }

    public static<T>  Encapulation<T> fail(Integer code, String message){
        return new Encapulation<>(code,message,null);
    }

    public static<T>  Encapulation<T> fail( String message){
        return new Encapulation<>(20001,message,null);
    }


}
