/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 12 "model.ump"
// line 47 "model.ump"
public class DatabaseHandler
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DatabaseHandler Attributes
  private String userId;
  private int rating;
  private int standID;

  //DatabaseHandler Associations
  private ResultPage resultPage;
  private List<Vote> votes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DatabaseHandler(String aUserId, int aRating, int aStandID, ResultPage aResultPage)
  {
    userId = aUserId;
    rating = aRating;
    standID = aStandID;
    if (aResultPage == null || aResultPage.getDatabaseHandler() != null)
    {
      throw new RuntimeException("Unable to create DatabaseHandler due to aResultPage");
    }
    resultPage = aResultPage;
    votes = new ArrayList<Vote>();
  }

  public DatabaseHandler(String aUserId, int aRating, int aStandID)
  {
    userId = aUserId;
    rating = aRating;
    standID = aStandID;
    resultPage = new ResultPage(this);
    votes = new ArrayList<Vote>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUserId(String aUserId)
  {
    boolean wasSet = false;
    userId = aUserId;
    wasSet = true;
    return wasSet;
  }

  public boolean setRating(int aRating)
  {
    boolean wasSet = false;
    rating = aRating;
    wasSet = true;
    return wasSet;
  }

  public boolean setStandID(int aStandID)
  {
    boolean wasSet = false;
    standID = aStandID;
    wasSet = true;
    return wasSet;
  }

  public String getUserId()
  {
    return userId;
  }

  public int getRating()
  {
    return rating;
  }

  public int getStandID()
  {
    return standID;
  }
  /* Code from template association_GetOne */
  public ResultPage getResultPage()
  {
    return resultPage;
  }
  /* Code from template association_GetMany */
  public Vote getVote(int index)
  {
    Vote aVote = votes.get(index);
    return aVote;
  }

  public List<Vote> getVotes()
  {
    List<Vote> newVotes = Collections.unmodifiableList(votes);
    return newVotes;
  }

  public int numberOfVotes()
  {
    int number = votes.size();
    return number;
  }

  public boolean hasVotes()
  {
    boolean has = votes.size() > 0;
    return has;
  }

  public int indexOfVote(Vote aVote)
  {
    int index = votes.indexOf(aVote);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVotes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vote addVote(int aWeight, VoteConfirmedPage aVoteConfirmedPage, Stand aStand, UserVerification aUserVerification)
  {
    return new Vote(aWeight, aVoteConfirmedPage, aStand, this, aUserVerification);
  }

  public boolean addVote(Vote aVote)
  {
    boolean wasAdded = false;
    if (votes.contains(aVote)) { return false; }
    DatabaseHandler existingDatabaseHandler = aVote.getDatabaseHandler();
    boolean isNewDatabaseHandler = existingDatabaseHandler != null && !this.equals(existingDatabaseHandler);
    if (isNewDatabaseHandler)
    {
      aVote.setDatabaseHandler(this);
    }
    else
    {
      votes.add(aVote);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVote(Vote aVote)
  {
    boolean wasRemoved = false;
    //Unable to remove aVote, as it must always have a databaseHandler
    if (!this.equals(aVote.getDatabaseHandler()))
    {
      votes.remove(aVote);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addVoteAt(Vote aVote, int index)
  {  
    boolean wasAdded = false;
    if(addVote(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVoteAt(Vote aVote, int index)
  {
    boolean wasAdded = false;
    if(votes.contains(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVoteAt(aVote, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ResultPage existingResultPage = resultPage;
    resultPage = null;
    if (existingResultPage != null)
    {
      existingResultPage.delete();
    }
    for(int i=votes.size(); i > 0; i--)
    {
      Vote aVote = votes.get(i - 1);
      aVote.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "userId" + ":" + getUserId()+ "," +
            "rating" + ":" + getRating()+ "," +
            "standID" + ":" + getStandID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "resultPage = "+(getResultPage()!=null?Integer.toHexString(System.identityHashCode(getResultPage())):"null");
  }
}