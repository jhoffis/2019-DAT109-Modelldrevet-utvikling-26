<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class Vote
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vote Attributes
  private $weight;

  //Vote Associations
  private $voteConfirmedPage;
  private $stand;
  private $databaseHandler;
  private $userVerification;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aWeight = null, $aVoteConfirmedPage = null, $aStand = null, $aDatabaseHandler = null, $aUserVerification = null)
  {
    if (func_num_args() == 0) { return; }

    $this->weight = $aWeight;
    if ($aVoteConfirmedPage == null || $aVoteConfirmedPage->getVote() != null)
    {
      throw new Exception("Unable to create Vote due to aVoteConfirmedPage");
    }
    $this->voteConfirmedPage = $aVoteConfirmedPage;
    $didAddStand = $this->setStand($aStand);
    if (!$didAddStand)
    {
      throw new Exception("Unable to create vote due to stand");
    }
    $didAddDatabaseHandler = $this->setDatabaseHandler($aDatabaseHandler);
    if (!$didAddDatabaseHandler)
    {
      throw new Exception("Unable to create vote due to databaseHandler");
    }
    $didAddUserVerification = $this->setUserVerification($aUserVerification);
    if (!$didAddUserVerification)
    {
      throw new Exception("Unable to create vote due to userVerification");
    }
  }
  public static function newInstance($aWeight, $aUserMessageForVoteConfirmedPage, $aStand, $aDatabaseHandler, $aUserVerification)
  {
    $thisInstance = new Vote();
    $thisInstance->weight = $aWeight;
    $thisInstance->voteConfirmedPage = new VoteConfirmedPage($aUserMessageForVoteConfirmedPage, $thisInstance);$this->stands = array();
    $this->stands[] = $aStand;$this->databaseHandlers = array();
    $this->databaseHandlers[] = $aDatabaseHandler;$this->userVerifications = array();
    $this->userVerifications[] = $aUserVerification;
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setWeight($aWeight)
  {
    $wasSet = false;
    $this->weight = $aWeight;
    $wasSet = true;
    return $wasSet;
  }

  public function getWeight()
  {
    return $this->weight;
  }

  public function getVoteConfirmedPage()
  {
    return $this->voteConfirmedPage;
  }

  public function getStand()
  {
    return $this->stand;
  }

  public function getDatabaseHandler()
  {
    return $this->databaseHandler;
  }

  public function getUserVerification()
  {
    return $this->userVerification;
  }

  public function setStand($aStand)
  {
    $wasSet = false;
    if ($aStand == null)
    {
      return $wasSet;
    }
    
    $existingStand = $this->stand;
    $this->stand = $aStand;
    if ($existingStand != null && $existingStand != $aStand)
    {
      $existingStand->removeVote($this);
    }
    $this->stand->addVote($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setDatabaseHandler($aDatabaseHandler)
  {
    $wasSet = false;
    if ($aDatabaseHandler == null)
    {
      return $wasSet;
    }
    
    $existingDatabaseHandler = $this->databaseHandler;
    $this->databaseHandler = $aDatabaseHandler;
    if ($existingDatabaseHandler != null && $existingDatabaseHandler != $aDatabaseHandler)
    {
      $existingDatabaseHandler->removeVote($this);
    }
    $this->databaseHandler->addVote($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setUserVerification($aUserVerification)
  {
    $wasSet = false;
    if ($aUserVerification == null)
    {
      return $wasSet;
    }
    
    $existingUserVerification = $this->userVerification;
    $this->userVerification = $aUserVerification;
    if ($existingUserVerification != null && $existingUserVerification != $aUserVerification)
    {
      $existingUserVerification->removeVote($this);
    }
    $this->userVerification->addVote($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingVoteConfirmedPage = $this->voteConfirmedPage;
    $this->voteConfirmedPage = null;
    if ($existingVoteConfirmedPage != null)
    {
      $existingVoteConfirmedPage->delete();
    }
    $placeholderStand = $this->stand;
    $this->stand = null;
    $placeholderStand->removeVote($this);
    $placeholderDatabaseHandler = $this->databaseHandler;
    $this->databaseHandler = null;
    $placeholderDatabaseHandler->removeVote($this);
    $placeholderUserVerification = $this->userVerification;
    $this->userVerification = null;
    $placeholderUserVerification->removeVote($this);
  }

}
?>