<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class VoteConfirmedPage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VoteConfirmedPage Attributes
  private $userMessage;

  //VoteConfirmedPage Associations
  private $vote;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aUserMessage = null, $aVote = null)
  {
    if (func_num_args() == 0) { return; }

    $this->userMessage = $aUserMessage;
    if ($aVote == null || $aVote->getVoteConfirmedPage() != null)
    {
      throw new Exception("Unable to create VoteConfirmedPage due to aVote");
    }
    $this->vote = $aVote;
  }
  public static function newInstance($aUserMessage, $aWeightForVote, $aStandForVote, $aDatabaseHandlerForVote, $aUserVerificationForVote)
  {
    $thisInstance = new VoteConfirmedPage();
    $thisInstance->userMessage = $aUserMessage;
    $thisInstance->vote = new Vote($aWeightForVote, $thisInstance, $aStandForVote, $aDatabaseHandlerForVote, $aUserVerificationForVote);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setUserMessage($aUserMessage)
  {
    $wasSet = false;
    $this->userMessage = $aUserMessage;
    $wasSet = true;
    return $wasSet;
  }

  public function getUserMessage()
  {
    return $this->userMessage;
  }

  public function getVote()
  {
    return $this->vote;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingVote = $this->vote;
    $this->vote = null;
    if ($existingVote != null)
    {
      $existingVote->delete();
    }
  }

}
?>