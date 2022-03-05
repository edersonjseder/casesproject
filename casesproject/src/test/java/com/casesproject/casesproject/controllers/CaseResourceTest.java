package com.casesproject.casesproject.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.casesproject.casesproject.CasesprojectApplication;
import com.casesproject.casesproject.domain.Case;
import com.casesproject.casesproject.services.CaseService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CasesprojectApplication.class)
public class CaseResourceTest {
	@Autowired
	private MockMvc mvc;

	private Case mCase;

	@MockBean
	private CaseService caseService;

	@Before
	public void setUp() throws Exception {
		mCase = Mockito.mock(Case.class);
	}

	@Test
	void testGetContent() {
		Mockito.when(mCase.getDescription()).thenReturn("Mockito");
	}

}
