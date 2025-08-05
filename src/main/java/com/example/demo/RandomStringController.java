package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RandomStringController {
//	クラスインスタンスの自動注入
	@Autowired
	RandomStringGenerator gen;
	
	// getメソッド URLに/を指定された場合randomを返す。
	@RequestMapping("/")
	public String index() {
		return "random";
	}
	
//	POSTメソッドの作成
	@RequestMapping(value = "/generate", method = RequestMethod.POST)
//	POSTでHTMLから渡された値を引数として取得する
	public ModelAndView generate(@RequestParam("charLength") int charLength,
	@RequestParam(name = "withNumber", defaultValue = "") String withNumber, ModelAndView mv) {
//		withNumFlagが1であればtrueを返す。
		boolean withNumFlag = "1".equals(withNumber);
//		List作成 RandomStringGeneratorクラスのgenerateメソッドで作成された値を格納する
		List<String> randomStringList = gen.generate(charLength, withNumFlag);
//		randomStringListをHTMLファイルに渡す
		mv.addObject("randList", randomStringList);
//		このポストメソッドが実行された場合に表示させるHTMLファイルを指定する。
		mv.setViewName("random");
		// 結果としてmvを返す。
		return mv;
	}

}
