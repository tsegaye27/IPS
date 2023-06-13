-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2023 at 02:29 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ois`
--

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
  `appId` int(11) NOT NULL,
  `internId` int(11) NOT NULL,
  `internshipId` int(11) NOT NULL,
  `yearOfStudy` int(11) NOT NULL,
  `universityName` varchar(255) NOT NULL,
  `skills` varchar(255) NOT NULL,
  `gitURL` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT 'pending',
  `interests` text DEFAULT NULL,
  `experience` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`appId`, `internId`, `internshipId`, `yearOfStudy`, `universityName`, `skills`, `gitURL`, `status`, `interests`, `experience`) VALUES
(1, 2, 2, 3, '1', '11', '1', 'accepted', '1', '1'),
(2, 2, 1, 3, '1', '11', '1', 'pending', '1', '1'),
(3, 2, 4, 3, '1', '11', '1', 'pending', '1', '1'),
(4, 8, 1, 3, 's', 's', 's', 'pending', 'ss', 's'),
(5, 8, 7, 3, 'bahir dar university', 'front end: html css javascript, backend:php', 'none', 'pending', 'i\'m interested in being a front end developer', 'none'),
(6, 6, 4, 3, 'Addis Ababa', 'java', 'git', 'pending', 'i love java', '1 year working on java projects');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `phone` int(10) NOT NULL,
  `location` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `name`, `email`, `pass`, `phone`, `location`) VALUES
(1, 'xyz tech', 'xyz@gmail.com', 'xyz', 987654321, 'adiss'),
(2, 'Hahu jobs', 'jobs@hahu.com', 'hahujobs', 911111111, 'Adiss Ababa'),
(3, 'Eshi Tech', 'tech@eshi.com', 'eshitech', 922222222, 'Adiss Ababa'),
(4, '360 Ground', 'ground360@gmail.com', 'ground360', 933333333, 'bahir dar'),
(5, 'Addis soft', 'addis@soft.com', 'addissoft', 912211221, 'Dire Dawa'),
(6, 'GeezByte', 'geezbyte@gmail.com', 'geezbyte', 988776655, 'Debre Birihan');

-- --------------------------------------------------------

--
-- Table structure for table `internshipposts`
--

CREATE TABLE `internshipposts` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `Title` text NOT NULL,
  `duration` varchar(255) NOT NULL,
  `requirements` text NOT NULL,
  `description` text DEFAULT NULL,
  `type` varchar(6) DEFAULT NULL,
  `numberOfApplicantsNeeded` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `internshipposts`
--

INSERT INTO `internshipposts` (`id`, `company_id`, `Title`, `duration`, `requirements`, `description`, `type`, `numberOfApplicantsNeeded`) VALUES
(1, 2, 'Front end web Developer', '2 months', 'Html, Css, Javascript/Typescript, React js', 'As a web development intern, you will assist our team in building and maintaining websites for clients. We expect basic knowledge of HTML, CSS, and JavaScript, as well as strong communication skills and attention to detail. You will gain valuable experience and build a portfolio of work to kickstart your career in web development.', 'unpaid', 6),
(2, 6, 'Software Developer', '1 month', 'Java, JavaFX, Jsp, Mysql', 'Our software development internship requires knowledge of Java, JavaFX, JSP, and MySQL. You\'ll work with our team on designing, coding, testing, and debugging software applications for clients. Strong communication and collaboration skills are a must. Gain practical experience and build a portfolio to set you on the path to a successful career in software development.', 'unpaid', 15),
(3, 3, 'Software Devloper', '1 month', 'Node js, Mongo DB', ' You\'ll work with our team on designing, coding, testing, and debugging software applications for clients. Strong communication and collaboration skills are a must. Gain practical experience and build a portfolio to set you on the path to a successful career in software development.', 'unpaid', 5),
(4, 2, 'software tester', '3 months', 'Java, JUnit, and TestNG and experience with Jira or Bugzilla', 'Our software testing internship program will provide you with hands-on experience in manual and automated testing. You will work alongside our experienced QA team to test software applications, identify defects, and report findings. We value attention to detail, strong communication skills, and the ability to work collaboratively in a team environment.', 'unpaid', 6),
(5, 5, 'Back End developer', '3 months', 'Node js, Express js, mongo DB', 'this is an internship that will enable you to learn and experience new technologies and grow your skill. If you are interested, apply.', 'unpaid', 20),
(7, 3, 'UI/UX designer', '1 month', 'Figma, Adobe Photoshop', 'aspiring UI/UX designers needed', 'unpaid', 6);

-- --------------------------------------------------------

--
-- Table structure for table `stud`
--

CREATE TABLE `stud` (
  `id` int(11) NOT NULL,
  `fullName` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `phone` int(10) DEFAULT NULL,
  `dept` varchar(40) DEFAULT NULL,
  `birth` varchar(20) DEFAULT NULL,
  `gradYear` varchar(4) DEFAULT NULL,
  `location` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stud`
--

INSERT INTO `stud` (`id`, `fullName`, `email`, `pass`, `phone`, `dept`, `birth`, `gradYear`, `location`) VALUES
(1, 'Kaleab Solomon', 'kaleabslmn@gmail.com', 'osiPass1234', 942102626, 'software engineering', '2002', '2025', 'Adiss Ababa'),
(2, 'kaleab', 'kb@kb.dev', '112211', 0, 'software', NULL, NULL, 'bahir dar'),
(3, 'smachew', 'sme@gedefaw.com', 'smachew123', 999112233, 'Graphics Design', 'Jun 09, 2000', '2025', 'welkite'),
(4, 'a', 'a', 'a', 1, 'a', 'Jun 04, 2023', '2023', 'a'),
(5, 'jon doe', 'jon@doe.com', 'jondoe', 912121212, 'mechanical engineering', 'Jun 11, 2023', '2023', 'wachamo'),
(6, 'John Aseffa', 'johnAseffa@gmail.com', 'hohnAseffa', 911221111, 'software engineering', 'Jun 21, 2001', '2025', 'addis ababa'),
(7, 'shalom wubu', 'shalomWubu@gmail.com', 'shalom', 999119911, 'software engineering', 'Jun 21, 2001', '2027', 'Jemo'),
(8, 'titus tit', 'tit@gmail.com', 'titus1', 98133212, 'computer science', 'Jun 20, 2004', '2024', 'Gondar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`appId`),
  ADD KEY `internId` (`internId`),
  ADD KEY `internshipId` (`internshipId`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `internshipposts`
--
ALTER TABLE `internshipposts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `stud`
--
ALTER TABLE `stud`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `appId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `internshipposts`
--
ALTER TABLE `internshipposts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `stud`
--
ALTER TABLE `stud`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `application_ibfk_1` FOREIGN KEY (`internId`) REFERENCES `stud` (`id`),
  ADD CONSTRAINT `application_ibfk_2` FOREIGN KEY (`internshipId`) REFERENCES `internshipposts` (`id`);

--
-- Constraints for table `internshipposts`
--
ALTER TABLE `internshipposts`
  ADD CONSTRAINT `internshipposts_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
