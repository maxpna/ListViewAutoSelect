package com.mpn.listviewautoselect;

/**
 * Created by maxpower on 3/22/2016.
 */
public class StateObject {
  public String Name="";
  public String StateCapital="";
  public String StateLetters="";
  public boolean Selected=false;

  @Override
  public String toString() {
    return Name;
  }
}
