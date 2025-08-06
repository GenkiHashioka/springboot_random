package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

//処理を書く場所だとSpringに伝えるアノテーション。他のクラスから自動で使えるようになる　(Model)
@Service
public class RandomStringGenerator {
//	フィールド定数
	private final static int GENERATE_NUM = 10;
	
	public List<String> generate(int charLength, boolean withNumber) {
//		ArrayListの作成
		List<String> list = new ArrayList<>();
//		10回ループを回してね。
//		[条件分岐] withNumberの条件がtrueなら数字入りのランダムな文字列をcharLengthに指定した回数listに追加。falseなら数字を含めない。
		for (int i = 0; i < GENERATE_NUM; i++) {
			if (withNumber) {
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else {
				list.add(RandomStringUtils.randomAlphabetic(charLength));
			}
		}
		return list;
	}
}
