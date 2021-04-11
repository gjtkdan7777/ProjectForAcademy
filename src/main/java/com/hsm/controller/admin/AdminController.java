package com.hsm.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsm.service.AdminService;
import com.hsm.vo.QnASearch;
import com.hsm.vo.QnAVO;
import com.hsm.vo.Search;
import com.hsm.vo.TicketingVO;
import com.hsm.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "admin")
@Slf4j
public class AdminController {
	
	@Autowired
	AdminService service;


	@RequestMapping(value = "/contentAns")
	public String contentSub(UserVO uvo, QnAVO qvo, HttpSession session) {
		qvo.setEmail((String)session.getAttribute("loginID"));
		String url = "redirect:qnaList";
		String msg = null;
		if(qvo.getEmail().equals(null)) {
			msg = "로그인 후 이용하실 수 있습니다";
			url = "redirect:loginf";
		}else {
			service.insertAnswer(qvo);
		}
		return url;
	}
	
	// admin member list
		@RequestMapping(value = "/MemberList")
		public String adminMemberList(Model model, Search vo) {
			List<Search> list = service.userList(vo);
			
			if(list!=null) {
				model.addAttribute("li", list);
			}
			return "admin/member/list";
		}
		
		@RequestMapping(value = "/QuestionsList")
		public String adminQuestionsList(Model model, QnASearch vo) {
			List <QnASearch> list = new ArrayList<QnASearch>();
			list = service.qnaList(vo);
			model.addAttribute("li", list);
			return "admin/questions/list";
		}
		
		@RequestMapping(value = "/Delete")
		public String Delete(Model model, HttpServletRequest request, UserVO vo) {
			String[] check = request.getParameterValues("chk");
			for (int i = 0; i < check.length; i++) {
				vo.setEmail(check[i]);
				service.deleteUser(vo);
			}
			return "redirect:MemberList";
		}
		
		// admin member modify
		@RequestMapping(value = "/MemberModify")
		public String adminMemberModify(Model model,UserVO vo) {
			String url = "admin/member/modify";
			vo = service.selectOne(vo);
			if(vo!=null) {
				model.addAttribute("vo", vo);
			}else {
				url = "redirect:MemberList";
			}
			return url;
		}
		
		@RequestMapping(value = "/update")
		public String update(UserVO vo) {
			String msg = "수정실패";
			String url = "redirect:MemberModify";
			if(service.update(vo)>0) {
				msg = "수정성공";
				url = "redirect:MemberList";
			}
			return url;
		}
		
		
		
		// admin member detail
		@RequestMapping(value = "/QuestionsDetail")
		public String adminQuestionsDetail(Model model,QnAVO vo) {
			vo = service.selectQnA(vo);
			if(vo != null) {
				model.addAttribute("vo", vo);
			}
			return "admin/questions/detail";
		}
		
		@RequestMapping(value = "/insertAnswer")
		public String insertAnswer(Model model,QnAVO vo) {
			String msg = "";
			if(service.insertAnswer(vo)>0) {
				msg = "답변완료";
			}
			return "redirect:QuestionsList";
		}
		@RequestMapping(value = "/questionDelete")
		public String questionDelete(Model model, HttpServletRequest request, QnAVO vo) {
			String[] check = request.getParameterValues("chk");
			for (int i = 0; i < check.length; i++) {
				System.out.println(check[i]);
				vo.setSeq(Integer.parseInt(check[i]));
				service.deleteQuestion(vo);
			}
			return "redirect:QuestionsList";
		}
		
		// admin ticketing list
		@RequestMapping(value = "/TicketingList")
		public String adminTicketingList(Model model) {
			List<TicketingVO> list = new ArrayList<TicketingVO>();
			list = service.TicketingList();
			if(list==null) {
				String msg="예매내역이 없습니다.";
			}else {
				model.addAttribute("li", list);
			}
			return "admin/ticketing/list";
		}
}
