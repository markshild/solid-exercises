package com.theladders.solid.srp.job;

import java.util.HashMap;
import java.util.Map;

import com.theladders.solid.srp.job.Job;

public class ModelJobBuilder
{
  private final Map<String, Object> model = new HashMap<>();

  public ModelJobBuilder()
  {
    this.model = model;
  }

  public Map<String, Object> buildModel(Job job)
  {
    model.put("jobId", job.getJobId());
    model.put("jobTitle", job.getTitle());
    return model;
  }
}