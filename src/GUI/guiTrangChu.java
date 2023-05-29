package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

//import jdk.nashorn.internal.ir.ForNode;

//import com.sun.org.apache.bcel.internal.generic.LNEG;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import connectDB.ConnectDB;
import dao.BaoHanh_Dao;
import dao.HangSanXuat_Dao;
import dao.HopDongTraGop_Dao;
import dao.HopDongTraHet_Dao;
import dao.HopDong_Dao;
import dao.LinhKien_Dao;
import dao.LoaiXe_Dao;
import dao.NhanVienHanhChanh_Dao;
import dao.NhanVienKyThuat_Dao;
import dao.TaiKhoanKT_Dao;
import dao.TraLan1_Dao;
import dao.TraLan2_Dao;
import dao.TraLan3_Dao;
import dao.XeMayDuPhong_Dao;
import dao.XeMay_Dao;
import dao.taiKhoanHC_Dao;
import entity.BaoHanh;
import entity.HangSanXuat;
import entity.HopDong;
import entity.HopDongTraGop;
import entity.HopDongTraHet;
import entity.LinhKien;
import entity.LoaiXe;
import entity.NhanVienHanhChanh;
import entity.NhanVienKyThuat;
import entity.TaiKhoanHC;
import entity.TaiKhoanKT;
import entity.TraLan1;
import entity.TraLan2;
import entity.TraLan3;
import entity.dsXeMay;
import entity.xeMay;

public class guiTrangChu{
	//Login
	JFrame frameLogin = new JFrame();
	JTextField tfTenDangNhap;
	JPasswordField tfMatKhau;
	JButton btLogin,btExit;
	//
	JFrame frameRes = new JFrame();
	JComboBox comMaNVHCDK,comMaNVKTDK;
	JTextField tfTenDangKy;
	JPasswordField tfMatKhauDK,tfNhapLaiMK;
	JButton btRes,btBackRes,btKT,btHC;
	//QL
	JFrame frameQL = new JFrame();
	JButton btNhanVien,btThoat,btTaiKhoan;
	//Nhan vien hanh chanh
	JFrame frameChucNangNV = new JFrame();
	JButton btXeMay,btThoatNV,btHopDong;
	//Nhan vien ky thuat
	JFrame frameChucNangNVKT = new JFrame();
	JButton btBaoHanh,btThoatNVKT;
	//Nhan vien
	JFrame frameNhanVien = new JFrame();
	JButton BackNV;
	JTextField tfMaNVHC,tfTenNVHC,tfChucVuNVHC,tfPhongBanNVHC,tfHocVanVNHC,tfSDTNVHC,tfTimNVHC;
	JButton btThemNVHC,btXoaNVHC,btNVHCCapNhat,btNVHCHuy,btNVHCLuu;	
	JComboBox comGioiTinhNVHC;
	JDateChooser dateNVHC;
	
	JTextField tfMaNVKT,tfTenNVKT,tfChucVuNVKT,tfBacThoNVKT ,tfSoNamKNVNKT,tfSDTNVKT,tfTimNVKT;
	JButton btThemNVKT,btXoaNVKT,btNVKTCapNhat,btNVKTHuy,btNVKTLuu;
	JComboBox comGioiTinhNVKT;
	JDateChooser dateNVKT;
	JTable tableNVHC,tableNVKT;
	DefaultTableModel modelNVHC,modelNVKT;	
	//Xe may
	JFrame frameXeMay = new JFrame();
	JButton BackXe;
	JTextField tfMaXe,tfNuocSX,tfMauXe,tfTenXe,tfMaHSX,tfTenHSX,tfDonGia,tfTenLoai,tfMaLoai,tfSoLuongTon,tfTimXe,tfTimHSX,tfTimLoai;
	JButton btXeThem,btXeXoa,btXeCapNhat,btXeHuy,btXeLuu;
	JButton btHSXThem,btHSXXoa,btHSXCapNhat,btHSXLuu,btHSXHuy;
	JButton btLoaiThem,btLoaiXoa,btLoaiCapNhat,btLoaiLuu,btLoaiHuy;
	JComboBox comHangSX,comSoPK,comLoaiXe;
	JTable tableXe,tableHSX,tableLoai;
	DefaultTableModel modelXe,modelHSX,modelLoai;
	//Hop Dong
	JFrame frameHopDong = new JFrame();
	JButton BackHD;
	JTextField tfTenKHHD,tfDCKHHD,tfNVLap,tfSDTKHHD,tfMaHD,tfTGBHHD,tfTimHD;
	JButton btThemHD,btXoaHD,btHDCapNhat,btHDHuy,btHDLuu;	
	JComboBox comLoaiHD;
	JDateChooser ngayLapHD,ngayTra1,ngayTra2,ngayTra3;
	JTextField tfNVLHD1L, tfGiaxeHD1L, tfTenXeHD1L,tfTimHD1L;
	JButton btThemHD1L,btXoaHD1L,btHD1LLuu,btHD1LHuy,btChonXeHD1L,btchonMaHD1L;
	JComboBox comMaHD1L,comMaXeHD1L;
	JLabel lbTienThanhToanHD1L;
	
	JTextField tfNVLHDTG, tfGiaxeHDTG, tfTenXeHDTG ,tfNgayTra1,tfNgayTra2,tfNgayTra3,tfTimHDTG;
	JButton btThemHDTG,btXoaHDTG,btHDTGLuu,btHDTGHuy,btTra1,btTra2,btTra3,btChonXeHDTG,btchonMaHDTG;
	JComboBox comMaHDTG,comMaXeHDTG;
	JLabel lbTienThanhToanHDTG;
	
	JTable tableHD,tableHD1L,tableHDTG;
	DefaultTableModel modelHD,modelHD1L,modelHDTG;
	//Bao hanh
	JFrame frameBaoHanh = new JFrame();
	JButton BackBH;
	JTextField tfMaPhieu,tfNhanVienKyThuat, tfLiDoBH,tfLoaiHDBH ,tfTenXeBh,tfHSXBH,
		tfLoaiXeBH,tfMaHDBH,tfNhanVienLapBH,tfThoiGianBaoHanhBH,tfNgayLapHDBH,tfTimBH;
	JButton btThemBH,btXoaBH,btBHCapNhat,btBHLuu,btBHHuy;
	JComboBox comMaXeBH,comLoiDo,comTenLinhKien;
	JDateChooser ngayBaoHanh;
	JTextField tfMaLK,tfTenLK,tfTimLK;
	JButton btThemLK,btXoaLK,btLKCapNhat,btLKLuu,btLKHuy,btChonMaBH;
	JTable tableBH,tableLK;
	DefaultTableModel modelBH,modelLK;
	
	
	JLabel tbRegexNVHC,tbRegexNVKT,tbRegexXe,tbRegexHSX,tbRegexLoai,tbRegexHD,tbRegexHD1L,tbRegexHDTG,tbRegexBH,tbRegexLK;
	//
	NhanVienHanhChanh_Dao nvhc_dao = new NhanVienHanhChanh_Dao();
	taiKhoanHC_Dao tkhc_dao = new taiKhoanHC_Dao();
	NhanVienKyThuat_Dao nvkt_dao = new NhanVienKyThuat_Dao();
	TaiKhoanKT_Dao tkkt_dao = new TaiKhoanKT_Dao();
	XeMay_Dao xm_dao = new XeMay_Dao();
	HangSanXuat_Dao hsx_dao = new HangSanXuat_Dao();
	LoaiXe_Dao lx_dao = new LoaiXe_Dao();
	HopDong_Dao hd_dao = new HopDong_Dao();
	HopDongTraGop_Dao hdtg_dao = new HopDongTraGop_Dao();
	HopDongTraHet_Dao hdth_dao = new HopDongTraHet_Dao();
	BaoHanh_Dao bh_dao = new BaoHanh_Dao();
	LinhKien_Dao lk_dao = new LinhKien_Dao();
	XeMayDuPhong_Dao xmdp_dao = new XeMayDuPhong_Dao();
	TraLan1_Dao tl1_dao = new TraLan1_Dao();
	TraLan2_Dao tl2_dao = new TraLan2_Dao();
	TraLan3_Dao tl3_dao = new TraLan3_Dao();
	private int sttMaXe ;
	public guiTrangChu() {
		LoginFrame();
	}
	public void LoginFrame(){
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frameLogin.setTitle("Đăng nhập");
		frameQL.setTitle("Chức năng người quản lí");
		frameNhanVien.setTitle("Nhân viên");
		frameRes.setTitle("Đăng ký tài khoản");
		frameChucNangNV.setTitle("Chức năng nhân viên hành chánh");
		frameChucNangNVKT.setTitle("Chức năng nhân viên kỹ thuật");
		frameXeMay.setTitle("Xe máy");
		frameHopDong.setTitle("Hợp đồng");
		frameBaoHanh.setTitle("Bảo hành");
		//Login
		JPanel guiLogin = new JPanel();
		guiLogin.setLayout(new BorderLayout());
		JPanel LoginCenter = new JPanel();
		LoginCenter.setLayout(null);
		
		JLabel lbTenDangNhap ,lbTMatKhau ;
		LoginCenter.add(lbTenDangNhap= new JLabel("Tên đăng nhập:"));
		LoginCenter.add(tfTenDangNhap = new JTextField());
		LoginCenter.add(lbTMatKhau= new JLabel("Mật khẩu:"));
		LoginCenter.add(tfMatKhau = new JPasswordField());
		
		lbTenDangNhap.setBounds(60, 20, 90, 30);
		tfTenDangNhap.setBounds(160,20 , 200, 30);
		lbTMatKhau.setBounds(60, 70, 80, 30);
		tfMatKhau.setBounds(160,70 , 200, 30);
		
		JPanel loginSouth = new JPanel();
		loginSouth.add(btLogin=new JButton("Đăng nhập"));
		loginSouth.add(btExit=new JButton("Thoát"));
		guiLogin.add(LoginCenter,BorderLayout.CENTER);
		guiLogin.add(loginSouth,BorderLayout.SOUTH);
		
		frameLogin.setDefaultCloseOperation(frameLogin.EXIT_ON_CLOSE);
		frameLogin.setSize(400,200);
		frameLogin.setLocationRelativeTo(null);
		frameLogin.setResizable(false);
		frameLogin.setVisible(true);
		frameLogin.add(guiLogin);
		//Dang ky
		JPanel guiRes = new JPanel();
		guiRes.setLayout(new BorderLayout());
		JPanel ResCenter = new JPanel();
		ResCenter.setLayout(null);
		
		JLabel lbTenDangKy ,lbTMatKhauDK,lbNhapLaiMatKhau,lbMaNVHCDk, lbMaNVKTDk;
		ResCenter.add(lbTenDangKy= new JLabel("Tên đăng nhập:"));
		ResCenter.add(tfTenDangKy = new JTextField());
		ResCenter.add(lbTMatKhauDK= new JLabel("Mật khẩu:"));
		ResCenter.add(tfMatKhauDK = new JPasswordField());
		ResCenter.add(lbNhapLaiMatKhau= new JLabel("Nhập lại MK:"));
		ResCenter.add(tfNhapLaiMK = new JPasswordField());
		ResCenter.add(lbMaNVHCDk= new JLabel("NV hành chánh"));
		ResCenter.add(comMaNVHCDK = new JComboBox());
		ResCenter.add(lbMaNVKTDk= new JLabel("NV kỹ thuật"));
		ResCenter.add(comMaNVKTDK = new JComboBox());
		ResCenter.add(btHC = new JButton("Mở"));
		ResCenter.add(btKT = new JButton("Mở"));
		
		lbTenDangKy.setBounds(50, 20, 90, 30);
		tfTenDangKy.setBounds(160,20 , 200, 30);
		lbTMatKhauDK.setBounds(50, 70, 80, 30);
		tfMatKhauDK.setBounds(160,70 , 200, 30);
		lbNhapLaiMatKhau.setBounds(50, 120, 80, 30);
		tfNhapLaiMK.setBounds(160,120 , 200, 30);
		lbMaNVHCDk.setBounds(50, 170, 90, 30);
		comMaNVHCDK.setBounds(160,170 , 120, 30);
		btHC.setBounds(310,170 , 60, 30);
		lbMaNVKTDk.setBounds(50, 230, 80, 30);
		comMaNVKTDK.setBounds(160,230 , 120, 30);
		btKT.setBounds(310,230 , 60, 30);
		
		
		comMaNVHCDK.setEnabled(false);
		comMaNVKTDK.setEnabled(false);
		JPanel ResSouth = new JPanel();
		ResSouth.add(btRes=new JButton("Đăng ký"));
		ResSouth.add(btBackRes=new JButton("Quay lại"));
		guiRes.add(ResCenter,BorderLayout.CENTER);
		guiRes.add(ResSouth,BorderLayout.SOUTH);
		
		frameRes.setDefaultCloseOperation(frameRes.EXIT_ON_CLOSE);
		frameRes.setSize(400,400);
		frameRes.setLocationRelativeTo(null);
		frameRes.setResizable(false);
		
		frameRes.add(guiRes);
		//QL
		JPanel pnChucNangQL = new JPanel();
		pnChucNangQL.setLayout(null);

		pnChucNangQL.add(btNhanVien = new JButton("Nhân viên"));
		pnChucNangQL.add(btTaiKhoan = new JButton("Tài khoản"));
		pnChucNangQL.add(btThoat = new JButton("Thoát"));
		
		
		ImageIcon employ = new ImageIcon("employee.png");
		ImageIcon insurance = new ImageIcon("insurance.png");
		ImageIcon contract = new ImageIcon("contract.png");
		ImageIcon xemay = new ImageIcon("xemay.png");
		ImageIcon taikhoan = new ImageIcon("account.png");
	
		
		
		
		btNhanVien.setBounds(70, 70, 150, 50);
		btTaiKhoan.setBounds(290, 70, 150, 50);
		btThoat.setBounds(520, 70, 150, 50);
		btNhanVien.setIcon(employ);
		btTaiKhoan.setIcon(taikhoan);
		
		frameQL.setDefaultCloseOperation(frameQL.EXIT_ON_CLOSE);
		frameQL.setSize(720,250);
		frameQL.setResizable(false);
		frameQL.setLocationRelativeTo(null);
		frameQL.add(pnChucNangQL);
		//Nhan vien hanh chanh
		JPanel pnChucNangChucNangNV = new JPanel();
		pnChucNangChucNangNV.setLayout(null);

		pnChucNangChucNangNV.add(btXeMay = new JButton("Xe máy"));
		pnChucNangChucNangNV.add(btHopDong = new JButton("Hợp đồng"));
		pnChucNangChucNangNV.add(btThoatNV = new JButton("Thoát"));

		btXeMay.setBounds(70, 70, 150, 50);
		btHopDong.setBounds(270, 70, 150, 50);
		btThoatNV.setBounds(500, 70, 150, 50);
		btXeMay.setIcon(xemay);
		btHopDong.setIcon(contract);
		
		
		frameChucNangNV.setDefaultCloseOperation(frameChucNangNV.EXIT_ON_CLOSE);
		frameChucNangNV.setSize(700,250);
		frameChucNangNV.setResizable(false);
		frameChucNangNV.setLocationRelativeTo(null);
		//frameChucNangNV.setVisible(true);
		frameChucNangNV.add(pnChucNangChucNangNV);
		//Nhan vien ky thuat
		JPanel pnChucNangChucNangNVKT = new JPanel();
		pnChucNangChucNangNVKT.setLayout(null);

		pnChucNangChucNangNVKT.add(btBaoHanh = new JButton("Bảo hành"));
		pnChucNangChucNangNVKT.add(btThoatNVKT = new JButton("Thoát"));
		btBaoHanh.setBounds(70, 70, 150, 50);
		btThoatNVKT.setBounds(300, 70, 150, 50);
		btBaoHanh.setIcon(insurance);
		
		
		frameChucNangNVKT.setDefaultCloseOperation(frameChucNangNVKT.EXIT_ON_CLOSE);
		frameChucNangNVKT.setSize(500,250);
		frameChucNangNVKT.setResizable(false);
		frameChucNangNVKT.setLocationRelativeTo(null);
		//frameChucNangNVKT.setVisible(true);
		frameChucNangNVKT.add(pnChucNangChucNangNVKT);
		//NV
		JPanel pnNhanVien = new JPanel();
		pnNhanVien.setLayout(new BorderLayout());
		JPanel pnNhanVienNorth = new JPanel();
		
		pnNhanVienNorth.add(BackNV = new JButton("Back"));		
		ImageIcon back = new ImageIcon("back.png");
		BackNV.setIcon(back);
		BackNV.setPreferredSize(new Dimension(100,30));
		Box box = Box.createHorizontalBox();
		box.add(Box.createHorizontalStrut(1000));
		pnNhanVienNorth.add(box);
		JLabel lbNVHCNorth = new JLabel("QUẢN LÍ NHÂN VIÊN");
		lbNVHCNorth.setForeground(Color.blue);
		Font fontXe = new Font("Arial", Font.BOLD, 20);
		lbNVHCNorth.setFont(fontXe);
		pnNhanVienNorth.add(lbNVHCNorth);
		
		
		JPanel pnNhanVienCenter = new JPanel();
		pnNhanVienCenter.setLayout(new BorderLayout());
		
		JPanel pnNVHC = new JPanel();
		pnNVHC.setLayout(new BorderLayout());
		
		JPanel pnNVHCCenter = new JPanel();
		pnNVHCCenter.setLayout(null);
		
		pnNVHCCenter.setBorder(new TitledBorder("Thông tin nhân viên hành chánh"));
		JLabel lbMaNVHC,lbTenNVHC,lbTuoiNVHC ,lbChucVuNVHC ,lbGioiTinhNVHC ,lbPhongBanNVHC , lbSDTNVHC,lbHocVanVNHC ;
		
		pnNVHCCenter.add(lbMaNVHC = new JLabel("Mã Nhân viên:"));
		pnNVHCCenter.add(lbTenNVHC = new JLabel("Tên nhân viên:"));
		pnNVHCCenter.add(lbTuoiNVHC = new JLabel("Ngày sinh:"));
		pnNVHCCenter.add(lbChucVuNVHC = new JLabel("Chức vụ:"));
		pnNVHCCenter.add(lbGioiTinhNVHC = new JLabel("Giới tính:"));
		pnNVHCCenter.add(lbPhongBanNVHC = new JLabel("Phòng ban:"));
		pnNVHCCenter.add(lbSDTNVHC = new JLabel("Số điện thoại:"));
		pnNVHCCenter.add(lbHocVanVNHC = new JLabel("Học vấn:"));
		pnNVHCCenter.add(tbRegexNVHC = new JLabel(""));
		tbRegexNVHC.setBounds(830, 270, 500	,30);
		tbRegexNVHC.setForeground(Color.red);
		pnNVHCCenter.add(tfMaNVHC = new JTextField());
		pnNVHCCenter.add(tfTenNVHC = new JTextField());
		pnNVHCCenter.add(dateNVHC = new JDateChooser());
		pnNVHCCenter.add(tfChucVuNVHC = new JTextField());
		pnNVHCCenter.add(comGioiTinhNVHC = new JComboBox());
		pnNVHCCenter.add(tfPhongBanNVHC = new JTextField());
		pnNVHCCenter.add(tfSDTNVHC = new JTextField());
		pnNVHCCenter.add(tfHocVanVNHC = new JTextField());
		pnNVHCCenter.add(tfTimNVHC = new JTextField());
		lbMaNVHC.setBounds(150, 30, 100, 30);
		tfMaNVHC.setBounds(240, 30, 300, 30);
		lbGioiTinhNVHC.setBounds(740, 30, 100, 30);
		comGioiTinhNVHC.setBounds(840, 30, 300, 30);
		comGioiTinhNVHC.addItem("Nam");
		comGioiTinhNVHC.addItem("Nữ");
		
		lbTenNVHC.setBounds(150, 75, 100, 30);
		tfTenNVHC.setBounds(240, 75, 300, 30);
		lbTuoiNVHC.setBounds(740, 75, 100, 30);
		dateNVHC.setBounds(840, 75, 300, 30);
		
		lbPhongBanNVHC.setBounds(150, 120, 100, 30);
		tfPhongBanNVHC.setBounds(240, 120, 300, 30);
		lbHocVanVNHC.setBounds(740, 120, 100, 30);
		tfHocVanVNHC.setBounds(840, 120, 300, 30);
		
		lbChucVuNVHC.setBounds(150, 165, 100, 30);
		tfChucVuNVHC.setBounds(240, 165, 300, 30);
		lbSDTNVHC.setBounds(740, 165, 100, 30);
		tfSDTNVHC.setBounds(840, 165, 300, 30);
		btThoatNV.setIcon(back);
		pnNVHC.add(pnNVHCCenter,BorderLayout.CENTER);	
		
		JLabel lbTimNVHC = new JLabel("Tìm kiêm:");
		pnNVHCCenter.add(btThemNVHC = new JButton("Thêm"));
		pnNVHCCenter.add(btXoaNVHC = new JButton("Xóa"));
		pnNVHCCenter.add(btNVHCHuy = new JButton("Hủy"));
		pnNVHCCenter.add(btNVHCCapNhat = new JButton("Cập nhật"));
		pnNVHCCenter.add(btNVHCLuu = new JButton("Lưu"));
		
		pnNVHCCenter.add(lbTimNVHC);
		btThemNVHC.setBounds(20, 240, 130, 30);		
		btNVHCLuu.setBounds(160, 240, 130, 30);		
		btNVHCCapNhat.setBounds(300, 240, 130, 30);
		btXoaNVHC.setBounds(440, 240, 130, 30);
		btNVHCHuy.setBounds(590, 240, 80, 30);
		
		lbTimNVHC.setBounds(720, 240, 130, 30);
		tfTimNVHC.setBounds(830, 240, 130, 30);
		
		ImageIcon add = new ImageIcon("add.png");
		ImageIcon delete = new ImageIcon("delete.png");		
		ImageIcon iconSave = new ImageIcon("save.png");
		ImageIcon update = new ImageIcon("update.png");
		
		btThemNVHC.setIcon(add);	
		btXoaNVHC.setIcon(delete);
		btNVHCLuu.setIcon(iconSave);		
		btNVHCCapNhat.setIcon(update);
		
		JPanel pnNVHCSouth = new JPanel();
		String[] ColNVHC = {"Mã nhân viên","Tên nhân viên","Phòng ban","Chức vụ","Giới tính","Ngày sinh","Học vấn","Số điện thoại"};
		
		tableNVHC = new JTable(modelNVHC = new DefaultTableModel(ColNVHC,0));
		JScrollPane scr = new JScrollPane(tableNVHC,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scr.setPreferredSize(new Dimension(1310,250));
		pnNVHCSouth.add(scr);
		pnNVHCSouth.setBorder(new TitledBorder("Danh sách nhân viên hành chánh"));
		
		pnNVHC.add(pnNVHCSouth,BorderLayout.SOUTH);
		
		btThoatNVKT.setIcon(back);
		btThoat.setIcon(back);
		JPanel pnNVKT = new JPanel();
		pnNVKT.setLayout(new BorderLayout());
		
		JPanel pnNVKTCenter = new JPanel();
		pnNVKTCenter.setLayout(null);
		
		pnNVKTCenter.setBorder(new TitledBorder("Thông tin nhân viên kỹ thuật"));
		JLabel lbMaNVKT,lbTenNVKT,lbTuoiNVKT ,lbChucVuNVKT ,lbGioiTinhNVKT ,lbBacThoNVKT , lbSDTNVKT,lbSoNamKNNVKT ;
		
		pnNVKTCenter.add(lbMaNVKT = new JLabel("Mã Nhân viên:"));
		pnNVKTCenter.add(lbTenNVKT = new JLabel("Tên nhân viên:"));
		pnNVKTCenter.add(lbTuoiNVKT = new JLabel("Ngày sinh:"));
		pnNVKTCenter.add(lbChucVuNVKT = new JLabel("Chức vụ:"));
		pnNVKTCenter.add(lbGioiTinhNVKT = new JLabel("Giới tính:"));
		pnNVKTCenter.add(lbBacThoNVKT = new JLabel("Bậc thợ:"));
		pnNVKTCenter.add(lbSDTNVKT = new JLabel("Số điện thoại:"));
		pnNVKTCenter.add(lbSoNamKNNVKT = new JLabel("Số năm KN:"));
		pnNVKTCenter.add(tbRegexNVKT = new JLabel(""));
		tbRegexNVKT.setBounds(830, 270, 500	,30);
		tbRegexNVKT.setForeground(Color.red);
		pnNVKTCenter.add(tfMaNVKT = new JTextField());
		pnNVKTCenter.add(tfTenNVKT = new JTextField());
		pnNVKTCenter.add(dateNVKT = new JDateChooser());
		pnNVKTCenter.add(tfChucVuNVKT = new JTextField());
		pnNVKTCenter.add(comGioiTinhNVKT = new JComboBox());
		pnNVKTCenter.add(tfBacThoNVKT = new JTextField());
		pnNVKTCenter.add(tfSDTNVKT = new JTextField());
		pnNVKTCenter.add(tfSoNamKNVNKT = new JTextField());
		pnNVKTCenter.add(tfTimNVKT = new JTextField());
		lbMaNVKT.setBounds(150, 30, 100, 30);
		tfMaNVKT.setBounds(240, 30, 300, 30);
		lbGioiTinhNVKT.setBounds(740, 30, 100, 30);
		comGioiTinhNVKT.setBounds(840, 30, 300, 30);
		comGioiTinhNVKT.addItem("Nam");
		comGioiTinhNVKT.addItem("Nữ");
		lbTenNVKT.setBounds(150, 75, 100, 30);
		tfTenNVKT.setBounds(240, 75, 300, 30);
		lbTuoiNVKT.setBounds(740, 75, 100, 30);
		dateNVKT.setBounds(840, 75, 300, 30);
		
		lbBacThoNVKT.setBounds(150, 120, 100, 30);
		tfBacThoNVKT.setBounds(240, 120, 300, 30);
		lbSoNamKNNVKT.setBounds(740, 120, 100, 30);
		tfSoNamKNVNKT.setBounds(840, 120, 300, 30);
		
		lbChucVuNVKT.setBounds(150, 165, 100, 30);
		tfChucVuNVKT.setBounds(240, 165, 300, 30);
		lbSDTNVKT.setBounds(740, 165, 100, 30);
		tfSDTNVKT.setBounds(840, 165, 300, 30);
	
		pnNVKT.add(pnNVKTCenter,BorderLayout.CENTER);	
		
		JLabel lbTimNVKT = new JLabel("Tìm kiếm:");
		pnNVKTCenter.add(btThemNVKT = new JButton("Thêm"));
		pnNVKTCenter.add(btXoaNVKT = new JButton("Xóa"));
		pnNVKTCenter.add(btNVKTHuy = new JButton("Hủy"));
		pnNVKTCenter.add(btNVKTCapNhat = new JButton("Cập nhật"));
		pnNVKTCenter.add(btNVKTLuu = new JButton("Lưu"));
		
		
		pnNVKTCenter.add(lbTimNVKT);
		btThemNVKT.setBounds(20, 240, 130, 30);		
		btNVKTLuu.setBounds(160, 240, 130, 30);		
		btNVKTCapNhat.setBounds(300, 240, 130, 30);
		btXoaNVKT.setBounds(440, 240, 130, 30);
		btNVKTHuy.setBounds(590, 240, 80, 30);
		
		lbTimNVKT.setBounds(720, 240, 130, 30);
		tfTimNVKT.setBounds(830, 240, 130, 30);
		
		
		btThemNVKT.setIcon(add);	
		btXoaNVKT.setIcon(delete);
		btNVKTLuu.setIcon(iconSave);		
		btNVKTCapNhat.setIcon(update);
		
		JPanel pnNVKTSouth = new JPanel();
		String[] ColNVKT = {"Mã nhân viên","Tên nhân viên","Bậc thợ","Chức vụ","Giới tính","Ngày sinh","Số năm kinh nghiệm","Số điện thoại"};
		
		tableNVKT = new JTable(modelNVKT = new DefaultTableModel(ColNVKT,0));
		JScrollPane scrr = new JScrollPane(tableNVKT,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrr.setPreferredSize(new Dimension(1310,250));
		pnNVKTSouth.add(scrr);
		pnNVKTSouth.setBorder(new TitledBorder("Danh sách nhân viên kỹ thuật"));
		
		pnNVKT.add(pnNVKTSouth,BorderLayout.SOUTH);
		
		
		
		JTabbedPane tabbed = new JTabbedPane();
		tabbed.add("Nhân viên hành chánh",pnNVHC);
		tabbed.add("Nhân viên kỹ thuật",pnNVKT);
		
		pnNhanVienCenter.add(tabbed);
		pnNhanVien.add(pnNhanVienNorth,BorderLayout.NORTH);
		pnNhanVien.add(pnNhanVienCenter,BorderLayout.CENTER);
		frameNhanVien.setSize(1350,700);
		frameNhanVien.setLocationRelativeTo(null);
		frameNhanVien.setResizable(false);
		frameNhanVien.setDefaultCloseOperation(frameNhanVien.EXIT_ON_CLOSE);
		
		frameNhanVien.add(pnNhanVien);
		//Xe may
		JPanel pnXeMayMain = new JPanel();
		pnXeMayMain.setLayout(new BorderLayout());
		JPanel pnXeMayNorth = new JPanel();
		
		pnXeMayNorth.add(BackXe = new JButton("Back"));		
		BackXe.setIcon(back);
		BackXe.setPreferredSize(new Dimension(100,30));
		Box boxxe = Box.createHorizontalBox();
		boxxe.add(Box.createHorizontalStrut(1000));
		pnXeMayNorth.add(boxxe);
		JLabel lbXeNorth = new JLabel("QUẢN LÍ XE MÁY");
		lbXeNorth.setForeground(Color.blue);
		lbXeNorth.setFont(fontXe);
		pnXeMayNorth.add(lbXeNorth);
		
		
		JPanel pnXMCenter = new JPanel();
		pnXMCenter.setLayout(new BorderLayout());
		//tab Xe máy
		JPanel pnXeMay = new JPanel();
		pnXeMay.setLayout(new BorderLayout());
		
		JPanel pnXeMayCenter = new JPanel();
		pnXeMayCenter.setLayout(null);
		
		pnXeMayCenter.setBorder(new TitledBorder("Thông tin xe máy"));
		JLabel lbMaXe,lbNuocSX,lbHangSX ,lbMauXe ,lbDonGia ,lbTenXe , lbLoaiXe,lbSoPK ;
		
		pnXeMayCenter.add(lbMaXe = new JLabel("Mã xe:"));
		pnXeMayCenter.add(lbNuocSX = new JLabel("Nước sản xuất:"));
		pnXeMayCenter.add(lbHangSX = new JLabel("Hãng sản xuất:"));
		pnXeMayCenter.add(lbMauXe = new JLabel("Màu xe:"));
		pnXeMayCenter.add(lbDonGia = new JLabel("Đơn giá:"));
		pnXeMayCenter.add(lbTenXe = new JLabel("Tên xe:"));
		pnXeMayCenter.add(lbLoaiXe = new JLabel("Loại xe:"));
		pnXeMayCenter.add(lbSoPK = new JLabel("Số phân khối:"));
		
		
		pnXeMayCenter.add(tfMaXe = new JTextField());
		pnXeMayCenter.add(tfNuocSX = new JTextField());
		pnXeMayCenter.add(comHangSX = new JComboBox());
		pnXeMayCenter.add(tfMauXe = new JTextField());
		pnXeMayCenter.add(tfDonGia = new JTextField());
		pnXeMayCenter.add(tfTenXe = new JTextField());
		pnXeMayCenter.add(comLoaiXe = new JComboBox());
		pnXeMayCenter.add(comSoPK = new JComboBox());
		pnXeMayCenter.add(tfTimXe = new JTextField());
		
		
		lbMaXe.setBounds(150, 30, 100, 30);
		tfMaXe.setBounds(240, 30, 300, 30);
		lbTenXe.setBounds(740, 30, 100, 30);
		tfTenXe.setBounds(840, 30, 300, 30);
		
		lbNuocSX.setBounds(150, 75, 100, 30);
		tfNuocSX.setBounds(240, 75, 300, 30);
		lbHangSX.setBounds(740, 75, 100, 30);
		comHangSX.setBounds(840, 75, 300, 30);
		
		lbDonGia.setBounds(150, 120, 100, 30);
		tfDonGia.setBounds(240, 120, 300, 30);
		lbSoPK.setBounds(740, 120, 100, 30);
		comSoPK.setBounds(840, 120, 300, 30);
		
		lbMauXe.setBounds(150, 165, 100, 30);
		tfMauXe.setBounds(240, 165, 300, 30);
		lbLoaiXe.setBounds(740, 165, 100, 30);
		comLoaiXe.setBounds(840, 165, 300, 30);
		
		comSoPK.addItem("Dưới 50cc");
		comSoPK.addItem("50cc");
		comSoPK.addItem("100cc");
		comSoPK.addItem("110cc");
		comSoPK.addItem("125cc");
		comSoPK.addItem("150cc");
		comSoPK.addItem("300cc");
		comSoPK.addItem("400cc");
		comSoPK.addItem("800cc");
		comSoPK.addItem("1000cc");
		
		
		
		pnXeMay.add(pnXeMayCenter,BorderLayout.CENTER);	
		
		JLabel lbTimXe = new JLabel("Tìm kiếm:");
		pnXeMayCenter.add(btXeThem = new JButton("Thêm"));
		pnXeMayCenter.add(btXeXoa = new JButton("Xóa"));
		pnXeMayCenter.add(btXeHuy = new JButton("Hủy"));
		pnXeMayCenter.add(btXeCapNhat = new JButton("Cập nhật"));
		pnXeMayCenter.add(btXeLuu = new JButton("Lưu"));
		pnXeMayCenter.add(tbRegexXe = new JLabel(""));
		tbRegexXe.setBounds(830, 270, 500	,30);
		tbRegexXe.setForeground(Color.red);
		pnXeMayCenter.add(lbTimXe);
		btXeThem.setBounds(20, 240, 130, 30);		
		btXeLuu.setBounds(160, 240, 130, 30);		
		btXeCapNhat.setBounds(300, 240, 130, 30);
		btXeXoa.setBounds(440, 240, 130, 30);
		btXeHuy.setBounds(590, 240, 80, 30);
		
		lbTimXe.setBounds(720, 240, 130, 30);
		tfTimXe.setBounds(830, 240, 130, 30);
		btXeThem.setIcon(add);	
		btXeXoa.setIcon(delete);
		btXeLuu.setIcon(iconSave);		
		btXeCapNhat.setIcon(update);
		
		JPanel pnXeSouth = new JPanel();
		String[] ColXe = {"Mã xe","Tên xe","Nước sản xuất","Hãng sản xuất","Đơn giá","Số phân khối","Màu xe","Loại xe"};
		
		tableXe = new JTable(modelXe = new DefaultTableModel(ColXe,0));
		JScrollPane scrXe = new JScrollPane(tableXe,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrXe.setPreferredSize(new Dimension(1310,250));
		pnXeSouth.add(scrXe);
		pnXeSouth.setBorder(new TitledBorder("Danh sách xe máy"));
		
		pnXeMay.add(pnXeSouth,BorderLayout.SOUTH);
		
		
		JPanel pnHangsx = new JPanel();
		pnHangsx.setLayout(new BorderLayout());
		
		
		
		JPanel pnHSXCenter = new JPanel();
		pnHSXCenter.setLayout(null);
		pnHSXCenter.setBorder(new TitledBorder("Thông tin hãng sản xuất"));
		JLabel lbMaHSX ,lbTenHSX ,lbSoLuongTon ,lbTimHSX;
		
		pnHSXCenter.add(lbMaHSX = new JLabel("Mã hãng SX:"));
		pnHSXCenter.add(tfMaHSX = new JTextField());
		pnHSXCenter.add(lbTenHSX = new JLabel("Tên hãng SX:"));
		pnHSXCenter.add(tfTenHSX = new JTextField());
		pnHSXCenter.add(lbSoLuongTon = new JLabel("Số lượng tồn:"));
		pnHSXCenter.add(tfSoLuongTon = new JTextField());
		pnHSXCenter.add(lbTimHSX = new JLabel("Tìm kiếm:"));
		pnHSXCenter.add(tfTimHSX = new JTextField());
		pnHSXCenter.add(tbRegexHSX = new JLabel(""));
		tbRegexHSX.setBounds(1000, 120, 500	,30);
		tbRegexHSX.setForeground(Color.red);
		pnHSXCenter.add(btHSXThem = new JButton("Thêm"));
		pnHSXCenter.add(btHSXXoa = new JButton("Xóa"));
		pnHSXCenter.add(btHSXCapNhat = new JButton("Cập nhật"));
		pnHSXCenter.add(btHSXLuu = new JButton("Lưu"));
		pnHSXCenter.add(btHSXHuy = new JButton("Hủy"));
		
		lbMaHSX.setBounds(100, 30, 100, 30);
		tfMaHSX.setBounds(200, 30, 200, 30);
		lbTenHSX.setBounds(500, 30, 100, 30);
		tfTenHSX.setBounds(600, 30, 200, 30);
		lbSoLuongTon.setBounds(900, 30, 100, 30);
		tfSoLuongTon.setBounds(1000, 30, 200, 30);	
	
		lbTimHSX.setBounds(900, 100, 130, 30);
		tfTimHSX.setBounds(1000, 100, 130, 30);
	
		btHSXThem.setBounds(180, 100, 130, 30);		
		btHSXLuu.setBounds(320, 100, 130, 30);			
		btHSXCapNhat.setBounds(460, 100, 130, 30);
		btHSXXoa.setBounds(600, 100, 130, 30);
		btHSXHuy.setBounds(760, 100, 80, 30);
		
		
		
		btHSXThem.setIcon(add);	
		btHSXXoa.setIcon(delete);
		btHSXLuu.setIcon(iconSave);
		btHSXCapNhat.setIcon(update);
		pnHangsx.add(pnHSXCenter,BorderLayout.CENTER);
		
			
		JPanel pnHSXSouth = new JPanel();
		String[] ColHSX = {"Mã Hãng sản xuất","Tên Hãng sản xuất","Số lượng tồn"};
		tableHSX = new JTable(modelHSX = new DefaultTableModel(ColHSX,0));
		JScrollPane scrHSX = new JScrollPane(tableHSX,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrHSX.setPreferredSize(new Dimension(1310,400));
		pnHSXSouth.add(scrHSX);
		pnHSXSouth.setBorder(new TitledBorder("Danh sách hãng sản xuất"));
		pnHangsx.add(pnHSXSouth,BorderLayout.SOUTH);

		JPanel pnLoaiXe = new JPanel();
		pnLoaiXe.setLayout(new BorderLayout());
		
		JPanel pnLoaiCenter = new JPanel();
		pnLoaiCenter.setLayout(null);
		pnLoaiCenter.setBorder(new TitledBorder("Thông tin loại xe"));
		JLabel lbMaLoai,lbTenLoai,lbTimLoai;
		pnLoaiCenter.add(lbMaLoai = new JLabel("Mã loại xe:"));
		pnLoaiCenter.add(tfMaLoai = new JTextField());
		pnLoaiCenter.add(lbTenLoai = new JLabel("Tên loại xe:"));
		pnLoaiCenter.add(tfTenLoai = new JTextField());
		pnLoaiCenter.add(lbTimLoai = new JLabel("Tìm kiếm:"));
		pnLoaiCenter.add(tfTimLoai = new JTextField());
		pnLoaiCenter.add(tbRegexLoai = new JLabel(""));
		tbRegexLoai.setBounds(1000, 120, 500	,30);
		tbRegexLoai.setForeground(Color.red);
		lbMaLoai.setBounds(200, 30, 120, 30);
		tfMaLoai.setBounds(330, 30, 200, 30);
		lbTenLoai.setBounds(740, 30, 120, 30);
		tfTenLoai.setBounds(900, 30, 200, 30);
			
		lbTimLoai.setBounds(900, 100, 130, 30);
		tfTimLoai.setBounds(1000, 100, 130, 30);
		
		pnLoaiCenter.add(btLoaiThem = new JButton("Thêm"));
		pnLoaiCenter.add(btLoaiXoa = new JButton("Xóa"));
		pnLoaiCenter.add(btLoaiCapNhat = new JButton("Cập nhật"));
		pnLoaiCenter.add(btLoaiLuu = new JButton("Lưu"));
		pnLoaiCenter.add(btLoaiHuy = new JButton("Hủy"));
		
		btLoaiThem.setBounds(180, 100, 130, 30);		
		btLoaiLuu.setBounds(320, 100, 130, 30);		
		btLoaiCapNhat.setBounds(460, 100, 130, 30);
		btLoaiXoa.setBounds(600, 100, 130, 30);
		btLoaiHuy.setBounds(760, 100, 80, 30);
		
		btLoaiThem.setIcon(add);	
		btLoaiXoa.setIcon(delete);
		btLoaiLuu.setIcon(iconSave);
		btLoaiCapNhat.setIcon(update);
		pnLoaiXe.add(pnLoaiCenter,BorderLayout.CENTER);
		
		JPanel pnloaiSouth = new JPanel();
		String[] ColLoai = {"Mã loại xe","Tên loại xe"};
		tableLoai = new JTable(modelLoai = new DefaultTableModel(ColLoai,0));
		JScrollPane scrLoai = new JScrollPane(tableLoai,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrLoai.setPreferredSize(new Dimension(1310,400));
		pnloaiSouth.add(scrLoai);
		pnloaiSouth.setBorder(new TitledBorder("Danh sách loại xe"));
		
		pnLoaiXe.add(pnloaiSouth,BorderLayout.SOUTH);
		
		JTabbedPane tabbedxe = new JTabbedPane();
		tabbedxe.add("Xe Máy",pnXeMay);
		tabbedxe.add("Hãng sản xuất",pnHangsx);
		tabbedxe.add("Loại xe",pnLoaiXe);
		
		pnXMCenter.add(tabbedxe);
		pnXeMayMain.add(pnXeMayNorth,BorderLayout.NORTH);
		pnXeMayMain.add(pnXMCenter,BorderLayout.CENTER);
		frameXeMay.setSize(1350,700);
		frameXeMay.setLocationRelativeTo(null);
		frameXeMay.setResizable(false);
		frameXeMay.setDefaultCloseOperation(frameXeMay.EXIT_ON_CLOSE);
		
		frameXeMay.add(pnXeMayMain);
		//Hop dong
		JPanel pnHopDong = new JPanel();
		pnHopDong.setLayout(new BorderLayout());
		JPanel pnHopDongNorth = new JPanel();
		
		pnHopDongNorth.add(BackHD = new JButton("Back"));		
		BackHD.setIcon(back);
		BackHD.setPreferredSize(new Dimension(100,30));
		Box boxhd = Box.createHorizontalBox();
		boxhd.add(Box.createHorizontalStrut(1000));
		pnHopDongNorth.add(boxhd);
		JLabel lbHDNorth = new JLabel("QUẢN LÍ HỢP ĐỒNG");
		lbHDNorth.setForeground(Color.blue);
		lbHDNorth.setFont(fontXe);
		pnHopDongNorth.add(lbHDNorth);
		
		
		JPanel pnHopDongCenter = new JPanel();
		pnHopDongCenter.setLayout(new BorderLayout());
		
		JPanel pnHD = new JPanel();
		pnHD.setLayout(new BorderLayout());
		
		JPanel pnHDCenter = new JPanel();
		pnHDCenter.setLayout(null);
		
		pnHDCenter.setBorder(new TitledBorder("Thông tin Hợp đồng"));
		JLabel lbTenKHHD,lbDCKHHD,lbLoaiHD ,lbSDTKHHD ,lbNVLap  ,lbNgayLapHD ,lbMaHD,lbTGBHHD,lbThang;
		
		pnHDCenter.add(lbTenKHHD = new JLabel("Tên khách hàng:"));
		pnHDCenter.add(lbDCKHHD = new JLabel("Địa chỉ:"));
		pnHDCenter.add(lbLoaiHD = new JLabel("Loại hợp đồng:"));		
		pnHDCenter.add(lbSDTKHHD = new JLabel("Số điện thoại:"));
		pnHDCenter.add(lbNVLap = new JLabel("Nhân viên lập:"));		
		pnHDCenter.add(lbNgayLapHD = new JLabel("Ngày lập:"));
		pnHDCenter.add(lbMaHD = new JLabel("Mã hợp đồng:"));
		pnHDCenter.add(lbTGBHHD = new JLabel("Thời gian bảo hành:"));
		pnHDCenter.add(lbThang = new JLabel("Tháng"));
		pnHDCenter.add(tbRegexHD = new JLabel(""));
		tbRegexHD.setBounds(720, 260, 500	,30);
		tbRegexHD.setForeground(Color.red);
		
		pnHDCenter.add(tfTenKHHD = new JTextField());
		pnHDCenter.add(tfDCKHHD = new JTextField());
		pnHDCenter.add(comLoaiHD = new JComboBox());
		pnHDCenter.add(tfSDTKHHD = new JTextField());
		pnHDCenter.add(tfNVLap = new JTextField());
		pnHDCenter.add(ngayLapHD = new JDateChooser());
		pnHDCenter.add(tfMaHD = new JTextField());
		pnHDCenter.add(tfTGBHHD = new JTextField());
		pnHDCenter.add(tfTimHD = new JTextField());
		
		lbMaHD.setBounds(140, 30, 100, 30);
		tfMaHD.setBounds(240, 30, 300, 30);
		lbLoaiHD.setBounds(740, 30, 100, 30);
		comLoaiHD.setBounds(880, 30, 300, 30);
		
		lbTenKHHD.setBounds(140, 75, 100, 30);
		tfTenKHHD.setBounds(240, 75, 300, 30);		
		lbSDTKHHD.setBounds(740, 75, 100, 30);
		tfSDTKHHD.setBounds(880, 75, 300, 30);
		
		lbNVLap.setBounds(140, 120, 100, 30);
		tfNVLap.setBounds(240, 120, 300, 30);
		lbTGBHHD.setBounds(740, 120, 150, 30);
		tfTGBHHD.setBounds(880, 120, 100, 30);
		lbThang.setBounds(1000, 120, 150, 30);
		
		lbDCKHHD.setBounds(140, 165, 100, 30);
		tfDCKHHD.setBounds(240, 165, 450, 30);
		lbNgayLapHD.setBounds(740, 165, 100, 30);
		ngayLapHD.setBounds(880, 165, 300, 30);
		
		comLoaiHD.addItem("Hợp đồng trả hết");
		comLoaiHD.addItem("Hợp đồng trả góp");
		pnHD.add(pnHDCenter,BorderLayout.CENTER);	
		
		JLabel lbTimHD = new JLabel("Tìm kiếm:");
		
		pnHDCenter.add(btThemHD = new JButton("Thêm"));
		pnHDCenter.add(btXoaHD = new JButton("Xóa"));
		pnHDCenter.add(btHDHuy = new JButton("Hủy"));
		pnHDCenter.add(btHDCapNhat = new JButton("Cập nhật"));
		pnHDCenter.add(btHDLuu = new JButton("Lưu"));
	
		pnHDCenter.add(tfTimHD);
		pnHDCenter.add(lbTimHD);
		btThemHD.setBounds(20, 240, 130, 30);		
		btHDLuu.setBounds(160, 240, 130, 30);		
		btHDCapNhat.setBounds(300, 240, 130, 30);
		btXoaHD.setBounds(440, 240, 130, 30);
		btHDHuy.setBounds(590, 240, 80, 30);
		
		lbTimHD.setBounds(720, 240, 130, 30);
		tfTimHD.setBounds(870, 240, 130, 30);
		
		btThemHD.setIcon(add);	
		btXoaHD.setIcon(delete);
		btHDLuu.setIcon(iconSave);		
		btHDCapNhat.setIcon(update);
		
		JPanel pnHDSouth = new JPanel();
		String[] ColHD = {"Mã hợp đồng","Tên khách hàng","Nhân viên lập","Địa chỉ","Loại hợp đồng","Số điện thoại","Thời gian bảo hành","Ngày lập"};
		
		tableHD = new JTable(modelHD = new DefaultTableModel(ColHD,0));
		JScrollPane scrHD = new JScrollPane(tableHD,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrHD.setPreferredSize(new Dimension(1310,250));
		pnHDSouth.add(scrHD);
		pnHDSouth.setBorder(new TitledBorder("Danh sách Hợp đồng"));
		
		pnHD.add(pnHDSouth,BorderLayout.SOUTH);
		
		
		JPanel pnHD1L = new JPanel();
		pnHD1L.setLayout(new BorderLayout());
		
		JPanel pnHD1LCenter = new JPanel();
		pnHD1LCenter.setLayout(null);
		
		pnHD1LCenter.setBorder(new TitledBorder("Thông tin Hợp đồng 1 lần"));
		JLabel lbMaHD1L,lbMaXeHD1L,lbNVLHD1L ,lbGiaXeHD1L ,lbTenXeHD1L ,lbTimHD1L  ;
		
		pnHD1LCenter.add(lbMaHD1L = new JLabel("Mã hợp đồng:"));
		pnHD1LCenter.add(lbMaXeHD1L = new JLabel("Mã xe:"));
		pnHD1LCenter.add(lbNVLHD1L = new JLabel("Nhân viên lập:"));
		pnHD1LCenter.add(lbGiaXeHD1L = new JLabel("Giá xe:"));
		pnHD1LCenter.add(lbTenXeHD1L = new JLabel("Tên xe:"));
		pnHD1LCenter.add(lbTienThanhToanHD1L = new JLabel("Tổng tiền:"));
		/*pnHD1LCenter.add(tbRegexHD1L = new JLabel("0"));
		tbRegexHD1L.setBounds(720, 260, 500	,30);*/
		
		Font fontTongTien = new Font("Arial", Font.ITALIC, 20);
		lbTienThanhToanHD1L.setFont(fontTongTien);
		lbTienThanhToanHD1L.setForeground(Color.red);
		
		pnHD1LCenter.add(comMaHD1L = new JComboBox());
		pnHD1LCenter.add(comMaXeHD1L = new JComboBox());
		pnHD1LCenter.add(tfNVLHD1L = new JTextField());
		pnHD1LCenter.add(tfGiaxeHD1L = new JTextField());
		pnHD1LCenter.add(tfTenXeHD1L = new JTextField());
		
		pnHD1LCenter.add(tfTimHD1L = new JTextField());
		pnHD1LCenter.add(lbTimHD1L = new JLabel("Tìm kiếm:"));
		tfTimHD1L.setBounds(870, 240, 130, 30);
		lbTimHD1L.setBounds(720, 240, 130, 30);
		
		lbMaHD1L.setBounds(150, 30, 100, 30);
		comMaHD1L.setBounds(240, 30, 300, 30);
		lbMaXeHD1L.setBounds(740, 30, 100, 30);
		comMaXeHD1L.setBounds(840, 30, 300, 30);
		
		lbNVLHD1L.setBounds(150, 75, 100, 30);
		tfNVLHD1L.setBounds(240, 75, 300, 30);
		lbGiaXeHD1L.setBounds(740, 75, 100, 30);
		tfGiaxeHD1L.setBounds(840, 75, 300, 30);
		
		lbTenXeHD1L.setBounds(150, 120, 100, 30);
		tfTenXeHD1L.setBounds(240, 120, 300, 30);	
		lbTienThanhToanHD1L.setBounds(740, 120, 500, 30);

		pnHD1L.add(pnHD1LCenter,BorderLayout.CENTER);	
		pnHD1LCenter.add(btThemHD1L = new JButton("Thêm"));
		pnHD1LCenter.add(btXoaHD1L = new JButton("Xóa"));
		pnHD1LCenter.add(btHD1LHuy = new JButton("Hủy"));
		pnHD1LCenter.add(btHD1LLuu = new JButton("Lưu"));
		pnHD1LCenter.add(btChonXeHD1L = new JButton("Chọn"));
		pnHD1LCenter.add(btchonMaHD1L = new JButton("Chọn"));
		btchonMaHD1L.setBounds(550, 30, 80, 30);
		btChonXeHD1L.setBounds(1150, 30, 80, 30);
		
		btThemHD1L.setBounds(20, 240, 130, 30);		
		btHD1LLuu.setBounds(160, 240, 130, 30);		
		btXoaHD1L.setBounds(300, 240, 130, 30);
		btHD1LHuy.setBounds(440, 240, 80, 30);
		
		btThemHD1L.setIcon(add);	
		btXoaHD1L.setIcon(delete);
		btHD1LLuu.setIcon(iconSave);		
		
		JPanel pnHD1LSouth = new JPanel();
		String[] ColHD1L = {"Mã hợp đồng","Nhân viên lập","Tên xe","Mã xe","Giá xe"};
		
		tableHD1L = new JTable(modelHD1L = new DefaultTableModel(ColHD1L,0));
		JScrollPane scrHD1L = new JScrollPane(tableHD1L,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrHD1L.setPreferredSize(new Dimension(1310,250));
		pnHD1LSouth.add(scrHD1L);
		pnHD1LSouth.setBorder(new TitledBorder("Danh sách hợp đồng trả 1 lần"));
		
		pnHD1L.add(pnHD1LSouth,BorderLayout.SOUTH);
		
		JPanel pnHDTG = new JPanel();
		pnHDTG.setLayout(new BorderLayout());
		
		JPanel pnHDTGCenter = new JPanel();
		pnHDTGCenter.setLayout(null);
		
		pnHDTGCenter.setBorder(new TitledBorder("Thông tin Hợp đồng 1 lần"));
		JLabel lbMaHDTG,lbMaXeHDTG,lbNVLHDTG ,lbGiaXeHDTG ,lbTenXeHDTG  ,lbNgayTra1,lbNgayTra2,lbNgayTra3,lbTimHDTG;
		
		pnHDTGCenter.add(lbMaHDTG = new JLabel("Mã hợp đồng:"));
		pnHDTGCenter.add(lbMaXeHDTG = new JLabel("Mã xe:"));
		pnHDTGCenter.add(lbNVLHDTG = new JLabel("Nhân viên lập:"));
		pnHDTGCenter.add(lbGiaXeHDTG = new JLabel("Giá xe:"));
		pnHDTGCenter.add(lbTenXeHDTG = new JLabel("Tên xe:"));
		pnHDTGCenter.add(lbTienThanhToanHDTG = new JLabel("Tổng tiền:"));
		pnHDTGCenter.add(lbNgayTra1 = new JLabel("Trả lần 1:"));
		pnHDTGCenter.add(lbNgayTra2 = new JLabel("Trả lần 2:"));
		pnHDTGCenter.add(lbNgayTra3 = new JLabel("Trả lần 3:"));
		
		pnHDTGCenter.add(comMaHDTG = new JComboBox());
		pnHDTGCenter.add(comMaXeHDTG = new JComboBox());
		pnHDTGCenter.add(tfNVLHDTG = new JTextField());
		pnHDTGCenter.add(tfGiaxeHDTG = new JTextField());
		pnHDTGCenter.add(tfTenXeHDTG = new JTextField());
		pnHDTGCenter.add(ngayTra1 = new JDateChooser ());
		pnHDTGCenter.add(ngayTra2 = new JDateChooser ());
		pnHDTGCenter.add(ngayTra3 = new JDateChooser ());
		pnHDTGCenter.add(tfNgayTra1 = new JTextField());
		pnHDTGCenter.add(tfNgayTra2 = new JTextField());
		pnHDTGCenter.add(tfNgayTra3 = new JTextField());

		pnHDTGCenter.add(lbTimHDTG = new JLabel("Tìm kiếm:"));
		pnHDTGCenter.add(tfTimHDTG = new JTextField());
		lbTimHDTG.setBounds(720, 240, 130, 30);
		tfTimHDTG.setBounds(870, 240, 130, 30);
		/*pnHDTGCenter.add(tbRegexHDTG = new JLabel("0"));
		tbRegexHDTG.setBounds(720, 260, 500	,30);*/
		
		lbMaHDTG.setBounds(150, 30, 100, 30);
		comMaHDTG.setBounds(240, 30, 300, 30);
		lbMaXeHDTG.setBounds(740, 30, 100, 30);
		comMaXeHDTG.setBounds(840, 30, 300, 30);
		
		lbNVLHDTG.setBounds(150, 75, 100, 30);
		tfNVLHDTG.setBounds(240, 75, 300, 30);
		lbGiaXeHDTG.setBounds(740, 75, 100, 30);
		tfGiaxeHDTG.setBounds(840, 75, 300, 30);
		
		lbTenXeHDTG.setBounds(150, 120, 100, 30);
		tfTenXeHDTG.setBounds(240, 120, 300, 30);
		lbTienThanhToanHDTG.setBounds(740, 120, 500, 30);
		lbTienThanhToanHDTG.setFont(fontTongTien);
		lbTienThanhToanHDTG.setForeground(Color.red);
		
		lbNgayTra1.setBounds(25, 160, 80, 30);
		ngayTra1.setBounds(105, 160, 100, 30);
		tfNgayTra1.setBounds(220, 160, 80, 30);
		
		lbNgayTra2.setBounds(460, 160, 80, 30);
		ngayTra2.setBounds(550, 160, 100, 30);
		tfNgayTra2.setBounds(670, 160, 80, 30);
		
		lbNgayTra3.setBounds(895, 160, 80, 30);
		ngayTra3.setBounds(995, 160, 100, 30);
		tfNgayTra3.setBounds(1115, 160, 80, 30);
		pnHDTG.add(pnHDTGCenter,BorderLayout.CENTER);	
		
		
		
		pnHDTGCenter.add(btThemHDTG = new JButton("Thêm"));
		pnHDTGCenter.add(btXoaHDTG = new JButton("Xóa"));
		pnHDTGCenter.add(btHDTGHuy = new JButton("Hủy"));
		pnHDTGCenter.add(btHDTGLuu = new JButton("Lưu"));
		pnHDTGCenter.add(btTra1 = new JButton("Trả"));
		pnHDTGCenter.add(btTra2 = new JButton("Trả"));
		pnHDTGCenter.add(btTra3 = new JButton("Trả"));
		pnHDTGCenter.add(btChonXeHDTG = new JButton("Chọn"));
		pnHDTGCenter.add(btchonMaHDTG = new JButton("Chọn"));
		btchonMaHDTG.setBounds(550, 30, 80, 30);
		btChonXeHDTG.setBounds(1150, 30, 80, 30);

		
		
		btThemHDTG.setBounds(20, 240, 130, 30);		
		btHDTGLuu.setBounds(160, 240, 130, 30);		
		btXoaHDTG.setBounds(300, 240, 130, 30);
		btHDTGHuy.setBounds(440, 240, 80, 30);
		
		
		btTra1.setBounds(310, 160, 70, 30);
		btTra2.setBounds(760, 160, 70, 30);
		btTra3.setBounds(1210, 160, 70, 30);
		btThemHDTG.setIcon(add);	
		btXoaHDTG.setIcon(delete);
		btHDTGLuu.setIcon(iconSave);		
		
		JPanel pnHDTGSouth = new JPanel();
		String[] ColHDTG = {"Mã hợp đồng","Nhân viên lập","Tên xe","Mã xe","Giá xe"};
		
		tableHDTG = new JTable(modelHDTG = new DefaultTableModel(ColHDTG,0));
		JScrollPane scrHDTG = new JScrollPane(tableHDTG,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrHDTG.setPreferredSize(new Dimension(1310,250));
		pnHDTGSouth.add(scrHDTG);
		pnHDTGSouth.setBorder(new TitledBorder("Danh sách hợp đồng trả góp"));
		
		pnHDTG.add(pnHDTGSouth,BorderLayout.SOUTH);
		
		JTabbedPane tabbedHD = new JTabbedPane();
		tabbedHD.add("Hợp đồng",pnHD);
		tabbedHD.add("Hợp đồng trả hết",pnHD1L);
		tabbedHD.add("Hợp đồng trả góp",pnHDTG);
		pnHopDongCenter.add(tabbedHD);
		pnHopDong.add(pnHopDongNorth,BorderLayout.NORTH);
		pnHopDong.add(pnHopDongCenter,BorderLayout.CENTER);
		
		
		
		frameHopDong.setDefaultCloseOperation(frameHopDong.EXIT_ON_CLOSE);
		frameHopDong.setSize(1350, 700);
		frameHopDong.setResizable(false);
		frameHopDong.setLocationRelativeTo(null);
		
		frameHopDong.add(pnHopDong);
		//Bao Hanh
		JPanel pnBaoHanh = new JPanel();
		pnBaoHanh.setLayout(new BorderLayout());
		JPanel pnBaoHanhNorth = new JPanel();
		
		pnBaoHanhNorth.add(BackBH = new JButton("Back"));		
		BackBH.setIcon(back);
		BackBH.setPreferredSize(new Dimension(100,30));
		Box boxBH = Box.createHorizontalBox();
		boxBH.add(Box.createHorizontalStrut(950));
		pnBaoHanhNorth.add(boxBH);
		JLabel lbBHNorth = new JLabel("QUẢN LÍ PHIẾU BẢO HÀNH");
		lbBHNorth.setForeground(Color.blue);
		lbBHNorth.setFont(fontXe);
		pnBaoHanhNorth.add(lbBHNorth);
		
		
		JPanel pnBaoHanhCenter = new JPanel();
		pnBaoHanhCenter.setLayout(new BorderLayout());
		
		
		JPanel pnBH = new JPanel();
		pnBH.setLayout(new BorderLayout());
		
		JPanel pnBHCenter = new JPanel();
		pnBHCenter.setLayout(null);
		
		pnBHCenter.setBorder(new TitledBorder("Thông tin phiếu bảo hành"));
		JLabel lbMaPhieu,lbMaXeBH,lbTenXeBh,lbHSXBH,lbLoaiXeBH, lbMaHDBH,lbLoaiHDBH,lbNhanVienLapBH
		,lbThoiGianBaoHanhBH,lbNgayLapHDBH,lbNhanVienKyThuat ,lbLiDoBH ,lbLoiDo ,lbTenLinhKien,lbNgayBaoHanh,lbTimBH  ;
		
		pnBHCenter.add(lbMaPhieu = new JLabel("Mã phiếu:"));
		pnBHCenter.add(lbMaXeBH = new JLabel("Mã xe:"));
		pnBHCenter.add(lbTenXeBh = new JLabel("Tên xe:"));
		pnBHCenter.add(lbHSXBH = new JLabel("Hãng sản xuất:"));
		pnBHCenter.add(lbLoaiXeBH = new JLabel("Loại xe:"));
		
		pnBHCenter.add(lbMaHDBH = new JLabel("Mã hợp đồng:"));
		pnBHCenter.add(lbLoaiHDBH = new JLabel("Loại hợp đồng:"));
		pnBHCenter.add(lbNhanVienLapBH = new JLabel("Nhân viên lập:"));
		pnBHCenter.add(lbThoiGianBaoHanhBH = new JLabel("Thời gian bảo hành:"));
		pnBHCenter.add(lbNgayLapHDBH = new JLabel("Ngày lập:"));
		
		pnBHCenter.add(lbNhanVienKyThuat = new JLabel("Nhân viên KT phụ trách:"));
		pnBHCenter.add(lbLiDoBH = new JLabel("Lí do bảo hành:"));
		pnBHCenter.add(lbLoiDo = new JLabel("Lỗi do:"));
		pnBHCenter.add(lbTenLinhKien = new JLabel("Tên linh kiện:"));
		pnBHCenter.add(lbNgayBaoHanh = new JLabel("Ngày bảo hành:"));
		
		
		pnBHCenter.add(tfTimBH = new JTextField());
		pnBHCenter.add(lbTimBH = new JLabel("Tìm kiếm:"));
		tfTimBH.setBounds(1000, 250, 130, 30);
		lbTimBH.setBounds(900, 250, 130, 30);
		pnBHCenter.add(tbRegexBH = new JLabel(""));
		tbRegexBH.setBounds(720, 270, 500	,30);
		tbRegexBH.setForeground(Color.red);
		pnBHCenter.add(tfMaPhieu = new JTextField());
		pnBHCenter.add(comMaXeBH = new JComboBox());
		pnBHCenter.add(tfTenXeBh = new JTextField());
		pnBHCenter.add(tfHSXBH = new JTextField());
		pnBHCenter.add(tfLoaiXeBH = new JTextField());
		
		
	
		pnBHCenter.add(tfMaHDBH = new JTextField());
		pnBHCenter.add(tfLoaiHDBH = new JTextField());
		pnBHCenter.add(tfNhanVienLapBH = new JTextField());
		pnBHCenter.add(tfThoiGianBaoHanhBH = new JTextField());
		pnBHCenter.add(tfNgayLapHDBH = new JTextField());
		
		
		pnBHCenter.add(tfNhanVienKyThuat = new JTextField());
		pnBHCenter.add(tfLiDoBH = new JTextField());
		pnBHCenter.add(comLoiDo = new JComboBox());
		pnBHCenter.add(comTenLinhKien = new JComboBox());
		pnBHCenter.add(ngayBaoHanh = new JDateChooser());
		
		lbMaPhieu.setBounds(90, 30, 100, 30);
		tfMaPhieu.setBounds(200, 30, 150, 30);
		lbMaXeBH.setBounds(90, 75, 100, 30);
		comMaXeBH.setBounds(200, 75, 150, 30);
		lbTenXeBh.setBounds(90, 120, 100, 30);
		tfTenXeBh.setBounds(200, 120, 150, 30);
		lbHSXBH.setBounds(90, 165, 100, 30);
		tfHSXBH.setBounds(200, 165, 150, 30);
		lbLoaiXeBH.setBounds(90, 210, 100, 30);
		tfLoaiXeBH.setBounds(200,210,150,30);
		
		
		lbMaHDBH.setBounds(500, 30, 100, 30);
		tfMaHDBH.setBounds(630, 30, 150, 30);	
		lbLoaiHDBH.setBounds(500, 75, 100, 30);
		tfLoaiHDBH.setBounds(630, 75, 150, 30);	
		lbNhanVienLapBH.setBounds(500, 120, 100, 30);	
		tfNhanVienLapBH.setBounds(630, 120, 150, 30);	
		lbThoiGianBaoHanhBH.setBounds(500, 165, 120, 30);	
		tfThoiGianBaoHanhBH.setBounds(630, 165, 150, 30);	
		lbNgayLapHDBH.setBounds(500, 210, 100, 30);	
		tfNgayLapHDBH.setBounds(630, 210, 150, 30);	
		
		
		
		lbNhanVienKyThuat.setBounds(840, 30, 150, 30);
		tfNhanVienKyThuat.setBounds(1020, 30, 150, 30);	
		lbLiDoBH.setBounds(840, 75, 100, 30);
		tfLiDoBH.setBounds(1020, 75, 150, 30);	
		lbLoiDo.setBounds(840, 120, 100, 30);	
		comLoiDo.setBounds(1020, 120, 150, 30);
		lbTenLinhKien.setBounds(840, 165, 100, 30);	
		comTenLinhKien.setBounds(1020, 165, 150, 30);	
		lbNgayBaoHanh.setBounds(840, 210, 100, 30);	
		ngayBaoHanh.setBounds(1020, 210, 150, 30);	
		
		
		comLoiDo.addItem("Khách hàng");
		comLoiDo.addItem("Sản phẩm");
		pnBH.add(pnBHCenter,BorderLayout.CENTER);	
		
		pnBHCenter.add(btThemBH = new JButton("Thêm"));
		pnBHCenter.add(btXoaBH = new JButton("Xóa"));
		pnBHCenter.add(btBHHuy = new JButton("Hủy"));
		pnBHCenter.add(btBHCapNhat = new JButton("Cập nhật"));
		pnBHCenter.add(btBHLuu = new JButton("Lưu"));
		pnBHCenter.add(btChonMaBH = new JButton("Chọn"));
		btBHLuu.setEnabled(false);
		btChonMaBH.setBounds(370, 75, 80, 30);
		
		btThemBH.setBounds(20, 250, 130, 30);		
		btBHLuu.setBounds(160, 250, 130, 30);		
		btBHCapNhat.setBounds(300, 250, 130, 30);
		btXoaBH.setBounds(440, 250, 130, 30);
		btBHHuy.setBounds(590, 250, 80, 30);
		
		btThemBH.setIcon(add);	
		btXoaBH.setIcon(delete);
		btBHLuu.setIcon(iconSave);		
		btBHCapNhat.setIcon(update);
		
		JPanel pnBHSouth = new JPanel();
		String[] ColBH = {"Mã phiếu","Mã xe","Tên xe","Hãng sản xuất","Loại xe","Mã hợp đồng","Loại hợp đồng","Nhân viên lập"
				,"Thời gian bảo hành","Ngày lập hợp đồng","Nhân viên phụ trách","Lí do bảo hành","Lỗi do","Tên linh kiện","Ngày bảo hành"};
		
		tableBH = new JTable(modelBH = new DefaultTableModel(ColBH,0));
		JScrollPane scrBH = new JScrollPane(tableBH,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrBH.setPreferredSize(new Dimension(1310,250));
		pnBHSouth.add(scrBH);
		pnBHSouth.setBorder(new TitledBorder("Danh sách phiếu bảo hành"));
		
		pnBH.add(pnBHSouth,BorderLayout.SOUTH);
		
		JPanel pnLK = new JPanel();
		pnLK.setLayout(new BorderLayout());
		
		JPanel pnLKCenter = new JPanel();
		pnLKCenter.setLayout(null);
		
		pnLKCenter.setBorder(new TitledBorder("Thông tin Linh kiện"));
		JLabel lbMaLK,lbTenLK,lbTimLK;
		
		pnLKCenter.add(lbMaLK = new JLabel("Mã linh kiện:"));
		pnLKCenter.add(lbTenLK = new JLabel("Tên linh kiện:"));
		
		
		pnLKCenter.add(tfMaLK = new JTextField());
		pnLKCenter.add(tfTenLK = new JTextField());
		

		lbMaLK.setBounds(150, 30, 100, 30);
		tfMaLK.setBounds(240, 30, 300, 30);
		lbTenLK.setBounds(740, 30, 100, 30);
		tfTenLK.setBounds(840, 30, 300, 30);
		
		pnLKCenter.add(lbTimLK = new JLabel("Tìm kiếm:"));
		pnLKCenter.add(tfTimLK = new JTextField());
		
		lbTimLK.setBounds(740, 100, 100, 30);
		tfTimLK.setBounds(840, 100, 100, 30);
		pnLKCenter.add(tbRegexLK = new JLabel("0"));
		tbRegexLK.setBounds(720, 270, 500	,30);
		tbRegexLK.setForeground(Color.red);
		pnLK.add(pnLKCenter,BorderLayout.CENTER);	
		
		
		
		pnLKCenter.add(btThemLK = new JButton("Thêm"));
		pnLKCenter.add(btXoaLK = new JButton("Xóa"));
		pnLKCenter.add(btLKHuy = new JButton("Hủy"));
		pnLKCenter.add(btLKCapNhat = new JButton("Cập nhật"));
		pnLKCenter.add(btLKLuu = new JButton("Lưu"));
		btLKLuu.setEnabled(false);
		
		pnLKCenter.add(lbTimLK);
		btThemLK.setBounds(20, 100, 130, 30);		
		btLKLuu.setBounds(160, 100, 130, 30);		
		btLKCapNhat.setBounds(300, 100, 130, 30);
		btXoaLK.setBounds(440, 100, 130, 30);
		btLKHuy.setBounds(590, 100, 80, 30);
		
		
		btThemLK.setIcon(add);	
		btXoaLK.setIcon(delete);
		btLKLuu.setIcon(iconSave);		
		btLKCapNhat.setIcon(update);
		
		JPanel pnLKSouth = new JPanel();
		String[] ColLK = {"Mã linh kiện","Tên linh kiện"};
		
		tableLK = new JTable(modelLK = new DefaultTableModel(ColLK,0));
		JScrollPane scrLK = new JScrollPane(tableLK,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrLK.setPreferredSize(new Dimension(1310,400));
		pnLKSouth.add(scrLK);
		pnLKSouth.setBorder(new TitledBorder("Danh sách linh kiện"));
		
		pnLK.add(pnLKSouth,BorderLayout.SOUTH);
		
		JTabbedPane tabbedBH = new JTabbedPane();
		tabbedBH.add("Phiếu bảo hành",pnBH);
		tabbedBH.add("Linh kiện",pnLK);
		
		pnBaoHanhCenter.add(tabbedBH);
		pnBaoHanh.add(pnBaoHanhNorth,BorderLayout.NORTH);
		pnBaoHanh.add(pnBaoHanhCenter,BorderLayout.CENTER);
		
		/*btNhanVien.setIcon(employ);
		btBaoHanh.setIcon(insurance);
		btHopDong.setIcon(contract);*/
		
		frameBaoHanh.setDefaultCloseOperation(frameBaoHanh.EXIT_ON_CLOSE);
		frameBaoHanh.setSize(1350, 700);
		frameBaoHanh.setResizable(false);
		frameBaoHanh.setLocationRelativeTo(null);
		
		frameBaoHanh.add(pnBaoHanh);
		
		
		
		ngayLapHD.setDateFormatString("dd/MM/yyyy");
		dateNVHC.setDateFormatString("dd/MM/yyyy");
		dateNVKT.setDateFormatString("dd/MM/yyyy");
		ngayTra1.setDateFormatString("dd/MM/yyyy");
		ngayTra2.setDateFormatString("dd/MM/yyyy");
		ngayTra3.setDateFormatString("dd/MM/yyyy");
		ngayBaoHanh.setDateFormatString("dd/MM/yyyy");
		JTextFieldDateEditor edit1 = (JTextFieldDateEditor) ngayLapHD.getDateEditor();
		edit1.setEditable(false);
		JTextFieldDateEditor edit2 = (JTextFieldDateEditor) dateNVHC.getDateEditor();
		edit2.setEditable(false);
		JTextFieldDateEditor edit3 = (JTextFieldDateEditor) dateNVKT.getDateEditor();
		edit3.setEditable(false);
		JTextFieldDateEditor edit4 = (JTextFieldDateEditor) ngayTra1.getDateEditor();
		edit4.setEditable(false);
		JTextFieldDateEditor edit5 = (JTextFieldDateEditor) ngayTra2.getDateEditor();
		edit5.setEditable(false);
		JTextFieldDateEditor edit6 = (JTextFieldDateEditor) ngayTra3.getDateEditor();
		edit6.setEditable(false);
		JTextFieldDateEditor edit7 = (JTextFieldDateEditor) ngayBaoHanh.getDateEditor();
		edit7.setEditable(false);
		tfNVLap.setEnabled(false);
		tfNhanVienKyThuat.setEnabled(false);
		btChonXeHD1L.setEnabled(false);
		btChonXeHDTG.setEnabled(false);
		
		
		//Đăng ký lắng nghe 
		
		//    Sự kiện trong giao diện Đăng nhập
		//			Button đăng nhập
		btLogin.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfTenDangNhap.getText().equals("") || tfMatKhau.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin đăng nhập");
				}
				else if(tfTenDangNhap.getText().equals("admin") && tfMatKhau.getText().equals("admin")){
					frameQL.setVisible(true);
					frameLogin.setVisible(false);
					
				} 	
				else if(tfMatKhau.getText().equals(tkhc_dao.getMatKhauHC(tfTenDangNhap.getText()))){
					frameChucNangNV.setVisible(true);
					frameLogin.setVisible(false);
					String ma = tkhc_dao.getMaNV(tfTenDangNhap.getText());
					String ten = nvhc_dao.getTenNhanVienHC(ma);
					tfNVLap.setText(ten);				
				}
				else if(tfMatKhau.getText().equals(tkkt_dao.getMatKhauKT(tfTenDangNhap.getText()))){
					frameChucNangNVKT.setVisible(true);
					frameLogin.setVisible(false);
					String ma = tkkt_dao.getMaNV(tfTenDangNhap.getText());
					String ten = nvkt_dao.getTenNhanVienKT(ma);
					tfNhanVienKyThuat.setText(ten);
				}
				
				else{			
					JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng");						
				}				
			}
		});
		
		//			Button thoát
		btExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
				
			}
		});
		//------------------------------------------------
		//	Sự kiện của giao diện quản lí
		//			Button trở về giao diện đăng nhập từ giao diện quản lí
		//
		
		btThoat.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				frameLogin.setVisible(true);
				frameQL.setVisible(false);				
			}
		});
		//		Button mở giao diện nhân viên của quản lí
		btNhanVien.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				frameNhanVien.setVisible(true);
				frameQL.setVisible(false);
					
			}
		});
		//		Button mở giao diện đăng ký tài khoản cho nhân viên
		btTaiKhoan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameRes.setVisible(true);
				frameQL.setVisible(false);
				
			}
		});
		//--------------------------------------------------------
		//	Sử lí sự kiện giao diện đăng ký	
		//		Button đăng ký tài khoản
		btRes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfTenDangKy.getText().equals("") || tfMatKhauDK.getText().equals("") || tfNhapLaiMK.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else if (tfTenDangKy.getText().equalsIgnoreCase("admin")){
					JOptionPane.showMessageDialog(null, "Không được phép đặt tên đăng nhập bằng 'admin'");
				}
				else if(tfNhapLaiMK.getText().equalsIgnoreCase(tfMatKhauDK.getText())){
					//
					if(comMaNVKTDK.getItemCount()==0 && comMaNVHCDK.getItemCount()==0){			
						JOptionPane.showMessageDialog(null, "Vui lòng chọn mã nhân viên để tạo tài khoản");
					}
					else if(comMaNVKTDK.getItemCount()==0){			
						
						try {	
							String ten =tfTenDangKy.getText();
							String mk =tfMatKhauDK.getText();
							String maHC = comMaNVHCDK.getSelectedItem().toString();
							if(tkhc_dao.taoTaiKhoanNVHC(new TaiKhoanHC(ten, mk, new NhanVienHanhChanh(maHC)))==true){
								JOptionPane.showMessageDialog(null, "Tạo tài khoản cho nhân viên hành chánh thành công");
							}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(comMaNVHCDK.getItemCount()==0){			
						
						try {	
							String ten =tfTenDangKy.getText();
							String mk =tfMatKhauDK.getText();
							String maKT = comMaNVKTDK.getSelectedItem().toString();
							if(tkkt_dao.taoTaiKhoanNVKT(new TaiKhoanKT(ten, mk, new NhanVienKyThuat(maKT)))==true){
								JOptionPane.showMessageDialog(null, "Tạo tài khoản cho nhân viên kỹ thuật thành công");
							}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không trùng khớp");
				}				
			}
		});
		//		Button trở về giao diện	quản lí từ giao diện đăng ký tài khoản
		btBackRes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameRes.setVisible(false);
				frameQL.setVisible(true);
				
			}
		});
		//		Button chọn nhân viên hành chánh để đăng ký tài khoản
		btHC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btHC.getText().equalsIgnoreCase("Mở")){
					comMaNVKTDK.removeAllItems();
					comMaNVKTDK.setEnabled(false);
					btHC.setText("Hủy");
					btKT.setText("Mở");
					ArrayList<NhanVienHanhChanh> listnvhc = nvhc_dao.getAllNhanVienHanhChanh();
					for(NhanVienHanhChanh nvhc : listnvhc){
						comMaNVHCDK.addItem(nvhc.getMaNhanVien());
					}
					comMaNVHCDK.setEnabled(true);
				}
				else if(btHC.getText().equalsIgnoreCase("Hủy")){
					comMaNVHCDK.setEnabled(false);
					comMaNVHCDK.removeAllItems();
					btHC.setText("Mở");
				}				
			}
		});
		//		Button chọn nhân viên kỹ thuật để đăng ký tài khoản
		btKT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btKT.getText().equalsIgnoreCase("Mở")){
					comMaNVHCDK.removeAllItems();
					comMaNVHCDK.setEnabled(false);
					btKT.setText("Hủy");
					btHC.setText("Mở");
					ArrayList<NhanVienKyThuat> listnvkt = nvkt_dao.getAllNhanVienkyThuat();
					for(NhanVienKyThuat nvkt : listnvkt){
						comMaNVKTDK.addItem(nvkt.getMaNhanVien());
					}
					comMaNVKTDK.setEnabled(true);
				}
				else if(btKT.getText().equalsIgnoreCase("Hủy")){
					comMaNVKTDK.setEnabled(false);
					comMaNVKTDK.removeAllItems();
					btKT.setText("Mở");
				}				
			}
		});
		//-------------------------------------------------
		//	Sử lí sự kiện chức nắng của nhân viên hành chánh
		//		Button mở chức năng xe máy của nhân viên hành chánh
		btXeMay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameXeMay.setVisible(true);
				frameChucNangNV.setVisible(false);
				
			}
		});
		//		Button trở về giao diện đăng nhập từ giao diện nhân viên hành chánh
		btThoatNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameLogin.setVisible(true);
				frameChucNangNV.setVisible(false);
				
			}
		});
		//		Button mở giao diện hợp đồng từ giao diện nhân viên hành chánh
		btHopDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameHopDong.setVisible(true);
				frameChucNangNV.setVisible(false);
				
			}
		}); 
		//-----------------------------------------------------------
		//	Sử lí sự kiện chức nắng của nhân viên kỹ thuật
		//		Button mở giao diện	bảo hành từ giao diện nhân viên kỹ thuật
		btBaoHanh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameBaoHanh.setVisible(true);
				frameChucNangNVKT.setVisible(false);
				
			}
		});
		//		Button trở về giao diện	đăng nhập từ giao diện nhân viên kỹ thuật
		btThoatNVKT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameLogin.setVisible(true);
				frameChucNangNVKT.setVisible(false);
				
			}
		});		
		//---------------------------------------------------------
		//	Sử lí sự kiện cho giao diện nhân viên hành chánh của quản lí
		// Tab nhân viên
		//		Button thêm nhân viên hành chánh
		btThemNVHC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showNVHC();
				btThemNVHC.setEnabled(false);	
				int sl = tableNVHC.getRowCount()+1;
				tfMaNVHC.setEnabled(false);
				tfMaNVHC.setText("NVHC0"+sl);
				btThemNVHC.setEnabled(false);
				btNVHCCapNhat.setEnabled(false);
				btXoaNVHC.setEnabled(false);
			}
		});
		//			Button hủy nhân viên hành chánh       
		btNVHCHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hideNVHC();
				btThemNVHC.setEnabled(true);
				clearNVHC();	
				tfMaNVKT.setText("");
				btThemNVHC.setEnabled(true);
				btNVHCCapNhat.setEnabled(true);
				btXoaNVHC.setEnabled(true);
				btNVHCCapNhat.setText("Cập nhật");
			}
		});
		//			Button lưu nhân viên hành chánh
		btNVHCLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfMaNVHC.getText().equals("")||tfTenNVHC.getText().equals("")||tfPhongBanNVHC.getText().equals("")||tfChucVuNVHC.getText().equals("")||tfHocVanVNHC.getText().equals("")||tfSDTNVHC.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else{
					try {	
						if(!tfTenNVHC.getText().matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$")){
							tbRegexNVHC.setText("Tên nhân viên phải bắt đầu với kí tự hoa mỗi từ");
							tfTenNVHC.requestFocus();
							return;
						}
						
						
						if(!tfPhongBanNVHC.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
							tbRegexNVHC.setText("Kí tự đầu của phòng ban phải in hoa");
							tfPhongBanNVHC.requestFocus();
							return; 
						}
						if(!tfChucVuNVHC.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
							tbRegexNVHC.setText("Kí tự đầu của chức vụ phải in hoa");
							tfChucVuNVHC.requestFocus();
							return; 
						}
						if(!tfHocVanVNHC.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
							tbRegexNVHC.setText("Kí tự đầu của học vấn phải in hoa");
							tfHocVanVNHC.requestFocus();
							return; 
						}
						if(!tfSDTNVHC.getText().matches("\\d{10}")){ 
							tbRegexNVHC.setText("Số điện thoại phải là kí tự hoa và có 10 kí tự");
							tfSDTNVHC.requestFocus();
							return; 
						}
						String n1 =tfMaNVHC.getText();
						String n2 =tfTenNVHC.getText();
						String n3 = tfPhongBanNVHC.getText();
						String n4 = tfChucVuNVHC.getText();
						String n5 = comGioiTinhNVHC.getSelectedItem().toString();				
						String n7 = tfHocVanVNHC.getText();
						String n8 = tfSDTNVHC.getText();
						
						Date date = dateNVHC.getDate();
						String pattern = "dd/MM/yyyy";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						String n6 = simpleDateFormat.format(date);
						if(nvhc_dao.ThemNVHC(new NhanVienHanhChanh(n1, n2, n3, n4, n5, n6, n7, n8))){						
							JOptionPane.showMessageDialog(null, "Thêm nhân viên hành chánh thành công");
							
							loadTableNVHC();
							clearNVHC();
							tbRegexNVHC.setText("");
							btThemNVHC.setEnabled(true);
							btNVHCCapNhat.setEnabled(true);
							btXoaNVHC.setEnabled(true);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh");
					}
				}				
			}
		});
		//			Button xóa nhân viên hành chánh	
		btXoaNVHC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableNVHC.getSelectedRow();			
				if(r!=-1){
					int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa nhân viên hành chánh này?","Delete",JOptionPane.YES_NO_OPTION);
					if(tb==JOptionPane.YES_OPTION){
						String ma = (String) tableNVHC.getValueAt(r, 0);			
						nvhc_dao.xoaNVHC(ma);
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						loadTableNVHC();
						tkhc_dao.xoaTaiKhoanNVHC(ma);
						clearNVHC();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
				}
			}
		});
		//			Button cập nhật nhân viên hành chánh
		btNVHCCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btNVHCCapNhat.getText().equalsIgnoreCase("Cập nhật")){
					showNVHC();
					tfMaNVHC.setEnabled(false);
					btNVHCCapNhat.setText("OK");
					btThemNVHC.setEnabled(false);
					btXoaNVHC.setEnabled(false);
					btNVHCLuu.setEnabled(false);
				}
				else if(btNVHCCapNhat.getText().equalsIgnoreCase("OK")){
					int r = tableNVHC.getSelectedRow();
					if(r!=-1){
						try {
							String n1 =tfMaNVHC.getText();
							String n2 =tfTenNVHC.getText();
							String n3 = tfPhongBanNVHC.getText();
							String n4 = tfChucVuNVHC.getText();
							String n5 = comGioiTinhNVHC.getSelectedItem().toString();				
							String n7 = tfHocVanVNHC.getText();
							String n8 = tfSDTNVHC.getText();
							Date date = dateNVHC.getDate();
							String pattern = "dd/MM/yyyy";
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String n6 = simpleDateFormat.format(date);
							if(!tfTenNVHC.getText().matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$")){
								tbRegexNVHC.setText("Tên nhân viên phải bắt đầu với kí tự hoa mỗi từ");
								tfTenNVHC.requestFocus();
								return;
							}
							
							
							if(!tfPhongBanNVHC.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
								tbRegexNVHC.setText("Kí tự đầu của phòng ban phải in hoa");
								tfPhongBanNVHC.requestFocus();
								return; 
							}
							if(!tfChucVuNVHC.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
								tbRegexNVHC.setText("Kí tự đầu của chức vụ phải in hoa");
								tfChucVuNVHC.requestFocus();
								return; 
							}
							if(!tfHocVanVNHC.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
								tbRegexNVHC.setText("Kí tự đầu của học vấn phải in hoa");
								tfHocVanVNHC.requestFocus();
								return; 
							}
							if(!tfSDTNVHC.getText().matches("\\d{10}")){ 
								tbRegexNVHC.setText("Số điện thoại phải là kí tự hoa và có 10 kí tự");
								tfSDTNVHC.requestFocus();
								return; 
							}
							if(nvhc_dao.capNhatNVHC(new NhanVienHanhChanh(n1, n2, n3, n4, n5, n6, n7, n8))==true){
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								
								loadTableNVHC();
								hideNVHC();
								btThemNVHC.setEnabled(true);
								btNVHCLuu.setEnabled(true);
								btXoaNVHC.setEnabled(true);
								btNVHCCapNhat.setText("Cập nhật");
								btThemNVHC.setEnabled(true);
								btXoaNVHC.setEnabled(true);
								btNVHCLuu.setEnabled(false);
							}
							
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật");
					}
					
					
					
				}
				
			}
		});
		//-------------------------------------------------------
		//	Sử lí sự kiện cho giao diện nhân viên kỹ thuật của quản lí

		//			Button thêm nhân viên kỹ thuật
		btThemNVKT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showNVKT();
				int sl = tableNVKT.getRowCount()+1;
				tfMaNVKT.setEnabled(false);
				tfMaNVKT.setText("NVKT0"+sl);
				btThemNVKT.setEnabled(false);
				btNVKTCapNhat.setEnabled(false);
				btXoaNVKT.setEnabled(false);
			}
		});
		//			Button hủy nhân viên kỹ thuật
		btNVKTHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hideNVKT();
				btThemNVKT.setEnabled(true);
				clearNVKT();
				btNVKTCapNhat.setText("Cập nhật");
				tfMaNVKT.setText("");
				btThemNVKT.setEnabled(true);
				btNVKTCapNhat.setEnabled(true);
				btXoaNVKT.setEnabled(true);
				btNVKTCapNhat.setText("Cập nhật");
			}
			
		});
		//			Button lưu nhân viên kỹ thuật
		btNVKTLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfMaNVKT.getText().equals("")||tfTenNVKT.getText().equals("")||tfBacThoNVKT.getText().equals("")||tfChucVuNVKT.getText().equals("")||tfSoNamKNVNKT.getText().equals("")|| tfSDTNVKT.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				if(!tfTenNVKT.getText().matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$")){
					tbRegexNVKT.setText("Tên nhân viên phải bắt đầu với kí tự hoa mỗi từ");
					tfTenNVKT.requestFocus();
					return;
				}
				
				
				if(!tfBacThoNVKT.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
					tbRegexNVKT.setText("Kí tự đầu của bậc thợ phải in hoa");
					tfBacThoNVKT.requestFocus();
					return; 
				}
				if(!tfChucVuNVKT.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
					tbRegexNVKT.setText("Kí tự đầu của chức vụ phải in hoa");
					tfChucVuNVKT.requestFocus();
					return; 
				}
				
				if(!tfSDTNVKT.getText().matches("\\d{10}")){ 
					tbRegexNVKT.setText("Số điện thoại phải là kí tự số và có 10 kí tự");
					tfSDTNVKT.requestFocus();
					return; 
				}
				else{
					try {	
						
						String n1 =tfMaNVKT.getText();
						String n2 =tfTenNVKT.getText();
						String n3 = tfBacThoNVKT.getText();
						String n4 = tfChucVuNVKT.getText();
						String n5 = comGioiTinhNVKT.getSelectedItem().toString();				
						String n7 = tfSoNamKNVNKT.getText();
						String n8 = tfSDTNVKT.getText();
						
						Date date = dateNVKT.getDate();
						String pattern = "dd/MM/yyyy";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						String n6 = simpleDateFormat.format(date);
						if(nvkt_dao.ThemNVKT(new NhanVienKyThuat(n1, n2, n3, n4, n5, n6, n7, n8))){						
							JOptionPane.showMessageDialog(null, "Thêm nhân viên kỹ thuật thành công");
							loadTableNVKT();
							clearNVKT();
							tbRegexNVKT.setText("");
							btThemNVKT.setEnabled(true);
							btNVKTCapNhat.setEnabled(true);
							btXoaNVKT.setEnabled(true);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh");
					}
				}				
			}
		});	
		//			Button xóa nhân viên kỹ thuật
		btXoaNVKT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableNVKT.getSelectedRow();			
				if(r!=-1){
					int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa nhân viên kỹ thuật này?","Delete",JOptionPane.YES_NO_OPTION);
					if(tb==JOptionPane.YES_OPTION){
						String ma = (String) tableNVKT.getValueAt(r, 0);			
						nvkt_dao.xoaNVKT(ma);
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						loadTableNVKT();
						tkkt_dao.xoaTaiKhoanNVKT(ma);
						clearNVKT();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
				}
				
			}
		});
		//			Button cập nhật nhân viên kỹ thuật
		btNVKTCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btNVKTCapNhat.getText().equalsIgnoreCase("Cập nhật")){
					showNVKT();
					tfMaNVKT.setEnabled(false);
					btNVKTCapNhat.setText("OK");
					btThemNVKT.setEnabled(false);
					btXoaNVKT.setEnabled(false);
					btNVKTLuu.setEnabled(false);
				}
				else if(btNVKTCapNhat.getText().equalsIgnoreCase("OK")){
					int r = tableNVKT.getSelectedRow();
					if(r!=-1){
						try {
							String n1 =tfMaNVKT.getText();
							String n2 =tfTenNVKT.getText();
							String n3 = tfBacThoNVKT.getText();
							String n4 = tfChucVuNVKT.getText();
							String n5 = comGioiTinhNVKT.getSelectedItem().toString();				
							String n7 = tfSoNamKNVNKT.getText();
							String n8 = tfSDTNVKT.getText();
							Date date = dateNVKT.getDate();
							String pattern = "dd/MM/yyyy";
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String n6 = simpleDateFormat.format(date);
							if(!tfTenNVKT.getText().matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$")){
								tbRegexNVKT.setText("Tên nhân viên phải bắt đầu với kí tự hoa mỗi từ");
								tfTenNVKT.requestFocus();
								return;
							}
							
							
							if(!tfBacThoNVKT.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
								tbRegexNVKT.setText("Kí tự đầu của bậc thợ phải in hoa");
								tfBacThoNVKT.requestFocus();
								return; 
							}
							if(!tfChucVuNVKT.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
								tbRegexNVKT.setText("Kí tự đầu của chức vụ phải in hoa");
								tfChucVuNVKT.requestFocus();
								return; 
							}
							
							if(!tfSDTNVKT.getText().matches("\\d{10}")){ 
								tbRegexNVKT.setText("Số điện thoại phải là kí tự số và có 10 kí tự");
								tfSDTNVKT.requestFocus();
								return; 
							}
							if(nvkt_dao.capNhatNVHC(new NhanVienKyThuat(n1, n2, n3, n4, n5, n6, n7, n8))==true){
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								loadTableNVKT();
								hideNVKT();
								btNVKTCapNhat.setText("Cập nhật");
								btThemNVKT.setEnabled(true);
								btXoaNVKT.setEnabled(true);
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật");
					}
					//nvkt_dao.capNhatNVHC(n);
					
					
					
					hideNVKT();
				}
				
			}
		});
		//		Button trở về giao diện quản lí
		BackNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameNhanVien.setVisible(false);
				frameQL.setVisible(true);
				
			}
		});
		//------------------------------------------------------------
		//	Sử lí sự kiện chức năng cửa nhân viên hành chánh
		//	Chức năng xe máy
		//		Tab Xe máy
		//			Button thêm xe máy
		btXeThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int sl = xmdp_dao.getSLXe()+1;
				showXeMay();
				tfMaXe.setEnabled(false);
				tfMaXe.setText("XM-00"+sl);
				btXeThem.setEnabled(false);
				btXeCapNhat.setEnabled(false);
				btXeXoa.setEnabled(false);
			}
		});
		//			Button xóa xe máy
		btXeXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableXe.getSelectedRow();			
				if(r!=-1){
					int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa xe máy này?","Delete",JOptionPane.YES_NO_OPTION);
					if(tb==JOptionPane.YES_OPTION){
						String maxe = (String) tableXe.getValueAt(r, 0);
						xm_dao.xoaXe(maxe);
						comMaXeHD1L.removeAllItems();
						comMaXeHDTG.removeAllItems();
						try {
							hsx_dao.capNhatSLLen((String) tableXe.getValueAt(r, 3));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						xmdp_dao.xoaXeDSXe(maxe);
						loadTableXeMay();
						loadComXeMay();
						
						loadTableHSX();
						clearXeMay();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
				}				
			}
		});
		//			Button hủy xe máy
		btXeHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hideXeMay();
				btXeThem.setEnabled(true);
				clearXeMay();	
				tfMaXe.setText("");
				btXeCapNhat.setText("Cập nhật");
				btXeThem.setEnabled(true);
				btXeCapNhat.setEnabled(true);
				btXeXoa.setEnabled(true);
			}
		});
		//			Button lưu xe máy
		btXeLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfMaXe.getText().equals("")||tfTenXe.getText().equals("")||tfDonGia.getText().equals("")||tfMauXe.getText().equals("")||tfNuocSX.getText().equals("")|| comHangSX.getItemCount()==0||comLoaiXe.getItemCount()==0||comSoPK.getItemCount()==0){
					
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else if(tfMaXe.getText().equals(xmdp_dao.getMaTuDS(tfMaXe.getText()))){
					JOptionPane.showMessageDialog(null, "Mã xe đã tồn tại");
				}
				
				if(!tfNuocSX.getText().matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$")){
					tbRegexXe.setText("Tên nước SX phải bắt đầu với kí tự hoa mỗi từ");
					tfNuocSX.requestFocus();
					return;
				}
				if(!tfDonGia.getText().matches("\\d+")){ 
					tbRegexXe.setText("Đơn giá phải nhập số");
					tfDonGia.requestFocus();
					return; 
				}
				
				if(!tfMauXe.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
					tbRegexXe.setText("Kí tự đầu của màu xe phải in hoa");
					tfMauXe.requestFocus();
					return; 
				}
				if(!tfTenXe.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z0-9]*)*$")){ 
					tbRegexXe.setText("Kí tự đầu của Tên xe phải in hoa");
					tfMauXe.requestFocus();
					return; 
				}
				else{
					try {	
						String n1 =tfMaXe.getText();
						String n2 =tfTenXe.getText();
						String n3 = tfNuocSX.getText();
						String n4 = comHangSX.getSelectedItem().toString();
						String n5 = tfDonGia.getText();
						String n6 = comSoPK.getSelectedItem().toString();
						String n7 = tfMauXe.getText();
						String n8 = comLoaiXe.getSelectedItem().toString();
						if(hsx_dao.getSoLuongTon(n4)<=0){
							JOptionPane.showMessageDialog(null, "Số lượng tồn không đảm bảo");
						}
						else {
							if(xm_dao.ThemXe(new xeMay(n1, n2, n3, new HangSanXuat(n4), Double.parseDouble(n5), n6, n7, new LoaiXe(n8)))==true){
								JOptionPane.showMessageDialog(null, "Thêm xe máy thành công");
								loadTableXeMay();
								comMaXeHD1L.removeAllItems();
								comMaXeHDTG.removeAllItems();
								loadComXeMay();
								
								xmdp_dao.ThemDSXe(n1);
								btXeThem.setEnabled(true);
								clearXeMay();
								hideXeMay();
								loadComChonXeBH();
								
								btXeThem.setEnabled(true);
								hsx_dao.capNhatSL(n4);
								loadTableHSX();
								btXeCapNhat.setEnabled(true);
								btXeXoa.setEnabled(true);
								tbRegexXe.setText("");
							}
						}
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Không hợp lệ");
					}
				}				
			}
		});
		//			Button cập nhật xe máy
		btXeCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btXeCapNhat.getText().equalsIgnoreCase("Cập nhật")){
					btXeCapNhat.setText("OK");
					showXeMay();
					tfMaXe.setEnabled(false);
					btXeThem.setEnabled(false);
					btXeXoa.setEnabled(false);
					btXeLuu.setEnabled(false);
				}
				else if(btXeCapNhat.getText().equalsIgnoreCase("OK")){
					int r = tableXe.getSelectedRow();
					if(r!=-1){
						
						String ma = tfMaXe.getText();
						String ten = tfTenXe.getText();
						String nuocsx = tfNuocSX.getText();
						String hsx = comHangSX.getSelectedItem().toString();
						String gia = tfDonGia.getText();
						String soPK = comSoPK.getSelectedItem().toString();
						String mau = tfMauXe.getText();
						String loai = comLoaiXe.getSelectedItem().toString();
						
						//String donGia = tachDauPhay(gia);
					
						try {
							if(!tfNuocSX.getText().matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$")){
								tbRegexXe.setText("Tên nước SX phải bắt đầu với kí tự hoa mỗi từ");
								tfNuocSX.requestFocus();
								return;
							}
							if(!tfDonGia.getText().matches("\\d+")){ 
								tbRegexXe.setText("Đơn giá phải nhập số");
								tfDonGia.requestFocus();
								return; 
							}
							
							if(!tfMauXe.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){ 
								tbRegexXe.setText("Kí tự đầu của màu xe phải in hoa");
								tfMauXe.requestFocus();
								return; 
							}
							if(!tfTenXe.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z0-9]*)*$")){ 
								tbRegexXe.setText("Kí tự đầu của Tên xe phải in hoa");
								tfTenXe.requestFocus();
								return; 
							}
							if(xm_dao.capNhatXM(new xeMay(ma, ten, nuocsx, new HangSanXuat(hsx), Double.parseDouble(gia), soPK, mau, new LoaiXe(loai)))==true){
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								xmdp_dao.capNhatdsXM(new xeMay(ma, ten, nuocsx, new HangSanXuat(hsx), Double.parseDouble(gia), soPK, mau, new LoaiXe(loai)));
								loadTableXeMay();
								hideXeMay();
								btXeThem.setEnabled(true);
								
								btXeXoa.setEnabled(true);
								btXeCapNhat.setText("Cập nhật");
								tbRegexXe.setText("");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật");
					}
					
				}
				
			}
		});
		//		Tab hãng sản xuất
		//			Button thêm hãng sản xuất
		btHSXThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showHSX();
				tfMaHSX.setEnabled(false);
				int sl = tableHSX.getRowCount()+1;
				tfMaHSX.setText("HSX0"+sl);
				btHSXThem.setEnabled(false);
				btHSXCapNhat.setEnabled(false);
				btHSXXoa.setEnabled(false);
			}
		});
		//			Button lưu hãng sản xuất
		btHSXLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfMaHSX.getText().equals("")||tfTenHSX.getText().equals("")||tfSoLuongTon.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else{
					try {	
						String n1 =tfMaHSX.getText();
						String n2 =tfTenHSX.getText();
						String n3 = tfSoLuongTon.getText();
						if(!tfTenHSX.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){
							tbRegexHSX.setText("Tên hãng sản xuất phải bắt đầu với kí tự hoa");
							tfTenHSX.requestFocus();
							return;
						}
						if(!tfSoLuongTon.getText().matches("\\d+")){ 
							tbRegexHSX.setText("Số lượng tồn phải nhập số");
							tfSoLuongTon.requestFocus();
							return; 
						}

						if(hsx_dao.ThemHSX(new HangSanXuat(n1, n2, Integer.parseInt(n3)))==true){						
							JOptionPane.showMessageDialog(null, "Thêm hãng sản xuất thành công");
							loadTableHSX();
							loadComHSX();
							btHSXThem.setEnabled(true);
							clearHSX();
							btHSXThem.setEnabled(true);
							btHSXCapNhat.setEnabled(true);
							btHSXXoa.setEnabled(true);
							tbRegexHSX.setText("");
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Không hợp lệ");
					}
				}				
			}
		});
		//			Button hủy hãng sản xuất
		btHSXHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hideHSX();
				btHSXThem.setEnabled(true);
				tfMaHSX.setText("");
				clearHSX();		
				btHSXThem.setEnabled(true);
				btHSXCapNhat.setEnabled(true);
				btHSXXoa.setEnabled(true);
				btHSXCapNhat.setText("Cập nhật");
			}
		});
		//			Button xóa hãng sản xuất
		btHSXXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableHSX.getSelectedRow();			
				if(r!=-1){
					int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa hãng sản xuất này?","Delete",JOptionPane.YES_NO_OPTION);
					if(tb==JOptionPane.YES_OPTION){
						String ma = (String) tableHSX.getValueAt(r, 0);			
						try {
							if(hsx_dao.xoaHSX(ma)){
								
								
								JOptionPane.showMessageDialog(null, "Xóa thành công");
								loadTableHSX();
								loadComHSX();
								clearHSX();
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
				}
				
			}
		});
		//			Button cập nhật hãng sản xuất
		btHSXCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btHSXCapNhat.getText().equalsIgnoreCase("Cập nhật")){
					btHSXCapNhat.setText("OK");
					showHSX();
					tfMaHSX.setEnabled(false);
					btHSXThem.setEnabled(false);
					btHSXLuu.setEnabled(false);
					btHSXXoa.setEnabled(false);
				}
				else if(btHSXCapNhat.getText().equalsIgnoreCase("OK")){
					int r = tableHSX.getSelectedRow();
					if(r!=-1){
						
						String ma = tfMaHSX.getText();
						String ten = tfTenHSX.getText();
						String slt = tfSoLuongTon.getText();
						
						try {
							if(!tfTenHSX.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){
								tbRegexHSX.setText("Tên hãng sản xuất phải bắt đầu với kí tự hoa");
								tfTenHSX.requestFocus();
								return;
							}
							if(!tfSoLuongTon.getText().matches("\\d+")){ 
								tbRegexHSX.setText("Số lượng tồn phải nhập số");
								tfSoLuongTon.requestFocus();
								return; 
							}
							if(hsx_dao.capNhatNVHC(new HangSanXuat(ma, ten, Integer.parseInt(slt))) ==true){
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								loadTableHSX();
								hideHSX();
								btHSXCapNhat.setText("Cập nhật");
								btHSXThem.setEnabled(true);
								
								btHSXXoa.setEnabled(true);
								tbRegexHSX.setText("");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật");
					}
				}
				
			}
		});
		//		Table loại xe
		//		Button thêm loại xe
		btLoaiThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int sl = tableLoai.getRowCount()+1;
				tfMaLoai.setText("LX0"+sl);
				showLoaiXe();
				tfMaLoai.setEnabled(false);

				btLoaiThem.setEnabled(false);	
				btLoaiCapNhat.setEnabled(false);
				btLoaiXoa.setEnabled(false);
			}
		});
		//		Button lưu loại xe
		btLoaiLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfMaLoai.getText().equals("")||tfTenLoai.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else{
					try {	
						String n1 =tfMaLoai.getText();
						String n2 =tfTenLoai.getText();
						if(!tfTenLoai.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){
							tbRegexLoai.setText("Tên loại phải bắt đầu với kí tự hoa");
							tfTenLoai.requestFocus();
							return;
						}
						
						if(lx_dao.ThemLoai(new LoaiXe(n1, n2))==true){
							JOptionPane.showMessageDialog(null, "Thêm loại xe thành công");
							loadTableLoaiXe();
							loadComLoai();
							btLoaiThem.setEnabled(true);
							clearloaiXe();
							btLoaiThem.setEnabled(true);	
							btLoaiCapNhat.setEnabled(true);
							btLoaiXoa.setEnabled(true);
							tbRegexLoai.setText("");
							btLoaiLuu.setEnabled(false);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Không hợp lệ");
					}
				}				
			}
		});
		//		Button hủy loại xe
		btLoaiHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hideLoai();
				btLoaiThem.setEnabled(true);
				clearloaiXe();		
				tfMaLoai.setText("");
				btLoaiCapNhat.setEnabled(true);
				btLoaiXoa.setEnabled(true);
			}
		});		
		//		Button xóa loại xe	
		btLoaiXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableLoai.getSelectedRow();			
				if(r!=-1){
					int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa loại xe này?","Delete",JOptionPane.YES_NO_OPTION);
					if(tb==JOptionPane.YES_OPTION){
						String ma = (String) tableLoai.getValueAt(r, 0);			
						try {
							if(lx_dao.xoaLoaiXe(ma)){
								JOptionPane.showMessageDialog(null, "Xóa thành công");
								loadTableLoaiXe();
								loadComLoai();
								clearloaiXe();
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
				}
				
			}
		});
		//		Button cập nhật loại xe
		btLoaiCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btLoaiCapNhat.getText().equalsIgnoreCase("Cập nhật")){
					btLoaiCapNhat.setText("OK");
					showLoaiXe();
					tfMaLoai.setEnabled(false);
					btLoaiThem.setEnabled(false);	
					btLoaiXoa.setEnabled(false);
					btLoaiLuu.setEnabled(false);
				}
				else if(btLoaiCapNhat.getText().equalsIgnoreCase("OK")){
					int r = tableLoai.getSelectedRow();
					if(r!=-1){
						String ma = tfMaLoai.getText();
						String ten = tfTenLoai.getText();
						if(!tfTenLoai.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){
							tbRegexLoai.setText("Tên loại phải bắt đầu với kí tự hoa");
							tfTenLoai.requestFocus();
							return;
						}
						try {
							if(lx_dao.capNhatLK(new LoaiXe(ma, ten))==true){
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								loadTableLoaiXe();
								hideLoai();
								btLoaiThem.setEnabled(true);	
								btLoaiXoa.setEnabled(true);
								btLoaiCapNhat.setText("Cập nhật");
								tbRegexLoai.setText("");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật");
					}
					
				}
				
			}
		});	
		//		Button trở về giao diện chức năng nhân viên hành chánh từ giao diện xe máy
		BackXe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameChucNangNV.setVisible(true);
				frameXeMay.setVisible(false);
				
			}
		});
		//	Chức năng hợp đồng
		//		Tab hợp đồng
		//		Button thêm hợp đồng
		btThemHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showHD();
				btThemHD.setEnabled(false);	
				tfMaHD.setEnabled(false);
				int sl = tableHD.getRowCount()+1;
				tfMaHD.setText("HD0"+sl);
			
				btHDCapNhat.setEnabled(false);
				btXoaHD.setEnabled(false);
			}
		});
		//		Button hủy hợp đồng
		btHDHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hideHD();
				
				clearHD();	
				btHDCapNhat.setText("Cập nhật");
				btThemHD.setEnabled(true);
				btHDCapNhat.setEnabled(true);
				btXoaHD.setEnabled(true);
				tfMaHD.setText("");
			}
		});
		//		Button lưu hợp đồng
		btHDLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfMaHD.getText().equals("")||tfTenKHHD.getText().equals("")||tfSDTKHHD.getText().equals("")||tfTGBHHD.getText().equals("")|| tfDCKHHD.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else{
					try {	
						String n1 =tfMaHD.getText();
						String n2 =tfTenKHHD.getText();
						String n3 = tfNVLap.getText();
						String n4 =	tfDCKHHD.getText();
						String n5 = comLoaiHD.getSelectedItem().toString();
						String n6 = tfSDTKHHD.getText();
						String n7 = tfTGBHHD.getText();
						Date date = ngayLapHD.getDate();
						String pattern = "dd/MM/yyyy";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						String n8 = simpleDateFormat.format(date);
						if(!tfTenKHHD.getText().matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$")){
							tbRegexHD.setText("Tên khách hàng phải bắt đầu với kí tự hoa mỗi từ");
							tfTenKHHD.requestFocus();
							return;
						}
						if(!tfSDTKHHD.getText().matches("\\d{10}")){ 
							tbRegexHD.setText("Số điện thoại phải là kí tự số và có 10 kí tự");
							tfSDTKHHD.requestFocus();
							return; 
						}
						if(!tfTGBHHD.getText().matches("\\d+")){ 
							tbRegexHD.setText("Thời gian bảo hành là kí tự số");
							tfTGBHHD.requestFocus();
							return; 
						}
						
						
						
						if(hd_dao.ThemHD(new HopDong(n1, n2, n3, n4, n5,n6, n7+" tháng", n8))==true){
							//String row[] = {n1,n2,n3,n4,n5,n6,n7,n8};
							
							JOptionPane.showMessageDialog(null, "Thêm hợp đồng thành công");
							loadTableHopDong();
							comMaHD1L.removeAllItems();
							comMaHDTG.removeAllItems();
							loadComHD();
							btThemHD.setEnabled(true);
							clearHD();
							btThemHD.setEnabled(true);
							btHDCapNhat.setEnabled(true);
							btXoaHD.setEnabled(true);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày lập");
					}
				}				
			}
		});
		//			Button xóa hợp đồng
		btXoaHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableHD.getSelectedRow();			
				if(r!=-1){
					int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa hợp đồng này?","Delete",JOptionPane.YES_NO_OPTION);
					if(tb==JOptionPane.YES_OPTION){
						String ma = (String) tableHD.getValueAt(r, 0);			
						try {
							if(hd_dao.xoaHD(ma)){
								JOptionPane.showMessageDialog(null, "Xóa thành công");
								loadTableHopDong();
								comMaHD1L.removeAllItems();
								comMaHDTG.removeAllItems();
								loadComHD();
								clearHD();
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
				}
				
			}
		});
		//			Button cập nhật hợp đồng
		btHDCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btHDCapNhat.getText().equalsIgnoreCase("Cập nhật")){
					btHDCapNhat.setText("OK");
					showHD();
					tfMaHD.setEnabled(false);
					btThemHD.setEnabled(false);
					btHDLuu.setEnabled(false);
					btXoaHD.setEnabled(false);
				}
				else if(btHDCapNhat.getText().equalsIgnoreCase("OK")){
					
					
					int r = tableHD.getSelectedRow();
					if(r!=-1){
						try {
							String ma =tfMaHD.getText();
							String tenKH =tfTenKHHD.getText();
							
							String DC =	tfDCKHHD.getText();
							String Loai = comLoaiHD.getSelectedItem().toString();
							String SDT = tfSDTKHHD.getText();
							String TGBH = tfTGBHHD.getText();
							Date date = ngayLapHD.getDate();
							String pattern = "dd/MM/yyyy";
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String NgayLap = simpleDateFormat.format(date);
							if(!tfTenKHHD.getText().matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$")){
								tbRegexHD.setText("Tên khách hàng phải bắt đầu với kí tự hoa mỗi từ");
								tfTenKHHD.requestFocus();
								return;
							}
							if(!tfSDTKHHD.getText().matches("\\d{10}")){ 
								tbRegexHD.setText("Số điện thoại phải là kí tự số và có 10 kí tự");
								tfSDTKHHD.requestFocus();
								return; 
							}
							if(!tfTGBHHD.getText().matches("\\d+")){ 
								tbRegexHD.setText("Thời gian bảo hành là kĩ tự số");
								tfTGBHHD.requestFocus();
								return; 
							}
							if(hd_dao.capNhatHD(new HopDong(ma, tenKH, DC, Loai, SDT, TGBH+" tháng", NgayLap))==true){
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								loadTableHopDong();
								hideHD();
								btThemHD.setEnabled(true);
								btXoaHD.setEnabled(true);
								btHDCapNhat.setText("Cập nhật");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng để cập nhật");
					}
					
				}
				
			}
		});
		//		Button trở về giao diện chức năng nhân viên hành chánh từ giao diện hợp đồng
		BackHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameChucNangNV.setVisible(true);
				frameHopDong.setVisible(false);
				
			}
		});
		//			Tab hợp đồng trả hết
		//		Button thêm hợp đồng trả hết
		btThemHD1L.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comMaXeHD1L.setEnabled(true);
				btChonXeHD1L.setEnabled(true);
				btThemHD1L.setEnabled(false);
				btHD1LLuu.setEnabled(true);	
				btXoaHD1L.setEnabled(false);	
			}
		});
		//		Button xóa hợp đồng trả hết
		btXoaHD1L.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableHD1L.getSelectedRow();			
				if(r!=-1){
					int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa hợp đồng trả hết này?","Delete",JOptionPane.YES_NO_OPTION);
					if(tb==JOptionPane.YES_OPTION){
						String maxe = (String) tableHD1L.getValueAt(r, 3);
						String mahd = (String) tableHD1L.getValueAt(r, 0);
						xm_dao.themTuXMDP(maxe);
						xmdp_dao.xoaXeDP(maxe);
						loadTableXeMay();
						comMaXeHD1L.removeAllItems();
						comMaXeHDTG.removeAllItems();
						loadComXeMay();
						hdth_dao.xoaHDTH(mahd, maxe);				
						loadTableHopDongTraHet(mahd);
						clearHD1L();
						lbTienThanhToanHD1L.setText("Tổng tiền: ");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
				}
				
			}
		});
		//		Button lưu hợp đồng trả hết	
		btHD1LLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfGiaxeHD1L.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng chọn xe để thêm vào hợp đồng");
				}
				else{
					try {	
						String maHD = comMaHD1L.getSelectedItem().toString();	
						String maXe = comMaXeHD1L.getSelectedItem().toString();
						String nhanVienLap = tfNVLHD1L.getText();
						String gia = tfGiaxeHD1L.getText();
						String tenxe = tfTenXeHD1L.getText();
						
						if(hdth_dao.ThemHD(new HopDongTraHet(new HopDong(maHD), maXe, nhanVienLap, Double.parseDouble(gia), tenxe))==true){
							JOptionPane.showMessageDialog(null, "Thêm xe vào hợp đồng trả hết thành công");
							btThemHD1L.setEnabled(true);
							btHD1LLuu.setEnabled(false);	
							btXoaHD1L.setEnabled(true);	
							loadTableHopDongTraHet(maHD);
							xmdp_dao.ThemTuXM(maXe);
							xm_dao.xoaXe(maXe);
							loadTableXeMay();
							comMaXeHD1L.removeAllItems();
							comMaXeHDTG.removeAllItems();
							loadComXeMay();
							double tien =hdth_dao.getTongThanhToan(comMaHD1L.getSelectedItem().toString());
							double tienGiam;
							if(modelHD1L.getRowCount()>3){
								tienGiam = tien*0.95;
							}
							else{
								tienGiam = tien*0.98;
							}
							lbTienThanhToanHD1L.setText("Tổng tiền: "+String.format("%,.0f",tienGiam));
							clearHD1L();
						}
							
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Không hợp lệ");
					}
				}					
			}
		});
		//		Button hủy hợp đồng trả hết
		btHD1LHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearHD1L();
				comMaXeHD1L.setEnabled(false);
				btChonXeHD1L.setEnabled(false);
				btThemHD1L.setEnabled(true);
				btHD1LLuu.setEnabled(false);
				modelHD1L.setRowCount(0);
				
				btXoaHD1L.setEnabled(true);	
				
			}
		});
		//		Button chọn hợp đồng trả hết
		btchonMaHD1L.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadTableHopDongTraHet(comMaHD1L.getSelectedItem().toString());
				double tien =hdth_dao.getTongThanhToan(comMaHD1L.getSelectedItem().toString());
				double tienGiam;
				if(modelHD1L.getRowCount()>3){
					tienGiam = tien*0.95;
				}
				else{
					tienGiam = tien*0.98;
				}
				lbTienThanhToanHD1L.setText("Tổng tiền: "+String.format("%,.0f",tienGiam));				
			}
		});
		//		Button chọn xe để thêm vào hợp đồng trả hết
		btChonXeHD1L.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comMaXeHD1L.getItemCount()==0){
					JOptionPane.showMessageDialog(null, "Không có mã xe để chọn");
				}
				else{
					String maHD = comMaHD1L.getSelectedItem().toString();	
					String maXe = comMaXeHD1L.getSelectedItem().toString();
					String nhanVienLap = hd_dao.getTenNhanVien(maHD);
					double giaXe = xm_dao.getTienXe(maXe);
					String gia = String.format("%.0f",giaXe);
					String tenXe = xm_dao.getTenXe(maXe);
					tfNVLHD1L.setText(nhanVienLap);
					tfGiaxeHD1L.setText(gia);
					tfTenXeHD1L.setText(tenXe);
				}				
			}
		});
		//		Button thêm hợp đồng trả góp
		btThemHDTG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comMaXeHDTG.setEnabled(true);
				btChonXeHDTG.setEnabled(true);
				btThemHDTG.setEnabled(false);
				btHDTGLuu.setEnabled(true);
				btXoaHDTG.setEnabled(false);
			}
		});
		//			Tab hợp đồng trả góp
		//		Button chọn xe để thêm vào hợp đồng trả gop
		btChonXeHDTG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comMaXeHDTG.getItemCount()==0){
					JOptionPane.showMessageDialog(null, "Không có mã xe để chọn");
				}
				else{
					String maHD = comMaHDTG.getSelectedItem().toString();	
					String maXe = comMaXeHDTG.getSelectedItem().toString();
					String nhanVienLap = hd_dao.getTenNhanVien(maHD);
					double giaXe = xm_dao.getTienXe(maXe);
					String gia = String.format("%.0f",giaXe);
					String tenXe = xm_dao.getTenXe(maXe);
					tfNVLHDTG.setText(nhanVienLap);
					tfGiaxeHDTG.setText(gia);
					tfTenXeHDTG.setText(tenXe);
					
				}
				
				
			}
		});
		//		Button chọn hợp đồng trả góp
		btchonMaHDTG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maHD = comMaHDTG.getSelectedItem().toString();
				loadTableHopDongTraGop(maHD);
				double tien =hdtg_dao.getTongThanhToan(maHD);
				lbTienThanhToanHDTG.setText("Tổng tiền: "+String.format("%,.0f",tien));
				double tienLan1 = tl1_dao.getTien(maHD);
				String tienTra1 =  String.format("%,.0f",tienLan1);
				tfNgayTra1.setText(tienTra1);
				
				String ngay1 = tl1_dao.getNgay(maHD);
				if(ngay1.equals("")){
					
				}
				else{
					SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date date1 = null;
					try {
						date1 = DateFormat.parse(ngay1);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ngayTra1.setDate(date1);
				}
				
				
				
				if(tfNgayTra1.getText().equalsIgnoreCase(tienTra1)){
					lbTienThanhToanHDTG.setText("Tổng tiền: "+String.format("%,.0f",tien-tienLan1));
				}
				double tienLan2 = tl2_dao.getTien(maHD);
				String tienTra2 =  String.format("%,.0f",tienLan2);
				tfNgayTra2.setText(tienTra2);
				
				String ngay2 = tl2_dao.getNgay(maHD);
				if(ngay2.equals("")){
					
				}
				else{
					SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date date2 = null;
					try {
						date2 = DateFormat.parse(ngay2);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ngayTra2.setDate(date2);
				}
				
				double tienLan3 = tl3_dao.getTien(maHD);
				String tienTra3 =  String.format("%,.0f",tienLan3);
				tfNgayTra3.setText(tienTra3);
				
				String ngay3 = tl3_dao.getNgay(maHD);
				if(ngay3.equals("")){
					
				}
				else{
					SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date date3 = null;
					try {
						date3 = DateFormat.parse(ngay2);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ngayTra3.setDate(date3);
				}
				
				
				if(tfNgayTra3.getText().equalsIgnoreCase(tienTra3)){
					lbTienThanhToanHDTG.setText("Tổng tiền: "+String.format("%,.0f",tien-tienLan1-tienLan2-tienLan3));
				}
				
				
				
				if(tien-tienLan1-tienLan2-tienLan3<0){
					lbTienThanhToanHDTG.setText("Tổng tiền: 0");
				}
			}
		});
		//		Button xóa hợp đồng trả góp
		btXoaHDTG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableHDTG.getSelectedRow();		
				if(FormatDoubleThanhString(tl1_dao.getTien((String) tableHDTG.getValueAt(r, 0))).equals("0")|| FormatDoubleThanhString(tl1_dao.getTien((String) tableHDTG.getValueAt(r, 0))).equals("0")){
					if(r!=-1){
						int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa hợp đồng trả góp này?","Delete",JOptionPane.YES_NO_OPTION);
						if(tb==JOptionPane.YES_OPTION){
							
							String maxe = (String) tableHDTG.getValueAt(r, 3);
							String mahd = (String) tableHDTG.getValueAt(r, 0);
							xm_dao.themTuXMDP(maxe);
							xmdp_dao.xoaXeDP(maxe);
							loadTableXeMay();
							comMaXeHDTG.removeAllItems();
							comMaXeHD1L.removeAllItems();
							loadComXeMay();
							hdtg_dao.xoaHDTG(mahd,maxe);
							
							loadTableHopDongTraGop(mahd);
							clearHDTG();
							lbTienThanhToanHDTG.setText("Tổng tiền: ");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Hợp đồng này đã được trả tiền, không thể xóa");
				}
				
				
			}
		});
		//		Button lưu hợp đồng trả góp
		btHDTGLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfGiaxeHDTG.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng chọn xe để thêm vào hợp đồng");
				}
				else{
					try {	
						String maHD = comMaHDTG.getSelectedItem().toString();	
						String maXe = comMaXeHDTG.getSelectedItem().toString();
						String nhanVienLap = tfNVLHDTG.getText();
						String gia = tfGiaxeHDTG.getText();
						String tenxe = tfTenXeHDTG.getText();
						
						if(hdtg_dao.ThemHD(new HopDongTraGop(new HopDong(maHD), maXe, nhanVienLap, Double.parseDouble(gia), tenxe))==true){
							JOptionPane.showMessageDialog(null, "Thêm xe vào hợp đồng trả góp thành công");
							btXoaHDTG.setEnabled(true);
							btThemHDTG.setEnabled(true);
							btHDTGLuu.setEnabled(false);
							loadTableHopDongTraGop(maHD);
							xmdp_dao.ThemTuXM(maXe);
							xm_dao.xoaXe(maXe);
							loadTableXeMay();
							comMaXeHD1L.removeAllItems();
							comMaXeHDTG.removeAllItems();
							loadComXeMay();
							double tien =hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString());
							lbTienThanhToanHDTG.setText("Tổng tiền: "+String.format("%,.0f",tien));
							clearHDTG();
						}
							
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Không hợp lệ");
					}
				}	
				
			}
		});

		//		Button hủy hợp đồng trả góp
		btHDTGHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearHDTG();
				comMaXeHDTG.setEnabled(false);
				btChonXeHDTG.setEnabled(false);
				btThemHDTG.setEnabled(true);
				btXoaHDTG.setEnabled(true);
				btHDTGLuu.setEnabled(false);
				btTra1.setText("Trả");
				btTra2.setText("Trả");
				btTra3.setText("Trả");
				hideTra1();
				hideTra2();
				hideTra3();
				modelHDTG.setRowCount(0);
				
				
			}
		});
		
		btChonMaBH.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comMaXeBH.getItemCount()==0){
					JOptionPane.showMessageDialog(null, "Không có mã xe để chọn");
				}
				else{
					String maxe = comMaXeBH.getSelectedItem().toString();
					String tenxe = bh_dao.getTenXe(maxe);
					String mahsx = bh_dao.getMaHSX(maxe);
					String maloai = bh_dao.getMaLoai(maxe);
					String tenHSX = hsx_dao.getTenHSX(mahsx);
					String tenLoai = lx_dao.getTenLoai(maloai);
					tfTenXeBh.setText(tenxe);
					tfHSXBH.setText(tenHSX);
					tfLoaiXeBH.setText(tenLoai);
					String maHD=null;
					if(hdtg_dao.getMaHDTG(maxe).equalsIgnoreCase("")){
						maHD = hdth_dao.getMaHDTH(maxe);
					}
					else if(hdth_dao.getMaHDTH(maxe).equalsIgnoreCase("")){
						maHD = hdtg_dao.getMaHDTG(maxe);
					}
					tfMaHDBH.setText(maHD);
					String loaiHD = hd_dao.getLoaiHD(maHD);
					tfLoaiHDBH.setText(loaiHD);
					String nvl = hd_dao.getNhanVienLap(maHD);
					tfNhanVienLapBH.setText(nvl);
					String TGBH = hd_dao.getThoiGianBH(maHD);
					tfThoiGianBaoHanhBH.setText(TGBH);
					String ngayLap = hd_dao.getNgayLapHD(maHD);
					tfNgayLapHDBH.setText(ngayLap);
					loadTableBaoHanh(maxe);
				}
			}
		});
		//---------------------------------------------------------------
		
		//			sử lí sự kiện Chức năng của nhân viên kỹ thuật
		//		Tab bảo hành
		//		Button thêm bảo hành
		btThemBH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				showBH();
				tfMaPhieu.setEnabled(false);
				int sl = bh_dao.getSLBH()+1;
				tfMaPhieu.setText("BH0"+sl);
				btBHLuu.setEnabled(true);
				btBHCapNhat.setEnabled(false);
				btXoaBH.setEnabled(false);
				btThemBH.setEnabled(false);
			}
		});
		//		Button xóa bảo hành
		btXoaBH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableBH.getSelectedRow();			
				if(r!=-1){
					int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa phiếu bảo hành này?","Delete",JOptionPane.YES_NO_OPTION);
					if(tb==JOptionPane.YES_OPTION){
						String ma = (String) tableBH.getValueAt(r, 0);	
						String maxe = (String) tableBH.getValueAt(r, 1);	
						
						bh_dao.xoaBH(ma);
						loadTableBaoHanh(maxe);
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						clearBH();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
				}
				
			}
		});
		//		Button cập nhật bảo hành
		btBHCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btBHCapNhat.getText().equalsIgnoreCase("Cập nhật")){
					btBHCapNhat.setText("OK");
					showBH();
					tfMaPhieu.setEnabled(false);
					btThemBH.setEnabled(false);
					
					btXoaBH.setEnabled(false);
					btBHLuu.setEnabled(false);
					
				}
				else if(btBHCapNhat.getText().equalsIgnoreCase("OK")){
					int r = tableBH.getSelectedRow();
					if(r!=-1){
						String maxe = comMaXeBH.getSelectedItem().toString();
						String ma = tfMaPhieu.getText();
						String liDo = tfLiDoBH.getText();
						String loiDo = comLoiDo.getSelectedItem().toString();
						String lK = comTenLinhKien.getSelectedItem().toString();
						Date date = ngayBaoHanh.getDate();
						String pattern = "dd/MM/yyyy";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						String ngayBh = simpleDateFormat.format(date);
						try {
							if(bh_dao.capNhatBH(new BaoHanh(ma, liDo, loiDo, new LinhKien(lK), ngayBh))==true){
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								loadTableBaoHanh(maxe);
								hideBH();
								btBHCapNhat.setText("Cập nhật");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật");
					}
					
				}
				
			}
		});
		//		Button lưu bảo hành
		btBHLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfLiDoBH.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else{

					try {
						String maPhieu = tfMaPhieu.getText();
						String maXe = comMaXeBH.getSelectedItem().toString();
						String tenXe = tfTenXeBh.getText();
						String HSX = tfHSXBH.getText();
						String loai = tfLoaiXeBH.getText();
						
						String maHD = tfMaHDBH.getText();
						String loaiHD = tfLoaiHDBH.getText(); 
						String nvl = tfNhanVienLapBH.getText();
						String tgbh = tfThoiGianBaoHanhBH.getText();
						String ngayLap = tfNgayLapHDBH.getText();
						
						String nvpt = tfNhanVienKyThuat.getText();
						String lido = tfLiDoBH.getText();
						String loiDo = comLoiDo.getSelectedItem().toString();
						String lk = comTenLinhKien.getSelectedItem().toString();
						Date date = ngayBaoHanh.getDate();
						String pattern = "dd/MM/yyyy";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						String ngayBh = simpleDateFormat.format(date);
						if(!tfLiDoBH.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){
							tbRegexBH.setText("Lí do bảo hành phải bắt đầu với kí tự hoa");
							tfLiDoBH.requestFocus();
							return;
						}
						
						if(bh_dao.ThemBH(new BaoHanh(maPhieu,maXe, tenXe, HSX, loai, maHD, loaiHD, nvl, tgbh, ngayLap, nvpt, lido, loiDo, new LinhKien(lk), ngayBh))==true){
							JOptionPane.showMessageDialog(null, "Thêm phiếu bảo hành thành công");
							loadTableBaoHanh(maXe);
							clearBH();
							btBHLuu.setEnabled(false);
							btBHCapNhat.setEnabled(true);
							btXoaBH.setEnabled(true);
							btThemBH.setEnabled(true);
							tbRegexBH.setText("");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bảo hành");
					}
				}
				
			
				
			}
		});
		//		Button hủy bảo hành
		btBHHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearBH();
				hideBH();
				btBHCapNhat.setText("Cập nhật");
				tfMaPhieu.setText("");
				btThemBH.setEnabled(true);
				btBHCapNhat.setEnabled(true);
				btBHLuu.setEnabled(false);
				btXoaBH.setEnabled(true);
			}
		});
		//		Button trở về giao diện chức năng nhân viên kỹ thuật từ giao diện bảo hành
		BackBH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameChucNangNVKT.setVisible(true);
				frameBaoHanh.setVisible(false);
				
			}
		});
		//			Tab linh kiện
		//		Button thêm linh kiện
		btThemLK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int sl = tableLK.getRowCount()+1;
				showLk();
				tfMaLK.setEnabled(false);
				tfMaLK.setText("LK0"+sl);
				btThemLK.setEnabled(false);
				btLKLuu.setEnabled(true);
				btLKCapNhat.setEnabled(false);
				btXoaLK.setEnabled(false);
			}
		});
		//		Button xóa linh kiện
		btXoaLK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableLK.getSelectedRow();			
				if(r!=-1){
					int tb = JOptionPane.showConfirmDialog(null, "Bạn có chấc chắn xóa linh kiện này?","Delete",JOptionPane.YES_NO_OPTION);
					if(tb==JOptionPane.YES_OPTION){
						String ma = (String) tableLK.getValueAt(r, 0);			
						lk_dao.xoaLinhKien(ma);
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						loadTableLinhKien();
						loadComLK();
						clearLK();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn đòng để xóa");
				}
				
			}
		});
		//		Button cập nhật linh kiện
		btLKCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btLKCapNhat.getText().equalsIgnoreCase("Cập nhật")){
					btLKCapNhat.setText("OK");
					showLk();
					tfMaLK.setEnabled(false);
					btThemLK.setEnabled(false);
					btLKLuu.setEnabled(false);
					btLKCapNhat.setEnabled(true);
					btXoaLK.setEnabled(false);
					
				}
				else if(btLKCapNhat.getText().equalsIgnoreCase("OK")){
					int r = tableLK.getSelectedRow();
					if(r!=-1){
						btLKCapNhat.setText("Cập nhật");
						String ma = tfMaLK.getText();
						String ten = tfTenLK.getText();
						try {
							if(lk_dao.capNhatLK(new LinhKien(ma, ten))==true){
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								loadTableLinhKien();
								hideLK();
								btThemLK.setEnabled(true);
								btLKLuu.setEnabled(false);
								btLKCapNhat.setEnabled(true);
								btXoaLK.setEnabled(true);
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật");
					}
					
				}
				
			}
		});
		//		Button lưu linh kiện
		btLKLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfMaLK.getText().equals("")|| tfTenLK.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else{
					String malk = tfMaLK.getText();
					String tenlk = tfTenLK.getText();
					try {
						if(!tfTenLK.getText().matches("^[A-Z][a-zA-Z]*(\\s[a-zA-Z]*)*$")){
							tbRegexLK.setText("Tên linh kiện phải bắt đầu với kí tự in hoa");
							tfTenLK.requestFocus();
							return;
						}
						if(lk_dao.ThemLinhKien(new LinhKien(malk, tenlk))==true){
							JOptionPane.showMessageDialog(null, "Thêm linh kiện thành công");
							loadTableLinhKien();
							loadComLK();
							clearLK();
							btThemLK.setEnabled(true);
							btLKLuu.setEnabled(false);
							btLKCapNhat.setEnabled(true);
							btXoaLK.setEnabled(true);
							tbRegexLK.setText("");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Không hợp lệ");
					}
					
				}
			}
		});
		//		Button hủy linh kiện
		btLKHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*String row[] = {"oke",test()};
				modelLK.addRow(row);*/
				hideLK();
				clearLK();
				btLKCapNhat.setText("Cập nhật");
				tfMaLK.setText("");
				btThemLK.setEnabled(true);
				btLKLuu.setEnabled(false);
				btLKCapNhat.setEnabled(true);
				btXoaLK.setEnabled(true);
			}
		});
		//---------------------------------------------
		


		btTra1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btTra1.getText().equalsIgnoreCase("Trả")){				
					if(hdtg_dao.getMaXeHDTG(comMaHDTG.getSelectedItem().toString()).equals("")){
						JOptionPane.showMessageDialog(null, "Hợp đồng này chưa có xe máy nào");
					}
					else if(tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())!=0){
						JOptionPane.showMessageDialog(null, "Số tiền lần 1 đã được trả");
						hideTra1();
					}
					else {
						btTra1.setText("OK");
						showTra1();
					}
				}
				else if(btTra1.getText().equalsIgnoreCase("OK")){	
		
					if(tfNgayTra1.getText().equals("") || tfNgayTra1.getText().equals("0")){
						
						JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền cần trả");
						
					}
					
					else{
						
						try {
							String mahd = comMaHDTG.getSelectedItem().toString();
							Date date = ngayTra1.getDate();
							String pattern = "dd/MM/yyyy";
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String ngaytra1 = simpleDateFormat.format(date);
							String soTien = tfNgayTra1.getText();
							if(tl1_dao.ThemTraLan1(new TraLan1(mahd, ngaytra1, Double.parseDouble(soTien)))==true){
								JOptionPane.showMessageDialog(null, "Trả tiền cho lần 1 thành công");
								double tien =hdtg_dao.getTongThanhToan(mahd);
								double tienCanTra =  tien-Double.parseDouble(soTien);
								lbTienThanhToanHDTG.setText("Tổng tiền: "+String.format("%,.0f",tienCanTra));
								
								btTra1.setText("Trả");
								hideTra1();
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày trả");
						}
					}
					if(tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())-hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString())>0){
						double tienThua = tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())-hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Tiền thừa: "+FormatDoubleThanhString(tienThua));
						lbTienThanhToanHDTG.setText("Tổng tiền: 0");
						
					}
				}
				
			}
		});
		btTra2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btTra2.getText().equalsIgnoreCase("Trả")){
					if(hdtg_dao.getMaXeHDTG(comMaHDTG.getSelectedItem().toString()).equals("")){
						JOptionPane.showMessageDialog(null, "Hợp đồng này chưa có xe máy nào");
					}
					else if(hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString())-tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())==0){
						JOptionPane.showMessageDialog(null, "Số tiền trả cho lần 1 đã đủ");
					}
					else if(FormatDoubleThanhString(tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())).equals("0")){
						JOptionPane.showMessageDialog(null, "Số tiền lần 1 chưa được trả");
					}
					 
					
					else if(tl2_dao.getTien(comMaHDTG.getSelectedItem().toString())!=0){
						JOptionPane.showMessageDialog(null, "Số tiền lần 2 đã được trả");
						hideTra2();
					}
					else{
						btTra2.setText("OK");
						showTra2();
					}
				}
				else if(btTra2.getText().equalsIgnoreCase("OK")){					
					if(tfNgayTra2.getText().equals("")||tfNgayTra2.getText().equals("0")){
						
						JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền cần trả");
						
					}
					
					else{
						
						try {
							String mahd = comMaHDTG.getSelectedItem().toString();
							Date date = ngayTra2.getDate();
							String pattern = "dd/MM/yyyy";
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String ngaytra2 = simpleDateFormat.format(date);
							String soTien = tfNgayTra2.getText();
							
							double tien =hdtg_dao.getTongThanhToan(mahd);
							double TienConLaiSauLan1 =  tien-tl1_dao.getTien(mahd);
							if(TienConLaiSauLan1>0){
								if(tl2_dao.ThemTraLan2(new TraLan2(mahd, ngaytra2, Double.parseDouble(soTien)))==true ){
									
									JOptionPane.showMessageDialog(null, "Trả tiền cho lần 2 thành công");
									double tienlan2 = tl2_dao.getTien(mahd);
									double TienCanTra =  tien-tl1_dao.getTien(mahd) - tienlan2;
									lbTienThanhToanHDTG.setText("Tổng tiền: "+String.format("%,.0f",TienCanTra));
									
									btTra2.setText("Trả");
									hideTra2();
								}
							}
							else{
								JOptionPane.showConfirmDialog(null, "Hợp đồng này đã được thanh toán hết");
							}
							
						} catch (Exception e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày trả");
						}
					}
					if((tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())+tl2_dao.getTien(comMaHDTG.getSelectedItem().toString()))-hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString())>0){
						double tienThua = (tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())+tl2_dao.getTien(comMaHDTG.getSelectedItem().toString()))-hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString());
						
						JOptionPane.showMessageDialog(null, "Tiền thừa: "+FormatDoubleThanhString(tienThua));
						lbTienThanhToanHDTG.setText("Tổng tiền: 0");
						
					}
					
				}
				
			
				
			}
		});
		btTra3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btTra3.getText().equalsIgnoreCase("Trả")){
					if(hdtg_dao.getMaXeHDTG(comMaHDTG.getSelectedItem().toString()).equals("")){
						JOptionPane.showMessageDialog(null, "Hợp đồng này chưa có xe máy nào");
					}
					else if(hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString())-tl2_dao.getTien(comMaHDTG.getSelectedItem().toString())==0){
						JOptionPane.showMessageDialog(null, "Số tiền trả cho lần 2 đã đủ");
					}
					else if(FormatDoubleThanhString(tl2_dao.getTien(comMaHDTG.getSelectedItem().toString())).equals("0")){
						JOptionPane.showMessageDialog(null, "Số tiền lần 2 chưa được trả");
					}
					 
					
					else if(tl3_dao.getTien(comMaHDTG.getSelectedItem().toString())!=0){
						JOptionPane.showMessageDialog(null, "Số tiền lần 3 đã được trả");
						hideTra2();
					}
					else{
						btTra3.setText("OK");
						showTra3();
					}
				}
				else if(btTra3.getText().equalsIgnoreCase("OK")){	
					
					if(tfNgayTra3.getText().equals("")||tfNgayTra3.getText().equals("0")){
						
						JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền cần trả");
						
					}
					if(hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString())-(tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())+tl2_dao.getTien(comMaHDTG.getSelectedItem().toString())+Double.parseDouble(tfNgayTra3.getText()))>0){
						JOptionPane.showMessageDialog(null, "Lần trả này phải trả hết số tiền cần thanh toán");
					}
					else{
						
						try {
							String mahd = comMaHDTG.getSelectedItem().toString();
							Date date = ngayTra3.getDate();
							String pattern = "dd/MM/yyyy";
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String ngaytra3 = simpleDateFormat.format(date);
							String soTien3 = tfNgayTra3.getText();
							
							double tien =hdtg_dao.getTongThanhToan(mahd);
							double TienConLaiSauLan2 =  tien-tl1_dao.getTien(mahd)-tl2_dao.getTien(mahd);
							if(TienConLaiSauLan2>0){
								if(tl3_dao.ThemTraLan3(new TraLan3(mahd, ngaytra3, Double.parseDouble(soTien3)))==true ){
									
									JOptionPane.showMessageDialog(null, "Trả tiền cho lần 3 thành công");
									double tienlan2 = tl2_dao.getTien(mahd);
									double TienCanTra =  tien-tl1_dao.getTien(mahd) - tienlan2 - tl3_dao.getTien(mahd);
									lbTienThanhToanHDTG.setText("Tổng tiền: "+String.format("%,.0f",TienCanTra));
									
									btTra3.setText("Trả");
									hideTra3();
								}
							}
							else{
								JOptionPane.showConfirmDialog(null, "Hợp đồng này đã được thanh toán hết");
							}
							
						} catch (Exception e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày trả");
						}
					}
					if((tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())+tl2_dao.getTien(comMaHDTG.getSelectedItem().toString())+tl3_dao.getTien(comMaHDTG.getSelectedItem().toString()))-hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString())>0){
						double tienThua = (tl1_dao.getTien(comMaHDTG.getSelectedItem().toString())+tl2_dao.getTien(comMaHDTG.getSelectedItem().toString())+tl3_dao.getTien(comMaHDTG.getSelectedItem().toString()))-hdtg_dao.getTongThanhToan(comMaHDTG.getSelectedItem().toString());
						
						JOptionPane.showMessageDialog(null, "Tiền thừa: "+FormatDoubleThanhString(tienThua));
						lbTienThanhToanHDTG.setText("Tổng tiền: 0");
						
					}
					
				}
				
			}
		});
		
		hideTra1();
		hideTra2();
		hideTra3();
		
		loadTableNVHC();
		loadTableNVKT();
		loadTableXeMay();
		loadTableLoaiXe();
		loadTableHSX();
		loadTableHopDong();
		loadTableLinhKien();
		loadComHSX();
		hideHSX();
		loadComXeMay();
		hideXeMay();
		loadComLoai();
		hideLoai();
		loadComHD();
		hideHD();
		hideHD1L();
		hideHDTG();
		hideNVHC();
		hideNVKT();
		loadComLK();
		hideBH();
		hideLK();
		loadComChonXeBH();
		
		// --------------------------------
		//Load dữ liệu vào table
		tableNVHC.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//Nhân viên hành chánh
				int rNVHC = tableNVHC.getSelectedRow();
				tfMaNVHC.setText(tableNVHC.getValueAt(rNVHC, 0).toString());
				tfTenNVHC.setText(tableNVHC.getValueAt(rNVHC, 1).toString());
				tfPhongBanNVHC.setText(tableNVHC.getValueAt(rNVHC, 2).toString());
				tfChucVuNVHC.setText(tableNVHC.getValueAt(rNVHC, 3).toString());
				comGioiTinhNVHC.setSelectedItem(tableNVHC.getValueAt(rNVHC, 4).toString());
				String ngaySinhHC = tableNVHC.getValueAt(rNVHC, 5).toString();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date dateHC = null;
				try {
					dateHC = DateFormat.parse(ngaySinhHC);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dateNVHC.setDate(dateHC);
				tfHocVanVNHC.setText(tableNVHC.getValueAt(rNVHC, 6).toString());
				tfSDTNVHC.setText(tableNVHC.getValueAt(rNVHC, 7).toString());
				
				
				
				
			}
		}); 
		tableNVKT.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//Nhân viên kỹ thuật
				int rNVKT = tableNVKT.getSelectedRow();
				tfMaNVKT.setText(tableNVKT.getValueAt(rNVKT, 0).toString());
				tfTenNVKT.setText(tableNVKT.getValueAt(rNVKT, 1).toString());
				tfBacThoNVKT.setText(tableNVKT.getValueAt(rNVKT, 2).toString());
				tfChucVuNVKT.setText(tableNVKT.getValueAt(rNVKT, 3).toString());
				comGioiTinhNVKT.setSelectedItem(tableNVKT.getValueAt(rNVKT, 4).toString());
				String ngay = tableNVKT.getValueAt(rNVKT, 5).toString();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date dateKT = null;
				try {
					dateKT = DateFormat.parse(ngay);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dateNVKT.setDate(dateKT);
				tfSoNamKNVNKT.setText(tableNVKT.getValueAt(rNVKT, 6).toString());
				tfSDTNVKT.setText(tableNVKT.getValueAt(rNVKT, 7).toString());
				
			}
		}); 
		tfTimXe.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimXe.getText();
				searchXeMay(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tfTimHSX.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimHSX.getText();
				searchHSX(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tfTimLoai.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimLoai.getText();
				searchLoai(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tfTimHD.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimHD.getText();
				searchHD(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tfTimHD1L.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimHD1L.getText();
				searchHD1L(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		tfTimHDTG.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimHDTG.getText();
				searchHDTG(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tfTimNVHC.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimNVHC.getText();
				searchNVHC(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		tfTimNVKT.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimNVKT.getText();
				searchNVKT(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tfTimBH.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimBH.getText();
				searchBH(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tfTimLK.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String strSear = tfTimLK.getText();
				searchLK(strSear);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tableXe.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//xe máy
				int r= tableXe.getSelectedRow();
				tfMaXe.setText(tableXe.getValueAt(r, 0).toString());
				tfTenXe.setText(tableXe.getValueAt(r, 1).toString());
				tfNuocSX.setText(tableXe.getValueAt(r, 2).toString());
				comHangSX.setSelectedItem(tableXe.getValueAt(r, 3).toString());
				String donGia = tachDauPhay(tableXe.getValueAt(r, 4).toString());
				tfDonGia.setText(donGia);
				comSoPK.setSelectedItem(tableXe.getValueAt(r, 5).toString());
				tfMauXe.setText(tableXe.getValueAt(r, 6).toString());
				comLoaiXe.setSelectedItem(tableXe.getValueAt(r, 7).toString());						
			}
		});
		tableHSX.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//hãng sản xuất
				int r= tableHSX.getSelectedRow();
				tfMaHSX.setText(tableHSX.getValueAt(r, 0).toString());
				tfTenHSX.setText(tableHSX.getValueAt(r, 1).toString());
				tfSoLuongTon.setText(tableHSX.getValueAt(r, 2).toString());
					
			}
		});
		tableLoai.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// loại xe
				int r= tableLoai.getSelectedRow();
				tfMaLoai.setText(tableLoai.getValueAt(r, 0).toString());
				tfTenLoai.setText(tableLoai.getValueAt(r, 1).toString());
				
				
			}
		});
		tableHD.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//Hợp đồng
				int r= tableHD.getSelectedRow();
				tfMaHD.setText(tableHD.getValueAt(r, 0).toString());
				tfTenKHHD.setText(tableHD.getValueAt(r, 1).toString());
				tfNVLap.setText(tableHD.getValueAt(r, 2).toString());
				tfDCKHHD.setText(tableHD.getValueAt(r, 3).toString());
				comLoaiHD.setSelectedItem(tableHD.getValueAt(r, 4).toString());
				tfSDTKHHD.setText(tableHD.getValueAt(r, 5).toString());
				String str =  tableHD.getValueAt(r, 6).toString();
				String[] tach=str.split("\\s");
				String thang = tach[0];
				tfTGBHHD.setText(thang);
				
				String ngay = tableHD.getValueAt(r, 7).toString();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = null;
				try {
					date = DateFormat.parse(ngay);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ngayLapHD.setDate(date);
			}
		});
		tableHD1L.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//hợp đồng trả hết
				int r= tableHD1L.getSelectedRow();
				comMaHD1L.setSelectedItem(tableHD1L.getValueAt(r, 0).toString());
				tfNVLHD1L.setText(tableHD1L.getValueAt(r, 1).toString());
				tfTenXeHD1L.setText(tableHD1L.getValueAt(r, 2).toString());
				tfGiaxeHD1L.setText(tableHD1L.getValueAt(r, 4).toString());
				
			}
		});
		tableHDTG.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//hợp đồng trả góp
				int r= tableHDTG.getSelectedRow();
				comMaHDTG.setSelectedItem(tableHDTG.getValueAt(r, 0).toString());
				tfNVLHDTG.setText(tableHDTG.getValueAt(r, 1).toString());
				tfTenXeHDTG.setText(tableHDTG.getValueAt(r, 2).toString());
				tfGiaxeHDTG.setText(tableHDTG.getValueAt(r, 4).toString());
				
			}
		});
		tableBH.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tableBH.getSelectedRow();
				tfMaPhieu.setText(tableBH.getValueAt(r, 0).toString());
				comMaXeBH.setSelectedItem(tableBH.getValueAt(r, 1).toString());
				tfTenXeBh.setText(tableBH.getValueAt(r, 2).toString());
				tfHSXBH.setText(tableBH.getValueAt(r, 3).toString());
				tfLoaiXeBH.setText(tableBH.getValueAt(r, 4).toString());
				
				tfMaHDBH.setText(tableBH.getValueAt(r, 5).toString());
				tfLoaiHDBH.setText(tableBH.getValueAt(r, 6).toString());
				tfNhanVienLapBH.setText(tableBH.getValueAt(r, 7).toString());
				tfThoiGianBaoHanhBH.setText(tableBH.getValueAt(r, 8).toString());
				tfNgayLapHDBH.setText(tableBH.getValueAt(r, 9).toString());

				tfNhanVienKyThuat.setText(tableBH.getValueAt(r, 10).toString());
				tfLiDoBH.setText(tableBH.getValueAt(r, 11).toString());
				comLoiDo.setSelectedItem(tableBH.getValueAt(r, 12).toString());
				comTenLinhKien.setSelectedItem(tableBH.getValueAt(r, 13).toString());
				String ngay = tableBH.getValueAt(r, 14).toString();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = null;
				try {
					date = DateFormat.parse(ngay);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ngayBaoHanh.setDate(date);
				
				
			}
		});
		tableLK.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tableLK.getSelectedRow();
				tfMaLK.setText(tableLK.getValueAt(r, 0).toString());
				tfTenLK.setText(tableLK.getValueAt(r, 1).toString());
				
				
				
			}
		});
	}
	
	public static void main(String[] args) {
		new guiTrangChu();
	}
	
	
	//----------------------------------
	//		Các hàn bổ trợ
	private void loadComChonXeBH(){
		comMaXeBH.removeAllItems();
		ArrayList<dsXeMay> list = bh_dao.getAllxeMay();
		for(dsXeMay n : list){
			comMaXeBH.addItem(n.getMaXe());
			
		}
	}
	private void loadComHSX(){
		comHangSX.removeAllItems();
		ArrayList<HangSanXuat> listhsx = hsx_dao.getAllHangSanXuat();
		for(HangSanXuat hsx : listhsx){
			comHangSX.addItem(hsx.getMaHSX());
		}
	}
	private void loadComLoai(){
		comLoaiXe.removeAllItems();
		ArrayList<LoaiXe> listlx = lx_dao.getAllLoaiXe();
		for(LoaiXe lx : listlx){
			comLoaiXe.addItem(lx.getMaLoai());
		}
	}
	private void loadComXeMay(){
		ArrayList<xeMay> listxe = xm_dao.getAllxeMay();
		for(xeMay xe : listxe){
			comMaXeHD1L.addItem(xe.getMaXe());
			comMaXeHDTG.addItem(xe.getMaXe());
			
		}
	}
	private void loadComHD(){
		ArrayList<HopDong> listhd = hd_dao.getAllHopDong();
		for(HopDong hd : listhd){
			
			if(hd.getLoaiHopDong().equalsIgnoreCase("Hợp đồng trả góp")){				
				comMaHDTG.addItem(hd.getMaHopDong());			
			}
			else if(hd.getLoaiHopDong().equalsIgnoreCase("Hợp đồng trả hết")){	
				comMaHD1L.addItem(hd.getMaHopDong());	
			}
		}
	}
	/*public void loadComBH(){
		ArrayList<BaoHanh> list = bh_dao.getAllBaoHanhTheoMa(mahdong)();
		for(BaoHanh n : list){
			comTimBH.addItem(n.getMahd().getMaHopDong());
		}
	}*/
	private void loadComLK(){
		comTenLinhKien.removeAllItems();
		ArrayList<LinhKien> list = lk_dao.getAllLinhKien();
		for(LinhKien n : list){
			comTenLinhKien.addItem(n.getMaLinhkien());	
		}
	}
	private void loadTableNVHC(){
		modelNVHC.setRowCount(0);
		List<NhanVienHanhChanh> list = nvhc_dao.getAllNhanVienHanhChanh();
		for(NhanVienHanhChanh nvhc : list){
			modelNVHC.addRow(new Object[]{nvhc.getMaNhanVien(),nvhc.getTenNhanVien(),nvhc.getPhongBan(),nvhc.getChucVu(),nvhc.getGioiTinh(),nvhc.getNgaySinh(),nvhc.getHocVan(),nvhc.getSoDienThoai()});
		}
	}
	private void loadTableNVKT(){
		modelNVKT.setRowCount(0);
		List<NhanVienKyThuat> list = nvkt_dao.getAllNhanVienkyThuat();
		for(NhanVienKyThuat nvkt : list){
			modelNVKT.addRow(new Object[]{nvkt.getMaNhanVien(),nvkt.getTenNhanVien(),nvkt.getBacTho(),nvkt.getChucVu(),nvkt.getGioiTinh(),nvkt.getNgaySinh(),nvkt.getSoNamKinhNghiem(),nvkt.getSoDienThoai()});
		}
	}
	private void loadTableXeMay(){
		modelXe.setRowCount(0);
		List<xeMay> list = xm_dao.getAllxeMay();
		for(xeMay n : list){
			modelXe.addRow(new Object[]{n.getMaXe(),n.getTenXe(),n.getNuocSX(),n.getHsx().getMaHSX(),String.format("%,.0f",n.getDonGia()),n.getSoPhanKhoi(),n.getMauXe(),n.getLoai().getMaLoai()});
		}
	}
	private void loadTableLoaiXe(){
		modelLoai.setRowCount(0);
		List<LoaiXe> list = lx_dao.getAllLoaiXe();
		for(LoaiXe n : list){
			modelLoai.addRow(new Object[]{n.getMaLoai(),n.getTenLoai()});
		}
	}
	private void loadTableHSX(){
		modelHSX.setRowCount(0);
		List<HangSanXuat> list = hsx_dao.getAllHangSanXuat();
		for(HangSanXuat n : list){
			modelHSX.addRow(new Object[]{n.getMaHSX(),n.getTenHSX(),n.getSoLuongTon()});
		}
	}
	private void loadTableHopDong(){
		modelHD.setRowCount(0);
		List<HopDong> list = hd_dao.getAllHopDong();
		for(HopDong n : list){
			modelHD.addRow(new Object[]{n.getMaHopDong(),n.getTenKhachHang(),n.getNhanVienLap(),n.getDiaChiKhachHang(),n.getLoaiHopDong(),n.getSoDienThoaiKH(),n.getThoiGianBaoHanh(),n.getNgayLapHD()});
		}
	}
	
	private void loadTableHopDongTraGop(String ma){
		modelHDTG.setRowCount(0);
		List<HopDongTraGop> list = hdtg_dao.getAllHopDongTraGopTheoMa(ma);
		for(HopDongTraGop n : list){
			modelHDTG.addRow(new Object[]{n.getMaHopDong().getMaHopDong(),n.getNhanVienLap(),n.getTenXe(),n.getMaXe(),String.format("%,.0f",n.getGiaXe())});
		}
	}
	private void loadTableHopDongTraHet(String ma){
		modelHD1L.setRowCount(0);
		List<HopDongTraHet> list = hdth_dao.getAllHopDongTraHetTheoMa(ma);
		for(HopDongTraHet n : list){
			modelHD1L.addRow(new Object[]{n.getMaHopDong().getMaHopDong(),n.getNhanVienLap(),n.getTenXe(),n.getMaXe(),String.format("%,.0f",n.getGiaXe())});
		}
	}
	private void loadTableBaoHanh(String maxe){
		modelBH.setRowCount(0);
		List<BaoHanh> list = bh_dao.getAllBaoHanhTheoMa(maxe);
		for(BaoHanh n : list){
			modelBH.addRow(new Object[]{n.getMaphieu(),n.getMaxe(),n.getTenxe(),n.getHangsx(),n.getLoai(),n.getMahd(),n.getLoaiHD(),n.getNhanvienlap(),n.getThoiGianBH(),n.getNgayLapHD(),n.getNvpt(),n.getLidoBH(),n.getLoiDo(),n.getLK().getMaLinhkien(),n.getNgayBH()});
		}
	}
	private void loadTableLinhKien(){
		modelLK.setRowCount(0);
		List<LinhKien> list = lk_dao.getAllLinhKien();
		for(LinhKien n : list){
			modelLK.addRow(new Object[]{n.getMaLinhkien(),n.getTenLinhKien()});
		}
	}
	/*public String test(){
		String str = "";
		
		List<LinhKien> list = lk_dao.getAllLinhKien();
		for(LinhKien n : list){
				
			str =  str.concat("'"+n.getTenLinhKien()+"'"+"  " );
				//
		}
		return str;
		
	}*/
	public String tachDauPhay(String gia){	
		String[] tach=gia.split(",");
		String dongia = "";
		for (int i = 0; i<tach.length;i++){
			dongia =  dongia.concat(tach[i]+"");
			
		}
		return dongia;
	}
	private void hideHSX(){
		tfMaHSX.setEnabled(false);
		tfTenHSX.setEnabled(false);
		tfSoLuongTon.setEnabled(false);
		
		btHSXLuu.setEnabled(false);
	}
	private void showHSX(){
		tfMaHSX.setEnabled(true);
		tfTenHSX.setEnabled(true);
		tfSoLuongTon.setEnabled(true);
		
		btHSXLuu.setEnabled(true);
	}
	private void clearHSX(){
		tfMaHSX.setText("");
		tfTenHSX.setText("");
		tfSoLuongTon.setText("");
	}
	private void hideLoai(){
		tfMaLoai.setEnabled(false);
		tfTenLoai.setEnabled(false);
		
		btLoaiLuu.setEnabled(false);
	}
	private void showLoaiXe(){
		tfMaLoai.setEnabled(true);
		tfTenLoai.setEnabled(true);
			
		btLoaiLuu.setEnabled(true);
	}
	private void clearloaiXe(){
		tfMaLoai.setText("");
		tfTenLoai.setText("");
	}
	private void hideXeMay(){
		tfMaXe.setEnabled(false);
		tfTenXe.setEnabled(false);
		comSoPK.setEnabled(false);
		comLoaiXe.setEnabled(false);
		comHangSX.setEnabled(false);
		tfDonGia.setEnabled(false);
		tfMauXe.setEnabled(false);
		tfNuocSX.setEnabled(false);
		
		btXeLuu.setEnabled(false);
	}
	private void showXeMay(){
		tfMaXe.setEnabled(true);
		tfTenXe.setEnabled(true);
		comSoPK.setEnabled(true);
		comLoaiXe.setEnabled(true);
		comHangSX.setEnabled(true);
		tfDonGia.setEnabled(true);
		tfMauXe.setEnabled(true);
		tfNuocSX.setEnabled(true);
		
		btXeLuu.setEnabled(true);
	}
	private void clearXeMay(){
		tfMaXe.setText("");
		tfTenXe.setText("");
		tfDonGia.setText("");
		tfMauXe.setText("");
		tfNuocSX.setText("");
		if(comHangSX.getItemCount()!=0){
			comHangSX.setSelectedIndex(0);
		}
		if(comLoaiXe.getItemCount()!=0){
			comLoaiXe.setSelectedIndex(0);
		}
		if(comSoPK.getItemCount()!=0){
			comSoPK.setSelectedIndex(0);
		}
	}
	private void hideNVHC(){
		tfMaNVHC.setEnabled(false);
		tfTenNVHC.setEnabled(false);
		tfPhongBanNVHC.setEnabled(false);
		tfChucVuNVHC.setEnabled(false);
		comGioiTinhNVHC.setEnabled(false);
		tfHocVanVNHC.setEnabled(false);
		tfSDTNVHC.setEnabled(false);
		dateNVHC.setEnabled(false);
		
		btNVHCLuu.setEnabled(false);
	}
	private void showNVHC(){
		tfMaNVHC.setEnabled(true);
		tfTenNVHC.setEnabled(true);
		tfPhongBanNVHC.setEnabled(true);
		tfChucVuNVHC.setEnabled(true);
		comGioiTinhNVHC.setEnabled(true);
		tfHocVanVNHC.setEnabled(true);
		tfSDTNVHC.setEnabled(true);
		dateNVHC.setEnabled(true);
		
		btNVHCLuu.setEnabled(true);
	}
	private void clearNVHC(){		
		tfMaNVHC.setText("");
		tfTenNVHC.setText("");
		tfPhongBanNVHC.setText("");
		tfChucVuNVHC.setText("");
		comGioiTinhNVHC.setSelectedIndex(0);
		tfHocVanVNHC.setText("");
		tfSDTNVHC.setText("");	
	}
	private void hideNVKT(){
		tfMaNVKT.setEnabled(false);
		tfTenNVKT.setEnabled(false);
		tfBacThoNVKT.setEnabled(false);
		tfChucVuNVKT.setEnabled(false);
		comGioiTinhNVKT.setEnabled(false);
		tfSoNamKNVNKT.setEnabled(false);
		tfSDTNVKT.setEnabled(false);
		dateNVKT.setEnabled(false);
		
		btNVKTLuu.setEnabled(false);
	}
	private void showNVKT(){
		tfMaNVKT.setEnabled(true);
		tfTenNVKT.setEnabled(true);
		tfBacThoNVKT.setEnabled(true);
		tfChucVuNVKT.setEnabled(true);
		comGioiTinhNVKT.setEnabled(true);
		tfSoNamKNVNKT.setEnabled(true);
		tfSDTNVKT.setEnabled(true);
		dateNVKT.setEnabled(true);
		
		btNVKTLuu.setEnabled(true);
	}
	private void clearNVKT(){		
		tfMaNVKT.setText("");
		tfTenNVKT.setText("");
		tfBacThoNVKT.setText("");
		tfChucVuNVKT.setText("");
		comGioiTinhNVKT.setSelectedIndex(0);
		tfSoNamKNVNKT.setText("");
		tfSDTNVKT.setText("");	
	}
	private void hideHD(){
		tfMaHD.setEnabled(false);
		tfTenKHHD.setEnabled(false);
		
		tfDCKHHD.setEnabled(false);
		comLoaiHD.setEnabled(false);
		tfSDTKHHD.setEnabled(false);
		tfTGBHHD.setEnabled(false);
		ngayLapHD.setEnabled(false);
		
		btHDLuu.setEnabled(false);
	}
	private void showHD(){
		tfMaHD.setEnabled(true);
		tfTenKHHD.setEnabled(true);
		tfDCKHHD.setEnabled(true);
		comLoaiHD.setEnabled(true);
		tfSDTKHHD.setEnabled(true);
		tfTGBHHD.setEnabled(true);
		ngayLapHD.setEnabled(true);
		
		btHDLuu.setEnabled(true);
	}
	private void clearHD(){		
		tfMaHD.setText("");	
		tfTenKHHD.setText("");	
		tfDCKHHD.setText("");	
		comLoaiHD.setSelectedIndex(0);
		tfSDTKHHD.setText("");	
		tfTGBHHD.setText("");	
		
	}
	
	private void hideHD1L(){
		comMaXeHD1L.setEnabled(false);
		tfNVLHD1L.setEnabled(false);
		tfGiaxeHD1L.setEnabled(false);
		tfTenXeHD1L.setEnabled(false);
		
		btHD1LLuu.setEnabled(false);
	}
	
	private void clearHD1L(){
		if(comMaHD1L.getItemCount()!=0){
			comMaHD1L.setSelectedIndex(0);
		}
		if(comMaXeHD1L.getItemCount()!=0){
			comMaXeHD1L.setSelectedIndex(0);
		}
		tfNVLHD1L.setText("");	
		tfGiaxeHD1L.setText("");	
		tfTenXeHD1L.setText("");	
			
	}
	private void hideHDTG(){
		comMaXeHDTG.setEnabled(false);
		tfNVLHDTG.setEnabled(false);
		tfGiaxeHDTG.setEnabled(false);
		tfTenXeHDTG.setEnabled(false);
		
		
		btHDTGLuu.setEnabled(false);
	}
	private void clearHDTG(){	
		if(comMaHDTG.getItemCount()!=0){
			comMaHDTG.setSelectedIndex(0);
		}
		if(comMaXeHDTG.getItemCount()!=0){
			comMaXeHDTG.setSelectedIndex(0);
		}
		tfNVLHDTG.setText("");	
		tfGiaxeHDTG.setText("");	
		tfTenXeHDTG.setText("");	
		
	}
	private void hideBH(){
		tfMaPhieu.setEditable(false);
		tfTenXeBh.setEnabled(false);
		tfHSXBH.setEnabled(false);
		tfLoaiXeBH.setEnabled(false);
		
		tfMaHDBH.setEnabled(false);
		tfLoaiHDBH.setEnabled(false);
		tfNhanVienLapBH.setEnabled(false);
		tfThoiGianBaoHanhBH.setEnabled(false);
		tfNgayLapHDBH.setEnabled(false);
		
		tfNhanVienKyThuat.setEnabled(false);
		tfLiDoBH.setEnabled(false);
		comLoiDo.setEnabled(false);
		ngayBaoHanh.setEnabled(false);
		comTenLinhKien.setEnabled(false);
	}
	private void showBH(){
		tfMaPhieu.setEditable(true);
		tfLiDoBH.setEnabled(true);
		comLoiDo.setEnabled(true);
		ngayBaoHanh.setEnabled(true);
		comTenLinhKien.setEnabled(true);
	}
	private void clearBH(){
		tfLoaiHDBH.setText("");
		tfLiDoBH.setText("");
		comLoiDo.setSelectedIndex(0);
		if(comTenLinhKien.getItemCount()!=0){
			comTenLinhKien.setSelectedIndex(0);
		}
		tfTenXeBh.setText("");
		tfHSXBH.setText("");
		tfLoaiXeBH.setText("");
		tfMaHDBH.setText("");
		tfLoaiHDBH.setText("");
		tfNhanVienLapBH.setText("");
		tfThoiGianBaoHanhBH.setText("");
		tfNgayLapHDBH.setText("");
		
	}
	
	private void hideLK(){
		tfMaLK.setEnabled(false);
		tfTenLK.setEnabled(false);
	}
	private void showLk(){
		tfMaLK.setEnabled(true);
		tfTenLK.setEnabled(true);
	}
	private void clearLK(){
		tfMaLK.setText("");
		tfTenLK.setText("");
	}
	private void hideTra1(){
		ngayTra1.setEnabled(false);
		tfNgayTra1.setEnabled(false);
	}
	private void showTra1(){
		ngayTra1.setEnabled(true);
		tfNgayTra1.setEnabled(true);
	}
	private void hideTra2(){
		ngayTra2.setEnabled(false);
		tfNgayTra2.setEnabled(false);
	}
	private void showTra2(){
		ngayTra2.setEnabled(true);
		tfNgayTra2.setEnabled(true);
	}
	private void hideTra3(){
		ngayTra3.setEnabled(false);
		tfNgayTra3.setEnabled(false);
	}
	private void showTra3(){
		ngayTra3.setEnabled(true);
		tfNgayTra3.setEnabled(true);
	}
	private void searchXeMay(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelXe);
		tableXe.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private void searchHSX(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelHSX);
		tableHSX.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private void searchLoai(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelLoai);
		tableLoai.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private void searchHD(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelHD);
		tableHD.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private void searchHD1L(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelHD1L);
		tableHD1L.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private void searchHDTG(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelHDTG);
		tableHDTG.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private void searchNVHC(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelNVHC);
		tableNVHC.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private void searchNVKT(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelNVKT);
		tableNVKT.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private void searchBH(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelBH);
		tableBH.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private void searchLK(String str){
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelLK);
		tableLK.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	private String FormatDoubleThanhString(double dou){
		String strKQ = String.format("%,.0f",dou);
		return strKQ;
	}
}
