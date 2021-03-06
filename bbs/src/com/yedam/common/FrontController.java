package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.web.BulletinDelete;
import com.yedam.bulletin.web.BulletinForm;
import com.yedam.bulletin.web.BulletinInsert;
import com.yedam.bulletin.web.BulletinList;
import com.yedam.bulletin.web.BulletinListPaging;
import com.yedam.bulletin.web.BulletinSelect;
import com.yedam.bulletin.web.BulletinUpdate;
import com.yedam.member.web.MemberJoin;
import com.yedam.member.web.MemberJoinForm;
import com.yedam.member.web.MemberLogin;
import com.yedam.member.web.MemberLoginForm;
import com.yedam.member.web.MemberLogout;
import com.yedam.notice.web.Notice;
import com.yedam.notice.web.NoticeDelete;
import com.yedam.notice.web.NoticeForm;
import com.yedam.notice.web.NoticeInsert;
import com.yedam.notice.web.NoticeList;
import com.yedam.notice.web.NoticeListPaging;
import com.yedam.notice.web.NoticeUpdate;
import com.yedam.product.web.AddCart;
import com.yedam.product.web.CartList;
import com.yedam.product.web.ProductList;

public class FrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private HashMap<String, DbCommand> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// 요청 페이지 - 실행 컨트롤
		map.put("/index.do", new IndexPage());
		map.put("/main.do", new MainPage());
		map.put("/memberJoinForm.do", new MemberJoinForm());
		map.put("/memberJoin.do", new MemberJoin());
		map.put("/memberLoginForm.do", new MemberLoginForm());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLoginOut.do", new MemberLogout());
		
		// 공지사항
		map.put("/noticeList.do", new NoticeList());
		map.put("/noticeListPaging.do", new NoticeListPaging());
		map.put("/notice.do", new Notice());
		map.put("/noticeUpdate.do", new NoticeUpdate());
		map.put("/noticeInsert.do", new NoticeInsert());
		map.put("/noticeForm.do", new NoticeForm());
		map.put("/noticeDelete.do", new NoticeDelete());
		
		// 게시글 관련
		map.put("/bulletinList.do", new BulletinList());
		map.put("/bulletinListPaging.do", new BulletinListPaging());
		map.put("/bulletinForm.do", new BulletinForm());	// 경로 지정 잘하면 굳이 필요 없는 애. ~> 비정상적으로 작동하네? delete는 서블릿으로 작동하니까 필요없다 쳐도 얘는 아닌가 본데? 필요한가 본데?
		map.put("/bulletinInsert.do", new BulletinInsert());
		map.put("/bulletinSelect.do", new BulletinSelect());
		map.put("/bulletinDelete.do", new BulletinDelete());	// 경로 지정 및 form태그 한 번 더 쓰게 되면 굳이 필요 없는 애.
		map.put("/bulletinUpdate.do", new BulletinUpdate());
		
		// 상품 관련
		map.put("/productList.do", new ProductList());
		map.put("/addCart.do", new AddCart());
		map.put("/cartList.do", new CartList());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		String cPath = req.getContextPath();
		String path = uri.substring(cPath.length());
		
		DbCommand command = map.get(path);
		String viewPage = command.execute(req, resp);
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
}
