# 📚 Book Store Management System (Desktop Application)

### 📖 Giới thiệu

Đây là ứng dụng Desktop **Quản lý Kinh doanh Cửa hàng Sách & Truyện Tranh** (Manga/Comics) được phát triển nhằm số hóa quy trình bán sách và quản lý kho hàng.

Hệ thống kết hợp giữa bán sách vật lý và sách điện tử (Ebook), tích hợp **Google Drive** để lưu trữ tài nguyên số và **RabbitMQ** để hỗ trợ khách hàng trực tuyến. Dự án áp dụng mô hình kiến trúc **MVC (Model-View-Controller)** để đảm bảo mã nguồn rõ ràng, dễ bảo trì và mở rộng.

### 🚀 Tính năng nổi bật

#### 👤 Dành cho Khách hàng (Client App)
* **Mua sắm trực quan:** Duyệt danh sách truyện/sách theo thể loại (Action, Isekai, Comedy...), xem chi tiết, thêm vào giỏ hàng.
* **Thanh toán thông minh:** Hỗ trợ chọn địa chỉ giao hàng chi tiết (Tỉnh/Huyện/Xã - tích hợp API hành chính), áp dụng Voucher giảm giá.
* **Ebook & Google Drive:** Sau khi mua sách điện tử, hệ thống tự động gửi link tải hoặc file sách từ Google Drive qua Email cho khách hàng.
* **Chat Hỗ trợ (Real-time):** Nhắn tin trực tiếp với Admin để được tư vấn ngay lập tức thông qua giao thức **RabbitMQ**.
* **Bảo mật:** Đăng ký, Đăng nhập, Quên mật khẩu xác thực bằng mã **OTP qua Email**.

#### 🛠 Dành cho Quản lý (Admin Dashboard)
* **Dashboard Thống kê:** Biểu đồ trực quan về doanh thu theo ngày/tháng, top sản phẩm bán chạy.
* **Quản lý Sách & Kho:** Thêm, xóa, sửa thông tin sách, cập nhật số lượng, quản lý chapters (chương truyện).
* **Quản lý Đơn hàng:** Theo dõi trạng thái đơn hàng, duyệt đơn và xem lịch sử mua hàng của khách.
* **Hỗ trợ Khách hàng:** Nhận và phản hồi tin nhắn của khách hàng theo thời gian thực.
* **Tích hợp Cloud:** Quản lý file sách/ảnh bìa trực tiếp trên Google Drive thông qua API.

### 🛠 Công nghệ sử dụng

| Thành phần | Công nghệ | Chi tiết |
| :--- | :--- | :--- |
| **Ngôn ngữ** | Java | JDK 17+ |
| **Giao diện** | JavaFX / FXML | CSS styling, Scene Builder |
| **Cơ sở dữ liệu** | MySQL | Lưu trữ thông tin sách, user, đơn hàng |
| **Kết nối DB** | JDBC | Java Database Connectivity |
| **Messaging** | RabbitMQ | Xử lý chat Real-time bất đồng bộ |
| **Cloud Storage** | Google Drive API v3 | Lưu trữ và phân phối Ebook/Hình ảnh |
| **Tiện ích** | JavaMail | Gửi Email OTP, Hóa đơn & Ebook |
| **Thư viện khác** | Gson, Jackson, JXMaps | Xử lý JSON, API Địa chỉ |

### 📐 Kiến trúc Hệ thống (MVC)

Hệ thống được tổ chức theo mô hình MVC tiêu chuẩn:
* **View:** Các file `.fxml` (FrontEnd, BackEnd, Login...) và giao diện JavaFX.
* **Controller:** Xử lý sự kiện (LoginController, CartCardController, etc.) và điều hướng logic.
* **Model:** Các thực thể dữ liệu (Book, Cart, Account) và lớp truy xuất DB.
* **Services:** Các module xử lý riêng biệt cho Google Drive, Email Sender và Chat Service.

### ⚙️ Hướng dẫn Cài đặt & Chạy

#### 1. Yêu cầu hệ thống
* JDK 17 trở lên.
* MySQL Server (XAMPP hoặc MySQL Workbench).
* RabbitMQ Server (Đã cài đặt và bật Plugin Management).
* Kết nối Internet (để gọi API Google và Email).

#### 2. Cài đặt Cơ sở dữ liệu
1.  Mở phpMyAdmin hoặc MySQL Workbench.
2.  Tạo database tên `book_management`.
3.  Import file `data/book_management.sql` (nằm trong thư mục dự án).

#### 3. Cấu hình RabbitMQ & Google Cloud
* **RabbitMQ:** Đảm bảo server đang chạy tại port mặc định `5672`.
* **Google Cloud Credentials:**
    * Do chính sách bảo mật, file `credentials.json` và `client_secret.json` đã bị ẩn khỏi Git.
    * Bạn cần tạo Project trên Google Cloud Console, kích hoạt **Drive API** và **Gmail API**.
    * Tải file credentials về và đặt vào thư mục `src/` (hoặc cấu hình lại đường dẫn trong `GoogleDriveServiceHelper.java`).

#### 4. Chạy ứng dụng
* **Bước 1:** Import dự án vào Eclipse hoặc IntelliJ IDEA.
* **Bước 2:** Add các file `.jar` trong thư mục `lib` vào Build Path (Libraries) của dự án.
* **Bước 3:** Chạy file `src/application/Main.java`.

### 🔐 Tài khoản Quản trị (Admin)
* **Username:** `admin`
* **Password:** (Vui lòng kiểm tra trong bảng `Account` của Database hoặc tạo mới qua chức năng đăng ký nếu chưa có).

### 📝 License
Dự án là Niên luận/Đồ án cơ sở ngành Mạng máy tính & Truyền thông dữ liệu.