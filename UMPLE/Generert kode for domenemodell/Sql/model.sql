-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `stand`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*stand Associations*/
  result_page_database_handler_user_id VARCHAR(255),
  
  /*stand Attributes*/
  stand_id VARCHAR(255),
  PRIMARY KEY(stand_id)

);





CREATE TABLE IF NOT EXISTS `result_page`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*result_page Associations*/
  database_handler_user_id VARCHAR(255),
    PRIMARY KEY(database_handler_user_id)

);





CREATE TABLE IF NOT EXISTS `database_handler`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*database_handler Associations*/
  result_page_database_handler_user_id VARCHAR(255),
  
  /*database_handler Attributes*/
  user_id VARCHAR(255),
  rating INT,
  stand_id INT,
  database_handler_user_id VARCHAR(255),
  database_handler_user_id VARCHAR(255),
  database_handler_user_id VARCHAR(255),
  database_handler_user_id VARCHAR(255),
  PRIMARY KEY(user_id)

);





CREATE TABLE IF NOT EXISTS `vote_confirmed_page`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*vote_confirmed_page Associations*/
  vote_weight INT,
  
  /*vote_confirmed_page Attributes*/
  user_message VARCHAR(255),
  PRIMARY KEY(user_message)

);





CREATE TABLE IF NOT EXISTS `vote`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*vote Associations*/
  vote_confirmed_page_user_message VARCHAR(255),
  stand_stand_id VARCHAR(255),
  database_handler_user_id VARCHAR(255),
  user_verification_user_id VARCHAR(255),
  
  /*vote Attributes*/
  weight INT,
  PRIMARY KEY(weight)

);





CREATE TABLE IF NOT EXISTS `user_verification`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*user_verification Attributes*/
  user_id VARCHAR(255),
  PRIMARY KEY(user_id)

);


ALTER TABLE `stand` ADD CONSTRAINT `fk_stand_result_page_database_handler_user_id` FOREIGN KEY (`result_page_database_handler_user_id`) REFERENCES `result_page`(`database_handler_user_id`);

ALTER TABLE `result_page` ADD CONSTRAINT `fk_resultpage_database_handler_user_id` FOREIGN KEY (`database_handler_user_id`) REFERENCES `database_handler`(`user_id`);

ALTER TABLE `database_handler` ADD CONSTRAINT `fk_databasehandler_result_page_database_handler_user_id` FOREIGN KEY (`result_page_database_handler_user_id`) REFERENCES `result_page`(`database_handler_user_id`);

ALTER TABLE `vote_confirmed_page` ADD CONSTRAINT `fk_voteconfirmedpage_vote_weight` FOREIGN KEY (`vote_weight`) REFERENCES `vote`(`weight`);

ALTER TABLE `vote` ADD CONSTRAINT `fk_vote_vote_confirmed_page_user_message` FOREIGN KEY (`vote_confirmed_page_user_message`) REFERENCES `vote_confirmed_page`(`user_message`);
ALTER TABLE `vote` ADD CONSTRAINT `fk_vote_stand_stand_id` FOREIGN KEY (`stand_stand_id`) REFERENCES `stand`(`stand_id`);
ALTER TABLE `vote` ADD CONSTRAINT `fk_vote_database_handler_user_id` FOREIGN KEY (`database_handler_user_id`) REFERENCES `database_handler`(`user_id`);
ALTER TABLE `vote` ADD CONSTRAINT `fk_vote_user_verification_user_id` FOREIGN KEY (`user_verification_user_id`) REFERENCES `user_verification`(`user_id`);

