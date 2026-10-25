/**************************************
Author: Patrick Vandergrift
Date: Aug. 30, 2026
Description: Class to handle quarterback information
****************************************/

//CLASS Quarterback Description
/********************************************************
Purpose:  Class to handle quarterback information
Attributes: name (String), attemptPass (int), completions (int),
  yards (int), touchdowns (int), interceptions (int)
Methods: Quarterback(), setName(), setAttempt(), setComp(),
  setYards(), setTDowns(), setIntercept(), getName(),
  getAttempt(), getComp(), getYards(), getTDowns(), getIntercept(),
  getRating(), print()
**********************************************************/
public class Quarterback
{
  String name;
  int attemptPass;
  int completions;
  int yards;
  int touchdowns;
  int interceptions;
  
  public Quarterback()
  {
    name = "";
    attemptPass=0;
    completions=0;
    yards=0;
    touchdowns=0;
    interceptions=0;
  }
  
  public Quarterback(String name, int attPass, int comp, int yards, int tds, int inter)
  {
    this.name = name;
    this.attemptPass = attPass;
    this.completions = comp;
    this.yards = yards;
    this.touchdowns = tds;
    this.interceptions = inter;
  }
  
  public void setName(String name){this.name = name;}
  public void setAttempt(int attPass){this.attemptPass = attPass;}
  public void setComp(int comp){this.completions = comp;}
  public void setYards(int yards){this.yards = yards;}
  public void setTDowns(int tds){this.touchdowns = tds;}
  public void setIntercept(int inter){this.interceptions = inter;}
  public String getName(){return name;}
  public int getAttempt(){return attemptPass;}
  public int getComp(){return completions;}
  public int getYards(){return yards;}
  public int getTDowns(){return touchdowns;}
  public int getIntercept(){return interceptions;}
  
  public double getRating()
  {
    double compPercent=0, yardAtt=0, tDownPercent=0, interPecent=0;
    double rating=0;
    //Rating Formula
    compPercent = (((double) completions/attemptPass) - 0.3) * 5.0;
    yardAtt = (((double) yards/attemptPass) - 3) * 0.25;
    tDownPercent = ((double) touchdowns/attemptPass) * 20.0;
    interPecent = 2.375 - (((double) interceptions/attemptPass) * 25);
    compPercent = Math.max(0.0, Math.min(compPercent, 2.375));
    yardAtt = Math.max(0.0, Math.min(yardAtt, 2.375));
    tDownPercent= Math.max(0.0, Math.min(tDownPercent, 2.375));
    interPecent = Math.max(0.0, Math.min(interPecent, 2.375));
    rating = (((compPercent + yardAtt + tDownPercent+ interPecent))/6.0) * 100.0;
    return rating;
  }
  
  public void print()
  {
    System.out.printf(getName() + getAttempt() + getComp() + getYards() + getTDowns() +
    getIntercept() + getRating());
  }
}
