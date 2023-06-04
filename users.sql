-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2023 at 02:41 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users`
--

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `username` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `lecture` varchar(15) NOT NULL,
  `profile` varchar(300) NOT NULL,
  `total_conducted` int(11) DEFAULT NULL,
  `batch` varchar(10) NOT NULL,
  `branch` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`username`, `name`, `password`, `lecture`, `profile`, `total_conducted`, `batch`, `branch`) VALUES
('01Aarti', 'Prof. Dr. Aarti Karande', 'aarti@123', 'Java', 'https://mca.spit.ac.in/wp-content/uploads/2022/12/aarti.png', 0, 'FY', 'MCA'),
('01harshil', 'Prof. Harshil Kanakia', 'harshil@123', 'Process Automat', 'https://mca.spit.ac.in/wp-content/uploads/2022/12/HK.png', 0, 'FY', 'MCA'),
('01nikhita', 'Prof. Nikhita Mangaonkar', 'nikhita@123', 'Software Testin', 'https://mca.spit.ac.in/wp-content/uploads/2022/12/NM.png', 0, 'FY', 'MCA');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `uid` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `branch` varchar(10) NOT NULL,
  `roll_number` int(11) NOT NULL,
  `java` int(11) NOT NULL,
  `process_automation` int(11) NOT NULL,
  `software_testing` int(11) NOT NULL,
  `year` varchar(2) NOT NULL,
  `profile` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`uid`, `name`, `branch`, `roll_number`, `java`, `process_automation`, `software_testing`, `year`, `profile`) VALUES
(2022510005, 'Tanmay Chavan', 'MCA', 5, 0, 0, 0, 'FY', 'https://www.valoguides.com/images/agents/jett/agent_jett-min.png'),
(2022510011, 'Viraj Dhumal', 'MCA', 11, 0, 0, 0, 'FY', 'https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltf0200e1821b5b39f/5eb7cdc144bf8261a04d87f9/V_AGENTS_587x900_Phx.png'),
(2022510004, 'Tejas Chalke', 'MCA', 4, 0, 0, 0, 'FY', 'https://gamepedia.cursecdn.com/valorant_esports_gamepedia_en/6/68/Agent_Omen_Half.png'),
(2022510036, 'Pranav Menon', 'MCA', 36, 0, 0, 0, 'FY', 'https://trackercdn.com/cdn/tracker.gg/valorant/db/agents/sage_portrait.png'),
(2022510038, 'Sahil Panchbhaiya', 'MCA', 38, 0, 0, 0, 'FY', 'https://static.tvtropes.org/pmwiki/pub/images/reyna_valorant.png');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
