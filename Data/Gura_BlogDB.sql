use master
go

---Tạo blogs database
create database Gura_BlogDB

go
use Gura_BlogDB
go
/****** Object:  Table [dbo].[Categories]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[category_id] [nvarchar](10) NOT NULL,
	[category_name] [nvarchar](20) NOT NULL,
 CONSTRAINT [Categories_PK] PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comments]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comments](
	[comment_id] [nvarchar](15) NOT NULL,
	[user_id] [nvarchar](12) NOT NULL,
	[comment_detail] [text] NOT NULL,
	[comment_create_date] [date] NOT NULL,
	[comment_create_time] [time](0) NOT NULL,
	[comment_parent_id] [nvarchar](30) NULL,
	[post_id] [nvarchar](10) NOT NULL,
 CONSTRAINT [Comments_PK] PRIMARY KEY CLUSTERED 
(
	[comment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Images]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Images](
	[post_id] [nvarchar](10) NOT NULL,
	[img_filename] [nvarchar](200) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Messages]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Messages](
	[message_id] [nvarchar](20) NOT NULL,
	[message_detail] [text] NOT NULL,
	[user_send_name] [nvarchar](100) NOT NULL,
	[user_send_email] [nvarchar](200) NOT NULL,
 CONSTRAINT [Messages_PK] PRIMARY KEY CLUSTERED 
(
	[message_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Posts]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Posts](
	[post_id] [nvarchar](10) NOT NULL,
	[post_title] [nvarchar](100) NOT NULL,
	[topic_id] [nvarchar](10) NOT NULL,
	[post_create_date] [date] NOT NULL,
	[post_create_time] [time](7) NOT NULL,
	[post_body] [nvarchar](4000) NOT NULL,
	[post_author_id] [nvarchar](12) NOT NULL,
 CONSTRAINT [Posts_PK] PRIMARY KEY CLUSTERED 
(
	[post_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PostTag]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PostTag](
	[post_id] [nvarchar](10) NOT NULL,
	[tag_id] [nvarchar](10) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[role_id] [nvarchar](12) NOT NULL,
	[role_name] [nvarchar](12) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tags]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tags](
	[tag_id] [nvarchar](10) NOT NULL,
	[tag_name] [nvarchar](20) NOT NULL,
 CONSTRAINT [Tags_PK] PRIMARY KEY CLUSTERED 
(
	[tag_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Topics]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Topics](
	[topic_id] [nvarchar](10) NOT NULL,
	[topic_name] [nvarchar](30) NOT NULL,
	[category_id] [nvarchar](10) NOT NULL,
 CONSTRAINT [Topics_PK] PRIMARY KEY CLUSTERED 
(
	[topic_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserRole]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRole](
	[user_id] [nvarchar](12) NOT NULL,
	[role_id] [nvarchar](12) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 10/28/2022 12:11:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[user_id] [nvarchar](12) NOT NULL,
	[user_account] [nvarchar](50) NOT NULL,
	[user_email] [nvarchar](200) NOT NULL,
	[user_password] [nvarchar](50) NOT NULL,
	[user_create_date] [date] NOT NULL,
	[user_create_time] [time](0) NOT NULL,
	[user_firstname] [nvarchar](100) NULL,
	[user_lastname] [nvarchar](100) NULL,
	[user_gender] [bit] NULL,
	[user_dateofbirth] [date] NULL,
	[user_phone] [nvarchar](13) NULL,
	[user_address] [nvarchar](200) NULL,
	[user_avatar] [nvarchar](100) NULL,
	[user_about] [nvarchar](1000) NULL,
 CONSTRAINT [Users_PK] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Categories] ([category_id], [category_name]) VALUES (N'234', N'nhẹ nhàng')
INSERT [dbo].[Categories] ([category_id], [category_name]) VALUES (N'326', N'Anime')
INSERT [dbo].[Categories] ([category_id], [category_name]) VALUES (N'335', N'văn hoá')
INSERT [dbo].[Categories] ([category_id], [category_name]) VALUES (N'435', N'Dien anh')
INSERT [dbo].[Categories] ([category_id], [category_name]) VALUES (N'873', N'Lập trình')
INSERT [dbo].[Categories] ([category_id], [category_name]) VALUES (N'892', N'vui choi')
INSERT [dbo].[Categories] ([category_id], [category_name]) VALUES (N'904', N'thể thao')
GO
INSERT [dbo].[Images] ([post_id], [img_filename]) VALUES (N'9849293133', N'Ghien-review-Chua-va-Ngot-Sweet-and-Sour-01-min.jpg')
INSERT [dbo].[Images] ([post_id], [img_filename]) VALUES (N'6546378952', N'Ghien-review-Chua-va-Ngot-Sweet-and-Sour-01-min.jpg')
INSERT [dbo].[Images] ([post_id], [img_filename]) VALUES (N'7652987352', N'Ghien-review-Time-to-hunt-01-1024x574.jpg')
INSERT [dbo].[Images] ([post_id], [img_filename]) VALUES (N'6578935462', N'Ghien-review-Minions-2022-02.jpg')
INSERT [dbo].[Images] ([post_id], [img_filename]) VALUES (N'5849353726', N'Ghienreview-Nguoi-moi-gioi-03-min.jpg')
INSERT [dbo].[Images] ([post_id], [img_filename]) VALUES (N'9634246234', N'Ghienreview-Nguoi-khoi-lua-01-min-1536x1024.jpg')
INSERT [dbo].[Images] ([post_id], [img_filename]) VALUES (N'6429735302', N'Ghien-review-Chua-va-Ngot-Sweet-and-Sour-01-min.jpg')
INSERT [dbo].[Images] ([post_id], [img_filename]) VALUES (N'1467165618', N'Ghien-review-Chua-va-Ngot-Sweet-and-Sour-01-min.jpg')
GO
INSERT [dbo].[Posts] ([post_id], [post_title], [topic_id], [post_create_date], [post_create_time], [post_body], [post_author_id]) VALUES (N'1467165618', N'Review phim Sonic 3 2022- Màn team up thú vị của Sonic', N'3542', CAST(N'2022-10-27' AS Date), CAST(N'18:55:18.5740000' AS Time), N'sdasfsdf', N'42352521')
INSERT [dbo].[Posts] ([post_id], [post_title], [topic_id], [post_create_date], [post_create_time], [post_body], [post_author_id]) VALUES (N'5849353726', N'Review phim Người môi giới: Lời động viên đến những người bất hạnh', N'6833', CAST(N'2022-04-11' AS Date), CAST(N'12:21:00' AS Time), N'Người môi giới (tựa tiếng Anh: Broker) là bộ phim Hàn Quốc gây được sự chú ý của khán giả trong và ngoài nước khi phim xuất sắc giành được giải nam chính xuất sắc nhất trong liên hoan phim Cannes 2022. Phim được khởi chiếu ở Việt Nam vào tuần cuối của tháng sáu nhưng với đụng lịch với nhiều bom tấn Việt Nam và nước ngoài nên dường như người xem ít quan tâm đến phim hơn các phim khác. Đối với Ghiền review, Người môi giới không phải là một bộ phim hay nhưng là một tác phẩm điện ảnh thực sự đáng xem với thông điệp cực kỳ ý nghĩa. Hãy cùng Ghiền review phim Người môi giới để tìm hiểu vì sao mình lại nhận xét như vậy về phim nhé!', N'42352521')
INSERT [dbo].[Posts] ([post_id], [post_title], [topic_id], [post_create_date], [post_create_time], [post_body], [post_author_id]) VALUES (N'6429735302', N'Review phim Sonic 2 2022- Màn team up thú vị của Sonic', N'2435', CAST(N'2022-10-27' AS Date), CAST(N'18:49:00.3120000' AS Time), N'dgfdgfdgdf', N'42352521')
INSERT [dbo].[Posts] ([post_id], [post_title], [topic_id], [post_create_date], [post_create_time], [post_body], [post_author_id]) VALUES (N'6546378952', N'Review phim Chua và Ngọt: Chuyện tình yêu hiện đại không như ta tưởng', N'6345', CAST(N'2022-04-15' AS Date), CAST(N'12:21:00' AS Time), N'Sweet & Sour (Tựa tiếng Việt: Chua và Ngọt) là bộ phim tình cảm đến từ điện ảnh Hàn Quốc không được quảng bá mạnh mẽ nhưng dù mới ra mắt phim đã lọt vào top những phim được xem nhiều nhất trên Netflix Việt Nam. Câu chuyện của bộ phim này thực sự rất gần gũi và lột tả trọn vẹn mọi khía cạnh của tình yêu thời hiện đại với nhiều tình tiết bất ngờ thú vị. Hãy cùng Ghiền review phim Chua và Ngọt để tìm hiểu lý do vì sao phim lại được yêu thích đến thế các bạn nhé!', N'42352521')
INSERT [dbo].[Posts] ([post_id], [post_title], [topic_id], [post_create_date], [post_create_time], [post_body], [post_author_id]) VALUES (N'6578935462', N'Review phim Minions (2022) – Sự trỗi dậy của Gru: Vui nhưng chóng quên', N'6345', CAST(N'2022-04-12' AS Date), CAST(N'12:21:00' AS Time), N'Minions có lẽ là nhân vật hoạt hình thành công nhất của hãng Universal khi trở thành biểu tượng của hãng phim này và độ phủ sóng khắp toàn cầu, thậm chí còn nổi hơn nhân vật chính Gru của seri phim Kẻ cắp mặt trăng. Ở Việt Nam, độ yêu thích nhân vật Minions cực kỳ lớn nên dễ hiểu vì sao phần phim hoạt hình riêng về những tên tay sai da vàng mặc áo yếm này lại tạo nên kỷ lục phòng vé, sánh ngang với các bom tấn của Marvel luôn. Hãy cùng Ghiền review phim Minions (2022) – Sự trỗi dậy của Gru để xem thử phim có gì hấp dẫn mà lại mang về thành công như vậy các bạn nhé!', N'42352521')
INSERT [dbo].[Posts] ([post_id], [post_title], [topic_id], [post_create_date], [post_create_time], [post_body], [post_author_id]) VALUES (N'7652987352', N'Review phim Giờ săn đã điểm – Time to hunt (2020)', N'2435', CAST(N'2022-09-30' AS Date), CAST(N'12:21:00' AS Time), N'Time to hunt (2020) là bộ phim từng được kỳ vọng sẽ nối tiếp thành công của Parasite (2019) để mang lại vinh quang cho điện ảnh Hàn Quốc trong năm nay. Tuy nhiên tác phẩm này lại nhận được nhiều ý kiến trái chiều của các nhà phê bình tại liên hoan phim Berlin, đồng thời cũng bị dời lịch chiếu tới tận 3 lần thì mới được Netflix phát hành chính thức lên trang phim trực tuyến của mình vào ngày 23/04/2020. Nào, hãy cùng Ghiền review phim Giờ săn đã điểm để có cái nhìn khách quan hơn về phim nhé', N'42352521')
INSERT [dbo].[Posts] ([post_id], [post_title], [topic_id], [post_create_date], [post_create_time], [post_body], [post_author_id]) VALUES (N'9634246234', N'Review phim Người khởi lửa – Câu chuyện dị nhân thiếu sức hút', N'3542', CAST(N'2022-03-11' AS Date), CAST(N'12:21:00' AS Time), N'Sau cơn đại địa chấn của bom tấn mang tên Doctor Strange 2, tuần này các rạp phim Việt Nam khá tẻ nhạt với 2 phim mang màu sắc kinh dị là Chuyện ma đô thị và Người khởi lửa. Các phim này đều được bố trí rất ít suất chiếu nên canh me mãi Ghiền review mới đặt được vé xem phim Người khởi lửa. Coi trailer phim này thì thấy khá hấp dẫn và gợi được sự tò mò cho khán giả. Liệu rằng phim có thu hút như vậy không? Hãy cùng Ghiền review phim Người khởi lửa (tên tiếng Anh: Firestarter) để có câu trả lời các bạn nhé!', N'42352521')
INSERT [dbo].[Posts] ([post_id], [post_title], [topic_id], [post_create_date], [post_create_time], [post_body], [post_author_id]) VALUES (N'9849293133', N'Review phim Sonic 2 2022- Màn team up thú vị của Sonic', N'2435', CAST(N'2022-10-27' AS Date), CAST(N'18:29:52.1040000' AS Time), N'asdsadsa', N'42352521')
GO
INSERT [dbo].[PostTag] ([post_id], [tag_id]) VALUES (N'1467165618', N'43267')
INSERT [dbo].[PostTag] ([post_id], [tag_id]) VALUES (N'1467165618', N'45246')
INSERT [dbo].[PostTag] ([post_id], [tag_id]) VALUES (N'7652987352', N'45323')
GO
INSERT [dbo].[Roles] ([role_id], [role_name]) VALUES (N'1', N'Admin')
INSERT [dbo].[Roles] ([role_id], [role_name]) VALUES (N'4', N'User')
GO
INSERT [dbo].[Tags] ([tag_id], [tag_name]) VALUES (N'43267', N'hello')
INSERT [dbo].[Tags] ([tag_id], [tag_name]) VALUES (N'45246', N'tag3')
INSERT [dbo].[Tags] ([tag_id], [tag_name]) VALUES (N'45323', N'tag1')
INSERT [dbo].[Tags] ([tag_id], [tag_name]) VALUES (N'51277', N'harykane')
GO
INSERT [dbo].[Topics] ([topic_id], [topic_name], [category_id]) VALUES (N'1235', N'phim tháng 4', N'435')
INSERT [dbo].[Topics] ([topic_id], [topic_name], [category_id]) VALUES (N'2435', N'phim thang 10', N'435')
INSERT [dbo].[Topics] ([topic_id], [topic_name], [category_id]) VALUES (N'3542', N'phim tháng 2', N'435')
INSERT [dbo].[Topics] ([topic_id], [topic_name], [category_id]) VALUES (N'5323', N'anime mua thu', N'873')
INSERT [dbo].[Topics] ([topic_id], [topic_name], [category_id]) VALUES (N'6345', N'phim tháng 11', N'435')
INSERT [dbo].[Topics] ([topic_id], [topic_name], [category_id]) VALUES (N'6833', N'phim tháng 3', N'435')
GO
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'12346432', N'4')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'12352532', N'4')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'12424552', N'4')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'42352521', N'1')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'64234632', N'1')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'64234632', N'4')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'80196411', N'4')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'69914775', N'4')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'29807774', N'1')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'39147556', N'4')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'50965257', N'1')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'56011452', N'4')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'12175105', N'4')
INSERT [dbo].[UserRole] ([user_id], [role_id]) VALUES (N'89722981', N'1')
GO
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'12175105', N'nguyenan', N'nguyenan1@gmail.com', N'123', CAST(N'2022-10-25' AS Date), CAST(N'17:30:22' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'12346432', N'user0', N'user0@gmail.com', N'123', CAST(N'2022-10-20' AS Date), CAST(N'09:10:00' AS Time), N'nguyen', N'thanh cong', 1, CAST(N'2002-06-16' AS Date), N'0857689020', N'ha noi', N'avatar.png', N'yeu mau hong')
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'12352532', N'user1', N'user1@gmail.com', N'123', CAST(N'2022-10-20' AS Date), CAST(N'09:15:00' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'12424552', N'user2', N'user2@gmail.com', N'123', CAST(N'2022-10-20' AS Date), CAST(N'09:30:00' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'16273546', N'nguyencong1', N'nguyencong1@gmail.com', N'123', CAST(N'2022-10-25' AS Date), CAST(N'11:01:58' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'29807774', N'nguyentuan', N'nguyentuan1@gmail.com', N'123', CAST(N'2022-10-27' AS Date), CAST(N'17:56:49' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'39147556', N'nguyenkhanh', N'nguyenkhanh@gmail.com', N'123', CAST(N'2022-10-27' AS Date), CAST(N'18:05:30' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'42352521', N'admin0', N'admin0@gmail.com', N'123', CAST(N'2022-10-21' AS Date), CAST(N'10:10:00' AS Time), N'nguyen', N'kieu nga', 0, CAST(N'2002-03-14' AS Date), N'0733485921', N'ha noi', N'avatar.png', N'ta la chu cai page ')
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'50965257', N'nguyenkhanh2', N'nguyenkhanh2@gmail.com', N'123', CAST(N'2022-10-27' AS Date), CAST(N'18:06:28' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'56011452', N'nguyenhoang1', N'nguyenhoang1@gmail.com', N'123', CAST(N'2022-10-27' AS Date), CAST(N'21:15:59' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'64234632', N'admin1', N'admin1@gmail.com', N'123', CAST(N'2022-10-21' AS Date), CAST(N'11:10:00' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'64527421', N'nguyencong1', N'nguyencong1@gmail.com', N'123', CAST(N'2022-10-25' AS Date), CAST(N'11:01:58' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'69914775', N'nguyennam', N'nguyennam', N'123', CAST(N'2022-10-25' AS Date), CAST(N'17:29:59' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'80196411', N'nguyencong2', N'nguyencong2@gmail.com', N'123', CAST(N'2022-10-25' AS Date), CAST(N'16:11:07' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'89722981', N'nguyenkhanh4', N'nguyenkhanh4@gmail.com', N'123', CAST(N'2022-10-27' AS Date), CAST(N'18:11:01' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([user_id], [user_account], [user_email], [user_password], [user_create_date], [user_create_time], [user_firstname], [user_lastname], [user_gender], [user_dateofbirth], [user_phone], [user_address], [user_avatar], [user_about]) VALUES (N'92032238', N'nguyennam', N'nguyennam1@gmail.com', N'123', CAST(N'2022-10-25' AS Date), CAST(N'16:47:09' AS Time), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
GO
ALTER TABLE [dbo].[UserRole] ADD  DEFAULT ((4)) FOR [role_id]
GO
ALTER TABLE [dbo].[Comments]  WITH CHECK ADD  CONSTRAINT [Comments_FK] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Comments] CHECK CONSTRAINT [Comments_FK]
GO
ALTER TABLE [dbo].[Comments]  WITH CHECK ADD  CONSTRAINT [Comments_FK1] FOREIGN KEY([post_id])
REFERENCES [dbo].[Posts] ([post_id])
GO
ALTER TABLE [dbo].[Comments] CHECK CONSTRAINT [Comments_FK1]
GO
ALTER TABLE [dbo].[Images]  WITH CHECK ADD  CONSTRAINT [Images_FK] FOREIGN KEY([post_id])
REFERENCES [dbo].[Posts] ([post_id])
GO
ALTER TABLE [dbo].[Images] CHECK CONSTRAINT [Images_FK]
GO
ALTER TABLE [dbo].[Posts]  WITH CHECK ADD  CONSTRAINT [Posts_FK] FOREIGN KEY([topic_id])
REFERENCES [dbo].[Topics] ([topic_id])
GO
ALTER TABLE [dbo].[Posts] CHECK CONSTRAINT [Posts_FK]
GO
ALTER TABLE [dbo].[Posts]  WITH CHECK ADD  CONSTRAINT [Posts_FK1] FOREIGN KEY([post_author_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Posts] CHECK CONSTRAINT [Posts_FK1]
GO
ALTER TABLE [dbo].[PostTag]  WITH CHECK ADD  CONSTRAINT [PostTag_FK] FOREIGN KEY([post_id])
REFERENCES [dbo].[Posts] ([post_id])
GO
ALTER TABLE [dbo].[PostTag] CHECK CONSTRAINT [PostTag_FK]
GO
ALTER TABLE [dbo].[PostTag]  WITH CHECK ADD  CONSTRAINT [PostTag_FK1] FOREIGN KEY([tag_id])
REFERENCES [dbo].[Tags] ([tag_id])
GO
ALTER TABLE [dbo].[PostTag] CHECK CONSTRAINT [PostTag_FK1]
GO
ALTER TABLE [dbo].[Topics]  WITH CHECK ADD  CONSTRAINT [Topics_FK] FOREIGN KEY([category_id])
REFERENCES [dbo].[Categories] ([category_id])
GO
ALTER TABLE [dbo].[Topics] CHECK CONSTRAINT [Topics_FK]
GO
ALTER TABLE [dbo].[UserRole]  WITH CHECK ADD  CONSTRAINT [User_Role_FK] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[UserRole] CHECK CONSTRAINT [User_Role_FK]
GO
ALTER TABLE [dbo].[UserRole]  WITH CHECK ADD  CONSTRAINT [User_Role_FK_1] FOREIGN KEY([role_id])
REFERENCES [dbo].[Roles] ([role_id])
GO
ALTER TABLE [dbo].[UserRole] CHECK CONSTRAINT [User_Role_FK_1]
GO
