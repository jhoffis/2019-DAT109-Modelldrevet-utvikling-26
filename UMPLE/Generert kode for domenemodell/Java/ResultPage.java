/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 7 "model.ump"
// line 41 "model.ump"
public class ResultPage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ResultPage Associations
  private List<Stand> stands;
  private DatabaseHandler databaseHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ResultPage(DatabaseHandler aDatabaseHandler)
  {
    stands = new ArrayList<Stand>();
    if (aDatabaseHandler == null || aDatabaseHandler.getResultPage() != null)
    {
      throw new RuntimeException("Unable to create ResultPage due to aDatabaseHandler");
    }
    databaseHandler = aDatabaseHandler;
  }

  public ResultPage(String aUserIdForDatabaseHandler, int aRatingForDatabaseHandler, int aStandIDForDatabaseHandler)
  {
    stands = new ArrayList<Stand>();
    databaseHandler = new DatabaseHandler(aUserIdForDatabaseHandler, aRatingForDatabaseHandler, aStandIDForDatabaseHandler, this);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Stand getStand(int index)
  {
    Stand aStand = stands.get(index);
    return aStand;
  }

  public List<Stand> getStands()
  {
    List<Stand> newStands = Collections.unmodifiableList(stands);
    return newStands;
  }

  public int numberOfStands()
  {
    int number = stands.size();
    return number;
  }

  public boolean hasStands()
  {
    boolean has = stands.size() > 0;
    return has;
  }

  public int indexOfStand(Stand aStand)
  {
    int index = stands.indexOf(aStand);
    return index;
  }
  /* Code from template association_GetOne */
  public DatabaseHandler getDatabaseHandler()
  {
    return databaseHandler;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStands()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stand addStand(String aStandId)
  {
    return new Stand(aStandId, this);
  }

  public boolean addStand(Stand aStand)
  {
    boolean wasAdded = false;
    if (stands.contains(aStand)) { return false; }
    ResultPage existingResultPage = aStand.getResultPage();
    boolean isNewResultPage = existingResultPage != null && !this.equals(existingResultPage);
    if (isNewResultPage)
    {
      aStand.setResultPage(this);
    }
    else
    {
      stands.add(aStand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStand(Stand aStand)
  {
    boolean wasRemoved = false;
    //Unable to remove aStand, as it must always have a resultPage
    if (!this.equals(aStand.getResultPage()))
    {
      stands.remove(aStand);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandAt(Stand aStand, int index)
  {  
    boolean wasAdded = false;
    if(addStand(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandAt(Stand aStand, int index)
  {
    boolean wasAdded = false;
    if(stands.contains(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandAt(aStand, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=stands.size(); i > 0; i--)
    {
      Stand aStand = stands.get(i - 1);
      aStand.delete();
    }
    DatabaseHandler existingDatabaseHandler = databaseHandler;
    databaseHandler = null;
    if (existingDatabaseHandler != null)
    {
      existingDatabaseHandler.delete();
    }
  }

}