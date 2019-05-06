<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class Expo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Expo State Machines
  private static $ExpoFrontpage = 1;
  private static $ExpoLogInAdmin = 2;
  private static $ExpoResultPage = 3;
  private static $ExpoStands = 4;
  private static $ExpoQRkode = 5;
  private static $ExpoVote = 6;
  private static $ExpoVoteConfirmedPage = 7;
  private $Expo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setExpo(self::$ExpoFrontpage);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getExpoFullName()
  {
    $answer = $this->getExpo();
    return $answer;
  }

  public function getExpo()
  {
    if ($this->Expo == self::$ExpoFrontpage) { return "ExpoFrontpage"; }
    elseif ($this->Expo == self::$ExpoLogInAdmin) { return "ExpoLogInAdmin"; }
    elseif ($this->Expo == self::$ExpoResultPage) { return "ExpoResultPage"; }
    elseif ($this->Expo == self::$ExpoStands) { return "ExpoStands"; }
    elseif ($this->Expo == self::$ExpoQRkode) { return "ExpoQRkode"; }
    elseif ($this->Expo == self::$ExpoVote) { return "ExpoVote"; }
    elseif ($this->Expo == self::$ExpoVoteConfirmedPage) { return "ExpoVoteConfirmedPage"; }
    return null;
  }

  public function tilStands()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->Expo;
    if ($aExpo == self::$ExpoFrontpage)
    {
      $this->setExpo(self::$ExpoStands);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function loggInnSomAdmin()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->Expo;
    if ($aExpo == self::$ExpoFrontpage)
    {
      $this->setExpo(self::$ExpoLogInAdmin);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function tilForside()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->Expo;
    if ($aExpo == self::$ExpoLogInAdmin)
    {
      $this->setExpo(self::$ExpoFrontpage);
      $wasEventProcessed = true;
    }
    elseif ($aExpo == self::$ExpoResultPage)
    {
      $this->setExpo(self::$ExpoFrontpage);
      $wasEventProcessed = true;
    }
    elseif ($aExpo == self::$ExpoStands)
    {
      $this->setExpo(self::$ExpoFrontpage);
      $wasEventProcessed = true;
    }
    elseif ($aExpo == self::$ExpoVote)
    {
      $this->setExpo(self::$ExpoFrontpage);
      $wasEventProcessed = true;
    }
    elseif ($aExpo == self::$ExpoVoteConfirmedPage)
    {
      $this->setExpo(self::$ExpoFrontpage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function loggInn()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->Expo;
    if ($aExpo == self::$ExpoLogInAdmin)
    {
      $this->setExpo(self::$ExpoResultPage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function stemStand()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->Expo;
    if ($aExpo == self::$ExpoStands)
    {
      $this->setExpo(self::$ExpoVote);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function scan()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->Expo;
    if ($aExpo == self::$ExpoQRkode)
    {
      $this->exitExpo();
      goToPage();
      $this->setExpo(self::$ExpoVote);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function sendInnDinStemme()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->Expo;
    if ($aExpo == self::$ExpoVote)
    {
      tryRemoveVoteFromDB(); pushVoteToDB(); goToPage();
      $this->setExpo(self::$ExpoVoteConfirmedPage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function endreStemme()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->Expo;
    if ($aExpo == self::$ExpoVoteConfirmedPage)
    {
      if ($this->temp())
      {
        $this->setExpo(self::$ExpoVote);
        $wasEventProcessed = true;
      }
    }
    return $wasEventProcessed;
  }

  private function exitExpo()
  {
    if ($this->Expo == self::$ExpoQRkode)
    {
      tryGenerateID();
    }
  }

  private function setExpo($aExpo)
  {
    $this->Expo = $aExpo;

    // entry actions and do activities
    if ($this->Expo == self::$ExpoFrontpage)
    {
      tryGenerateID();
    }
    elseif ($this->Expo == self::$ExpoResultPage)
    {
      getAllResultsFromDB()
    }
    elseif ($this->Expo == self::$ExpoStands)
    {
      getStandsFromDB()
    }
    elseif ($this->Expo == self::$ExpoVote)
    {
      initPage();
    }
    elseif ($this->Expo == self::$ExpoVoteConfirmedPage)
    {
      showVote();
    }
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>