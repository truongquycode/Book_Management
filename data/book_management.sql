-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2025 at 02:54 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `date` date NOT NULL,
  `update_date` date DEFAULT NULL,
  `fullname` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `typeBank` varchar(200) DEFAULT NULL,
  `numberBank` varchar(50) DEFAULT NULL,
  `status` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `email`, `username`, `password`, `date`, `update_date`, `fullname`, `phone`, `address`, `typeBank`, `numberBank`, `status`) VALUES
(5, 'admin@gmail.com', 'admin', '$2a$10$C245yI8VZzaH5.0xysbALe6bzU3W7sodx2ATcMTTdY2yZVH2qKWAO', '2025-02-21', '2025-03-23', '', '', '', '', '', 0),
(7, 'truongb2204976@student.ctu.edu.vn', 'truong3006', '$2a$10$Rb8w.RrBl9wwioxZ8QWPFezO6gu3fMsqNxAX2ubh5Pzg0/.1D2dI6', '2025-03-03', '2025-03-23', 'Nguyễn Lâm Trường', '0384382444', '123a, 3/2, Xã Phúc Lộc, Huyện Ba Bể, Tỉnh Bắc Kạn', 'MB Bank', '456388612', 0),
(8, 'thanh@gmail.com', 'thanh', '$2a$10$3e3LR3FxRD0oAZiB4YpGa.0KiyeDe5V5VkSs8W7zrSmjrAo7asDsm', '2025-03-23', NULL, 'Ngô Hữu Thành', '', '178/a, Mậu Thân, Phường Bùi Hữu Nghĩa, Quận Bình Thuỷ, Thành phố Cần Thơ', '', '', 0),
(9, 'tquy27764@gmail.com', 'quy', '$2a$10$4RtbADefSYk7kjtWQoxUReDR.zUCZgQekfV.W7Mr5ypqsy3kUE2E.', '2025-03-27', '2025-04-01', 'Trương Văn Quy', '0387117871', '123a, Ấp 5, Thị trấn Gành Hào, Huyện Đông Hải, Tỉnh Bạc Liêu', 'Vietcombank', '1032762243', 0),
(10, 'trieub2204975@student.ctu.edu.vn', 'trieu', '$2a$10$cgpcopQL2mFITd3zqYVHl.RTQdliSec0RZ3o5j3Tpv.c6AHZwIwZi', '2025-03-29', NULL, 'Phạm Thành Quốc Triệu', NULL, NULL, NULL, NULL, 0),
(11, 'thienb2204968@student.ctu.edu.vn', 'thien', '$2a$10$942Nc2YKMP1Wa4sRTwnQLuren9f2wOY4Ec2lnPPcvL7tei3uzcgKm', '2025-03-30', '2025-03-30', 'Phạm Lương Bảo Thiện', NULL, NULL, NULL, NULL, 0),
(12, 'lamtruongnguyen2004@gmail.com', 'truongnguyen', '$2a$10$x.fvg7rvzdsDDwzrw6iyNehM0/HWVpvZpwzvzp1liwcSX4B/ntiUm', '2025-04-01', '2025-04-08', 'Lâm Trường Nguyễn', NULL, NULL, NULL, NULL, 0),
(13, 'quy5704quy@gmail.com', 'quyquy', '$2a$10$uaOserLjiI0NtuVuwIniBuZqosmI2k7M6TCcJR505HcHyM1fTw5ti', '2025-04-04', '2025-04-04', 'Quy Trương', NULL, NULL, NULL, NULL, 0),
(14, 'quyb2204965@student.ctu.edu.vn', 'qui', '$2a$10$/zfZAX0HTkUs4mkeCbAEtuyQHzQPMmDNKuSzNkHnAynD2rEW9BWyy', '2025-04-05', NULL, 'Trương Văn Quy', '0387117871', '124f, Trần hoàn na, Xã Phú Lũng, Huyện Yên Minh, Tỉnh Hà Giang', 'Vietcombank', '1032762243', 0);

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id_auto` int(11) NOT NULL,
  `id` varchar(11) NOT NULL,
  `image` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `author` varchar(100) NOT NULL,
  `genre` varchar(1000) NOT NULL,
  `price` double NOT NULL,
  `pub_year` int(11) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `des` varchar(5000) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ebookLink` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id_auto`, `id`, `image`, `name`, `author`, `genre`, `price`, `pub_year`, `stock`, `des`, `status`, `created_at`, `updated_at`, `ebookLink`) VALUES
(26, 'mha-01', '/images/mha/my-hero-academy-01.jpg', 'MY HERO ACADEMIA 01', 'Kohei Horikoshi', 'Hành động, Phiêu lưu, Hài hước, Học đường, Siêu nhiên', 126000, 2018, 96, 'Trong một thế giới mà 80% mọi người đều có một năng lực đặc biệt (siêu năng lực), tất cả những gì Izuko Midoriya từng muốn là trở thành một anh hùng. Nhưng cậu ấy không có năng lực đặc biệt. Chưa. My Hero Academia là một câu chuyện siêu anh hùng mới mẻ và độc đáo với những cung bậc nhân vật vô song.\n\nMidoriya thừa hưởng siêu năng lực của người anh hùng vĩ đại nhất thế giới, nhưng sự vĩ đại sẽ không đến dễ dàng.\n\nThế giới sẽ ra sao nếu 80 phần trăm dân số biểu hiện siêu năng lực được gọi là \"Quirks\"? Anh hùng và kẻ phản diện sẽ chiến đấu ở khắp mọi nơi! Trở thành anh hùng có nghĩa là phải học cách sử dụng sức mạnh của bạn, nhưng bạn sẽ học ở đâu? Tất nhiên là Học viện anh hùng! Nhưng bạn sẽ làm gì nếu bạn là một trong 20 phần trăm người sinh ra đã không có năng lực?\n\nHọc sinh trung học Izuku Midoriya muốn trở thành một anh hùng hơn bất cứ điều gì, nhưng cậu không có một chút sức mạnh nào trong mình. Không có cơ hội nào để vào Trường trung học UA danh giá dành cho những anh hùng mới chớm nở, cuộc sống của cậu ngày càng giống một ngõ cụt. Sau đó, một cuộc gặp gỡ với All Might, người anh hùng vĩ đại nhất trong số họ, đã cho cậu cơ hội thay đổi số phận của mình...', 1, '2025-03-21 03:23:59', '2025-04-07 01:06:53', 'https://drive.google.com/file/d/15pzDo-eh4VPk1I3EfK2vCe4dJIZGFzqH'),
(27, 'mha-02', '/images/mha/my-hero-academy-02.jpg', 'MY HERO ACADEMIA 02', 'Kohei Horikoshi', 'Hành động, Phiêu lưu, Hài hước, Học đường, Siêu nhiên', 98000, 2018, 94, 'Midoriya còn lâu mới có thể kiểm soát được năng lực mới của mình, nhưng giờ cậu phải cạnh tranh để giữ được vị trí của mình tại trường trung học UA. Sự căng thẳng đang ở mức quá tải.\n\nMidoriya thừa hưởng siêu năng lực của người anh hùng vĩ đại nhất thế giới, nhưng sự vĩ đại sẽ không đến dễ dàng.\n\nThế giới sẽ như thế nào nếu 80 phần trăm dân số biểu hiện siêu năng lực được gọi là \"Quirks\"? Anh hùng và kẻ phản diện sẽ chiến đấu ở khắp mọi nơi! Trở thành anh hùng có nghĩa là phải học cách sử dụng sức mạnh của bạn, nhưng bạn sẽ học ở đâu? Tất nhiên là Học viện Anh hùng! Nhưng bạn sẽ làm gì nếu bạn là một trong 20 phần trăm người sinh ra đã không có năng lực?\n\nVào được Trường trung học UA đã đủ khó khăn, nhưng đó chỉ là khởi đầu cho con đường dài của Midoriya để trở thành một siêu anh hùng. Tất cả những học sinh mới đều có sức mạnh đáng kinh ngạc, và mặc dù Midoriya đã thừa hưởng khả năng của All Might, cậu bé hầu như không thể kiểm soát chúng. Hơn nữa, những học sinh năm nhất được thông báo rằng họ sẽ phải cạnh tranh chỉ để tránh bị đuổi học!', 1, '2025-03-21 03:23:59', '2025-04-07 01:06:36', 'https://drive.google.com/file/d/15ZPkMZvJg2pxsLqCs9hi5REAc6hVGOB4'),
(28, 'mha-03', '/images/mha/my-hero-academy-03.jpg', 'MY HERO ACADEMIA 03', 'Kohei Horikoshi', 'Hành động, Phiêu lưu, Hài hước, Học đường, Siêu nhiên', 110000, 2018, 97, 'Khi Shigaraki nguy hiểm xuất hiện với mục đích ngăn chặn All Might một lần và mãi mãi, các sinh viên UA phải tập hợp lại để ngăn chặn thế lực phản diện đang xâm lược này mạnh mẽ hơn bất kỳ ai mong đợi.\n\nMidoriya thừa hưởng siêu năng lực của người anh hùng vĩ đại nhất thế giới, nhưng sự vĩ đại sẽ không đến dễ dàng.\n\nThế giới sẽ ra sao nếu 80 phần trăm dân số biểu hiện siêu năng lực được gọi là \"Quirks\"? Anh hùng và kẻ xấu sẽ chiến đấu ở khắp mọi nơi! Trở thành anh hùng có nghĩa là phải học cách sử dụng sức mạnh của bạn, nhưng bạn sẽ đi học ở đâu? Tất nhiên là Học viện Anh hùng! Nhưng bạn sẽ làm gì nếu bạn là một trong 20 phần trăm những người sinh ra đã không có năng lực?\n\nMột nhóm kẻ xấu nham hiểm đã tấn công những học sinh năm nhất của UA, nhưng mục tiêu thực sự của chúng là All Might. Midoriya và các bạn cùng lớp chỉ có thể làm mọi cách để ngăn chặn chúng cho đến khi quân tiếp viện đến. All Might tham gia trận chiến để bảo vệ bọn trẻ, nhưng khi sức mạnh của anh cạn kiệt, anh có thể bị buộc phải thực hiện một trò lừa bịp cực kỳ nguy hiểm!', 1, '2025-03-21 03:23:59', '2025-04-01 08:18:47', ''),
(29, 'mha-04', '/images/mha/my-hero-academy-04.jpg', 'MY HERO ACADEMIA 04', 'Kohei Horikoshi', 'Hành động, Phiêu lưu, Hài hước, Học đường, Siêu nhiên', 96000, 2018, 100, 'Với sự theo dõi của hầu hết mọi người và các anh hùng chuyên nghiệp đang tìm kiếm học trò, các sinh viên UA đang thể hiện tài năng của mình trong một giải đấu kinh điển và hy vọng nó sẽ ấn tượng như họ nghĩ.\n\nMidoriya thừa hưởng siêu năng lực của người anh hùng vĩ đại nhất thế giới, nhưng sự vĩ đại sẽ không đến dễ dàng.\n\nThế giới sẽ như thế nào nếu 80 phần trăm dân số biểu hiện siêu năng lực được gọi là \"Quirks\"? Anh hùng và kẻ phản diện sẽ chiến đấu ở khắp mọi nơi! Trở thành anh hùng có nghĩa là phải học cách sử dụng sức mạnh của bạn, nhưng bạn sẽ học ở đâu? Tất nhiên là Học viện Anh hùng! Nhưng bạn sẽ làm gì nếu bạn là một trong 20 phần trăm những người sinh ra đã không có năng lực?\n\nLễ hội thể thao của trường trung học UA là cơ hội để những anh hùng mới chớm nở thể hiện khả năng của mình và tìm kiếm một người cố vấn siêu anh hùng. Các học sinh đã phải vật lộn qua vòng loại khắc nghiệt, nhưng giờ đây họ phải hợp tác để chứng minh rằng họ có khả năng tiến vào giai đoạn tiếp theo. Cả đất nước đang theo dõi, và cả những thế lực đen tối đã tấn công học viện nữa...', 1, '2025-03-21 03:23:59', '2025-04-01 08:18:58', ''),
(30, 'mha-05', '/images/mha/my-hero-academy-05.jpg', 'MY HERO ACADEMIA 05', 'Kohei Horikoshi', 'Hành động, Phiêu lưu, Hài hước, Học đường, Siêu nhiên', 99999, 2018, 95, 'Trận chiến nối tiếp trận chiến, đây là một cuộc đấu tay đôi thường xuyên khi lễ hội thể thao diễn ra. Liệu Bakugo có nổi giận với Ururaka hay cái đầu lạnh của cô sẽ chiến thắng?\n\nMidoriya thừa hưởng siêu năng lực của người anh hùng vĩ đại nhất thế giới, nhưng sự vĩ đại sẽ không đến dễ dàng.\n\nThế giới sẽ như thế nào nếu 80 phần trăm dân số biểu hiện siêu năng lực được gọi là \"Quirks\"? Anh hùng và kẻ phản diện sẽ chiến đấu ở khắp mọi nơi! Trở thành anh hùng có nghĩa là phải học cách sử dụng sức mạnh của bạn, nhưng bạn sẽ học ở đâu? Tất nhiên là Học viện Anh hùng! Nhưng bạn sẽ làm gì nếu bạn là một trong 20 phần trăm người sinh ra đã không có năng lực?\n\nCác giai đoạn cuối cùng của lễ hội thể thao trường trung học UA hứa hẹn sẽ bùng nổ, khi Uraraka đấu với Bakugo trong một trận đấu trực diện! Bakugo không bao giờ cho bất kỳ ai nghỉ ngơi, và đám đông nín thở khi trận chiến bắt đầu. Trận chung kết sẽ thúc đẩy các học sinh Lớp 1-A đến giới hạn của họ và hơn thế nữa!', 1, '2025-03-21 03:23:59', '2025-04-10 03:25:02', ''),
(31, 'op-01', '/images/op/one-piece-1.jpg', 'ONE PIECE 01', 'Oda Eiichiro', 'Hành động, Phiêu lưu, Hài hước, Shounen', 180000, 2014, 100, 'Bắt đầu câu chuyện lan man mà bạn nên bắt đầu khi Monkey D. Luffy — luôn lạc quan, luôn mỉm cười — bắt đầu cuộc hành trình vĩ đại của mình. Không có thủy thủ đoàn (chưa), không có tàu (chưa), chỉ có thái độ có thể làm được và một chiếc mũ rơm.\n\nHãy tham gia cùng Monkey D. Luffy và đoàn thủy thủ của anh trong hành trình tìm kiếm kho báu cuối cùng, One Piece!\n\nKhi còn nhỏ, Monkey D. Luffy đã mơ ước trở thành Vua hải tặc. Nhưng cuộc đời anh đã thay đổi khi anh vô tình có được sức mạnh co giãn như cao su... nhưng phải trả giá bằng việc không bao giờ có thể bơi được nữa! Nhiều năm sau, Luffy lên đường tìm kiếm \"One Piece\", được cho là kho báu vĩ đại nhất thế giới...\n\nKhi còn nhỏ, Monkey D. Luffy đã được truyền cảm hứng để trở thành cướp biển khi nghe những câu chuyện về tên cướp biển \"Tóc đỏ\" Shanks. Nhưng cuộc đời anh đã thay đổi khi Luffy vô tình ăn Trái ác quỷ Gum-Gum và có được sức mạnh co giãn như cao su... nhưng phải trả giá bằng việc không bao giờ có thể bơi được nữa! Nhiều năm sau, vẫn thề sẽ trở thành vua hải tặc, Luffy lên đường phiêu lưu... một mình trên thuyền chèo, tìm kiếm \"One Piece\" huyền thoại, được cho là kho báu vĩ đại nhất thế giới...', 1, '2025-03-21 03:23:59', '2025-04-01 13:25:40', ''),
(32, 'op-02', '/images/op/one-piece-2.jpg', 'ONE PIECE 02', 'Oda Eiichiro', 'Hành động, Phiêu lưu, Hài hước, Shounen', 180000, 2014, 98, 'Màn mở đầu của Buggy the Clown và Hoa tiêu Nami. Luffy phải phân biệt bạn bè với kẻ thù và tự mình tạo dựng thành công lâu dài.\n\nHãy tham gia cùng Monkey D. Luffy và đoàn thủy thủ của anh trong hành trình tìm kiếm kho báu cuối cùng, One Piece!\n\nKhi còn nhỏ, Monkey D. Luffy mơ ước trở thành Vua hải tặc. Nhưng cuộc đời anh đã thay đổi khi anh vô tình có được sức mạnh co giãn như cao su... nhưng phải trả giá bằng việc không bao giờ có thể bơi được nữa! Nhiều năm sau, Luffy lên đường tìm kiếm \"One Piece\", được cho là kho báu vĩ đại nhất thế giới...\n\nKhi còn nhỏ, Monkey D. Luffy đã thề sẽ trở thành Vua hải tặc và tìm ra kho báu huyền thoại có tên là \"One Piece\". Quả Gum-Gum Fruit đã ban cho Luffy sức mạnh co giãn như cao su—và người đồng đội mới của anh, thợ săn cướp biển khét tiếng Roronoa Zolo, đã gieo rắc nỗi sợ hãi vào trái tim của những tên cướp biển khác! Nhưng một anh chàng cao su có cơ hội nào để chống lại Nami, một tên trộm cứng rắn đến mức cô chuyên cướp của cướp biển... hay thuyền trưởng Buggy, một tên cướp biển hung dữ có vẻ ngoài kỳ lạ, hề hước che giấu sức mạnh thậm chí còn kỳ lạ hơn? Đó là cuộc chiến cướp biển đấu với cướp biển trong tập thứ hai của One Piece !', 1, '2025-03-21 03:23:59', '2025-04-01 08:19:23', ''),
(33, 'op-03', '/images/op/one-piece-3.jpg', 'ONE PIECE 03', 'Oda Eiichiro', 'Hành động, Phiêu lưu, Hài hước, Shounen', 180000, 2014, 99, 'Hãy tham gia cùng Monkey D. Luffy và đoàn thủy thủ của anh trong hành trình tìm kiếm kho báu cuối cùng, One Piece!\n\nKhi còn nhỏ, Monkey D. Luffy đã mơ ước trở thành Vua hải tặc. Nhưng cuộc đời anh đã thay đổi khi anh vô tình có được sức mạnh co giãn như cao su... nhưng phải trả giá bằng việc không bao giờ có thể bơi được nữa! Nhiều năm sau, Luffy lên đường tìm kiếm \"One Piece\", được cho là kho báu vĩ đại nhất thế giới...\n\nChắc chắn, rất nhiều người nói rằng họ muốn trở thành Vua hải tặc, nhưng có bao nhiêu người có đủ can đảm để làm những gì cần thiết? Khi Monkey D. Luffy lần đầu tiên ra khơi trên một chiếc thuyền chèo thủng, anh không biết điều gì có thể nằm ở phía chân trời. Bây giờ anh có một đoàn thủy thủ—một kiểu—dưới dạng kiếm sĩ Roronoa Zolo và tên trộm săn kho báu Nami. Nếu muốn chứng tỏ bản thân trên biển cả, Luffy sẽ phải đánh bại tên cướp biển kỳ lạ Buggy the Clown. Anh sẽ phải tìm một bản đồ đến Grand Line, tuyến đường biển mà những tên cướp biển cứng rắn nhất đi qua. Và anh ta sẽ phải đối mặt với tên thuyền trưởng đáng sợ Usopp, kẻ tự nhận mình là thuyền trưởng cướp biển khét tiếng... nhưng thành thật mà nói, Usopp nói rất nhi', 1, '2025-03-21 03:23:59', '2025-04-01 13:08:25', ''),
(34, 'op-04', '/images/op/one-piece-4.jpg', 'ONE PIECE 04', 'Oda Eiichiro', 'Hành động, Phiêu lưu, Hài hước, Shounen', 180000, 2014, 96, 'Hãy tham gia cùng Monkey D. Luffy và đoàn thủy thủ của anh trong hành trình tìm kiếm kho báu cuối cùng, One Piece!\n\nKhi còn nhỏ, Monkey D. Luffy đã mơ ước trở thành Vua hải tặc. Nhưng cuộc đời anh đã thay đổi khi anh vô tình có được sức mạnh co giãn như cao su... nhưng phải trả giá bằng việc không bao giờ có thể bơi được nữa! Nhiều năm sau, Luffy lên đường tìm kiếm \"One Piece\", được cho là kho báu vĩ đại nhất trên thế giới...\n\nThuyền trưởng Kuro của băng hải tặc Black Cat là thiên tài độc ác đáng sợ nhất trên biển cả... cho đến khi anh biến mất. Hầu hết mọi người đều tin rằng anh đã chết, nhưng chỉ có thủy thủ đoàn của anh biết sự thật: Thuyền trưởng Kuro đã ẩn náu trong một ngôi làng nhỏ ven biển, giả làm một quản gia hiền lành cho đến khi thời điểm cướp bóc đến. Bây giờ thời điểm đó đã đến, và băng hải tặc Black Cat tàn nhẫn sắp tấn công...\n\nTất nhiên là trừ khi Monkey D. Luffy có thể ngăn chặn chúng! Tất cả những gì Luffy có bên mình là người bạn đồng hành cầm kiếm của mình, Zolo; hoa tiêu trộm cắp của anh, Nami; Usopp, một đứa trẻ địa phương có tài nói dối; và sức mạnh kỳ lạ của chính mình. Nếu bốn tên cướp biển nghiệp dư này muốn ngăn chặn toàn bộ băng Black Cat, chúng sẽ phải nghĩ ra một kế hoạch khá khéo léo...', 1, '2025-03-21 03:23:59', '2025-04-10 03:25:02', ''),
(35, 'op-05', '/images/op/one-piece-5.jpg', 'ONE PIECE 05', 'Oda Eiichiro', 'Hành động, Phiêu lưu, Hài hước, Shounen', 180000, 2014, 98, 'Hãy cùng Monkey D. Luffy và đoàn thủy thủ của anh trong hành trình tìm kiếm kho báu cuối cùng, One Piece!\n\nKhi còn nhỏ, Monkey D. Luffy đã mơ ước trở thành Vua hải tặc. Nhưng cuộc đời anh đã thay đổi khi vô tình có được sức mạnh co giãn như cao su... nhưng đổi lại là không bao giờ có thể bơi được nữa! Nhiều năm sau, Luffy lên đường tìm kiếm \"One Piece\", được cho là kho báu vĩ đại nhất thế giới...\n\nNgày xửa ngày xưa, Usopp chỉ là một cậu bé địa phương có tài kể chuyện cổ tích. Mọi người trong ngôi làng nhỏ ven biển của anh đều biết anh là một gã hề tự nhận mình là thuyền trưởng cướp biển và đánh thức mọi người vào buổi sáng bằng cách hét lên \"Cướp biển đang đến!\" Nhưng rồi những tên cướp biển thực sự đã đổ bộ lên bãi biển...\n\nGiờ đây, ngôi làng của Usopp đang bị tấn công bởi băng hải tặc Black Cat, một trong những băng hải tặc huyền thoại và đáng sợ nhất trên biển cả. Và ba tên cướp biển trẻ tuổi đã cùng anh bảo vệ ngôi làng: Nami - tên trộm, Zolo - kiếm sĩ và Luffy - tên cướp biển mũ rơm muốn trở thành với sức mạnh cao su đáng kinh ngạc. Usopp sắp khám phá ra cách một tên cướp biển tưởng tượng chống lại thực tế... và ý nghĩa của việc trở thành một tên cướp biển thực sự. Hàng xóm của anh sẽ không bao giờ tin điều đó t', 1, '2025-03-21 03:23:59', '2025-04-01 13:08:49', ''),
(36, 'slf-01', '/images/slf/shangri-la-frontier-1.jpg', 'SHANGRI-LA FRONTIER 01', 'Ryosuke Fuji,Katarina', 'Hành động, Phiêu lưu, Hài hước, Game, Fantasy', 170000, 2018, 97, 'Một cuộc phiêu lưu nhanh và bất kính dành cho những người hâm mộ isekai và RPG! Học sinh trung học Rakuro thích săn lùng \"trò chơi rác\", nhưng một ngày nọ, cậu quyết định chơi một trò chơi VR AAA có tên là Shangri-La Frontier . Cậu tạo ra một nhân vật có đầu chim, bỏ qua các đoạn cắt cảnh và nhảy ngay vào trò chơi—nhưng những gì đang chờ đợi cậu trong trò chơi này khác với bất kỳ điều gì cậu từng đối mặt...\n\nĐẦU CHIM ĐÃ THAM GIA TRÒ CHƠI\n\nHọc sinh trung học năm thứ hai Rakuro Hizutome không thích gì hơn là tìm ra cái gọi là \"trò chơi rác\" và đánh bại chúng. Khi cậu quyết định thay đổi mọi thứ bằng cách chơi một trò chơi VR mới, \"cấp độ thần thánh\" có tên là Shangri-La Frontier (hay còn gọi là SLF ), cậu làm những gì mình làm tốt nhất: tối thiểu hóa, bỏ qua phần mở đầu và nhảy thẳng vào hành động! Rakuro có thể là một game thủ kỳ cựu, nhưng một cuộc gặp gỡ với một đối thủ cũ sẽ thay đổi số phận của mọi người chơi SLF mãi mãi.\n\nChỉ mặc quần short và mặt nạ chim, Rakuro (tên người chơi: Sunraku) lao vào thế giới SLF . Mọi thứ diễn ra tốt đẹp lúc đầu khi anh hạ gục một con yêu tinh, một con thỏ và thậm chí là một con trăn. Nhưng sau đó Sunraku phải đối mặt với một con sói khổng lồ, hung dữ được gọi là Lycagon the Nightslayer. Liệu những năm tháng kinh nghiệm \"trò chơi rác\" của Sunraku có đủ không, hay anh sắp phải chịu một sự thức tỉnh thô bạo chỉ sau vài giờ phiêu lưu SLF ?', 1, '2025-03-21 03:23:59', '2025-04-04 14:52:54', ''),
(37, 'slf-02', '/images/slf/shangri-la-frontier-2.jpg', 'SHANGRI-LA FRONTIER 02', 'Ryosuke Fuji,Katarina', 'Hành động, Phiêu lưu, Hài hước, Game, Fantasy', 170000, 2018, 100, 'Một cuộc phiêu lưu nhanh và bất kính dành cho những người hâm mộ isekai và RPG! Cậu học sinh trung học Rakuro thích săn lùng \"trò chơi rác\", nhưng một ngày nọ, cậu quyết định chơi một trò chơi VR AAA có tên là Shangri-La Frontier . Cậu tạo ra một nhân vật có đầu chim, bỏ qua các đoạn cắt cảnh và nhảy ngay vào trò chơi—nhưng những gì đang chờ đợi cậu trong trò chơi này khác với bất kỳ thứ gì cậu từng đối mặt...\n\nKẺ THÙ MỚI, BẠN CŨ\n\nSau khi đắm chìm vào trò chơi VR bậc thầy Shangri-La Frontier, Sunraku (hay còn gọi là Rakuro Hizutome) phải chịu thất bại thảm hại trước quái vật độc nhất Lycagon the Nightslayer. Sunraku thoát khỏi cuộc chạm trán với một dấu ấn ngăn cản cậu trang bị bất cứ thứ gì trên chân hoặc thân mình. Nhưng đừng loại trừ cậu ngay! Cùng với Emul, chú thỏ vorpal hòa đồng, cậu tiếp tục trên con đường sẽ đưa cậu đối mặt với những kẻ thù mới đáng sợ, thậm chí là một số cái tên quen thuộc trong thế giới trò chơi.', 1, '2025-03-21 03:23:59', '2025-04-01 13:21:34', ''),
(38, 'slf-03', '/images/slf/shangri-la-frontier-3.jpg', 'SHANGRI-LA FRONTIER 03', 'Ryosuke Fuji,Katarina', 'Hành động, Phiêu lưu, Hài hước, Game, Fantasy', 170000, 2018, 100, 'Một cuộc phiêu lưu nhanh và bất kính dành cho những người hâm mộ isekai và RPG! Cậu học sinh trung học Rakuro thích săn lùng \"trò chơi rác\", nhưng một ngày nọ, cậu quyết định chơi một trò chơi VR AAA có tên là Shangri-La Frontier . Cậu tạo ra một nhân vật có đầu chim, bỏ qua các đoạn cắt cảnh và nhảy ngay vào trò chơi—nhưng những gì đang chờ đợi cậu trong trò chơi này khác với bất kỳ điều gì cậu từng đối mặt...\n\nLỜI ĐỀ XUẤT CỦA PENCILGON\n\nSau khi sống sót sau một cuộc tấn công dữ dội của một trong những gia tộc PK của Shangri-La Frontier, Sunraku bước vào võ đài chiến đấu với mười con quái vật mạnh mẽ như một phần của một kịch bản độc đáo. Cậu suýt nữa thì mất mạng, chỉ để rồi nhận được lời mời từ người bạn chơi game Pencilgon để giúp cô ấy hạ gục một con quái vật độc đáo được gọi là Wethermon the Tombguard. Với Wethermon vẫn chưa bị đánh bại bởi bất kỳ ai trong số 30 triệu người chơi của trò chơi, Sunraku có thể đã cắn nhiều hơn những gì anh ta có thể nhai!', 1, '2025-03-21 03:23:59', '2025-04-01 08:20:09', ''),
(39, 'slf-04', '/images/slf/shangri-la-frontier-4.jpg', 'SHANGRI-LA FRONTIER 04', 'Ryosuke Fuji,Katarina', 'Hành động, Phiêu lưu, Hài hước, Game, Fantasy', 170000, 2018, 100, 'Một cuộc phiêu lưu nhanh và bất kính dành cho những người hâm mộ isekai và RPG! Cậu học sinh trung học Rakuro thích săn lùng \"trò chơi rác\", nhưng một ngày nọ, cậu quyết định chơi một trò chơi VR AAA có tên là Shangri-La Frontier . Cậu tạo ra một nhân vật có đầu chim, bỏ qua các đoạn cắt cảnh và nhảy ngay vào trò chơi—nhưng những gì đang chờ đợi cậu trong trò chơi này khác với bất kỳ điều gì cậu từng đối mặt...\n\nWETHERMON THE TOMBGUARD\n\nVừa mới cày cấp sau nhiều giờ, Sunraku bắt đầu một nhiệm vụ với những người chơi khác là Pencilgon và OiKatzo để đánh bại Wethermon the Tombguard, một trong Bảy Người Khổng Lồ hùng mạnh. Pencilgon giới thiệu họ với một NPC được gọi là Setsuna of Bygone Days, người cầu xin họ đưa linh hồn của Wethermon về nơi an nghỉ. Mặc dù ba người bạn thề sẽ thực hiện mong muốn của Setsuna, nhưng kiếm sĩ bất tử sẽ chứng tỏ mình đáng sợ hơn những gì họ có thể tưởng tượng.', 1, '2025-03-21 03:23:59', '2025-04-01 13:26:02', ''),
(40, 'slf-05', '/images/slf/shangri-la-frontier-5.jpg', 'SHANGRI-LA FRONTIER 05', 'Ryosuke Fuji,Katarina', 'Hành động, Phiêu lưu, Hài hước, Game, Fantasy', 170000, 2018, 96, 'Một cuộc phiêu lưu nhanh và bất kính dành cho những người hâm mộ isekai và RPG! Cậu học sinh trung học Rakuro thích săn lùng \"trò chơi rác\", nhưng một ngày nọ, cậu quyết định chơi một trò chơi VR AAA có tên là Shangri-La Frontier . Cậu tạo ra một nhân vật có đầu chim, bỏ qua các đoạn cắt cảnh và nhảy ngay vào trò chơi—nhưng những gì đang chờ đợi cậu trong trò chơi này khác với bất kỳ điều gì cậu từng đối mặt...\n\nSỨC MẠNH KHÔNG THỂ NGĂN CẢN ĐỐI VỚI VẬT THỂ KHÔNG THỂ\n\nPHÁ VỠ Cuộc chiến chống lại Wethermon là một trận chiến tiêu hao tàn khốc. Bước vào giai đoạn cuối của trận đấu trùm, đội của Pencilgon bị đánh tơi tả, nhưng không bị phá vỡ. Trong khi Sunraku đấu một chọi một với Wethermon, Pencilgon và OiKatzo hợp tác chống lại chiến mã máy của Wethermon. Hầu hết các vật phẩm của Pencilgon đã cạn kiệt nên hành động thận trọng sẽ là chơi an toàn và cố gắng sống sót trong giai đoạn mười phút theo lý thuyết. Tuy nhiên, Sunraku được xây dựng khác biệt và quyết định thách thức Wethermon trực diện!', 1, '2025-03-21 03:23:59', '2025-04-05 10:07:34', ''),
(41, 'dms-01', '/images/kny/kny01.jpg', 'DEMON SLAYER 01', 'Koyoharu Gotouge', 'Hành động, Phiêu lưu, Hài hước, Kinh dị, Fantasy', 150000, 2017, 99, 'Cuộc sống của Tanjio trở nên tồi tệ hơn khi một con quỷ giết chết toàn bộ gia đình cậu. Ngoại trừ chị gái cậu, người đã trở thành một con quỷ. Demon Slayer là một câu chuyện độc đáo tuyệt vời tận dụng tối đa phương tiện manga với cùng những nhân vật độc đáo và những rủi ro không ngừng mà bạn yêu thích, và nhiều hơn thế nữa.\n\nTanjiro lên đường trở thành Sát Quỷ Nhân để cứu em gái và trả thù cho gia đình!\n\nỞ Nhật Bản thời Taisho, Tanjiro Kamado tốt bụng kiếm sống bằng nghề bán than củi. Nhưng cuộc sống yên bình của cậu đã tan vỡ khi một con quỷ tàn sát toàn bộ gia đình cậu. Em gái Nezuko của cậu là người duy nhất sống sót, nhưng bản thân cô bé đã bị biến thành quỷ! Tanjiro lên đường thực hiện một hành trình nguy hiểm để tìm cách đưa em gái mình trở lại bình thường và tiêu diệt con quỷ đã hủy hoại cuộc đời cậu.\n\nHọc cách tiêu diệt quỷ dữ sẽ không dễ dàng, và Tanjiro hầu như không biết phải bắt đầu từ đâu. Sự xuất hiện bất ngờ của một cậu bé khác tên là Giyuu, người dường như biết chuyện gì đang xảy ra, có thể cung cấp một số câu trả lời—nhưng chỉ khi Tanjiro có thể ngăn Giyuu giết em gái mình trước!', 1, '2025-03-21 03:23:59', '2025-04-01 09:58:10', ''),
(42, 'dms-02', '/images/kny/kny02.jpg', 'DEMON SLAYER 02', 'Koyoharu Gotouge', 'Hành động, Phiêu lưu, Hài hước, Kinh dị, Fantasy', 150000, 2017, 98, 'Số phận của Tanjiro đưa cậu vượt qua vòng tuyển chọn và đến với nhiệm vụ đầu tiên với tư cách là thành viên chính thức của Quân đoàn diệt quỷ. Cố lên Tanjiro!\n\nTanjiro lên đường trở thành Sát Quỷ Nhân để cứu em gái và trả thù cho gia đình!\n\nỞ Nhật Bản thời Taisho, Tanjiro Kamado tốt bụng kiếm sống bằng nghề bán than củi. Nhưng cuộc sống yên bình của cậu đã tan vỡ khi một con quỷ tàn sát toàn bộ gia đình cậu. Em gái Nezuko của cậu là người duy nhất sống sót, nhưng chính cô bé đã bị biến thành một con quỷ! Tanjiro lên đường thực hiện một hành trình nguy hiểm để tìm cách đưa em gái mình trở lại bình thường và tiêu diệt con quỷ đã hủy hoại cuộc đời cậu.\n\nTrong đợt tuyển chọn cuối cùng cho Quân đoàn Sát Quỷ Nhân, Tanjiro phải đối mặt với một con quỷ bị biến dạng và sử dụng các kỹ thuật do sư phụ của mình, Urokodaki, truyền dạy! Khi Tanjiro bắt đầu bước đi trên con đường Sát Quỷ Nhân, cuộc tìm kiếm con quỷ đã giết hại gia đình mình đã dẫn cậu đến việc điều tra vụ mất tích của những cô gái trẻ ở một thị trấn gần đó.', 1, '2025-03-21 03:23:59', '2025-04-02 12:49:16', ''),
(43, 'dms-03', '/images/kny/kny03.jpg', 'DEMON SLAYER 03', 'Koyoharu Gotouge', 'Hành động, Phiêu lưu, Hài hước, Kinh dị, Fantasy', 150000, 2017, 99, 'Tanjiro phải đối mặt với hai con quỷ mới có khả năng thử thách giới hạn của cậu, nhưng chắc chắn — chắc chắn! — cậu sẽ chiến thắng cùng người chị gái thân yêu của mình.\n\nTanjiro lên đường trở thành Sát Quỷ Nhân để cứu em gái và trả thù cho gia đình!\n\nỞ Nhật Bản thời Taisho, Tanjiro Kamado tốt bụng kiếm sống bằng nghề bán than củi. Nhưng cuộc sống yên bình của cậu đã tan vỡ khi một con quỷ tàn sát toàn bộ gia đình cậu. Em gái Nezuko của cậu là người duy nhất sống sót, nhưng bản thân cô bé đã bị biến thành quỷ! Tanjiro lên đường thực hiện một hành trình nguy hiểm để tìm cách đưa em gái mình trở lại bình thường và tiêu diệt con quỷ đã hủy hoại cuộc đời cậu.\n\nTanjiro và Nezuko chạm trán với hai con quỷ mạnh mẽ chiến đấu bằng vũ khí ma thuật. Ngay cả sự giúp đỡ của Tamayo và Yushiro cũng có thể không đủ để đánh bại những con quỷ này, những kẻ tự nhận mình là thành viên của Thập Nhị Kizuki phục vụ trực tiếp cho Kibutsuji, con quỷ chịu trách nhiệm cho mọi tai ương của Tanjiro! Nhưng nếu có thể đánh bại những con quỷ này, chúng có thể tiết lộ những bí mật gì về Kibutsuji?', 1, '2025-03-21 03:23:59', '2025-04-02 12:49:16', ''),
(44, 'dms-04', '/images/kny/kny04.jpg', 'DEMON SLAYER 04', 'Koyoharu Gotouge', 'Hành động, Phiêu lưu, Hài hước, Kinh dị, Fantasy', 150000, 2017, 97, 'Gặp Inosuke. Cậu bé hoang dã và có vẻ mất trí với chiếc mặt nạ đầu lợn xông vào loạt phim Demon Slayer và không bao giờ ngoảnh lại nhìn khi cậu và Tanjiro đối đầu nhau bên trong một ngôi nhà bí ẩn.\n\nTanjiro lên đường trở thành Sát Quỷ Nhân để cứu em gái và trả thù cho gia đình!\n\nVào thời Taisho ở Nhật Bản, Tanjiro Kamado tốt bụng kiếm sống bằng nghề bán than củi. Nhưng cuộc sống yên bình của cậu đã tan vỡ khi một con quỷ tàn sát toàn bộ gia đình cậu. Em gái Nezuko của cậu là người duy nhất sống sót, nhưng bản thân cô bé đã bị biến thành quỷ! Tanjiro lên đường thực hiện một hành trình nguy hiểm để tìm cách đưa em gái mình trở lại bình thường và tiêu diệt con quỷ đã hủy hoại cuộc đời cậu.\n\nSau một trận chiến dữ dội với một con quỷ bên trong một ngôi nhà điên cuồng với những căn phòng luôn thay đổi, Tanjiro có cơ hội tìm hiểu về chiến binh đeo mặt nạ đầu lợn rừng. Kiếm sĩ nhiệt huyết này là ai và anh ta muốn gì? Sau đó, một nhiệm vụ mới đã đưa Tanjiro và những người đồng đội của mình đến Núi Natagumo và đối đầu với một mối đe dọa bí ẩn và kinh hoàng...', 1, '2025-03-21 03:23:59', '2025-04-08 01:20:07', ''),
(45, 'dms-05', '/images/kny/kny05.jpg', 'DEMON SLAYER 05', 'Koyoharu Gotouge', 'Hành động, Phiêu lưu, Hài hước, Kinh dị, Fantasy', 150000, 2017, 99, 'Tanjiro, Zenitsu và Inosuke phải đối mặt với nhiệm vụ không đáng ghen tị và — nếu bạn hỏi Zenitsu — là nhiệm vụ đáng sợ là đánh bại một băng quỷ nhện trên chính lãnh địa của chúng.\n\nTanjiro lên đường trở thành Sát Quỷ Nhân để cứu em gái và trả thù cho gia đình!\n\nỞ Nhật Bản thời Taisho, Tanjiro Kamado tốt bụng kiếm sống bằng nghề bán than củi. Nhưng cuộc sống yên bình của cậu đã tan vỡ khi một con quỷ tàn sát toàn bộ gia đình cậu. Em gái Nezuko của cậu là người duy nhất sống sót, nhưng bản thân cô bé đã bị biến thành quỷ! Tanjiro lên đường thực hiện một hành trình nguy hiểm để tìm cách đưa em gái mình trở lại bình thường và tiêu diệt con quỷ đã hủy hoại cuộc đời cậu.\n\nTại Núi Natagumo, Tanjiro, Zenitsu và Inosuke chiến đấu với một gia đình quỷ nhện khủng khiếp. Đối đầu với những kẻ thù mạnh mẽ như vậy đòi hỏi tất cả kỹ năng và may mắn mà Tanjiro có khi cậu và những người bạn đồng hành chiến đấu để giải cứu Nezuko khỏi mạng nhện. Trận chiến đang thu hút những Sát Quỷ Nhân khác nhưng không phải tất cả bọn họ sẽ rời khỏi Núi Natagumo còn sống—hoặc nguyên vẹn!', 1, '2025-03-21 03:23:59', '2025-04-01 13:08:25', ''),
(46, 'jjk-01', '/images/jjk/jujutsu-kaisen-01.jpg', 'JUJUTSU KAISEN 01', 'Gege Akutami', 'Hành động, Kinh dị, Siêu nhiên, Hài hước', 140000, 2018, 100, 'Hãy chuẩn bị để gặp một trong những bộ sưu tập nhân vật tuyệt vời nhất trong manga, bắt đầu với Yuji Itadori cực kỳ mạnh mẽ nhưng lại không có tài năng, người đã ăn một ngón tay bị nguyền rủa và đảo lộn thế giới của mình. Và đó chỉ là sự khởi đầu.\n\nĐể có được sức mạnh cần thiết để cứu bạn mình khỏi một linh hồn bị nguyền rủa, Yuji Itadori đã nuốt một mảnh của một con quỷ, chỉ để thấy mình bị cuốn vào giữa một cuộc chiến khủng khiếp của thế lực siêu nhiên!\n\nTrong một thế giới mà những linh hồn bị nguyền rủa ăn thịt những con người không hề hay biết, những mảnh vỡ của con quỷ huyền thoại và đáng sợ Ryomen Sukuna đã bị thất lạc và phân tán khắp nơi. Nếu bất kỳ con quỷ nào ăn các bộ phận cơ thể của Sukuna, sức mạnh mà chúng có được có thể phá hủy thế giới như chúng ta biết. May mắn thay, có một trường phái bí ẩn của các pháp sư jujutsu tồn tại để bảo vệ sự tồn tại bấp bênh của người sống khỏi thế lực siêu nhiên!\n\nMặc dù Yuji Itadori trông giống như một thiếu niên bình thường, nhưng sức mạnh thể chất to lớn của anh ấy là điều đáng chú ý! Mọi câu lạc bộ thể thao đều muốn anh ấy tham gia, nhưng Itadori lại thích đi chơi với những kẻ bị ruồng bỏ trong trường ở Câu lạc bộ nghiên cứu huyền bí. Một ngày nọ, câu lạc bộ xoay sở để có được một vật thể bị nguyền rủa bị phong ấn. Họ không biết nỗi kinh hoàng mà họ sẽ giải phóng khi phá vỡ phong ấn...', 1, '2025-03-21 03:23:59', '2025-04-01 13:49:06', ''),
(47, 'jjk-02', '/images/jjk/jujutsu-kaisen-02.jpg', 'JUJUTSU KAISEN 02', 'Gege Akutami', 'Hành động, Kinh dị, Siêu nhiên, Hài hước', 140000, 2018, 100, 'Nhiệm vụ đầu tiên dành cho những năm đầu tiên, và có một tử cung bị nguyền rủa, đây không phải là tin tốt lành cho bất kỳ ai liên quan.\n\nĐể có được sức mạnh cần thiết để cứu bạn mình khỏi một linh hồn bị nguyền rủa, Yuji Itadori đã nuốt một mảnh của một con quỷ, chỉ để thấy mình bị cuốn vào giữa một cuộc chiến khủng khiếp của thế lực siêu nhiên!\n\nTrong một thế giới mà những linh hồn bị nguyền rủa ăn thịt những con người không hề hay biết, những mảnh vỡ của con quỷ huyền thoại và đáng sợ Ryomen Sukuna đã bị thất lạc và phân tán khắp nơi. Nếu bất kỳ con quỷ nào ăn các bộ phận cơ thể của Sukuna, sức mạnh mà chúng có được có thể phá hủy thế giới như chúng ta biết. May mắn thay, có một trường phái bí ẩn gồm các pháp sư jujutsu tồn tại để bảo vệ sự tồn tại bấp bênh của người sống khỏi thế lực siêu nhiên!\n\nKhi một tử cung bị nguyền rủa xuất hiện tại một cơ sở giam giữ, Jujutsu High đã cử Itadori và những học sinh năm nhất khác đến để giải quyết tình hình. Tuy nhiên, lời nguyền mà họ gặp phải mạnh hơn nhiều so với những gì họ từng mong đợi! Itadori và những người bạn hiện có hai lựa chọn: chạy trốn và có thể sống sót, hoặc chiến đấu và chết. Trong khi họ bị phân tâm, những lời nguyền mạnh mẽ với những âm mưu bí ẩn nhắm vào Jujutsu High và Satoru Gojo đang tụ tập...', 1, '2025-03-21 03:23:59', '2025-04-01 08:20:59', ''),
(48, 'jjk-03', '/images/jjk/jujutsu-kaisen-03.jpg', 'JUJUTSU KAISEN 03', 'Gege Akutami', 'Hành động, Kinh dị, Siêu nhiên, Hài hước', 140000, 2018, 99, 'Ai mà không thích một cuộc gặp gỡ chào hỏi với những trận đấu tay đôi và một chú gấu trúc chứ? Khi sự kiện thiện chí đang đến gần, Kyoto và Tokyo High đang thổi bùng ngọn lửa trước khi trận chiến bắt đầu.\n\nĐể có được sức mạnh cần thiết để cứu bạn mình khỏi một linh hồn bị nguyền rủa, Yuji Itadori đã nuốt một mảnh của một con quỷ, chỉ để thấy mình bị cuốn vào giữa một cuộc chiến kinh hoàng của thế lực siêu nhiên!\n\nTrong một thế giới mà những linh hồn bị nguyền rủa ăn thịt những con người không hề hay biết, những mảnh vỡ của con quỷ huyền thoại và đáng sợ Ryomen Sukuna đã bị thất lạc và phân tán khắp nơi. Nếu bất kỳ con quỷ nào ăn các bộ phận cơ thể của Sukuna, sức mạnh mà chúng có được có thể phá hủy thế giới như chúng ta biết. May mắn thay, có một trường phái bí ẩn của các pháp sư jujutsu tồn tại để bảo vệ sự tồn tại bấp bênh của người sống khỏi thế lực siêu nhiên!\n\nCăng thẳng lên cao khi Sự kiện thiện chí giữa cơ sở Tokyo và Kyoto của trường Trung học Jujutsu đến gần. Nhưng trước khi cuộc thi có thể bắt đầu, một vài học sinh Kyoto đã đối đầu với Fushiguro và Kugisaki. Trong khi đó, quá trình luyện tập của Yuji bị gián đoạn bởi một tội ác bí ẩn liên quan đến những thay đổi cơ thể kỳ dị do một linh hồn bị nguyền rủa gây ra...', 1, '2025-03-21 03:23:59', '2025-04-08 01:16:53', ''),
(49, 'jjk-04', '/images/jjk/jujutsu-kaisen-04.jpg', 'JUJUTSU KAISEN 04', 'Gege Akutami', 'Hành động, Kinh dị, Siêu nhiên, Hài hước', 140000, 2018, 99, 'Sự khởi đầu cho sự độc ác của Mahito. Khi Itadori và Junpei bắt đầu một tình bạn quyến rũ, linh hồn bị nguyền rủa Mahito lại có những kế hoạch khác.\n\nĐể có được sức mạnh cần thiết để cứu bạn mình khỏi một linh hồn bị nguyền rủa, Yuji Itadori đã nuốt một mảnh của một con quỷ, chỉ để thấy mình bị cuốn vào giữa một cuộc chiến siêu nhiên kinh hoàng!\n\nTrong một thế giới nơi những linh hồn bị nguyền rủa ăn thịt những con người không hề hay biết, những mảnh vỡ của con quỷ huyền thoại và đáng sợ Ryomen Sukuna đã bị thất lạc và phân tán khắp nơi. Nếu bất kỳ con quỷ nào ăn các bộ phận cơ thể của Sukuna, sức mạnh mà chúng có được có thể phá hủy thế giới như chúng ta biết. May mắn thay, có một trường phái bí ẩn của các pháp sư jujutsu tồn tại để bảo vệ sự tồn tại bấp bênh của người sống khỏi thế lực siêu nhiên!\n\nTrong khi điều tra một loạt cái chết bí ẩn kỳ lạ, Itadori gặp Junpei, một đứa trẻ có vấn đề thường bị bắt nạt ở trường. Tuy nhiên, Junpei cũng kết bạn với thủ phạm đằng sau vụ việc đẫm máu—Mahito, một linh hồn bị nguyền rủa tinh quái! Mahito khởi động một kế hoạch gian xảo liên quan đến Junpei, hy vọng cũng sẽ bẫy được Itadori.', 1, '2025-03-21 03:23:59', '2025-04-02 07:37:06', ''),
(50, 'jjk-05', '/images/jjk/jujutsu-kaisen-05.jpg', 'JUJUTSU KAISEN 05', 'Gege Akutami', 'Hành động, Kinh dị, Siêu nhiên, Hài hước', 140000, 2018, 100, 'Itadori vẫn còn sống! Và mặc dù chưa có ai ăn mừng, nhưng chắc chắn họ sẽ ăn mừng khi anh ấy cứu cả ngày trước Kyoto High. Chắc chắn rồi.\n\nĐể có được sức mạnh cần thiết để cứu bạn mình khỏi một linh hồn bị nguyền rủa, Yuji Itadori đã nuốt một mảnh của một con quỷ, chỉ để thấy mình bị cuốn vào giữa một cuộc chiến kinh hoàng của thế lực siêu nhiên!\n\nTrong một thế giới mà những linh hồn bị nguyền rủa ăn thịt những con người không hề hay biết, những mảnh vỡ của con quỷ huyền thoại và đáng sợ Ryomen Sukuna đã bị thất lạc và phân tán khắp nơi. Nếu bất kỳ con quỷ nào ăn các bộ phận cơ thể của Sukuna, sức mạnh mà chúng có được có thể phá hủy thế giới như chúng ta biết. May mắn thay, có một trường phái bí ẩn gồm những pháp sư jujutsu tồn tại để bảo vệ sự tồn tại bấp bênh của người sống khỏi thế lực siêu nhiên!\n\nMọi người đều ngạc nhiên (và không nhất thiết là theo cách tốt) khi họ phát hiện ra Itadori vẫn còn sống, nhưng không có thời gian cho một cuộc đoàn tụ ấm áp khi Trường trung học Jujutsu đang ở giữa một cuộc cạnh tranh khốc liệt với các đối thủ của họ từ Kyoto! Nhưng tinh thần thể thao tốt dường như không nằm trong các lá bài khi chính quyền quyết định loại bỏ mối đe dọa Sukuna một lần và mãi mãi...', 1, '2025-03-21 03:23:59', '2025-04-01 08:21:16', ''),
(51, 'ddd-01', '/images/ddd/dandandan-01.jpg', 'DANDADAN 01', 'Yukinobu Tatsu', 'Hành động, Kinh dị, Hài hước, Trinh thám, Siêu nhiên', 166000, 2020, 100, 'Một mọt sách phải chiến đấu với những linh hồn mạnh mẽ và người ngoài hành tinh đang tranh giành sức mạnh bí mật của \"viên ngọc gia truyền\" của mình, vậy còn ai có thể chiến đấu cùng anh ta tốt hơn là người anh ta thầm thương trộm nhớ thời trung học và một bà ngoại tinh linh?!\n\nMomo Ayase và Okarun ở hai thái cực đối lập của quang phổ huyền bí liên quan đến những gì họ tin và những gì họ không tin. Nhiệm vụ chứng minh rằng nhau đã sai dẫn họ đến một con đường của những mối tình thầm kín và những trận chiến huyền bí mà họ phải tham gia để tin!\n\nMomo Ayase bắt đầu một tình bạn khác thường với một người cuồng UFO ở trường, người mà cô đặt biệt danh là \"Okarun\" vì anh ta có một cái tên không được phép nói ra. Trong khi Momo tin vào linh hồn, cô nghĩ rằng người ngoài hành tinh chẳng là gì ngoài sự vô nghĩa. Trong khi đó, người bạn mới của cô lại nghĩ ngược lại. Để giải quyết vấn đề, cả hai bắt đầu chứng minh rằng nhau đã sai - Momo đến một điểm nóng UFO và Okarun đến một đường hầm ma ám! Những gì diễn ra tiếp theo là một câu chuyện đẹp ', 1, '2025-03-21 03:23:59', '2025-04-01 08:21:21', ''),
(52, 'ddd-02', '/images/ddd/dandandan-02.jpg', 'DANDADAN 02', 'Yukinobu Tatsu', 'Hành động, Kinh dị, Hài hước, Trinh thám, Siêu nhiên', 166000, 2020, 100, 'Một mọt sách phải chiến đấu với những linh hồn mạnh mẽ và người ngoài hành tinh đang tranh giành sức mạnh bí mật của \"viên ngọc gia truyền\" của mình, vậy còn ai tốt hơn để chiến đấu cùng anh ta ngoài người anh thầm thương trộm nhớ thời trung học và một bà lão tinh thần?!\n\nMomo Ayase và Okarun ở hai phía đối lập của quang phổ huyền bí liên quan đến những gì họ sẽ tin và những gì họ sẽ không tin. Nhiệm vụ chứng minh rằng nhau sai dẫn họ đến một con đường của những mối tình thầm kín và những trận chiến huyền bí mà họ sẽ phải tham gia để tin!\n\nOkarun, một cậu bé trung học bị ám ảnh bởi các hiện tượng siêu nhiên, bị Turbo Granny nguyền rủa! Để phá bỏ lời nguyền, Okarun và bạn cùng lớp Momo Ayase thách đấu Turbo Granny trong một cuộc đua có tiền cược cao. Nhưng sát thủ của Turbo Granny, một linh hồn bị trói buộc dưới hình dạng một con cua khổng lồ, có những kế hoạch khác!', 1, '2025-03-21 03:23:59', '2025-04-01 08:21:27', ''),
(53, 'ddd-03', '/images/ddd/dandandan-03.jpg', 'DANDADAN 03', 'Yukinobu Tatsu', 'Hành động, Kinh dị, Hài hước, Trinh thám, Siêu nhiên', 166000, 2020, 99, 'Hãy gặp Aira! Cô ấy có thể nghĩ rằng mình được phái xuống từ thiên đường để tiêu diệt quỷ dữ, nhưng còn người phụ nữ điên đang cố giết cô ấy thì sao?\n\nMột mọt sách phải chiến đấu với những linh hồn mạnh mẽ và người ngoài hành tinh đang tranh giành sức mạnh bí mật của \"viên ngọc gia truyền\" của mình, vậy còn ai có thể chiến đấu cùng anh ta tốt hơn là người anh thầm thương trộm nhớ thời trung học và một bà lão tinh thần?!\n\nMomo Ayase và Okarun ở hai phía đối lập của quang phổ huyền bí liên quan đến những gì họ sẽ tin và những gì họ sẽ không tin. Nhiệm vụ chứng minh rằng nhau sai dẫn họ đến một con đường của những mối tình thầm kín và những trận chiến huyền bí mà họ sẽ phải tham gia để tin!\n\nOkarun, một cậu học sinh trung học bị ám ảnh bởi các hiện tượng siêu nhiên, đã đánh mất những viên ngọc gia truyền quý giá của mình trong một trận chiến với Turbo Granny! Người bạn cùng lớp của anh ta là Aira cuối cùng đã tìm thấy một viên, và nó đánh thức sức mạnh tâm linh bên trong cô. Cùng thời điểm này, một người phụ nữ lạ mặc váy đỏ xuất hiện ở trường và tấn công Aira, Okarun và Momo! Cô ta là ai và tại sao cô ta lại ám ảnh Aira đến vậy?', 1, '2025-03-21 03:23:59', '2025-04-04 00:36:25', ''),
(54, 'ddd-04', '/images/ddd/dandandan-04.jpg', 'DANDADAN 04', 'Yukinobu Tatsu', 'Hành động, Kinh dị, Hài hước, Trinh thám, Siêu nhiên', 166000, 2020, 100, 'Các cơ quan sinh sản đang bị đe dọa vì người Serpoian đã hoàn toàn mất trí. Nhưng thông qua sức mạnh của tinh thần đồng đội, chắc chắn các anh hùng của chúng ta có thể chiến thắng, và không có bất kỳ sự nhổ răng nào không mong muốn.\n\nMột mọt sách phải chiến đấu với những linh hồn mạnh mẽ và những người ngoài hành tinh đang tranh giành sức mạnh bí mật của \"viên ngọc gia truyền\" của mình, vậy còn ai có thể chiến đấu cùng anh ta tốt hơn là người anh ta thầm thương trộm nhớ thời trung học và một bà ngoại tinh linh?!\n\nMomo Ayase và Okarun ở hai phía đối lập của quang phổ huyền bí liên quan đến những gì họ sẽ tin và những gì họ sẽ không tin. Nhiệm vụ chứng minh rằng nhau đã sai dẫn họ đến một con đường của những mối tình thầm kín và những trận chiến huyền bí mà họ sẽ phải tham gia để tin!\n\nNhững người Serpoian ăn trộm chuối đã trở lại! Và chúng đã nhốt Okarun, Momo và Aira trong một khoảng không để có một lần nữa đánh cắp cơ quan sinh sản của họ. Trận chiến sau đó khiến sức mạnh của Acrobatic Silky trú ngụ trong Aira thức tỉnh, và cô tạm thời hợp tác với Momo và Okarun. Nhưng liệu họ có thể là đối thủ của đối thủ của mình sau khi những người ngoài hành tinh hợp nhất với tay sai của chúng để tạo thành một sinh vật thậm chí còn vĩ đại hơn ?!', 1, '2025-03-21 03:23:59', '2025-04-01 08:21:38', ''),
(55, 'ddd-05', '/images/ddd/dandandan-05.jpg', 'DANDADAN 05', 'Yukinobu Tatsu', 'Hành động, Kinh dị, Hài hước, Trinh thám, Siêu nhiên', 166000, 2020, 100, 'Một mọt sách phải chiến đấu với những linh hồn mạnh mẽ và người ngoài hành tinh đang tranh giành sức mạnh bí mật của \"viên ngọc gia truyền\" của mình, vậy còn ai tốt hơn để chiến đấu cùng anh ngoài người anh thầm thương trộm nhớ thời trung học và một bà ngoại tinh linh?!\n\nMomo Ayase và Okarun ở hai phía đối lập của quang phổ huyền bí liên quan đến những gì họ sẽ tin và những gì họ sẽ không tin. Nhiệm vụ chứng minh rằng nhau sai dẫn họ đến một con đường của những mối tình thầm kín và những trận chiến huyền bí mà họ sẽ phải tham gia để tin!\n\nOkarun và nhóm bạn đến một thị trấn suối nước nóng để điều tra bí ẩn về gia đình Jiji. Nhưng khi họ đến đó, một gia đình kỳ lạ thông đồng với cảnh sát bắt đầu gây rắc rối cho họ, và trước khi Okarun và những người khác có thể đi đến tận cùng của bí ẩn, Momo đã trở thành một vật hiến tế cho vị thần địa phương!', 1, '2025-03-21 03:23:59', '2025-04-01 08:21:43', ''),
(56, 'sao-01', '/images/sao/sao-1.jpg', 'SWORD ART ONLINE 01', 'Reki Kawahara,Stephen Paul', 'Game, Fantasy, Hành động, Phiêu lưu', 190000, 2015, 100, '\"Không có cách nào để chiến thắng trò chơi này. Điểm khác biệt duy nhất là khi nào và ở đâu bạn chết...\" Một tháng đã trôi qua kể từ khi trò chơi chết chóc của Akihiko Kayaba bắt đầu, và số lượng người chết vẫn tiếp tục tăng. Hai nghìn người chơi đã chết. Kirito và Asuna là hai người rất khác nhau, nhưng cả hai đều muốn chiến đấu một mình. Tuy nhiên, họ thấy mình bị cuốn vào nhau để đối mặt với những thách thức từ cả bên trong và bên ngoài. Với việc toàn bộ thế giới ảo mà họ đang sống được tạo ra như một cái bẫy chết người, những người chơi còn sống sót của Sword Art Online đang bắt đầu trở nên tuyệt vọng, và sự tuyệt vọng khiến họ trở nên nguy hiểm đối với những kẻ đơn độc như Kirito và Asuna. Khi rõ ràng rằng cô đơn đồng nghĩa với tự tử, liệu hai người có thể vượt qua được sự khác biệt của mình để tìm thấy sức mạnh để tin tưởng vào nhau và bằng cách đó sống sót? Sword Art Online: Progressive là phiên bản mới của câu chuyện Sword Art Online bắt đầu từ cuộc phiêu lưu hoành tráng của Kirito và Asuna—ở cấp độ đầu tiên của thế giới chết chóc Aincrad!', 1, '2025-03-21 03:23:59', '2025-04-01 08:21:49', ''),
(57, 'sao-02', '/images/sao/sao-2.jpg', 'SWORD ART ONLINE 02', 'Reki Kawahara,Stephen Paul', 'Game, Fantasy, Hành động, Phiêu lưu', 190000, 2015, 100, '\"Không có cách nào để đánh bại trò chơi này. Điểm khác biệt duy nhất là khi nào và ở đâu bạn chết...\" Sau khi dọn sạch tầng một và tầng hai của Aincrad với cái giá rất đắt, Kirito, Asuna và những người chơi còn lại lên đến tầng ba. Những đồng minh mới mong manh đang chờ họ—quan trọng nhất là Kizmel, hiệp sĩ tiên. Kizmel được cho là một NPC nhỏ với AI cấp thấp, nhưng cô ấy sớm bộc lộ mình còn hơn thế nữa. Tuy nhiên, với những đồng minh mới đi kèm những phức tạp mới, và những người tiên của khu rừng rộng lớn ở tầng ba không đoàn kết hơn những người chơi vừa mới đến đó. Sự hấp dẫn trở nên sâu sắc hơn khi một nhân vật bí ẩn thách thức Kirito, và những gì bắt đầu như một cuộc thi kỹ năng đơn giản thực sự có thể là thứ gì đó chết chóc hơn nhiều! Sword Art Online: Progressive là phiên bản mới của câu chuyện Sword Art Online, ghi lại toàn bộ cuộc phiêu lưu hoành tráng của Kirito và Asuna qua Aincrad—từ cấp độ đầu tiên cho đến hết!', 1, '2025-03-21 03:23:59', '2025-04-01 08:21:56', ''),
(58, 'sao-03', '/images/sao/sao-3.jpg', 'SWORD ART ONLINE 03', 'Reki Kawahara,Stephen Paul', 'Game, Fantasy, Hành động, Phiêu lưu', 190000, 2015, 100, '\"Chúng ta đi thôi, Asuna! Bám chặt vào! Tilnel, phóng!\"\nSau khi tạm biệt hiệp sĩ elven bí ẩn Kizmel, Kirito và Asuna hướng tầm mắt đến tầng thứ tư của Aincrad. Nhưng khi họ mở cánh cửa, họ thấy lối đi phía trước bị chặn bởi một dòng sông chảy xiết. Phiên bản cập nhật của tầng thứ tư đã được thay đổi thành một thế giới nước! Khi cuối cùng họ đến thị trấn của tầng này, họ được chào đón bằng những con phố trắng như phấn và vô số thuyền gondola đủ mọi kích cỡ. Để di chuyển đến nơi này, Kirito và Asuna sẽ cần thuyền gondola riêng của mình—nhưng để có được một chiếc, họ sẽ phải đối mặt với một con quái thú lửa cao tám mét: Magnaterium... Và đó chỉ là khởi đầu cho những khó khăn mà tầng thứ tư của Aincrad dành cho họ!\n\n\nSword Art Online: Progressive, phiên bản mới của câu chuyện Sword Art Online ghi lại toàn bộ cuộc phiêu lưu hoành tráng của Kirito và Asuna qua Aincrad, sẽ tiếp tục!', 1, '2025-03-21 03:23:59', '2025-04-01 08:22:02', ''),
(59, 'sao-04', '/images/sao/sao-4.jpg', 'SWORD ART ONLINE 04', 'Reki Kawahara,Stephen Paul', 'Game, Fantasy, Hành động, Phiêu lưu', 190000, 2015, 100, 'Chỉ mới hai tháng trôi qua kể từ khi họ bị mắc kẹt trong trò chơi tử thần Sword Art Online , và Kirito cùng Asuna tiếp tục cuộc đấu tranh của họ ở vị trí tiên phong trong quá trình tiến triển của trò chơi. Tầng thứ năm của Aincrad là một đống đổ nát giống như mê cung, và cả hai đều dám vui vẻ đột kích vào đó để tìm kho báu. Khi trở về tầng thứ tư, đã đến lúc thực hiện một số nhiệm vụ thay mặt cho Chúa tể Elf Yofilis—nhưng ở đây sự bất mãn của Asuna bắt đầu, vì khi làm như vậy, họ sẽ phải đối mặt với con quái vật mà cô ấy ghét nhất...', 1, '2025-03-21 03:23:59', '2025-04-01 08:22:08', ''),
(60, 'sao-05', '/images/sao/sao-5.jpg', 'SWORD ART ONLINE 05', 'Reki Kawahara,Stephen Paul', 'Game, Fantasy, Hành động, Phiêu lưu', 190000, 2015, 100, 'Yuuki Asuna là một học sinh giỏi, dành cả ngày để học ở trường luyện thi và chuẩn bị cho kỳ thi tuyển sinh trung học—nhưng đó là trước khi cô mượn hệ thống trò chơi thực tế ảo của anh trai mình và bị mắc kẹt trong Sword Art Online cùng với mười nghìn người chơi sợ hãi khác. Khi thời gian trôi qua, Asuna lo sợ về những gì sẽ xảy ra với cuộc sống của cô bên ngoài thế giới tưởng tượng—sự thất bại mà cô có thể bị coi là trong mắt bạn bè và cha mẹ. Không muốn chờ đợi những game thủ giàu kinh nghiệm hơn đánh bại trò chơi, Asuna sử dụng thói quen học tập của mình để tìm hiểu cơ chế của trò chơi—và đấu kiếm. Sự nhanh nhẹn của cô đã gây ấn tượng với Kirito, một game thủ chuyên nghiệp, người đã mời Asuna tham gia cùng những người chơi giỏi nhất ở tuyến đầu. Liệu Asuna đã sẵn sàng đổi thứ hạng lớp học lấy thứ hạng người chơi và tham gia cùng Kirito chưa?', 1, '2025-03-21 03:23:59', '2025-04-01 08:22:15', ''),
(61, 'blc-01', '/images/bc/black-clover-01.jpg', 'BLACK CLOVER 01', 'Yuki Tabata', 'Sounen, Hành động, Hài hước, Fantasy, Phiêu lưu, Siêu nhiên', 120000, 2017, 100, 'Asta quyết tâm trở thành Vua pháp sư, mặc dù không có phép thuật riêng. Nhưng rồi cậu có được một thanh kiếm chống phép thuật mạnh mẽ, và đó là tất cả những gì cậu cần. Đây là My Hero Academia, nhưng với phép thuật thay vì các đặc điểm kỳ quặc, và nó sẽ vẫn cuốn hút bạn.\n\nTrong một thế giới phép thuật, Asta, một cậu bé có sức mạnh chống lại phép thuật, sẽ làm bất cứ điều gì cần thiết để trở thành Vua pháp sư!\n\nAsta là một cậu bé mơ ước trở thành pháp sư vĩ đại nhất trong vương quốc. Chỉ có một vấn đề - cậu không thể sử dụng bất kỳ phép thuật nào! May mắn thay cho Asta, cậu nhận được cuốn sách ma thuật cỏ năm lá cực kỳ hiếm có giúp cậu có được sức mạnh chống lại phép thuật. Liệu một người không thể sử dụng phép thuật có thực sự trở thành Vua pháp sư không? Một điều chắc chắn là - Asta sẽ không bao giờ bỏ cuộc!\n\nAsta trẻ tuổi được sinh ra mà không có khả năng phép thuật trong một thế giới mà phép thuật là tất cả. Để chứng minh sức mạnh của mình và giữ lời hứa với bạn mình, Asta mơ ước trở thành pháp sư vĩ đại nhất trong vùng đất này, Vua pháp sư!', 1, '2025-03-21 03:23:59', '2025-04-01 08:22:20', ''),
(62, 'blc-02', '/images/bc/black-clover-02.jpg', 'BLACK CLOVER 02', 'Yuki Tabata', 'Sounen, Hành động, Hài hước, Fantasy, Phiêu lưu, Siêu nhiên', 120000, 2017, 100, 'Cuộc khai quật đơn giản ban đầu đã biến thành một cuộc chiến giữa các quốc gia và sự liều lĩnh đáng yêu của Asta chính là nguyên nhân chính.\n\nTrong một thế giới phép thuật, Asta, một cậu bé có sức mạnh chống lại phép thuật, sẽ làm bất cứ điều gì cần thiết để trở thành Vua pháp sư!\n\nAsta là một cậu bé mơ ước trở thành pháp sư vĩ đại nhất trong vương quốc. Chỉ có một vấn đề - cậu không thể sử dụng bất kỳ phép thuật nào! May mắn thay cho Asta, cậu nhận được cuốn sách ma thuật cỏ năm lá cực kỳ hiếm có giúp cậu có được sức mạnh chống lại phép thuật. Liệu một người không thể sử dụng phép thuật có thực sự có thể trở thành Vua pháp sư không? Một điều chắc chắn là - Asta sẽ không bao giờ bỏ cuộc!\n\nTheo lệnh của Vua pháp sư, Asta và các đồng minh của mình đến một ngục tối bí ẩn để lấy một thánh tích mạnh mẽ. Tuy nhiên, khi các pháp sư từ một quốc gia đối thủ xuất hiện, nhiệm vụ này biến thành một trận chiến toàn diện. Liệu Asta có thể dẫn dắt đội của mình giành chiến thắng không?\n', 1, '2025-03-21 03:23:59', '2025-04-01 08:22:25', ''),
(63, 'blc-03', '/images/bc/black-clover-03.jpg', 'BLACK CLOVER 03', 'Yuki Tabata', 'Sounen, Hành động, Hài hước, Fantasy, Phiêu lưu, Siêu nhiên', 120000, 2017, 100, 'Gặp Mars, niềm tự hào và niềm vui của Vương quốc Kim cương (hiện tại). Liệu sự lạc quan mù quáng của Asta có đủ để ngăn chặn mối đe dọa này không?\n\nTrong một thế giới phép thuật, Asta, một cậu bé có sức mạnh chống lại phép thuật, sẽ làm bất cứ điều gì cần thiết để trở thành Vua pháp sư!\n\nAsta là một cậu bé mơ ước trở thành pháp sư vĩ đại nhất trong vương quốc. Chỉ có một vấn đề - cậu không thể sử dụng bất kỳ phép thuật nào! May mắn thay cho Asta, cậu nhận được cuốn sách ma thuật cỏ năm lá cực kỳ hiếm có giúp cậu có được sức mạnh chống lại phép thuật. Liệu một người không thể sử dụng phép thuật có thực sự có thể trở thành Vua pháp sư không? Một điều chắc chắn là - Asta sẽ không bao giờ bỏ cuộc!\n\nAsta và các đồng đội của mình đã sẵn sàng cho rắc rối khi họ được đưa vào một ngục tối ma thuật đầy cạm bẫy, nhưng việc chống lại Vương quốc Kim cương có thể là quá sức đối với họ. Ngay cả Yuno cũng không thể chống lại Mars và phép thuật khoáng vật của anh ta - liệu Asta có cơ hội không...?!', 1, '2025-03-21 03:23:59', '2025-04-01 08:22:30', '');
INSERT INTO `books` (`id_auto`, `id`, `image`, `name`, `author`, `genre`, `price`, `pub_year`, `stock`, `des`, `status`, `created_at`, `updated_at`, `ebookLink`) VALUES
(64, 'blc-04', '/images/bc/black-clover-04.jpg', 'BLACK CLOVER 04', 'Yuki Tabata', 'Sounen, Hành động, Hài hước, Fantasy, Phiêu lưu, Siêu nhiên', 120000, 2017, 100, 'Nguy hiểm ở Vương quốc Clover! Khi các hiệp sĩ chống lại một cuộc tấn công bất ngờ, những câu hỏi lớn được đặt ra và rất khó để tìm ra câu trả lời.\n\nTrong một thế giới phép thuật, Asta, một cậu bé có sức mạnh chống lại phép thuật, sẽ làm bất cứ điều gì cần thiết để trở thành Vua pháp sư!\n\nAsta là một cậu bé mơ ước trở thành pháp sư vĩ đại nhất trong vương quốc. Chỉ có một vấn đề - cậu không thể sử dụng bất kỳ phép thuật nào! May mắn thay cho Asta, cậu nhận được cuốn sách ma thuật cỏ năm lá cực kỳ hiếm có giúp cậu có được sức mạnh chống lại phép thuật. Liệu một người không thể sử dụng phép thuật có thực sự trở thành Vua pháp sư không? Một điều chắc chắn là - Asta sẽ không bao giờ bỏ cuộc!\n\nSự hỗn loạn hoàn toàn đã nổ ra khi thủ đô Vương quốc Cỏ ba lá bị một nhóm khủng bố bí ẩn tấn công. Asta và các Hiệp sĩ phép thuật khác tham gia cuộc chiến để bảo vệ những thường dân vô tội, nhưng chính xác thì những kẻ khủng bố đang theo đuổi điều gì?', 1, '2025-03-21 03:23:59', '2025-04-01 08:22:38', ''),
(65, 'blc-05', '/images/bc/black-clover-05.jpg', 'BLACK CLOVER 05', 'Yuki Tabata', 'Sounen, Hành động, Hài hước, Fantasy, Phiêu lưu, Siêu nhiên', 120000, 2017, 100, 'Mối đe dọa đã được ngăn chặn, nhưng phải trả giá như thế nào? Vua pháp sư phải đưa ra một số quyết định, và Asta, như thường lệ, đã sẵn sàng chiến đấu.\n\nTrong một thế giới phép thuật, Asta, một cậu bé có sức mạnh chống lại phép thuật, sẽ làm bất cứ điều gì cần thiết để trở thành Vua pháp sư!\n\nAsta là một cậu bé mơ ước trở thành pháp sư vĩ đại nhất trong vương quốc. Chỉ có một vấn đề - cậu không thể sử dụng bất kỳ phép thuật nào! May mắn thay cho Asta, cậu nhận được cuốn sách ma thuật cỏ năm lá cực kỳ hiếm có giúp cậu có được sức mạnh chống lại phép thuật. Liệu một người không thể sử dụng phép thuật có thực sự trở thành Vua pháp sư không? Một điều chắc chắn là - Asta sẽ không bao giờ bỏ cuộc!\n\nNhóm khủng bố bí ẩn tự xưng là Mắt Mặt trời Nửa đêm đã bị đẩy lùi khỏi Vương quốc Cỏ ba lá, nhưng thiệt hại gây ra là rất lớn. Một trong những đội trưởng Hiệp sĩ Phép thuật đã bị thương nặng và Asta đã bị bắt cóc. Vua pháp sư sẽ phản ứng như thế nào...?', 1, '2025-03-21 03:23:59', '2025-04-01 08:22:43', ''),
(66, 'spxf-01', '/images/spxf/spy-x-family-01.jpg', 'SPY x FAMILY 01', 'Tatsuya Endo', 'Hài hước, Gia đình, Gián điệp, Hành động, Học đường', 150000, 2022, 99, 'Một điệp viên, một sát thủ và một nhà ngoại cảm bước vào một bộ truyện tranh, và đó là Spy x Family. Bạn sẽ cười, bạn sẽ khóc (vì cười), và bạn có thể sẽ say sưa đọc hết cả bộ truyện.\n\nMột bộ phim hài hành động về một gia đình giả gồm một điệp viên, một sát thủ và một nhà ngoại cảm!\n\nĐiệp viên bậc thầy Twilight là vô song khi nói đến việc bí mật thực hiện các nhiệm vụ nguy hiểm vì sự cải thiện của thế giới. Nhưng khi anh nhận được nhiệm vụ cuối cùng - kết hôn và có một đứa con - cuối cùng anh có thể bị quá sức!\n\nKhông phải là người phụ thuộc vào người khác, Twilight phải làm việc chăm chỉ để kiếm được cả vợ và con cho nhiệm vụ thâm nhập vào một trường tư thục danh giá. Điều anh không biết là người vợ anh chọn là một sát thủ và đứa con anh nhận nuôi là một nhà ngoại cảm!', 1, '2025-03-21 04:02:20', '2025-04-04 03:02:05', ''),
(67, 'spxf-02', '/images/spxf/spy-x-family-02.jpg', 'SPY x FAMILY 02', 'Tatsuya Endo', 'Hài hước, Gia đình, Gián điệp, Hành động, Học đường', 150000, 2022, 100, 'Liệu Loid có thể thuyết phục thành công hội đồng rằng Anya là học sinh hoàn hảo không? Hay sự cạnh tranh của anh với Donovan Desmond sẽ làm lộ vỏ bọc của anh?\n\nMột bộ phim hài hành động về một gia đình giả gồm một điệp viên, một sát thủ và một nhà ngoại cảm!\n\nĐiệp viên bậc thầy Twilight là vô song khi nói đến việc bí mật thực hiện các nhiệm vụ nguy hiểm vì sự cải thiện của thế giới. Nhưng khi anh nhận được nhiệm vụ cuối cùng - kết hôn và có một đứa con - cuối cùng anh có thể đã quá sức!\n\nTwilight phải thâm nhập vào Học viện Eden danh giá để tiếp cận mục tiêu của mình là Donovan Desmond, nhưng liệu anh có hủy hoại cơ hội của con gái mình là Anya bằng cơn bộc phát của mình trong buổi phỏng vấn tuyển sinh không? Có lẽ nhiệm vụ thực sự bất khả thi lần này là đảm bảo Anya vừa trở thành một học sinh gương mẫu vừa kết bạn với Damian, cậu con trai kiêu ngạo của Donovan!', 1, '2025-03-21 04:02:40', '2025-04-01 08:22:54', ''),
(68, 'spxf-03', '/images/spxf/spy-x-family-03.jpg', 'SPY x FAMILY 03', 'Tatsuya Endo', 'Hài hước, Gia đình, Gián điệp, Hành động, Học đường', 150000, 2022, 100, 'Loid có thể xử lý hầu hết mọi thứ, nhưng em trai của Yor là Yuri thì không. Đây là cuộc đấu trí tuệ và bí mật, và những người tham chiến đã sẵn sàng và chuẩn bị hành lý.\n\nMột bộ phim hài hành động về một gia đình giả bao gồm một điệp viên, một sát thủ và một nhà ngoại cảm!\n\nĐiệp viên bậc thầy Twilight là vô song khi nói đến việc bí mật thực hiện các nhiệm vụ nguy hiểm vì sự cải thiện của thế giới. Nhưng khi anh nhận được nhiệm vụ cuối cùng - kết hôn và có một đứa con - cuối cùng anh có thể bị quá sức!\n\nTwilight đã vượt qua nhiều thử thách trong việc thành lập gia đình Forger, nhưng giờ đây mọi công sức của anh có thể tan thành mây khói khi em trai của Yor là Yuri bất ngờ ghé thăm! Liệu Twilight có thể qua mặt được Yuri, người thực sự làm việc cho cơ quan mật vụ Ostanian?!', 1, '2025-03-21 04:03:01', '2025-04-01 08:22:59', ''),
(69, 'spxf-04', '/images/spxf/spy-x-family-04.jpg', 'SPY x FAMILY 04', 'Tatsuya Endo', 'Hài hước, Gia đình, Gián điệp, Hành động, Học đường', 150000, 2022, 100, 'Đã đến lúc nuôi một chú chó con trong gia đình, nhưng trước tiên (hoặc không?) có một mối đe dọa cần phải ngăn chặn. Liệu hai mục tiêu có nhiều điểm chung hơn vẻ bề ngoài không?\n\nMột bộ phim hài hành động về một gia đình giả bao gồm một điệp viên, một sát thủ và một nhà ngoại cảm!\n\nĐiệp viên bậc thầy Twilight là vô song khi nói đến việc bí mật thực hiện các nhiệm vụ nguy hiểm vì sự cải thiện của thế giới. Nhưng khi anh nhận được nhiệm vụ cuối cùng - kết hôn và có một đứa con - cuối cùng anh có thể bị quá sức!\n\nThe Forgers tìm cách thêm một con chó vào gia đình của họ, nhưng đây không phải là nhiệm vụ dễ dàng - đặc biệt là khi Twilight phải đồng thời ngăn chặn một âm mưu ám sát một bộ trưởng ngoại giao! Những kẻ thủ ác có kế hoạch sử dụng những chú chó được huấn luyện để tấn công, nhưng Twilight nhận được một số sự giúp đỡ bất ngờ để ngăn chặn những kẻ khủng bố này.', 1, '2025-03-21 04:03:19', '2025-04-01 08:23:04', ''),
(70, 'spxf-05', '/images/spxf/spy-x-family-05.jpg', 'SPY x FAMILY 05', 'Tatsuya Endo', 'Hài hước, Gia đình, Gián điệp, Hành động, Học đường', 150000, 2022, 100, 'Một bộ phim hài hành động về một gia đình giả gồm một điệp viên, một sát thủ và một nhà ngoại cảm!\n\nĐiệp viên bậc thầy Twilight là vô song khi nói đến việc bí mật thực hiện các nhiệm vụ nguy hiểm vì sự cải thiện của thế giới. Nhưng khi anh nhận được nhiệm vụ cuối cùng - kết hôn và có một đứa con - cuối cùng anh có thể đã quá sức!\n\nAnya Forger đã cố gắng hết sức để kết bạn với Damian Desmond, con trai của nhà lãnh đạo chính trị Ostanian quyền lực Donovan Desmond, nhưng những nỗ lực của cô liên tục bị từ chối. Bất chấp những thất bại, Anya quyết tâm tiếp cận vòng tròn bên trong của Desmonds và thậm chí còn nghĩ ra một kế hoạch mới - vượt qua kỳ thi giữa kỳ để kiếm được sao stella! Liệu Anya có thể thực hiện được kỳ tích này vì hòa bình thế giới không?', 1, '2025-03-21 04:03:40', '2025-04-01 08:23:09', ''),
(71, 'kn8-01', '/images/kn8/kaiju-no-8-01.jpg', 'KAIJU no. 8 01', 'Naoya Matsumoto', 'Siêu nhiên, Hành động, Hài hước, Shounen', 177000, 2021, 100, 'Kafka muốn ở trong Lực lượng Phòng vệ, nhưng thay vào đó, anh ta lại dọn dẹp sau họ. Kaiju No. 8 giống như Chainsaw Man, nhưng không nhiều máu me và có lẽ chỉ ít hơn một chút về sự vô lý. Nó vui, có các nhân vật và quái vật khổng lồ mà bạn muốn có trong manga, và các trận chiến cũng hấp dẫn không kém.\n\nKafka muốn dọn dẹp kaiju, nhưng không phải theo nghĩa đen! Liệu một sự biến đổi đột ngột có cản trở ước mơ của anh không?\n\nVới tỷ lệ xuất hiện kaiju cao nhất thế giới, Nhật Bản không còn xa lạ với những cuộc tấn công của quái vật chết người. Hãy gia nhập Lực lượng Phòng vệ Nhật Bản, một tổ chức quân sự được giao nhiệm vụ vô hiệu hóa kaiju. Kafka Hibino, một người dọn dẹp xác kaiju, luôn mơ ước được gia nhập lực lượng này. Nhưng khi anh có cơ hội khác để đạt được ước mơ thời thơ ấu của mình, anh đã trải qua một sự biến đổi bất ngờ. Làm sao anh có thể chiến đấu với kaiju khi chính anh đã trở thành một kaiju?!\n\nKafka hy vọng một ngày nào đó sẽ giữ được giao ước với người bạn thời thơ ấu Mina để gia nhập Lực lượng Phòng vệ Nhật Bản và chiến đấu bên cạnh cô. Nhưng trong khi cô ra ngoài vô hiệu hóa kaiju với tư cách là đội trưởng Sư đoàn 3, Kafka lại phải dọn dẹp hậu quả của các trận chiến của mình. Khi một thay đổi đột ngột khiến Kafka đủ điều kiện gia nhập Lực lượng Phòng vệ, anh quyết định thử sức với đội một lần nữa. Chỉ có một vấn đề - anh đã lọt vào danh sách vô hiệu hóa của Lực lượng Phòng vệ dưới mật danh Kaiju số 8.', 1, '2025-03-21 04:09:38', '2025-04-01 08:23:14', ''),
(72, 'kn8-02', '/images/kn8/kaiju-no-8-02.jpg', 'KAIJU no. 8 02', 'Naoya Matsumoto', 'Siêu nhiên, Hành động, Hài hước, Shounen', 177000, 2021, 100, 'Một manga chiến đấu khác có thử thách, và hoàn toàn xứng đáng với mỗi con quái vật đã chết. Câu chuyện tiếp tục với sự bất an đang nảy nở của Kafka và sự tháo vát ngày càng tăng của nhóm học viên Lực lượng Phòng vệ tiếp theo.\n\nKafka muốn dọn dẹp kaiju, nhưng không phải theo nghĩa đen! Liệu một sự biến đổi đột ngột có cản trở ước mơ của anh không?\n\nVới tỷ lệ xuất hiện kaiju cao nhất thế giới, Nhật Bản không còn xa lạ với những cuộc tấn công của những con quái vật chết người. Hãy gia nhập Lực lượng Phòng vệ Nhật Bản, một tổ chức quân sự được giao nhiệm vụ vô hiệu hóa kaiju. Kafka Hibino, một người dọn dẹp xác kaiju, luôn mơ ước được gia nhập lực lượng này. Nhưng khi anh có một cơ hội khác để đạt được ước mơ thời thơ ấu của mình, anh đã trải qua một sự biến đổi bất ngờ. Làm sao anh có thể chiến đấu với kaiju khi chính anh đã trở thành một kaiju?!\n\nBài kiểm tra cuối cùng của Lực lượng Phòng vệ đã kết thúc, nhưng những thử thách của các thí sinh vẫn chưa kết thúc. Một kaiju hình người bí ẩn đã hồi sinh một honju đã bị vô hiệu hóa và tấn công Kikoru Shinomiya. Đúng lúc Kikoru dường như đã đến giới hạn, Kafka lao vào bảo vệ cô! Nhưng mục tiêu của kaiju hình người là gì?', 1, '2025-03-21 04:10:15', '2025-04-01 08:23:19', ''),
(73, 'kn8-03', '/images/kn8/kaiju-no-8-03.jpg', 'KAIJU no. 8 03', 'Naoya Matsumoto', 'Siêu nhiên, Hành động, Hài hước, Shounen', 177000, 2021, 100, 'Khoảnh khắc định mệnh! Kafka phải trở thành kaiju thực thụ để cứu bạn bè mình, và giờ thì Defense Corp đang truy đuổi anh. Kafka có thể duy trì được điều này trong bao lâu?\n\nKafka muốn dọn dẹp kaiju, nhưng không phải theo nghĩa đen! Liệu một sự biến đổi đột ngột có cản trở ước mơ của anh không?\n\nVới tỷ lệ xuất hiện kaiju cao nhất thế giới, Nhật Bản không còn xa lạ với những cuộc tấn công của quái vật chết người. Hãy gia nhập Lực lượng Phòng vệ Nhật Bản, một tổ chức quân sự được giao nhiệm vụ vô hiệu hóa kaiju. Kafka Hibino, một người dọn dẹp xác kaiju, luôn mơ ước được gia nhập lực lượng này. Nhưng khi anh có cơ hội khác để đạt được ước mơ thời thơ ấu của mình, anh đã trải qua một sự biến đổi bất ngờ. Làm sao anh có thể chiến đấu với kaiju khi chính anh đã trở thành một kaiju?!\n\nKafka xoay sở để chống lại một kaiju dạng người, giải cứu Iharu và Reno. Nhưng trước khi anh có thể trở lại hình dạng con người, Kafka đã bị các sĩ quan của Lực lượng Phòng vệ phát hiện, và đơn vị vô hiệu hóa - do không ai khác ngoài Phó đội trưởng Hoshina chỉ huy - được cử đến để tiêu diệt anh. Liệu Kafka có thể chống lại các cuộc tấn công của sĩ quan cấp trên mà không tiết lộ danh tính thực sự của mình không?!', 1, '2025-03-21 04:10:36', '2025-04-01 08:23:24', ''),
(74, 'kn8-04', '/images/kn8/kaiju-no-8-04.jpg', 'KAIJU no. 8 04', 'Naoya Matsumoto', 'Siêu nhiên, Hành động, Hài hước, Shounen', 177000, 2021, 100, 'Vẫn bám chặt vào danh tính bí mật của mình là một Kaiju, Kafka gia nhập Lực lượng Phòng vệ khi họ chống lại cuộc tấn công vào căn cứ Tachikawa. Khi trận chiến diễn ra dữ dội, câu hỏi vẫn còn đó—Kafka thực sự có thể làm gì, và khi nào mọi người mới phát hiện ra anh ta là ai?\n\nKafka muốn dọn dẹp kaiju, nhưng không phải theo nghĩa đen! Liệu một sự biến đổi đột ngột có cản trở ước mơ của anh không?\n\nVới tỷ lệ xuất hiện kaiju cao nhất thế giới, Nhật Bản không còn xa lạ với những cuộc tấn công của quái vật chết người. Hãy gia nhập Lực lượng Phòng vệ Nhật Bản, một tổ chức quân sự được giao nhiệm vụ vô hiệu hóa kaiju. Kafka Hibino, một người dọn dẹp xác kaiju, luôn mơ ước được gia nhập lực lượng này. Nhưng khi anh có cơ hội khác để đạt được ước mơ thời thơ ấu của mình, anh đã trải qua một sự biến đổi bất ngờ. Làm sao anh có thể chiến đấu với kaiju khi chính anh đã trở thành một kaiju?!\n\nCuộc đột kích vào căn cứ Tachikawa của Lực lượng Phòng vệ vẫn tiếp tục khi các sĩ quan nỗ lực chống lại yoju. Trong khi đó, Hoshina giải phóng toàn bộ sức mạnh chiến đấu của mình để chiến đấu với daikaiju—kaiju mạnh nhất trong nhóm. Ngay khi trận chiến có vẻ đã kết thúc, daikaiju biến hình và khả năng phát hiện của Kafka phản ứng với nó! Liệu Kafka có tìm ra cách để cứu vãn tình hình mà không tiết lộ bí mật của mình không?', 1, '2025-03-21 04:11:01', '2025-04-01 08:23:31', ''),
(75, 'kn8-05', '/images/kn8/kaiju-no-8-05.jpg', 'KAIJU no. 8 05', 'Naoya Matsumoto', 'Siêu nhiên, Hành động, Hài hước, Shounen', 177000, 2021, 100, 'Kafka đã bị bắt! Và không ai khác chính là Lực lượng Phòng vệ. Không còn nơi nào để đi, anh ta buộc phải chiến đấu với Tổng giám đốc. Quá nhiều hành động, tất cả chỉ trong một bộ manga.\n\nKafka muốn dọn dẹp kaiju, nhưng không phải theo nghĩa đen! Liệu một sự biến đổi đột ngột có cản trở ước mơ của anh không?\n\nVới tỷ lệ xuất hiện kaiju cao nhất thế giới, Nhật Bản không còn xa lạ với những cuộc tấn công của quái vật chết người. Hãy gia nhập Lực lượng Phòng vệ Nhật Bản, một tổ chức quân sự được giao nhiệm vụ vô hiệu hóa kaiju. Kafka Hibino, một người dọn dẹp xác kaiju, luôn mơ ước được gia nhập lực lượng này. Nhưng khi anh có cơ hội khác để đạt được ước mơ thời thơ ấu của mình, anh đã trải qua một sự biến đổi bất ngờ. Làm sao anh có thể chiến đấu với kaiju khi chính anh đã trở thành một kaiju?! Lực lượng\n\nPhòng vệ đã bắt giữ Kafka và có kế hoạch xử lý anh. Kafka cố gắng trình bày vụ việc của mình với Tổng giám đốc Shinomiya, người nắm giữ sức mạnh của Kaiju số 2 hùng mạnh và là người được ca ngợi là mạnh nhất trong lịch sử Lực lượng Phòng vệ. Nhưng khi những lời cầu xin của Kafka không lay chuyển được tổng giám đốc, anh đã phải đối mặt với ông ta trong trận chiến! Hơn nữa, anh bắt đầu mất kiểm soát hình dạng kaiju của mình! Liệu Kafka có thể giữ được trạng thái đó đủ lâu để cứu lấy chính mình không?', 1, '2025-03-21 04:11:21', '2025-04-01 08:23:38', ''),
(76, 'csm-01', '/images/chansawman/chainsaw-man-1.jpg', 'CHAINSAW MAN 01', 'Tatsuki Fujimoto', 'Kinh dị, Hành động, Siêu nhiên', 98000, 2019, 100, 'Nếu một người đàn ông với cánh tay và khuôn mặt là cưa máy không đủ để tạo nên cảm giác chung về bộ phim hoàn hảo mang tên Chainsaw Man, thì hãy xem xét những nhân vật phức tạp đến ngạc nhiên ẩn dưới lớp vỏ bọc cực kỳ thuyết phục của máu me và cảnh tàn sát.\n\nChàng trai trẻ nghèo khổ + ác quỷ cưa máy = Chainsaw Man!\n\nDenji là một thợ săn quỷ nhỏ chỉ cố gắng sống sót trong một thế giới khắc nghiệt. Sau khi bị giết trong khi làm nhiệm vụ, anh được hồi sinh bởi con quỷ cưng Pochita của mình và trở thành một thứ gì đó mới mẻ và nguy hiểm—Chainsaw Man!\n\nDenji là một chàng trai trẻ nghèo, người sẽ làm bất cứ điều gì để kiếm tiền, thậm chí là săn quỷ cùng con quỷ cưng Pochita của mình. Anh là một người đàn ông giản dị với những ước mơ giản dị, chìm đắm dưới một núi nợ. Nhưng cuộc sống buồn bã của anh đã bị đảo lộn một ngày khi anh bị phản bội bởi chính người mà anh tin tưởng. Bây giờ với sức mạnh của một con quỷ bên trong mình, Denji đã trở thành một người đàn ông hoàn toàn mới—Chainsaw Man!', 1, '2025-03-27 12:06:02', '2025-04-01 08:23:43', ''),
(77, 'csm-02', '/images/chansawman/chainsaw-man-2.jpg', 'CHAINSAW MAN 02', 'Tatsuki Fujimoto', 'Kinh dị, Hành động, Siêu nhiên', 88000, 2019, 100, 'Đang đấu tranh với động lực thực sự, Denji vẫn quyết tâm đánh bại Bat Demon và có được thứ mà anh ta mong muốn đến vậy. Nhưng hóa ra—thật sốc—có thể có một sự khóa chặt sâu hơn đối với hạnh phúc của anh ta.\n\nChàng trai trẻ nghèo khổ + quỷ cưa máy = Chainsaw Man!\n\nDenji là một thợ săn quỷ nhỏ chỉ cố gắng sống sót trong một thế giới khắc nghiệt. Sau khi bị giết trong một nhiệm vụ, anh được hồi sinh bởi con quỷ cưng Pochita của mình và trở thành một thứ gì đó mới mẻ và nguy hiểm—Chainsaw Man!\n\nĐể đạt được mục tiêu lớn nhất trong lịch sử loài người—chạm vào ngực—Denji sẽ mạo hiểm mọi thứ trong cuộc chiến chống lại Bat Devil nguy hiểm. Nhưng liệu việc đạt được thứ mình muốn có thực sự khiến anh hạnh phúc không...?', 1, '2025-03-27 12:08:41', '2025-04-01 08:23:49', ''),
(78, 'csm-03', '/images/chansawman/chainsaw-man-3.jpg', 'CHAINSAW MAN 03', 'Tatsuki Fujimoto', 'Kinh dị, Hành động, Siêu nhiên', 90000, 2019, 100, 'Sự tận tụy của Division 4 đã bị thử thách, và Denji lại sử dụng cưa máy. Sự kết hợp giữa phát triển nhân vật và hỗn loạn đẫm máu điên cuồng đã tạo nên sức mạnh cho series.\n\nChàng trai trẻ nghèo khổ + quỷ cưa máy = Chainsaw Man!\n\nDenji là một thợ săn quỷ nhỏ chỉ cố gắng sống sót trong một thế giới khắc nghiệt. Sau khi bị giết trong một nhiệm vụ, anh được hồi sinh bởi con quỷ cưng Pochita của mình và trở thành một thứ gì đó mới mẻ và nguy hiểm—Chainsaw Man!\n\nMột con quỷ bí ẩn đang đòi trái tim của Denji! Nhưng liệu những thợ săn quỷ từ Division 4 có đồng ý với thỏa thuận này để tự cứu mình không? Hay Denji sẽ phải làm những gì Denji làm tốt nhất—biến thành một chiếc cưa máy và cắt nhỏ mọi thứ cản đường mình?!', 1, '2025-03-27 12:09:06', '2025-04-01 08:23:54', ''),
(79, 'csm-04', '/images/chansawman/chainsaw-man-4.jpg', 'CHAINSAW MAN 04', 'Tatsuki Fujimoto', 'Kinh dị, Hành động, Siêu nhiên', 111000, 2019, 100, 'Những kẻ xấu trở nên khá hung dữ khi chúng dùng mọi thứ trừ bồn rửa chén để tấn công trái tim của Denji. Nhưng chắc chắn anh ấy có thể vượt qua với một chút giúp đỡ từ bạn bè (và cưa máy của anh ấy).\n\nChàng trai trẻ nghèo khổ + quỷ cưa máy = Chainsaw Man!\n\nDenji là một thợ săn quỷ nhỏ chỉ cố gắng sống sót trong một thế giới khắc nghiệt. Sau khi bị giết trong một nhiệm vụ, anh được hồi sinh bởi con quỷ cưng Pochita của mình và trở thành một thứ gì đó mới mẻ và nguy hiểm—Chainsaw Man!\n\nDevil Extermination Special Division 4 đang gặp rắc rối nghiêm trọng khi một con quỷ đã cử cả một đội sát thủ đến để lấy trái tim của Denji. Để sống sót sau cuộc tấn công, Denji, Power và Aki sẽ phải trở nên mạnh mẽ hơn. Nhưng liệu Denji có đủ thông minh để học cách kiểm soát sức mạnh quỷ dữ của mình không? Bạn có thể dạy cho một con chó-ác-cưa máy già những mánh khóe mới không?', 1, '2025-03-27 12:09:29', '2025-04-01 08:24:00', ''),
(80, 'csm-05', '/images/chansawman/chainsaw-man-5.jpg', 'CHAINSAW MAN 05', 'Tatsuki Fujimoto', 'Kinh dị, Hành động, Siêu nhiên', 165000, 2019, 93, 'Denji đối mặt với Katana Man sắc bén như dự đoán. Aki đối mặt với Ghost Devil đáng sợ. Đầu lăn, cơ thể bị chẻ đôi, đó là tất cả những gì bạn mong đợi (và yêu thích) về Chainsaw Man khi số lượng xác chết tăng lên.\n\nChàng trai trẻ nghèo khổ + quỷ cưa máy = Chainsaw Man!\n\nDenji là một thợ săn quỷ nhỏ chỉ cố gắng sống sót trong một thế giới khắc nghiệt. Sau khi bị giết trong một nhiệm vụ, anh được hồi sinh bởi con quỷ cưng Pochita của mình và trở thành một thứ gì đó mới mẻ và nguy hiểm—Chainsaw Man!\n\nĐó là Chainsaw đấu với Sword khi trận chiến đẫm máu giành trái tim của Denji nóng lên. Denji sẽ phải làm mọi cách để chống lại đối thủ xảo quyệt này. Và khi bụi lắng xuống, Special Division 4 sẽ vượt qua những mất mát của họ như thế nào?', 1, '2025-03-27 12:09:55', '2025-04-10 03:25:02', ''),
(81, 'bblock-01', '/images/blueblock/blueblock-01.jpg', 'BLUE LOCK 01', 'Muneyuki Kaneshiro,Yusuke Nomura', 'Thể thao, Siêu nhiên, Shounen, Hài hước', 110000, 2021, 99, 'Sau khi giấc mơ bóng đá của mình dường như kết thúc, Isagi được trao cơ hội trở thành tiền đạo giỏi nhất thế giới tại dự án Blue Lock mang tính cách mạng và phi truyền thống. Với động lực nhân vật đáng kinh ngạc, sự căng thẳng không ngừng và rất nhiều kịch tính, bộ truyện tranh này không chỉ dành cho người hâm mộ bóng đá.\n\nMột huấn luyện viên trẻ điên rồ tập hợp các cầu thủ bóng đá từ khắp đất nước để cạnh tranh trong một loạt các thử thách kỳ lạ trong một đấu trường công nghệ cao mà anh ta gọi là Blue Lock. Đây là một trận chiến không có bóng nào bị cấm để trở thành tiền đạo hàng đầu tiếp theo của Nhật Bản, trong bộ truyện tranh Squid Game –gặp–World Cup này, hiện đã có bản in!\n\nAnime sắp ra mắt!\n\nBạn có phải là kẻ ích kỷ nhất thế giới không?\n\nSau thất bại thảm hại tại World Cup 2018, đội tuyển Nhật Bản đang phải vật lộn để tập hợp lại. Nhưng còn thiếu điều gì? Một tiền đạo thực sự. Liên đoàn bóng đá quyết tâm tạo ra một tiền đạo khao khát ghi bàn và chiến thắng, vì vậy Blue Lock — một sân tập khắc nghiệt dành cho 300 cầu thủ trẻ xuất sắc nhất và sáng giá nhất của Nhật Bản — đã được tạo ra. Để sống sót trong trận chiến hoàng gia này, tiền đạo cuối cùng còn trụ lại sẽ phải vượt qua sức mạnh cơ bắp và cái tôi của bất kỳ ai cản đường anh ta!', 1, '2025-03-27 12:26:53', '2025-04-01 08:24:12', ''),
(82, 'bblock-02', '/images/blueblock/blueblock-02.jpg', 'BLUE LOCK 02', 'Muneyuki Kaneshiro,Yusuke Nomura', 'Thể thao, Siêu nhiên, Shounen, Hài hước', 110000, 2021, 99, 'Có thể có chữ \"I\" trong Isagi, nhưng vẫn không có chữ \"I\" trong nhóm, và điều đó rất khó để Đội Z nắm bắt.\n\nMột huấn luyện viên trẻ điên rồ tập hợp các cầu thủ bóng đá từ khắp đất nước để cạnh tranh trong một loạt các thử thách kỳ lạ trong một đấu trường công nghệ cao mà anh ta gọi là Blue Lock. Đây là một trận chiến không có bóng nào bị cấm để trở thành tiền đạo hàng đầu tiếp theo của Nhật Bản, trong bộ truyện tranh Squid Game này –gặp–World Cup, hiện đã có bản in!\n\nAnime đang phát sóng!\n\nBẠN CÓ BẮN KHÔNG NGẠI KHÔNG?\n\nYoichi Isagi, một trong ba trăm cầu thủ bóng đá trung học, đang ở trong Đội Z—nhóm được xếp hạng thấp nhất trong cơ sở đào tạo gây tranh cãi, Blue Lock, nơi mục tiêu là tạo ra tiền đạo giỏi nhất Nhật Bản. Để sống sót qua giải đấu vòng tròn đầu tiên của mình, Đội Z của Isagi sẽ cần tìm cách sử dụng \"vũ khí\" độc đáo của họ, trong khi vật lộn với cuộc đụng độ của những cái tôi. Nhưng Isagi vật lộn để hiểu được điểm mạnh của mình là gì với tư cách là một tiền đạo...', 1, '2025-03-27 12:27:16', '2025-04-01 08:24:21', ''),
(83, 'bblock-03', '/images/blueblock/blueblock-03.jpg', 'BLUE LOCK 03', 'Muneyuki Kaneshiro,Yusuke Nomura', 'Thể thao, Siêu nhiên, Shounen, Hài hước', 120000, 2021, 100, 'Đội Z có thể đang rất phấn khích sau chiến thắng, nhưng khi họ phải đối mặt với nguy cơ thua cuộc tiếp theo, liệu họ có thể tự cứu mình được không?\n\nMột huấn luyện viên trẻ điên rồ tập hợp các cầu thủ bóng đá từ khắp đất nước để tham gia một loạt các thử thách kỳ lạ trong một đấu trường công nghệ cao mà anh ta gọi là Blue Lock. Đây là một trận chiến không có giới hạn để trở thành tiền đạo hàng đầu tiếp theo của Nhật Bản, trong bộ truyện tranh Squid Game –gặp–World Cup này, hiện đã có bản in!\n\nAnime đang phát sóng!\n\nBẠN CÓ THỂ PHÁ VỠ QUÁ KHỨ KHÔNG?\n\nThưởng thức hương vị ngọt ngào của chiến thắng trước Đội Y, Đội Z phấn khích khi đối mặt với đối thủ tiếp theo của họ trong giải đấu vòng tròn lựa chọn đầu tiên—Đội W! Nhưng những vết nứt bắt đầu xuất hiện trong mối quan hệ mong manh của Đội Z, và nỗi sợ hãi bên trong khiến các cầu thủ phải dừng bước trên sân. Trước những át chủ bài mạnh mẽ của Đội W, cặp song sinh Wanima, liệu Đội Z có thể đoàn kết kịp thời để thoát khỏi thất bại?', 1, '2025-03-27 12:27:40', '2025-04-01 08:24:26', ''),
(84, 'bblock-04', '/images/blueblock/blueblock-04.jpg', 'BLUE LOCK 04', 'Muneyuki Kaneshiro,Yusuke Nomura', 'Thể thao, Siêu nhiên, Shounen, Hài hước', 130000, 2021, 100, 'Gặp Nagi. Bạn có thể chưa yêu anh ấy, nhưng bạn sẽ yêu. Ngoài ra, Đội Z đang phải chống chọi với khó khăn (một lần nữa) và tuyệt vọng tìm lại tinh thần đồng đội trước khi tất cả trở về nhà trong sự đau khổ. Tiến lên Isagi!\n\nMột huấn luyện viên trẻ điên rồ tập hợp các cầu thủ bóng đá từ khắp đất nước để tham gia một loạt các thử thách kỳ lạ trong một đấu trường công nghệ cao mà anh ta gọi là Blue Lock. Đây là một trận chiến không có giới hạn để trở thành tiền đạo hàng đầu tiếp theo của Nhật Bản, trong bộ truyện tranh Squid Game –gặp–World Cup này, hiện đã có bản in!\n\nAnime đang phát sóng!\n\nBẠN CÓ CHƠI NẾU BẠN YẾU NHẤT KHÔNG?\n\nĐây là vòng cuối cùng của đợt tuyển chọn đầu tiên và Đội Z cần phải thắng Đội V—đội bất bại của Wing 5—để sống sót! Một mối đe dọa ba bên đang chờ Isagi, bao gồm cả thần đồng Seishiro Nagi, người chỉ mới bắt đầu chơi bóng đá sáu tháng trước. Hơn nữa, Đội Z vẫn còn một người sau sự phản bội tàn bạo của Kuon trong trận đấu trước. Mọi thứ đều bất lợi cho họ khi họ bước vào sân, và Isagi cùng các đồng đội của mình đang nhận ra một cách đau đớn rằng họ thực sự yếu đuối như thế nào. Cuối cùng, liệu tất cả có vô nghĩa không? Hay sự tuyệt vọng sẽ chiến thắng tài năng?', 1, '2025-03-27 12:28:00', '2025-04-01 08:24:31', ''),
(85, 'bblock-05', '/images/blueblock/blueblock-05.jpg', 'BLUE LOCK 05', 'Muneyuki Kaneshiro,Yusuke Nomura', 'Thể thao, Siêu nhiên, Shounen, Hài hước', 150000, 2021, 97, 'Đội Z đã tìm được nhịp điệu của mình, nhưng vẫn còn nhiều việc phải làm nếu họ muốn tránh bị loại sớm.\n\nMột huấn luyện viên trẻ điên rồ tập hợp các cầu thủ bóng đá từ khắp đất nước để cạnh tranh trong một loạt các thử thách kỳ lạ trong một đấu trường công nghệ cao mà anh ta gọi là Blue Lock. Đây là một trận chiến không có bóng nào bị cấm để trở thành tiền đạo hàng đầu tiếp theo của Nhật Bản, trong bộ truyện tranh Squid Game –gặp–World Cup này, hiện đã có bản in!\n\nAnime đang phát sóng!\n\nBẠN CÓ VƯỢT QUA GIỚI HẠN CỦA MÌNH KHÔNG?\nĐối mặt với Đội V, Đội Z đã cố gắng bắt kịp 3-3 khi còn mười lăm phút nữa. Trong bối cảnh căng thẳng này, tất cả các cầu thủ đều tìm kiếm \"sự thức tỉnh\" của họ để đưa kỹ năng của họ lên một tầm cao mới... Họ có thể đánh bại Đội V và đủ điều kiện tham gia lựa chọn tiếp theo không - hay họ sẽ bị mắc kẹt trên sân chơi mà không có nơi nào để đi?', 1, '2025-03-27 12:28:28', '2025-04-05 10:00:38', '');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `name` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `of_fullname` varchar(100) NOT NULL,
  `selected` tinyint(1) DEFAULT 0,
  `loaisach` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chapters`
--

CREATE TABLE `chapters` (
  `chapter_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `chapter_number` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chapters`
--

INSERT INTO `chapters` (`chapter_id`, `name`, `chapter_number`, `title`) VALUES
(2, 'MY HERO ACADEMIA 01', 1, 'Anh hùng thật sự là ai'),
(3, 'MY HERO ACADEMIA 01', 2, 'Thế lực tà ác đang kéo tới'),
(4, 'MY HERO ACADEMIA 02', 1, 'Đối diện với quá khứ gia đình');

-- --------------------------------------------------------

--
-- Table structure for table `chapter_contents`
--

CREATE TABLE `chapter_contents` (
  `content_id` int(11) NOT NULL,
  `chapter_id` int(11) DEFAULT NULL,
  `content` mediumtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chapter_contents`
--

INSERT INTO `chapter_contents` (`content_id`, `chapter_id`, `content`) VALUES
(1, 2, 'Sau khi kỳ thực tập kết thúc, một ngày nắng đẹp và yên bình giữa mùa xuân và mùa hè đánh dấu sự khởi đầu cho quá trình chuẩn bị cho kỳ thi cuối kỳ sắp tới.\n\n“Tiếp theo, Midoriya.”\n\nGiữa một thành phố đổ nát, một giọng nói vô cùng thờ ơ vang lên.\n\nTrên mặt đất của thành phố đổ nát này là giáo viên chủ nhiệm lớp 1-A Aizawa, người đang nhìn lên tầng ba của một tòa nhà với đôi mắt lờ đờ hé ra sau mái tóc dài rối bù. Tòa nhà, vào lúc đó trông có vẻ sắp sụp đổ.\n\n“Vâng, thưa ngài!”\n\nTheo lời gọi của Aizawa, một học sinh mặt mộc với mái tóc rối bù và những đốm tàn nhang khá quyến rũ đứng dậy và trả lời. Có một vẻ hơi lo lắng trên khuôn mặt anh ta.\n\n“Deku-kun, chúc may mắn nhé!”\n\nPhía sau anh, trong hàng ngũ các cô gái, Uraraka Ochako thò đầu ra và cổ vũ anh.\n\n\"Yeah!\" Izuku trả lời khi má cậu ửng hồng vì nụ cười tươi tắn, rạng rỡ của cô. Cậu bước về phía máng trượt nối tầng ba với mặt đất.\n\nChiếc máng trượt dịch chuyển và cong theo sức nặng của anh ta. Đó là một máng thoát hiểm thẳng đứng dùng để di tản. Công cụ này, giống như một chiếc cầu trượt, được dùng để đưa mọi người xuống đất từ ​​các tòa nhà cao tầng.\n\nĐây là UA Academia. Và khoảnh khắc này là giữa giờ học Heroes Fundamentals của Lớp I-A.\n\nUA có rất nhiều bất động sản với nhiều tiện nghi khác nhau. Giống như một sân vận động có thể chứa vô số người. Hoặc USJ, một nơi mà họ có thể luyện tập để ứng phó với thảm họa và tai nạn, nơi mà ký ức về việc bị Liên minh phản diện tấn công vẫn còn mới mẻ. Cảnh quan thị trấn đổ nát này, nơi lớp học được tổ chức cũng là một trong những tổ chức của họ.\n\n* * *\n\n“Những nét kỳ quặc” biểu hiện ở con người vẫn là một điều có lịch sử gần đây hơn.\n\nKhi những khả năng đặc biệt xuất hiện ở từng người một, lúc đầu người ta coi đó là hiện tượng siêu nhiên hoặc phép màu. Nhưng giờ đây 80% dân số có Quirk và nó được coi là bình thường. Tuy nhiên, có rất nhiều người sử dụng năng lực đặc biệt của mình vào mục đích xấu.\n\nTội phạm tăng lên một cách bùng nổ. Dân số rơi vào hỗn loạn. Xã hội sụp đổ.\n\nNhưng sau đó, những người sử dụng khả năng của mình để bảo vệ và đấu tranh cho công lý cũng xuất hiện để chống lại bọn tội phạm.\n\nAnh hùng. Những người cứu giúp kẻ yếu, chống lại áp bức và kiên định đứng về phía công lý. Giấc mơ mà mọi người hằng mong ước đã trở thành hiện thực.\n\nChẳng bao lâu sau, nó trở thành một nghề chuyên nghiệp do được công chúng đón nhận rộng rãi. Cuối cùng, khi số lượng thành công của họ tăng lên, họ đã trở nên nổi tiếng và có thu nhập ổn định từ đất nước.\n\nNhưng không phải ai cũng có thể trở thành anh hùng. Bây giờ cần phải có chứng nhận để làm công việc anh hùng. Về nguyên tắc, việc sử dụng Quirks ở nơi công cộng bị cấm để giữ gìn trật tự.\n\nĐể được đất nước chấp nhận, các anh hùng cần phải có giấy phép chuyên nghiệp để tự do sử dụng Quirks của mình. Sự cần thiết đó đã trở thành nền tảng cho các trường học có khóa học về anh hùng, điều này rất cần thiết để nhận được Giấy phép anh hùng.\n\nVà tất nhiên có cánh cổng hẹp nhất. Rào cản lớn nhất, UA Academia.\n\nVào thời đại này, Izuku được coi là một cá nhân “Không có năng lực” hiếm hoi. Một người không thể trở thành anh hùng vì họ không có năng lực, thường biểu hiện ở tuổi lên bốn. Cùng độ tuổi đó, Izuku đã học được sự thật khắc nghiệt của xã hội.\n\nƯớc mơ trở thành anh hùng số 1 All Might của Izuku dường như rất, rất xa vời.\n\nMặc dù vậy, Izuku không bao giờ từ bỏ. Bất kể ai cười nhạo hay coi thường cậu, bất kể điều đó có bất khả thi đến mức nào, cậu vẫn bám chặt vào ước mơ của mình.\n\nVà đúng lúc mong muốn của Izuku dường như không thể thực hiện được, cậu đã gặp All Might lần đầu tiên, người đã nhận ra phẩm chất của cậu và cho cậu trải qua khóa đào tạo khắc nghiệt để biến cậu thành người kế thừa bí mật năng lực của All Might, \"One For All\".\n\n* * *\n\nMặc dù lúc đầu do thiếu sự thành thạo nên anh đã bị thương nhiều lần, nhưng thông qua cả hai lớp học và sự hướng dẫn của Gran Torino, bậc thầy của All Might, cuối cùng anh đã có thể kiểm soát được một chút.\n\n“Ồ.”\n\nSau khi trải nghiệm cảm giác lơ lửng, Izuku rời khỏi máng trượt và đáp xuống đất rồi đứng dậy.\n\n“Được rồi, mọi người bên phía cậu bé đã xong. Tiếp theo, Yaoyorozu.”\n\n“Vâng, thưa ông.”\n\nLớp phó, Yaoyorozu Momo, trả lời và di chuyển để trượt xuống máng trượt.\n\nTrong khi những người trên mặt đất chờ Yaoyorozu đi xuống, một học sinh thấp bé, đầu tròn tên là Mineta Minoru đang thở hổn hển vì một lý do nào đó.\n\n“Có chuyện gì thế, Mineta-kun?”\n\nTrước câu hỏi của Izuku, hơi thở của Mineta ngày càng trở nên nặng nhọc.\n\n“Midoriya, khi một cô gái trượt cầu trượt, cô ấy nên mặc váy, đúng không! Nhưng tại sao cô ấy lại mặc đồng phục thể dục… Tôi biết tại sao! Bởi vì không có hương vị hay sự hấp dẫn tình dục hay Đức Phật, chết tiệt!”\n\n“Em không bao giờ thay đổi cả, Mineta-chan.”\n\nAsui Tsuyu, người đi xuống sau Yaoyorozu, thẳng thắn bình luận.\n\n“Đúng vậy, Mineta-kun. Sẽ không ổn nếu váy của họ bị thổi tung trong giờ học. Đơn giản là hợp lý hơn khi các cô gái mặc trang phục thể dục dễ di chuyển trong các buổi tập sơ tán… Không, đợi đã. Nếu đây là một cuộc sơ tán thực sự thì váy cũng sẽ được mặc!”\n\n“Không, có lẽ anh đã nhầm về điều đó.”\n\nIzuku cười lo lắng và trả lời người bạn nghiêm túc của mình, Iida Tenya, người đã đi đến một kết luận sai lầm nghiêm trọng. Khi họ lần đầu gặp nhau trong kỳ thi tuyển sinh, Izuku đã nghĩ Iida là một người đáng sợ. Nhưng bây giờ họ là bạn tốt.\n\n\"Đừng cười nữa, đồ Deku khốn nạn.\"\n\nMột giọng nói buồn bã vang lên với Izuku.\n\n“Kacchan…”\n\nNgười bạn thời thơ ấu có phần xa cách của Izuku, Bakugou Katsuki, đang trừng mắt nhìn cậu bằng ánh mắt sắc lẹm.\n\nViệc chửi bới Deku một cách giận dữ là điều xảy ra hàng ngày. Mặc dù so với hồi trung học, số lần cậu ấy lao vào các tình huống một cách liều lĩnh đã giảm xuống. Không nhiều, nhưng khá tốt cho Kacchan.\n\n“Dù sao thì, cái trò di tản chết tiệt này thật là ngu ngốc.”\n\n“Anh đang nói gì thế?! Ưu tiên hàng đầu của tất cả anh hùng luôn là cứu mạng người! Và việc tìm hiểu về các công cụ được sử dụng để cứu mạng người là rất quan trọng. Đây là một lớp học rất quan trọng!”\n\n“Như thể tôi quan tâm. Mọi người được sinh ra cho những thứ khác nhau. Tôi sẽ tiêu diệt tất cả những kẻ xấu và một người khác có thể giải cứu họ và mọi chuyện sẽ ổn thỏa.”\n\n“Cái gì—Anh thực sự muốn trở thành anh hùng sao?!”\n\nMột bên là Iida với ý thức công lý mạnh mẽ. Và bên kia là Bakugou với ý thức tự phụ mạnh mẽ. Hai người cực kỳ không hợp nhau. Izuku vội vã giữ Iida lại trước khi xông tới Bakugou.\n\n“Iida-kun, bình tĩnh nào!”\n\n“Ừm, đúng là anh ta không thích hợp để giải cứu người khác.”\n\nMột người nào đó gần đó lẩm bẩm. Đó là Todoroki Shouto, một nam sinh hấp dẫn với vết sẹo bỏng trên mặt.\n\n“Todoroki-kun?”\n\n“Tôi không thể tưởng tượng được Bakugou sẽ cứu ai đó.”\n\n“…… Anh đã nói cái quái gì với tôi thế?!”\n\n“Ồ vâng, tôi hoàn toàn đồng ý! Anh ta có nhiều khả năng làm họ bị thương hơn!”\n\nKaminari Denki reo lên đồng tình. Bakugou gầm lên, \"Tao sẽ làm mày bị thương trước, đồ khốn!\" khi những vụ nổ bùng nổ từ lòng bàn tay của hắn. Quirk của Bakugou là mồ hôi giống như nitro chảy ra từ lòng bàn tay và phát nổ.\n\nNhững cô gái bước xuống từ máng cứu hộ đều bối rối trước cảnh náo loạn này, còn những cậu bé khác dừng lại tại chỗ để xem toàn bộ cảnh tượng đó.\n\nĐúng lúc tình hình có vẻ như đã mất kiểm soát, một giọng nói nhỏ nhẹ vang lên.\n\n“…… Bạn có biết bây giờ là mấy giờ không?”'),
(2, 3, 'Khi nghe thấy giọng nói của Aizawa vang lên, tất cả học sinh lớp 1-A đều đứng im tại chỗ và đứng thẳng dậy. Aizawa, người yêu với phương châm lý trí, đã trở thành một hiện tượng đáng sợ đối với học sinh trong vài tháng qua. Mặc dù thường tỏ ra thờ ơ, Aizawa vẫn mở to mắt và đôi mắt nhuốm đỏ. Quirk của Aizawa là khả năng khiến Quirk của người khác biến mất bằng cách nhìn chằm chằm vào họ cho đến khi anh chớp mắt lần nữa. Anh được biết đến với cái tên Anh hùng xóa bỏ, Eraserhead. Nhưng vì anh ghét việc tiếp xúc với phương tiện truyền thông và chụp ảnh, nên mức độ nổi tiếng của anh không cao.\n\nCác học sinh im lặng và đôi mắt của Aizawa trở lại trạng thái thờ ơ thường ngày khi ông nói.\n\n\"Cho dù bạn có phù hợp hay không, bạn không thể sử dụng loại lý do đó ngoài thực địa. Làm những gì bạn cần làm là một phần của việc trở thành anh hùng chuyên nghiệp.\"\n\nAizawa nhìn khắp học sinh của mình trong khi nói.\n\n“Khi đội cứu hộ hoặc cảnh sát không thể giúp đỡ, bạn cần đóng vai trò là người hướng dẫn để đưa họ đến nơi trú ẩn.”\n\n“Nếu chúng ta nói về việc sơ tán thì một đội cứu hộ không phải sẽ nhanh hơn sao?”\n\nTrong đám đồng phục thể dục, một ống tay áo trống rỗng duy nhất giơ lên ​​không trung. Ống tay áo của Hagakure Tooru. Rõ ràng là cô ấy đã giơ tay lên. Quirk của Hagakure là vô hình, vì vậy thoạt nhìn có vẻ như bộ đồ thể dục của cô ấy đang lơ lửng giữa không trung.\n\n“Nhưng nếu bạn phải sơ tán một lượng lớn người thì sao?”\n\nTrước câu hỏi trả lời của Yaoyorozu, Aizawa gật đầu nhẹ.\n\n“Đúng vậy. Chỉ cần sơ tán một hoặc hai người thì không khó. Nhưng trong trường hợp có nhiều người thì các công cụ sơ tán mới hữu ích. Và tất nhiên trong những tình huống như vậy, bạn không thể nói rằng bạn không biết cách sử dụng chúng. Đó là lý do tại sao chúng tôi đưa việc sử dụng các công cụ sơ tán vào chương trình giảng dạy. Hiểu chưa, Bakugou?”\n\n\"…… Vâng.\"\n\nBakugou lẩm bẩm đáp lại. Từ anh ấy, đó là sự nhượng bộ lớn nhất mà họ có thể nhận được.\n\nBên cạnh Bakugou, Izuku thở dài nhẹ nhõm và bắt đầu lẩm bẩm một mình.\n\n“Đúng vậy, chẳng phải việc kết hợp các công cụ sơ tán và Quirks với nhau sẽ hữu ích cho việc sơ tán đám đông lớn sao…? Giống như nếu chúng ta sử dụng Zero Gravity của Uraraka-san và Tape của Sero-kun… hoặc với cả Pop Off Quirk của Mineta-kun nữa. Bao gồm cả trong các anh hùng chuyên nghiệp… các biến thể có thể là vô tận…!”\n\nIzuku là một fan cuồng nhiệt của siêu anh hùng, hoàn toàn dành tâm huyết cho việc nghiên cứu siêu anh hùng và mong muốn bản thân mình trở thành một siêu anh hùng.\n\nIzuku có xu hướng lẩm bẩm một mình khi đắm chìm trong suy nghĩ của mình, điều này khiến những người khác lúc đầu bị sốc. Nhưng bây giờ mọi người đều nhìn cậu bằng ánh mắt trìu mến (trừ Bakugou).\n\n“Được rồi, tiếp theo là…”\n\nĐúng lúc đó, giọng nói của Aizawa bị cắt ngang bởi tiếng động cơ gầm rú trên bầu trời. Các học sinh ngạc nhiên nhìn lên và thấy một chiếc trực thăng đang hạ xuống.\n\nTừ trực thăng nhảy ra một người đàn ông có thân hình cơ bắp nổi bật trên nền trời xanh.\n\n“Từ trên trời… Ta đã đến!!”\n\n“All Might?!”\n\nVới một tiếng động lớn, Anh hùng số 1 All Might, với cơ bắp bùng nổ và khí thế oai nghiêm, đáp xuống đất. Mái tóc mái chẻ đôi và hướng lên trời của anh ta đung đưa trong làn gió do trực thăng tạo ra khi anh ta nở một nụ cười với hàm răng trắng như ngọc trai.\n\n“Xin lỗi vì đã đến muộn, các quý ông quý bà trẻ tuổi! Ngay sau khi tôi rời đi, tôi phải bắt một số kẻ xấu!”\n\n“Thành thật mà nói. Ban đầu, anh được giao nhiệm vụ dẫn dắt lớp học.”\n\nKhông giống như Aizawa, người lẩm bẩm một cách bực bội, mắt Izuku sáng lên.\n\n“Tin tức đã đưa rồi! Tôi đã kiểm tra trong giờ nghỉ trưa! Anh đã bắt được bọn cướp ngân hàng, đúng không?!”\n\n“Ồ, còn một vụ việc nữa, nhưng tôi đoán là chưa đưa tin.”\n\n“Ồ… Đúng như mong đợi của All Might!”\n\nIzuku, người không ngừng khao khát những chiến công anh hùng, đã không thể kiểm soát được sự phấn khích của mình.\n\nTrong số tất cả các anh hùng, All Might là người đặc biệt. Với sự hiện diện áp đảo của mình, anh đã một mình ngăn chặn tội phạm ngay tại chỗ.\n\nÔng là người anh hùng được mệnh danh là “Biểu tượng của hòa bình”.\n\nSự thật là All Might đã truyền lại sức mạnh của mình cho Izuku và mối quan hệ thầy trò của họ là một bí mật với phần lớn dân số. Cách All Might thực sự, hình dạng héo úa và thời gian anh có thể dành cho hình dạng anh hùng của mình đang bị rút ngắn cũng là một bí mật.\n\n“Midoriya trẻ tuổi, lời khen của ngươi đối với ta đã đủ rồi. Bây giờ, ta không thể giữ máy bay trực thăng mãi được.”\n\n“Máy bay trực thăng? Không phải chỉ để đưa cô đến đây thôi sao…?”\n\n“Trong trường hợp khẩn cấp, tôi sẽ không chỉ sử dụng để tạo lối vào! Bây giờ, hãy thực hành cứu hộ bằng trực thăng này! BẠN ĐÃ SẴN SÀNG CHƯA?!”\n\n“Đúng như mong đợi của khóa học anh hùng…”\n\nIzuku lẩm bẩm, rất ngạc nhiên và có phần cảm động.\n\nHọc mọi thứ để trở thành anh hùng, đó chính là Khóa học Anh hùng UA.'),
(3, 4, 'Bạn của Deku đã trở về nhà sau bao lâu không về nhưng...');

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `gioHangId` int(11) DEFAULT NULL,
  `sanPham` varchar(255) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `gia` double NOT NULL,
  `loaisach` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `gioHangId`, `sanPham`, `soLuong`, `gia`, `loaisach`) VALUES
(1, 2, 'SHANGRI-LA FRONTIER 05', 1, 170, 'Sách giấy'),
(2, 2, 'SHANGRI-LA FRONTIER 03', 1, 102, 'Sách điện tử'),
(3, 3, 'SHANGRI-LA FRONTIER 01', 1, 102, 'Sách điện tử'),
(4, 4, 'DEMON SLAYER 04', 2, 150000, 'Sách giấy'),
(5, 4, 'MY HERO ACADEMIA 02', 1, 98000, 'Sách giấy'),
(6, 5, 'MY HERO ACADEMIA 01', 1, 126000, 'Sách giấy'),
(7, 5, 'SHANGRI-LA FRONTIER 01', 2, 170000, 'Sách giấy'),
(8, 5, 'DEMON SLAYER 03', 1, 150000, 'Sách giấy'),
(9, 5, 'DEMON SLAYER 02', 1, 150000, 'Sách giấy'),
(10, 6, 'DANDADAN 03', 1, 166000, 'Sách giấy'),
(11, 6, 'MY HERO ACADEMIA 01', 1, 126000, 'Sách giấy'),
(12, 7, 'ONE PIECE 04', 1, 180000, 'Sách giấy'),
(13, 7, 'MY HERO ACADEMIA 05', 1, 99999, 'Sách giấy'),
(14, 7, 'BLUE LOCK 05', 1, 90000, 'Sách điện tử'),
(15, 7, 'SPY x FAMILY 01', 1, 150000, 'Sách giấy'),
(16, 8, 'SHANGRI-LA FRONTIER 01', 1, 170000, 'Sách giấy'),
(17, 9, 'BLUE LOCK 05', 3, 150000, 'Sách giấy'),
(18, 9, 'MY HERO ACADEMIA 01', 1, 126000, 'Sách giấy'),
(19, 10, 'MY HERO ACADEMIA 02', 1, 98000, 'Sách giấy'),
(20, 11, 'SHANGRI-LA FRONTIER 05', 1, 170000, 'Sách giấy'),
(21, 11, 'ONE PIECE 01', 1, 108000, 'Sách điện tử'),
(22, 12, 'JUJUTSU KAISEN 04', 1, 84000, 'Sách điện tử'),
(23, 13, 'MY HERO ACADEMIA 02', 1, 58800, 'Sách điện tử'),
(24, 14, 'MY HERO ACADEMIA 01', 1, 75600, 'Sách điện tử'),
(25, 15, 'MY HERO ACADEMIA 01', 1, 75600, 'Sách điện tử'),
(26, 16, 'MY HERO ACADEMIA 01', 1, 75600, 'Sách điện tử'),
(27, 17, 'MY HERO ACADEMIA 01', 1, 75600, 'Sách điện tử'),
(28, 18, 'MY HERO ACADEMIA 01', 1, 75600, 'Sách điện tử'),
(29, 19, 'MY HERO ACADEMIA 01', 1, 75600, 'Sách điện tử'),
(30, 20, 'MY HERO ACADEMIA 01', 1, 126000, 'Sách giấy'),
(31, 20, 'MY HERO ACADEMIA 02', 1, 58800, 'Sách điện tử'),
(32, 21, 'MY HERO ACADEMIA 01', 1, 75600, 'Sách điện tử'),
(33, 21, 'MY HERO ACADEMIA 02', 1, 75600, 'Sách điện tử'),
(34, 22, 'JUJUTSU KAISEN 03', 1, 140000, 'Sách giấy'),
(35, 23, 'DEMON SLAYER 04', 1, 150000, 'Sách giấy'),
(36, 24, 'SHANGRI-LA FRONTIER 01', 1, 102000, 'Sách điện tử'),
(37, 25, 'DEMON SLAYER 05', 1, 90000, 'Sách điện tử'),
(38, 26, 'MY HERO ACADEMIA 05', 4, 99999, 'Sách giấy'),
(39, 26, 'BLUE LOCK 05', 1, 90000, 'Sách điện tử'),
(40, 26, 'CHAINSAW MAN 05', 3, 150000, 'Sách giấy'),
(41, 26, 'JUJUTSU KAISEN 01', 1, 84000, 'Sách điện tử'),
(42, 26, 'ONE PIECE 04', 2, 140000, 'Sách giấy');

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `nguoiMua` varchar(255) NOT NULL,
  `tongtienhang` double DEFAULT NULL,
  `phivanchuyen` double DEFAULT NULL,
  `voucher` double DEFAULT NULL,
  `thanhtien` double DEFAULT NULL,
  `hinhthucthanhtoan` varchar(100) DEFAULT NULL,
  `thoiGianDatHang` timestamp NOT NULL DEFAULT current_timestamp(),
  `diachi` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`id`, `nguoiMua`, `tongtienhang`, `phivanchuyen`, `voucher`, `thanhtien`, `hinhthucthanhtoan`, `thoiGianDatHang`, `diachi`) VALUES
(2, 'quy', 272000, 80000, -70000, 282000, 'Trực tuyến/Bank', '2025-04-02 07:47:11', ''),
(3, 'trieu', 102000, 0, -10000, 92000, 'Trực tuyến/Bank', '2025-04-02 08:17:55', ''),
(4, 'quy', 398000, 40000, -18000, 420000, 'Trực tuyến/Bank', '2025-04-02 12:41:55', ''),
(5, 'thanh', 766000, 80000, -180000, 666000, 'Khi nhận hàng', '2025-04-02 12:49:16', ''),
(6, 'quy', 292000, 80000, -26000, 346000, 'Trực tuyến/Bank', '2025-04-04 00:36:25', ''),
(7, 'quy', 519999, 40000, 0, 559999, 'Trực tuyến/Bank', '2025-04-04 03:02:05', ''),
(8, 'quy', 170000, 80000, -10000, 240000, 'Khi nhận hàng', '2025-04-04 14:52:54', ''),
(9, 'quy', 576000, 40000, -18000, 598000, 'Trực tuyến/Bank', '2025-04-05 10:00:38', 'fff, ff, Xã Pải Lủng, Huyện Mèo Vạc, Tỉnh Hà Giang'),
(10, 'quy', 98000, 40000, -18000, 120000, 'Trực tuyến/Bank', '2025-04-05 10:01:58', 'fff, ff, Xã Pải Lủng, Huyện Mèo Vạc, Tỉnh Hà Giang'),
(11, 'quy', 278000, 40000, -18000, 300000, 'Trực tuyến/Bank', '2025-04-05 10:07:34', 'fff, ff, Xã Pải Lủng, Huyện Mèo Vạc, Tỉnh Hà Giang'),
(12, 'quy', 84000, 0, 0, 84000, 'Trực tuyến/Bank', '2025-04-05 10:11:54', ''),
(13, 'qui', 58800, 0, -10000, 48800, 'Trực tuyến/Bank', '2025-04-05 14:19:05', ''),
(14, 'quy', 75600, 0, -10000, 65600, 'Trực tuyến/Bank', '2025-04-05 14:33:28', ''),
(15, 'quy', 75600, 0, 0, 75600, 'Trực tuyến/Bank', '2025-04-05 14:43:39', ''),
(16, 'qui', 75600, 0, 0, 75600, 'Trực tuyến/Bank', '2025-04-05 15:16:22', ''),
(17, 'truongnguyen', 75600, 0, -10000, 65600, 'Trực tuyến/Bank', '2025-04-06 10:14:17', ''),
(18, 'truongnguyen', 75600, 0, -10000, 65600, 'Trực tuyến/Bank', '2025-04-06 10:30:38', ''),
(19, 'quy', 75600, 0, 0, 75600, 'Trực tuyến/Bank', '2025-04-07 00:18:21', ''),
(20, 'quy', 184800, 40000, -18000, 206800, 'Trực tuyến/Bank', '2025-04-07 01:00:53', '123a, Ấp 5, Thị trấn Gành Hào, Huyện Đông Hải, Tỉnh Bạc Liêu'),
(21, 'quy', 151200, 0, 0, 151200, 'Trực tuyến/Bank', '2025-04-07 01:09:49', ''),
(22, 'quy', 140000, 40000, -18000, 162000, 'Khi nhận hàng', '2025-04-08 01:16:53', '123a, Ấp 5, Thị trấn Gành Hào, Huyện Đông Hải, Tỉnh Bạc Liêu'),
(23, 'quy', 150000, 40000, -18000, 172000, 'Khi nhận hàng', '2025-04-08 01:20:07', '123a, Ấp 5, Thị trấn Gành Hào, Huyện Đông Hải, Tỉnh Bạc Liêu'),
(24, 'quy', 102000, 0, -10000, 92000, 'Trực tuyến/Bank', '2025-04-08 01:20:31', ''),
(25, 'quy', 90000, 0, 0, 90000, 'Trực tuyến/Bank', '2025-04-08 02:29:05', ''),
(26, 'quy', 1303996, 40000, -18000, 1325996, 'Trực tuyến/Bank', '2025-04-10 03:25:02', '123a, Ấp 5, Thị trấn Gành Hào, Huyện Đông Hải, Tỉnh Bạc Liêu');

-- --------------------------------------------------------

--
-- Table structure for table `libraries`
--

CREATE TABLE `libraries` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `image` varchar(500) DEFAULT NULL,
  `of_username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `libraries`
--

INSERT INTO `libraries` (`id`, `name`, `image`, `of_username`) VALUES
(32, 'MY HERO ACADEMIA 01', '/images/mha/my-hero-academy-01.jpg', 'quy'),
(33, 'MY HERO ACADEMIA 02', '/images/mha/my-hero-academy-02.jpg', 'quy'),
(34, 'SHANGRI-LA FRONTIER 01', '/images/slf/shangri-la-frontier-1.jpg', 'quy'),
(35, 'DEMON SLAYER 05', '/images/kny/kny05.jpg', 'quy'),
(36, 'BLUE LOCK 05', '/images/blueblock/blueblock-05.jpg', 'quy'),
(37, 'JUJUTSU KAISEN 01', '/images/jjk/jujutsu-kaisen-01.jpg', 'quy');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `sender` varchar(50) DEFAULT NULL,
  `receiver` varchar(50) DEFAULT NULL,
  `message` text DEFAULT NULL,
  `timestamp` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `sender`, `receiver`, `message`, `timestamp`) VALUES
(319, 'thanh', 'admin', 'hello', '2025-03-30 16:01:49'),
(320, 'admin', 'thanh', 'bạn cần giúp gì ạ', '2025-03-30 16:03:05'),
(321, 'thanh', 'admin', 'tôi đang gặp vấn đề về đọc sách', '2025-03-30 16:04:44'),
(322, 'quy', 'admin', 'hvjvs', '2025-03-30 16:48:56'),
(323, 'quy', 'admin', 'dvfs', '2025-03-30 16:56:55'),
(324, 'admin', 'quy', 'ok bạn', '2025-03-30 19:47:26'),
(325, 'thien', 'admin', 'chào bạn', '2025-03-30 21:14:33'),
(326, 'admin', 'thien', 'chào đằng ấy', '2025-03-30 21:14:44'),
(327, 'thien', 'admin', 'tôi cần hỗ trợ', '2025-03-30 21:15:01'),
(328, 'thien', 'admin', 'bạn giúp tôi với', '2025-03-30 21:15:14'),
(329, 'quy', 'admin', 'ee', '2025-03-31 11:03:32'),
(330, 'quy', 'admin', 'sfs', '2025-04-02 07:26:14'),
(331, 'admin', 'truongnguyen', 'bhhfg', '2025-04-02 07:28:50'),
(332, 'quy', 'admin', 'Làm sao tôi có thể xem lại các đơn hàng đã đặt?', '2025-04-03 15:45:12'),
(333, 'quy', 'admin', 'Làm sao tôi có thể xem lại các đơn hàng đã đặt?', '2025-04-03 15:45:41'),
(334, 'quy', 'admin', 'Đơn hàng của tôi chừng nào đến?', '2025-04-03 15:45:46'),
(335, 'quy', 'admin', 'Tôi có thể lấy mã giảm giá ở đâu?', '2025-04-03 15:45:58'),
(336, 'quy', 'admin', 'Tôi có thể lấy mã giảm giá ở đâu?', '2025-04-03 18:21:45'),
(337, 'quy', 'admin', 'Hỏi trực tiếp >', '2025-04-03 19:11:35'),
(338, 'quy', 'admin', 'Bao lâu tập mới sẽ có?', '2025-04-03 19:17:18'),
(339, 'admin', 'quy', 'bạn vui lòng cho biết phim bạn muốn hỏi', '2025-04-03 19:18:38'),
(340, 'admin', 'quy', 'fvsv', '2025-04-03 19:18:55'),
(341, 'admin', 'quy', 'sfv', '2025-04-03 19:19:13'),
(342, 'quy', 'admin', 'vsv', '2025-04-03 19:19:19'),
(343, 'admin', 'quy', 'sfdf', '2025-04-03 19:19:48'),
(344, 'admin', 'quy', 'hg', '2025-04-03 19:20:18'),
(345, 'quy', 'admin', 'Tôi có thể đổi mật khẩu ở đâu?', '2025-04-04 07:51:55'),
(346, 'quy', 'admin', 'Làm sao tôi có thể lịch sử đơn hàng?', '2025-04-04 10:01:16'),
(347, 'quy', 'admin', 'bbcn', '2025-04-04 10:01:31'),
(348, 'quy', 'admin', 'Làm sao tôi có thể lịch sử đơn hàng?', '2025-04-08 08:15:18'),
(349, 'admin', 'quy', 'đsd', '2025-04-08 15:46:53'),
(350, 'quy', 'admin', 'vfsvf', '2025-04-08 15:47:36'),
(351, 'quy', 'admin', 'dc', '2025-04-08 15:47:55'),
(352, 'admin', 'quy', 'đac', '2025-04-08 15:47:59'),
(353, 'truongnguyen', 'admin', 'hello hfdvg', '2025-04-08 15:57:17'),
(354, 'quy', 'admin', 'xin chào', '2025-04-10 10:31:24'),
(355, 'quy', 'admin', 'chào bạn', '2025-04-10 10:31:34'),
(356, 'admin', 'quy', 'hello', '2025-04-10 10:31:42'),
(357, 'quy', 'admin', 'Làm sao tôi có thể lưu trang thái đọc?', '2025-04-10 16:03:22');

-- --------------------------------------------------------

--
-- Table structure for table `thongke`
--

CREATE TABLE `thongke` (
  `id` int(11) NOT NULL,
  `soLuongKhachTruyCap` int(11) DEFAULT 0,
  `soLuongSachDuocBan` int(11) DEFAULT 0,
  `doanhThu` double DEFAULT 0,
  `ngayThangNam` varchar(100) DEFAULT NULL,
  `khoangThoiGian` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thongke`
--

INSERT INTO `thongke` (`id`, `soLuongKhachTruyCap`, `soLuongSachDuocBan`, `doanhThu`, `ngayThangNam`, `khoangThoiGian`) VALUES
(14, 5, 2, 500, '01/01/2025', '10:15:30'),
(15, 8, 6, 1200, '02/01/2025', '14:45:20'),
(16, 3, 4, 700, '03/01/2025', '18:30:10'),
(17, 7, 5, 1100, '04/01/2025', '09:20:00'),
(18, 6, 3, 900, '05/01/2025', '11:25:40'),
(19, 10, 7, 1500, '06/01/2025', '15:40:50'),
(20, 4, 3, 800, '07/01/2025', '13:10:10'),
(21, 9, 6, 1300, '08/01/2025', '17:55:25'),
(22, 7, 4, 1100, '09/01/2025', '08:45:30'),
(23, 5, 2, 600, '10/01/2025', '16:20:10'),
(24, 6, 3, 900, '01/02/2025', '11:25:40'),
(25, 7, 5, 1100, '02/02/2025', '16:50:15'),
(26, 4, 2, 600, '03/02/2025', '20:10:05'),
(27, 9, 7, 1400, '04/02/2025', '12:30:50'),
(28, 8, 5, 1200, '05/02/2025', '15:45:25'),
(29, 10, 8, 1700, '06/02/2025', '09:55:40'),
(30, 6, 4, 900, '07/02/2025', '18:15:20'),
(31, 5, 3, 700, '08/02/2025', '14:20:30'),
(32, 9, 6, 1300, '09/02/2025', '07:10:50'),
(33, 8, 4, 1100, '10/02/2025', '21:30:45'),
(34, 7, 5, 1200, '01/03/2025', '10:30:25'),
(35, 5, 2, 600, '02/03/2025', '17:45:40'),
(36, 9, 6, 1400, '03/03/2025', '08:20:30'),
(37, 6, 4, 1000, '04/03/2025', '19:15:20'),
(38, 10, 8, 1800, '05/03/2025', '11:25:55'),
(39, 7, 5, 1300, '06/03/2025', '13:50:40'),
(40, 8, 6, 1500, '07/03/2025', '16:30:10'),
(41, 6, 3, 900, '08/03/2025', '09:45:30'),
(42, 9, 7, 1600, '09/03/2025', '14:10:20'),
(43, 5, 2, 600, '10/03/2025', '20:30:05'),
(44, 6, 3, 900, '11/03/2025', '11:25:40'),
(45, 7, 5, 1100, '12/03/2025', '16:50:15'),
(46, 4, 2, 600, '13/03/2025', '20:10:05'),
(47, 9, 7, 1400, '14/03/2025', '12:30:50'),
(48, 8, 5, 1200, '15/03/2025', '15:45:25'),
(49, 10, 8, 1700, '16/03/2025', '09:55:40'),
(50, 6, 4, 900, '17/03/2025', '18:15:20'),
(51, 5, 3, 700, '18/03/2025', '14:20:30'),
(52, 9, 6, 1300, '19/03/2025', '07:10:50'),
(53, 8, 4, 1100, '20/03/2025', '21:30:45'),
(54, 7, 5, 1200, '21/03/2025', '10:30:25'),
(55, 5, 2, 600, '22/03/2025', '17:45:40'),
(56, 9, 6, 1400, '23/03/2025', '08:20:30'),
(57, 6, 4, 1000, '24/03/2025', '19:15:20'),
(58, 10, 8, 1800, '25/03/2025', '11:25:55'),
(59, 7, 5, 1300, '26/03/2025', '13:50:40'),
(60, 8, 6, 1500, '27/03/2025', '16:30:10'),
(61, 6, 3, 900, '28/03/2025', '09:45:30'),
(62, 3, 3, 799.2, '29/03/2025', '07:58:59'),
(63, 5, 2, 500, '01/01/2023', '10:15:30'),
(64, 8, 6, 1200, '01/02/2023', '14:45:20'),
(65, 3, 4, 700, '01/03/2023', '18:30:10'),
(66, 7, 5, 1100, '01/04/2023', '09:20:00'),
(67, 6, 3, 900, '01/05/2023', '11:25:40'),
(68, 10, 7, 1500, '01/06/2023', '15:40:50'),
(69, 4, 3, 800, '01/07/2023', '13:10:10'),
(70, 9, 6, 1300, '01/08/2023', '17:55:25'),
(71, 7, 4, 1100, '01/09/2023', '08:45:30'),
(72, 5, 2, 600, '01/10/2023', '16:20:10'),
(73, 6, 3, 900, '01/11/2023', '11:25:40'),
(74, 7, 5, 1100, '01/12/2023', '16:50:15'),
(75, 6, 3, 900, '01/01/2024', '10:30:25'),
(76, 7, 5, 1200, '01/02/2024', '14:50:40'),
(77, 4, 2, 600, '01/03/2024', '20:10:05'),
(78, 9, 7, 1400, '01/04/2024', '12:30:50'),
(79, 8, 5, 1200, '01/05/2024', '15:45:25'),
(80, 10, 8, 1700, '01/06/2024', '09:55:40'),
(81, 6, 4, 900, '01/07/2024', '18:15:20'),
(82, 5, 3, 700, '01/08/2024', '14:20:30'),
(83, 9, 6, 1300, '01/09/2024', '07:10:50'),
(84, 8, 4, 1100, '01/10/2024', '21:30:45'),
(85, 7, 5, 1200, '01/11/2024', '10:30:25'),
(86, 5, 2, 600, '01/12/2024', '17:45:40'),
(87, 6, 3, 900, '02/02/2023', '10:15:30'),
(88, 8, 4, 1200, '03/02/2023', '14:20:10'),
(89, 5, 2, 700, '04/02/2023', '09:10:50'),
(90, 7, 5, 1100, '05/02/2023', '13:45:30'),
(91, 6, 3, 800, '06/02/2023', '16:20:25'),
(92, 9, 6, 1400, '07/02/2023', '18:10:40'),
(93, 10, 7, 1500, '08/02/2023', '11:55:15'),
(94, 4, 3, 750, '09/02/2023', '20:30:10'),
(95, 8, 5, 1250, '10/02/2023', '07:40:35'),
(96, 7, 4, 1100, '11/02/2023', '12:15:50'),
(97, 6, 3, 900, '12/02/2023', '08:25:20'),
(98, 5, 2, 600, '13/02/2023', '15:55:45'),
(99, 9, 6, 1350, '14/02/2023', '10:10:30'),
(100, 7, 4, 1100, '15/02/2023', '17:25:10'),
(101, 8, 5, 1200, '16/02/2023', '14:40:20'),
(102, 10, 7, 1600, '17/02/2023', '11:10:50'),
(103, 6, 3, 900, '18/02/2023', '20:55:15'),
(104, 5, 2, 650, '19/02/2023', '07:20:40'),
(105, 9, 6, 1300, '20/02/2023', '13:35:25'),
(106, 8, 4, 1150, '21/02/2023', '09:50:30'),
(107, 7, 5, 1200, '22/02/2023', '18:05:10'),
(108, 6, 3, 800, '23/02/2023', '12:10:50'),
(109, 10, 7, 1550, '24/02/2023', '08:45:20'),
(110, 4, 2, 700, '25/02/2023', '17:30:35'),
(111, 9, 6, 1350, '26/02/2023', '10:20:50'),
(112, 7, 4, 1100, '27/02/2023', '15:40:30'),
(113, 5, 2, 600, '28/02/2023', '11:55:10'),
(114, 7, 4, 1100, '02/03/2023', '14:20:10'),
(115, 6, 3, 900, '03/03/2023', '10:10:50'),
(116, 8, 5, 1200, '04/03/2023', '16:45:30'),
(117, 9, 6, 1400, '05/03/2023', '08:20:25'),
(118, 5, 3, 800, '06/03/2023', '11:10:40'),
(119, 10, 7, 1600, '07/03/2023', '18:55:15'),
(120, 4, 2, 750, '08/03/2023', '12:30:10'),
(121, 9, 6, 1350, '09/03/2023', '07:40:35'),
(122, 6, 3, 900, '10/03/2023', '13:15:50'),
(123, 7, 4, 1100, '11/03/2023', '10:25:20'),
(124, 8, 5, 1250, '12/03/2023', '15:55:45'),
(125, 6, 3, 900, '13/03/2023', '08:10:30'),
(126, 9, 6, 1400, '14/03/2023', '17:25:10'),
(127, 5, 2, 650, '15/03/2023', '14:40:20'),
(128, 10, 7, 1600, '16/03/2023', '11:10:50'),
(129, 4, 2, 750, '17/03/2023', '20:55:15'),
(130, 8, 5, 1200, '18/03/2023', '07:20:40'),
(131, 7, 4, 1100, '19/03/2023', '13:35:25'),
(132, 9, 6, 1300, '20/03/2023', '09:50:30'),
(133, 6, 3, 900, '21/03/2023', '18:05:10'),
(134, 5, 2, 700, '22/03/2023', '12:10:50'),
(135, 9, 6, 1350, '23/03/2023', '08:45:20'),
(136, 7, 4, 1100, '24/03/2023', '17:30:35'),
(137, 10, 7, 1600, '25/03/2023', '10:20:50'),
(138, 6, 3, 900, '26/03/2023', '15:40:30'),
(139, 5, 2, 700, '27/03/2023', '11:55:10'),
(140, 9, 6, 1400, '28/03/2023', '13:30:20'),
(141, 7, 4, 1100, '29/03/2023', '16:45:40'),
(142, 8, 5, 1250, '30/03/2023', '09:15:10'),
(143, 6, 3, 900, '31/03/2023', '18:30:50'),
(144, 8, 5, 1250, '02/04/2023', '14:20:10'),
(145, 7, 4, 1100, '03/04/2023', '10:30:50'),
(146, 9, 6, 1450, '04/04/2023', '16:40:30'),
(147, 5, 2, 700, '05/04/2023', '08:15:25'),
(148, 10, 7, 1600, '06/04/2023', '11:20:40'),
(149, 4, 2, 750, '07/04/2023', '18:55:15'),
(150, 9, 6, 1350, '08/04/2023', '12:30:10'),
(151, 6, 3, 900, '09/04/2023', '07:40:35'),
(152, 8, 5, 1250, '10/04/2023', '13:15:50'),
(153, 7, 4, 1100, '11/04/2023', '10:25:20'),
(154, 5, 2, 750, '12/04/2023', '15:55:45'),
(155, 9, 6, 1400, '13/04/2023', '08:10:30'),
(156, 6, 3, 900, '14/04/2023', '17:25:10'),
(157, 10, 7, 1600, '15/04/2023', '14:40:20'),
(158, 8, 5, 1200, '16/04/2023', '11:10:50'),
(159, 5, 2, 650, '17/04/2023', '20:55:15'),
(160, 9, 6, 1300, '18/04/2023', '07:20:40'),
(161, 7, 4, 1100, '19/04/2023', '13:35:25'),
(162, 10, 7, 1600, '20/04/2023', '09:50:30'),
(163, 6, 3, 900, '21/04/2023', '18:05:10'),
(164, 5, 2, 700, '22/04/2023', '12:10:50'),
(165, 9, 6, 1350, '23/04/2023', '08:45:20'),
(166, 7, 4, 1100, '24/04/2023', '17:30:35'),
(167, 10, 7, 1600, '25/04/2023', '10:20:50'),
(168, 8, 5, 1250, '26/04/2023', '15:40:30'),
(169, 6, 3, 900, '27/04/2023', '11:55:10'),
(170, 9, 6, 1400, '28/04/2023', '13:30:20'),
(171, 7, 4, 1100, '29/04/2023', '16:45:40'),
(172, 5, 2, 750, '30/04/2023', '09:15:10'),
(173, 8, 5, 1300, '02/05/2023', '09:15:20'),
(174, 7, 4, 1100, '03/05/2023', '14:30:40'),
(175, 9, 6, 1400, '04/05/2023', '11:45:10'),
(176, 6, 3, 900, '05/05/2023', '18:20:50'),
(177, 10, 7, 1650, '06/05/2023', '08:10:35'),
(178, 5, 2, 750, '07/05/2023', '12:40:25'),
(179, 9, 6, 1450, '08/05/2023', '16:30:30'),
(180, 7, 4, 1150, '09/05/2023', '10:50:50'),
(181, 6, 3, 950, '10/05/2023', '13:10:20'),
(182, 8, 5, 1250, '11/05/2023', '07:30:15'),
(183, 10, 7, 1700, '12/05/2023', '15:45:40'),
(184, 5, 2, 800, '13/05/2023', '09:20:30'),
(185, 9, 6, 1400, '14/05/2023', '12:15:50'),
(186, 6, 3, 900, '15/05/2023', '17:55:10'),
(187, 7, 4, 1100, '16/05/2023', '11:35:20'),
(188, 10, 7, 1600, '17/05/2023', '14:50:30'),
(189, 8, 5, 1300, '18/05/2023', '09:05:40'),
(190, 9, 6, 1450, '19/05/2023', '18:25:50'),
(191, 6, 3, 950, '20/05/2023', '07:10:30'),
(192, 7, 4, 1150, '21/05/2023', '12:45:20'),
(193, 5, 2, 800, '22/05/2023', '16:20:10'),
(194, 9, 6, 1350, '23/05/2023', '10:30:50'),
(195, 8, 5, 1250, '24/05/2023', '15:10:40'),
(196, 6, 3, 950, '25/05/2023', '11:50:30'),
(197, 10, 7, 1650, '26/05/2023', '08:40:15'),
(198, 7, 4, 1150, '27/05/2023', '14:30:50'),
(199, 9, 6, 1400, '28/05/2023', '12:55:40'),
(200, 5, 2, 800, '29/05/2023', '18:10:30'),
(201, 8, 5, 1300, '30/05/2023', '09:25:20'),
(202, 10, 7, 1700, '31/05/2023', '15:40:50'),
(203, 9, 5, 1400, '02/06/2023', '14:25:40'),
(204, 8, 4, 1200, '03/06/2023', '12:10:50'),
(205, 10, 6, 1550, '04/06/2023', '09:35:20'),
(206, 6, 2, 800, '05/06/2023', '18:45:30'),
(207, 9, 5, 1350, '06/06/2023', '11:20:15'),
(208, 7, 3, 1100, '07/06/2023', '16:30:50'),
(209, 8, 4, 1250, '08/06/2023', '07:55:40'),
(210, 10, 6, 1600, '09/06/2023', '13:20:25'),
(211, 6, 2, 900, '10/06/2023', '10:45:30'),
(212, 9, 5, 1350, '11/06/2023', '15:10:40'),
(213, 7, 3, 1050, '12/06/2023', '08:25:30'),
(214, 8, 4, 1200, '13/06/2023', '12:50:10'),
(215, 10, 6, 1550, '14/06/2023', '17:15:20'),
(216, 6, 2, 850, '15/06/2023', '14:30:45'),
(217, 9, 5, 1400, '16/06/2023', '11:55:10'),
(218, 7, 3, 1100, '17/06/2023', '09:10:20'),
(219, 8, 4, 1250, '18/06/2023', '16:40:30'),
(220, 10, 6, 1650, '19/06/2023', '13:05:50'),
(221, 6, 2, 800, '20/06/2023', '07:30:15'),
(222, 9, 5, 1350, '21/06/2023', '18:50:25'),
(223, 7, 3, 1100, '22/06/2023', '10:20:30'),
(224, 8, 4, 1200, '23/06/2023', '14:45:40'),
(225, 10, 6, 1550, '24/06/2023', '12:35:50'),
(226, 6, 2, 850, '25/06/2023', '09:55:30'),
(227, 9, 5, 1400, '26/06/2023', '15:25:20'),
(228, 7, 3, 1100, '27/06/2023', '08:40:10'),
(229, 8, 4, 1250, '28/06/2023', '17:10:45'),
(230, 10, 6, 1650, '29/06/2023', '11:50:30'),
(231, 6, 2, 800, '30/06/2023', '14:30:20'),
(232, 8, 3, 1100, '02/07/2023', '09:30:20'),
(233, 9, 4, 1200, '03/07/2023', '10:15:30'),
(234, 8, 3, 1150, '04/07/2023', '11:05:20'),
(235, 10, 5, 1500, '05/07/2023', '12:30:40'),
(236, 7, 3, 1050, '06/07/2023', '13:45:10'),
(237, 9, 4, 1300, '07/07/2023', '14:20:30'),
(238, 8, 3, 1100, '08/07/2023', '15:10:20'),
(239, 10, 5, 1500, '09/07/2023', '09:50:40'),
(240, 7, 3, 1050, '10/07/2023', '10:30:20'),
(241, 9, 4, 1300, '11/07/2023', '11:15:50'),
(242, 8, 3, 1150, '12/07/2023', '12:05:30'),
(243, 10, 5, 1500, '13/07/2023', '13:40:20'),
(244, 7, 3, 1050, '14/07/2023', '14:25:30'),
(245, 9, 4, 1300, '15/07/2023', '15:10:40'),
(246, 8, 3, 1100, '16/07/2023', '16:05:20'),
(247, 10, 5, 1500, '17/07/2023', '09:30:10'),
(248, 7, 3, 1050, '18/07/2023', '10:20:40'),
(249, 9, 4, 1300, '19/07/2023', '11:15:30'),
(250, 8, 3, 1100, '20/07/2023', '12:25:20'),
(251, 10, 5, 1500, '21/07/2023', '13:30:40'),
(252, 7, 3, 1050, '22/07/2023', '14:40:20'),
(253, 9, 4, 1300, '23/07/2023', '15:50:30'),
(254, 8, 3, 1100, '24/07/2023', '16:55:20'),
(255, 10, 5, 1500, '25/07/2023', '09:15:10'),
(256, 7, 3, 1050, '26/07/2023', '10:05:20'),
(257, 9, 4, 1300, '27/07/2023', '11:00:30'),
(258, 8, 3, 1100, '28/07/2023', '12:10:40'),
(259, 10, 5, 1500, '29/07/2023', '13:20:50'),
(260, 7, 3, 1050, '30/07/2023', '14:30:10'),
(261, 9, 4, 1300, '31/07/2023', '15:40:20'),
(262, 8, 3, 1100, '02/08/2023', '09:35:20'),
(263, 10, 5, 1500, '03/08/2023', '10:25:30'),
(264, 7, 3, 1050, '04/08/2023', '11:15:40'),
(265, 9, 4, 1300, '05/08/2023', '12:05:20'),
(266, 8, 3, 1100, '06/08/2023', '13:40:30'),
(267, 10, 5, 1500, '07/08/2023', '14:20:10'),
(268, 7, 3, 1050, '08/08/2023', '15:10:50'),
(269, 9, 4, 1300, '09/08/2023', '09:50:30'),
(270, 8, 3, 1150, '10/08/2023', '10:30:20'),
(271, 10, 5, 1500, '11/08/2023', '11:15:40'),
(272, 7, 3, 1050, '12/08/2023', '12:05:20'),
(273, 9, 4, 1300, '13/08/2023', '13:40:30'),
(274, 8, 3, 1100, '14/08/2023', '14:20:10'),
(275, 10, 5, 1500, '15/08/2023', '15:10:50'),
(276, 7, 3, 1050, '16/08/2023', '09:50:30'),
(277, 9, 4, 1300, '17/08/2023', '10:30:20'),
(278, 8, 3, 1100, '18/08/2023', '11:15:40'),
(279, 10, 5, 1500, '19/08/2023', '12:05:20'),
(280, 7, 3, 1050, '20/08/2023', '13:40:30'),
(281, 9, 4, 1300, '21/08/2023', '14:20:10'),
(282, 8, 3, 1100, '22/08/2023', '15:10:50'),
(283, 10, 5, 1500, '23/08/2023', '09:50:30'),
(284, 7, 3, 1050, '24/08/2023', '10:30:20'),
(285, 9, 4, 1300, '25/08/2023', '11:15:40'),
(286, 8, 3, 1100, '26/08/2023', '12:05:20'),
(287, 10, 5, 1500, '27/08/2023', '13:40:30'),
(288, 7, 3, 1050, '28/08/2023', '14:20:10'),
(289, 9, 4, 1300, '29/08/2023', '15:10:50'),
(290, 8, 3, 1100, '30/08/2023', '09:50:30'),
(291, 10, 5, 1500, '31/08/2023', '10:30:20'),
(292, 8, 3, 1100, '02/09/2023', '09:40:20'),
(293, 10, 5, 1500, '03/09/2023', '10:20:30'),
(294, 7, 3, 1050, '04/09/2023', '11:10:40'),
(295, 9, 4, 1300, '05/09/2023', '12:00:20'),
(296, 8, 3, 1100, '06/09/2023', '12:50:30'),
(297, 10, 5, 1500, '07/09/2023', '13:40:20'),
(298, 7, 3, 1050, '08/09/2023', '14:30:30'),
(299, 9, 4, 1300, '09/09/2023', '15:20:20'),
(300, 8, 3, 1100, '10/09/2023', '09:50:30'),
(301, 10, 5, 1500, '11/09/2023', '10:40:20'),
(302, 7, 3, 1050, '12/09/2023', '11:30:30'),
(303, 9, 4, 1300, '13/09/2023', '12:20:20'),
(304, 8, 3, 1100, '14/09/2023', '13:10:30'),
(305, 10, 5, 1500, '15/09/2023', '14:00:20'),
(306, 7, 3, 1050, '16/09/2023', '14:50:30'),
(307, 9, 4, 1300, '17/09/2023', '15:40:20'),
(308, 8, 3, 1100, '18/09/2023', '09:50:30'),
(309, 10, 5, 1500, '19/09/2023', '10:40:20'),
(310, 7, 3, 1050, '20/09/2023', '11:30:30'),
(311, 9, 4, 1300, '21/09/2023', '12:20:20'),
(312, 8, 3, 1100, '22/09/2023', '13:10:30'),
(313, 10, 5, 1500, '23/09/2023', '14:00:20'),
(314, 7, 3, 1050, '24/09/2023', '14:50:30'),
(315, 9, 4, 1300, '25/09/2023', '15:40:20'),
(316, 8, 3, 1100, '26/09/2023', '09:50:30'),
(317, 10, 5, 1500, '27/09/2023', '10:40:20'),
(318, 7, 3, 1050, '28/09/2023', '11:30:30'),
(319, 9, 4, 1300, '29/09/2023', '12:20:20'),
(320, 8, 3, 1100, '30/09/2023', '13:10:30'),
(321, 8, 3, 1100, '02/10/2023', '09:45:20'),
(322, 10, 5, 1500, '03/10/2023', '10:35:30'),
(323, 7, 3, 1050, '04/10/2023', '11:25:40'),
(324, 9, 4, 1300, '05/10/2023', '12:15:20'),
(325, 8, 3, 1100, '06/10/2023', '13:05:30'),
(326, 10, 5, 1500, '07/10/2023', '13:55:20'),
(327, 7, 3, 1050, '08/10/2023', '14:45:30'),
(328, 9, 4, 1300, '09/10/2023', '15:35:20'),
(329, 8, 3, 1100, '10/10/2023', '09:45:30'),
(330, 10, 5, 1500, '11/10/2023', '10:35:20'),
(331, 7, 3, 1050, '12/10/2023', '11:25:30'),
(332, 9, 4, 1300, '13/10/2023', '12:15:20'),
(333, 8, 3, 1100, '14/10/2023', '13:05:30'),
(334, 10, 5, 1500, '15/10/2023', '13:55:20'),
(335, 7, 3, 1050, '16/10/2023', '14:45:30'),
(336, 9, 4, 1300, '17/10/2023', '15:35:20'),
(337, 8, 3, 1100, '18/10/2023', '09:45:30'),
(338, 10, 5, 1500, '19/10/2023', '10:35:20'),
(339, 7, 3, 1050, '20/10/2023', '11:25:30'),
(340, 9, 4, 1300, '21/10/2023', '12:15:20'),
(341, 8, 3, 1100, '22/10/2023', '13:05:30'),
(342, 10, 5, 1500, '23/10/2023', '13:55:20'),
(343, 7, 3, 1050, '24/10/2023', '14:45:30'),
(344, 9, 4, 1300, '25/10/2023', '15:35:20'),
(345, 8, 3, 1100, '26/10/2023', '09:45:30'),
(346, 10, 5, 1500, '27/10/2023', '10:35:20'),
(347, 7, 3, 1050, '28/10/2023', '11:25:30'),
(348, 9, 4, 1300, '29/10/2023', '12:15:20'),
(349, 8, 3, 1100, '30/10/2023', '13:05:30'),
(350, 10, 5, 1500, '31/10/2023', '13:55:20'),
(351, 8, 3, 1100, '02/11/2023', '09:50:20'),
(352, 10, 5, 1500, '03/11/2023', '10:40:30'),
(353, 7, 3, 1050, '04/11/2023', '11:30:40'),
(354, 9, 4, 1300, '05/11/2023', '12:20:20'),
(355, 8, 3, 1100, '06/11/2023', '13:10:30'),
(356, 10, 5, 1500, '07/11/2023', '14:00:20'),
(357, 7, 3, 1050, '08/11/2023', '14:50:30'),
(358, 9, 4, 1300, '09/11/2023', '15:40:20'),
(359, 8, 3, 1100, '10/11/2023', '09:50:30'),
(360, 10, 5, 1500, '11/11/2023', '10:40:20'),
(361, 7, 3, 1050, '12/11/2023', '11:30:30'),
(362, 9, 4, 1300, '13/11/2023', '12:20:20'),
(363, 8, 3, 1100, '14/11/2023', '13:10:30'),
(364, 10, 5, 1500, '15/11/2023', '14:00:20'),
(365, 7, 3, 1050, '16/11/2023', '14:50:30'),
(366, 9, 4, 1300, '17/11/2023', '15:40:20'),
(367, 8, 3, 1100, '18/11/2023', '09:50:30'),
(368, 10, 5, 1500, '19/11/2023', '10:40:20'),
(369, 7, 3, 1050, '20/11/2023', '11:30:30'),
(370, 9, 4, 1300, '21/11/2023', '12:20:20'),
(371, 8, 3, 1100, '22/11/2023', '13:10:30'),
(372, 10, 5, 1500, '23/11/2023', '14:00:20'),
(373, 7, 3, 1050, '24/11/2023', '14:50:30'),
(374, 9, 4, 1300, '25/11/2023', '15:40:20'),
(375, 8, 3, 1100, '26/11/2023', '09:50:30'),
(376, 10, 5, 1500, '27/11/2023', '10:40:20'),
(377, 7, 3, 1050, '28/11/2023', '11:30:30'),
(378, 9, 4, 1300, '29/11/2023', '12:20:20'),
(379, 8, 3, 1100, '30/11/2023', '13:10:30'),
(380, 8, 3, 1100, '02/12/2023', '09:55:20'),
(381, 10, 5, 1500, '03/12/2023', '10:45:30'),
(382, 7, 3, 1050, '04/12/2023', '11:35:40'),
(383, 9, 4, 1300, '05/12/2023', '12:25:20'),
(384, 8, 3, 1100, '06/12/2023', '13:15:30'),
(385, 10, 5, 1500, '07/12/2023', '14:05:20'),
(386, 7, 3, 1050, '08/12/2023', '14:55:30'),
(387, 9, 4, 1300, '09/12/2023', '15:45:20'),
(388, 8, 3, 1100, '10/12/2023', '09:55:30'),
(389, 10, 5, 1500, '11/12/2023', '10:45:20'),
(390, 7, 3, 1050, '12/12/2023', '11:35:30'),
(391, 9, 4, 1300, '13/12/2023', '12:25:20'),
(392, 8, 3, 1100, '14/12/2023', '13:15:30'),
(393, 10, 5, 1500, '15/12/2023', '14:05:20'),
(394, 7, 3, 1050, '16/12/2023', '14:55:30'),
(395, 9, 4, 1300, '17/12/2023', '15:45:20'),
(396, 8, 3, 1100, '18/12/2023', '09:55:30'),
(397, 10, 5, 1500, '19/12/2023', '10:45:20'),
(398, 7, 3, 1050, '20/12/2023', '11:35:30'),
(399, 9, 4, 1300, '21/12/2023', '12:25:20'),
(400, 8, 3, 1100, '22/12/2023', '13:15:30'),
(401, 10, 5, 1500, '23/12/2023', '14:05:20'),
(402, 7, 3, 1050, '24/12/2023', '14:55:30'),
(403, 9, 4, 1300, '25/12/2023', '15:45:20'),
(404, 8, 3, 1100, '26/12/2023', '09:55:30'),
(405, 10, 5, 1500, '27/12/2023', '10:45:20'),
(406, 7, 3, 1050, '28/12/2023', '11:35:30'),
(407, 9, 4, 1300, '29/12/2023', '12:25:20'),
(408, 8, 3, 1100, '30/12/2023', '13:15:30'),
(409, 10, 5, 1500, '31/12/2023', '14:05:20'),
(410, 3, 4, 2812.3999999999996, '30/03/2025', '16:10:07'),
(411, 3, 2, 458, '31/03/2025', '09:25:41'),
(414, 1, 5, 1965120, '02/04/2025', '07:18:27'),
(415, 2, 0, 0, '03/04/2025', '16:43:16'),
(416, 1, 3, 1145999, '04/04/2025', '07:15:25'),
(417, 1, 3, 1433200, '05/04/2025', '15:42:35'),
(418, 1, 0, 131200, '06/04/2025', '17:13:49'),
(419, 1, 1, 433600, '07/04/2025', '07:17:58'),
(420, 1, 2, 516000, '08/04/2025', '08:14:42'),
(421, 1, 0, 0, '09/04/2025', '14:46:11'),
(422, 1, 2, 1325996, '10/04/2025', '09:47:33');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id_auto`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `chapters`
--
ALTER TABLE `chapters`
  ADD PRIMARY KEY (`chapter_id`),
  ADD KEY `name` (`name`);

--
-- Indexes for table `chapter_contents`
--
ALTER TABLE `chapter_contents`
  ADD PRIMARY KEY (`content_id`),
  ADD KEY `chapter_id` (`chapter_id`);

--
-- Indexes for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gioHangId` (`gioHangId`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `libraries`
--
ALTER TABLE `libraries`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `thongke`
--
ALTER TABLE `thongke`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id_auto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- AUTO_INCREMENT for table `chapters`
--
ALTER TABLE `chapters`
  MODIFY `chapter_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `chapter_contents`
--
ALTER TABLE `chapter_contents`
  MODIFY `content_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `libraries`
--
ALTER TABLE `libraries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=358;

--
-- AUTO_INCREMENT for table `thongke`
--
ALTER TABLE `thongke`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=423;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chapters`
--
ALTER TABLE `chapters`
  ADD CONSTRAINT `chapters_ibfk_1` FOREIGN KEY (`name`) REFERENCES `books` (`name`) ON DELETE CASCADE;

--
-- Constraints for table `chapter_contents`
--
ALTER TABLE `chapter_contents`
  ADD CONSTRAINT `chapter_contents_ibfk_1` FOREIGN KEY (`chapter_id`) REFERENCES `chapters` (`chapter_id`) ON DELETE CASCADE;

--
-- Constraints for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `chitietdonhang_ibfk_1` FOREIGN KEY (`gioHangId`) REFERENCES `donhang` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
