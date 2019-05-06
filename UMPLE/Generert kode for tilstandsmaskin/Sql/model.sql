-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `expo`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*Expo State Machines*/
  expo ENUM('frontpage', 'log_in_admin', 'result_page', 'stands', 'q_rkode', 'vote', 'vote_confirmed_page'),
  PRIMARY KEY(expo)

);


