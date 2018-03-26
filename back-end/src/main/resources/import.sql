
####INIT CARD DATABASE####

INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (2,'Pink','Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (2, 'Gift', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (6, 'DDos guy', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (8, 'Boat', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (5, 'icsh>', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (3, 'This guy again', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (3, 'Fat this guy again', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (4, 'Alphadoge', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (5, 'Nice', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (5, 'New', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (6, 'Babe', 'Monster');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (1, 'Wit', 'Monster');

INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (7, 'Flex tape', 'Magic');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (4, 'Gun man', 'Magic');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (4, 'Blue pay', 'Magic');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (5, 'Hanoi', 'Magic');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (3, '3D Printer', 'Magic');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (3, 'ChocChip', 'Magic');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (2, 'HW Token', 'Magic');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (3, 'SFC', 'Magic');
INSERT INTO `hardstring`.`card` (`cost`, `name`, `type`) VALUES (2, 'AddDrop', 'Magic');

####INIT MONSTER DATABASE####

INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='Pink'),2,3,2,'Pink',FALSE ,FALSE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='Gift'),2,2,3,'Gift',FALSE ,FALSE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='DDos guy'),6,9,1,'DDos Guy',FALSE ,FALSE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='Boat'),8,8,5,'Boat',FALSE ,TRUE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='icsh>'),5,5,4,'icsh>',FALSE ,FALSE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='This guy again'),3,4,2,'This guy again',FALSE ,TRUE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='Fat this guy again'),3,2,4,'Fat this guy again',TRUE ,FALSE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='Alphadoge'),4,2,5,'Alphadoge',TRUE ,FALSE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='Nice'),5,6,4,'Nice',FALSE ,FALSE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='New'),5,6,4,'New',FALSE ,FALSE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='Babe'),4,5,5,'Babe',FALSE ,FALSE );
INSERT INTO `hardstring`.`monster` (`id`, `cost`, `atk`, `maxhp`, `name`, `taunt`, `charge`) VALUES ((SELECT card_id FROM `hardstring`.`card` WHERE card.name='Wit'),1,0,1,'Wit',TRUE ,FALSE );

