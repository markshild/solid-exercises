package com.theladders.solid.srp.http;

import java.util.Map;

public class HttpRequest
{
  private final HttpSession session;
  private final Map<String, String> parameters;

  public HttpRequest(HttpSession session,
                     Map<String,String> parameters)
  {
    this.session = session;
    this.parameters = parameters;
  }

  public HttpSession getSession()
  {
    return session;
  }

  public String getParameter(String key)
  {
    return parameters.get(key);
  }

  public int getJobId()
  {
    String stringId = parameters.get("jobId");
    return Integer.parseInt(stringId);
  }

  public boolean resumeNotExist()
  {
    return "existing" != parameters.get("whichResume");
  }

  public boolean activateResume()
  {
    return parameters.get("makeResumeActive") == "yes";
  }
}
