package com.theladders.solid.srp.jobseeker;

import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;
import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.Jobseeker;

public class Jobseeker
{
  private final int id;
  private final boolean hasPremiumAccount;

  public Jobseeker(int id, boolean hasPremiumAccount)
  {
    this.id = id;
    this.hasPremiumAccount = hasPremiumAccount;
  }

  public boolean isPremium()
  {
    return hasPremiumAccount;
  }

  public int getId()
  {
    return id;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  public boolean profileIncomplete(JobseekerProfileManager jobSeekerProfileManager)
  {
    if (isPremium())
      return false;

    JobseekerProfile profile = jobSeekerProfileManager.getJobSeekerProfile(this);

    if (profile.incomplete() || profile.noProfile() || profile.removed())
      return true;
    return false;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Jobseeker other = (Jobseeker) obj;
    if (id != other.id)
      return false;
    return true;
  }
}
