package utils;

import com.google.gson.annotations.SerializedName;

public class Environment {

    @SerializedName("urlComunidadFeliz")
    public String url;
    public String user;
    public String pass;

    public Environment() {

    }

    public String getUrl(){ return url;}
    public void setUrl(String url){ this.url = url;}

    public String getUser(){ return user;}
    public void setUser(String user){ this.user = user;}

    public String getPass(){ return pass;}
    public void setPass(String pass){ this.pass = pass;}



}
