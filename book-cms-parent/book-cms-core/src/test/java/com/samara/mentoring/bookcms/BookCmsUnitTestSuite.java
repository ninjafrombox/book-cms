package com.samara.mentoring.bookcms;

import com.samara.mentoring.bookcms.domain.AuthorUnitTest;
import com.samara.mentoring.bookcms.domain.BookUnitTest;
import com.samara.mentoring.bookcms.service.BookServiceJmockitUnitTest;
import com.samara.mentoring.bookcms.service.BookServiceMockitoUnitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AuthorUnitTest.class, BookUnitTest.class,
        BookServiceMockitoUnitTest.class, BookServiceJmockitUnitTest.class})
public class BookCmsUnitTestSuite {
}
