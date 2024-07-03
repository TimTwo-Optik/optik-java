-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.4.0 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for optik
CREATE DATABASE IF NOT EXISTS `optik` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `optik`;

-- Dumping structure for table optik.barang
CREATE TABLE IF NOT EXISTS `barang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `kode_barang` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nama` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `kategori` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `harga` decimal(20,0) DEFAULT '0',
  `stok` int DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table optik.barang: ~17 rows (approximately)
INSERT INTO `barang` (`id`, `kode_barang`, `nama`, `kategori`, `harga`, `stok`) VALUES
	(3, 'B003', 'Kacamata Merah', 'frame', 130000, -1),
	(4, 'B004', 'Kacamata Kuning', 'lensa', 140000, 16),
	(5, 'B005', 'Kacamata Hijau', 'lensa', 170000, 12),
	(6, 'B006', 'Kacamata Pink', 'frame', 110000, 11),
	(8, 'B008', 'Kacamata Putih', 'frame', 125000, 19),
	(9, 'B009', 'Kacamata Abu-abu', 'aksesoris', 100000, 9),
	(10, 'B010', 'Kacamata Cokelat', 'lensa', 180000, 30),
	(21, 'B001', 'kacamata hitam', 'lensa', 180000, 20),
	(22, 'B002', 'Kacamata Biru', 'frame', 50000, 9),
	(23, 'B003', 'Kacamata Merah', 'frame', 130000, 16),
	(24, 'B004', 'Kacamata Kuning', 'lensa', 140000, 22),
	(26, 'B006', 'Kacamata Pink', 'frame', 110000, 12),
	(27, 'B007', 'Kacamata Ungu', 'lensa', 180000, 30),
	(28, 'B008', 'Kacamata Putih', 'frame', 125000, 20),
	(30, 'B010', 'Kacamata Cokelat', 'lensa', 180000, 24),
	(31, 'B001', 'kacamata hitam', 'lensa', 180000, 11),
	(32, 'B8964', 'Kacamata Ungu', 'frame', 150000, 100);

-- Dumping structure for table optik.detail_pembelian
CREATE TABLE IF NOT EXISTS `detail_pembelian` (
  `id_pembelian` varchar(50) NOT NULL,
  `id_barang` int DEFAULT NULL,
  `nama_barang` varchar(100) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `harga` int DEFAULT NULL,
  `kuantitas` int DEFAULT NULL,
  `total_harga` int DEFAULT NULL,
  PRIMARY KEY (`id_pembelian`),
  KEY `id_barang` (`id_barang`),
  CONSTRAINT `detail_pembelian_ibfk_1` FOREIGN KEY (`id_pembelian`) REFERENCES `penjualan` (`id`),
  CONSTRAINT `detail_pembelian_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table optik.detail_pembelian: ~0 rows (approximately)

-- Dumping structure for table optik.detail_penjualan
CREATE TABLE IF NOT EXISTS `detail_penjualan` (
  `id_penjualan` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_barang` int NOT NULL,
  `nama_barang` varchar(100) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `harga` decimal(20,0) DEFAULT NULL,
  `kuantitas` int DEFAULT NULL,
  `total_harga` decimal(20,0) DEFAULT NULL,
  KEY `id_barang` (`id_barang`),
  KEY `id_penjualan` (`id_penjualan`),
  CONSTRAINT `detail_penjualan_ibfk_1` FOREIGN KEY (`id_penjualan`) REFERENCES `penjualan` (`id`),
  CONSTRAINT `detail_penjualan_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table optik.detail_penjualan: ~12 rows (approximately)
INSERT INTO `detail_penjualan` (`id_penjualan`, `id_barang`, `nama_barang`, `kategori`, `harga`, `kuantitas`, `total_harga`) VALUES
	('INV/0003', 4, 'Kacamata Kuning', 'lensa', 140000, 5, 700000),
	('INV/0003', 5, 'Kacamata Hijau', 'lensa', 170000, 7, 1190000),
	('INV/0004', 31, 'kacamata hitam', 'lensa', 180000, 9, 1620000),
	('INV/0004', 30, 'Kacamata Cokelat', 'lensa', 180000, 6, 1080000),
	('INV/0004', 5, 'Kacamata Hijau', 'lensa', 170000, 4, 680000),
	('INV/0005', 5, 'Kacamata Hijau', 'lensa', 170000, 2, 340000),
	('INV/0005', 9, 'Kacamata Abu-abu', 'aksesoris', 100000, 1, 100000),
	('INV/0006', 3, 'Kacamata Merah', 'frame', 130000, 12, 1560000),
	('INV/0007', 3, 'Kacamata Merah', 'frame', 130000, 3, 390000),
	('INV/0007', 6, 'Kacamata Pink', 'frame', 110000, 1, 110000),
	('INV/0008', 23, 'Kacamata Merah', 'frame', 130000, 2, 260000),
	('INV/0008', 4, 'Kacamata Kuning', 'lensa', 140000, 1, 140000);

-- Dumping structure for table optik.karyawan
CREATE TABLE IF NOT EXISTS `karyawan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nama` varchar(100) NOT NULL,
  `Kontak` varchar(14) NOT NULL,
  `Alamat` text NOT NULL,
  `email` varchar(50) NOT NULL,
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT (1),
  `waktu_bergabung` date DEFAULT (now()),
  PRIMARY KEY (`id`),
  UNIQUE KEY `Kontak` (`Kontak`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table optik.karyawan: ~7 rows (approximately)
INSERT INTO `karyawan` (`id`, `Nama`, `Kontak`, `Alamat`, `email`, `status`, `waktu_bergabung`) VALUES
	(1, 'Yudanto', '0876654487654', 'Jl. Damai RT 05, RW 09 Ciracas, Jakarta Selatan', 'yuda@yahoo.com', '0', '2024-05-07'),
	(6, 'anton', '087586884345', 'Bojong sari no 31 Bekasi', 'anton@gmail.com', '1', '2024-05-09'),
	(8, 'amber', '07876894664343', 'mondstatd', 'amber@yahoo.com', '1', '2024-05-09'),
	(9, 'melissa', '086587867534', 'celestia', 'melissa@genshin.com', '1', '2024-05-09'),
	(10, 'sparkle', '0876689459963', 'penacony', 'sparkle@gmail.com', '1', '2024-05-09'),
	(12, 'Sabdha', '0876384343', 'Kalsisari', 'sabdha@gmaill.com', '1', '2024-06-19'),
	(13, 'Rudi', '0829489889', 'bekasi', 'rudi@example', '1', '2024-06-26');

-- Dumping structure for table optik.nota
CREATE TABLE IF NOT EXISTS `nota` (
  `idnota` varchar(50) DEFAULT NULL,
  `tanggalnota` date DEFAULT NULL,
  `idpelanggan` varchar(50) DEFAULT NULL,
  `namapelanggan` varchar(50) DEFAULT NULL,
  `totaltransaksi` decimal(20,0) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table optik.nota: ~0 rows (approximately)

-- Dumping structure for table optik.pelanggan
CREATE TABLE IF NOT EXISTS `pelanggan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama_pelanggan` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `kontak` varchar(50) DEFAULT NULL,
  `alamat` text,
  `status` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_nama_pelanggan` (`nama_pelanggan`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table optik.pelanggan: ~97 rows (approximately)
INSERT INTO `pelanggan` (`id`, `nama_pelanggan`, `kontak`, `alamat`, `status`) VALUES
	(1, 'John Doe', 'john@example.com', '123 Main Street, Anytown', 1),
	(3, 'Michael Lee', 'michael@example.com', '789 Oak Street, Anycity', 1),
	(4, 'Sarah Brown', 'sarah@example.com', '101 Maple Avenue, Anycity', 0),
	(5, 'David Johnson', 'david@example.com', '222 Pine Street, Othertown', 1),
	(6, 'Emily Wilson', 'emily@example.com', '333 Cedar Avenue, Anycity', 1),
	(7, 'Daniel Kim', 'daniel@example.com', '444 Birch Street, Anytown', 1),
	(8, 'Lisa Garcia', 'lisa@example.com', '555 Walnut Drive, Othertown', 1),
	(9, 'Kevin Chen', 'kevin@example.com', '666 Cherry Lane, Anycity', 1),
	(10, 'Jessica Wang', 'jessica@example.com', '777 Spruce Street, Anytown', 1),
	(11, 'Robert Smith', 'robert@example.com', '888 Apple Road, Othertown', 1),
	(12, 'Jennifer Davis', 'jennifer@example.com', '999 Peach Boulevard, Anytown', 1),
	(13, 'Christopher Wilson', 'christopher@example.com', '111 Plum Lane, Anycity', 1),
	(14, 'Amanda Taylor', 'amanda@example.com', '222 Lemon Drive, Othertown', 1),
	(15, 'Matthew Martinez', 'matthew@example.com', '333 Banana Street, Anytown', 1),
	(16, 'Elizabeth Anderson', 'elizabeth@example.com', '444 Grape Avenue, Anycity', 1),
	(17, 'Joshua Thomas', 'joshua@example.com', '555 Orange Road, Othertown', 1),
	(18, 'Ashley Harris', 'ashley@example.com', '666 Mango Lane, Anytown', 1),
	(19, 'Andrew Walker', 'andrew@example.com', '777 Coconut Drive, Anycity', 1),
	(20, 'Jessica Nelson', 'jessica@example.com', '888 Papaya Boulevard, Othertown', 1),
	(21, 'William King', 'william@example.com', '999 Kiwi Lane, Anytown', 1),
	(22, 'Melissa White', 'melissa@example.com', '111 Cherry Street, Anycity', 1),
	(23, 'Christopher Clark', 'christopher@example.com', '222 Pear Avenue, Othertown', 1),
	(24, 'Mary Wright', 'mary@example.com', '333 Blueberry Road, Anytown', 1),
	(25, 'David Young', 'david@example.com', '444 Raspberry Drive, Anycity', 1),
	(26, 'Patricia Lopez', 'patricia@example.com', '555 Strawberry Lane, Othertown', 1),
	(27, 'Michael Hall', 'michael@example.com', '666 Watermelon Boulevard, Anytown', 1),
	(28, 'Laura Martinez', 'laura@example.com', '777 Cranberry Drive, Anycity', 1),
	(29, 'Daniel Thompson', 'daniel@example.com', '888 Blackberry Avenue, Othertown', 1),
	(30, 'Kimberly Perez', 'kimberly@example.com', '999 Grapefruit Lane, Anytown', 1),
	(31, 'Joseph Jackson', 'joseph@example.com', '111 Pineapple Road, Anycity', 1),
	(32, 'Michelle Hernandez', 'michelle@example.com', '222 Fig Street, Othertown', 1),
	(33, 'Richard Gonzalez', 'richard@example.com', '333 Cherry Blossom Drive, Anytown', 1),
	(34, 'Karen Lewis', 'karen@example.com', '444 Sunflower Lane, Anycity', 1),
	(35, 'Jason Hill', 'jason@example.com', '555 Tulip Road, Othertown', 1),
	(36, 'Maria Scott', 'maria@example.com', '666 Lily Drive, Anytown', 1),
	(37, 'William Green', 'william@example.com', '777 Daisy Avenue, Anycity', 1),
	(38, 'Sandra Adams', 'sandra@example.com', '888 Rose Street, Othertown', 1),
	(39, 'Jessica Baker', 'jessica@example.com', '999 Orchid Lane, Anytown', 1),
	(40, 'Charles Cook', 'charles@example.com', '111 Magnolia Drive, Anycity', 1),
	(41, 'Nancy Murphy', 'nancy@example.com', '222 Jasmine Boulevard, Othertown', 1),
	(42, 'Daniel Morris', 'daniel@example.com', '333 Iris Lane, Anytown', 1),
	(43, 'Jennifer Hill', 'jennifer@example.com', '444 Hyacinth Street, Anycity', 1),
	(44, 'James Nelson', 'james@example.com', '555 Lily-of-the-Valley Road, Othertown', 1),
	(45, 'Karen Rivera', 'karen@example.com', '666 Forget-Me-Not Drive, Anytown', 1),
	(46, 'Paula Perry', 'paula@example.com', '777 Peony Avenue, Anycity', 1),
	(47, 'Kenneth Wood', 'kenneth@example.com', '888 Bluebell Lane, Othertown', 1),
	(48, 'Brenda Ward', 'brenda@example.com', '999 Daffodil Road, Anytown', 1),
	(97, 'John Doe', 'john@example.com', '123 Main Street, Anytown', 1),
	(98, 'Jane Smith', 'jane@example.com', '456 Elm Street, Othertown', 1),
	(99, 'Michael Lee', 'michael@example.com', '789 Oak Street, Anycity', 1),
	(100, 'Sarah Brown', 'sarah@example.com', '101 Maple Avenue, Anycity', 1),
	(101, 'David Johnson', 'david@example.com', '222 Pine Street, Othertown', 1),
	(102, 'Emily Wilson', 'emily@example.com', '333 Cedar Avenue, Anycity', 1),
	(103, 'Daniel Kim', 'daniel@example.com', '444 Birch Street, Anytown', 1),
	(104, 'Lisa Garcia', 'lisa@example.com', '555 Walnut Drive, Othertown', 1),
	(105, 'Kevin Chen', 'kevin@example.com', '666 Cherry Lane, Anycity', 1),
	(106, 'Jessica Wang', 'jessica@example.com', '777 Spruce Street, Anytown', 1),
	(107, 'Robert Smith', 'robert@example.com', '888 Apple Road, Othertown', 1),
	(108, 'Jennifer Davis', 'jennifer@example.com', '999 Peach Boulevard, Anytown', 1),
	(109, 'Christopher Wilson', 'christopher@example.com', '111 Plum Lane, Anycity', 1),
	(110, 'Amanda Taylor', 'amanda@example.com', '222 Lemon Drive, Othertown', 1),
	(111, 'Matthew Martinez', 'matthew@example.com', '333 Banana Street, Anytown', 1),
	(112, 'Elizabeth Anderson', 'elizabeth@example.com', '444 Grape Avenue, Anycity', 1),
	(113, 'Joshua Thomas', 'joshua@example.com', '555 Orange Road, Othertown', 1),
	(114, 'Ashley Harris', 'ashley@example.com', '666 Mango Lane, Anytown', 1),
	(115, 'Andrew Walker', 'andrew@example.com', '777 Coconut Drive, Anycity', 1),
	(116, 'Jessica Nelson', 'jessica@example.com', '888 Papaya Boulevard, Othertown', 1),
	(117, 'William King', 'william@example.com', '999 Kiwi Lane, Anytown', 1),
	(118, 'Melissa White', 'melissa@example.com', '111 Cherry Street, Anycity', 1),
	(119, 'Christopher Clark', 'christopher@example.com', '222 Pear Avenue, Othertown', 1),
	(120, 'Mary Wright', 'mary@example.com', '333 Blueberry Road, Anytown', 1),
	(121, 'David Young', 'david@example.com', '444 Raspberry Drive, Anycity', 1),
	(122, 'Patricia Lopez', 'patricia@example.com', '555 Strawberry Lane, Othertown', 1),
	(123, 'Michael Hall', 'michael@example.com', '666 Watermelon Boulevard, Anytown', 1),
	(124, 'Laura Martinez', 'laura@example.com', '777 Cranberry Drive, Anycity', 1),
	(125, 'Daniel Thompson', 'daniel@example.com', '888 Blackberry Avenue, Othertown', 1),
	(126, 'Kimberly Perez', 'kimberly@example.com', '999 Grapefruit Lane, Anytown', 1),
	(127, 'Joseph Jackson', 'joseph@example.com', '111 Pineapple Road, Anycity', 1),
	(128, 'Michelle Hernandez', 'michelle@example.com', '222 Fig Street, Othertown', 1),
	(129, 'Richard Gonzalez', 'richard@example.com', '333 Cherry Blossom Drive, Anytown', 1),
	(130, 'Karen Lewis', 'karen@example.com', '444 Sunflower Lane, Anycity', 1),
	(131, 'Jason Hill', 'jason@example.com', '555 Tulip Road, Othertown', 1),
	(132, 'Maria Scott', 'maria@example.com', '666 Lily Drive, Anytown', 1),
	(133, 'William Green', 'william@example.com', '777 Daisy Avenue, Anycity', 1),
	(134, 'Sandra Adams', 'sandra@example.com', '888 Rose Street, Othertown', 1),
	(135, 'Jessica Baker', 'jessica@example.com', '999 Orchid Lane, Anytown', 1),
	(136, 'Charles Cook', 'charles@example.com', '111 Magnolia Drive, Anycity', 1),
	(137, 'Nancy Murphy', 'nancy@example.com', '222 Jasmine Boulevard, Othertown', 1),
	(138, 'Daniel Morris', 'daniel@example.com', '333 Iris Lane, Anytown', 1),
	(139, 'Jennifer Hill', 'jennifer@example.com', '444 Hyacinth Street, Anycity', 1),
	(140, 'James Nelson', 'james@example.com', '555 Lily-of-the-Valley Road, Othertown', 1),
	(141, 'Karen Rivera', 'karen@example.com', '666 Forget-Me-Not Drive, Anytown', 1),
	(142, 'Paula Perry', 'paula@example.com', '777 Peony Avenue, Anycity', 1),
	(143, 'Kenneth Wood', 'kenneth@example.com', '888 Bluebell Lane, Othertown', 1),
	(144, 'Brenda Ward', 'brenda@example.com', '999 Daffodil Road, Anytown', 1),
	(145, 'Syahdan', '08946657643', 'Bekasi', 1),
	(146, 'Budi', '083349284923', 'bogor', 1);

-- Dumping structure for table optik.pembelian
CREATE TABLE IF NOT EXISTS `pembelian` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_supplier` int DEFAULT NULL,
  `id_barang` int DEFAULT NULL,
  `tanggal_beli` date NOT NULL DEFAULT (now()),
  `kuantitas` int NOT NULL DEFAULT (0),
  `total_harga` decimal(20,0) NOT NULL DEFAULT '0',
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_pembelian` (`id_supplier`),
  KEY `fk_barang_pembelian` (`id_barang`),
  CONSTRAINT `fk_barang_pembelian` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id`),
  CONSTRAINT `fk_supplier_pembelian` FOREIGN KEY (`id_supplier`) REFERENCES `suppliers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table optik.pembelian: ~46 rows (approximately)
INSERT INTO `pembelian` (`id`, `id_supplier`, `id_barang`, `tanggal_beli`, `kuantitas`, `total_harga`, `status`) VALUES
	(1, 1, 5, '2024-02-01', 57, 3000000, 'Lunas'),
	(2, 3, 5, '2024-04-02', 54, 1200000, 'Lunas'),
	(3, 5, 9, '2024-08-03', 38, 3900000, 'Lunas'),
	(4, 6, 9, '2024-01-04', 31, 2800000, 'Lunas'),
	(5, 5, 10, '2024-06-05', 45, 1600000, 'Lunas'),
	(6, 7, 10, '2024-10-06', 54, 2200000, 'Lunas'),
	(8, 8, 4, '2024-12-08', 49, 1250000, 'Lunas'),
	(10, 2, 4, '2024-05-10', 38, 1800000, 'Lunas'),
	(11, 5, 6, '2024-11-11', 47, 3200000, 'Lunas'),
	(12, 10, 3, '2024-07-12', 34, 1100000, 'Lunas'),
	(14, 2, 5, '2024-12-14', 45, 2500000, 'Lunas'),
	(15, 5, 5, '2024-04-15', 30, 1400000, 'Lunas'),
	(16, 8, 6, '2024-08-16', 56, 2300000, 'Lunas'),
	(17, 5, 9, '2024-10-17', 57, 5500000, 'Lunas'),
	(18, 8, 5, '2024-02-18', 50, 1350000, 'Lunas'),
	(19, 1, 3, '2024-11-19', 53, 1800000, 'Lunas'),
	(21, 2, 6, '2024-05-21', 46, 2900000, 'Lunas'),
	(23, 8, 10, '2024-04-23', 41, 4800000, 'Lunas'),
	(24, 9, 6, '2024-11-24', 53, 2700000, 'Lunas'),
	(25, 4, 5, '2024-03-25', 36, 1900000, 'Lunas'),
	(26, 6, 4, '2024-09-26', 33, 3100000, 'Lunas'),
	(27, 4, 4, '2024-01-27', 50, 5200000, 'Lunas'),
	(28, 4, 8, '2024-06-28', 53, 1600000, 'Lunas'),
	(29, 6, 3, '2024-08-29', 55, 3000000, 'Lunas'),
	(31, 3, 3, '2025-02-01', 40, 3000000, 'Lunas'),
	(32, 2, 8, '2025-04-02', 44, 1200000, 'Lunas'),
	(36, 6, 8, '2025-10-06', 43, 2200000, 'Lunas'),
	(37, 8, 6, '2025-03-07', 49, 5100000, 'Lunas'),
	(38, 5, 3, '2025-12-08', 50, 1250000, 'Lunas'),
	(40, 7, 5, '2025-05-10', 40, 1800000, 'Lunas'),
	(41, 3, 3, '2025-11-11', 47, 3200000, 'Lunas'),
	(42, 10, 3, '2025-07-12', 60, 1100000, 'Lunas'),
	(44, 2, 9, '2025-12-14', 41, 2500000, 'Lunas'),
	(46, 4, 9, '2025-08-16', 41, 2300000, 'Lunas'),
	(47, 2, 5, '2025-10-17', 57, 5500000, 'Lunas'),
	(48, 3, 3, '2025-02-18', 47, 1350000, 'Lunas'),
	(50, 3, 3, '2025-09-20', 35, 1700000, 'Lunas'),
	(51, 4, 4, '2025-05-21', 45, 2900000, 'Lunas'),
	(52, 6, 4, '2025-07-22', 57, 1500000, 'Lunas'),
	(55, 3, 5, '2025-03-25', 47, 1900000, 'Lunas'),
	(56, 6, 10, '2025-09-26', 38, 3100000, 'Lunas'),
	(57, 5, 3, '2025-01-27', 33, 5200000, 'Lunas'),
	(58, 8, 5, '2025-06-28', 52, 1600000, 'Lunas'),
	(59, 5, 10, '2025-08-29', 49, 3000000, 'Lunas'),
	(60, 3, 4, '2025-12-30', 32, 2000000, 'Lunas'),
	(61, 2, 27, '2024-06-26', 2, 90000, 'Lunas');

-- Dumping structure for table optik.penjualan
CREATE TABLE IF NOT EXISTS `penjualan` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_pelanggan` int DEFAULT NULL,
  `tanggal_jual` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `id_pelanggan` (`id_pelanggan`),
  CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table optik.penjualan: ~8 rows (approximately)
INSERT INTO `penjualan` (`id`, `id_pelanggan`, `tanggal_jual`, `status`) VALUES
	('INV/0001', 1, '2024-06-07', 'Lunas'),
	('INV/0002', 1, '2024-06-17', 'Lunas'),
	('INV/0003', 1, '2024-06-17', 'Lunas'),
	('INV/0004', 143, '2024-06-17', 'Lunas'),
	('INV/0005', 4, '2024-06-19', 'Lunas'),
	('INV/0006', 3, '2024-06-26', 'Lunas'),
	('INV/0007', 43, '2024-06-26', 'Lunas'),
	('INV/0008', 43, '2024-06-26', 'Lunas');

-- Dumping structure for table optik.suppliers
CREATE TABLE IF NOT EXISTS `suppliers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama_supplier` varchar(50) DEFAULT NULL,
  `kontak` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `jenis_supplier` varchar(50) DEFAULT NULL,
  `lokasi_supplier` varchar(50) DEFAULT NULL,
  `alamat` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table optik.suppliers: ~14 rows (approximately)
INSERT INTO `suppliers` (`id`, `nama_supplier`, `kontak`, `email`, `jenis_supplier`, `lokasi_supplier`, `alamat`) VALUES
	(1, 'PT Bagus Jaya Abadi', '084567866354', 'bagus@jayaabadi.com', 'Lensa', 'Luar Negeri', 'Swiss'),
	(2, 'PT Fadhil Cahaya Asia', '0897654387658', 'fadhil@abadi.com', 'Frame', 'Jabodetabek', 'Jakarta'),
	(3, 'Supplier A', '081234567890', 'supplierA@example.com', 'lensa', 'Luar Kota', 'Alamat Supplier A'),
	(4, 'Supplier B', '081234567891', 'supplierB@example.com', 'frame', 'Luar Negeri', 'Alamat Supplier B'),
	(5, 'Supplier C', '081234567892', 'supplierC@example.com', 'aksesoris', 'Jabodetabek', 'Alamat Supplier C'),
	(6, 'Supplier D', '081234567893', 'supplierD@example.com', 'lensa', 'Luar Kota', 'Alamat Supplier D'),
	(7, 'Supplier E', '081234567894', 'supplierE@example.com', 'frame', 'Luar Negeri', 'Alamat Supplier E'),
	(8, 'Supplier F', '081234567895', 'supplierF@example.com', 'aksesoris', 'Jabodetabek', 'Alamat Supplier F'),
	(9, 'Supplier G', '081234567896', 'supplierG@example.com', 'lensa', 'Luar Kota', 'Alamat Supplier G'),
	(10, 'Supplier H', '081234567897', 'supplierH@example.com', 'frame', 'Luar Negeri', 'Alamat Supplier H'),
	(12, 'supplier787', '087678456464', 'supplier787@gmial.com', 'Lensa', 'Jabodetabek', 'Bojong Gede'),
	(13, 'supplier 777', '077883445864', 'supplier777@testing.com', 'Frame', 'Luar Kota', 'gfadsgdasgewa'),
	(14, 'PT ABC', '08668343', 'abc@supplier.co.id', 'Lensa', 'Jabodetabek', 'Bogor'),
	(15, 'PT. Alif ', '089540915114', 'alifpajar4@gmail.com', 'Lensa', 'Jabodetabek', 'Jl. gintung');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
