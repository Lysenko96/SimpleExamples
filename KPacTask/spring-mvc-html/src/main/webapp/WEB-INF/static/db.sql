DROP TABLE IF EXISTS `k_pac`;
CREATE TABLE `k_pac` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `title` varchar(11) NOT NULL,
                         `description` varchar(30) NOT NULL,
                         `createdAt` date NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records
-- ----------------------------
INSERT INTO `k_pac` VALUES ('1', 'title', 'description', '2024-05-22');