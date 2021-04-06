package com.hsm.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hsm.service.UserService;
import com.hsm.vo.AllBusVO;
import com.hsm.vo.BusTimeVO;
import com.hsm.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	// user main page
	@RequestMapping(value = "/mainf")
	public String main() {
		return "user/main/main";
	}
	// user login page
	@RequestMapping(value = "/loginf")
	public String login() {
		return "user/login/login";
	}
	// user find id page
	@RequestMapping(value = "/findIDf")
	public String findID() {
		return "user/login/findID";
	}
	// user find pw page
	@RequestMapping(value = "/findPWf")
	public String findPW() {
		return "user/login/findPW";
	}
	// user join page
	@RequestMapping(value = "/joinf")
	public String joinf() {
		return "user/join/join";
	}
	@RequestMapping(value = "/changeNumberf")
	public String changeNumberf() {
		return "user/myPage/changeNumber";
	}
	@RequestMapping(value = "/changePWf")
	public String changePWf() {
		return "user/myPage/changePW";
	}
	@RequestMapping(value = "/ticketList")
	public String ticketList() {
		return "user/myPage/ticketList";
	}
	@RequestMapping(value = "/terminal")
	public String terminal() {
		return "user/terminal/terminal";
	}
	@RequestMapping(value = "/qnaList")
	public String qnaList() {
		return "user/qna/list";
	}
	@RequestMapping(value = "/qnaRegister")
	public String qnaRegister() {
		return "user/qna/register";
	}
	
	
	
	// user ticketing search page
	@RequestMapping(value = "/search")
	public String search(Model model, AllBusVO vo, RedirectAttributes redirect, HttpServletRequest request) {
		String msg = "";
		String url = "";
		List<BusTimeVO> list = new ArrayList<BusTimeVO>();
		list = service.busTimeList(vo);
		if(list!=null) {
			model.addAttribute("li", list);
			url = "user/ticketing/search";
		}else {
			msg = "해당 지역에 정류장이 없습니다.";
			url = "redirect:main";
		}
		redirect.addFlashAttribute("msg", msg);
		return url;
	}
	
	@RequestMapping(value = "/seat")
	public String seat(Model model, BusTimeVO vo) {
		String bus_name = vo.getBus_name();
		String area = bus_name.substring(0,bus_name.lastIndexOf("_"));
		vo.setDeparture_area(area);
		vo = service.busChoose(vo);
		System.out.println(vo);
		model.addAttribute("vo", vo);
		return "user/ticketing/seat";
	}
	
	@RequestMapping(value = "/myPage")
	public String myPage(Model model,UserVO vo,HttpServletRequest request) {
		vo.setEmail((String)request.getSession().getAttribute("loginID"));
		model.addAttribute("vo", service.selectOne(vo));
		return "user/myPage/home";
	}
	
	
	@RequestMapping(value = "/changePW")
	public String changePW(Model model, HttpServletRequest request, UserVO vo, 
				RedirectAttributes redirect, HttpSession session) {
		String password = (String)request.getSession().getAttribute("loginPassword");
		String msg = "";
		String url = "user/myPage/changePW";
		if(password!=null) {
			if(password.equals(request.getParameter("passwordCh"))) {
				vo.setEmail((String)request.getSession().getAttribute("loginID"));
				vo.setPassword(request.getParameter("password"));
				service.changePassword(vo);
				session.invalidate();
				msg = "비밀번호 변경 성공!! 로그인후 이용하세요";
				url = "redirect:loginf";
			}else {
				msg= "비밀번호가 틀렸습니다.";
			}
		}else {
			msg = "로그인중이 아닙니다.";
		}
		redirect.addFlashAttribute("vo", vo);
		redirect.addFlashAttribute("msg", msg);
		return url;
	}
	
	@RequestMapping(value = "/changeNumber")
	public String changeNumber(Model model, HttpServletRequest request, UserVO vo, 
			RedirectAttributes redirect, HttpSession session) {
		String password = (String)request.getSession().getAttribute("loginPassword");
		String url = "redirect:changeNumberf";
		String msg = "";
		if(password!=null) {
			if(password.equals(vo.getPassword())) {
				vo.setEmail((String)request.getSession().getAttribute("loginID"));
				service.changePhone(vo);
				url = "redirect:myPage";
			}else {
				msg= "비밀번호가 틀렸습니다.";
			}
		}else {
			msg = "로그인중이 아닙니다.";
		}
		redirect.addFlashAttribute("msg", msg);
		return url;
	}
	
	@RequestMapping(value = "/join")
	public String join(Model model, UserVO vo, RedirectAttributes rttr) {
		String url = "redirect:joinf";
		String msg = "";
		if(service.selectOne(vo)==null) {
			if(service.userJoin(vo)>0) {
				url = "redirect:loginf";
				msg = "회원가입 성공! 로그인 후 이용하세요^^";
			}else {
				msg = "회원가입 실패 다시 시도해주세요 ㅠㅠ";
			}
		}else {
			msg = "이미 있는 아이디 입니다.";
		}
		rttr.addFlashAttribute("vo",vo);
		rttr.addFlashAttribute("msg",msg);
		return url;
	}
	
	@RequestMapping(value = "/login")
	public String login(UserVO vo, HttpServletRequest request, RedirectAttributes rttr) {
		String password = vo.getPassword();
		String url = "redirect:loginf";
		String msg = "";
		vo = service.selectOne(vo);
		if(vo!=null) {
			if(vo.getPassword().equals(password)) {
				request.getSession().setAttribute("loginID", vo.getEmail());
				request.getSession().setAttribute("loginPassword", vo.getPassword());
				url = "redirect:mainf";
			}else {
				msg = "Password를 확인해 주세요.";
			}
		}else {
			msg = "ID를 확인해 주세요.";
		}
		rttr.addFlashAttribute("msg",msg);
		rttr.addFlashAttribute("vo",vo);
		return url;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpSession session, RedirectAttributes rttr) {
		session = request.getSession(false);
		String msg = null;
		if (session !=null && session.getAttribute("loginID") !=null) {
			session.invalidate();
			msg = "로그아웃 완료";
		}
		rttr.addFlashAttribute("msg", msg);
		return "redirect:loginf";
	}
	
	@RequestMapping(value = "/secession")
	public String seCession(HttpServletRequest request, HttpSession session, 
				 UserVO vo, RedirectAttributes redirect) {
		String msg = null;
//		로그인한 아이디 & 비밀번호
		String email = (String)session.getAttribute("loginID");
		String password = (String)session.getAttribute("loginPassword");
		//입력한 비밀번호
		String passwordCh = (String)request.getParameter("password");
		String url = "redirect:myPage";
		if(password.equals(passwordCh)){
			if (session !=null && session.getAttribute("loginID") !=null) {
				vo.setEmail(email);
				service.secession(vo);
				session.invalidate();
				msg = "회원탈퇴 완료.";
				url = "redirect:mainf";
			}else {
				msg = "로그인을 한 후 이용해주세요.";
			}
		}else {
			msg = "비밀번호를 다시 입력해주세요.";
		}
		redirect.addFlashAttribute("msg", msg);
		return url;
	}
	
	
	
}
