ALTER TABLE doctors ADD active tinyint;
update doctors set active = 1;