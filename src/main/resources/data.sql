INSERT INTO `CUSTOMER` (`name`,`password`,`surname`,`username`) VALUES ('Elena','11111111','Blagoj','elina54');
INSERT INTO `CUSTOMER` (`name`,`password`,`surname`,`username`) VALUES ('Zhasmina','22222222','Deurveilher','zhas123');

INSERT INTO `current_account` (`customer_id`,`account_number`,`name`, `balance`) VALUES (1,' BE76 5473 7876 0846','Kids Expenses', '0.00');
INSERT INTO `current_account` (`customer_id`,`account_number`,`name`, `balance`) VALUES (1,' BE76 8755 7977 6656','Account Groceries', '0.00');
INSERT INTO `current_account` (`customer_id`,`account_number`,`name`, `balance`) VALUES (1,' BE76 2234 6557 8547','Genaral Payments', '1700.00');
INSERT INTO `current_account` (`customer_id`,`account_number`,`name`, `balance`) VALUES (2,' BE76 7574 1117 2223','Uni Expenses', '50.00');


INSERT INTO `transaction` (`created_at`,`amount`,`is_credit`,`description`,`sender`,`sender_account`,`receiver`,`receiver_account`,`account_id`) VALUES ('2023-07-02 23:11:26',3050.00,true,'Initial Ammount','Zhasmina Deurveilher','BE76757411172223','Zhasmina Deurveilher',' BE76547378760846',3);
INSERT INTO `transaction` (`created_at`,`amount`,`is_credit`,`description`,`sender`,`sender_account`,`receiver`,`receiver_account`,`account_id`) VALUES ('2023-07-02 23:12:37',890.00, false,'Rent Avenue G. ...','Zhasmina Deurveilher',' BE76547378760846','Grigor Venny',' BE70334523458743',3);
INSERT INTO `transaction` (`created_at`,`amount`,`is_credit`,`description`,`sender`,`sender_account`,`receiver`,`receiver_account`,`account_id`) VALUES ('2023-07-02 23:13:08',400.00, false,'PS4 ','Zhasmina Deurveilher',' BE76547378760846','Media Markt',' BE45564498781235',3);
INSERT INTO `transaction` (`created_at`,`amount`,`is_credit`,`description`,`sender`,`sender_account`,`receiver`,`receiver_account`,`account_id`) VALUES ('2023-07-02 23:14:32',60.00, false,'Zhasmina Deurveilher',' BE76547378760846','Water bill','Vivaqua',' BE76223465578547',3);
