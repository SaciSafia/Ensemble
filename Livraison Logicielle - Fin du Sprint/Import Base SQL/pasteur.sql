-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 26 jan. 2022 à 02:18
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pasteur`
--

-- --------------------------------------------------------

--
-- Structure de la table `patients`
--

DROP TABLE IF EXISTS `patients`;
CREATE TABLE IF NOT EXISTS `patients` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `dateNaiss` varchar(255) DEFAULT NULL,
  `dateDose1` varchar(255) DEFAULT NULL,
  `DateDose2` varchar(255) DEFAULT NULL,
  `DateDose3` varchar(255) DEFAULT NULL,
  `typeVaccin` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_type_vaccin` (`typeVaccin`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `patients`
--

INSERT INTO `patients` (`ID`, `nom`, `prenom`, `dateNaiss`, `dateDose1`, `DateDose2`, `DateDose3`, `typeVaccin`) VALUES
(1, 'dahy', 'nathan', '2022-01-05', '2022-01-12', '2022-01-19', '2022-01-21', 'moderna'),
(2, 'Nathan', 'Lucas', '2028-01-22', '2028-01-22', '2028-01-22', '2028-01-22', 'Moderna'),
(7, 'azezae', 'aezzea', '2028-01-22', '2028-01-22', '2028-01-22', '2028-01-22', 'Moderna'),
(6, '', '', '2028-01-22', '2028-01-22', '2028-01-22', '2028-01-22', 'Moderna'),
(5, '', '', '2028-01-22', '2028-01-22', '2028-01-22', '2028-01-22', 'Moderna'),
(4, 'aoues', 'laety', '2010-01-22', '2010-01-22', '2010-01-22', '2010-01-22', 'test'),
(3, 'aoues', 'laety', '2010-01-22', '2010-01-22', '2010-01-22', '2010-01-22', 'test'),
(26, 'et', 'et', 'te', 'etet', 'et', 'et', 'et'),
(27, 'Safia', 'Saci', '01/02/1980', '11/1/2021', '16/1/2021', '', 'Moderna');

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE IF NOT EXISTS `personnel` (
  `ID` int(6) NOT NULL,
  `noms` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `poste` varchar(50) NOT NULL,
  `dateNaiss` date NOT NULL,
  `mp` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`ID`, `noms`, `prenom`, `poste`, `dateNaiss`, `mp`) VALUES
(1, 'Essai', 'Testeur', 'Médecin', '2022-01-05', 'mp'),
(2, 'test', 'test', 'test', '2022-01-26', 'encore');

-- --------------------------------------------------------

--
-- Structure de la table `tests`
--

DROP TABLE IF EXISTS `tests`;
CREATE TABLE IF NOT EXISTS `tests` (
  `type` varchar(20) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prixUnitaire` int(11) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tests`
--

INSERT INTO `tests` (`type`, `quantite`, `prixUnitaire`) VALUES
('PCR', 210, 10),
('Antigenic', 15, 10);

-- --------------------------------------------------------

--
-- Structure de la table `typemasques`
--

DROP TABLE IF EXISTS `typemasques`;
CREATE TABLE IF NOT EXISTS `typemasques` (
  `type` varchar(20) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prixUnitaire` int(11) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `typemasques`
--

INSERT INTO `typemasques` (`type`, `quantite`, `prixUnitaire`) VALUES
('FFP2', 40, 5),
('Chirurgicals', 91, 10);

-- --------------------------------------------------------

--
-- Structure de la table `vaccins`
--

DROP TABLE IF EXISTS `vaccins`;
CREATE TABLE IF NOT EXISTS `vaccins` (
  `type` varchar(20) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prixUnitaire` int(11) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vaccins`
--

INSERT INTO `vaccins` (`type`, `quantite`, `prixUnitaire`) VALUES
('Moderna', 0, 1000),
('Pfizer', 100, 20),
('Astrazeneca', 100, 100);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
