-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 03, 2026 at 02:05 AM
-- Server version: 8.4.3
-- PHP Version: 8.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pegawai`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `divisi`
--

CREATE TABLE `divisi` (
  `id_divisi` int NOT NULL,
  `nama_divisi` varchar(22) DEFAULT NULL,
  `honor_divisi` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `divisi`
--

INSERT INTO `divisi` (`id_divisi`, `nama_divisi`, `honor_divisi`) VALUES
(1, 'KEUANGAN', 1500000),
(2, 'KEPEGAWAIAN', 1600000),
(3, 'ADMINISTRASI', 1670000),
(4, 'LABORATORIUM', 1450000),
(5, 'INSPEKSI', 2000000),
(6, 'FUMIGASI', 1800000),
(7, 'PEMASARAN', 1550000);

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id_jabatan` int NOT NULL,
  `jabatan` varchar(50) DEFAULT NULL,
  `gaji_pokok` bigint DEFAULT NULL,
  `tunj_jabatan` bigint DEFAULT NULL,
  `tunj_anak` bigint DEFAULT NULL,
  `tunj_kesehatan` bigint DEFAULT NULL,
  `perj_dinas` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `jabatan`, `gaji_pokok`, `tunj_jabatan`, `tunj_anak`, `tunj_kesehatan`, `perj_dinas`) VALUES
(1, 'Kepala Bagian Keuangan', 5000000, 1000000, 500000, 500000, 1000000),
(2, 'Kepala Bagian Kepegawaian', 6080000, 1300000, 500000, 500000, 1200000),
(3, 'Kepala Bagian Operasional', 5500000, 1000000, 550000, 500000, 1000000),
(4, 'Kepala Bagian Fumigasi', 6700000, 1100000, 500000, 500000, 1300000),
(5, 'Kepala Bagian HRD', 5000000, 1000000, 500000, 500000, 1100000),
(6, 'Kepala Laboratorium', 5500000, 1000000, 500000, 500000, 1100000);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` int NOT NULL,
  `id_divisi` int DEFAULT NULL,
  `id_jabatan` int DEFAULT NULL,
  `nama` varchar(22) DEFAULT NULL,
  `alamat` varchar(22) DEFAULT NULL,
  `usia` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `id_divisi`, `id_jabatan`, `nama`, `alamat`, `usia`) VALUES
(11112011, 3, 3, 'Inka', 'Jakarta', 29),
(13071975, 1, 3, 'Nurhayati', 'Bandung', 47),
(17081983, 2, 2, 'Evi Nurbaeti', 'Kerawang', 39),
(20211977, 1, 1, 'Budi Laksono', 'Cibitung', 45),
(21121981, 2, 2, 'Eva Nurvaizah', 'Purwokerto', 41),
(23011978, 2, 1, 'Endar', 'Purwokerto', 44);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `divisi`
--
ALTER TABLE `divisi`
  ADD PRIMARY KEY (`id_divisi`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD KEY `id_divisi` (`id_divisi`),
  ADD KEY `id_jabatan` (`id_jabatan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `divisi`
--
ALTER TABLE `divisi`
  MODIFY `id_divisi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id_jabatan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `pegawai_ibfk_1` FOREIGN KEY (`id_divisi`) REFERENCES `divisi` (`id_divisi`),
  ADD CONSTRAINT `pegawai_ibfk_2` FOREIGN KEY (`id_jabatan`) REFERENCES `jabatan` (`id_jabatan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
