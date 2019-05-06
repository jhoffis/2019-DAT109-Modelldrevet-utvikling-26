<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class DatabaseHandler
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DatabaseHandler Attributes
  private $userId;
  private $rating;
  private $standID;

  //DatabaseHandler Associations
  private $resultPage;
  private $votes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aUserId = null, $aRating = null, $aStandID = null, $aResultPage = null)
  {
    if (func_num_args() == 0) { return; }

    $this->userId = $aUserId;
    $this->rating = $aRating;
    $this->standID = $aStandID;
    if ($aResultPage == null || $aResultPage->getDatabaseHandler() != null)
    {
      throw new Exception("Unable to create DatabaseHandler due to aResultPage");
    }
    $this->resultPage = $aResultPage;
    $this->votes = array();
  }
  public static function newInstance($aUserId, $aRating, $aStandID)
  {
    $thisInstance = new DatabaseHandler();
    $thisInstance->userId = $aUserId;
    $thisInstance->rating = $aRating;
    $thisInstance->standID = $aStandID;
    $thisInstance->resultPage = new ResultPage($thisInstance);
    $this->votes = array();
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setUserId($aUserId)
  {
    $wasSet = false;
    $this->userId = $aUserId;
    $wasSet = true;
    return $wasSet;
  }

  public function setRating($aRating)
  {
    $wasSet = false;
    $this->rating = $aRating;
    $wasSet = true;
    return $wasSet;
  }

  public function setStandID($aStandID)
  {
    $wasSet = false;
    $this->standID = $aStandID;
    $wasSet = true;
    return $wasSet;
  }

  public function getUserId()
  {
    return $this->userId;
  }

  public function getRating()
  {
    return $this->rating;
  }

  public function getStandID()
  {
    return $this->standID;
  }

  public function getResultPage()
  {
    return $this->resultPage;
  }

  public function getVote_index($index)
  {
    $aVote = $this->votes[$index];
    return $aVote;
  }

  public function getVotes()
  {
    $newVotes = $this->votes;
    return $newVotes;
  }

  public function numberOfVotes()
  {
    $number = count($this->votes);
    return $number;
  }

  public function hasVotes()
  {
    $has = $this->numberOfVotes() > 0;
    return $has;
  }

  public function indexOfVote($aVote)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->votes as $vote)
    {
      if ($vote->equals($aVote))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfVotes()
  {
    return 0;
  }

  public function addVoteVia($aWeight, $aVoteConfirmedPage, $aStand, $aUserVerification)
  {
    return new Vote($aWeight, $aVoteConfirmedPage, $aStand, $this, $aUserVerification);
  }

  public function addVote($aVote)
  {
    $wasAdded = false;
    if ($this->indexOfVote($aVote) !== -1) { return false; }
    $existingDatabaseHandler = $aVote->getDatabaseHandler();
    $isNewDatabaseHandler = $existingDatabaseHandler != null && $this !== $existingDatabaseHandler;
    if ($isNewDatabaseHandler)
    {
      $aVote->setDatabaseHandler($this);
    }
    else
    {
      $this->votes[] = $aVote;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeVote($aVote)
  {
    $wasRemoved = false;
    //Unable to remove aVote, as it must always have a databaseHandler
    if ($this !== $aVote->getDatabaseHandler())
    {
      unset($this->votes[$this->indexOfVote($aVote)]);
      $this->votes = array_values($this->votes);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addVoteAt($aVote, $index)
  {  
    $wasAdded = false;
    if($this->addVote($aVote))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfVotes()) { $index = $this->numberOfVotes() - 1; }
      array_splice($this->votes, $this->indexOfVote($aVote), 1);
      array_splice($this->votes, $index, 0, array($aVote));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveVoteAt($aVote, $index)
  {
    $wasAdded = false;
    if($this->indexOfVote($aVote) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfVotes()) { $index = $this->numberOfVotes() - 1; }
      array_splice($this->votes, $this->indexOfVote($aVote), 1);
      array_splice($this->votes, $index, 0, array($aVote));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addVoteAt($aVote, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingResultPage = $this->resultPage;
    $this->resultPage = null;
    if ($existingResultPage != null)
    {
      $existingResultPage->delete();
    }
    foreach ($this->votes as $aVote)
    {
      $aVote->delete();
    }
  }

}
?>