USE [schoolbook]
GO
/****** Object:  Table [dbo].[BookInfo]    Script Date: 2024/8/28 10:13:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookInfo](
	[BookID] [varchar](20) NOT NULL,
	[Title] [varchar](20) NOT NULL,
	[Author] [varchar](50) NOT NULL,
	[Category] [varchar](20) NOT NULL,
	[StockCount] [int] NOT NULL,
	[Borrowingvolume] [int] NOT NULL,
	[Bookwordcount] [int] NOT NULL,
	[Bookclass] [int] NOT NULL,
 CONSTRAINT [PK_BookInfo] PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BorrowRecord]    Script Date: 2024/8/28 10:13:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BorrowRecord](
	[BrrownumberID] [varchar](20) NOT NULL,
	[BrrowbookID] [varchar](20) NOT NULL,
	[RecordID] [varchar](20) NOT NULL,
	[BorrowDate] [datetime] NOT NULL,
	[ReturnDate] [datetime] NOT NULL,
	[ScoreChange] [int] NOT NULL,
	[ChangeReason] [varchar](20) NULL,
 CONSTRAINT [PK_BorrowRecord_1] PRIMARY KEY CLUSTERED 
(
	[RecordID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Class]    Script Date: 2024/8/28 10:13:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Class](
	[ClassAdminID] [varchar](20) NULL,
	[ClassAdminclass] [int] NOT NULL,
	[ClassAdminPassword] [varchar](20) NULL,
	[classnumber] [int] NOT NULL,
	[ClassAdminUsername] [char](20) NOT NULL,
 CONSTRAINT [PK_ClassAdmin] PRIMARY KEY CLUSTERED 
(
	[ClassAdminclass] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ClassMember]    Script Date: 2024/8/28 10:13:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClassMember](
	[ClassMemberID] [varchar](20) NOT NULL,
	[ClassMemberName] [varchar](20) NOT NULL,
	[ClassMemberPassword] [varchar](20) NOT NULL,
	[CreditScore] [int] NOT NULL,
	[ClassMemberclass] [int] NOT NULL,
	[BookID] [varchar](20) NULL,
	[BorrowRecords] [int] NULL,
 CONSTRAINT [PK_ClassMember] PRIMARY KEY CLUSTERED 
(
	[ClassMemberID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BookInfo] ([BookID], [Title], [Author], [Category], [StockCount], [Borrowingvolume], [Bookwordcount], [Bookclass]) VALUES (N'A003', N'skybook', N'efag', N'sky', 10, 2, 5000, 3)
INSERT [dbo].[BookInfo] ([BookID], [Title], [Author], [Category], [StockCount], [Borrowingvolume], [Bookwordcount], [Bookclass]) VALUES (N'H001', N'Seabook', N'haea', N'sea', 10, 2, 5000, 1)
INSERT [dbo].[BookInfo] ([BookID], [Title], [Author], [Category], [StockCount], [Borrowingvolume], [Bookwordcount], [Bookclass]) VALUES (N'H002', N'landbook', N'eadf', N'land', 10, 2, 5000, 2)
GO
INSERT [dbo].[BorrowRecord] ([BrrownumberID], [BrrowbookID], [RecordID], [BorrowDate], [ReturnDate], [ScoreChange], [ChangeReason]) VALUES (N'A001', N'H001', N'P001', CAST(N'2021-02-01T00:00:00.000' AS DateTime), CAST(N'2021-02-02T00:00:00.000' AS DateTime), 0, NULL)
GO
INSERT [dbo].[Class] ([ClassAdminID], [ClassAdminclass], [ClassAdminPassword], [classnumber], [ClassAdminUsername]) VALUES (N'A001', 1, N'123456', 5, N'刘毅                ')
INSERT [dbo].[Class] ([ClassAdminID], [ClassAdminclass], [ClassAdminPassword], [classnumber], [ClassAdminUsername]) VALUES (N'B001', 2, N'123456', 5, N'韩飞                ')
INSERT [dbo].[Class] ([ClassAdminID], [ClassAdminclass], [ClassAdminPassword], [classnumber], [ClassAdminUsername]) VALUES (N'C001', 3, N'123456', 32, N'汉武                ')
GO
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'1', N'一把', N'1', 100, 1, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'56', N'一哈', N'1', 100, 1, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'A001', N'刘毅', N'123456', 100, 1, N'H001', 1)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'A002', N'一一', N'123', 100, 1, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'A003', N'一二', N'123', 100, 1, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'A004', N'一三', N'123', 100, 1, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'A005', N'一四', N'123', 100, 1, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'B001', N'韩飞', N'123456', 100, 2, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'B002', N'二一', N'123', 100, 2, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'B003', N'二二', N'123', 100, 2, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'B004', N'二三', N'123', 100, 2, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'B005', N'二四', N'123', 100, 2, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'C001', N'汉武', N'123456', 100, 3, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'C002', N'三一', N'123', 100, 3, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'C003', N'三二', N'123', 100, 3, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'C004', N'三三', N'123', 100, 3, NULL, NULL)
INSERT [dbo].[ClassMember] ([ClassMemberID], [ClassMemberName], [ClassMemberPassword], [CreditScore], [ClassMemberclass], [BookID], [BorrowRecords]) VALUES (N'C005', N'三四', N'123', 100, 3, NULL, NULL)
GO
ALTER TABLE [dbo].[BookInfo]  WITH CHECK ADD  CONSTRAINT [FK_BookInfo_ClassAdmin] FOREIGN KEY([Bookclass])
REFERENCES [dbo].[Class] ([ClassAdminclass])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BookInfo] CHECK CONSTRAINT [FK_BookInfo_ClassAdmin]
GO
ALTER TABLE [dbo].[BorrowRecord]  WITH CHECK ADD  CONSTRAINT [FK_BorrowRecord_BookInfo] FOREIGN KEY([BrrowbookID])
REFERENCES [dbo].[BookInfo] ([BookID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BorrowRecord] CHECK CONSTRAINT [FK_BorrowRecord_BookInfo]
GO
ALTER TABLE [dbo].[BorrowRecord]  WITH CHECK ADD  CONSTRAINT [FK_BorrowRecord_ClassMember] FOREIGN KEY([BrrownumberID])
REFERENCES [dbo].[ClassMember] ([ClassMemberID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BorrowRecord] CHECK CONSTRAINT [FK_BorrowRecord_ClassMember]
GO
