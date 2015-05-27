package com.theladders.solid.srp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.theladders.solid.srp.http.HttpResponse;


public class ViewHandler
{
  private HttpResponse response;

  public ViewHandler(HttpResponse httpResponse)
  {
    this.response = httpResponse;
  }

  public HttpResponse provideApplySuccessView(Map<String, Object> model)
  {
    Result result = new Result("success", model);
    response.setResult(result);
    return response;
  }

  public HttpResponse provideResumeCompletionView(Map<String, Object> model)
  {
    Result result = new Result("completeResumePlease", model);
    response.setResult(result);
    return response;
  }

  public HttpResponse provideErrorView(List<String> errList, Map<String, Object> model)
  {
    Result result = new Result("error", model, errList);
    response.setResult(result);
    return response;
  }


  public HttpResponse provideInvalidJobView(int jobId)
  {
    Map<String, Object> model = new HashMap<>();
    model.put("jobId", jobId);

    Result result = new Result("invalidJob", model);
    response.setResult(result);
    return response;
  }
}
