-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 26-Jun-2017 às 01:57
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iam_servico`
--
CREATE DATABASE IF NOT EXISTS `iam_servico` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `iam_servico`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `iam_entrada`
--

CREATE TABLE `iam_entrada` (
  `codE` int(11) NOT NULL,
  `data` varchar(100) NOT NULL,
  `fornecedor` int(11) NOT NULL,
  `funcionario` int(11) NOT NULL,
  `valor_Nota` float NOT NULL,
  `idEntradas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `iam_entrada`
--

INSERT INTO `iam_entrada` (`codE`, `data`, `fornecedor`, `funcionario`, `valor_Nota`, `idEntradas`) VALUES
(1, '25/10/2016', 2, 3, 26.5, 1),
(1, '25/10/2016', 2, 3, 26.5, 2),
(15, '25/10/2016', 2, 3, 26.5, 3),
(15, '25/10/2016', 2, 3, 26.5, 4),
(15, '25/10/2016', 2, 3, 26.5, 5),
(15, '25/10/2016', 2, 3, 26.5, 6),
(285, '25/10/2016', 2, 3, 26.5, 7),
(100, '25/10/2016', 2, 3, 26.5, 8),
(5, '1-1-1', 5, 7, 9, 9),
(6, '1-1-1', 5, 7, 9, 10),
(6, '1-1-1', 5, 7, 9, 11),
(7, '', 2, 3, 26.5, 12),
(5, '', 2, 3, 26.5, 13),
(5, '', 5, 3, 26.5, 14),
(1, '10', 1, 2, 5, 15),
(100, '10/10/2015', 100, 100, 100, 16),
(100, '10/10/2015', 100, 100, 100, 17),
(100, '10/10/2015', 100, 100, 100, 18),
(100, '10/10/2015', 100, 100, 100, 19),
(200, '10/10/2015', 100, 100, 100, 20),
(100, '10/10/2015', 100, 100, 100, 21),
(100, '10/10/2015', 100, 100, 100, 22),
(100, '10/10/2015', 100, 100, 100, 23),
(400, '10/10/2015', 100, 100, 100, 24),
(0, '10/10/2015', 100, 100, 100, 25),
(0, '10/10/2015', 100, 100, 100, 26),
(0, '10/10/2015', 100, 100, 100, 27),
(55, '10/10/2015', 100, 100, 100, 28),
(28, '10/10/2015', 100, 100, 100, 29),
(1, '10/10/2015', 100, 100, 100, 30),
(26, '10/10/2015', 100, 100, 100, 31),
(6, '10/10/2015', 100, 100, 100, 32),
(400, '10/10/2015', 100, 100, 100, 33),
(25, '10/10/2015', 100, 100, 100, 34),
(10, '10/10/2015', 100, 100, 100, 35),
(1, '10/10/2015', 100, 100, 100, 36),
(7, '10/10/2015', 100, 100, 100, 37),
(100, '10/10/2015', 100, 100, 100, 38),
(1, '10/10/2015', 100, 100, 100, 39),
(1, '10/10/2015', 100, 100, 100, 40),
(5, '10/10/2015', 100, 100, 100, 41),
(1, '25/10/2016', 1, 1, 100, 42),
(1, '25/10/2016', 100, 100, 100, 43),
(25, '25/10/2016', 1, 1, 100, 44),
(33, '25/10/2016', 6, 15, 100, 45),
(33, '25/10/2016', 1, 1, 100, 46),
(39, '25/10/2016', 15, 5, 100, 47),
(39, '25/10/2016', 5, 1, 100, 48),
(89, '25/10/2016', 1, 100, 100, 49),
(10, '101010', 1, 1, 10, 50),
(33, '333333', 100, 1, 33, 51),
(55, '555555', 15, 1, 55, 52),
(11, '1111111', 5, 100, 11, 53),
(4, '1111111', 5, 100, 11, 54),
(58, '585858', 6, 1, 689, 55),
(5, '55555', 100, 1, 6, 56),
(5, '551155', 100, 5, 6, 57),
(555, '5', 1, 100, 55, 58),
(5, '5', 5, 100, 5, 59);

-- --------------------------------------------------------

--
-- Estrutura da tabela `iam_itens_entrada`
--

CREATE TABLE `iam_itens_entrada` (
  `cod_Produto` int(11) NOT NULL,
  `valor_Unitario` float NOT NULL,
  `quantidade` int(11) NOT NULL,
  `idEntradas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `iam_itens_entrada`
--

INSERT INTO `iam_itens_entrada` (`cod_Produto`, `valor_Unitario`, `quantidade`, `idEntradas`) VALUES
(2269, 25, 5, 0),
(4456, 25, 5, 1),
(4456, 25, 5, 2),
(25, 25, 5, 3),
(25, 25, 5, 4),
(25, 25, 5, 5),
(25, 25, 5, 6),
(25, 25, 5, 7),
(25, 25, 5, 8),
(5555, 55, 5, 9),
(5555, 55, 5, 10),
(5555, 55, 5, 11),
(25, 25, 5, 12),
(25, 25, 5, 13),
(25, 25, 5, 14),
(2, 2, 2, 15),
(100, 100, 100, 16),
(100, 100, 100, 17),
(100, 100, 100, 18),
(100, 100, 100, 19),
(100, 100, 100, 20),
(100, 100, 100, 21),
(100, 100, 100, 22),
(100, 100, 100, 23),
(100, 100, 100, 24),
(100, 100, 100, 25),
(100, 100, 100, 26),
(100, 100, 100, 27),
(100, 100, 100, 28),
(100, 100, 100, 29),
(100, 100, 100, 30),
(100, 100, 100, 31),
(100, 100, 100, 32),
(100, 100, 100, 33),
(100, 100, 100, 34),
(100, 100, 100, 35),
(100, 100, 100, 36),
(100, 100, 100, 37),
(100, 100, 100, 38),
(100, 100, 100, 39),
(100, 100, 100, 40),
(100, 100, 100, 41),
(5, 100, 100, 42),
(100, 100, 100, 43),
(25, 100, 100, 44),
(285, 100, 100, 45),
(15, 100, 100, 46),
(285, 100, 100, 47),
(1, 100, 100, 48),
(1, 100, 100, 49),
(1, 10, 10, 50),
(15, 33, 33, 51),
(7, 55, 55, 52),
(285, 11, 11, 53),
(285, 11, 11, 54),
(15, 69, 69, 55),
(100, 5, 5, 56),
(100, 5, 585, 57),
(100, 26, 25, 58),
(58, 5, 5, 59);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `iam_entrada`
--
ALTER TABLE `iam_entrada`
  ADD PRIMARY KEY (`idEntradas`);

--
-- Indexes for table `iam_itens_entrada`
--
ALTER TABLE `iam_itens_entrada`
  ADD KEY `idEntradas` (`idEntradas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `iam_entrada`
--
ALTER TABLE `iam_entrada`
  MODIFY `idEntradas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
