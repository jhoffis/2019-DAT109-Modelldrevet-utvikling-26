<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class ResultPage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ResultPage Associations
  private $stands;
  private $databaseHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aDatabaseHandler = null)
  {
    if (func_num_args() == 0) { return; }

    $this->stands = array();
    if ($aDatabaseHandler == null || $aDatabaseHandler->getResultPage() != null)
    {
      throw new Exception("Unable to create ResultPage due to aDatabaseHandler");
    }
    $this->databaseHandler = $aDatabaseHandler;
  }
  public static function newInstance($aUserIdForDatabaseHandler, $aRatingForDatabaseHandler, $aStandIDForDatabaseHandler)
  {
    $thisInstance = new ResultPage();
    $this->stands = array();
    $thisInstance->databaseHandler = new DatabaseHandler($aUserIdForDatabaseHandler, $aRatingForDatabaseHandler, $aStandIDForDatabaseHandler, $thisInstance);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStand_index($index)
  {
    $aStand = $this->stands[$index];
    return $aStand;
  }

  public function getStands()
  {
    $newStands = $this->stands;
    return $newStands;
  }

  public function numberOfStands()
  {
    $number = count($this->stands);
    return $number;
  }

  public function hasStands()
  {
    $has = $this->numberOfStands() > 0;
    return $has;
  }

  public function indexOfStand($aStand)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stands as $stand)
    {
      if ($stand->equals($aStand))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getDatabaseHandler()
  {
    return $this->databaseHandler;
  }

  public static function minimumNumberOfStands()
  {
    return 0;
  }

  public function addStandVia($aStandId)
  {
    return new Stand($aStandId, $this);
  }

  public function addStand($aStand)
  {
    $wasAdded = false;
    if ($this->indexOfStand($aStand) !== -1) { return false; }
    $existingResultPage = $aStand->getResultPage();
    $isNewResultPage = $existingResultPage != null && $this !== $existingResultPage;
    if ($isNewResultPage)
    {
      $aStand->setResultPage($this);
    }
    else
    {
      $this->stands[] = $aStand;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStand($aStand)
  {
    $wasRemoved = false;
    //Unable to remove aStand, as it must always have a resultPage
    if ($this !== $aStand->getResultPage())
    {
      unset($this->stands[$this->indexOfStand($aStand)]);
      $this->stands = array_values($this->stands);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStandAt($aStand, $index)
  {  
    $wasAdded = false;
    if($this->addStand($aStand))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStandAt($aStand, $index)
  {
    $wasAdded = false;
    if($this->indexOfStand($aStand) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStandAt($aStand, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->stands as $aStand)
    {
      $aStand->delete();
    }
    $existingDatabaseHandler = $this->databaseHandler;
    $this->databaseHandler = null;
    if ($existingDatabaseHandler != null)
    {
      $existingDatabaseHandler->delete();
    }
  }

}
?>