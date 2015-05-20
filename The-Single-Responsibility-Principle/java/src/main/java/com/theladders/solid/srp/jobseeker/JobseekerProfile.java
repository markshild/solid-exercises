package com.theladders.solid.srp.jobseeker;

public class JobseekerProfile
{
  private final int id;
  private final ProfileStatus status;

  public JobseekerProfile(int id, ProfileStatus status)
  {
    this.id = id;
    this.status = status;
  }

  public ProfileStatus getStatus()
  {
    return status;
  }

  public int getId()
  {
    return id;
  }

  public boolean incomplete() {return this.status.incomplete() }

  public boolean noProfile() {return this.status.noProfile() }

  public boolean removed() {return this.status.removed() }
}
