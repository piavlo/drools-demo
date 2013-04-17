package com.zohararad;

import java.io.Serializable;
import java.util.Date;

public class GenericEvent implements Serializable {

  private String event;
  private int id;
  private Date startTimestamp;
  private Date endTimestamp;
  private Date time;
  private int count;

  public GenericEvent(String e, int id){
    this.event = e;
    this.id = id;
    this.count = 1;
    this.startTimestamp = new Date();
    this.endTimestamp = new Date();
    this.time = new Date();
  }

  public String getEvent(){
    return this.event;
  }

  public void setEvent(String e){
    this.event = e;
  }

  public int getId(){
    return this.id;
  }

  public void setId(int id){
    this.id = id;
  }

  public Date getStartTimestamp(){
    return this.startTimestamp;
  }

  public void setStartTimestamp(Date d){
    this.startTimestamp = d;
  }

  public Date getEndTimestamp(){
    return this.endTimestamp;
  }

  public void setEndTimestamp(Date d){
    this.endTimestamp = d;
  }

  public Date getTime(){
    return this.time;
  }

  public void setTime(Date d){
    this.time = d;
  }

  public int getCount(){
    return this.count;
  }

  public void setCount(int c){
    this.count = c;
  }
}
