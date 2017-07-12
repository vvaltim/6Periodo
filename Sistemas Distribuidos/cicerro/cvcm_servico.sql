-- phpMyAdmin SQL Dump
-- version 4.6.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 27-Jun-2017 às 23:57
-- Versão do servidor: 5.7.12
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cvcm_servico`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cvcm_venda`
--

CREATE TABLE `cvcm_venda` (
  `idVendas` int(11) NOT NULL,
  `codV` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idVendedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cvcm_venda`
--

INSERT INTO `cvcm_venda` (`idVendas`, `codV`, `idCliente`, `idVendedor`) VALUES
(1, 8, 16, 5),
(2, 5, 4, 12),
(3, 9, 16, 5),
(4, 9, 16, 5),
(5, 9, 16, 5),
(6, 9, 16, 5),
(7, 5, 4, 12),
(8, 5, 4, 12),
(9, 15, 4, 12),
(10, 0, 0, 0),
(11, 36, 26, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cvcm_vendas_itens`
--

CREATE TABLE `cvcm_vendas_itens` (
  `idProduto` int(50) NOT NULL,
  `valor_Unitario` float NOT NULL,
  `quantidade` int(50) NOT NULL,
  `idVendas` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cvcm_vendas_itens`
--

INSERT INTO `cvcm_vendas_itens` (`idProduto`, `valor_Unitario`, `quantidade`, `idVendas`) VALUES
(1, 1, 1, 1),
(26, 2, 2, 2),
(26, 2, 2, 8),
(27, 2, 25, 9),
(46, 10, 6, 11);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cvcm_venda`
--
ALTER TABLE `cvcm_venda`
  ADD PRIMARY KEY (`idVendas`);

--
-- Indexes for table `cvcm_vendas_itens`
--
ALTER TABLE `cvcm_vendas_itens`
  ADD KEY `idVendas` (`idVendas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cvcm_venda`
--
ALTER TABLE `cvcm_venda`
  MODIFY `idVendas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
