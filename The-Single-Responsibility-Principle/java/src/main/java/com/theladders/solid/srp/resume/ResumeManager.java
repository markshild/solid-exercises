package com.theladders.solid.srp.resume;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.resume.MyResumeManager;

public class ResumeManager
{
  private final ResumeRepository resumeRepository;

  public ResumeManager(ResumeRepository resumeRepository)
  {
    this.resumeRepository = resumeRepository;
  }

  public Resume saveResume(Jobseeker jobseeker,
                           String fileName)
  {

    Resume resume = new Resume(fileName);
    resumeRepository.saveResume(jobseeker.getId(), resume);

    return resume;
  }

  public Resume saveNewOrRetrieveExistingResume(String newResumeFileName,
                                                 Jobseeker jobseeker,
                                                 HttpRequest request,
                                                 MyResumeManager myResumeManager)
  {
    Resume resume;

    if (request.resumeNotExist())
    {
      resume = saveResume(jobseeker, newResumeFileName);

      if (resume != null && request.activateResume())
      {
        myResumeManager.saveAsActive(jobseeker, resume);
      }
    }
    else
    {
      resume = myResumeManager.getActiveResume(jobseeker.getId());
    }

    return resume;
  }
}
