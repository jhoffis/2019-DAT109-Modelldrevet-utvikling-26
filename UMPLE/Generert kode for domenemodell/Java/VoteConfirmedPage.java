/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 20 "model.ump"
// line 54 "model.ump"
public class VoteConfirmedPage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VoteConfirmedPage Attributes
  private String userMessage;

  //VoteConfirmedPage Associations
  private Vote vote;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VoteConfirmedPage(String aUserMessage, Vote aVote)
  {
    userMessage = aUserMessage;
    if (aVote == null || aVote.getVoteConfirmedPage() != null)
    {
      throw new RuntimeException("Unable to create VoteConfirmedPage due to aVote");
    }
    vote = aVote;
  }

  public VoteConfirmedPage(String aUserMessage, int aWeightForVote, Stand aStandForVote, DatabaseHandler aDatabaseHandlerForVote, UserVerification aUserVerificationForVote)
  {
    userMessage = aUserMessage;
    vote = new Vote(aWeightForVote, this, aStandForVote, aDatabaseHandlerForVote, aUserVerificationForVote);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUserMessage(String aUserMessage)
  {
    boolean wasSet = false;
    userMessage = aUserMessage;
    wasSet = true;
    return wasSet;
  }

  public String getUserMessage()
  {
    return userMessage;
  }
  /* Code from template association_GetOne */
  public Vote getVote()
  {
    return vote;
  }

  public void delete()
  {
    Vote existingVote = vote;
    vote = null;
    if (existingVote != null)
    {
      existingVote.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "userMessage" + ":" + getUserMessage()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "vote = "+(getVote()!=null?Integer.toHexString(System.identityHashCode(getVote())):"null");
  }
}