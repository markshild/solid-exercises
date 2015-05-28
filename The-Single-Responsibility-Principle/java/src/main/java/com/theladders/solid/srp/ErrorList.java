package com.theladders.solid.srp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshildkret on 5/28/15.
 */
public class ErrorList
{
  private List<String> errList;

  public ErrorList()
  {
    this.errList = new ArrayList<>();
  }

  public void add(String error)
  {
    errList.add(error);
  }

  public void addApplicationError()
  {
    add("We could not process your application.");
  }

  public List<String> toList()
  {
    return errList;
  }
}
