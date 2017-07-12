-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 01-Jul-2017 às 00:36
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `produto_e_estoque`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `marca`
--

CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL,
  `nome_marca` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `marca`
--

INSERT INTO `marca` (`id_marca`, `nome_marca`) VALUES
(1, 'Nestle'),
(2, 'Garoto'),
(3, 'Lacta'),
(4, 'Ferrero Rocher'),
(5, 'Cacau Show'),
(6, 'Milk'),
(7, 'Teste 10'),
(8, 'teste gestor');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `valor` double NOT NULL,
  `id_unidade_medida` int(11) NOT NULL,
  `quantidade_estoque` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `descricao`, `id_marca`, `valor`, `id_unidade_medida`, `quantidade_estoque`) VALUES
(1, 'Teste teste 1', 4, 10.5, 1, 19),
(2, 'Achocolatado Dois Frades 200g', 1, 10.5, 2, 131),
(3, 'Açai', 7, 10.5, 3, 18),
(4, 'Teste gestor produto', 5, 1.99, 3, -5),
(5, 'Produto Prova', 4, 3.15, 5, 35);

-- --------------------------------------------------------

--
-- Estrutura da tabela `unidade_medida`
--

CREATE TABLE `unidade_medida` (
  `id_unidade_medida` int(11) NOT NULL,
  `nome_unidade_medida` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `unidade_medida`
--

INSERT INTO `unidade_medida` (`id_unidade_medida`, `nome_unidade_medida`) VALUES
(1, 'Liquido'),
(2, 'Pó'),
(3, 'Comprimido'),
(4, 'Sach�'),
(5, 'Peso');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id_marca`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`),
  ADD KEY `produto_fk0` (`id_marca`),
  ADD KEY `produto_fk1` (`id_unidade_medida`);

--
-- Indexes for table `unidade_medida`
--
ALTER TABLE `unidade_medida`
  ADD PRIMARY KEY (`id_unidade_medida`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `marca`
--
ALTER TABLE `marca`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `unidade_medida`
--
ALTER TABLE `unidade_medida`
  MODIFY `id_unidade_medida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_fk0` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`),
  ADD CONSTRAINT `produto_fk1` FOREIGN KEY (`id_unidade_medida`) REFERENCES `unidade_medida` (`id_unidade_medida`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
