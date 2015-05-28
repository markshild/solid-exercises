package com.theladders.solid.srp.job.application;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

public class JobApplicationSystem
{
  private final JobApplicationRepository repository;
  private final ResumeManager            resumeManager;

  public JobApplicationSystem(JobApplicationRepository repository,
                              ResumeManager resumeManager)
  {
    this.repository = repository;
    this.resumeManager = resumeManager;
  }

  public void apply(HttpRequest request,
                                    Jobseeker jobseeker,
                                    Job job,
                                    String fileName,
                                    MyResumeManager myResumeManager)
  {
    Resume resume = resumeManager.saveNewOrRetrieveExistingResume(fileName,jobseeker, request, myResumeManager);
    UnprocessedApplication application = new UnprocessedApplication(jobseeker, job, resume);
    JobApplicationResult applicationResult = processApplication(application);

    if (applicationResult.failure())
    {
      throw new ApplicationFailureException(applicationResult.toString());
    }
  }

  private JobApplicationResult processApplication(UnprocessedApplication application)
  {
    if (application.isValid() &&
        !repository.applicationExistsFor(application.getJobseeker(), application.getJob()))
    {

      SuccessfulApplication success = application.toSuccessfulApplication();

      repository.add(success);

      return success;
    }

    return new FailedApplication();
  }
}
