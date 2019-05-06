/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 35 "model.ump"
public class Stand
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stand Attributes
  private String standId;

  //Stand Associations
  private List<Vote> votes;
  private ResultPage resultPage;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Stand(String aStandId, ResultPage aResultPage)
  {
    standId = aStandId;
    votes = new ArrayList<Vote>();
    boolean didAddResultPage = setResultPage(aResultPage);
    if (!didAddResultPage)
    {
      throw new RuntimeException("Unable to create stand due to resultPage");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStandId(String aStandId)
  {
    boolean wasSet = false;
    standId = aStandId;
    wasSet = true;
    return wasSet;
  }

  public String getStandId()
  {
    return standId;
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
  /* Code from template association_GetOne */
  public ResultPage getResultPage()
  {
    return resultPage;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVotes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vote addVote(int aWeight, VoteConfirmedPage aVoteConfirmedPage, DatabaseHandler aDatabaseHandler, UserVerification aUserVerification)
  {
    return new Vote(aWeight, aVoteConfirmedPage, this, aDatabaseHandler, aUserVerification);
  }

  public boolean addVote(Vote aVote)
  {
    boolean wasAdded = false;
    if (votes.contains(aVote)) { return false; }
    Stand existingStand = aVote.getStand();
    boolean isNewStand = existingStand != null && !this.equals(existingStand);
    if (isNewStand)
    {
      aVote.setStand(this);
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
    //Unable to remove aVote, as it must always have a stand
    if (!this.equals(aVote.getStand()))
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
  /* Code from template association_SetOneToMany */
  public boolean setResultPage(ResultPage aResultPage)
  {
    boolean wasSet = false;
    if (aResultPage == null)
    {
      return wasSet;
    }

    ResultPage existingResultPage = resultPage;
    resultPage = aResultPage;
    if (existingResultPage != null && !existingResultPage.equals(aResultPage))
    {
      existingResultPage.removeStand(this);
    }
    resultPage.addStand(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=votes.size(); i > 0; i--)
    {
      Vote aVote = votes.get(i - 1);
      aVote.delete();
    }
    ResultPage placeholderResultPage = resultPage;
    this.resultPage = null;
    if(placeholderResultPage != null)
    {
      placeholderResultPage.removeStand(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "standId" + ":" + getStandId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "resultPage = "+(getResultPage()!=null?Integer.toHexString(System.identityHashCode(getResultPage())):"null");
  }
}