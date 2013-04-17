package com.zohararad;

import java.io.Serializable;
import java.util.Date;

public class EventCounter implements Serializable {

  private String event;
  private int id;
  private Date startTimestamp;
  private Date endTimestamp;
  private int count;

  public EventCounter(){
    this.count = 0;
    this.startTimestamp = new Date();
    this.endTimestamp = new Date();
  }

  public EventCounter(String e){
    this.event = e;
    this.count = 0;
    this.startTimestamp = new Date();
    this.endTimestamp = new Date();
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

  public int getCount(){
    return this.count;
  }

  public void setCount(int c){
    this.count = c;
  }

  public void addEvent(String e, int id){
    this.count++;
    this.event = e;
    this.id = id;
  }

  public void removeEvent(String e, int id){
    this.count--;
    this.event = e;
    this.id = id;
  }

}
