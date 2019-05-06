/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 2 "model.ump"
// line 49 "model.ump"
public class Expo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Expo State Machines
  public enum Expo { Frontpage, LogInAdmin, ResultPage, Stands, QRkode, Vote, VoteConfirmedPage }
  private Expo expo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Expo()
  {
    setExpo(Expo.Frontpage);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getExpoFullName()
  {
    String answer = expo.toString();
    return answer;
  }

  public Expo getExpo()
  {
    return expo;
  }

  public boolean tilStands()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case Frontpage:
        setExpo(Expo.Stands);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean loggInnSomAdmin()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case Frontpage:
        setExpo(Expo.LogInAdmin);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean tilForside()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case LogInAdmin:
        setExpo(Expo.Frontpage);
        wasEventProcessed = true;
        break;
      case ResultPage:
        setExpo(Expo.Frontpage);
        wasEventProcessed = true;
        break;
      case Stands:
        setExpo(Expo.Frontpage);
        wasEventProcessed = true;
        break;
      case Vote:
        setExpo(Expo.Frontpage);
        wasEventProcessed = true;
        break;
      case VoteConfirmedPage:
        setExpo(Expo.Frontpage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean loggInn()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case LogInAdmin:
        setExpo(Expo.ResultPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean stemStand()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case Stands:
        setExpo(Expo.Vote);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean scan()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case QRkode:
        exitExpo();
        // line 28 "model.ump"
        goToPage();
        setExpo(Expo.Vote);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean sendInnDinStemme()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case Vote:
        // line 33 "model.ump"
        tryRemoveVoteFromDB(); pushVoteToDB(); goToPage();
        setExpo(Expo.VoteConfirmedPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean endreStemme()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case VoteConfirmedPage:
        if (temp())
        {
          setExpo(Expo.Vote);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitExpo()
  {
    switch(expo)
    {
      case QRkode:
        // line 27 "model.ump"
        tryGenerateID();
        break;
    }
  }

  private void setExpo(Expo aExpo)
  {
    expo = aExpo;

    // entry actions and do activities
    switch(expo)
    {
      case Frontpage:
        // line 7 "model.ump"
        tryGenerateID();
        break;
      case ResultPage:
        // line 16 "model.ump"
        getAllResultsFromDB()
        break;
      case Stands:
        // line 21 "model.ump"
        getStandsFromDB()
        break;
      case Vote:
        // line 31 "model.ump"
        initPage();
        break;
      case VoteConfirmedPage:
        // line 39 "model.ump"
        showVote();
        break;
    }
  }

  public void delete()
  {}

}