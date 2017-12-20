package com.demo.entity;


public class BoAttachUrl {
    private Integer id;
    private String attachUrl;
    private String attachStatus;
    private String attachEmail;

    public BoAttachUrl setId(Integer id){
        this.id = id;
        return this;
    }
    public Integer getId(){
        return this.id;
    }

    public BoAttachUrl setAttachUrl(String attachUrl){
        this.attachUrl = attachUrl;
        return this;
    }
    public String getAttachUrl(){
        return this.attachUrl;
    }

    public BoAttachUrl setAttachStatus(String attachStatus){
        this.attachStatus = attachStatus;
        return this;
    }
    public String getAttachStatus(){
        return this.attachStatus;
    }

    public BoAttachUrl setAttachEmail(String attachEmail){
        this.attachEmail = attachEmail;
        return this;
    }
    public String getAttachEmail(){
        return this.attachEmail;
    }

    
    @Override
    public String toString() {
        return "BoAttachUrl ["
        + "id=" + id +", "
        + "attachUrl=" + attachUrl +", "
        + "attachStatus=" + attachStatus +", "
        + "attachEmail=" + attachEmail +", "
       +" ]";
    }
}