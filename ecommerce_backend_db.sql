-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th9 05, 2024 lúc 02:35 PM
-- Phiên bản máy phục vụ: 8.0.17
-- Phiên bản PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ecommerce_backend_db`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fullname` varchar(50) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `address`, `birthdate`, `email`, `fullname`, `gender`, `password`, `phone_number`, `role`, `username`) VALUES
(1, 'aaaaaaa', '2002-11-12', 'xuanhieu0031@gmail.com', 'dang xuan hieu', 'Male', '$2a$10$wU9AybJn0egq6uot9lV7zuYg16ka0TFQmRSAj5O/IJ41EVkQd5vlO', '0858250715', 'Admin', 'xuanhieu'),
(2, 'Bắc Ninh', '2023-12-19', 'xuanhieu1102@gmail.com', 'dang xuan hieu', 'Female', '$2a$10$A5E54C2VNeKo81VnP87bQOLTw8kPES6ZzGrlCicz3HiftwYMbNiJK', '7536252', 'Admin', 'xuanhieu5'),
(4, 'Bắc Kạn', '2023-12-29', 'xuanhieu2102@gmail.com', 'dang xuan hieu', 'Female', '$2a$10$G1MT6jydRve72Cl2I1m9N.VrzIKBGWH.B2NMssceUy8Sv8W1U/a3G', '646262', 'User', 'xuanhieu6'),
(5, 'Bến Tre', '2023-12-28', 'xuanhieu11022@gmail.com', 'dang xuan hieu', 'Female', '$2a$10$B1gdn9CVcl.5DFkvPnDN9uCe5cPvb3Vs3tsfOQsD/kqbQbyjXlRjm', '6462625', 'User', 'xuanhieu7'),
(6, 'Bến Tre', '2023-12-28', 'xuanhieu110223@gmail.com', 'dang xuan hieu', 'Female', '$2a$10$gqGmA1x4GQY.97ZkrTrI0OG2jZlfEqAM43hw6jdbis9PQPap6KyXS', '6462625', 'User', 'xuanhieu8'),
(7, 'Bến Tre', '2023-12-11', 'xuanhieu21302@gmail.com', 'dang xuan hieu', 'Male', '$2a$10$juvIbGVCu6RNGrF/OM6uCOg8hxXd3Ink/dohCHfku.PVe3EerZ9SO', '7536252', 'User', 'xuanhieu2'),
(8, 'Đắk Nông', '2017-11-01', 'xuanhieu11035@gmail.com', 'dang xuan hieu', 'Male', '$2a$10$SjGjOeH44U5h6mu6Y0yNuOJ0SAFtScrHyMUYbNAg/wZsz12B6ByI2', '753625214', 'User', 'xuanhieu1'),
(9, 'Bắc Kạn', '2023-12-25', 'xuanhieu1102132@gmail.com', 'dang xuan hieu', 'Male', '$2a$10$KiX4.C/kWUidE.0k7GczkezOD7Fc6Vvu2CcUS9Q2BN8UR1MtEh43K', '7536252', 'User', 'xuanhieu11'),
(10, 'Bạc Liêu', '2023-12-26', 'xuanhieu123102@gmail.com', 'dang xuan hieu', 'Female', '$2a$10$bYjtZtOdplxCD3GMg6IKOuROFTatnpc/yvE8NOkwBnzjiOQNyXt9C', '7536252', 'User', 'xuanhieu12'),
(11, 'Hà Nội', '2023-12-19', 'xuanhieu003112@gmail.com', 'Dang Xuan Hieu', 'Male', '$2a$10$t9M4.2uBh6DHMDyotelSt.kz3pROIAqcqfxuF3Fe9t.aBQ4O2Bg7q', '23124112', 'User', 'xuanhieu1102'),
(12, 'Hà Nội', '2023-12-19', 'xuanhieu00321@gmail.com', 'Dang Xuan Hieu', 'Male', '$2a$10$wqRc3hMfl.kobLj6.gvyZ./h7qUfVodkeowFj8XD/NDm6YXfbr3QO', '0858250714', 'User', 'dangxuanhieu');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brands`
--

CREATE TABLE `brands` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `brands`
--

INSERT INTO `brands` (`id`, `name`) VALUES
(1, 'apple'),
(2, 'samsung'),
(3, 'xiaomi'),
(4, 'oppo'),
(5, 'acer');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(5, 'clock'),
(2, 'laptop'),
(1, 'mobilephone'),
(7, 'screen'),
(6, 'smart TV'),
(3, 'tablet');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `love_product`
--

CREATE TABLE `love_product` (
  `id` int(11) NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `option_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `love_product`
--

INSERT INTO `love_product` (`id`, `account_id`, `option_id`) VALUES
(2, 2, 6),
(3, 2, 4),
(11, 1, 5),
(13, 2, 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `name`, `brand_id`, `category_id`) VALUES
(2, 'Gigabyte Aero 20 OLED2', 2, 1),
(3, 'Điện thoại iPhone 14 Pro Max (128GB) - Chính hãng VN/A', 2, 1),
(4, 'Acer Chromebook Spin 713', 1, 2),
(5, 'Samsung Galaxy Book Flex 2 Alpha', 3, 2),
(6, 'Điện thoại iPhone 14 Pro Max (128GB) - Chính hãng VN/A', 2, 3),
(8, 'MacBook Air M1 13\" (8GB/256GB) - Chính hãng Apple Việt Nam', 3, 1),
(9, 'Điện thoại iPhone 14 Pro Max (128GB) - Chính hãng VN/A', 2, 3),
(10, 'Dell Chromebook 3100', 3, 2),
(11, 'Điện thoại iPhone 15 (256GB) - Chính hãng VN/A', 2, 1),
(12, 'Điện thoại iPhone 14 Pro Max (256GB) - Chính hãng VN/A', 2, 1),
(13, 'Điện thoại ASUS ROG Phone 7 (16GB/512GB) - Chính hãng', 3, 1),
(14, 'Điện thoại iPhone 14 Pro Max (256GB) - Chính hãng VN/A', 3, 1),
(15, 'Điện thoại iPhone 14 Plus (128GB) - Chính hãng VN/A', 1, 1),
(16, 'Điện thoại iPhone 15 Plus (128GB) - Chính hãng VN/A', 1, 1),
(17, 'Điện thoại iPhone 14 Pro Max (128GB) - Chính hãng VN/A', 2, 1),
(18, 'Điện thoại iPhone 15 (512GB) - Chính hãng VN/A', 2, 1),
(19, 'Điện thoại Samsung Galaxy S23 Plus - 8GB/512GB - Chính hãng', 1, 1),
(20, 'Điện thoại NUBIA REDMAGIC 7 PUSAR 16GB 256GB - Chính hãng', 1, 1),
(21, 'Điện thoại NUBIA REDMAGIC 7 PUSAR 16GB 256GB - Chính hãng', 1, 1),
(22, 'Điện thoại iPhone 14 Pro Max (256GB) - Chính hãng VN/A', 2, 1),
(23, 'MacBook Air M1 13\" (8GB/256GB) - Chính hãng Apple Việt Nam', 3, 1),
(24, 'Điện thoại iPhone 14 Pro Max (256GB) - Chính hãng VN/A', 1, 1),
(25, 'Điện thoại iPhone 15 (512GB) - Chính hãng VN/A', 1, 1),
(26, 'Đồng hồ thông minh Apple Watch Series 7 GPS, 41mm – Viền nhôm dây cao su - Chính hãng VN/A', 2, 5),
(27, 'Đồng hồ thông minh Apple Watch SE 2023 - GPS + LTE, 44mm - Vỏ Nhôm Dây Cao Su - VN/A', 3, 5),
(28, 'Đồng hồ thông minh Forerunner 255 Music - Chính Hãng', 2, 5),
(29, 'Đồng hồ thông minh Apple Watch SE 2023 - GPS, 44mm - Vỏ Nhôm Dây Cao Su - VN/A', 2, 5),
(30, 'Đồng hồ thông minh Garmin Venu SQ 2 Music - Chính hãng', 2, 5),
(31, 'Đồng hồ thông minh Forerunner 255 Music - Chính Hãng', 3, 5),
(32, 'Đồng hồ thông minh Garmin Venu SQ 2 Music - Chính hãng', 2, 5),
(40, 'Asus ZenBook 14 OLED', 1, 2),
(41, 'Dell XPS 13 Plus', 2, 2),
(42, 'HP Spectre x360 14', 3, 2),
(43, 'Apple MacBook Air M2', 4, 2),
(44, 'Lenovo ThinkPad X1 Carbon Gen 10', 1, 2),
(45, 'Microsoft Surface Laptop Studio', 2, 2),
(46, 'Samsung Galaxy Book Pro 360', 3, 2),
(47, 'Acer Swift X', 4, 2),
(48, 'Razer Blade 14', 1, 2),
(49, 'Gigabyte Aero 15 OLED', 2, 2),
(50, 'MSI Prestige 14', 3, 6),
(51, 'ASUS ROG Zephyrus G14', 4, 6),
(52, 'Acer Nitro 5', 1, 6),
(53, 'Dell G15', 2, 2),
(54, 'HP Pavilion Gaming 15', 3, 2),
(55, 'Lenovo Legion 5 Pro', 4, 2),
(56, 'Asus TUF Dash 15', 1, 2),
(57, 'Acer Swift 3', 2, 2),
(58, 'Dell Inspiron 14', 3, 2),
(60, 'Lenovo IdeaPad 5', 1, 2),
(61, 'Microsoft Surface Laptop 4', 2, 2),
(62, 'Samsung Galaxy Book Flex 2 Alpha', 3, 2),
(63, 'Acer Chromebook Spin 713', 4, 2),
(64, 'Dell Chromebook 3100', 1, 2),
(65, 'HP Chromebook x360 14', 2, 2),
(66, 'Lenovo Chromebook Duet 5', 3, 2),
(67, 'Asus Chromebook Flip CX5', 4, 2),
(68, 'Asus Chromebook Flip CX5', 2, 1),
(69, 'Microsoft Surface Laptop 4', 2, 5),
(70, 'Asus Chromebook Flip CX5', 2, 2),
(71, 'Microsoft Surface Laptop 4', 2, 2),
(72, 'Asus Chromebook Flip CX5', 3, 2),
(73, 'AAAAAAAAAAAAAAAAAAAAa', 2, 3),
(74, 'Màn hình Asus VA24EHF  - Chính hãng', 2, 7),
(75, 'Màn hình LG 24MP60G-B 23.8inch/FHD/IPS/75Hz/1ms/ Đen', 3, 7),
(76, 'Màn hình AOC G2490VX/74 23.8 inch/FHD/VA/144Hz', 2, 7),
(77, 'Màn hình LG 27MP60G-B 27inch/FHD/IPS/75Hz/5ms/250nitsĐen', 3, 7),
(78, 'Màn hình LG 27MK600M-B 27 inch/FHD/ - Chính hãng', 2, 7),
(79, 'Màn hình LG 27GQ50F 27 inch/FHD/VA/165Hz Đen', 2, 7),
(80, 'Màn hình LG 27MP60G-B 27inch/FHD/IPS/75Hz/5ms/Đen', 2, 7),
(81, 'Tivi sony nét căng', 3, 6),
(82, 'TV Chromebook Flip CX5', 2, 6),
(83, 'Laptop acer 360 gaming', 1, 2),
(84, 'Ipad2712 Vip pro max', 2, 2),
(85, 'Asus gaming 1003 VN', 2, 2),
(86, 'Test Product Vip', 5, 3),
(87, 'Màn hình 360 gaming', 2, 7),
(88, 'New product vip pro', 3, 2),
(89, 'New product version 2', 2, 7),
(90, 'New product 11226', 1, 1),
(91, 'Máy tính bảng iPad Pro M2 11\" 5G (128GB) - Chính hãng Apple Việt Nam', 2, 3),
(92, 'Máy tính bảng Samsung Galaxy Tab S9 5G 8GB/128GB - Chính hãng', 1, 3),
(93, 'Máy tính bảng Samsung Galaxy Tab S9 FE Plus Wifi 8GB/128GB', 2, 3),
(94, 'Máy tính bảng iPad Gen 9 10.2\" Wi-Fi (256GB) - Chính hãng Apple Việt Nam', 2, 3),
(95, 'Máy tính bảng OPPO Pad Air (Màu tím) - 128GB - Chính hãng', 2, 3),
(96, 'Máy tính bảng iPad Gen 9 10.2\" Wi-Fi (256GB) - Chính hãng Apple Việt Nam', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_options`
--

CREATE TABLE `product_options` (
  `id` int(11) NOT NULL,
  `color` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `price_sale` float DEFAULT '0',
  `quantity` int(11) NOT NULL,
  `ram` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `product_options`
--

INSERT INTO `product_options` (`id`, `color`, `image`, `price`, `price_sale`, `quantity`, `ram`, `product_id`) VALUES
(4, 'black', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/03/24/redminote12-0.png', 12000000, 9000000, 2, 64, 2),
(5, 'blue', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/05/11/note12s.png', 23000000, 21000000, 5, 32, 3),
(6, 'black', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/10/11/tab-s9-fe-1.png', 27000000, 26500000, 6, 64, 3),
(7, 'green', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/02/27/thumb-xiaomi-13-lite.png', 32000000, 31000000, 3, 32, 4),
(8, 'blue', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/03/13/c55-1-den.png', 17000000, 0, 1, 16, 4),
(9, 'pink', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/01/11/image-removebg-preview-8.png', 22000000, 0, 2, 32, 5),
(10, 'black', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/12/05/s23-xang.png', 23000000, 22300000, 5, 16, 6),
(11, 'black', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/09/08/anh-chup-man-hinh-2022-09-08-luc-01-57-13-removebg-preview.png', 19000000, 18700000, 5, 32, 11),
(12, 'black', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/10/19/xueying-product-images-openback-gold-9-rgb-20230725-removebg-preview.png', 21000000, 19900000, 2, 16, 12),
(13, 'red', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/10/27/oppo-find-n3.png', 22000000, 21000000, 3, 32, 13),
(14, 'black', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/09/13/iphone-15-pro-blue-titanium-pure-back-iphone-15-pro-blue-titanium-pure-front-2up-screen-usen.png', 18000000, 17500000, 2, 16, 14),
(15, 'black', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/09/13/iphone-15-pro-natural-titanium-pure-back-iphone-15-pro-natural-titanium-pure-front-2up-screen-usen.png', 15690000, 15000000, 3, 16, 15),
(16, 'black', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2021/09/15/image-removebg-preview-28.png', 8999000, 7500000, 1, 2, 26),
(17, 'red', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2020/11/04/venu-sq.png', 6500000, 6000000, 1, 4, 27),
(18, 'blue', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/02/15/ks62w.png', 8000000, 7200000, 2, 4, 28),
(19, 'red', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2022/03/31/image-removebg-preview.png', 12000000, 11500000, 1, 2, 29),
(20, 'blue', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2020/11/04/venu-sq.png', 9000000, 8700000, 1, 2, 30),
(21, 'black', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2022/06/13/vong-deo-tay-thong-minh-huawei-band-7-chinh-hang-12.png', 8500000, 8100000, 1, 2, 31),
(22, 'Black', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/10/24/image-removebg-preview-33.png', 10000000, 9000000, 50, 8, 40),
(23, 'Silver', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/07/18/image-removebg-preview-1_637937326256886528.png', 12000000, 11000000, 30, 16, 41),
(24, 'Blue', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/12/22/image-removebg-preview.png', 8000000, 7500000, 40, 4, 42),
(25, 'Red', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/09/26/21dj00cwvn-1.png', 11000000, 10000000, 25, 8, 43),
(26, 'Green', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/10/14/image-removebg-preview-39.png', 9000000, 8000000, 35, 16, 44),
(27, 'Gold', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/12/22/image-removebg-preview.png', 13000000, 12000000, 20, 4, 45),
(28, 'Gray', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/03/06/14zd90q-g-ax32a5-1.png', 9500000, 9000000, 45, 12, 46),
(29, 'White', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/12/22/image-removebg-preview.png', 10500000, 9500000, 30, 8, 47),
(30, 'Purple', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/10/14/image-removebg-preview-39.png', 8000000, 7500000, 40, 16, 48),
(31, 'Orange', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/10/24/image-removebg-preview-33.png', 12000000, 11000000, 25, 4, 49),
(32, 'Yellow', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/03/06/14zd90q-g-ax32a5-1.png', 10000000, 9500000, 35, 8, 50),
(33, 'Pink', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/10/24/image-removebg-preview-33.png', 11000000, 10000000, 30, 16, 51),
(34, 'Brown', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/10/14/image-removebg-preview-39.png', 9000000, 8000000, 40, 12, 52),
(35, 'Cyan', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/03/06/14zd90q-g-ax32a5-1.png', 13000000, 12000000, 20, 8, 53),
(36, 'Magenta', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/03/06/14zd90q-g-ax32a5-1.png', 9500000, 9000000, 45, 16, 54),
(37, 'Teal', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/03/06/14zd90q-g-ax32a5-1.png', 10500000, 9500000, 30, 4, 55),
(38, 'Olive', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/10/24/image-removebg-preview-33.png', 8000000, 7500000, 40, 8, 56),
(39, 'Maroon', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/12/22/image-removebg-preview.png', 15000000, 14000000, 25, 16, 57),
(40, 'Navy', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/10/14/image-removebg-preview-39.png', 9000000, 8500000, 20, 8, 58),
(43, 'Navy', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/08/23/image-removebg-preview-16.png', 8000000, 75000000, 5, 1, 74),
(44, 'Orange', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/08/18/image-removebg-preview-7.png', 5500000, 0, 2, 1, 75),
(45, 'Orange', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/08/23/image-removebg-preview-20.png', 4900000, 0, 5, 1, 76),
(46, 'Whitehttps://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/08/18/image-removebg-preview-31.png', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/08/18/image-removebg-preview-31.png', 7500000, 5900000, 5, 1, 77),
(47, 'Red', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/08/23/image-removebg-preview-15.png', 8880000, 7950000, 5, 1, 78),
(48, 'Black', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/10/14/image-removebg-preview-39.png', 8000000, 75000000, 5, 1, 79),
(49, 'Maroon', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/08/23/image-removebg-preview-20.png', 7500000, 5900000, 5, 1, 80),
(50, 'Orange', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/08/23/image-removebg-preview-20.png', 7500000, 5900000, 5, 1, 81),
(51, 'Red', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/03/06/14zd90q-g-ax32a5-1.png', 9000000, 7500000, 25, 1, 82),
(52, 'red', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/06/28/nokia-c32-0.png', 9000000, 62352300, 5, 32, 2),
(53, 'red', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/06/28/nokia-c32-0.png', 9000000, 2, 5, 32, 2),
(55, 'red', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2023/11/06/thumb-trang.png', 10000000, 9000000, 5, 8, 2),
(56, 'red', 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2023/10/16/82tsa071vn-1.png', 15000000, 12000000, 1, 8, 89),
(58, 'red', 'https://cdn.hoanghamobile.com/i/productlist/ts/Uploads/2022/10/20/image-removebg-preview-28.png', 10000000, 9000000, 5, 16, 90),
(59, 'red', 'https://cdn.hoanghamobile.com/i/preview/Uploads/2022/10/24/image-removebg-preview_638022082728321716.png', 15000000, 1450000, 5, 8, 91),
(60, 'red', 'https://cdn.hoanghamobile.com/i/preview/Uploads/2023/07/26/samsung-galaxy-tab-s9-5g-13.png', 10000000, 9000000, 5, 16, 92),
(61, 'blue', 'https://cdn.hoanghamobile.com/i/preview/Uploads/2023/10/04/galaxy-tab-s9-fe-plus-gray-product-image-front.png', 12000000, 0, 5, 16, 93),
(62, 'blue', 'https://cdn.hoanghamobile.com/i/preview/Uploads/2021/09/15/image-removebg-preview-26.png', 20000000, 19500000, 5, 32, 94),
(63, 'black', 'https://cdn.hoanghamobile.com/i/preview/Uploads/2023/04/12/oppo-pad-air-tim-1.png', 22000000, 21500000, 5, 16, 95),
(64, 'red', 'https://cdn.hoanghamobile.com/i/preview/Uploads/2021/09/15/image-removebg-preview-27.png', 15000000, 14500000, 5, 16, 96);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shop_cart`
--

CREATE TABLE `shop_cart` (
  `id` int(11) NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `option_id` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `shop_cart`
--

INSERT INTO `shop_cart` (`id`, `account_id`, `option_id`, `total`) VALUES
(5, 2, 18, 2),
(8, 1, 7, 2),
(19, 2, 11, 2),
(20, 2, 5, 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_de34gsw4qt8auhffbna969ahp` (`username`),
  ADD UNIQUE KEY `UK_cs5bnaggwuluahrdh8mbs1rpe` (`email`);

--
-- Chỉ mục cho bảng `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_t8o6pivur7nn124jehx7cygw5` (`name`);

--
-- Chỉ mục cho bảng `love_product`
--
ALTER TABLE `love_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrlduoy3bro7gciwkffotsqrkt` (`account_id`),
  ADD KEY `FK9dfgar5cddxp3xrnyd9cv6rik` (`option_id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa3a4mpsfdf4d2y6r8ra3sc8mv` (`brand_id`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`);

--
-- Chỉ mục cho bảng `product_options`
--
ALTER TABLE `product_options`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8vv4f8fru80wxocwgxwsrow61` (`product_id`);

--
-- Chỉ mục cho bảng `shop_cart`
--
ALTER TABLE `shop_cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3flpg78x9ngio7twdvollyh3n` (`account_id`),
  ADD KEY `FKlhhxn6co0cy9cwac7j937yxnd` (`option_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `brands`
--
ALTER TABLE `brands`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `love_product`
--
ALTER TABLE `love_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT cho bảng `product_options`
--
ALTER TABLE `product_options`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT cho bảng `shop_cart`
--
ALTER TABLE `shop_cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `love_product`
--
ALTER TABLE `love_product`
  ADD CONSTRAINT `FK9dfgar5cddxp3xrnyd9cv6rik` FOREIGN KEY (`option_id`) REFERENCES `product_options` (`id`),
  ADD CONSTRAINT `FKrlduoy3bro7gciwkffotsqrkt` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKa3a4mpsfdf4d2y6r8ra3sc8mv` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`),
  ADD CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

--
-- Các ràng buộc cho bảng `product_options`
--
ALTER TABLE `product_options`
  ADD CONSTRAINT `FK8vv4f8fru80wxocwgxwsrow61` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Các ràng buộc cho bảng `shop_cart`
--
ALTER TABLE `shop_cart`
  ADD CONSTRAINT `FK3flpg78x9ngio7twdvollyh3n` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `FKlhhxn6co0cy9cwac7j937yxnd` FOREIGN KEY (`option_id`) REFERENCES `product_options` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
