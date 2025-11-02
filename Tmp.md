# BÁO CÁO KẾT QUẢ BÀI TẬP LỚN DATABASE NHÓM 2

## A. Thông tin nhóm

**Tên Dự Án:** ....

**Link Dự Án:** ....

**Thành Viên Nhóm:**

- Hoàng Văn Chính - B23DCKH011
- Nguyễn Ngọc Dương - B23DCCN221
- Dương Thùy An - B21DCCN132
- Lê Thị Thùy Trang - B23DCKH119
- Đỗ Minh Hoàng - B23DCCN328

**22h ... hàng tuần (hạn cuối 27/11)**, team sẽ ngồi lại để review công việc đã làm, cùng nhau giải quyết vấn đề đang gặp phải và lên kế hoạch phát triển các tính năng trong tuần tiếp theo.

**Version Control Strategy**

Team hoạt động theo Gitflow để quản lý code. Mỗi thành viên sẽ tạo branch từ develop để làm việc, các branch đặt theo format feature/ten-chuc-nang, sau khi hoàn thành sẽ tạo Pull Request để review code và merge vào develop

- Các nhánh chính:
  - `main`: Chứa code ổn định, đã qua kiểm tra và test kỹ lưỡng
  - `develop`: Chứa code mới nhất, đã qua review và test
  - `feature/`: Các nhánh chứa code đang phát triển, short-live, sau khi hoàn thành sẽ merge vào `develop`.

Sau mỗi tuần, team sẽ merge `develop` vào `main` để release phiên bản mới.

**Công nghệ sử dụng:**
- **Version Control:** Git, Github
- **Frontend:** JavaFX
- **Backend:** Java Core + JDBC
- **Database:** MySQL

## B. Giới Thiệu Dự Án

### I. GIới thiệu chung

Nhóm chúng em xây dựng **Hệ thống quản lý phòng khám** gồm các chuyên khoa: da liễu, tai mũi họng, phụ khoa, nam khoa với mục tiêu đáp ứng đồng thời hai nhu cầu quan trọng: bệnh nhân có thể dễ dàng tra cứu lịch sử kết quả khám bệnh; nhân viên có thể xem trạng thái của các bác sỹ (hàng đợi bao nhiêu) để lên lịch cho bệnh nhân; bác sỹ có thể cập nhật tình trạng khám của bệnh nhân (đã khám, đang chờ) và xem danh sách bệnh nhân mà mình sẽ khám; quản lý có thể quản trị về nhân sự, xem báo cáo doanh thu của bệnh viện

### II. Đối tượng sử dụng

Trong hệ thống, có 4 nhóm người dùng chính:
| Đối tượng            | Mô tả                                          |
| -------------------- | ---------------------------------------------- |
| Khách hàng           | Là người đi khám bệnh                          |
| Nhân viên hành chính | Là người tiếp nhận hồ sơ khám bệnh và thu ngân |
| Bác sĩ               | Bác sĩ                                         |
| Quản lý              | Quản lý nhân viên; tài chính                   |

### III. Chức năng & Luồng hoạt động

#### 1. Các chức năng chính
- **Chức năng 1:** Đăng ký, đăng nhập. Tên đăng nhập là số điện thoại (chỉ cho nhân viên phòng khám)
- **Chức năng 2:** Bệnh nhân xem các lịch sử khám của bản thân bằng số căn cước công dân
- **Chức năng 3:** Nhân viên hành chính xem danh sách bác sỹ theo trình độ chuyên môn (giáo sư, phó giáo sư/ bác sỹ chuyên khoa), xem danh sách thanh toán và đơn thuốc; tạo phiếu khám cho bệnh nhân; thu ngân: chỉnh sửa trạng thái (đã thanh toán, chưa thanh toán)
- **Chức năng 4:** Bác sĩ xem danh sách bệnh nhân đang và chờ khám, thông tin phiếu khám của bệnh nhân; chỉnh sửa phiếu khám, chuyển đổi tình trạng bệnh nhân (chờ, đang khám, đã khám)
- **Chức năng 5:** Quản lý tạo và cấp tài khoản cho nhân viên theo role, xem báo cáo doanh thu

#### 2. Luồng hoạt động

**a. Tạo phiếu khám**
Bệnh nhân đến bệnh viện gặp nhân viên hành chính, nhân viên hành chính sẽ hỏi tình trạng bệnh của bệnh nhân, từ đó lên phiếu khám theo chuyên khoa và bác sỹ, đồng thời thu ngân tiền khám bác sĩ của bệnh nhân và chỉ định bệnh nhân đến phòng khám cụ thể

**b. Gặp bác sĩ**
Bác sĩ khám cho bệnh nhân, lên danh sách các thủ tục phải làm, kết luận và tạo đơn thuốc cho bệnh nhân (bệnh nhân khám xong chưa có đơn thuốc ngay). Sau đấy cập nhật tình trạng bệnh nhân từ đang khám thành đã khám

**c. Thanh toán và lấy đơn thuốc**
Bệnh nhân quay lại gặp nhân viên hành chính thanh toán tiền các thủ tục mà bác sĩ đã làm (nếu có, ví dụ: làm thêm nội soi tai mũi họng, siêu âm,...) và lấy đơn thuốc được in từ nhân viên và đi về

## C. Thiết kế chi tiết hệ thống

### I. Thực thể và Thuộc tính

#### 1. DOCTOR (Bác sĩ)

* `doctor_id` **(PK)**: mã bác sĩ
* `date_of_birth`: ngày sinh
* `sex` ('M', 'F', 'O'): giới tính
* `phone`: số điện thoại
* `email`: địa chỉ email
* `speciality`: Chuyên ngành (da liễu, tai mũi họng, phụ khoa, nam khoa)
* `qualification_level`: Trình độ chuyên môn (bác sĩ, phó giáo sư/giáo sư)
* `consultation_fee`: phí tư vấn

#### 2. STAFF (Nhân viên hành chính)

* `user_id` **(PK)**: mã nhân viên
* `date_of_birth`: ngày sinh
* `sex` ('M', 'F', 'O'): giới tính
* `phone`: số điện thoại
* `email`: địa chỉ email

#### 3. CLINIC_ROOM (Phòng khám)

* `room_id` **(PK)**: mã phòng
* `room_type`: loại phòng (phòng khám da liễu, phụ khoa, nam khoa)
* `location`: (ví dụ: phòng 305-tầng 3)

#### 4. MEDICAL_EXAMINATION_FORM (Phiếu khám)

* `form_id` **(PK)**: mã phiếu
* `citizen_id`: số căn cước công dân
* `patient_name`: tên bệnh nhân
* `time`: thời gian tạo phiếu
* `conclusion_result`: kết quả kết luận

#### 5. PROCEDURE (Thủ thuật)

* `procedure_id` **(PK)**: mã thủ thuật
* `name`: tên thủ thuật (nội soi tai mũi họng, siêu âm ổ bụng,...)
* `price`: giá tiền

#### 6. MEDICINE (Thuốc)

* `medicine_id` **(PK)**: mã thuốc
* `name`: tên thuốc
* `unit`: đơn vị (ví dụ: tablet, vial,...)
* `price`: giá tiền/đơn vị
* `instruction`: hướng dẫn dùng

#### 7. PRESCRIPTION (Đơn thuốc)

* `prescription_id` **(PK)**: mã đơn thuốc
* `medical_exmination_form` **(FK)**:
* `note`: ghi chú thêm (nếu có)
* `total_amount`: tổng tiền thuốc

#### 8. PRESCRIPTION_LINE (Chi tiết đơn thuốc)

* `prescription_id` **(FK)**: mã đơn thuốc
* `line_no` **(CK)**: số thứ tự dòng
* `medicine_id` **(FK)**:
* `quantity`: số lượng thuốc
* `dosage`: liều dùng (ví dụ 1 viên/lần & 3 lần/ngày)
* `duration`: thời gian (ví dụ: 7 ngày)
* `line_amount`: thành tiền của dòng

#### 9. INVOICE (Hóa đơn)

* `invoid_id` **(PK)**
* `total_amount`: tổng chi phí
* `staff_id`
* `method`: ('CASH', 'CARD', 'TRANSFER')
* `date`
* `status` (‘PAID’, ‘UNPAID’)