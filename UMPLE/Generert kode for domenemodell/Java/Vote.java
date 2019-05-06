/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 24 "model.ump"
// line 59 "model.ump"
public class Vote
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vote Attributes
  private int weight;

  //Vote Associations
  private VoteConfirmedPage voteConfirmedPage;
  private Stand stand;
  private DatabaseHandler databaseHandler;
  private UserVerification userVerification;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vote(int aWeight, VoteConfirmedPage aVoteConfirmedPage, Stand aStand, DatabaseHandler aDatabaseHandler, UserVerification aUserVerification)
  {
    weight = aWeight;
    if (aVoteConfirmedPage == null || aVoteConfirmedPage.getVote() != null)
    {
      throw new RuntimeException("Unable to create Vote due to aVoteConfirmedPage");
    }
    voteConfirmedPage = aVoteConfirmedPage;
    boolean didAddStand = setStand(aStand);
    if (!didAddStand)
    {
      throw new RuntimeException("Unable to create vote due to stand");
    }
    boolean didAddDatabaseHandler = setDatabaseHandler(aDatabaseHandler);
    if (!didAddDatabaseHandler)
    {
      throw new RuntimeException("Unable to create vote due to databaseHandler");
    }
    boolean didAddUserVerification = setUserVerification(aUserVerification);
    if (!didAddUserVerification)
    {
      throw new RuntimeException("Unable to create vote due to userVerification");
    }
  }

  public Vote(int aWeight, String aUserMessageForVoteConfirmedPage, Stand aStand, DatabaseHandler aDatabaseHandler, UserVerification aUserVerification)
  {
    weight = aWeight;
    voteConfirmedPage = new VoteConfirmedPage(aUserMessageForVoteConfirmedPage, this);
    boolean didAddStand = setStand(aStand);
    if (!didAddStand)
    {
      throw new RuntimeException("Unable to create vote due to stand");
    }
    boolean didAddDatabaseHandler = setDatabaseHandler(aDatabaseHandler);
    if (!didAddDatabaseHandler)
    {
      throw new RuntimeException("Unable to create vote due to databaseHandler");
    }
    boolean didAddUserVerification = setUserVerification(aUserVerification);
    if (!didAddUserVerification)
    {
      throw new RuntimeException("Unable to create vote due to userVerification");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWeight(int aWeight)
  {
    boolean wasSet = false;
    weight = aWeight;
    wasSet = true;
    return wasSet;
  }

  public int getWeight()
  {
    return weight;
  }
  /* Code from template association_GetOne */
  public VoteConfirmedPage getVoteConfirmedPage()
  {
    return voteConfirmedPage;
  }
  /* Code from template association_GetOne */
  public Stand getStand()
  {
    return stand;
  }
  /* Code from template association_GetOne */
  public DatabaseHandler getDatabaseHandler()
  {
    return databaseHandler;
  }
  /* Code from template association_GetOne */
  public UserVerification getUserVerification()
  {
    return userVerification;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStand(Stand aStand)
  {
    boolean wasSet = false;
    if (aStand == null)
    {
      return wasSet;
    }

    Stand existingStand = stand;
    stand = aStand;
    if (existingStand != null && !existingStand.equals(aStand))
    {
      existingStand.removeVote(this);
    }
    stand.addVote(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDatabaseHandler(DatabaseHandler aDatabaseHandler)
  {
    boolean wasSet = false;
    if (aDatabaseHandler == null)
    {
      return wasSet;
    }

    DatabaseHandler existingDatabaseHandler = databaseHandler;
    databaseHandler = aDatabaseHandler;
    if (existingDatabaseHandler != null && !existingDatabaseHandler.equals(aDatabaseHandler))
    {
      existingDatabaseHandler.removeVote(this);
    }
    databaseHandler.addVote(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setUserVerification(UserVerification aUserVerification)
  {
    boolean wasSet = false;
    if (aUserVerification == null)
    {
      return wasSet;
    }

    UserVerification existingUserVerification = userVerification;
    userVerification = aUserVerification;
    if (existingUserVerification != null && !existingUserVerification.equals(aUserVerification))
    {
      existingUserVerification.removeVote(this);
    }
    userVerification.addVote(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    VoteConfirmedPage existingVoteConfirmedPage = voteConfirmedPage;
    voteConfirmedPage = null;
    if (existingVoteConfirmedPage != null)
    {
      existingVoteConfirmedPage.delete();
    }
    Stand placeholderStand = stand;
    this.stand = null;
    if(placeholderStand != null)
    {
      placeholderStand.removeVote(this);
    }
    DatabaseHandler placeholderDatabaseHandler = databaseHandler;
    this.databaseHandler = null;
    if(placeholderDatabaseHandler != null)
    {
      placeholderDatabaseHandler.removeVote(this);
    }
    UserVerification placeholderUserVerification = userVerification;
    this.userVerification = null;
    if(placeholderUserVerification != null)
    {
      placeholderUserVerification.removeVote(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "weight" + ":" + getWeight()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "voteConfirmedPage = "+(getVoteConfirmedPage()!=null?Integer.toHexString(System.identityHashCode(getVoteConfirmedPage())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "stand = "+(getStand()!=null?Integer.toHexString(System.identityHashCode(getStand())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "databaseHandler = "+(getDatabaseHandler()!=null?Integer.toHexString(System.identityHashCode(getDatabaseHandler())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "userVerification = "+(getUserVerification()!=null?Integer.toHexString(System.identityHashCode(getUserVerification())):"null");
  }
}