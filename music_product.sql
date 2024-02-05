-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 05, 2024 at 05:13 AM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sbmusicapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `music_product`
--

CREATE TABLE `music_product` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `artist` varchar(255) NOT NULL,
  `audio_url` varchar(255) DEFAULT NULL,
  `picture_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `music_product`
--

INSERT INTO `music_product` (`id`, `name`, `artist`, `audio_url`, `picture_url`) VALUES
(1, 'Payphone', 'Maroon 5', 'https://soundcloud.com/maroon-5/payphone?utm_source=clipboard&utm_medium=text&utm_campaign=social_sharing', 'https://upload.wikimedia.org/wikipedia/en/7/7f/Maroon_5_Payphone_cover.png'),
(2, 'Leaders', 'Lil Uzi', 'https://soundcloud.com/liluzivert/leaders-feat-nav?utm_source=clipboard&utm_medium=text&utm_campaign=social_sharing', 'https://i1.sndcdn.com/artworks-VwJwgJZg8Pyh-0-t500x500.jpg'),
(5, 'just like me', '21 Savage', 'https://soundcloud.com/21savage/21-savage-burna-boy-metro?utm_source=clipboard&utm_medium=text&utm_campaign=social_sharing', 'https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/de/82/b9/de82b98d-56a1-e27b-10ea-46964f4585e4/196871714549.jpg/1200x1200bb.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `music_product`
--
ALTER TABLE `music_product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `music_product`
--
ALTER TABLE `music_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
