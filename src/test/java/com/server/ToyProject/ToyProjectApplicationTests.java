package com.server.ToyProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
class ToyProjectApplicationTests {		//기본 생성 이름 따라감

	@Test		//모든 컨텍스트가 로드가 되어 있는지 한번씩 테스트하는 기본적 생성되는 것
	void contextLoads() {
	}

}
