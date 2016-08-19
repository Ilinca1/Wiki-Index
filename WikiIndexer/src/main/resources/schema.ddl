CREATE TABLE `occurrence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(45) DEFAULT NULL,
  `occurrences` int(11) DEFAULT NULL,
  `title` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `title_idx` (`title`),
  CONSTRAINT `title` FOREIGN KEY (`title`) REFERENCES `title` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION);

CREATE TABLE `title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`));
