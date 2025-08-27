# Đề tài: Hệ thống quản lý bệnh viện

> **Nhóm 2:**
> * **Hoàng Văn Chính - B23DCKH011**
> * **Nguyễn Ngọc Dương - B23DCCN221**
> * **Dương Thùy An - B21DCCN132**
> * **Lê Thị Thùy Trang - B23DCKH119**
> * **Đỗ Minh Hoàng - B23DCCN328**

## A. Giới thiệu đề tài
Trong bối cảnh nhu cầu chăm sóc sức khỏe ngày càng cao và quy mô hoạt động của các bệnh viện ngày càng mở rộng, việc ứng dụng công nghệ thông tin vào quản lý trở thành một xu thế tất yếu.

Chính vì vậy, nhóm chúng em xây dựng **Hệ thống quản lý bệnh viện** với mục tiêu đáp ứng đồng thời hai nhu cầu quan trọng: bệnh nhân có thể dễ dàng đăng ký khám bệnh, tra cứu thông tin và theo dõi hồ sơ sức khỏe trực tuyến; trong khi đó đội ngũ y bác sĩ và nhân viên quản trị bệnh viện có thể quản lý bệnh án, lịch khám, thuốc men, viện phí và báo cáo thống kê một cách tập trung, nhanh chóng và chính xác.

## B. Đối tượng sử dụng
Trong hệ thống quản lý bệnh viện, có ... nhóm người dùng chính:
| Đối tượng            | Mô tả                                                      |
| -------------------- | ---------------------------------------------------------- |
| Bệnh nhân            | Là người đi khám bệnh và người nhập viện                   |
| Lễ tân               | Là người tiếp nhận hồ sơ bệnh nhân khám và nhập viện       |
| Nhân viên chuyên môn | Bác sỹ, y tá                                               |
| Quản lý              | Quản lý nhân viên; thiết bị; thuốc, vật tư y tế; tài chính |
| Giám đốc bệnh viện   | Người điều hành cấp cao nhất                               |

## C. Thiết kế chi tiết của hệ thống

![Mô hình trừu trượng 3 lớp](images-of-readme/mo_hinh_truu_tuong_3_lop.png)

### I. Mức ngoài - Khung nhìn người dùng

#### 1. Bệnh nhân
* Được cấp tài khoản gửi về sđt sau khi hoàn thành thủ tục. Tên đăng nhập sẽ chính là sđt của bệnh nhân.
* Không có quyền sửa thông tin. 
* Xem thông tin, lịch sử khám bệnh, lịch sử nhập viện, tình trạng bệnh, đơn thuốc đã được kê của bản thân và thông tin cơ bản của bác sĩ phụ trách
* Đối với bệnh nhân nhập viện: có thể xem tình trạng, thuốc đã dùng trong thời gian nhập viện

#### 2. Lễ tân
* Được cấp tài khoản sau khi hoàn thiện hồ sơ
* Có quyền thêm mới, xem, sửa, xóa thông tin cá nhân của bệnh nhân

#### 3. Nhân viên chuyên môn
* Được cấp tài khoản sau khi hoàn thiện hồ sơ
* Có quyền xem, sửa thông tin khám, nhập viện, tình trạng bệnh, đơn thuốc đã kê của mỗi bệnh nhân
* Có quyền xem danh sách các bệnh nhân nhập viện mà bản thân đang phụ trách
* Đối với bệnh nhân nhập viện: có thể xem tình trạng, thuốc đã dùng trong thời gian nhập viện

#### 4. Quản lý
* Quản lý hồ sơ nhân viên: 1 page gồm danh sách các nhân viên và các thông tin chính, click để xem chi tiết
  * Thêm mới, xem, sửa, xóa, tìm kiếm thông tin của nhân viên (thông tin của nhân viên sẽ bao gồm cả các bệnh nhân mà nhân viên phụ trách, tài khoản của nhân viên ẩn mật khẩu)

* Quản lý thiết bị:
  * Thêm mới, xem, sửa, xóa, tìm kiếm thông tin thiết bị. Có cả tình trạng thiết bị (chờ bảo trì, hoạt động).

* Quản lý thuốc, vật tư y tế:
  * Thêm mới, xem, sửa, xóa. Tăng giảm số lượng còn trong kho

* Quản lý thu chi:
  * Thêm, xem, sửa, xóa các khoản thu
  * Thêm, xem, sửa, xóa các khoản chi
  * Xem báo cáo thu chi

#### 5. Giám đốc bệnh viện
* Có tất cả các quyền trên
* Thêm quyền có thể thêm mới, xem, sửa, xóa thông tin của các quản lý
