package com.uas.model;

import java.io.Serializable;

public class DataSource implements Serializable{

    private Integer id;

    private String name;

    private String username;

   private String driverclass;

    private Integer port;

    private String password;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriverclass() {
        return driverclass;
    }

    public void setDriverclass(String driverclass) {
        this.driverclass = driverclass;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 生成beanID
     * */
    public String getBeanId(){
        return this.id+"_"+this.getUsername();
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", driverclass='" + driverclass + '\'' +
                ", port=" + port +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
