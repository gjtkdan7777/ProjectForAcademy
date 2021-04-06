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
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("user/main/main");
		return mv;
	}
	
	// user login page
	@RequestMapping(value = "/loginf")
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("user/login/login");
		return mv;
	}
	
	// user find id page
	@RequestMapping(value = "/findIDf")
	public ModelAndView findID(ModelAndView mv) {
		mv.setViewName("user/login/findID");
		return mv;
	}
	
	// user find pw page
	@RequestMapping(value = "/findPWf")
	public ModelAndView findPW(ModelAndView mv) {
		mv.setViewName("user/login/findPW");
		return mv;
	}

	// user join page
	@RequestMapping(value = "/joinf")
	public ModelAndView joinf(ModelAndView mv) {
		mv.setViewName("user/join/join");
		return mv;
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
	public ModelAndView myPage(ModelAndView mv) {
		mv.setViewName("user/myPage/home");
		return mv;
	}
	
	@RequestMapping(value = "/changeNumber")
	public ModelAndView changeNumber(ModelAndView mv) {
		mv.setViewName("user/myPage/changeNumber");
		return mv;
	}
	
	@RequestMapping(value = "/changePW")
	public ModelAndView changePW(ModelAndView mv) {
		mv.setViewName("user/myPage/changePW");
		return mv;
	}
	
	@RequestMapping(value = "/ticketList")
	public ModelAndView ticketList(ModelAndView mv) {
		mv.setViewName("user/myPage/ticketList");
		return mv;
	}
	
	@RequestMapping(value = "/terminal")
	public ModelAndView terminal(ModelAndView mv) {
		mv.setViewName("user/terminal/terminal");
		return mv;
	}
	
	@RequestMapping(value = "/qnaList")
	public ModelAndView qnaList(ModelAndView mv) {
		mv.setViewName("user/qna/list");
		return mv;
	}
	
	@RequestMapping(value = "/qnaRegister")
	public ModelAndView qnaRegister(ModelAndView mv) {
		mv.setViewName("user/qna/register");
		return mv;
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
	
	
	
}
