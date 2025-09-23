# Đề tài: Hệ thống quản lý phòng khám

> **Nhóm 2:**
> * **Hoàng Văn Chính - B23DCKH011**
> * **Nguyễn Ngọc Dương - B23DCCN221**
> * **Dương Thùy An - B21DCCN132**
> * **Lê Thị Thùy Trang - B23DCKH119**
> * **Đỗ Minh Hoàng - B23DCCN328**

## A. Giới thiệu đề tài
Hiện nay nhu cầu chăm sóc sức khỏe ngày càng cao và quy mô hoạt động của các phòng khám ngày càng mở rộng, việc ứng dụng công nghệ thông tin vào quản lý trở thành một xu thế tất yếu.

Chính vì vậy, nhóm chúng em xây dựng **Hệ thống quản lý phòng khám** với mục tiêu đáp ứng đồng thời hai nhu cầu quan trọng: bệnh nhân có thể dễ dàng đăng ký lịch khám bệnh online hoặc offline, tra cứu lịch sử kết quả khám bệnh; trong khi đó đội ngũ y bác sĩ và nhân viên quản trị bệnh viện có thể quản lý bệnh án, lịch khám, thuốc men, viện phí và báo cáo thống kê một cách tập trung, nhanh chóng và chính xác.

Khám được: da liễu, phụ khoa, nam khoa
Luồng: Bệnh nhân đặt lịch khám online(chọn thời gian và bác sĩ) hoặc trực tiếp với nhân viên hành chính. Sau khi đã có lịch khám/số khám ở phòng cụ thể thì bệnh nhân sẽ lên phòng gặp bác sĩ. Bác sĩ sẽ dựa trên yêu cầu hoặc dấu hiệu của bệnh nhân để chỉ định các thủ thuật, xét nghiệm. Sau đó bác sĩ sẽ kết luận kết quả, kê thuốc. Bệnh nhân thanh toán phí khám trước khi xét nghiệm. Và sau khi được kê đơn thuốc thì có thể lấy ở phòng khám hoặc tự lấy ở ngoài tùy ý.

## B. Đối tượng sử dụng
Trong hệ thống quản lý bệnh viện, có 4 nhóm người dùng chính:
| Đối tượng            | Mô tả                                          |
| -------------------- | ---------------------------------------------- |
| Khách hàng           | Là người đi khám bệnh                          |
| Nhân viên hành chính | Là người tiếp nhận hồ sơ khám bệnh và thu ngân |
| Bác sĩ               | Bác sĩ                                         |
| Quản lý              | Quản lý nhân viên; thuốc; tài chính            |

## C. Thiết kế chi tiết của hệ thống

### I. Thông tin thực thể

#### a. Thực thể và Thuộc tính

##### 1. USER (Người dùng)

* user_id: mã người dùng (khóa chính)
* birthday: ngày sinh
* sex: giới tính
* tel: số điện thoại
* address: địa chỉ
* email: địa chỉ email
* role: vai trò

##### 2. PATIENT (Bệnh nhân)

* has_visited: đã từng khám (True or False)

##### 3. DOCTOR (Bác sĩ)

* Chuyên khoa (da liễu, phụ khoa, nam khoa)
* Trình độ

##### 4. STAFF (Nhân viên hành chính)

##### 5. CLINIC_ROOM (Phòng khám)

* Mã phòng (RoomID)
* Loại phòng (khám da liễu, phụ khoa, nam khoa)
* Tên phòng
* Vị trí (số phòng và tầng)

##### 6. TIME_SLOT

* doctor_id
* slot_id: mã slot (khóa chính)
* star_time
* end_time
* status (True or False)

##### 7. Lịch khám (Appointment) ["Thực thể tạo thành từ liên kết bệnh nhân, bác sĩ và TIME_SLOT"]

* patient_id
* doctor_id
* slot_id
* appointment_id: khóa chính
* status: (Đặt, Đang khám, Hoàn thành, Hủy)

##### 8. Thủ thuật / Xét nghiệm (Procedure/Test)

* Mã thủ thuật (ProcedureID): khóa chính
* Tên thủ thuật / xét nghiệm
* Mô tả
* Chi phí

##### 9. Kết quả thủ thuật

* procedure_id
* patient_id
* ket_qua_thu_thuat_id: khóa chính
* Kết quả: ["Mô tả chi tiết kết quả trả về"]

##### 10. Kết quả khám bệnh

* doctor_id
* patient_id
* procedure_id
* Result:

##### 11. Thuốc (Medicine)

* Mã thuốc (MedicineID)
* Tên thuốc
* Đơn vị (viên, lọ, vỉ…)
* Liều dùng / Hướng dẫn

##### 12. Đơn thuốc

* prescription_id: mã đơn thuốc
* doctor_id
* patient_id
* medicine_id ["1 đơn thuốc nhiều thuốc"]
* Số lượng thuốc
* Đơn giá

##### 13. Thanh toán (Payment)

* Mã thanh toán (PaymentID)
* patient_id
* staff_id
* Ngày thanh toán
* Số tiền
* Phương thức thanh toán (tiền mặt, thẻ, ví điện tử)
* Trạng thái (đã thanh toán / chưa thanh toán)

#### b. Quan hệ giữa các thực thể

##### 1. **Bệnh nhân – Lịch khám**

   * Một bệnh nhân có thể đặt nhiều lịch khám.
   * Mỗi lịch khám thuộc về đúng một bệnh nhân.
     → Quan hệ 1 – N.

##### 2. **Lịch khám – Bác sĩ**

   * Mỗi lịch khám được gắn với một bác sĩ.
   * Một bác sĩ có thể có nhiều lịch khám.
     → Quan hệ 1 – N.

##### 3. **Lịch khám – Phòng khám**

   * Mỗi lịch khám diễn ra tại một phòng cụ thể.
   * Một phòng có thể phục vụ nhiều lịch khám.
     → Quan hệ 1 – N.

##### 4. **Phiếu khám – Lịch khám**

   * Mỗi lịch khám sẽ tạo ra một phiếu khám.
   * Một phiếu khám gắn liền với duy nhất một lịch khám.
     → Quan hệ 1 – 1.

##### 5. **Phiếu khám – Thủ thuật/Xét nghiệm**

   * Một phiếu khám có thể chỉ định nhiều thủ thuật/xét nghiệm.
   * Một thủ thuật có thể được áp dụng cho nhiều phiếu khám.
     → Quan hệ N – N (cần bảng trung gian).

##### 6. **Phiếu khám – Đơn thuốc**

   * Một phiếu khám có thể sinh ra nhiều đơn thuốc (hoặc không có).
   * Một đơn thuốc gắn với đúng một phiếu khám.
     → Quan hệ 1 – N.

##### 7. **Đơn thuốc – Thuốc**

   * Một đơn thuốc có thể gồm nhiều loại thuốc.
   * Một thuốc có thể xuất hiện trong nhiều đơn thuốc.
     → Quan hệ N – N (cần bảng trung gian với số lượng thuốc, liều dùng).

##### 8. **Thanh toán – Lịch khám/Xét nghiệm**

   * Thanh toán xảy ra trước xét nghiệm và sau khi khám.
   * Một lịch khám có thể gắn với một hoặc nhiều giao dịch thanh toán (tạm ứng, thanh toán lần cuối).
     → Quan hệ 1 – N.

---
---

#### 1. Bệnh nhân

* **C**reate:
  * Tạo tài khoản online
  * Hẹn lịch khám online

* **R**ead:
  * Thông tin cá nhân
  * Lịch sử khám bệnh hoặc nhập viện
  * Tình trạng bệnh
  * Đơn thuốc đã được kê
  * Thông tin cơ bản của bác sĩ phụ trách
  * Đối với bệnh nhân nhập viện: xem bệnh án

* **U**pdate:
  * Thông tin cá nhân
  * Lịch khám chưa duyệt

* **D**elete: NULL

#### 2. Nhân viên hành chính
* **C**reate:
  * Hồ sơ bệnh nhân
  * Lịch khám
  * Hóa đơn thanh toán

* **R**ead:
  * Hồ sơ bệnh nhân
  * Lịch khám
  * Danh sách bác sĩ và tình trạng thời gian thực
  * Danh sách giường trống và full

* **U**pdate:
  * Hồ sơ bệnh nhân
  * Lịch khám
  * Hóa đơn thanh toán
  * Danh sách bác sĩ và tình trạng thời gian thực
  * Danh sách giường trống và full

* **D**elete: 
  * Hồ sơ bệnh nhân

#### 3. Bác sĩ
* **C**reate:
  * Bệnh án
  * Dịch vụ chẩn đoán
  * Đơn thuốc

* **R**ead:
  * Lịch sử bệnh án
  * Lịch sử đơn thuốc
  * Danh sách bệnh nhân chờ
  * Danh sách bệnh nhân đang nhập viện bản thân phụ trách

* **U**pdate:
  * Bệnh án
  * Dịch vụ chẩn đoán
  * Đơn thuốc
  * Tình trạng: rảnh hay bận

* **D**elete: NULL

#### 4. Quản lý
* **C**reate:
  * Nhân viên hành chính, bác sĩ
  * Trang thiết bị
  * Dịch vụ chẩn đoán
  * Loại thuốc, vật tư y tế
  * Các khoản chi

* **R**ead:
  * Nhân viên hành chính, bác sĩ
  * Trang thiết bị
  * Dịch vụ chẩn đoán
  * Loại thuốc, vật tư y tế
  * Các khoản chi
  * Tình trạng phòng: trống hay full
  * Báo cáo thu chi, thống kê bệnh nhân

* **U**pdate:
  * Nhân viên hành chính, bác sĩ
  * Trang thiết bị
  * Dịch vụ chẩn đoán
  * Loại thuốc, vật tư y tế

* **D**elete: 
  * Nhân viên hành chính, bác sĩ
  * Trang thiết bị
  * Dịch vụ chẩn đoán
  * Loại thuốc, vật tư y tế

### II. Mức khái niệm