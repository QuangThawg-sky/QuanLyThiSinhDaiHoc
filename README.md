# Quản lý thí sinh dự thi đại học (Java)

## Chức năng
1. Thêm mới thí sinh khối A, B hoặc C.
2. Hiển thị danh sách và thông tin khối thi/môn thi.
3. Tìm kiếm thí sinh theo số báo danh.
4. Thoát chương trình.

## Các lớp
- `ThiSinh`: lớp trừu tượng lưu thông tin chung của thí sinh.
- `ThiSinhKhoiA`: khối A, gồm Toán, Lý, Hóa.
- `ThiSinhKhoiB`: khối B, gồm Toán, Hóa, Sinh.
- `ThiSinhKhoiC`: khối C, gồm Văn, Sử, Địa.
- `TuyenSinh`: lớp chạy chương trình, chứa menu và các chức năng quản lý.

## Cách chạy bằng terminal
Yêu cầu đã cài JDK.

Mở terminal tại thư mục dự án, sau đó chạy:

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out TuyenSinh
```

## Cách chạy bằng IntelliJ IDEA / NetBeans / VS Code
Tạo hoặc mở dự án Java, đưa các file trong thư mục `src` vào phần source, sau đó chạy lớp `TuyenSinh`.

## Đẩy dự án lên GitHub
Tạo một repository mới trên GitHub (có thể đặt tên `QuanLyThiSinhDaiHoc`). Nếu tạo repository mới, không cần thêm README trên GitHub vì dự án đã có README.

Mở terminal tại thư mục dự án và chạy:

```bash
git init
git add .
git commit -m "Add university applicant management program"
git branch -M main
git remote add origin https://github.com/TEN_USERNAME/QuanLyThiSinhDaiHoc.git
git push -u origin main
```

Thay `TEN_USERNAME` bằng username GitHub của bạn. Nếu thư mục đã là một Git repository, bỏ qua `git init`; nếu đã có remote tên `origin`, kiểm tra bằng `git remote -v` thay vì thêm lại.
